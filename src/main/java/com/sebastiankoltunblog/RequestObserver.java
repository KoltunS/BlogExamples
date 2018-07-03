package com.sebastiankoltunblog;

import org.apache.log4j.Logger;

import javax.enterprise.event.Observes;

public class RequestObserver {
    private static final Logger logger = Logger.getLogger(RequestObserver.class);

    public void printDetails(@Observes String uri) {
        logger.info("Request received: " + uri);
    }
}
