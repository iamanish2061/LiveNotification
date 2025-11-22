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

    private boolean hasRead = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum RecipientRole {
        ADMIN,
        DRIVER,
        CUSTOMER
    }

    public Notification(Long id, String message, RecipientRole recipientRole, Long recipientId, boolean read, LocalDateTime createdAt) {
        this.id = id;
        this.message = message;
        this.recipientRole = recipientRole;
        this.recipientId = recipientId;
        this.hasRead = read;
        this.createdAt = createdAt;
    }

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RecipientRole getRecipientRole() {
        return recipientRole;
    }

    public void setRecipientRole(RecipientRole recipientRole) {
        this.recipientRole = recipientRole;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public boolean isHasRead() {
        return hasRead;
    }

    public void setHasRead(boolean hasRead) {
        this.hasRead = hasRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
