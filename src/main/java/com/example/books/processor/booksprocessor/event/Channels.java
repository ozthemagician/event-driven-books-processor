package com.example.books.processor.booksprocessor.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    @Input
    SubscribableChannel books();

    @Output
    MessageChannel payments();

    @Output
    MessageChannel shipments();

    @Output
    MessageChannel communication();
}
