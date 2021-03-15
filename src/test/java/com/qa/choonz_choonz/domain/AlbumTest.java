package com.qa.choonz_choonz.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Genre;

public class AlbumTest {

	@Test
	public void testConstructor1() {
		Artist artist = new Artist(1L, "Ed Sheeran");
		Genre genre = new Genre(1L, "Pop", "Pop music is the genre of popular music that produces the most hit");
		Album album = new Album(1L, "+", artist, genre, "Cover");
		assertEquals(Long.valueOf("1"), album.getId());
		assertEquals("+", album.getName());
		assertEquals(artist, album.getArtist());
		assertEquals(genre, album.getGenre());
		assertEquals("Cover", album.getCoverImg());
	}


	@Test
	public void testHashCode() {
		Album album = new Album(1L, "+", null, null, "Cover");
		assertEquals(album.hashCode(), album.hashCode());
	}
	

	@Test
	public void testToString() {
		Album album = new Album(1L, "+", null, null, "Cover");
		String expected = "Album(id=1, name=+, tracks=null, artist=null, genre=null, coverImg=Cover)";
		assertEquals(expected, album.toString());
	}

}
