package com.example;

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

}
