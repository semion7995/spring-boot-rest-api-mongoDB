package com.javatodev.api;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
public class SpringBootRestApiMongodbApplication {
	public static void main(String[] args) {
		connectToMongoDB();
		SpringApplication.run(SpringBootRestApiMongodbApplication.class, args);
	}

	public static void connectToMongoDB(){
		System.setProperty("jdk.tls.trustNameService", "true");
		System.setProperty ("javax.net.ssl.keyStore", "path to java security folder\\mongodb.pkcs12");
		System.setProperty ("javax.net.ssl.keyStorePassword","changeit");
		ConnectionString connectionString = new ConnectionString("mongodb+srv://semen:admin@cluster0.ueo8n.mongodb.net/java-to-dev-api?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		MongoClient mongoClient = MongoClients.create(settings);
		MongoDatabase database = mongoClient.getDatabase("java-to-dev-api");
		System.out.println(database);
	}
}
