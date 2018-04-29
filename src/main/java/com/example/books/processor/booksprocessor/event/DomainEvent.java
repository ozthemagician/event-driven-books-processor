package com.example.books.processor.booksprocessor.event;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;

@JsonDeserialize(using = DomainEventDeserializer.class)
public interface DomainEvent {

    Instant occuredAt();
}
