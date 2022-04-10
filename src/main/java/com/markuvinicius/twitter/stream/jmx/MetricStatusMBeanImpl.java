package com.markuvinicius.twitter.stream.jmx;

public class MetricStatusMBeanImpl implements MetricStatusMBean{
    private Integer numberOfTwitterStatusReceived;
    private Integer numberOfTwitterStatusDispatched;
    private Integer numberOfProducerExceptions;
    private Integer numberOfTwitterStreamExceptions;

    private static MetricStatusMBeanImpl instance;

    public synchronized void incrementNumberOfTwitterStatusReceived(){
        this.numberOfTwitterStatusReceived++;
    }

    public synchronized void incrementNumberOfTwitterStatusDispatched(){
        this.numberOfTwitterStatusDispatched++;
    }

    public synchronized void incrementNumberOfProducerExceptions(){
        this.numberOfProducerExceptions++;
    }

    public synchronized void incrementNumberOfTwitterStreamExceptions(){
        this.numberOfTwitterStreamExceptions++;
    }

    public static MetricStatusMBeanImpl getInstance(){
        if ( instance == null ) instance = new MetricStatusMBeanImpl();
        return instance;
    }

    public MetricStatusMBeanImpl() {
        this.numberOfProducerExceptions = 0;
        this.numberOfTwitterStatusDispatched = 0;
        this.numberOfTwitterStatusReceived = 0;
        this.numberOfTwitterStreamExceptions = 0;
    }

    @Override
    public Integer getNumberOfTwitterStatusReceived() {
        return numberOfTwitterStatusReceived;
    }

    @Override
    public  Integer getNumberOfTwitterStatusDispatched() {
        return numberOfTwitterStatusDispatched;
    }

    @Override
    public Integer getNumberOfProducerExceptions() {
        return numberOfProducerExceptions;
    }

    @Override
    public  Integer getNumberOfTwitterStreamExceptions() {
        return numberOfTwitterStreamExceptions;
    }

}
