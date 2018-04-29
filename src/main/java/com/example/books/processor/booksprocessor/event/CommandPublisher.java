package com.example.books.processor.booksprocessor.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Publisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandPublisher {

    @Publisher(channel = "payments")
    public String sendCommandToPayment(String command) {
        log.info("About to send {}", command);
        return command;
    }

    @Publisher(channel = "shipments")
    public String sendCommandToShipment(String command) {
        log.info("About to send {}", command);
        return command;
    }

    @Publisher(channel = "communication")
    public String sendCommandToCommunication(String command) {
        log.info("About to send {}", command);
        return command;
    }
}
