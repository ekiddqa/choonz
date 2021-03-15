package com.qa.choonz.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    @NotNull
    private Album album;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    // in seconds
    private int duration;

    private String lyrics;

    public Track(Long id, String name, Album album, Playlist playlist, Genre genre, int duration, String lyrics) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.playlist = playlist;
        this.genre = genre;
        this.duration = duration;
        this.lyrics = lyrics;
    }
}
