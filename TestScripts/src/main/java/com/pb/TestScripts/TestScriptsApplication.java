package com.pb.TestScripts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestScriptsApplication {
	private static final Logger log = LoggerFactory.getLogger(TestScriptsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestScriptsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("Message from command line runner");
			log.info("-------------------------------");
		};
	}
}
