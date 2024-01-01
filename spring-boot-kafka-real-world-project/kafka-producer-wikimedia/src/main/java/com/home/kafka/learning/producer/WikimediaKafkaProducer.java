package com.home.kafka.learning.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class WikimediaKafkaProducer {
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recentchange";
        // To read real time stream data from wikimedia, we use event source

        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);


    }
}
