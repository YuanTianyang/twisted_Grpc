package me.grpc.test.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import me.grpc.test.route.Feature;
import me.grpc.test.route.Point;
import me.grpc.test.route.Rectangle;
import me.grpc.test.route.RouteGuideGrpc;
import me.grpc.test.route.RouteNote;
import me.grpc.test.route.RouteSummary;
import me.grpc.test.server.RouteGuideUtil;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class RouteGuideClient {

	private final ManagedChannel channel;// grpc�ŵ�,��Ҫָ���˿ں͵�ַ
	private final RouteGuideGrpc.RouteGuideBlockingStub blockingStub;// ����/ͬ�����
	private final RouteGuideGrpc.RouteGuideStub asyncStub;// ������,�첽���

	public RouteGuideClient(String host, int port) {
		// �����ŵ�
		channel = ManagedChannelBuilder.forAddress(host, port)
				.usePlaintext(true).build();
		// �������
		blockingStub = RouteGuideGrpc.newBlockingStub(channel);
		asyncStub = RouteGuideGrpc.newStub(channel);
	}

	/**
	 * �رշ���
	 */
	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	/**
	 * �������е�����һЩ������ִ��
	 */
	public static void main(String[] args) throws InterruptedException {
		List<Feature> features;
		try {
			features = RouteGuideUtil.parseFeatures(RouteGuideUtil
					.getDefaultFeaturesFile());
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		}
		RouteGuideClient client = new RouteGuideClient("localhost", 50051);
		try {
			 client.getFeature(409146138, -746188906);//�ɹ�����
			 client.getFeature(0, 0);//ʧ�ܰ���
			 client.listFeatures(400000000, -750000000, 420000000,
			 -730000000);
			 client.recordRoute(features, 10);
			 System.out.println("RouteGuideClient.main()--------����routeChat----------");
			CountDownLatch finishLatch = client.routeChat();

			if (!finishLatch.await(1, TimeUnit.MINUTES)) {
				System.out.println("routeChat can not finish within 1 minutes");
			}
		} finally {
			client.shutdown();
		}
	}

	// 1.��grpc
	public void getFeature(int lat, int lon) {
		System.out.println("start getFeature");
		Point request = Point.newBuilder().setLatitude(lat).setLongitude(lon)
				.build();
		Feature feature;
		try {
			// ͬ����������
			feature = blockingStub.getFeature(request);
			System.out.println("getFeature����˷��� :" + feature);
		} catch (StatusRuntimeException e) {
			System.out.println("RPC failed " + e.getStatus());
		}
	}

	// 2.�������ʽRPC
	public void listFeatures(int lowLat, int lowLon, int hiLat, int hiLon) {
		System.out.println("start listFeatures");
		Rectangle request = Rectangle
				.newBuilder()
				.setLo(Point.newBuilder().setLatitude(lowLat)
						.setLongitude(lowLon).build())
				.setHi(Point.newBuilder().setLatitude(hiLat)
						.setLongitude(hiLon).build()).build();
		Iterator<Feature> features;
		try {
			features = blockingStub.listFeatures(request);
			for (int i = 1; features.hasNext(); i++) {
				Feature feature = features.next();
				System.out.println("listFeatures����˷��� :" + feature);
			}
		} catch (Exception e) {
			System.out.println("RPC failed " + e.getMessage());
		}
	}

	// �ͻ�����ʽRPC
	public void recordRoute(List<Feature> features, int numPoints)
			throws InterruptedException {
		System.out.println("start recordRoute");
		final CountDownLatch finishLatch = new CountDownLatch(1);
		// ��һ��Ӧ���߽��ܷ�������
		StreamObserver<RouteSummary> responseObserver = new StreamObserver<RouteSummary>() {
			@Override
			public void onNext(RouteSummary summary) {
				System.out.println("recordRoute����˷��� :" + summary);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("RecordRoute Failed");
				finishLatch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("RecordRoute finish");
				finishLatch.countDown();
			}
		};
		// �ͻ���д�����
		StreamObserver<Point> requestObserver = asyncStub
				.recordRoute(responseObserver);
		Random random = new Random();
		try {
			for (int i = 0; i < numPoints; ++i) {
				int index = random.nextInt(features.size());
				Point point = features.get(index).getLocation();
				System.out.println("�ͻ���д��point:" + point);
				requestObserver.onNext(point);

				Thread.sleep(random.nextInt(1000) + 500);
				if (finishLatch.getCount() == 0) {
					return;
				}
			}
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		}
		// ��ʶ�Ѿ�д��
		requestObserver.onCompleted();
		// Receiving happens asynchronously
		if (!finishLatch.await(1, TimeUnit.MINUTES)) {
			System.out.println("recordRoute can not finish within 1 minutes");
		}
	}

	// ˫����ʽRPC
	public CountDownLatch routeChat() {
		System.out.println("start routeChat");
		final CountDownLatch finishLatch = new CountDownLatch(1);
		StreamObserver<RouteNote> requestObserver = asyncStub
				.routeChat(new StreamObserver<RouteNote>() {
					@Override
					public void onNext(RouteNote note) {
						System.out.println("�����д��: " + note);
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
						System.out.println("RouteChat Failed:");
						finishLatch.countDown();
					}

					@Override
					public void onCompleted() {
						System.out.println("Finished RouteChat");
						finishLatch.countDown();
					}
				});

		try {
			RouteNote[] requests = { newNote("First message", 0, 0),
					newNote("Second message", 0, 1),
					newNote("Third message", 1, 0),
					newNote("Fourth message", 1, 1) };

			for (RouteNote request : requests) {
				System.out.println("�ͻ���д��:" + request);
				requestObserver.onNext(request);
			}
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		}
		// ��ʶд��
		requestObserver.onCompleted();
		return finishLatch;
	}

	private RouteNote newNote(String message, int lat, int lon) {
		return RouteNote
				.newBuilder()
				.setMessage(message)
				.setLocation(
						Point.newBuilder().setLatitude(lat).setLongitude(lon)
								.build()).build();
	}

}
