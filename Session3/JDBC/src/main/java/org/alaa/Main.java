package org.alaa;

import java.sql.*;

/**
 * JDBC Flow;
 1- Load the jdbc Driver.
 2- Establish Connection on the database.
 3- Create Statement or preparedStatement.
 4- Execute Sql Query.
 5- Process the result
 6- close the connection.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("JDBC Project");
        String databaseUrl = "jdbc:postgresql://localhost:5432/spring_sessions";
        String username = "postgres";
        String password = "hggi";
        Connection connection;

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(databaseUrl,username,password);
            System.out.println("Connection Successful");


            /**
             * Normal Statement
             */
            Statement statement = connection.createStatement();

            //Read Query
//            String readQuery = "SELECT * FROM customers";

            String userInput = "' OR '1'='1";
            //SQL Injection
            String readQuery = "SELECT * FROM customers WHERE first_name = '"+ userInput +"'ORDER BY id ASC";

//            ResultSet resultSet = statement.executeQuery(readQuery);
//            while (resultSet.next()) {
//                System.out.println(
//                        resultSet.getInt("id") + " | " +
//                                resultSet.getString("first_name") + " | " +
//                                resultSet.getString("last_name") + " | " +
//                                resultSet.getString("email") + " | " +
//                                resultSet.getString("phone_number")
//                );
//            }

            //Insert query
//            int rowsAdded = statement.executeUpdate("INSERT INTO customers (id,first_name,last_name,email,phone_number)" +
//                    " VALUES (2,'Mohamed','Ali','mali@gmail.com','01234576876')");
//            System.out.println("rowsAdded: " + rowsAdded);

            //Update Query
//            String updateQuery = "UPDATE customers SET last_name='Apuelsoud' WHERE id=1";
//            int rowsUpdated = statement.executeUpdate(updateQuery);
//            System.out.println("Rows updated: " + rowsUpdated);

            //Delete Query
            String deleteQuery = "DELETE FROM customers";
//            int rowsDeleted = statement.executeUpdate(deleteQuery);
//            System.out.println("Rows deleted: " + rowsDeleted);




            /**
             * prepared Statement
             */
            String insertQuery = "INSERT INTO customers VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Mohamed");
            preparedStatement.setString(3, "Yassin");
            preparedStatement.setString(4, "myassin@ntgclarity.com");
            preparedStatement.setString(5, "01234567889");
//            int rawsAffected = preparedStatement.executeUpdate();
//            System.out.println("Rows affected: " + rawsAffected);


            //Read Query
            String preparedReadQuery = "SELECT * FROM customers WHERE first_name = ?";
            PreparedStatement readStatement = connection.prepareStatement(preparedReadQuery);
            readStatement.setString(1, "Mohamed");
            ResultSet preparedResultSet = readStatement.executeQuery();

            Customer customer = new Customer();

//            while (preparedResultSet.next()) {
//                customer.setId(preparedResultSet.getInt("id"));
//                customer.setFirstName(preparedResultSet.getString("first_name"));
//                customer.setLastName(preparedResultSet.getString("last_name"));
//                customer.setEmail(preparedResultSet.getString("email"));
//                customer.setPhoneNumber(preparedResultSet.getString("phone_number"));
//                System.out.println(customer);
//            }

            //Prepared Delete Query
            String preparedDeleteQuery = "DELETE FROM customers WHERE id = ?";
            PreparedStatement deletePreparedStatement = connection.prepareStatement(preparedDeleteQuery);
            deletePreparedStatement.setInt(1, 2);
            int rawsDeleted = deletePreparedStatement.executeUpdate();
            System.out.println("Deleted Rows : " + rawsDeleted);

            connection.close();
            statement.close();
            preparedResultSet.close();
            System.out.println("Connection closed");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}