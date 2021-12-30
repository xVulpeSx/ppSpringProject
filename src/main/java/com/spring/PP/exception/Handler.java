package com.spring.PP.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Handler implements Thread.UncaughtExceptionHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.info("Exception caught!" + e.getMessage());
    }
}
