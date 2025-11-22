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
}

