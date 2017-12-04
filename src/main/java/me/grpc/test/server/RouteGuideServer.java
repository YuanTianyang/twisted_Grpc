package me.grpc.test.server;

import java.io.IOException;
import java.util.List;

import me.grpc.test.route.Feature;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class RouteGuideServer {

	private final int port;// ����˶˿�
	private final Server server;// ������

	public RouteGuideServer(int port) throws IOException {
		this.port = port;
		// ��ȡ��ʼ������
		List<Feature> features = RouteGuideUtil.parseFeatures(RouteGuideUtil
				.getDefaultFeaturesFile());
		// ��ʼ��Server����
		server = ServerBuilder.forPort(port)
		// ���ָ������
				.addService(new RouteGuideService(features)).build();
	}

	/**
	 * ��������
	 */
	public void start() throws IOException {
		server.start();
		System.out.println("Server started, listening on " + port);
		// �����˳�ʱ�ر���Դ
		Runtime.getRuntime()
				.addShutdownHook(
						new Thread(
								() -> {
									System.err
											.println("*** shutting down gRPC server since JVM is shutting down");
									RouteGuideServer.this.stop();
									System.err.println("*** server shut down");
								}));
	}

	/**
	 * �رշ���
	 */
	public void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	/**
	 * ʹ��serverһֱ��������״̬
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		RouteGuideServer server = new RouteGuideServer(50051);
		server.start();
		server.blockUntilShutdown();
	}

}
