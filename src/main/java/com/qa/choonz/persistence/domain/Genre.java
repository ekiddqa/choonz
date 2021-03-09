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
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = 450)
    @Column(unique = true)
    private String desc;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Track> tracks;

    public Genre() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Genre(long id, @NotNull @Size(max = 100) String name, @NotNull @Size(max = 450) String desc,
            List<Track> tracks) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.tracks = tracks;
    }

}
