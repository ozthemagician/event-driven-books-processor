package com.example.books.processor.booksprocessor.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class AuthorNameChanged implements DomainEvent {

    private final String authorName;
    private final Instant when;


    @Override
    public Instant occuredAt() {
        return when;
    }
}
