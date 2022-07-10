package com.reinke.linkshortener;

import com.reinke.linkshortener.dto.LinkDto;
import com.reinke.linkshortener.entity.LinkEntity;
import com.reinke.linkshortener.exception.LinkAlreadyExistException;
import com.reinke.linkshortener.exception.LinkNotFoundException;
import com.reinke.linkshortener.repository.LinkRepository;
import com.reinke.linkshortener.service.LinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {

    @Mock
    LinkRepository repository;
    @InjectMocks
    LinkServiceImpl linkService;

    @Test
    void shouldNotCreateShortenedLinkInCaseOfOccupiedIdentifier() {
        // given
        LinkDto linkDto = new LinkDto("some ID", null, 0, "test@gmail.com", "http://google.com");

        given(repository.findById("krzysztof")).willReturn(Optional.of(LinkEntity.fromDto(linkDto)));

        linkService.createLink(linkDto);
        // when
        Assertions.assertThrows(LinkAlreadyExistException.class, () -> linkService.createLink(new LinkDto("some ID", null, 1, "email@test.pl", "https://bing.com")));
    }

    @Test
    void shouldCreateShortenedLinkInCaseOfOccupiedIdentifier() {
        // given
        LinkDto linkDto = new LinkDto("some ID", null, 0, "test@gmail.com", "http://google.com");
        linkService.createLink(linkDto);
        // when
        Assertions.assertThrows(LinkAlreadyExistException.class, () -> linkService.createLink(new LinkDto("some ID", null, 1, "email@test.pl", "https://bing.com")));
    }

    @Test
    void shouldThrowLinkNotFoundExceptionInCaseOfLinkNotFound() {
        // given
        String id = "test";
        given(repository.findById(id)).willReturn(Optional.empty());
        // then
        Assertions.assertThrows(LinkNotFoundException.class, () -> linkService.getLink(id));
    }

    @Test
    void shouldIncrementVisitsNumberOnEntry() {
        //given
        String id = "test";

    }

}