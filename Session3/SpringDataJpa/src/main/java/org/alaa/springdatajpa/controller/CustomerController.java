package org.alaa.springdatajpa.controller;

import org.alaa.springdatajpa.model.Customer;
import org.alaa.springdatajpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/byFirstName")
    public List<Customer> getCustomerByFirstName(@RequestParam String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }

    @PatchMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Map<String,Object> updateReq) {
        return customerService.updateCustomer(id, updateReq);
    }

}
