package com.example.user.users.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.41.3)",
    comments = "Source: order_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.user.users.grpc.generated.OrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.user.users.grpc.generated.GetOrderRequest,
      com.example.user.users.grpc.generated.OrderResponse> getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrder",
      requestType = com.example.user.users.grpc.generated.GetOrderRequest.class,
      responseType = com.example.user.users.grpc.generated.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.user.users.grpc.generated.GetOrderRequest,
      com.example.user.users.grpc.generated.OrderResponse> getGetOrderMethod() {
    io.grpc.MethodDescriptor<com.example.user.users.grpc.generated.GetOrderRequest, com.example.user.users.grpc.generated.OrderResponse> getGetOrderMethod;
    if ((getGetOrderMethod = OrderServiceGrpc.getGetOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetOrderMethod = OrderServiceGrpc.getGetOrderMethod) == null) {
          OrderServiceGrpc.getGetOrderMethod = getGetOrderMethod =
              io.grpc.MethodDescriptor.<com.example.user.users.grpc.generated.GetOrderRequest, com.example.user.users.grpc.generated.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.user.users.grpc.generated.GetOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.user.users.grpc.generated.OrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("GetOrder"))
              .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.user.users.grpc.generated.CreateOrderRequest,
      com.example.user.users.grpc.generated.OrderResponse> getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrder",
      requestType = com.example.user.users.grpc.generated.CreateOrderRequest.class,
      responseType = com.example.user.users.grpc.generated.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.user.users.grpc.generated.CreateOrderRequest,
      com.example.user.users.grpc.generated.OrderResponse> getCreateOrderMethod() {
    io.grpc.MethodDescriptor<com.example.user.users.grpc.generated.CreateOrderRequest, com.example.user.users.grpc.generated.OrderResponse> getCreateOrderMethod;
    if ((getCreateOrderMethod = OrderServiceGrpc.getCreateOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCreateOrderMethod = OrderServiceGrpc.getCreateOrderMethod) == null) {
          OrderServiceGrpc.getCreateOrderMethod = getCreateOrderMethod =
              io.grpc.MethodDescriptor.<com.example.user.users.grpc.generated.CreateOrderRequest, com.example.user.users.grpc.generated.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.user.users.grpc.generated.CreateOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.user.users.grpc.generated.OrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("CreateOrder"))
              .build();
        }
      }
    }
    return getCreateOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub>() {
        @java.lang.Override
        public OrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceStub(channel, callOptions);
        }
      };
    return OrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub>() {
        @java.lang.Override
        public OrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceBlockingStub(channel, callOptions);
        }
      };
    return OrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub>() {
        @java.lang.Override
        public OrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceFutureStub(channel, callOptions);
        }
      };
    return OrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getOrder(com.example.user.users.grpc.generated.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.example.user.users.grpc.generated.OrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }

    /**
     */
    public void createOrder(com.example.user.users.grpc.generated.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.example.user.users.grpc.generated.OrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.user.users.grpc.generated.GetOrderRequest,
                com.example.user.users.grpc.generated.OrderResponse>(
                  this, METHODID_GET_ORDER)))
          .addMethod(
            getCreateOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.user.users.grpc.generated.CreateOrderRequest,
                com.example.user.users.grpc.generated.OrderResponse>(
                  this, METHODID_CREATE_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class OrderServiceStub extends io.grpc.stub.AbstractAsyncStub<OrderServiceStub> {
    private OrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void getOrder(com.example.user.users.grpc.generated.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.example.user.users.grpc.generated.OrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createOrder(com.example.user.users.grpc.generated.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.example.user.users.grpc.generated.OrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.user.users.grpc.generated.OrderResponse getOrder(com.example.user.users.grpc.generated.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.user.users.grpc.generated.OrderResponse createOrder(com.example.user.users.grpc.generated.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.user.users.grpc.generated.OrderResponse> getOrder(
        com.example.user.users.grpc.generated.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.user.users.grpc.generated.OrderResponse> createOrder(
        com.example.user.users.grpc.generated.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ORDER = 0;
  private static final int METHODID_CREATE_ORDER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((com.example.user.users.grpc.generated.GetOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.example.user.users.grpc.generated.OrderResponse>) responseObserver);
          break;
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder((com.example.user.users.grpc.generated.CreateOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.example.user.users.grpc.generated.OrderResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.user.users.grpc.generated.OrderServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getGetOrderMethod())
              .addMethod(getCreateOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
