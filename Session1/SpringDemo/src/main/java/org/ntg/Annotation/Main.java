package org.ntg.Annotation;

import org.ntg.JavaBased.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"org.ntg.Annotation"})
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =  new AnnotationConfigApplicationContext(Main.class);

        Developer obj = context.getBean(Developer.class);
        obj.coding();

        Student student = context.getBean(Student.class);
        student.study();
    }
}
