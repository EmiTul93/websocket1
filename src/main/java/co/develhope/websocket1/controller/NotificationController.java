package co.develhope.websocket1.controller;

import co.develhope.websocket1.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/broadcast-message")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messaggingEx;

    @PostMapping
    public void sendMessage(@RequestBody MessageDTO message) {
        messaggingEx.convertAndSend("/broadcast", message);
    }
}