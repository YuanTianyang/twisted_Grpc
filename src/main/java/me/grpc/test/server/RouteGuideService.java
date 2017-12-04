package me.grpc.test.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import io.grpc.stub.StreamObserver;
import me.grpc.test.route.Feature;
import me.grpc.test.route.Point;
import me.grpc.test.route.RouteGuideGrpc;
import me.grpc.test.route.Rectangle;
import me.grpc.test.route.RouteNote;
import me.grpc.test.route.RouteSummary;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class RouteGuideService extends RouteGuideGrpc.RouteGuideImplBase {

	// ����������λ��
	private final Collection<Feature> features;

	private final ConcurrentMap<Point, List<RouteNote>> routeNotes = new ConcurrentHashMap<Point, List<RouteNote>>();

	// ��ʼ�����е�
	RouteGuideService(Collection<Feature> features) {
		this.features = features;
	}

	@Override
	public void getFeature(Point request,
			StreamObserver<Feature> responseObserver) {
		System.out.println("getFeature�õ����������: " + request.toString());
		// responseObserver.onError(); �����������
		responseObserver.onNext(checkFeature(request));// ��װ������Ϣ
		responseObserver.onCompleted();// ���һ������
	}

	// �ҵ����˵�feature
	private Feature checkFeature(Point location) {
		for (Feature feature : features) {
			if (feature.getLocation().getLatitude() == location.getLatitude()
					&& feature.getLocation().getLongitude() == location
							.getLongitude()) {
				return feature;
			}
		}
		// No feature was found, return an unnamed feature.
		return Feature.newBuilder().setName("").setLocation(location).build();
	}

	@Override
	public void listFeatures(Rectangle request,
			StreamObserver<Feature> responseObserver) {
		System.out.println("listFeatures�õ����������: " + request.toString());
		int left = min(request.getLo().getLongitude(), request.getHi()
				.getLongitude());
		int right = max(request.getLo().getLongitude(), request.getHi()
				.getLongitude());
		int top = max(request.getLo().getLatitude(), request.getHi()
				.getLatitude());
		int bottom = min(request.getLo().getLatitude(), request.getHi()
				.getLatitude());

		for (Feature feature : features) {
			// ��������������
			if (!RouteGuideUtil.exists(feature)) {
				continue;
			}

			int lat = feature.getLocation().getLatitude();
			int lon = feature.getLocation().getLongitude();
			if (lon >= left && lon <= right && lat >= bottom && lat <= top) {
				// �ҵ����ϵľ�д��
				responseObserver.onNext(feature);
			}
		}
		// ����ʶ���
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<Point> recordRoute(
			StreamObserver<RouteSummary> responseObserver) {
		return new StreamObserver<Point>() {
			int pointCount;
			int featureCount;
			int distance;
			Point previous;
			long startTime = System.nanoTime();

			// �ͻ���ÿд��һ��Point,����˾ͻ���ø÷���
			@Override
			public void onNext(Point point) {
				System.out.println("recordRoute�õ����������: " + point.toString());
				pointCount++;
				if (RouteGuideUtil.exists(checkFeature(point))) {
					featureCount++;
				}
				if (previous != null) {
					distance += calcDistance(previous, point);
				}
				previous = point;
			}

			@Override
			public void onError(Throwable throwable) {
				throwable.printStackTrace();
				System.err.println("Encountered error in recordRoute");
			}

			// �ͻ���д�����ʱ����
			@Override
			public void onCompleted() {
				long seconds = NANOSECONDS.toSeconds(System.nanoTime()
						- startTime);
				responseObserver.onNext(RouteSummary.newBuilder()
						.setPointCount(pointCount).setFetureCount(featureCount)
						.setDistance(distance).setElapsedTime((int) seconds)
						.build());
				responseObserver.onCompleted();
			}
		};
	}

	@Override
	public StreamObserver<RouteNote> routeChat(
			StreamObserver<RouteNote> responseObserver) {
		return new StreamObserver<RouteNote>() {
			@Override
			public void onNext(RouteNote note) {
				System.out.println("routeChat�õ�����:" + note);
				List<RouteNote> notes = getOrCreateNotes(note.getLocation());

				for (RouteNote prevNote : notes.toArray(new RouteNote[0])) {
					responseObserver.onNext(prevNote);
				}
				notes.add(note);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				System.err.println("Encountered error in routeChat");
			}

			@Override
			public void onCompleted() {
				System.out.println("finsh");
				responseObserver.onCompleted();
			}
		};
	}

	// ������¼��
	private List<RouteNote> getOrCreateNotes(Point location) {
		List<RouteNote> notes = Collections
				.synchronizedList(new ArrayList<RouteNote>());
		List<RouteNote> prevNotes = routeNotes.putIfAbsent(location, notes);
		return prevNotes != null ? prevNotes : notes;
	}

	// �����������
	private static int calcDistance(Point start, Point end) {
		double lat1 = RouteGuideUtil.getLatitude(start);
		double lat2 = RouteGuideUtil.getLatitude(end);
		double lon1 = RouteGuideUtil.getLongitude(start);
		double lon2 = RouteGuideUtil.getLongitude(end);
		int r = 6371000; // meters
		double phi1 = toRadians(lat1);
		double phi2 = toRadians(lat2);
		double deltaPhi = toRadians(lat2 - lat1);
		double deltaLambda = toRadians(lon2 - lon1);

		double a = sin(deltaPhi / 2) * sin(deltaPhi / 2) + cos(phi1)
				* cos(phi2) * sin(deltaLambda / 2) * sin(deltaLambda / 2);
		double c = 2 * atan2(sqrt(a), sqrt(1 - a));

		return (int) (r * c);
	}

}
