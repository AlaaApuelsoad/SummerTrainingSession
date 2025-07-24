package com.ntg.SpringWeb;

import com.ntg.SpringWeb.Controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {

		for (String arg : args) {
			System.out.println("argument-->" + arg);
		}

		System.out.println("Spring Web Application");

		ApplicationContext context = SpringApplication.run(SpringWebApplication.class, args);
		HelloController controller = (HelloController) context.getBean("helloController");
		controller.controller();

	}

}
