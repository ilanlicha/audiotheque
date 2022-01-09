package com.ipiecole.java.audio.audiotheque.controller;

import com.ipiecole.java.audio.audiotheque.model.Album;
import com.ipiecole.java.audio.audiotheque.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Album add(@RequestBody Album formAlbum){
        Album album = albumRepository.save(formAlbum);
        return album;
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        albumRepository.delete(albumRepository.getById(id));
    }
}
