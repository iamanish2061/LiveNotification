package com.LiveNotification.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User driver; // nullable until assigned

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PLACED;

    private LocalDateTime createdAt = LocalDateTime.now();


    public enum OrderStatus {
        PLACED,
        ASSIGNED,
        OUT_FOR_DELIVERY,
        DELIVERED
    }
    // Getters and Setters
}
