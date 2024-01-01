package com.home.kafka.learning.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Message Produce by producer : {}", message);
        kafkaTemplate.send("myTopic", message);
    }
}
