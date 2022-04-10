package com.markuvinicius.twitter.stream.config;

import org.aeonbits.owner.Config;

public interface ApplicationConfig extends Config {

    @Config.Key("kafka.topic.name")
    String kafkaTopic();

    @Config.Key("twitter.search.topics")
    String[] searchTopics();

    @Config.Key("kafka.bootstrap.server")
    String kafkaBootStrapServer();

    @Config.Key("kafka.application.id")
    String kafkaAppId();

    @Config.Key("twitter.search.languages")
    String[] searchLanguages();

    @Config.Key("jmx.object.name")
    String jmxObjectName();
}
