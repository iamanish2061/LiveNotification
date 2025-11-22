package com.LiveNotification.service;

import com.LiveNotification.entity.Notification;
import com.LiveNotification.kafka.KafkaProducer;
import com.LiveNotification.repo.NotificationRepo;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepo repository;
    private final KafkaProducer producer;

    public NotificationService(NotificationRepo repository, KafkaProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    public Notification createNotification(Notification notification) {
        Notification saved = repository.save(notification);
        producer.sendNotification(saved); // Publish complete saved object
        return saved;
    }

    public void markAsRead(Long id) {
        repository.findById(id).ifPresent(n -> {
            n.setHasRead(true);
            repository.save(n);
        });
    }

    public Iterable<Notification> getUserNotifications(Long userId) {
        return repository.findByRecipientIdOrderByCreatedAtDesc(userId);
    }

    public Iterable<Notification> getAdminNotifications() {
        return repository.findByRecipientRoleOrderByCreatedAtDesc(Notification.RecipientRole.ADMIN);
    }
}
