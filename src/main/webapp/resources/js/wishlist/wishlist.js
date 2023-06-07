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
    var productCodeString = itemsList.filter(function(item) {
        return item !== null && item !== undefined;
    }).join(",");

    var memberNickname = $('#memberNickname').val()

    const uuid = generateUUID();

    let targetUrl = generateURLFromUUID(uuid)
    copyToClipboard(targetUrl)

    let data = JSON.stringify({
        wishlistId: uuid,
        memberNickname: memberNickname,
        productCodeString: productCodeString,
    });
    console.log(data);
    $.ajax({
        data: data,
        url: '/wishlist',
        type: 'post',
        contentType: 'application/json',
        async: false,
        success: function (data) {
            console.log(data)
        },
        error: function (e) {
            console.log(e.responseText);
        },
    })
})

function generateURLFromUUID(uuid) {
    return "http://localhost:8080/wishlist/" + uuid;
}