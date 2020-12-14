package com.codenotfound;

import com.codenotfound.webService.client.ObjectFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.xml.ws.Endpoint;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringGrpcApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringGrpcApplication.class, args);
  }
}
