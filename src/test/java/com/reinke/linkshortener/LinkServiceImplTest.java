package com.reinke.linkshortener;

import com.reinke.linkshortener.dto.LinkDto;
import com.reinke.linkshortener.exception.LinkAlreadyExistException;
import com.reinke.linkshortener.service.LinkService;
import com.reinke.linkshortener.service.LinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkServiceImplTest {


    @Test
    void shouldNotCreateShortenedLinkInCaseOfOccupiedIdentifier() {
        // given
        LinkService service = new LinkServiceImpl();
        LinkDto linkDto = new LinkDto("some ID", null, 0, "test@gmail.com", "http://google.com");
        service.createLink(linkDto);
        // when
        Assertions.assertThrows(LinkAlreadyExistException.class, () -> service.createLink(new LinkDto("some ID", null, 1, "email@test.pl", "https://bing.com")));
    }
}