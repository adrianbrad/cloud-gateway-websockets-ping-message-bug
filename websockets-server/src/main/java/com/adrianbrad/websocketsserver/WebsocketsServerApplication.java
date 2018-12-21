package com.adrianbrad.websocketsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ConfigurationProperties
@EnableScheduling
public class WebsocketsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketsServerApplication.class, args);
	}

}

