package com.example.books.processor.booksprocessor.event;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class BookIsReleased implements DomainEvent {

    private Instant releasedAt;

    @Override
    public Instant occuredAt() {
        return releasedAt;
    }
}
