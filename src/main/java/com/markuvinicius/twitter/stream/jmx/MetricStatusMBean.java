package com.markuvinicius.twitter.stream.jmx;

import javax.management.MXBean;

@MXBean
public interface MetricStatusMBean {
    Integer getNumberOfTwitterStatusReceived();
    Integer getNumberOfTwitterStatusDispatched();
    Integer getNumberOfProducerExceptions();
    Integer getNumberOfTwitterStreamExceptions();
}
