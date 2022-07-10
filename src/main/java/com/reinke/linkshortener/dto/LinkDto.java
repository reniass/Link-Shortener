package com.reinke.linkshortener.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@Getter
@Builder
public class LinkDto {

    private String id;
    private LocalDate expirationDate;
    private int visits;
    private String email;
    private String targetUrl;

    public LinkDto(String id, LocalDate expirationDate, int visits, String email, String targetUrl) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.visits = visits;
        this.email = email;
        this.targetUrl = targetUrl;
    }

    public String getShortenedLink() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/s/{id}")
                .buildAndExpand(id)
                .toUriString();
    }

}
