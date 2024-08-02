package com.example.repository;

import com.example.enity.WikiData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiDataRepository extends JpaRepository<WikiData,Long> {
}
