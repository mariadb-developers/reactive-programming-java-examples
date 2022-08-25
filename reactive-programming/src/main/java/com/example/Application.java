package com.example;

import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		for (int u = 1; u <= 10; u++) {
			var user = "User " + u;
			Service.getFlux()
					.map(i -> user + " - " + i)
					.subscribe(System.out::println);
		}

		TimeUnit.SECONDS.sleep(5);
	}

}
