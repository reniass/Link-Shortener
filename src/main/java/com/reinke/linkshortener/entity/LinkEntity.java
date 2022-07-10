package com.reinke.linkshortener.entity;

import com.reinke.linkshortener.dto.LinkDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkEntity {

    @Id
    private String id;
    private LocalDate expirationDate;
    private int visits;
    private String email;
    private String targetUrl;

    public static LinkEntity fromDto(LinkDto linkDto) {
        return LinkEntity.builder()
                .id(linkDto.getId())
                .email(linkDto.getEmail())
                .targetUrl(linkDto.getTargetUrl())
                .expirationDate(linkDto.getExpirationDate())
                .visits(linkDto.getVisits())
                .build();
    }

    public LinkDto toDto() {
        return LinkDto.builder()
                .id(id)
                .expirationDate(expirationDate)
                .visits(visits)
                .email(email)
                .targetUrl(targetUrl)
                .build();
    }
}
