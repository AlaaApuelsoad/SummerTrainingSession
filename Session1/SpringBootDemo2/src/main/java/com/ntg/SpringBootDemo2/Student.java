package com.ntg.SpringBootDemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("studentBean")
//@Lazy
public class Student {

    @Autowired
    Laptop laptop;

    public Student() {
        System.out.println("Student Created");
    }

    public void study() {
        laptop.compiling();
        System.out.println("Student study");
    }
}
