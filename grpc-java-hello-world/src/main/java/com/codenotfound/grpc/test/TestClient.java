package com.codenotfound.grpc.test;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestClient {

    private TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 6600).usePlaintext().build();

        testServiceBlockingStub =TestServiceGrpc.newBlockingStub(managedChannel);
    }
    public int add(int one,int two){

        AddRequest addRequest=AddRequest.newBuilder().setOne(one).setTwo(two).setOther(1, Other.newBuilder().setOther(1).build()).build();

        AddResponse addResponse= testServiceBlockingStub.add(addRequest);

        return addResponse.getCount();
    }


}
