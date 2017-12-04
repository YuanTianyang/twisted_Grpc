package me.grpc.test.route;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *�������
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.8.0)",
    comments = "Source: rectangle.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetFeatureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<me.grpc.test.route.Point,
      me.grpc.test.route.Feature> METHOD_GET_FEATURE = getGetFeatureMethod();

  private static volatile io.grpc.MethodDescriptor<me.grpc.test.route.Point,
      me.grpc.test.route.Feature> getGetFeatureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<me.grpc.test.route.Point,
      me.grpc.test.route.Feature> getGetFeatureMethod() {
    io.grpc.MethodDescriptor<me.grpc.test.route.Point, me.grpc.test.route.Feature> getGetFeatureMethod;
    if ((getGetFeatureMethod = RouteGuideGrpc.getGetFeatureMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getGetFeatureMethod = RouteGuideGrpc.getGetFeatureMethod) == null) {
          RouteGuideGrpc.getGetFeatureMethod = getGetFeatureMethod = 
              io.grpc.MethodDescriptor.<me.grpc.test.route.Point, me.grpc.test.route.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RouteGuide", "GetFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.Feature.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("GetFeature"))
                  .build();
          }
        }
     }
     return getGetFeatureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListFeaturesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<me.grpc.test.route.Rectangle,
      me.grpc.test.route.Feature> METHOD_LIST_FEATURES = getListFeaturesMethod();

  private static volatile io.grpc.MethodDescriptor<me.grpc.test.route.Rectangle,
      me.grpc.test.route.Feature> getListFeaturesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<me.grpc.test.route.Rectangle,
      me.grpc.test.route.Feature> getListFeaturesMethod() {
    io.grpc.MethodDescriptor<me.grpc.test.route.Rectangle, me.grpc.test.route.Feature> getListFeaturesMethod;
    if ((getListFeaturesMethod = RouteGuideGrpc.getListFeaturesMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getListFeaturesMethod = RouteGuideGrpc.getListFeaturesMethod) == null) {
          RouteGuideGrpc.getListFeaturesMethod = getListFeaturesMethod = 
              io.grpc.MethodDescriptor.<me.grpc.test.route.Rectangle, me.grpc.test.route.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RouteGuide", "ListFeatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.Rectangle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.Feature.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("ListFeatures"))
                  .build();
          }
        }
     }
     return getListFeaturesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRecordRouteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<me.grpc.test.route.Point,
      me.grpc.test.route.RouteSummary> METHOD_RECORD_ROUTE = getRecordRouteMethod();

  private static volatile io.grpc.MethodDescriptor<me.grpc.test.route.Point,
      me.grpc.test.route.RouteSummary> getRecordRouteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<me.grpc.test.route.Point,
      me.grpc.test.route.RouteSummary> getRecordRouteMethod() {
    io.grpc.MethodDescriptor<me.grpc.test.route.Point, me.grpc.test.route.RouteSummary> getRecordRouteMethod;
    if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
          RouteGuideGrpc.getRecordRouteMethod = getRecordRouteMethod = 
              io.grpc.MethodDescriptor.<me.grpc.test.route.Point, me.grpc.test.route.RouteSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RouteGuide", "RecordRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.RouteSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("RecordRoute"))
                  .build();
          }
        }
     }
     return getRecordRouteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRouteChatMethod()} instead. 
  public static final io.grpc.MethodDescriptor<me.grpc.test.route.RouteNote,
      me.grpc.test.route.RouteNote> METHOD_ROUTE_CHAT = getRouteChatMethod();

  private static volatile io.grpc.MethodDescriptor<me.grpc.test.route.RouteNote,
      me.grpc.test.route.RouteNote> getRouteChatMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<me.grpc.test.route.RouteNote,
      me.grpc.test.route.RouteNote> getRouteChatMethod() {
    io.grpc.MethodDescriptor<me.grpc.test.route.RouteNote, me.grpc.test.route.RouteNote> getRouteChatMethod;
    if ((getRouteChatMethod = RouteGuideGrpc.getRouteChatMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getRouteChatMethod = RouteGuideGrpc.getRouteChatMethod) == null) {
          RouteGuideGrpc.getRouteChatMethod = getRouteChatMethod = 
              io.grpc.MethodDescriptor.<me.grpc.test.route.RouteNote, me.grpc.test.route.RouteNote>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RouteGuide", "RouteChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.RouteNote.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.grpc.test.route.RouteNote.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("RouteChat"))
                  .build();
          }
        }
     }
     return getRouteChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    return new RouteGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RouteGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RouteGuideFutureStub(channel);
  }

  /**
   * <pre>
   *�������
   * </pre>
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *�õ�ָ�����feature
     *һ�� �� RPC �� �ͻ���ʹ�ô���������󵽷��������ȴ���Ӧ���أ�����ƽ���ĺ�������һ����
     * </pre>
     */
    public void getFeature(me.grpc.test.route.Point request,
        io.grpc.stub.StreamObserver<me.grpc.test.route.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFeatureMethod(), responseObserver);
    }

    /**
     * <pre>
     *��ȡһ�������ڵĵ�
     *һ�� ����������ʽ RPC �� �ͻ��˷������󵽷��������õ�һ����ȥ��ȡ���ص���Ϣ���С� �ͻ��˶�ȡ���ص�����
     *ֱ������û���κ���Ϣ���������п��Կ�����ͨ���� ��Ӧ ����ǰ���� stream �ؼ��֣�����ָ��һ���������˵���������
     * </pre>
     */
    public void listFeatures(me.grpc.test.route.Rectangle request,
        io.grpc.stub.StreamObserver<me.grpc.test.route.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(getListFeaturesMethod(), responseObserver);
    }

    /**
     * <pre>
     *��¼�õ�
     *һ�� �ͻ�����ʽ RPC �� �ͻ���д��һ����Ϣ���в����䷢�͵���������ͬ��Ҳ��ʹ������һ���ͻ������д����Ϣ��
     *���ȴ���������ɶ�ȡ����������Ӧ��ͨ���� ���� ����ǰָ�� stream �ؼ�����ָ��һ���ͻ��˵���������
     * </pre>
     */
    public io.grpc.stub.StreamObserver<me.grpc.test.route.Point> recordRoute(
        io.grpc.stub.StreamObserver<me.grpc.test.route.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecordRouteMethod(), responseObserver);
    }

    /**
     * <pre>
     *·�ɽ���
     *һ�� ˫����ʽ RPC ��˫��ʹ�ö�д��ȥ����һ����Ϣ���С�������������������˿ͻ��˺ͷ�����
     *����������ϲ����˳���д�����磬 ������������д����Ӧǰ�ȴ��������еĿͻ�����Ϣ�����߿��Խ��� �Ķ�ȡ��д����Ϣ��
     *����������д����ϡ�ÿ�����е���Ϣ˳��Ԥ���������ͨ�����������Ӧǰ�� stream �ؼ���ȥ�ƶ����������͡�
     * </pre>
     */
    public io.grpc.stub.StreamObserver<me.grpc.test.route.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<me.grpc.test.route.RouteNote> responseObserver) {
      return asyncUnimplementedStreamingCall(getRouteChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFeatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                me.grpc.test.route.Point,
                me.grpc.test.route.Feature>(
                  this, METHODID_GET_FEATURE)))
          .addMethod(
            getListFeaturesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                me.grpc.test.route.Rectangle,
                me.grpc.test.route.Feature>(
                  this, METHODID_LIST_FEATURES)))
          .addMethod(
            getRecordRouteMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                me.grpc.test.route.Point,
                me.grpc.test.route.RouteSummary>(
                  this, METHODID_RECORD_ROUTE)))
          .addMethod(
            getRouteChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                me.grpc.test.route.RouteNote,
                me.grpc.test.route.RouteNote>(
                  this, METHODID_ROUTE_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   *�������
   * </pre>
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractStub<RouteGuideStub> {
    private RouteGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     * <pre>
     *�õ�ָ�����feature
     *һ�� �� RPC �� �ͻ���ʹ�ô���������󵽷��������ȴ���Ӧ���أ�����ƽ���ĺ�������һ����
     * </pre>
     */
    public void getFeature(me.grpc.test.route.Point request,
        io.grpc.stub.StreamObserver<me.grpc.test.route.Feature> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *��ȡһ�������ڵĵ�
     *һ�� ����������ʽ RPC �� �ͻ��˷������󵽷��������õ�һ����ȥ��ȡ���ص���Ϣ���С� �ͻ��˶�ȡ���ص�����
     *ֱ������û���κ���Ϣ���������п��Կ�����ͨ���� ��Ӧ ����ǰ���� stream �ؼ��֣�����ָ��һ���������˵���������
     * </pre>
     */
    public void listFeatures(me.grpc.test.route.Rectangle request,
        io.grpc.stub.StreamObserver<me.grpc.test.route.Feature> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *��¼�õ�
     *һ�� �ͻ�����ʽ RPC �� �ͻ���д��һ����Ϣ���в����䷢�͵���������ͬ��Ҳ��ʹ������һ���ͻ������д����Ϣ��
     *���ȴ���������ɶ�ȡ����������Ӧ��ͨ���� ���� ����ǰָ�� stream �ؼ�����ָ��һ���ͻ��˵���������
     * </pre>
     */
    public io.grpc.stub.StreamObserver<me.grpc.test.route.Point> recordRoute(
        io.grpc.stub.StreamObserver<me.grpc.test.route.RouteSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRecordRouteMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *·�ɽ���
     *һ�� ˫����ʽ RPC ��˫��ʹ�ö�д��ȥ����һ����Ϣ���С�������������������˿ͻ��˺ͷ�����
     *����������ϲ����˳���д�����磬 ������������д����Ӧǰ�ȴ��������еĿͻ�����Ϣ�����߿��Խ��� �Ķ�ȡ��д����Ϣ��
     *����������д����ϡ�ÿ�����е���Ϣ˳��Ԥ���������ͨ�����������Ӧǰ�� stream �ؼ���ȥ�ƶ����������͡�
     * </pre>
     */
    public io.grpc.stub.StreamObserver<me.grpc.test.route.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<me.grpc.test.route.RouteNote> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRouteChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *�������
   * </pre>
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *�õ�ָ�����feature
     *һ�� �� RPC �� �ͻ���ʹ�ô���������󵽷��������ȴ���Ӧ���أ�����ƽ���ĺ�������һ����
     * </pre>
     */
    public me.grpc.test.route.Feature getFeature(me.grpc.test.route.Point request) {
      return blockingUnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *��ȡһ�������ڵĵ�
     *һ�� ����������ʽ RPC �� �ͻ��˷������󵽷��������õ�һ����ȥ��ȡ���ص���Ϣ���С� �ͻ��˶�ȡ���ص�����
     *ֱ������û���κ���Ϣ���������п��Կ�����ͨ���� ��Ӧ ����ǰ���� stream �ؼ��֣�����ָ��һ���������˵���������
     * </pre>
     */
    public java.util.Iterator<me.grpc.test.route.Feature> listFeatures(
        me.grpc.test.route.Rectangle request) {
      return blockingServerStreamingCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *�������
   * </pre>
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *�õ�ָ�����feature
     *һ�� �� RPC �� �ͻ���ʹ�ô���������󵽷��������ȴ���Ӧ���أ�����ƽ���ĺ�������һ����
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<me.grpc.test.route.Feature> getFeature(
        me.grpc.test.route.Point request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FEATURE = 0;
  private static final int METHODID_LIST_FEATURES = 1;
  private static final int METHODID_RECORD_ROUTE = 2;
  private static final int METHODID_ROUTE_CHAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature((me.grpc.test.route.Point) request,
              (io.grpc.stub.StreamObserver<me.grpc.test.route.Feature>) responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures((me.grpc.test.route.Rectangle) request,
              (io.grpc.stub.StreamObserver<me.grpc.test.route.Feature>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECORD_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordRoute(
              (io.grpc.stub.StreamObserver<me.grpc.test.route.RouteSummary>) responseObserver);
        case METHODID_ROUTE_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.routeChat(
              (io.grpc.stub.StreamObserver<me.grpc.test.route.RouteNote>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RouteGuideBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return me.grpc.test.route.RouteProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RouteGuide");
    }
  }

  private static final class RouteGuideFileDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier {
    RouteGuideFileDescriptorSupplier() {}
  }

  private static final class RouteGuideMethodDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RouteGuideMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideFileDescriptorSupplier())
              .addMethod(getGetFeatureMethod())
              .addMethod(getListFeaturesMethod())
              .addMethod(getRecordRouteMethod())
              .addMethod(getRouteChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
