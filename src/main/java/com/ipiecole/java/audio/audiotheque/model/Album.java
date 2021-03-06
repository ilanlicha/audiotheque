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
    @Column(name = "artist_id")
    private Integer artistid;

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

    public Integer getArtist_id() {
        return artistid;
    }

    public void setArtist_id(Integer artist_id) {
        this.artistid = artist_id;
    }

    public Album(){}

    public Album(Integer id, String title, Integer artist_id){
        this.id = id;
        this.title = title;
        this.artistid = artist_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Album{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", artist_id=").append(artistid);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album album = (Album) o;

        if (!Objects.equals(id, album.id)) return false;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        return Objects.equals(artistid, album.artistid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artistid);
    }
}
