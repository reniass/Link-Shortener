package com.reinke.linkshortener;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkManageController {

    private final LinkService service;

    public LinkManageController(LinkService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return service.createLink(link.toDto());
    }
}
