package com.example.Check.controller;

import com.example.Check.entity.Notification;
import com.example.Check.entity.Role;
import com.example.Check.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{role}")
    public List<Notification> getNotifications(@PathVariable String role) {
        return notificationService.getNotificationsByRole(Role.valueOf(role.toUpperCase()));
    }

    @PostMapping
    public Notification createNotification(@RequestBody NotificationRequest request) {
        return notificationService.createNotification(request.getMessage(), request.getReceiverRole());
    }
}

class NotificationRequest {
    private String message;
    private Role receiverRole;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Role getReceiverRole() { return receiverRole; }
    public void setReceiverRole(Role receiverRole) { this.receiverRole = receiverRole; }
}