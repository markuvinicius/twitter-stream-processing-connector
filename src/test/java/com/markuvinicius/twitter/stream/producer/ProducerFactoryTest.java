package com.markuvinicius.twitter.stream.producer;

import com.markuvinicius.twitter.stream.utils.ApplicationConfigTest;
import org.junit.Assert;
import org.junit.Test;

public class ProducerFactoryTest {
    @Test
    public void shouldCreateAProducer(){
        IProducer producer = ProducerFactory.getProducer(new ApplicationConfigTest());
        Assert.assertEquals( producer.getClass() , ProducerDefault.class);
    }
}
