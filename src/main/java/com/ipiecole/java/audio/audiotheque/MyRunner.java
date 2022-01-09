package com.ipiecole.java.audio.audiotheque;

import com.ipiecole.java.audio.audiotheque.model.Album;
import com.ipiecole.java.audio.audiotheque.model.Artist;
import com.ipiecole.java.audio.audiotheque.repository.AlbumRepository;
import com.ipiecole.java.audio.audiotheque.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner {

   /* @Autowired
    AlbumRepository albumRepository;
*/
    @Autowired
    ArtistRepository artistRepository;

    @Override
    public void run(String... strings) throws Exception {
        /*Artist ar1 = new Artist(1,"test1");
        Artist ar2 = new Artist(1,"test1");
        Artist ar3 = new Artist(2,"coucou");

        Album al1 = new Album(1,"test2",1);
        Album al2 = new Album(1,"test2",1);
        Album al3 = new Album(1,"yo",2);

        print("ar1 = ar2 ? " + ar1.equals(ar2));
        print("ar1 = ar3 ? " + ar1.equals(ar3));
        print("al1 = al2 ? " + al1.equals(al2));
        print("al1 = al3 ? " + al1.equals(al3));

        print("ar1 hash : " + ar1.hashCode());
        print("ar2 hash : " + ar2.hashCode());
        print("ar3 hash : " + ar3.hashCode());*/


        //print(artistRepository.findAll());
        List<Artist> artists = artistRepository.findAll();
        for(Artist ar : artists){
            print(ar);
        }
        /*Artist artist = artistRepository.findByName("Accept");
        print(artist);*/
        /*List<Album> albums = albumRepository.findAll();
        for(Album al : albums){
            print(al);
        }*/
        /*List<Album> albums = albumRepository.findByTitle("Balls to the Wall");
        for(Album al : albums){
            print(al);
        }*/
        /*ist<Album> albums = albumRepository.findByArtistid(58);
        for(Album al : albums){
            print(al);
        }*/

        /*List<Artist> artists = artistRepository.findByNameStartingWithAllIgnoreCase("a");
        for(Artist ar : artists){
            print(ar);
        }*/

        /*Artist artist = artistRepository.findByNameAllIgnoreCase("Alberto Turco & nov Schola Gregoriana");
        print(artist);*/

        /*List<Artist> artists = artistRepository.findByNameIsContainingAllIgnoreCase("a");
        for(Artist ar : artists) {
            print(ar);
        }*/



    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
