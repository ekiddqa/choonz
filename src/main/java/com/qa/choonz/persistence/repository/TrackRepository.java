package com.qa.choonz.persistence.repository;

import com.qa.choonz.persistence.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Track;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query(value = "SELECT * FROM TRACK WHERE NAME ~* ?1", nativeQuery = true)
    List<Track> searchByName(String name);

}
