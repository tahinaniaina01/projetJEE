// script.js

document.addEventListener('DOMContentLoaded', function() {
    const product = {
        id: 1,
        title: "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        price: 109.95,
        description: "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        category: "men's clothing",
        image: "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    };

    document.querySelector('.product-image').src = product.image;
    document.querySelector('.product-title').textContent = product.title;
    document.querySelector('.product-price').textContent = `$${product.price}`;
    document.querySelector('.product-description').textContent = product.description;
});

function addToCart() {
    alert('Product added to cart!');
}
