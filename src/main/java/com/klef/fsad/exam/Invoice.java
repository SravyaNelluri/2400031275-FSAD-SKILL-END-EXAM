package com.klef.fsad.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @Column(name = "invoice_name", nullable = false, length = 100)
    private String name;

    @Column(name = "invoice_date", nullable = false)
    private LocalDate date;

    @Column(name = "invoice_status", nullable = false, length = 50)
    private String status;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description", length = 255)
    private String description;

    // Default constructor required by Hibernate
    public Invoice() {
    }

    // Parameterized constructor
    public Invoice(String name, LocalDate date, String status,
                   String customerName, double amount, String description) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.customerName = customerName;
        this.amount = amount;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", name=" + name + ", date=" + date
                + ", status=" + status + ", customerName=" + customerName
                + ", amount=" + amount + ", description=" + description + "]";
    }
}
