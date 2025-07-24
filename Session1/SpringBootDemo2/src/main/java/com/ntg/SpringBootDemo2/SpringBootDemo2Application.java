package com.ntg.SpringBootDemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootDemo2Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootDemo2Application.class, args);

//		Student obj = (Student) context.getBean("studentBean");
//		obj.study();

		Laptop laptop = (Laptop) context.getBean("laptop");
		laptop.compiling();

//		Student student = new Student();
//		student.study();

//		Developer objDeveloper = (Developer) context.getBean("developer");
//		objDeveloper.coding();

//		NotificationService notificationService = (NotificationService) context.getBean("notificationService");
//		notificationService.sendMessage("alaa");



	}

}
