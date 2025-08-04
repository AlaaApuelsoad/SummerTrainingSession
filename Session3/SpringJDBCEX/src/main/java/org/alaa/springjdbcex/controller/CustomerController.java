package org.alaa.springjdbcex.controller;

import org.alaa.springjdbcex.model.Customer;
import org.alaa.springjdbcex.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Database Format
    @GetMapping("/db")
    public List<Map<String, Object>> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/count")
    public int customersCount(){
        return customerService.getCustomerCount();
    }

    //RowMapper
    @GetMapping
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @PostMapping
    public int addNewCustomer(@RequestBody Customer customer){
        return customerService.addNewCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable int id){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/byFirstName")
    public List<Customer> findCustomerByFirstName(@RequestParam("firstName") String firstName){
        return customerService.findAllCustomersByFirstName(firstName);
    }
}
