package com.LiveNotification.controller;

import com.LiveNotification.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class KafkaTestController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/send/{msg}")
    public String send(@PathVariable String msg){
        kafkaProducer.sendMessage("test-topic", msg);
        return "Sent: "+msg;
    }

}
