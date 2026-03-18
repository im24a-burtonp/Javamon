async function checklogin(){
    const response = await fetch("/auth/me")
    const user = await response.text();

    if(!user) {
        window.location.href = "login.html";
    } else {
        console.log("Logged in as:", user)
        document.body.style.display = "flex";
    }
}

async function openParty() {
    window.location.href = "party.html"
}

document.addEventListener("DOMContentLoaded", () => {
    checklogin();
});