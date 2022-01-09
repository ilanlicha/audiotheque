package com.ipiecole.java.audio.audiotheque.repository;

import com.ipiecole.java.audio.audiotheque.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
