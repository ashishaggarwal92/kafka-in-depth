package com.home.kafka.learning.consumer;


import com.home.kafka.learning.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaJsonConsumer {

    @KafkaListener(topics = "myTopic_json", groupId = "myGroup")
    public void consume(User userData) {
        log.info("Json Message consumed : {}", userData);


    }

}
