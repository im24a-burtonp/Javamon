async function register(event){

    event.preventDefault()

    const username = document.getElementById("regUser").value.trim();
    const password = document.getElementById("regPass").value.trim();

    if (username === "" || password === "") {
        alert("Fill in all fields");
        return;
    }

    const response = await fetch("/auth/register",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    });

    const result = await response.json();

    if(result) {
        window.location.href = "home.html";
    } else {
        alert("Username already exists");
    }
}

async function login(event){

    event.preventDefault();

    const username = document.getElementById("loginUser").value.trim();
    const password = document.getElementById("loginPass").value.trim();

    if (username === "" || password === "") {
        alert("Fill in all fields");
        return;
    }

    const response = await fetch("/auth/login",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    });

    const result = await response.json();

    if (result) {
       window.location.href = "home.html";
    } else {
        alert("Login failed");
    }
}