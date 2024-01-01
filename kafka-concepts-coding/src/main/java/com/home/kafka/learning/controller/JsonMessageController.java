package com.home.kafka.learning.controller;

import com.home.kafka.learning.model.User;
import com.home.kafka.learning.producer.JsonKafkaProducer;
import com.home.kafka.learning.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    // http://localhost:8080/api/v1/kafka/publishJson
    // http://localhost:8090/api/v1/kafka/publishJson
    @PostMapping("/publishJson")
    public ResponseEntity<String> publish(@RequestBody User userData) {
        kafkaProducer.sendMessage(userData);
        return ResponseEntity.ok("Json Message sent to the topic");
    }





}
