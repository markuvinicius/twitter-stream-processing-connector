package com.markuvinicius.twitter.stream.listenner;

import com.markuvinicius.twitter.stream.producer.IProducer;
import com.markuvinicius.twitter.stream.producer.ProducerDefault;
import com.markuvinicius.twitter.stream.utils.TwitterModels;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class StreamListennerTest {

    private StreamListener listener;
    private IProducer producer;

    @Before
    public void setup(){
        producer = mock(ProducerDefault.class);
        listener = new StreamListener(producer);
    }

    @Test
    public void onStatusShouldProduceMessage(){
        TwitterModels.Status status = new TwitterModels.Status();
        doNothing().when(producer).sendMessage(any(), any(), any());
        listener.onStatus(status);

        Mockito.verify(producer, Mockito.times(1)).sendMessage(any(), any(), any());
    }
}
