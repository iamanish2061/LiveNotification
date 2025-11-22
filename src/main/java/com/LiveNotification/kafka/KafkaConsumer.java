package com.LiveNotification.kafka;

import com.LiveNotification.entity.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "thecutlab",
    groupId = "notification-group")
    public void consume(Notification notification){
        System.out.println("Received Message" + notification.getMessage());

        //forward to web socket
    }

}
