package org.alaa.springdatajpa.controller;

import org.alaa.springdatajpa.model.Customer;
import org.alaa.springdatajpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("TEST_HEADER", "TEST_VALUE");
        return new ResponseEntity<>(customerService.addCustomer(customer),headers,HttpStatus.CREATED);
    }

    @GetMapping("/byFirstName")
    public List<Customer> getCustomerByFirstName(@RequestParam String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        Map<String,Object> response = new HashMap<>();
        try {
            customerService.deleteCustomerById(id);
            response.put("Message ","deleted successfully");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception e) {
            response.put("Message ",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Map<String,Object> updateReq) {
        return customerService.updateCustomer(id, updateReq);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        Map<String,Object> response = new HashMap<>();
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getCustomerBYId(id));
        }catch (Exception e) {
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

    }

}
