package com.example;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.IntStream;

public class Service {

    public static IntStream getStream() {
        return IntStream.generate(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            return (int) (Math.random() * 10);
        });
    }

    public static Flux<Integer> getFlux() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(l -> (int) (Math.random() * 10));
    }

}
