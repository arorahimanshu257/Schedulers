package com.example.Schedulers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Document("messageLogs")
public class Message {
    @Id
    private String id;
    private String message;
    private String sender;
    private String receiver;
    private MessageStatus messageStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
