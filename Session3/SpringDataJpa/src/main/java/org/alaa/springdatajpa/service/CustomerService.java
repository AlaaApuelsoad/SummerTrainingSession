package org.alaa.springdatajpa.service;

import org.alaa.springdatajpa.model.Customer;
import org.alaa.springdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAllByOrderByIdDesc();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(int id, Map<String, Object> updateReq) {
        Customer dbCustomer =  customerRepository.findById(id).get();
        if (updateReq.containsKey("empFirstName")) {
            dbCustomer.setFirstName((String) updateReq.get("empFirstName"));
        }
        return customerRepository.save(dbCustomer);
    }

}
