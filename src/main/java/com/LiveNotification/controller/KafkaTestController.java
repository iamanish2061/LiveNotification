package com.LiveNotification.controller;

import com.LiveNotification.entity.Notification;
import com.LiveNotification.kafka.KafkaProducer;
import com.LiveNotification.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class KafkaTestController {

    private final KafkaProducer producer;
    private final NotificationService service;

    public KafkaTestController(KafkaProducer producer, NotificationService service) {
        this.producer = producer;
        this.service =service;
    }

    @PostMapping("/send")
    public Notification send(@RequestBody Notification notification) {
        return service.createNotification(notification);
    }

    @GetMapping("/user/{id}")
    public Iterable<Notification> getForUser(@PathVariable Long id) {
        return service.getUserNotifications(id);
    }

    @GetMapping("/admin")
    public Iterable<Notification> getForAdmin() {
        return service.getAdminNotifications();
    }

    @PutMapping("/mark/{id}")
    public String markAsRead(@PathVariable Long id) {
        service.markAsRead(id);
        return "Marked as read";
    }

}
