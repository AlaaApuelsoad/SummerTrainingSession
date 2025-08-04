package org.alaa.springjdbcex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class SpringJDBCEXApplication {

    public static void main(String[] args) throws SQLException {
        System.out.println("SpringJDBCEXApplication started");
        ApplicationContext context = SpringApplication.run(SpringJDBCEXApplication.class, args);
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();

    }

}
