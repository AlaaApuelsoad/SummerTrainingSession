package com.ntg.SpringBootDemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class CustomBeanConfiguration {

    @Bean
//    @Lazy
    public Laptop laptop(){
        return new Laptop();
    }

}
