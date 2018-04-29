package com.example.books.processor.booksprocessor.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class DomainEventDeserializer extends JsonDeserializer<DomainEvent> {

    @Override
    public DomainEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return null;
/*
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);
        if (root.has("authorName")) {
            return mapper.readValue(root.toString(), AuthorNameChanged.class);
        }
        if (root.has("releasedAt"))
            return mapper.readValue(root.toString(), BookIsReleased.class);
        if (root.has("discontinuedAt"))
            return mapper.readValue(root.toString(), BookIsDiscontinued.class);
        return null;
*/
    }
}
