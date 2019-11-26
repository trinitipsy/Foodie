package com.foodie.exception;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class Handler implements Thread.UncaughtExceptionHandler {
    private static Logger LOGGER = (Logger) LoggerFactory.getLogger(Handler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.info("Unhandled exception caught");

    }
}
