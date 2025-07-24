package com.ntg.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		Developer obj = context.getBean(Developer.class);
		obj.coding();

		Laptop laptop = context.getBean(Laptop.class);
		laptop.compiling();

//		Developer obj2 = context.getBean(Developer.class);
//		obj2.coding();




	}

}
