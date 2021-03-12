// Function that hash's passwords
export let passwordToHash = async (password) => {
    const msgUint8 = new TextEncoder().encode(password);
    const hashBuffer = await crypto.subtle.digest('SHA-256', msgUint8);
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
    return hashHex;
}

// Functions relating to getting the top 10 artists from lastFM
export let getTop10 = () => {
    let tableToAppend = createBaseTable();
    fetch("https://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=0a629ff23ad340cbdbf9b34544a58864&format=json&limit=10")
        .then((response) => {
            (response.status !== 200) ? console.error(`Status is ${response.status}`) :
                response.json()
                    .then((data) => {
                        addToTable(data['artists']['artist'], tableToAppend)
                    })
        })
    return tableToAppend;
}

let createBaseTable = () => {
    const table = document.createElement('table');

    const tr = document.createElement('tr');

    const count = document.createElement('th');
    count.className = "regular-text";
    count.innerHTML = "#";

    const artistName = document.createElement('th');
    artistName.className = "regular-text";
    artistName.innerHTML = "Artist Name";

    const listenerCount = document.createElement('th');
    listenerCount.className = "regular-text";
    listenerCount.innerHTML = "Number Of Listeners";

    const link = document.createElement('th');
    link.className = "regular-text";
    link.innerHTML = "Link To Artist";

    tr.append(count, artistName, listenerCount, link);
    table.append(tr);
    return table;
}

let addToTable = (data, table) => {
    let countNum = 1;
    for (let artist in data) {
        let tr = document.createElement('tr');

        let count = document.createElement('th');
        count.className = "regular-text";
        count.innerHTML = countNum.toString();

        let artistName = document.createElement('td');
        artistName.className = "regular-text";
        artistName.innerHTML = data[artist]['name'];

        let listenerCount = document.createElement('td');
        listenerCount.className = "regular-text";
        listenerCount.innerHTML = data[artist]['listeners'];

        let link = document.createElement('td');
        link.className = "regular-text";
        link.innerHTML = data[artist]['url'];

        tr.append(count, artistName, listenerCount, link);
        table.append(tr);

        countNum += 1;
    }
}

// Table Creation for artists
export let getArtists = (name) => {
    let artistTable = createTableArtist();
    fetch(`http://localhost:8082/artists/read/name/${name}`)
        .then((response) => {
            if (response.status === 200) {
                response.json()
                    .then((data) => {
                        addToArtist(data, artistTable)
                    })
            }
        })
    return artistTable;
}

let createTableArtist = () => {
    const table = document.createElement('table');

    const tr = document.createElement('tr');

    const count = document.createElement('th');
    count.className = "regular-text";
    count.innerHTML = "#";

    const name = document.createElement('th');
    name.className = "regular-text";
    name.innerHTML = "Name";

    const album = document.createElement('th');
    album.className = "regular-text";
    album.innerHTML = "Album(s)";

    const actions = document.createElement('th');
    actions.className = "regular-text";
    actions.innerHTML = "Actions";

    tr.append(count, name, album, actions);
    table.append(tr);
    return table;
}

let addToArtist = (data, table) => {
    let countNum = 1;
    for (let artist in data) {
        let tr = document.createElement('tr');

        let count = document.createElement('th');
        count.className = "regular-text";
        count.innerHTML = countNum.toString();

        let name = document.createElement('td');
        name.className = "regular-text";
        name.innerHTML = data[artist]['name'];

        let allAlbums = "";

        for (let album in data[artist]['albums']) {
            allAlbums += data[artist]['albums'][album]['name'];
            allAlbums += ",";
        }

        allAlbums = allAlbums.replace(/(^,)|(,$)/g, "");

        let album = document.createElement('td');
        album.className = "regular-text";
        album.innerHTML = allAlbums;

        tr.append(count, name, album);
        table.append(tr);

        countNum += 1;
    }
}

// Table Creation For Genre
export let getGenres = (name) => {
    let genreTable = createTableGenre();
    fetch(`http://localhost:8082/genres/read/name/${name}`)
        .then((response) => {
            if (response.status === 200) {
                response.json()
                    .then((data) => {
                        addToGenre(data, genreTable)
                    })
            }
        })
    return genreTable;
}

