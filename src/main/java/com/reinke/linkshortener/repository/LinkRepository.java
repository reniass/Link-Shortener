package com.reinke.linkshortener.repository;

import com.reinke.linkshortener.entity.LinkEntity;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<LinkEntity, String> {
}
