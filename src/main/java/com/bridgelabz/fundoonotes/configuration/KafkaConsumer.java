package com.bridgelabz.fundoonotes.configuration;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class KafkaConsumer {

    private final Logger logger = (Logger) LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
