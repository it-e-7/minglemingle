<%--
  Created by IntelliJ IDEA.
  User: Daniel Choi
  Date: 2023-05-26 026
  Time: PM 7:27
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>채팅</title>
    <style>
        .loader {
            border: 16px solid #f3f3f3; /* Light grey */
            border-top: 16px solid #3498db; /* Blue */
            border-radius: 50%;
            width: 120px;
            height: 120px;
            animation: spin 2s ease-in-out infinite;
            transition: .6s ease opacity,.6s ease transform;
            display: none;
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
        @keyframes show {
            0% { transform: scale(0); }
            100% { transform: scale(100); }
        }
    </style>
</head>
<body>
<h1>채팅방</h1>
<div id="chatConnect">
    <button onclick="connectSocket()">채팅 시작하기</button>
</div>


<div id="chat" hidden="hidden">
    <a>닉네임: ${nickname}</a>
    <a>채널: ${channel}</a>
    <div id="loader" class="loader"></div>
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
    let myname = "${nickname}";
    function connectSocket() {
        sock = new WebSocket("ws://localhost:8080/chat2mingle/ws/chat?channel=${channel}");
        sock.onopen = function () {

            getMessages(myname, "0");

            alert('연결에 성공하였습니다.');
            sock.onmessage = (data => {
                console.log(data)
                let d = JSON.parse(data.data);
                console.log(d)
                if (d.content === '') {return;}

                addMessageOnBottom(myname, d);

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

    function getMessages(nickname, messageId) {
        $.ajax({
            type: 'GET',
            url: '/chat2mingle/message?messageId='+messageId,
            success: function(data) {

                let chatboxWrap = $('#chatbox-wrap')[0]
                let lastScrollHeight = chatboxWrap.scrollHeight;
                console.log("lastScrollHeight: " + lastScrollHeight)
                d = JSON.parse(data)
                for (const key in d) {
                    addMessageOnTop(nickname, d[key]);
                }
                console.log("new: " + chatboxWrap.scrollHeight)

                chatboxWrap.scrollTop += chatboxWrap.scrollHeight - lastScrollHeight;
                console.log("changed: " + (chatboxWrap.scrollHeight - lastScrollHeight))
            },
            error: function(xhr, status, error) {
                alert('에러')
                console.log(error)
            }
        })
    }

    function addMessageOnBottom(myname, data) {
        let myMessage = myname === data.nickname;
        $(`<message-box messageid="` + data.messageId
            + `" isMyMessage="` + myMessage
            + `" content="` + data.content
            + `" nickname="` + data.nickname
            + `" sentAt="` + data.sentAt + `"/>`).appendTo('#chatbox');
        $("#chatbox-wrap").animate({ scrollTop: $('#chatbox-wrap').prop("scrollHeight")}, 500);
    }
    function addMessageOnTop(myname, data) {
        let myMessage = myname === data.nickname;
        $(`<message-box messageid="` + data.messageId
            + `" isMyMessage="` + myMessage
            + `" content="` + data.content
            + `" nickname="` + data.nickname
            + `" sentAt="` + data.sentAt + `"/>`).prependTo('#chatbox');
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

    function getTopMessageId() {
        return $('#chatbox').children().first().attr('messageid');
    }

    $("#message").keyup(e => {
        if (e.keyCode === 13) {
            sendMessage("${nickname}", ${channel});
        }
    });

    $("#sendBtn").click(() => {
        sendMessage("${nickname}", ${channel});
    });

    const chatContainer = document.getElementById('chatbox-wrap')
    const loader = document.getElementById('loader')
    $(document).ready(function() {
        chatContainer.addEventListener('scroll', function() {
            if (chatContainer.scrollTop === 0) {
                console.log("U reached the top");
                refreshFunction()
            }
        })
    })
    function refreshFunction() {
            // Simulating delay for demonstration purposes
            setTimeout(function() {
                // Perform your refresh logic here
                console.log('Refresh function called');
                loader.style.display = 'none';
                loader.style.transform = 'scale(0)';
                let messageId = getTopMessageId();
                console.log("reading more messages from: " + messageId)
                getMessages(myname, messageId)
            }, 0);
        }

</script>

</body>
</html>