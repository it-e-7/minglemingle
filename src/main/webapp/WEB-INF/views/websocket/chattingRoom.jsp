<%--
  Created by IntelliJ IDEA.
  User: Daniel Choi
  Date: 2023-05-26 026
  Time: PM 7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>채팅</title>
</head>
<body>
<h1>채팅방</h1>
<div id="chatConnect">
    <button onclick="connectSocket()">채팅 시작하기</button>
</div>

<div id="chat" hidden="hidden">
    <a>닉네임: ${nickname}</a>
    <a>채널: ${channel}</a>

    <input id="message">
    <button id="sendBtn">전송</button>
    <div id="chatBox"></div>
</div>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

    let sock;

    function connectSocket() {
        sock = new WebSocket("ws://localhost:8080/chat2mingle/ws/chat?channel=${channel}");
        sock.onopen = function () {
            alert('연결에 성공하였습니다.');
            sock.onmessage = (data => {
                console.log(JSON.parse(data.data))
                $("<p>" + data.data + "</p>").prependTo('#chatBox');
            });
            $('#chatConnect').hide();
            $('#chat').show();
        }
        sock.onerror = function (e) {
            alert('연결에 실패하였습니다.');
            console.log(e)
            $('#chatConnect').show();
            $('#chat').hide();
        }
        sock.onclose = function () {
            alert('연결을 종료합니다.');
            $('#chatConnect').show();
            $('#chat').hide();
        };
    }

    function sendMessage(nickname, channel) {
        let content = $("#message").val()

        sock.send(
            JSON.stringify({
                content: content,
                nickname: nickname,
                messageType: 1,
                channel: channel
            })
        );
        $('#message').val("");
    }

    $("#message").keyup(e => {
        if (e.keyCode == 13) {
            sendMessage();
        }
    });

    $("#sendBtn").click(() => {
        sendMessage("${nickname}", ${channel});
    });
</script>
</body>
</html>