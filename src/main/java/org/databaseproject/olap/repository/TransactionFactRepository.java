package org.databaseproject.olap.repository;

import org.databaseproject.olap.model.TransactionFact;
import org.databaseproject.olap.model.TransactionTypeDimension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionFactRepository extends JpaRepository<TransactionFact, String> {
}
