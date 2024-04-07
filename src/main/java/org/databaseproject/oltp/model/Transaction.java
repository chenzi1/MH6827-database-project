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
@Table(name = "Transaction")
public class Transaction {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "merchant_name")
    private String merchantName;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    // Getters and setters
}

