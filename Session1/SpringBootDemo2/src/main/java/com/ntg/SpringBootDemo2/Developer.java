package com.ntg.SpringBootDemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Developer {

    @Autowired
    Laptop laptop;

    public void coding(){
        laptop.compiling();
    }
}
