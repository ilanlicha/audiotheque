package com.ipiecole.java.audio.audiotheque.repository;

import com.ipiecole.java.audio.audiotheque.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Boolean existsByNameAllIgnoreCase(String name);
    Page<Artist> findByNameIsContainingAllIgnoreCase(String nom, Pageable pageable);
}
