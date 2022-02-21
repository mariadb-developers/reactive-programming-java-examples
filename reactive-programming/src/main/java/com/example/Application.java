package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        for (int u = 1; u <= 100; u++) {
            var user = "User " + u;
            threadPool.submit(() -> {
                Service.getNumberFlux()
                        .map(i -> user + ": " + i)
                        .subscribe(System.out::println);
            });
        }

    }
}
