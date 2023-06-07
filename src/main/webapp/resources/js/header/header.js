$('#get-wishlist').on('click', function () {
    var myWishlist = JSON.parse(sessionStorage.getItem("myWishlist"))
    console.log(myWishlist)
    var itemsList = myWishlist.items

    var filteredArray = itemsList.filter(function(item) {
        return item !== null && item !== undefined;
    });
    var itemsParam = filteredArray.join(',');

    $.ajax({
        data: {
            items: itemsParam
        },
        url: '/wishlist/createWishlist',
        type: 'get',
        contentType: 'application/json',
        async: false,
        success: function (data) {
            console.log(data)
            window.location.href = '/wishlist/myWishlist';
        },
        error: function (e) {
            console.log(e);
        },
    })
})