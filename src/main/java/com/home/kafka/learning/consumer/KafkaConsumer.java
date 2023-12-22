package com.home.kafka.learning.consumer;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumer {

    //@KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void consume(String message) {
        log.info("Message consumed : {}", message);


    }

}
