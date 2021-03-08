Genre
INSERT INTO `genre` (`name`, `desc`, `track_id`) VALUES ('Soul', ' Soul combines elements of African-American gospel music, rhythm and blues and jazz');

INSERT INTO `genre` (`name`, `desc`, `track_id`) ('Pop' 'Pop music is the genre of popular music that produces the most hits');

INSERT INTO `genre` (`name`, `desc`, `track_id`) ('Rock', 'Rock has a strong beat and the presence of rock instruments such as electric guitar, electric bass, electric organ or electric piano');


Artist 
INSERT INTO `artist` (`name`, `img`, `album_id`) ('Adele', 'tbd', 1);

INSERT INTO `artist` (`name`, `img`, `album_id`) ('Ray Charles', 'tbd', 2);

INSERT INTO `artist` (`name`, `img`, `album_id`) ('Ed Sheeran', 'tbd', 3);


Album
INSERT INTO `album` (`name`, `artist_id`, `img`, `track_id`) ('21', 1, 'tbd');

INSERT INTO `album` (`name`, `artist_id`, `img`,`track_id`) ('Ray', 2, 'tbd');

INSERT INTO `album` (`name`, `artist_id`, `img`, `track_id`) ('+', 3, 'tbd');


Playlist 

INSERT INTO `playlist` (`user_id`, `dec`, `artwork`, `track_id`) (1, 'For when I am working out', 'tbd', 3);

INSERT INTO `playlist` (`user_id`, `dec`, `artwork`, `track_id`) (2, 'For meditation and sleep', 'tbd', 2);

INSERT INTO `playlist` (`user_id`, `dec`, `artwork`, `track_id`) (3, 'Parties/Hype music', 'tbd', 1);


User

INSERT INTO `user` (`user`, `hash`) ('root', 'tbd');

INSERT INTO `user` (`user`, `hash`) ('monkey', 'tbd');

INSERT INTO `user` (`user`, `hash`) ('play', 'tbd');


Track

INSERT INTO `track` (`name`, `duration`, `album_id`, `playlist_id`, `genre_id`, `lyrics`) ('Someone like you', 4.45, 1, 2, 1, 'tbd');

INSERT INTO `track` (`name`, `duration`, `album_id`, `playlist_id`, `genre_id`, `lyrics`) ('Rolling in the deep', 3.48, 1, 2, 2, 'tbd');

INSERT INTO `track` (`name`, `duration`, `album_id`, `playlist_id`, `genre_id`, `lyrics`) ('I got a woman', 2.53, 2, 3, 1, 'tbd');

INSERT INTO `track` (`name`, `duration`, `album_id`, `playlist_id`, `genre_id`, `lyrics`) ('Mess Around', 2.41, 2, 1, 2, 'tbd');

INSERT INTO `track` (`name`, `duration`, `album_id`, `playlist_id`, `genre_id`, `lyrics`) ('Lego house', 3.05, 3, 1, 3, 'tbd');

INSERT INTO `track` (`name`, `duration`, `album_id`, `playlist_id`, `genre_id`, `lyrics`) ('The A team', 4.21, 3, 2, 2, 'tbd');
