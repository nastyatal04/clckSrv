package com.example.clck.converter;

import com.example.clck.domain.URLDomain;
import com.example.clck.entity.URLEntity;

import java.util.List;

public class URLConverter {
    public static URLDomain toDomain(URLEntity entity) {
        return URLDomain.builder()
                .id(entity.getId())
                .fullURL(entity.getFullURL())
                .reduceURL(entity.getReduceURL())
                .build();
    }
    public static URLEntity toEntity(URLDomain address) {
        return URLEntity.builder()
                .id(address.getId())
                .fullURL(address.getFullURL())
                .reduceURL(address.getReduceURL())
                .build();
    }

    public static List<URLDomain> toList(List<URLEntity> addresses) {
        return addresses.stream().map(URLConverter::toDomain).toList();
    }
}
