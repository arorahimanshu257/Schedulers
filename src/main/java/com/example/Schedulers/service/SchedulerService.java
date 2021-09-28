package com.example.Schedulers.service;

import com.example.Schedulers.data.MessageRepository;
import com.example.Schedulers.domain.Message;
import com.example.Schedulers.domain.MessageStatus;
import com.example.Schedulers.utils.RandomStringsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchedulerService {

    MessageRepository messageRepository;
    RandomStringsUtil randomStrings;

    public SchedulerService(MessageRepository messageRepository,
                            RandomStringsUtil randomStrings) {
        this.messageRepository = messageRepository;
        this.randomStrings = randomStrings;
    }

    @Scheduled(fixedDelay = 10000)
    public void scheduleMessages() {
        log.info("-----instantiating a new message-----");
        logMessages();
    }

    private void logMessages() {
        Message message = new Message();
        message.setMessage(randomStrings.randomMessage());
        message.setSender(randomStrings.randomName());
        message.setReceiver(randomStrings.randomName());
        message.setMessageStatus(MessageStatus.MSG_SENT);

        messageRepository.save(message);
        log.info("------message published-------");
    }

    @Scheduled(fixedDelay = 600000, initialDelay = 60000)
    public void scheduleCleanDatabase() {
        log.info("-----cleaning database after 10 minutes ------");
        log.info("purged {} items", messageRepository.count());
        messageRepository.deleteAll();
    }
}
