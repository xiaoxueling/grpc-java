package com.codenotfound.grpc.test;

import com.codenotfound.grpc.test.grpc.AddRequest;
import com.codenotfound.grpc.test.grpc.AddResponse;
import com.codenotfound.grpc.test.grpc.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@GRpcService
public class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {

    private static final Logger LOGGER=LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {

        LOGGER.info("服务端收到数据 {}", request);

        AddResponse addResponse= AddResponse.newBuilder().setCount(request.getOne()+request.getTwo()).build();

        responseObserver.onNext(addResponse);
        responseObserver.onNext(addResponse);

        LOGGER.info("服务端回复数据 {}", addResponse);

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<AddRequest> sum(StreamObserver<AddResponse> responseObserver) {

        return new StreamObserver<AddRequest>() {
            @Override
            public void onNext(AddRequest addRequest) {
                LOGGER.info("服务端接收数据 {}",addRequest);
                AddResponse response = AddResponse.newBuilder().setCount(addRequest.getOne()+addRequest.getTwo()).build();
                responseObserver.onNext(response);
                LOGGER.info("服务端回复数据 {}",response);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                response = AddResponse.newBuilder().setCount(addRequest.getOne()+addRequest.getTwo()).build();
                responseObserver.onNext(response);
                LOGGER.info("2.服务端回复数据 {}",response);

            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.info("服务端接收错误 {}",throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
                LOGGER.info("服务端回复数据结束");
            }
        };
    }
}
