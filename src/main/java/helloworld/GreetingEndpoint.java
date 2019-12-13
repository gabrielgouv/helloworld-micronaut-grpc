package helloworld;

import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class GreetingEndpoint extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        final String message = "Hello, " + request.getName();
        HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }



}
