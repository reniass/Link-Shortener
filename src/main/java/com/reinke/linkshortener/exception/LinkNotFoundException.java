package com.reinke.linkshortener.exception;

public class LinkNotFoundException extends RuntimeException{

    public LinkNotFoundException(String id) {
        super("link with id" + id + "does't exist");
    }


}
