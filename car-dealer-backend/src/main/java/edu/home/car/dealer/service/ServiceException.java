package edu.home.car.dealer.service;

public class ServiceException extends RuntimeException {

    public ServiceException(String s) { super(s); }

    public ServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }
}
