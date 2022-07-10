package com.reinke.linkshortener.service;

import com.reinke.linkshortener.entity.LinkEntity;
import com.reinke.linkshortener.exception.LinkAlreadyExistException;
import com.reinke.linkshortener.dto.LinkDto;
import com.reinke.linkshortener.exception.LinkNotFoundException;
import com.reinke.linkshortener.repository.LinkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LinkServiceImpl implements LinkService {

    //private Map<String, LinkDto> dtoMap = new HashMap<>();
    private final LinkRepository repository;

    public LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        // to Dto get Id
        if (repository.findById(linkDto.getId()).isPresent()) {
            throw new LinkAlreadyExistException(linkDto.getId());
        }


        repository.save(LinkEntity.fromDto(linkDto));

        return linkDto;
    }

    @Override
    @Transactional
    public String getLink(String id) {


        LinkEntity linkEntity = repository
                .findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id));


        linkEntity.setVisits(linkEntity.getVisits() + 1);
        return linkEntity.getTargetUrl();
      //  return repository.findById(id);
    }

    @Override
    public LinkDto getLinkDto(String id) {

       return repository
                .findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id)).toDto();

    }


//
//    @Overrideid
//    public LinkDto createLink(LinkDto linkDto) {
//        // to Dto get Id
//        if (dtoMap.get(linkDto) != null) {
//            throw new LinkAlreadyExistException(linkDto.getId());
//        }
//
//        dtoMap.put(linkDto.getId(), linkDto);
//
//        return linkDto;
//    }
//
//    @Override
//    public String getLink(String id) {
//        return dtoMap.get(id).getTargetUrl();
//    }

}
