package com.codenotfound.grpc.helloworld;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class HelloWorldServiceImpl
        extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

  private static final Logger LOGGER =
          LoggerFactory.getLogger(HelloWorldServiceImpl.class);

  @Override
  public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {

    LOGGER.info("服务端收到数据 {}", request);

    String message = "Hello " +request.getSex().name()+" "+ request.getFirstName() + " " + request.getLastName() + "!";

    Greeting greeting = Greeting.newBuilder().setMessage(message).build();

    LOGGER.info("服务端回复数据 {}", greeting);

    responseObserver.onNext(greeting);
    responseObserver.onCompleted();
  }
}
