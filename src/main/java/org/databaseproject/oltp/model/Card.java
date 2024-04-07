package org.databaseproject.oltp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@Table(name = "Card")
public class Card {
    @Id
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "customer_id")
    private String customerId;

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

    @Column(name = "status")
    private String status;

    // Getters and setters
}
