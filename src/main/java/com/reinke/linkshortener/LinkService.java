package com.reinke.linkshortener;

public interface LinkService {


    LinkDto createLink(LinkDto toDto);

    String getLink(String id);
}
