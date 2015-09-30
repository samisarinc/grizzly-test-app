package com.samsar.grizzlyjerseygradle.server;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.glassfish.grizzly.http.server.HttpServer;

/**
 * Hello world!
 */
public class Main {

	private static final URI BASE_URI = URI.create("http://localhost:9999/");

	public static void main(String[] args) {
		try {
			System.out.println("Grizzly with Jersey and Jackson");

			final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp(), false);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					server.shutdownNow();
				}
			}));
			server.start();

			System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

			Thread.currentThread().join();
		} catch (IOException | InterruptedException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static ResourceConfig createApp() {
		return new ResourceConfig().packages("com.samsar.grizzlyjerseygradle.rest").register(JacksonJsonProvider.class);
	}
}