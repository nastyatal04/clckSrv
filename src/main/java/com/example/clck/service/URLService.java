package com.example.clck.service;

import com.example.clck.converter.URLConverter;
import com.example.clck.domain.URLDomain;
import com.example.clck.entity.URLEntity;
import com.example.clck.repository.URLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class URLService {
    private final URLRepository repository;

    public URLDomain getURL(Long id) {
        return repository.findById(id).map(URLConverter::toDomain).orElse(null);
    }

    public List<URLDomain> getAllURL() {
        return URLConverter.toList(repository.findAll());
    }

    public URLDomain addURL(URLDomain address) {
        if(repository.findById(address.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return URLConverter.toDomain(
                repository.save(URLConverter.toEntity(address))
        );
    }

    public void deleteURL(Long id) {
        repository.deleteById(id);
    }

    public URLDomain updateURL(URLDomain domain) {
        Optional<URLEntity> urlEntity = repository.findById(domain.getId());
        urlEntity.ifPresent(repoAddress -> {
            repoAddress.setId(domain.getId());
            repoAddress.setFullURL(domain.getFullURL());
            repoAddress.setReduceURL(domain.getReduceURL());
            repository.save(repoAddress);
        });
        return urlEntity.map(URLConverter::toDomain).orElse(null);
    }
}
