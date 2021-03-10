package com.qa.choonz.persistence.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Track> tracks;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist = new Artist();

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre = new Genre();

    private String coverImg;

    public Album(Long id, String name, Artist artist, Genre genre, String coverImg) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.coverImg = coverImg;
    }
}
