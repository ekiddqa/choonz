let login =()=>{
    let username = document.querySelector('#username-input');
    let password = document.querySelector('#password-input');

    let usernameValue = username.value;
    let passwordValue = password.value;

    passwordToHash(passwordValue)
        .then((passwordHash)=>{
        let bodyObj = {'username': usernameValue, 'hash': passwordHash};
        console.log(bodyObj)
        })
        // TODO Give these login details to the login endpoint and see if login is successful
        .then(()=>{
            username.value = '';
            password.value = '';
        })
        .then(()=>{
            window.location.replace('../index.html');
        })
}


let passwordToHash = async (password)=>{
    const msgUint8 = new TextEncoder().encode(password);
    const hashBuffer = await crypto.subtle.digest('SHA-256', msgUint8);
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
    return hashHex;
}

let submitButton = document.querySelector('#submit-detail-button');
submitButton.addEventListener('click', login);


