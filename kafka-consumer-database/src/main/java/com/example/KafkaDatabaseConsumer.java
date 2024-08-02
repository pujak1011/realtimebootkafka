package com.example;

import com.example.enity.WikiData;
import com.example.repository.WikiDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikiDataRepository wikiDataRepository;

    public KafkaDatabaseConsumer(WikiDataRepository wikiDataRepository) {
        this.wikiDataRepository = wikiDataRepository;
    }

    @KafkaListener(topics="wiki-kafka", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Event Message received=. %s", message));
        WikiData wikiData = new WikiData();
        wikiData.setWikiEventData(message);

        wikiDataRepository.save(wikiData);


    }
}
