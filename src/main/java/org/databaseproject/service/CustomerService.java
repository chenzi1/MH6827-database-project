package org.databaseproject.service;

import org.databaseproject.model.Customer;
import org.databaseproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> getCustomer(String id) {
        return customerRepository.findById(id);
    }
}
