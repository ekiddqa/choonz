package com.qa.choonz.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Playlist;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

	@Query(value = "SELECT * FROM PLAYLIST WHERE NAME ~* ?1", nativeQuery = true)
	List<Playlist> searchByName(String name);

}
