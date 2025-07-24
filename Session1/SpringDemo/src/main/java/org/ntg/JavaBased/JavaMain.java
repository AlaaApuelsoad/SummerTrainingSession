package org.ntg.JavaBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaMain {
    public static void main(String[] args) {

        ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfiguration.class);

        Developer obj =  (Developer) context.getBean("developer2");
        obj.coding();
//
//        Developer obj2 =  (Developer) context.getBean("developer");
//        obj2.coding();

        Laptop lapObj = (Laptop)  context.getBean("laptop");
        lapObj.compiling();




    }
}
