package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }

    @Autowired
    private WikiChangesProducer wikiChangesProducer;
    /**
     * @param args
     * @throws Exception
     */

    @Override
    public void run(String... args) throws Exception {
        wikiChangesProducer.sendMessage();
    }
}