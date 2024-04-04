package org.databaseproject.repository;

import org.databaseproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Add custom queries if needed
}