let createTableGenre = () => {
    const table = document.createElement('table');

    const tr = document.createElement('tr');

    const count = document.createElement('th');
    count.className = "regular-text";
    count.innerHTML = "#";

    const name = document.createElement('th');
    name.className = "regular-text";
    name.innerHTML = "Name";

    const desc = document.createElement('th');
    desc.className = "regular-text";
    desc.innerHTML = "Description";

    const album = document.createElement('th');
    album.className = "regular-text";
    album.innerHTML = "Album(s)";

    const actions = document.createElement('th');
    actions.className = "regular-text";
    actions.innerHTML = "Actions";

    tr.append(count, name, desc, album, actions);
    table.append(tr);
    return table;
}

let addToGenre = (data, table) => {
    let countNum = 1;
    for (let genre in data) {
        let tr = document.createElement('tr');

        let count = document.createElement('th');
        count.className = "regular-text";
        count.innerHTML = countNum.toString();

        let name = document.createElement('td');
        name.className = "regular-text";
        name.innerHTML = data[genre]['name'];

        let desc = document.createElement('td');
        desc.className = "regular-text";
        desc.innerHTML = data[genre]['desc'];

        let allAlbums = "";

        for (let album in data[genre]['albums']) {
            allAlbums += data[genre]['albums'][album]['name'];
            allAlbums += ',';
        }

        allAlbums = allAlbums.replace(/(^,)|(,$)/g, "");

        let album = document.createElement('td');
        album.className = "regular-text";
        album.innerHTML = allAlbums;

        tr.append(count, name, desc, album);
        table.append(tr);

        countNum += 1;
    }
}

// Table Creation For Playlist
export let getPlaylists = (name) => {
    let playlistTable = createTablePlaylist();
    fetch(`http://localhost:8082/playlists/read/name/${name}`)
        .then((response) => {
            if (response.status === 200) {
                response.json()
                    .then((data) => {
                        addToPlaylist(data, playlistTable)
                    })
            }
        })
    return playlistTable;
}

let createTablePlaylist = () => {
    const table = document.createElement('table');

    const tr = document.createElement('tr');

    const count = document.createElement('th');
    count.className = "regular-text";
    count.innerHTML = "#";

    const name = document.createElement('th');
    name.className = "regular-text";
    name.innerHTML = "Name";

    const desc = document.createElement('th');
    desc.className = "regular-text";
    desc.innerHTML = "Description";

    const tracks = document.createElement('th');
    tracks.className = "regular-text";
    tracks.innerHTML = "Track(s)";

    const actions = document.createElement('th');
    actions.className = "regular-text";
    actions.innerHTML = "Actions";

    tr.append(count, name, desc, tracks, actions);
    table.append(tr);
    return table;
}

let addToPlaylist = (data, table) => {
    let countNum = 1;
    for (let playlist in data) {
        let tr = document.createElement('tr');

        let count = document.createElement('th');
        count.className = "regular-text";
        count.innerHTML = countNum.toString();

        let name = document.createElement('td');
        name.className = "regular-text";
        name.innerHTML = data[playlist]['name'];

        let desc = document.createElement('td');
        desc.className = "regular-text";
        desc.innerHTML = data[playlist]['desc'];

        let allTracks = "";

        for (let track in data[playlist]['tracks']) {
            allTracks += data[playlist]['tracks'][track]['name'];
            allTracks += ',';
        }

        allTracks = allTracks.replace(/(^,)|(,$)/g, "");

        let tracks = document.createElement('td');
        tracks.className = "regular-text";
        tracks.innerHTML = allTracks;

        tr.append(count, name, desc, tracks);
        table.append(tr);

        countNum += 1;
    }
}

// Table Creation For Albums
export let getAlbums = (name) => {
    let albumsTable = createTableAlbums();
    fetch(`http://localhost:8082/albums/read/name/${name}`)
        .then((response) => {
            if (response.status === 200) {
                response.json()
                    .then((data) => {
                        addToAlbum(data, albumsTable)
                    })
            }
        })
    return albumsTable;
}

