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
    let cart = JSON.parse(localStorage.getItem("cart")) || [];

    cart.push({
        name: productName,
        price: price
    });

    localStorage.setItem("cart", JSON.stringify(cart));

    alert(productName + " added to cart!");
}
