let API_DATA = {
    API_KEY: "0a629ff23ad340cbdbf9b34544a58864",
    USER_AGENT: "QA Choonz Application"
}

let tradingArtists = document.querySelector('#trending-artists');

let createBaseTable =()=>{
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

let addToTable =(data, table)=>{
    let countNum = 1;
    for (let artist in data) {
        console.log(data[artist]);
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
    tradingArtists.append(table);
}

let getTop10 =()=>{
    let tableToAppend = createBaseTable();
    fetch("https://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=0a629ff23ad340cbdbf9b34544a58864&format=json&limit=10")
        .then((response)=>{
            (response.status !== 200) ? console.error(`Status is ${response.status}`) :
                response.json()
                    .then((data)=>{console.log(data['artists']['artist'])
                        addToTable(data['artists']['artist'], tableToAppend)})
})};

getTop10();
