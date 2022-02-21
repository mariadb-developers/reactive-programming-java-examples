package com.example;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.IntStream;

public class Service {

    public static IntStream getNumberStream() {
        return IntStream.generate(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return (int) (Math.random() * 10);
        });
    }

    public static Flux<Integer> getNumberFlux() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(l -> (int) (Math.random() * 10));
    }

}
