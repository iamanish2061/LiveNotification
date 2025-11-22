package com.LiveNotification.repo;

import com.LiveNotification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification, Long> {

    List<Notification> findByRecipientIdOrderByCreatedAtDesc(Long recipientId);

    List<Notification> findByRecipientRoleOrderByCreatedAtDesc(Notification.RecipientRole role);

}
