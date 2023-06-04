
var categoryToPreviewDict = {
    "cosmetics" : "화장품",
    "young-casual" : "영캐주얼",
    "children" : "유아동/문화",
    "food" : "식품",
    "luxury" : "명품/잡화",
    "mens-fashion" : "남성패션",
    "sports" : "스포츠/레저",
    "pet" : "반려동물",
    "womens-fashion" : "여성패션",
    "jean" : "진/이지",
    "electronics":"리빙/가전",
    "all" :"모두선택"
}

var categoryToChannelDict = {
    "cosmetics" : 1,
    "young-casual" : 2,
    "children" : 3,
    "food" : 4,
    "luxury" : 5,
    "mens-fashion" : 6,
    "sports" : 7,
    "pet" : 8,
    "womens-fashion" : 9,
    "jean" : 10,
    "electronics":11,
    "all" :"모두선택"
}
$(document).ready(function() {
    $('#confirmation-modal').hide();

});

$('#notice-form').on('submit', function(e) {

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
        $('#confirmation-modal').show();
        var formDataArray = $(this).serializeArray();
        var previewCategories = '';
        var previewText = ''
        for (var i = 0; i < formDataArray.length; i++) {
            var field = formDataArray[i];
            if(field.name=="textInput") {
                previewText = field.value
            } else {
                if (field.name=="all"){continue;}
                previewCategories += '<li>' + categoryToPreviewDict[field.value] + '</li>';
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
            channels.push(categoryToChannelDict[field.value])
            // obj[field.name] = categoryDict[field.value]
        }
    }
    obj['channels'] = channels
    console.log(obj)
    let result = false
    $.ajax({
        data: JSON.stringify(obj),
        url: '/admin/sendNotice',
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

$('#confirm-accept-btn').on('click', function() {

    let isNoticeSent = sendFormData($('#notice-form'))
    $('#confirmation-modal').hide()
})

$('#confirm-cancel-btn').on('click', function() {
    $('#confirmation-modal').hide()

    $('#notice-form')[0].reset()
    $('#notice-text-preview').html('')
    $('#notice-category-preview').html('')

})

$('#all').on('click', function() {
    var isChecked = $(this).is(':checked');
    $('input[type="checkbox"]').prop('checked', isChecked);
});


$('.table').on('submit', function() {
    e.preventDefault()
    if($('#dropdown').value()=='chatting-stop'){
        alert('no 기능')
    }
})