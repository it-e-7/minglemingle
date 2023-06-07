function generateUUID() {
    var d = new Date().getTime();
    var uuid = 'xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random() * 16) % 16 | 0;
        d = Math.floor(d / 16);
        return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    });
    return uuid;
}

$('#share-to-chat').on('click', function (e) {
    e.preventDefault();

    var myWishlist = JSON.parse(sessionStorage.getItem("myWishlist"))
    var itemsList = myWishlist.items
    var filteredArray = itemsList.filter(function(item) {
        return item !== null && item !== undefined;
    });

    const uuid = generateUUID();
    var memberNickname = $('#memberNickname').val()

    console.log(filteredArray)
    console.log(uuid)
    console.log(memberNickname)

    $.ajax({
        data: {
            wishlistId: uuid,
            productCodeList: filteredArray,
            memberNickname: memberNickname
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