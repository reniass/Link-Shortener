package com.reinke.linkshortener.service;

import com.reinke.linkshortener.dto.LinkDto;

public interface LinkService {


    LinkDto createLink(LinkDto toDto);

    String getLink(String id);
}
