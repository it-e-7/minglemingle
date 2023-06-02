
var nicknameTimer;
var emailTimer;
let isNicknameValid = false;
let isEmailValid = false;
let isPasswordValid = false;

function checkNickname(nicknameText) {
	var result;
	var obj= {nickname: nicknameText}
	$.ajax({
		data: JSON.stringify(obj),
		dataType: 'json',
		url: '/member/checkNickname',
		type: 'post',
		contentType: 'application/json',
		async: false,
		success: function (data) {
			result = data;
		},
		error: function (e) {
			console.log(e);
		},
	});
	return result;
}

function checkEmail(emailText) {
	var result;
	var obj= {email: emailText}

	$.ajax({
		data: JSON.stringify(obj),
		url: '/member/checkEmail',
		type: 'post',
		contentType: 'application/json',
		async: false,
		success: function (data) {
			result = data;
		},
		error: function (e) {
			console.log(e);
		},
	});
	return result;
}

function confirmNickname(nickname) {
	if (nickname === ''){
		$('#nickname-message')
			.html('빈 공백은 사용할 수 없습니다')
			.css('color', 'red');
	} else {
		isNicknameValid = checkNickname(nickname);
		if (isNicknameValid) {
			$('#nickname-message')
				.html('사용가능한 닉네임입니다')
				.css('color', 'green');
		} else {
			$('#nickname-message')
				.html('이미 존재하는 닉네임입니다')
				.css('color', 'red');
		}
	}

}

function confirmEmail(email) {
	var regex = /@/;
	if (regex.test(email)) {
		isEmailValid = checkEmail(email);
		// isEmailValid = true;
		if (isEmailValid) {
			$('#email-message').html('사용가능한 이메일입니다').css('color', 'green');
		} else {
			$('#email-message')
				.html('이미 존재하는 이메일입니다')
				.css('color', 'red');
		}
	} else {
		$('#email-message')
			.html('올바른 이메일 형식이 아닙니다')
			.css('color', 'red');
	}
}

$('#nickname-confirm').click(function (e) {
	// alert('test email');
	e.preventDefault();
	confirmNickname($('#nickname').val());
});

$('#email-confirm').click(function (e) {
	// alert('test email');
	e.preventDefault();
	confirmEmail($('#email').val());
});

$(document).ready(function () {
	$('#nickname').on('keyup', function () {
		clearTimeout(nicknameTimer);
		nicknameTimer = setTimeout(function () {
			// alert('test');
			confirmNickname($('#nickname').val());
		}, 1000);
	});

	$('#email').on('keyup', function () {
		clearTimeout(emailTimer);
		emailTimer = setTimeout(function () {
			// alert('test');
			confirmEmail($('#email').val());
		}, 1000);
		// confirmEmail()
	});

	$('#password-check').on('keyup', function () {
		var password = $('#password').val();
		var confirmPassword = $('#password-check').val();

		if (password === confirmPassword) {
			isPasswordValid = true;
			$('#password-message')
				.html('비밀번호가 일치합니다')
				.css('color', 'green');
		} else {
			$('#password-message')
				.html('비밀번호가 일치하지 않습니다.')
				.css('color', 'red');
		}
	});

	$('form').submit(function (e) {
		e.preventDefault();
		if (isNicknameValid && isEmailValid && isPasswordValid) {
			// alert('true');
			$('#submit-message')
				.html('')
			this.submit();
		} else {
			$('#submit-message')
				.html('입력한 정보가 올바르지 않습니다.')
				.css('color', 'red');
		}
	});
});
