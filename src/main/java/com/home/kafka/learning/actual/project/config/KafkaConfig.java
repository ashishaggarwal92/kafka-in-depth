package com.home.kafka.learning.actual.project.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableKafka
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaSslConfig kafkaSslConfig;

    @Value("${kafka.bootstrap.server}")
    private String kafkaBootstrapServer;

    @Value("${kafka.key.deserializer}")
    private String kafkaKeyDeserializer;

    @Value("${kafka.value.deserializer}")
    private String kafkaValueDeserializer;

    @Value("${kafka.key.serializer}")
    private String kafkaKeySerializer;

    @Value("${kafka.value.serializer}")
    private String kafkaValueSerializer;

    @Value("${kafka.auto.flush}")
    private boolean kafkaTemplateAutoFlush;

    @Value("${kafka.home.consumer.group.id}")
    private String kafkaHomeConsumerGroupId;

    @Value("${kafka.home.consumer.auto-offset.reset}")
    private String homeConsumerOffsetReset;

    @Value("${kafka.producer.enable.idempotence.config}")
    private String isHomeIdempotentEnabled;

    @Bean
    public Map<String, Object> kafkaProducerConfigs() throws FileNotFoundException {

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.kafkaBootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaKeySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, this.kafkaValueSerializer);
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, this.isHomeIdempotentEnabled);
        props = this.kafkaSslConfig.kafkaSslConfig(props);
        return props;
    }

    @Bean
    public ProducerFactory<String, String> kafkaProducerFactory() throws FileNotFoundException {
        return new DefaultKafkaProducerFactory<>(kafkaProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() throws FileNotFoundException {
        return new KafkaTemplate<>(kafkaProducerFactory(), this.kafkaTemplateAutoFlush);
    }

    @Bean
    public Map<String, Object> kafkaConsumerConfigs() throws FileNotFoundException {

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.kafkaBootstrapServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaKeySerializer);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, this.kafkaValueSerializer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, this.kafkaHomeConsumerGroupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, this.homeConsumerOffsetReset);
        props = this.kafkaSslConfig.kafkaSslConfig(props);
        return props;
    }

    @Bean
    public ConsumerFactory<String, String> kafkaConsumerFactory() throws FileNotFoundException {
        return new DefaultKafkaConsumerFactory<>(kafkaConsumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() throws FileNotFoundException {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory());
        factory.setConcurrency(15);
        return factory;
    }





}
