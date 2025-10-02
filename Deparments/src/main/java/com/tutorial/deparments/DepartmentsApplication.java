package com.tutorial.deparments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.tutorial.deparments.Model")
public class DepartmentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentsApplication.class, args);
    }

}
