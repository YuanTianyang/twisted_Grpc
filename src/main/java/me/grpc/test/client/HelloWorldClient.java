package me.grpc.test.client;

import java.util.concurrent.TimeUnit;

import me.grpc.test.helloworld.GreeterGrpc;
import me.grpc.test.helloworld.HelloReply;
import me.grpc.test.helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class HelloWorldClient {
	
	private final ManagedChannel channel; //һ��gRPC�ŵ�
    private final GreeterGrpc.GreeterBlockingStub blockingStub;//����/ͬ�� ���

   //��ʼ���ŵ��ʹ��
    public HelloWorldClient(String host,int port){
        this(ManagedChannelBuilder.forAddress(host, port)
                                  // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                                  // needing certificates.
                                  .usePlaintext(true));
    }

    /** Construct client for accessing RouteGuide server using the existing channel. */
    private HelloWorldClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    //�ͻ��˷���
    public  void greet(String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC����ʧ��:"+e.getMessage());
            return;
        }
        System.out.println("������������Ϣ:"+response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorldClient client = new HelloWorldClient("127.0.0.1",50051);
        try {
            for(int i=0;i<5;i++){
                client.greet("world:"+i);
            }
        }finally {
            client.shutdown();
        }
    }
}
