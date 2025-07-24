package com.ntg.SpringBootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Developer {


    @Autowired
    Laptop laptop;

    public void coding(){
        System.out.println("coding");
        laptop.compiling();
        System.out.println("Developer coding");
    }
}
