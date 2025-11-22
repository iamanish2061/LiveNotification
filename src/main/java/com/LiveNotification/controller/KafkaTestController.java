package com.LiveNotification.controller;

import com.LiveNotification.entity.Notification;
import com.LiveNotification.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class KafkaTestController {

    private final KafkaProducer producer;

    public KafkaTestController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendTestNotification() {
        Notification n = new Notification();
        n.setMessage("Hello Admin!");
        n.setRecipientRole(Notification.RecipientRole.ADMIN);
        producer.sendNotification(n);
        return "Notification sent!";
    }

}
