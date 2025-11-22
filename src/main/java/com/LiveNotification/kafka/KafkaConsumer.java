package com.LiveNotification.kafka;

import com.LiveNotification.entity.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final SimpMessagingTemplate template;

    public KafkaConsumer(SimpMessagingTemplate template){
        this.template = template;
    }

    @KafkaListener(topics = "thecutlab",
    groupId = "notification-group")
    public void listen(Notification notification){
        // Admin broadcast
        if (notification.getRecipientRole() == Notification.RecipientRole.ADMIN) {
            template.convertAndSend("/topic/admin", notification);
        }
        else {  // User-specific notification
            template.convertAndSendToUser(
                    notification.getRecipientId().toString(),
                    "/queue/notifications",
                    notification
            );
        }
    }

}
