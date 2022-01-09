package com.ipiecole.java.audio.audiotheque.model;

import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Album{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne
    @JoinColumn( name = "artist_id" )
    private Artist artist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album(){}

    public Album(String title, Artist artis){
        this.title = title;
        this.artist = artist;
    }

    /*@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Album{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", artist_id=").append(artistid);
        sb.append('}');
        return sb.toString();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(title, album.title) &&
                Objects.equals(artist, album.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artist);
    }
}
