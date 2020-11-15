package com.jackie.flash.view.services;

public class ServiceException extends Exception {
    public static final String ERROR_NO_RESULTS ="There isn't a Social Network with that name" ;

    public ServiceException(String message) {
        super(message);
    }
}
