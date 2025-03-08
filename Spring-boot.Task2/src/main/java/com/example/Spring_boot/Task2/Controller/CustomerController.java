package com.example.Spring_boot.Task2.Controller;

import com.example.Spring_boot.Task2.Entity.Customer;
import com.example.Spring_boot.Task2.Service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/name/{name}")
    public List<Customer> getCustomersByName(@PathVariable String name) {
        return customerService.getCustomersByName(name);
    }

    @GetMapping("/email/{email}")
    public Customer getCustomerByEmail(@PathVariable String email) {
        return customerService.getCustomerByEmail(email);
    }

}
