
// var categoryDict = {
//     "cosmetics" : "화장품",
//     "young-casual" : "영캐주얼",
//     "children" : "유아동/문화",
//     "food" : "식품",
//     "luxury" : "명품/잡화",
//     "mens-fashion" : "남성패션",
//     "sports" : "스포츠/레저",
//     "pet" : "반려동물",
//     "womens-fashion" : "여성패션",
//     "jeans" : "진/이지",
//     "electronics":"리빙/가전",
//     "all" :"모두선택"
// }

var categoryDict = {
    "cosmetics" : 0,
    "young-casual" : 1,
    "children" : 2,
    "food" : 3,
    "luxury" : 4,
    "mens-fashion" : 5,
    "sports" : 6,
    "pet" : 7,
    "womens-fashion" : 8,
    "jean" : 9,
    "electronics":10,
    "all" :"모두선택"
}
$(document).ready(function() {
    $('#confirmationModal').hide();

});

$('form').on('submit', function(e) {

    e.preventDefault()
    var checkboxes = $('input[type="checkbox"]');
    var checkedValues = [];
    var noticeVal = $('#text-input').val();

    checkboxes.each(function() {
        if ($(this).is(':checked')) {
            checkedValues.push($(this).val());
        }
    });


    if (checkedValues.length === 0) {
        alert("카테고리는 최소 하나를 선택해야합니다.")
    } else if (noticeVal == "") {
        alert("공지가 비었습니다.")
    } else {
        $('#confirmationModal').show();
        var formDataArray = $(this).serializeArray();
        var previewCategories = '';
        var previewText = ''
        for (var i = 0; i < formDataArray.length; i++) {
            var field = formDataArray[i];
            if(field.name=="textInput") {
                previewText = field.value
            } else {
                if (field.name=="all"){continue;}
                previewCategories += field.value;
            }
        }
        $('#notice-text-preview').html(previewText)
        $('#notice-category-preview').html(previewCategories)

    }

})

function sendFormData(form) {
    let formDataArray = form.serializeArray()
    let obj = {}
    let channels = []
    console.log(formDataArray)
    for (var i = 0; i < formDataArray.length; i++) {
        var field = formDataArray[i];
        if(field.name=='all'){continue}
        if(field.name=='textInput'){
            obj['content'] = field.value
        } else {
            channels.push(categoryDict[field.value])
            // obj[field.name] = categoryDict[field.value]
        }
    }
    obj['channels'] = channels
    console.log(obj)
    let result = false
    $.ajax({
        data: JSON.stringify(obj),
        url: '/chat2mingle/admin/sendNotice',
        type: 'post',
        contentType: 'application/json',
        async: false,
        success: function (data) {
            result = data;
        },
        error: function (e) {
            console.log(e);
        },
    })
    return result
}

$('#confirm-form-btn').on('click', function() {

    let isNoticeSent = sendFormData($('form'))
    $('#confirmationModal').hide()

})

$('#all').on('click', function() {
    var isChecked = $(this).is(':checked');
    $('input[type="checkbox"]').prop('checked', isChecked);
});