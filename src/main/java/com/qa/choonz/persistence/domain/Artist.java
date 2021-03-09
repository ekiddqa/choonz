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
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 40)
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;
    
    public Artist() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Artist(long id, @NotNull @Size(max = 100) String name, List<Album> albums) {
        super();
        this.id = id;
        this.name = name;
        this.albums = albums;
    }
}
