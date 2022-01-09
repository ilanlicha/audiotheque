package com.ipiecole.java.audio.audiotheque.repository;

import com.ipiecole.java.audio.audiotheque.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist findByName(String name);
    Artist findByNameAllIgnoreCase(String name);
    List<Artist> findByNameStartingWithAllIgnoreCase(String name);
    //List<Artist> findByNameIsContainingAllIgnoreCase(String name);
    Boolean existsByNameAllIgnoreCase(String name);
    Page<Artist> findByNameIsContainingAllIgnoreCase(String nom, Pageable pageable);
}
