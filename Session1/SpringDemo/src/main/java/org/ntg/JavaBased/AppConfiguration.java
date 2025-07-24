package org.ntg.JavaBased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean("developer2")
    public Developer developerObject(){
        return new Developer(laptop());
    }

//    @Bean()
//    public Developer developer2(){
//        return new Developer();
//    }

    @Bean
    public Laptop laptop(){
        return new Laptop();
    }
}
