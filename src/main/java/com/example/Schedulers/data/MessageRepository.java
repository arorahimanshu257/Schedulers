package com.example.Schedulers.data;

import com.example.Schedulers.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
