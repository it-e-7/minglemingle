$('#wishlist-btn').on('click', function () {
    var sessionObject = JSON.parse(sessionStorage.getItem("myWishlist")) || { items: [] };

    var productCode = $('#product-code').text();

    if (!sessionObject.items.includes(productCode)) {
        sessionObject.items.push(productCode);
    }

    sessionStorage.setItem("myWishlist", JSON.stringify(sessionObject));

    var sessionData = JSON.stringify(sessionStorage);
    console.log(sessionData);
});

function copyCurrentLocationToClipboard() {
    copyToClipboard(window.location.href)
}
