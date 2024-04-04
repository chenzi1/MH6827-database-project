package org.databaseproject.controller;

import org.databaseproject.model.Customer;
import org.databaseproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/findById")
    public Optional<Customer> findById(@PathVariable String id) {
        return customerService.getCustomer(id);
    }
}
