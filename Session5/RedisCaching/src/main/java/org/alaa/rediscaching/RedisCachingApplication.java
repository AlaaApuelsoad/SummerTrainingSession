package org.alaa.rediscaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCachingApplication {

    public static void main(String[] args) {
        System.out.println("SpringBootRedisCachingApplication");
        SpringApplication.run(RedisCachingApplication.class, args);
    }



}
