package com.markuvinicius.twitter.stream.utils;

import com.markuvinicius.twitter.stream.config.ApplicationConfig;

public class ApplicationConfigTest implements ApplicationConfig {
        @Override
        public String kafkaTopic() {
            return "TOPIC";
        }

        @Override
        public String kafkaBootStrapServer() {
            return "localhost:9092";
        }

        @Override
        public String kafkaKeySerializer() {
            return "com.markuvinicius.twitter.stream.serializers.JsonSerializer";
        }

        @Override
        public String kafkaValueSerializer() {
            return "org.apache.kafka.common.serialization.StringSerializer";
        }

        @Override
        public String kafkaAppId() {
            return "appId";
        }

        @Override
        public String[] searchLanguages() {
            return new String[0];
        }

        @Override
        public String[] searchTopics() {
            return new String[0];
        }

        @Override
        public String jmxObjectName() {
            return "jmx";
        }
}
