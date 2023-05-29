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

    <div class="flex flex-col items-center justify-center w-screen min-h-screen bg-gray-100 text-gray-800 p-10">
        <!-- Component Start -->
        <div class="flex flex-col flex-grow w-full max-w-xl bg-white shadow-xl rounded-lg overflow-hidden">
            <div id="chatbox-wrap" class="flex flex-col flex-grow h-0 p-4 overflow-auto">
                <div id="chatbox"></div>
            </div>

            <div class="bg-gray-300 p-4">
                <input id="message" class="flex items-center h-10 w-full rounded px-3 text-sm" type="text" placeholder="Type your message…">
            </div>
            <button id="sendBtn">전송</button>
        </div>
        <!-- Component End  -->
    </div>
</div>
<script src="https://cdn.tailwindcss.com"></script>
<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/message/component/message-box.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

    let sock;

    function connectSocket() {
        sock = new WebSocket("ws://localhost:8080/chat2mingle/ws/chat?channel=${channel}");
        sock.onopen = function () {
            alert('연결에 성공하였습니다.');

            sock.onmessage = (data => {

                let d = JSON.parse(data.data);

                if (d.content === '') {return;}

                let myMessage = "${nickname}" === d .nickname;

                $(`<message-box isMyMessage="` + myMessage +
                    `" content="` + d.content +
                    `" nickname="` + d.nickname +
                    `" sentAt="` + d.sentAt + `"/>`).appendTo('#chatbox');

                $("#chatbox-wrap").animate({ scrollTop: $('#chatbox-wrap').prop("scrollHeight")}, 500);
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
                channel: channel,
                sentAt: new Date().valueOf(),
            })
        );
        $('#message').val("");
    }

    $("#message").keyup(e => {
        if (e.keyCode === 13) {
            sendMessage("${nickname}", ${channel});
        }
    });

    $("#sendBtn").click(() => {
        sendMessage("${nickname}", ${channel});
    });
</script>
</body>
</html>