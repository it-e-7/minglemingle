
$(document).ready(function () {
    $('#login-form').submit(function (e) {
        e.preventDefault();
        $('#email').val($('#email').trim())
        this.submit();

    });
});
