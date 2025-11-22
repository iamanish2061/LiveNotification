package com.LiveNotification.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;

        @Enumerated(EnumType.STRING)
        private UserRole role;

        @OneToMany(mappedBy = "customer")
        @JsonIgnore
        private List<Order> customerOrders; // only used if role = CUSTOMER

        @OneToMany(mappedBy = "driver")
        @JsonIgnore
        private List<Order> driverOrders; // only used if role = DRIVER

        // Getters and Setters

        public enum UserRole {
            ADMIN,
            DRIVER,
            CUSTOMER
        }

    public User(Long id, String name, String email, UserRole role, List<Order> customerOrders, List<Order> driverOrders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.customerOrders = customerOrders;
        this.driverOrders = driverOrders;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Order> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<Order> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public List<Order> getDriverOrders() {
        return driverOrders;
    }

    public void setDriverOrders(List<Order> driverOrders) {
        this.driverOrders = driverOrders;
    }
}

