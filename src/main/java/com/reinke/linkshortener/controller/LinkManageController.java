package com.reinke.linkshortener.controller;

import com.reinke.linkshortener.dto.CreateLinkDto;
import com.reinke.linkshortener.dto.LinkDto;
import com.reinke.linkshortener.exception.ExceptionResponse;
import com.reinke.linkshortener.exception.LinkAlreadyExistException;
import com.reinke.linkshortener.service.LinkService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@AllArgsConstructor
@RequestMapping("/links")
public class LinkManageController {

    private final LinkService service;

//    public LinkManageController(LinkService service) {
//        this.service = service;
//    }

    private final static Logger LOGGER = Logger.getLogger(LinkManageController.class.getName());


//    @PostMapping
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    ResponseEntity<?> createLink(@RequestBody CreateLinkDto link) {
//        try {
//            return ResponseEntity.created(null).body(service.createLink(link.toDto()));
//        } catch (LinkAlreadyExistException exception) {
//            LOGGER.info(exception.getMessage());
//
//            return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
//        }
//    }


    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return service.createLink(link.toDto());
    }
}
