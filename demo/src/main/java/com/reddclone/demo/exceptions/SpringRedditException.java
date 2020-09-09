package com.reddclone.demo.exceptions;


public class SpringRedditException extends RuntimeException {

    public SpringRedditException(String exMessage) {
        super(exMessage);
    }

    public SpringRedditException(String exMessage, Exception e) {
        super(exMessage, e);
    }
}
