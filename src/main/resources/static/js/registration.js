let register =()=>{
    let username = document.querySelector('#username-input');
    let password = document.querySelector('#password-input');
    let passwordRe = document.querySelector('#re-enter-password-input');

    let usernameValue = username.value;
    let passwordValue = password.value;
    let passwordReValue = passwordRe.value;

    if (passwordValue !== passwordReValue) {
        console.error('Passwords do not match try again');
    }

    else {
        passwordToHash(passwordValue)
            .then((passwordHash)=>{
                let bodyObj = {'username': usernameValue, 'hash': passwordHash};
                console.log(bodyObj);
            })
            .then(()=>{
                username.value = '';
                password.value = '';
                passwordRe.value = '';
            })
        // TODO make fetch request to link up JS with server
            .then(()=>{
                window.location.replace('../index.html')
            })
    }
}

let passwordToHash = async (password)=>{
    const msgUint8 = new TextEncoder().encode(password);
    const hashBuffer = await crypto.subtle.digest('SHA-256', msgUint8);
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
    return hashHex;
}

let submitButton = document.querySelector('#submit-detail-button');
submitButton.addEventListener('click', register);
