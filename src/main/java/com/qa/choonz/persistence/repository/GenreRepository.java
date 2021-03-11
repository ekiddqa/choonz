package com.qa.choonz.persistence.repository;

import com.qa.choonz.persistence.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(value = "SELECT * FROM GENRE WHERE NAME = ?1", nativeQuery = true)
    Genre searchByName(String name);

}
