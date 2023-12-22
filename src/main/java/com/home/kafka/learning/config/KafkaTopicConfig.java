package com.home.kafka.learning.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    // This will create a Kafka Topic in a kafka cluster
    //@Bean
    public NewTopic myNewTopic() {
        return TopicBuilder.name("myTopic")
                .build();
    }
}
