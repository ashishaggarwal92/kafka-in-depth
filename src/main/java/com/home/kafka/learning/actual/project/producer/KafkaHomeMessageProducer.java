package com.home.kafka.learning.actual.project.producer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
@RequiredArgsConstructor
@ConfigurationProperties("kafka.home.producer.outbound")
public class KafkaHomeMessageProducer implements MessageHandler{

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Getter
    @Setter
    private String topic;

    @Override
    public void handleMessage(String message) {
        sendMessage(topic, "key1", message);
    }

    private void sendMessage(String topic, String key, String msg) {
        ListenableFuture<SendResult<String, String>> futire = kafkaTemplate.send(topic, key, msg);

        futire.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send msg=[{}] due to: {}", msg, ex.getMessage(), ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("MSG Sent=[{}] with offset:[{}]", msg, result.getRecordMetadata().offset());
            }
        });
    }



}
