INSERT INTO ARTIST(name) VALUES ('testArtist');
INSERT INTO GENRE(name, desc) VALUES ('testGenre', 'test Desc');
INSERT INTO ALBUMS(name, artist_id, genre_id) VALUES ('testAlbum', 1, 1);
INSERT INTO TRACKS(name, album_id, genre_id) VALUES('testTrack', 1, 1);
INSERT INTO PLAYLIST(name, desc, artwork) VALUES('testPlaylist', 'test Desc', 'testArtwork');