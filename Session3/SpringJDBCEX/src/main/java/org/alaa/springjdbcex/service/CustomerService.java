package org.alaa.springjdbcex.service;

import org.alaa.springjdbcex.model.Customer;
import org.alaa.springjdbcex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Map<String, Object>> getAllCustomers() {
        return customerRepository.findAllFromDB();
    }

    public int getCustomerCount() {
        return customerRepository.getCustomerCount();
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public int addNewCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findById(id);
    }
    public List<Customer> findAllCustomersByFirstName(String firstName){
        return customerRepository.findByFirstName(firstName);
    }
}
