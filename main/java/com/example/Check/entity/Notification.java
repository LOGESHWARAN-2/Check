package com.example.Check.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private Role receiverRole; // MANAGER or EMPLOYEE

    private LocalDateTime timestamp = LocalDateTime.now();

    private boolean isRead = false;
}
