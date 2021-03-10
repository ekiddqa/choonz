package com.qa.choonz.persistence.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@NoArgsConstructor
@Data
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Track> tracks;

    public Playlist(Long id, String name, String desc, String artwork) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.artwork = artwork;
    }
}
