package com.LiveNotification.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private RecipientRole recipientRole;

    private Long recipientId; // nullable if role is generic (e.g., ADMIN)

    private boolean read = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum RecipientRole {
        ADMIN,
        DRIVER,
        CUSTOMER
    }

    // Getters and Setters
}
