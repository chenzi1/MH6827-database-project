package org.databaseproject.olap.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "CardDimension")
public class CardDimension {
    @Id
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "cancellation_date")
    private Date cancellationDate;

    @Column
    private String status;

    @Column(name = "customer_id")
    private String customerId;

    // Getters and setters
}

