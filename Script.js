function login(event) {
    event.preventDefault();

    window.location.href = "home.html";
}

function shopNow() {
    document.querySelector(".products").scrollIntoView({
        behavior: "smooth"
    });
}

function addToCart(productName, price) {
    alert(productName + " added to cart!");
}