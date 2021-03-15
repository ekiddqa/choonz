package com.qa.choonz.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Artist;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

	@Query(value = "SELECT * FROM ARTIST WHERE NAME ~* ?1", nativeQuery = true)
	List<Artist> searchByName(String name);

}
