package com.br.einstein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationTutorial {
    public ApplicationTutorial() {
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTutorial.class, args);
        System.out.println("Está executando");
    }
}
