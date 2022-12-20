package com.example.demojvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:configuration.xml")
public class DemoJValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJValidationApplication.class, args);
    }

}
