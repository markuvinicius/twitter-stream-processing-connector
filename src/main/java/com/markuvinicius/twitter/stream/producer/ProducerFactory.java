package com.markuvinicius.twitter.stream.producer;

import com.markuvinicius.twitter.stream.config.ApplicationConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

public interface ProducerFactory {

    static IProducer getProducer(ApplicationConfig config){
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.CLIENT_ID_CONFIG, config.kafkaAppId());
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.kafkaBootStrapServer());
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, config.kafkaKeySerializer());
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, config.kafkaValueSerializer());

        IProducer producer = new ProducerDefault(configProperties, config.kafkaTopic());
        return producer;
    }
}
