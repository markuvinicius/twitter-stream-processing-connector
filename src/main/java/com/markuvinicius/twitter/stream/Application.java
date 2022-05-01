package com.markuvinicius.twitter.stream;

import com.markuvinicius.twitter.stream.config.ApplicationConfig;
import com.markuvinicius.twitter.stream.dtos.StatusDTO;
import com.markuvinicius.twitter.stream.exceptions.PropertyConfigurationException;
import com.markuvinicius.twitter.stream.jmx.MetricStatusMBeanImpl;
import com.markuvinicius.twitter.stream.listenner.StreamListener;
import com.markuvinicius.twitter.stream.producer.IProducer;
import com.markuvinicius.twitter.stream.producer.ProducerFactory;
import com.markuvinicius.twitter.stream.serializers.JsonSerializer;
import org.aeonbits.owner.ConfigFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import javax.management.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Properties;

public class Application {

    private static ApplicationConfig config;
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final String CONSUMER_KEY="CONSUMER_KEY";
    private static final String CONSUMER_SECRET="CONSUMER_SECRET";
    private static final String ACCESS_TOKEN="ACCESS_TOKEN";
    private static final String TOKEN_SECRET="TOKEN_SECRET";
    private static final String DEBUG_ENABLED="DEBUG_ENABLED";

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        if (args.length == 0){
            logger.error("Usage: Application <application.properties>");
            System.exit(1);
        }
        config = parseApplicationConfig(args[0]);
        IProducer producer = ProducerFactory.getProducer(config);
        TwitterStream stream = buildStreamListener(producer);
        launchStreamListener(stream,
                config.searchTopics(),
                config.searchLanguages());
    }

    private static void setupJmxMBeans(String jmxObjectName) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName(jmxObjectName);
        mBeanServer.registerMBean(MetricStatusMBeanImpl.getInstance(), objectName);
    }

    public static ApplicationConfig parseApplicationConfig(String applicationPropertiesFileLocation) throws PropertyConfigurationException, IOException {
        ApplicationConfig appConfig ;
        Properties props = new Properties();
        props.load(new FileInputStream(new File(applicationPropertiesFileLocation)));
        appConfig = ConfigFactory.create(ApplicationConfig.class, props);

        if ( (appConfig.kafkaBootStrapServer() == null)
            || (appConfig.kafkaBootStrapServer().isEmpty()) ) {
            throw new PropertyConfigurationException("kafka.bootstrap.server property can not be empty");
        }

        if ( (appConfig.kafkaAppId() == null)
            || (appConfig.kafkaAppId().isEmpty()) ){
            throw new PropertyConfigurationException("kafka.application.id property can not be empty");
        }

        if ( (appConfig.kafkaTopic() == null)
                || (appConfig.kafkaTopic().isEmpty()) ){
            throw new PropertyConfigurationException("kafka.topic.name property can not be empty");
        }
        return appConfig;
    }

    private static TwitterStream buildStreamListener(IProducer<?, ?> defaultProducer) {

        StreamListener statusListener = new StreamListener(defaultProducer);
        TwitterStream twitterStream = new TwitterStreamFactory( getTwitterConfiguration() ).getInstance();
        twitterStream.addListener(statusListener);

        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                logger.info("Closing Status Stream");
                twitterStream.cleanUp();
                twitterStream.clearListeners();
                defaultProducer.close();
            }
        });

        return twitterStream;
    }

    private static Configuration getTwitterConfiguration() {
        String consumerKey = System.getenv(CONSUMER_KEY);
        String consumerSecret = System.getenv(CONSUMER_SECRET);
        String accessToken = System.getenv(ACCESS_TOKEN);
        String tokenSecret = System.getenv(TOKEN_SECRET);

        Boolean debugEnabled = Boolean.parseBoolean( System.getenv(DEBUG_ENABLED) );

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setDebugEnabled(debugEnabled)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(tokenSecret);

        return builder.build();
    }


    private static void launchStreamListener(TwitterStream stream, String[] searchTopics, String[] languages) {
        try {
            if (searchTopics.length != 0) {
                FilterQuery query = new FilterQuery()
                        .track(searchTopics)
                        .language(languages);

                stream.filter(query);
            } else {
                stream.sample();
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
