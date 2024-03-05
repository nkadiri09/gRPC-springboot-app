package com.naren.grpcssb.service;

import com.naren.sample.grpc.GreetRequest;
import com.naren.sample.grpc.GreetResponse;
import com.naren.sample.grpc.GreetServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        String name = request.getName();
        GreetResponse response = GreetResponse.newBuilder().setGreeting("hi Welcome to " + name + "!").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
