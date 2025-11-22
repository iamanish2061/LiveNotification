package com.LiveNotification.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
