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