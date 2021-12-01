package com.ipiecole.java.audio.audiotheque.repository;

import com.ipiecole.java.audio.audiotheque.model.Album;
import com.ipiecole.java.audio.audiotheque.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByTitle(String title);
    List<Album> findByArtistid(Integer artist_id);
}
