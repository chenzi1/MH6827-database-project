package org.databaseproject.olap.repository;

import org.databaseproject.olap.model.CustomerDimension;
import org.databaseproject.olap.model.DateDimension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDimensionRepository extends JpaRepository<CustomerDimension, String> {
}
