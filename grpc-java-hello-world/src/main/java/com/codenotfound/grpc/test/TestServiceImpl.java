package com.codenotfound.grpc.test;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {

        AddResponse addResponse= AddResponse.newBuilder().setCount(request.getOne()+request.getTwo()).build();

        responseObserver.onNext(addResponse);
        responseObserver.onCompleted();

    }
}
