package com.example;

public class Application {

	public static void main(String[] args) {
		for (int u = 1; u <= 10; u++) {
			var user = "User " + u;
			Service.getStream()
					.mapToObj(i -> user + " - " + i)
					.forEach(System.out::println);
		}
	}

}
