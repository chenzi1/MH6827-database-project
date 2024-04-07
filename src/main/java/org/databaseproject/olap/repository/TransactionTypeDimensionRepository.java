package org.databaseproject.olap.repository;

import org.databaseproject.olap.model.DateDimension;
import org.databaseproject.olap.model.TransactionTypeDimension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionTypeDimensionRepository extends JpaRepository<TransactionTypeDimension, String> {

    List<TransactionTypeDimension> findByTypeNameEqualsIgnoreCase(String transactiontype);
}
