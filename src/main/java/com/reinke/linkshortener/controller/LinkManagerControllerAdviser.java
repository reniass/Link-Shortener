package com.reinke.linkshortener.controller;

import com.reinke.linkshortener.exception.ExceptionResponse;
import com.reinke.linkshortener.exception.LinkAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class LinkManagerControllerAdviser {

    @ExceptionHandler(LinkAlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ExceptionResponse handleBusinessException(LinkAlreadyExistException e, WebRequest request) {
        return new ExceptionResponse(e.getMessage());
    }
}
