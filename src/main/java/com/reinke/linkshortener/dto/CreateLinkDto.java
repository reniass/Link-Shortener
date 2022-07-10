package com.reinke.linkshortener.dto;

import com.reinke.linkshortener.dto.LinkDto;

import java.time.LocalDate;

public class CreateLinkDto {

    private String email;
    private String targetUrl;
    private LocalDate expirationDate;
    private String id;

    public CreateLinkDto(String email, String targetUrl, LocalDate expirationDate, String id) {
        this.email = email;
        this.targetUrl = targetUrl;
        this.expirationDate = expirationDate;
        this.id = id;
    }

    public LinkDto toDto() {
        return new LinkDto(id,
                expirationDate,
                0,
                email,
                targetUrl);
    }
}
