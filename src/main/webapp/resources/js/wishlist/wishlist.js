$('#share-to-chat').on('click', function () {
    var myWishlist = JSON.parse(sessionStorage.getItem("myWishlist"))
    console.log(myWishlist)
    var itemsList = myWishlist.items

    var filteredArray = itemsList.filter(function(item) {
        return item !== null && item !== undefined;
    });
    console.log(filteredArray)
    $.ajax({
        data: {
            productCodeList: filteredArray
        },
        url: '/wishlist',
        type: 'post',
        contentType: 'application/json',
        async: false,
        success: function (data) {
            console.log(data)
        },
        error: function (e) {
            console.log(e);
        },
    })
})