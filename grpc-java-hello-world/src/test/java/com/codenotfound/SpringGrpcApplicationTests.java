package com.codenotfound;

import com.codenotfound.grpc.helloworld.HelloWorldClient;
import com.codenotfound.grpc.helloworld.grpc.Person;
import com.codenotfound.grpc.test.TestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringGrpcApplicationTests {

  @Autowired
  private HelloWorldClient helloWorldClient;
  @Autowired
  private TestClient testClient;

  @Test
  public void test() {
    assertThat(helloWorldClient.sayHello("John", "Doe",Person.Sex.girl)).isEqualTo("Hello girl John Doe!");

    assertThat(testClient.add(1,2)==1+2);

    testClient.sum();
  }
}
