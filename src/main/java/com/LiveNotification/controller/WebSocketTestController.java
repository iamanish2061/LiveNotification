package com.LiveNotification.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws-test")
public class WebSocketTestController {

    private final SimpMessagingTemplate template;

    public WebSocketTestController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @PostMapping("/send")
    public String test(@RequestBody String message) {
        template.convertAndSend("/topic/notifications", message);
        return "WS Message sent: " + message;
    }
}
