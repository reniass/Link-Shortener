package com.reinke.linkshortener.controller;

import com.reinke.linkshortener.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/s")
public class RedirectController {

    private final LinkService linkService;

//    public RedirectController(LinkService linkService) {
//        this.linkService = linkService;
//    }

    @GetMapping("/{id}")
    public void redirectLink(@PathVariable("id") String id,
                             HttpServletResponse httpServletResponse
                             ) throws IOException {
        httpServletResponse.sendRedirect(linkService.getLink(id));
    }
}
