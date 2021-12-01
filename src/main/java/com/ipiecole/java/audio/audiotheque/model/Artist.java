package com.ipiecole.java.audio.audiotheque.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Artist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artist_id;
    private String name;

    public Integer getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Integer artist_id) {
        this.artist_id = artist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist(){}

    public Artist(Integer artist_id, String name){
        this.artist_id = artist_id;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artist{");
        sb.append("artist_id=").append(artist_id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;

        Artist artist = (Artist) o;

        if (name != null ? !name.equals(artist.name) : artist.name != null) return false;
        return Objects.equals(artist_id, artist.artist_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist_id, name);
    }
}
