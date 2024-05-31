package com.expense.tracker.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="expenses")
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String expense;
    private double cost;
}
