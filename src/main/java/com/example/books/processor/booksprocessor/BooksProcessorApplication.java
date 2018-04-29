package com.example.books.processor.booksprocessor;

import com.example.books.processor.booksprocessor.event.CommandPublisher;
import com.example.books.processor.booksprocessor.event.DomainEvent;
import com.example.books.processor.booksprocessor.event.BookIsDiscontinued;
import com.example.books.processor.booksprocessor.event.Channels;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(Channels.class)
@SpringBootApplication
@RequiredArgsConstructor
public class BooksProcessorApplication {

    private final CommandPublisher commandPublisher;

    public static void main(String[] args) {
        SpringApplication.run(BooksProcessorApplication.class, args);
    }

    @StreamListener("books")
    public void handleEvent(DomainEvent event) {
        log.info("Received: {}", event.toString());
        if (event instanceof BookIsDiscontinued) {
            commandPublisher.sendCommandToPayment("cancelPayment");
            commandPublisher.sendCommandToShipment("cancelShipment");
            commandPublisher.sendCommandToCommunication("sendEmail");
        }
    }

}
