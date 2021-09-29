package com.example.Schedulers.web;

import com.example.Schedulers.data.MessageRepository;
import com.example.Schedulers.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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

    @PutMapping("/{id}")
    public void updateMessage(@PathVariable String id, @RequestBody Message message) {
        try {
            Message messageOld = messageRepository.findById(id).get();
            messageOld.setMessage(message.getMessage());
            messageOld.setReceiver(message.getReceiver());
            messageOld.setSender(message.getSender());
            messageOld.setMessageStatus(message.getMessageStatus());

            messageRepository.save(messageOld);
        } catch (NoSuchElementException exception) {
            log.error("error while fetching message : {}", exception.getMessage());
        }
    }
}
