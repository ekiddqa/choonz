package com.qa.choonz.rest.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenreDTO {

    private long id;
    private String name;
    private String desc;
    private List<AlbumDTO> albums;

}
