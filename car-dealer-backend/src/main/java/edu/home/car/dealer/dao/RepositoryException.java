package edu.home.car.dealer.dao;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String s) {
        super(s);
    }

    public RepositoryException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public RepositoryException(Throwable throwable) {
        super(throwable);
    }
}
