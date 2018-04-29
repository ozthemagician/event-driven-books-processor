package com.example.books.processor.booksprocessor

import com.example.books.processor.booksprocessor.event.Channels
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.GenericMessage
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.time.Instant
import java.util.concurrent.BlockingQueue

@SpringBootTest
@ContextConfiguration(classes = [BooksProcessorApplication], loader = SpringBootContextLoader)
class E2ETest extends Specification {

    @Autowired
    Channels channels

    @Autowired
    MessageCollector messageCollector

    //Create mock queues on memory
    BlockingQueue payments
    BlockingQueue shipments
    BlockingQueue communication

    def setup() {
        payments = messageCollector.forChannel(channels.payments())
        shipments = messageCollector.forChannel(channels.shipments())
        communication = messageCollector.forChannel(channels.communication())
    }


    def 'when book is discontinued then 3 commands thrown'() {
        when:
        channels.books().send(new GenericMessage<Object>(new com.example.books.processor.booksprocessor.event.BookIsDiscontinued(Instant.now())))
        then:
        // 3 outbound commands were thrown
        (payments.poll() as String).contains("cancelPayment")
        (shipments.poll() as String).contains("cancelShipment")
        (communication.poll() as String).contains("sendEmail")

    }

    def 'when book is on sale then no commands thrown'() {
        when:
        channels.books().send(new GenericMessage<Object>(new com.example.books.processor.booksprocessor.event.AuthorNameChanged("Edgar Alan Poe", Instant.now())))
        then:
        // 3 outbound queue must be empty
        payments.isEmpty()
        shipments.isEmpty()
        communication.isEmpty()

    }

}
