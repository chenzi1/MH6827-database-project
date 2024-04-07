package org.databaseproject.oltp.repository;

import org.databaseproject.oltp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Add custom queries if needed
}

