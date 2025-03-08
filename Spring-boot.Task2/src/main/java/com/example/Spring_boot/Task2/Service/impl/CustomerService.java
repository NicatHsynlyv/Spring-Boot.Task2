package com.example.Spring_boot.Task2.Service.impl;

import com.example.Spring_boot.Task2.Entity.Customer;
import com.example.Spring_boot.Task2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findCustomersByName(name);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
}
