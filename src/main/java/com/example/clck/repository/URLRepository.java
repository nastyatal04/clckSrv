package com.example.clck.repository;

import com.example.clck.entity.URLEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URLEntity, Long> {
}
