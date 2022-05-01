package com.markuvinicius.twitter.stream.config;

import org.aeonbits.owner.Config;

public interface ApplicationConfig extends Config {

    @Config.Key("kafka.topic.name")
    String kafkaTopic();

    @Config.Key("kafka.bootstrap.server")
    String kafkaBootStrapServer();

    @Config.Key("kafka.key.serializer")
    String kafkaKeySerializer();

    @Config.Key("kafka.value.serializer")
    String kafkaValueSerializer();

    @Config.Key("kafka.application.id")
    String kafkaAppId();

    @Config.Key("twitter.search.languages")
    String[] searchLanguages();

    @Config.Key("twitter.search.topics")
    String[] searchTopics();

    @Config.Key("jmx.object.name")
    String jmxObjectName();


}
