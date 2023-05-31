
$(document).ready(function () {
    $('form').submit(function (e) {
        e.preventDefault();
        $('#email').val($('#email').trim())
        this.submit();

    });
});
