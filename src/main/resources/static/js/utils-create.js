export let additionLink = (type) => {
    let button = document.createElement('button');
    button.className = "button-as-link";
    button.innerText = "Not seeing what you want? (Add You Own)";
    button.addEventListener("click", () => {
        buttonAction(type)
    });
    return button;
}

let buttonAction = (type) => {
    if (type === "Artist") {
        createArtist();
    } else if (type === "Genre") {
        createGenre();
    } else if (type === "Playlist") {
        createPlaylist();
    }
}

let createArtist = () => {

    let table = document.querySelector('#results-table');

    let tr = document.createElement('tr');
    tr.id = "input-row";

    let col1 = document.createElement('td');
    col1.className = "regular-text"
    col1.innerHTML = "NEW";

    let col2 = document.createElement('td');

    let name = document.createElement('input');
    name.className = "form-control";
    name.id = "artist-name";

    col2.append(name);

    let col3 = document.createElement('td');
    col3.className = "regular-text";
    col3.innerHTML = "N/A"

    let col4 = document.createElement('td');

    let confirm = document.createElement('button');
    confirm.className = "confirm";
    confirm.innerHTML = `&#10004`;
    confirm.addEventListener("click", confirmCreateArtist);

    let cancel = document.createElement('button');
    cancel.className = "cancel";
    cancel.innerHTML = `&#10006`;
    cancel.addEventListener("click", () => {
        cancelCreate()
    });

    col4.append(confirm, cancel);

    tr.append(col1, col2, col3, col4);
    table.append(tr);
}

let createGenre = () => {

    let table = document.querySelector('#results-table');

    let tr = document.createElement('tr');
    tr.id = "input-row";

    let col1 = document.createElement('td');
    col1.className = "regular-text"
    col1.innerHTML = "NEW";

    let col2 = document.createElement('td');

    let name = document.createElement('input');
    name.className = "form-control";
    name.id = "genre-name";

    col2.append(name);

    let col3 = document.createElement('td');

    let desc = document.createElement('input');
    desc.className = "form-control";
    desc.id = "genre-desc";

    col3.append(desc);

    let col4 = document.createElement('td');
    col4.className = "regular-text";
    col4.innerHTML = "N/A";

    let col5 = document.createElement('td');

    let confirm = document.createElement('button');
    confirm.className = "confirm";
    confirm.innerHTML = `&#10004`;
    confirm.addEventListener("click", confirmCreateGenre);

    let cancel = document.createElement('button');
    cancel.className = "cancel";
    cancel.innerHTML = `&#10006`;
    cancel.addEventListener("click", () => {
        cancelCreate()
    });

    col5.append(confirm, cancel);

    tr.append(col1, col2, col3, col4, col5);
    table.append(tr);
}

let createPlaylist = () => {

    let table = document.querySelector('#results-table');

    let tr = document.createElement('tr');
    tr.id = "input-row";

    let col1 = document.createElement('td');
    col1.className = "regular-text"
    col1.innerHTML = "NEW";

    let col2 = document.createElement('td');

    let name = document.createElement('input');
    name.className = "form-control";
    name.id = "playlist-name";

    col2.append(name);

    let col3 = document.createElement('td');

    let desc = document.createElement('input');
    desc.className = "form-control";
    desc.id = "playlist-desc";

    col3.append(desc);

    let col4 = document.createElement('td');
    col4.className = "regular-text";
    col4.innerHTML = "N/A";

    let col5 = document.createElement('td');

    let confirm = document.createElement('button');
    confirm.className = "confirm";
    confirm.innerHTML = `&#10004`;
    confirm.addEventListener("click", confirmCreatePlaylist);

    let cancel = document.createElement('button');
    cancel.className = "cancel";
    cancel.innerHTML = `&#10006`;
    cancel.addEventListener("click", () => {
        cancelCreate()
    });

    col5.append(confirm, cancel);

    tr.append(col1, col2, col3, col4, col5);
    table.append(tr);
}

// let createAlbum = () => {
//
//     let table = document.querySelector('#results-table');
//
//     let tr = document.createElement('tr');
//
//     let col1 = document.createElement('td');
//     col1.className = "regular-text"
//     col1.innerHTML = "NEW";
//
//     let col2 = document.createElement('td');
//
//     let name = document.createElement('input');
//     name.className = "form-control";
//     name.id = "album-name";
//
//     col2.append(name);
//
//     let col3 = document.createElement('td');
//     col3.className = "regular-text";
//     col3.innerHTML = "N/A";
//
//     let col4 = document.createElement('td');
//
//     let confirm = document.createElement('button');
//     confirm.className = "confirm";
//     confirm.innerHTML = `&#10004`;
//     confirm.addEventListener("click", confirmCreatePlaylist);
//
//     let cancel = document.createElement('button');
//     cancel.className = "cancel";
//     cancel.innerHTML = `&#10006`;
//     cancel.addEventListener("click", () => {
//         cancelCreate()
//     });
//
//     col4.append(confirm, cancel);
//
//     tr.append(col1, col2, col3, col4);
//     table.append(tr);

let cancelCreate = () => {
    let resultsTable = document.querySelector('#results-table');
    resultsTable.removeChild(document.querySelector('#input-row'));
}

let confirmCreateArtist = () => {
    let artistName = document.querySelector('#artist-name').value;
    let bodyObj = {'name': artistName};
    fetch('artists/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyObj)
    }).then(() => {
        cancelCreate()
    })
        .finally(() => {
            let searchButton = document.querySelector('#search-button');
            searchButton.click();
        })
}

let confirmCreateGenre = () => {
    let genreName = document.querySelector('#genre-name').value;
    let genreDesc = document.querySelector('#genre-desc').value;
    let bodyObj = {'name': genreName, 'desc': genreDesc};
    fetch('genres/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyObj)
    }).then(() => {
        cancelCreate()
    })
        .finally(() => {
            let searchButton = document.querySelector('#search-button');
            searchButton.click();
        })
}

let confirmCreatePlaylist =()=>{
    let playlistName = document.querySelector('#playlist-name').value;
    let playlistDesc = document.querySelector('#playlist-desc').value;
    let artwork = 'NOT IMPLEMENTED YET';
    let bodyObj = {'name': playlistName, 'desc': playlistDesc, 'artwork': artwork};
    fetch('playlists/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyObj)
    }).then(() => {
        cancelCreate()
    })
        .finally(() => {
            let searchButton = document.querySelector('#search-button');
            searchButton.click();
        })
}

// let confirmCreateAlbum =()=>{
//     let albumName = document.querySelector('#album-name').value;
//
// }
