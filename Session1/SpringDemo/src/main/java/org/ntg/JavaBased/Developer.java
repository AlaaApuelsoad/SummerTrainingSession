package org.ntg.JavaBased;

import org.springframework.beans.factory.annotation.Autowired;

public class Developer {

//    @Autowired //field injection
//    Laptop laptop;
    private Laptop laptop;

    //setter injection
//    @Autowired
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }

    public Developer(@Autowired Laptop laptop) {
        this.laptop = laptop;
        System.out.println("Developer Object Created");
    }

    public void coding(){
        laptop.compiling();
        System.out.println("Developer Coding");
    }
}
