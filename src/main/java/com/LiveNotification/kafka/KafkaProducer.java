package com.LiveNotification.kafka;


import com.LiveNotification.entity.Notification;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, Notification> kafkaTemplate;
    private final String TOPIC = "thecutlab";

    public KafkaProducer(KafkaTemplate<String, Notification> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(Notification notification){
        kafkaTemplate.send(TOPIC, notification);
    }

}
