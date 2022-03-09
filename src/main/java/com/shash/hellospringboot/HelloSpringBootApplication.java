package com.shash.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * Generates initial configurations and runs the web service.
 */
@SpringBootApplication
@EnableMongoRepositories
public class HelloSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloSpringBootApplication.class, args);
  }

}
