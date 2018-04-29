package com.example.books.processor.booksprocessor.event;

import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class BookIsDiscontinued implements DomainEvent {

    private Instant discontinuedAt;

    @Override
    public Instant occuredAt() {
        return discontinuedAt;
    }
}
