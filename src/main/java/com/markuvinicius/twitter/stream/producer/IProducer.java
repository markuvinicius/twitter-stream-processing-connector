package com.markuvinicius.twitter.stream.producer;

import org.apache.kafka.clients.producer.Callback;

public interface IProducer<K,V> {

    public void sendMessage(K key, V value);
    public void sendMessage(K key, V value, Callback callback);
    public void close();
}
