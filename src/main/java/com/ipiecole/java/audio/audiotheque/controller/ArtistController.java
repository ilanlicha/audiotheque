package com.ipiecole.java.audio.audiotheque.controller;

import com.ipiecole.java.audio.audiotheque.exception.ConflitException;
import com.ipiecole.java.audio.audiotheque.model.Artist;
import com.ipiecole.java.audio.audiotheque.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    public Artist findById(@PathVariable Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        if(artist.isPresent()){
            return artist.get();
        }
        throw new EntityNotFoundException("L'artiste d'identifiant " + id + " n'éxiste pas !");
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "name"
    )
    public Page<Artist> findByName(@RequestParam String name ,
                                   @RequestParam Integer page,
                                   @RequestParam Integer size,
                                   @RequestParam String sortProperty,
                                   @RequestParam Sort.Direction sortDirection){
        return artistRepository.findByNameIsContainingAllIgnoreCase(name,PageRequest.of(page, size, sortDirection, sortProperty));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Artist> findArtistsPaginated(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortProperty,
            @RequestParam Sort.Direction sortDirection){
        return artistRepository.findAll(PageRequest.of(page, size, sortDirection, sortProperty));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Artist createArtist(
            @RequestBody Artist artist
    )throws ConflitException {
        if (artistRepository.existsByNameAllIgnoreCase(artist.getName())){
            throw new ConflitException("Un artiste existe déjà avec le nom " + artist.getName());
        }
        return artistRepository.save(artist);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    public Artist editArtist(
            @RequestBody Artist artist
    ){
        return artistRepository.save(artist);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable Long id){
        artistRepository.deleteById(id);
    }


}
