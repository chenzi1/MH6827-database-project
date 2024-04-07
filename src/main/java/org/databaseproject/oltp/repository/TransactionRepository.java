package org.databaseproject.oltp.repository;

import org.databaseproject.oltp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
