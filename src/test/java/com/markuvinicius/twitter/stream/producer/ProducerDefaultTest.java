package com.markuvinicius.twitter.stream.producer;

import com.markuvinicius.twitter.stream.dtos.StatusDTO;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.MockProducer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProducerDefaultTest {
    private MockProducer<String, Object> mockProducer;
    private ProducerDefault producer;
    private final String TOPIC = "test";

    @Before
    public void setup(){
        this.mockProducer = new MockProducer<>();
        this.producer = new ProducerDefault(mockProducer,TOPIC);
    }

    @Test
    public void shouldSendAMessage(){
        StatusDTO value = StatusDTO.Builder
                .aStatusDTO()
                .build();

        this.producer.sendMessage("key",value);
        Assert.assertTrue(this.mockProducer.history().size() == 1);
    }

    @Test
    public void shouldSendAMessageWithCallBack() throws InterruptedException {
        StatusDTO value = StatusDTO.Builder
                .aStatusDTO()
                .build();

        Callback c = (RecordMetadata recordMetadata, Exception e) -> {
            Assert.assertTrue(recordMetadata.hasOffset());
            Assert.assertEquals(recordMetadata.topic(),TOPIC);
        };

        this.producer.sendMessage("key",value, c);
        Assert.assertTrue(this.mockProducer.history().size() == 1);
    }
}
