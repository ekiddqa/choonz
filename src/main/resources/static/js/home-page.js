import {getTop10} from './utils.js'

let auth = sessionStorage.getItem('auth');

if (auth == null) {
    console.log("No Auth");
    let centreCol = document.querySelector('#centre-col');

    let header = document.createElement('div');
    header.innerHTML = "<span class=\"regular-text\" style=\"float: left\">Trending Artists</span>" +
        "               <span class=\"regular-text\" style=\"float: right\">Gathered From LastFM</span>" +
        "               <br>"
    centreCol.append(header);

    let trending = document.createElement('div');

    let topTenTable = getTop10();
    trending.append(topTenTable);

    centreCol.append(trending);
} else {
    console.log("Logged In");
    let centreCol = document.querySelector('#centre-col');
    centreCol.innerHTML = "";
}

let search =()=>{
    let category = document.querySelector('#select-bar').value;
}