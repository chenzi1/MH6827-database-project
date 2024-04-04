package org.databaseproject.repository;

import org.databaseproject.model.Card;
import org.databaseproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
    // Add custom queries if needed
}

