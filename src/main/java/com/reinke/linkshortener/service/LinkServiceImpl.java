package com.reinke.linkshortener.service;

import com.reinke.linkshortener.exception.LinkAlreadyExistException;
import com.reinke.linkshortener.dto.LinkDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    private Map<String, LinkDto> dtoMap = new HashMap<>();

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        // to Dto get Id
        if (dtoMap.get(linkDto) != null) {
            throw new LinkAlreadyExistException(linkDto.getId());
        }

        dtoMap.put(linkDto.getId(), linkDto);

        return linkDto;
    }

    @Override
    public String getLink(String id) {
        return dtoMap.get(id).getTargetUrl();
    }

}
