package org.databaseproject.olap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TransactionTypeDimension")
public class TransactionTypeDimension {
    @Id
    private int type_id;

    @Column(name = "type_name")
    private String typeName;

    // Getters and setters
}
