package com.markuvinicius.twitter.stream.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDefault extends AbstractProducer<String, Object> {

    public ProducerDefault(Producer producer, String topic) {
        super(producer, topic);
    }

    public ProducerDefault(Properties props, String topic) {
        super(props,topic);
    }

    @Override
    public void sendMessage(String key, Object value) {
        producer.send(new ProducerRecord<>(topic, key, value));
    }

    @Override
    public void sendMessage(String key, Object value, Callback callback) {
        producer.send(new ProducerRecord<>(topic, key, value), callback);
    }

    @Override
    public void close() {
        producer.flush();
        producer.close();
    }
}
