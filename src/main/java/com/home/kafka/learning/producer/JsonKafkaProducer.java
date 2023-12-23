package com.home.kafka.learning.producer;

import com.home.kafka.learning.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class JsonKafkaProducer {

    private KafkaTemplate<String, User> kafkaTemplate;


    public void sendMessage(User userData) {
        log.info("Message sent : {}", userData);
        Message<User> message = MessageBuilder.withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC, "myTopic_json")
                .build();

        kafkaTemplate.send(message);
    }




}
