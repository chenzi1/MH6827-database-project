package org.databaseproject.oltp.repository;

import org.databaseproject.oltp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
    // Add custom queries if needed
}

