package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux()
//                .subscribe(
//                        System.out::println, //consumer
//                        err -> System.out.println(err.getMessage()), //error consumer
//                        () -> System.out.println("Completed")); // completion runnable
//
//        ReactiveSources.userMono()
//                .subscribe(
//                        System.out::println, //consumer
//                        err -> System.out.println(err.getMessage()), //error consumer
//                        () -> System.out.println("Completed")); // completion runnable

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.userFlux()
                .subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(2);//handling backpressure
    }

    @Override
    public void hookOnNext(T value) {
        System.out.println(value + " received");
        request(1);
    }
}