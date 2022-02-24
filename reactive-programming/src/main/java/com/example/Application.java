package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        for (int u = 1; u <= 10; u++) {
            var user = "User " + u;
            System.out.println("Submitting task " + u);
            threadPool.submit(() -> {
                Service.getFlux()
                        .map(i -> user + " - " + i)
                        .subscribe(System.out::println);
            });
        }
    }

}
