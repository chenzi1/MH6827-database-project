package org.databaseproject.oltp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "age_group")
    private String ageGroup;

    @Column(name = "age_score")
    private int ageScore;

    @Column(name = "education")
    private String education;

    @Column(name = "education_score")
    private int educationScore;

    @Column(name = "income")
    private int income;

    @Column(name = "income_range")
    private String incomeRange;

    @Column(name = "income_score")
    private int incomeScore;

    @Column(name = "credit_rating")
    private BigDecimal creditRating;

    @Column(name = "risk_grade")
    private String riskGrade;

    // Getters and setters
}

