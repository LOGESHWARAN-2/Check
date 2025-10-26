package com.example.Check.service;

import com.example.Check.entity.Notification;
import com.example.Check.entity.Role;
import com.example.Check.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(String message, Role receiverRole) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setReceiverRole(receiverRole);
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsByRole(Role role) {
        return notificationRepository.findByReceiverRole(role);
    }
}
