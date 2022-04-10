package com.markuvinicius.twitter.stream.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyConfigurationException extends RuntimeException{
    private final Logger logger = LoggerFactory.getLogger(PropertyConfigurationException.class);

    public PropertyConfigurationException(String message){
        super(message);
        logger.error(message);
    }
}
