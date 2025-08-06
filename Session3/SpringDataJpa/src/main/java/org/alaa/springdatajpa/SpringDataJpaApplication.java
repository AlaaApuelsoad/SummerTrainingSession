package org.alaa.springdatajpa;

import org.alaa.springdatajpa.model.Customer;
import org.alaa.springdatajpa.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        System.out.println("Spring Data JPA Application");
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

    }

}
