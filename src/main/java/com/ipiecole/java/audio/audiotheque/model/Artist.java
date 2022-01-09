package com.ipiecole.java.audio.audiotheque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Artist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnoreProperties("artist")
    @OneToMany(mappedBy = "artist")
    private Set<Album> albums = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Artist(){}

    public Artist(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artist{");
        sb.append("id=").append(id);
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
        return Objects.equals(id, artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