let createTableAlbums = () => {
    const table = document.createElement('table');

    const tr = document.createElement('tr');

    const count = document.createElement('th');
    count.className = "regular-text";
    count.innerHTML = "#";

    const name = document.createElement('th');
    name.className = "regular-text";
    name.innerHTML = "Name";

    const tracks = document.createElement('th');
    tracks.className = "regular-text";
    tracks.innerHTML = "Track(s)";

    const artist = document.createElement('th');
    artist.className = "regular-text";
    artist.innerHTML = "Artist";

    const genre = document.createElement('th');
    genre.className = "regular-text";
    genre.innerHTML = "Genre";

    const actions = document.createElement('th');
    actions.className = "regular-text";
    actions.innerHTML = "Actions";

    tr.append(count, name, tracks, artist, genre, actions);
    table.append(tr);
    return table;
}

let addToAlbum = (data, table) => {
    let countNum = 1;
    for (let album in data) {
        let tr = document.createElement('tr');

        let count = document.createElement('th');
        count.className = "regular-text";
        count.innerHTML = countNum.toString();

        let name = document.createElement('td');
        name.className = "regular-text";
        name.innerHTML = data[album]['name'];

        let allTracks = "";

        for (let track in data[album]['tracks']) {
            allTracks += data[album]['tracks'][track]['name'];
            allTracks += ',';
        }

        allTracks = allTracks.replace(/(^,)|(,$)/g, "");

        let tracks = document.createElement('td');
        tracks.className = "regular-text";
        tracks.innerHTML = allTracks;

        let artist = document.createElement('td');
        artist.className = "regular-text";
        fetch('artists/read')
            .then((response)=>{
                return response.json();
            }).then((responseData)=>{
            let albumLookingFor = data[album]['name'];
            for (let artistLocal in responseData) {
                    let artistName = responseData[artistLocal]['name'];
                    for (let albumLocal in responseData[artistLocal]['albums']) {
                        let albumName = responseData[artistLocal]['albums'][albumLocal]['name'];
                        if (albumLookingFor === albumName) {
                            artist.innerHTML = artistName;
                            break;
                        }
                    }
                }
        })

        let genre = document.createElement('td');
        genre.className = "regular-text";
        fetch('genres/read')
            .then((response)=>{
                return response.json();
            }).then((responseData)=>{
            let albumLookingFor = data[album]['name'];
            for (let genreLocal in responseData) {
                let genreName = responseData[genreLocal]['name'];
                for (let albumLocal in responseData[genreLocal]['albums']) {
                    let albumName = responseData[genreLocal]['albums'][albumLocal]['name'];
                    if (albumLookingFor === albumName) {
                        genre.innerHTML = genreName;
                        break;
                    }
                }
            }
        })

        tr.append(count, name, tracks, artist, genre);
        table.append(tr);

        countNum += 1;
    }
}

// Table Creation For Tracks
export let getTracks = (name) => {
    let tracksTable = createTableTracks();
    fetch(`http://localhost:8082/tracks/read/name/${name}`)
        .then((response) => {
            if (response.status === 200) {
                response.json()
                    .then((data) => {
                        addToTrack(data, tracksTable)
                    })
            }
        })
    return tracksTable;
}

let createTableTracks = () => {
    const table = document.createElement('table');

    const tr = document.createElement('tr');

    const count = document.createElement('th');
    count.className = "regular-text";
    count.innerHTML = "#";

    const name = document.createElement('th');
    name.className = "regular-text";
    name.innerHTML = "Name";

    const duration = document.createElement('th');
    duration.className = "regular-text";
    duration.innerHTML = "Duration";

    const actions = document.createElement('th');
    actions.className = "regular-text";
    actions.innerHTML = "Actions";

    tr.append(count, name, duration, actions);
    table.append(tr);
    return table;
}

let addToTrack = (data, table) => {
    let countNum = 1;
    for (let track in data) {
        let tr = document.createElement('tr');

        let count = document.createElement('th');
        count.className = "regular-text";
        count.innerHTML = countNum.toString();

        let name = document.createElement('td');
        name.className = "regular-text";
        name.innerHTML = data[track]['name'];

        let duration = document.createElement('td');
        duration.className = "regular-text";
        duration.innerHTML = data[track]['duration'];

        tr.append(count, name, duration);
        table.append(tr);

        countNum += 1;
    }
}