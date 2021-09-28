package com.example.Schedulers.web;

import com.example.Schedulers.data.MessageRepository;
import com.example.Schedulers.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createMessage(@RequestBody Message message) {
        try {
            messageRepository.save(message);
            log.info("------message published------");
        } catch (Exception exception) {
            log.error("error while publishing message : " + exception.getMessage());
        }
    }
}
