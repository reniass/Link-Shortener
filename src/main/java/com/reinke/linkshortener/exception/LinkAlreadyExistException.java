package com.reinke.linkshortener.exception;

public class LinkAlreadyExistException extends RuntimeException{

    public LinkAlreadyExistException(String id) {
        super("link with id" + id + "already exists");
    }
}
