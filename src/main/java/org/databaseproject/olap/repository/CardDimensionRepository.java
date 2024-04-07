package org.databaseproject.olap.repository;

import org.databaseproject.olap.model.CardDimension;
import org.databaseproject.olap.model.DateDimension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDimensionRepository extends JpaRepository<CardDimension, String> {
}
