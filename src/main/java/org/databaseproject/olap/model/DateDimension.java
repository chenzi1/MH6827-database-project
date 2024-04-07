package org.databaseproject.olap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "DateDimension")
public class DateDimension {
    @Id
    private int date_key;

    @Column
    private Date date;

    @Column
    private int day;

    @Column
    private int month;

    @Column
    private int quarter;

    @Column
    private int year;

    @Column(name = "day_of_week")
    private int dayOfWeek;

    @Column
    private int hour;

    @Column(name = "is_peak_hour")
    private boolean isPeakHour;

    // Getters and setters
}

