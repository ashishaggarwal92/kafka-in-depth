package com.home.kafka.learning;

import com.home.kafka.learning.producer.WikimediaKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartProducerApplication implements CommandLineRunner {

    @Autowired
    private WikimediaKafkaProducer wikimediaKafkaProducer;

    public static void main(String[] args) {
        SpringApplication.run(StartProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaKafkaProducer.sendMessage();
    }



}
