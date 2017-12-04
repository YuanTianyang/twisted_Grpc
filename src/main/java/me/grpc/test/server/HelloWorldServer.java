package me.grpc.test.server;

import java.io.IOException;

import me.grpc.test.helloworld.GreeterGrpc;
import me.grpc.test.helloworld.HelloReply;
import me.grpc.test.helloworld.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HelloWorldServer {

	private int port = 50051;
    private Server server;

    /**
     * ��������
     * @throws IOException
     */
    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                              .addService(new GreeterImpl())
                              .build()
                              .start();

        System.out.println("service start...");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // block һֱ���˳�����
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }


    // ʵ�� ����һ��ʵ�ַ���ӿڵ���
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            //��ȡ����
            System.out.println("�յ�����Ϣ:"+req.getName());

            //������Է��þ���ҵ������� start

            //������Է��þ���ҵ������� end

            //���췵��
            HelloReply reply = HelloReply.newBuilder().setMessage(("Hello: " + req.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
