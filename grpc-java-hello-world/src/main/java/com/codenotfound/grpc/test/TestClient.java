package com.codenotfound.grpc.test;

import com.codenotfound.grpc.test.grpc.*;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Iterator;

@Component
public class TestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestClient.class);
    private TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub;
    private TestServiceGrpc.TestServiceStub testServiceAsyncStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = NettyChannelBuilder
                .forAddress("localhost", 6600)
                .usePlaintext()
                .build();

        testServiceBlockingStub =TestServiceGrpc.newBlockingStub(managedChannel);
        testServiceAsyncStub =TestServiceGrpc.newStub(managedChannel);
    }
    public int add(int one,int two){

        AddRequest addRequest=AddRequest.newBuilder()
                .setOne(one)
                .setTwo(two)
                .addOther(Other.newBuilder().setOther(1).build())
                .addOther(Other.newBuilder().setOther(2).build())
                .putMaps(1, MapValue.newBuilder().setType(1).setMethod(2).build())
                .putMaps(2, MapValue.newBuilder().setType(2).setMethod(3).build())
                .setMapValue(MapValue.newBuilder().setType(3).setMethod(4).build())
                .setResult(false)
                .build();

        LOGGER.info("客户端发送数据 {}", addRequest);

        Iterator<AddResponse> iterator= testServiceBlockingStub.add(addRequest);

        int count=0;
        while (iterator.hasNext()){
            AddResponse addResponse=iterator.next();
            LOGGER.info("客户端收到数据 {}", addResponse);
            count=addResponse.getCount();
        }

        return count;
    }

    public void sum(){

        final SettableFuture<Void> finishFuture = SettableFuture.create();

        StreamObserver<AddRequest> requestObserver= testServiceAsyncStub.sum(new StreamObserver<AddResponse>() {
            @Override
            public void onNext(AddResponse addResponse) {
                LOGGER.info("客户端收到数据 {}",addResponse.getCount());
            }

            @Override
            public void onError(Throwable throwable) {
                finishFuture.setException(throwable);
                LOGGER.debug("客户端接收数据错误 {}！",throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                finishFuture.set(null);
                LOGGER.info("客户端接收数据结束！");
            }
        });

        try {
            AddRequest addRequest=AddRequest.newBuilder().setOne(1).setTwo(2).addOther(Other.newBuilder().setOther(1).build()).build();

            requestObserver.onNext(addRequest);
            LOGGER.info("客户端发送数据 {}",addRequest);

            addRequest=AddRequest.newBuilder().setOne(2).setTwo(4).build();
            requestObserver.onNext(addRequest);

            LOGGER.info("客户端发送数据 {}",addRequest);

            int count=0;
            while (count++<10){

                addRequest=AddRequest.newBuilder().setOne(count+10).setTwo(count+12).build();
                requestObserver.onNext(addRequest);
                LOGGER.info("客户端发送数据 {}",addRequest);

                Thread.sleep(5000);
            }

            requestObserver.onCompleted();
            LOGGER.info("客户端发送数据结束");

            //阻塞，等待通知
            finishFuture.get();

            if(finishFuture.isDone()){
                LOGGER.info("数据交互结束！");
            }

        } catch (Exception e) {
            requestObserver.onError(e);
            LOGGER.error("客户端发送数据异常 {}",e.getMessage());
        }
    }
}
