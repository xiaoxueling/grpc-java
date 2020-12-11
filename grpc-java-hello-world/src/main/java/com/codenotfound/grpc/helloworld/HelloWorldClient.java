package com.codenotfound.grpc.helloworld;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ConfigurationProperties("grpc")
@Component
@Data
public class HelloWorldClient {

  private int port;

  private static final Logger LOGGER =
          LoggerFactory.getLogger(HelloWorldClient.class);

  private com.codenotfound.grpc.helloworld.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub;


  @PostConstruct
  private void init() {
    ManagedChannel managedChannel = ManagedChannelBuilder
            .forAddress("localhost", port).usePlaintext().build();

    helloWorldServiceBlockingStub =
            com.codenotfound.grpc.helloworld.HelloWorldServiceGrpc.newBlockingStub(managedChannel);
  }

  public String sayHello(String firstName, String lastName, Person.Sex sex) {
    Person person = Person.newBuilder().setFirstName(firstName)
            .setLastName(lastName).setSex(sex).build();
    LOGGER.info("客户端发送数据 {}", person);

    Greeting greeting =
            helloWorldServiceBlockingStub.sayHello(person);
    LOGGER.info("客户端收到数据 {}", greeting);

    return greeting.getMessage();
  }
}
