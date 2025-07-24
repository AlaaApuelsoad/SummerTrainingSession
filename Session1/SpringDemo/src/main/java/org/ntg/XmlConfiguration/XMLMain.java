package org.ntg.XmlConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("XMLBeanConfiguration.xml");

        Developer obj = (Developer) context.getBean("developer");
        obj.coding();

        Developer obj1 = (Developer) context.getBean("developer");
        obj1.coding();


    }
}
