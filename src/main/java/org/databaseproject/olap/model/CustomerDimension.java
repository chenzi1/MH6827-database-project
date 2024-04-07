package org.databaseproject.olap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "CustomerDimension")
public class CustomerDimension {
    @Id
    private String customer_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private int age;

    @Column(name = "age_group")
    private String ageGroup;

    @Column
    private String education;

    @Column
    private int income;

    @Column(name = "income_range")
    private String incomeRange;

    @Column(name = "credit_rating")
    private BigDecimal creditRating;

    @Column(name = "risk_grade")
    private String riskGrade;

    @Column
    private boolean churned;

    // Getters and setters
}

