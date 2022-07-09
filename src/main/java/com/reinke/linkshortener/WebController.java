package com.reinke.linkshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    String indexHtml() {
        return "index.html";
    }

}
