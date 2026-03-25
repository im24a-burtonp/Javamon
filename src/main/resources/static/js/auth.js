function showError(message) {
    const errorElement = document.getElementById("errorMessage");
    if (errorElement) {
        errorElement.textContent = message;
        errorElement.style.display = "block";
    }
}

async function register(event){

    event.preventDefault()

    const username = document.getElementById("regUser").value.trim();
    const password = document.getElementById("regPass").value.trim();

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
        showError("Username already exists");
    }
}

async function login(event){

    event.preventDefault();

    const username = document.getElementById("loginUser").value.trim();
    const password = document.getElementById("loginPass").value.trim();

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
        showError("Login failed");
    }
}