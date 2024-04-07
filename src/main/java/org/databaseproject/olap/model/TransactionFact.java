package org.databaseproject.olap.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "TransactionFact")
public class TransactionFact {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "merchant_name")
    private String merchantName;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column
    private BigDecimal amount;

    @Column
    private String currency;

    @Column(name = "type_id")
    private int typeId;

    @Column
    private String status;

    // Getters and setters
}

