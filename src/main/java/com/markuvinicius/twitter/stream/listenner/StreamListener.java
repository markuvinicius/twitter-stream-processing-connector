package com.markuvinicius.twitter.stream.listenner;

import com.markuvinicius.twitter.stream.dtos.StatusDTO;
import com.markuvinicius.twitter.stream.dtos.UserDTO;
import com.markuvinicius.twitter.stream.jmx.MetricStatusMBeanImpl;
import com.markuvinicius.twitter.stream.producer.IProducer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;

public class StreamListener implements twitter4j.StatusListener {
    private final Logger logger = LoggerFactory.getLogger(StreamListener.class);

    private final IProducer producer;

    public StreamListener(IProducer producer) {
        this.producer = producer;
    }

    @Override
    public void onStatus(Status status) {
        MetricStatusMBeanImpl.getInstance().incrementNumberOfTwitterStatusReceived();

        UserDTO userDTO = UserDTO.Builder.anUserDTO()
                .withId(status.getUser().getId())
                .withCreatedAt(status.getUser().getCreatedAt())
                .withName(status.getUser().getName())
                .withLang(status.getUser().getLang())
                .withEmail(status.getUser().getEmail())
                .withFollowersCount(status.getUser().getFollowersCount())
                .withScreenName(status.getUser().getScreenName())
                .build();

        StatusDTO statusDTO = StatusDTO.Builder.aStatusDTO()
                .withId(status.getId())
                .withCreatedAt(status.getCreatedAt())
                .withLang(status.getLang())
                .withFavoriteCount(status.getFavoriteCount())
                .withRetweetCount(status.getRetweetCount())
                .withText(status.getText())
                .withUser(userDTO)
                .withLocation(status.getPlace().getCountry())
                .build();

        Callback callback = (RecordMetadata recordMetadata, Exception e) -> handleResult(e, statusDTO);
        producer.sendMessage(null, statusDTO, callback);
    }

    private void handleResult(Exception e, StatusDTO statusDTO) {
        if (e != null) {
            MetricStatusMBeanImpl.getInstance().incrementNumberOfProducerExceptions();
            logger.error("Error sending message: " + e.getMessage());
            e.printStackTrace();
        } else {
            MetricStatusMBeanImpl.getInstance().incrementNumberOfTwitterStatusDispatched();
            logger.info("Message Sent: " + statusDTO.toString());
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}

    @Override
    public void onTrackLimitationNotice(int i) {
        logger.info("Message limitation: " + i);
    }

    @Override
    public void onScrubGeo(long l, long l1) {}

    @Override
    public void onStallWarning(StallWarning stallWarning) {}

    @Override
    public void onException(Exception e) {
        if ((e != null) && !(e instanceof NullPointerException)) {
            MetricStatusMBeanImpl.getInstance().incrementNumberOfTwitterStreamExceptions();
            logger.error("Error Handling Stream: " + e.getMessage());
        }
    }
}
