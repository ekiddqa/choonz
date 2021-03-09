package com.qa.choonz.persistence.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Track> tracks;

    @ManyToOne
    private Artist artist;
    
    private String coverImg;

    public Album() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Album(long id, @NotNull @Size(max = 100) String name, List<Track> tracks, Artist artist,
            String coverImg) {
        super();
        this.id = id;
        this.name = name;
        this.tracks = tracks;
        this.artist = artist;
        this.coverImg = coverImg;
    }

}
