package com.example.Check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Check.entity.Notification;
import com.example.Check.entity.Role;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByReceiverRole(Role receiverRole);
}
