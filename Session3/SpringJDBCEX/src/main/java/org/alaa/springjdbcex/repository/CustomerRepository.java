package org.alaa.springjdbcex.repository;

import org.alaa.springjdbcex.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Customer> customerRowMapper = new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer1 = new Customer();
            customer1.setId(rs.getInt("id"));
            customer1.setFirstName(rs.getString("first_name"));
            customer1.setLastName(rs.getString("last_name"));
            customer1.setEmail(rs.getString("email"));
            customer1.setPhoneNumber(rs.getString("phone_number"));

            return customer1;
        }
    };


    public List<Map<String, Object>> findAllFromDB() {
        String readQuery = "SELECT * FROM customers";
        return jdbcTemplate.queryForList(readQuery);
    }

    public int getCustomerCount(){
        String readQuery = "SELECT count(*) FROM customers";
        return jdbcTemplate.queryForObject(readQuery, Integer.class);
    }

    public List<Customer> findAll(){
        String readQuery = "SELECT * FROM customers";

        return jdbcTemplate.query(readQuery,customerRowMapper);
    }

    public int save(Customer customer){
        String insertQuery = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(insertQuery,
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber());
    }

    public Customer findById(int id){
        String query = "SELECT * FROM customers WHERE id = ?";

        ResultSetExtractor<Customer> customersExtractor = new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                Customer customer = new Customer();
                if (rs.next()) {
                    customer.setId(rs.getInt("id"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhoneNumber(rs.getString("phone_number"));
                    return customer;
                }else {
                    throw new RuntimeException("No customer found with id " + id);
                }
            }
        };
        return jdbcTemplate.query(query,customersExtractor,id);
    }

    public List<Customer> findByFirstName(String firstName){
        String query = "SELECT * FROM customers WHERE LOWER(first_name) LIKE LOWER(?)";
        String pattern = "%" +  firstName + "%";
        return jdbcTemplate.query(query,customerRowMapper,pattern);
    }

}
