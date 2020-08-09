const navLinks = document.querySelectorAll(".nav-link");

for(let link of navLinks) {
    if(link.getAttribute("href") === window.location.pathname) {
        link.classList.add("active");
    }
}