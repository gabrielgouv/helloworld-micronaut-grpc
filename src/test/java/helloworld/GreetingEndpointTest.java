package helloworld;


import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class GreetingEndpointTest {

    @Inject
    GreeterGrpc.GreeterBlockingStub blockingStub;

    @Test
    void testHelloWorld() {
        final HelloRequest request = HelloRequest
                .newBuilder()
                .setName("Joao")
                .build();

        Assertions.assertEquals(
                "Hello, Joao",
                blockingStub.sayHello(request)
                        .getMessage());
    }

}
