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

        Customer customer = (Customer) context.getBean("customer");
//        customer.setId(1);
        customer.setFirstName("Alaa");
        customer.setLastName("Apuelsoad");
        customer.setEmail("aabouelsod@gmail.com");
        customer.setPhoneNumber("123456721");

        Customer customer2 = (Customer) context.getBean("customer");
//        customer2.setId(2);
        customer2.setFirstName("Moahmed");
        customer2.setLastName("Ali");
        customer2.setEmail("mali@gmail.com");
        customer2.setPhoneNumber("123456987");

        CustomerRepository customerRepository = (CustomerRepository) context.getBean("customerRepository");

//        customerRepository.saveAll(new ArrayList<Customer>(Arrays.asList(customer, customer2)));

        Optional<Customer> customer1 = customerRepository.findById(100);
//        System.out.println(customer1);

//        Customer customer3 = customerRepository.findByLastName("Ali");
//        System.out.println(customer3);

    }

}
