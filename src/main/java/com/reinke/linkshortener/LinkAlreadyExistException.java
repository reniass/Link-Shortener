package com.reinke.linkshortener;

public class LinkAlreadyExistException extends RuntimeException{

    public LinkAlreadyExistException(String id) {
        super("link with id" + id + "already exists");
    }
}
