package com.qa.choonz.persistence.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Genre [id=").append(id).append(", name=").append(name).append(", description=")
                .append(desc).append(", albums=").append(tracks).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(tracks, desc, id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) obj;
        return Objects.equals(tracks, other.tracks) && Objects.equals(desc, other.desc) && id == other.id
                && Objects.equals(name, other.name);
    }

}
