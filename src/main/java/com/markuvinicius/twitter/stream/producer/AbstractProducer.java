package com.markuvinicius.twitter.stream.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public abstract class AbstractProducer<K,V> implements IProducer<K,V>{
    protected final Producer producer;
    protected String topic;

    public AbstractProducer(Producer producer, String topic) {
        this.producer = producer;
        this.topic = topic;
    }

    public AbstractProducer(Properties props, String topic) {
        super();
        this.producer = new KafkaProducer(props);
        this.topic = topic;
    }
}
