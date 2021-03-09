package com.qa.choonz.persistence.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = 500)
    @Column(unique = true)
    private String desc;

    @NotNull
    @Size(max = 1000)
    @Column(unique = true)
    private String artwork;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.MERGE)
    private List<Track> tracks;

    public Playlist() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Playlist(long id, String name, String desc, String artwork, List<Track> tracks) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.artwork = artwork;
        this.tracks = tracks;
    }
}
