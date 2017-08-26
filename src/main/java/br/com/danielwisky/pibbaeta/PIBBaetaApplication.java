package br.com.danielwisky.pibbaeta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableMongoAuditing
@SpringBootApplication
public class PIBBaetaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PIBBaetaApplication.class, args);
  }
}
