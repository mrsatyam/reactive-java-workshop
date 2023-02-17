package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(System.out::println, System.err::println);
//
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(err -> System.out.println("Error occurred !!! " + err.getMessage()))
//                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((err, item) -> System.out.println("Error occurred !!! " + err.getMessage() + " for element " + item.toString()))
//                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .doFinally(signalType -> {
                    if (signalType == SignalType.ON_ERROR) {
                        System.out.println("Error");
                    } else {
                        System.out.println("Other");
                    }
                })
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
