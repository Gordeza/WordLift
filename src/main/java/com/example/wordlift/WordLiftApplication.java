package com.example.wordlift;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Word Lift Task Doc",
        version = "1.0.0"
))
public class WordLiftApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordLiftApplication.class, args);
    }

}
