package com.home.kafka.learning.actual.project.consumer;

import com.home.kafka.learning.actual.project.producer.KafkaHomeMessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaHomeMessageConsumer {


    //@KafkaListener(topics = "${kafka.home.consumer.inbound.topic}", groupId = "myGroup")
    private void listenToInboundMessage(String record) {
        log.info("Msg received:[{}]", record);

    }

}
