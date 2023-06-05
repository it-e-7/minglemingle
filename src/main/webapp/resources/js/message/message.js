const options = { hour: 'numeric', minute: 'numeric' };

let documentSelector;
let sock;
let onLoad;

let chatBox;
let chatBoxWrap;
let messageInputBox;
let sendBtn;

let nickname;
let channel;
let accountType;

let seeMoreModal;
let chatModalBackdrop;

async function connectSocket(nickname_param, channel_param, accountType_param) {
    // Socket 연결

    nickname = nickname_param;
    channel = channel_param;
    accountType = accountType_param;

    sock = new WebSocket("ws://192.168.0.200:8080/ws/chat?channel=" + channel);
    sock.onerror = function (e) {
        alert('연결에 실패하였습니다.');
        console.log(e)
    }
    sock.onclose = function () {
        alert('연결을 종료합니다.');
    };
    sock.onopen = async function () {
        // Socket이 연결되면
        await loadMessages(); // 처음에 메시지 불러오기
        scrollChatBoxWrapToBottom(); // 불러온 다음 아래로 스크롤
        assignEventListeners() //

        sock.onmessage = (datastr => {
            let data = JSON.parse(datastr.data)
            let wasAtBottom = isChatBoxWrapAtBottom()
            handleMessageReceived(data);
            //스크롤이 밑에 있었다면, 새로운 메시지를 받았을 때 아래로 스크롤을 같이 이동
            if (wasAtBottom || data.nickname === nickname) {
                scrollChatBoxWrapToBottom();
            }
        });
    }
}

function isChatBoxWrapAtBottom() {
    return chatBoxWrap.innerHeight() + chatBoxWrap.scrollTop() - (parseFloat(getScrollHeight(chatBoxWrap))) > -5;
}

function scrollChatBoxWrapToBottom() {
    chatBoxWrap.scrollTop(getScrollHeight(chatBoxWrap));

}

function deleteMessage(messageId) {
    console.log("deleting: " + messageId)
}

function hasReachedLoadThreshold() {
    return chatBoxWrap.scrollTop() < (getScrollHeight(chatBoxWrap) * 0.3);
}

async function loadMessages(messageId) {
    if (messageId === undefined) messageId = 0;
    lockLoad(true);

    let data = await getMessages(messageId);
    addMessagesAdjustScrollPosition(data);

    lockLoad(false);
}

async function getMessages(messageId) {
    return await $.ajax({
        type: 'GET',
        url: '/message?messageId='+messageId + '&channel=' + channel,
        dataType: "json",
        success: function(data) {
            return data;
        },
        error: function(xhr, status, error) {
            alert('에러')
            console.log(error)
            return error;
        }
    })
}

function assignEventListeners() {
    // 마우스 휠을 움직이거나, 스크롤을 움직일 경우 메시지를 불러오고 위치조정
    chatBoxWrap.on('wheel scroll', async function(event) {
        let previousY = $(this).data('previousScrollY') || 0;
        let currentY = $(this).scrollTop()

        $(this).data('previousScrollY', currentY);

        let deltaY = event.originalEvent.deltaY || currentY - previousY;

        if (isLoadAvailable() && hasReachedLoadThreshold() && deltaY < 0) {
            await loadMessages(getTopMessageId());
        }
    });

    // 메시지 inputBox 활성화, 비활성화
    messageInputBox.on('input change', function() {
        if ($(this).val() === "") {
            setDisabled(sendBtn, true);
        } else {
            setDisabled(sendBtn, false);
        }
    });
    // Message Input 엔터 눌렀을 때
    messageInputBox.keyup(e => {
        if (e.keyCode === 13 && messageInputBox.val() !== "") {
            setDisabled(sendBtn, true);
            sendMessage();
        }
    });

    sendBtn.click(() => {
        setDisabled(sendBtn, true);
        sendMessage();
    });

    documentSelector.on("keydown", function(event) {
        hideModalOnEscape(event);
    });
}

// Option에 기반해서 message 시간 포멧팅
function formatDateForMessage(dateString) {
    return (new Date(dateString)).toLocaleTimeString('kr-KR', options);
}

// Load 되었을 때, 메시지 추가
function addMessagesAdjustScrollPosition(data) {
    let originalScrollHeight = getScrollHeight(chatBoxWrap);

    prependMessageBoxListToChatBox(data);

    // 만약 chatbox scroll이 맨 위에 있다면 메시지를 추가한 다음에 원래 위치로 이동
    // 원래 위치와의 차이는 offset으로 계산
    if (chatBoxWrap.scrollTop() === 0) {
        let offset = getScrollHeight(chatBoxWrap) - originalScrollHeight;
        setScrollTop(chatBoxWrap, offset);
    }

}

// Chatbox 가장 아래에 메시지 추가 (메시지 수신 시 사용)
function appendMessageBoxToChatBox(data) {
    chatBox.append(
        makeMessageBoxListHTML(data)
    )
}

// chatbox 위에 메시지 추가 (이전 메시지 로딩 시 사용)
function prependMessageBoxListToChatBox(data) {
    Object.values(data).map(item =>
        chatBox.prepend(makeMessageBoxListHTML(item))
    )
}

// 공지 띄워주는 함수
function showNoticeBox(data) {
    console.log("공지입니다. " + data.content);
}

// 메시지를 받았을 때 취할 행동
function handleMessageReceived(data) {
    // messageType이 10보다 아래면 일반 메시지
    if (data.messageType < 10) {
        appendMessageBoxToChatBox(data);
    }
    // 10이면 공지 띄워주기
    else if (data.messageType === 10) {
        showNoticeBox(data)
    }
    else if (data.messageType === 99) {
        // 99이면 시스템 메시지
        let [command, messageId] = parseSystemMessage(data.content);
        runSystemCommand(command, messageId);
    }
}

// delete:244 형태의 commend 파싱
function parseSystemMessage(content) {
    let systemMsgArray = content.split(":");
    return [systemMsgArray[0], parseInt(systemMsgArray[1])]
}

// 시스템 메시지 커맨드 실행
function runSystemCommand(command, messageId) {
    if (command === "delete") {
        deleteMessage(messageId)
    }
    else {
        console.log("Unknown System Message Command: " + command + ", messageId: " + messageId);
    }
}

// 메시지 전송 함수
function sendMessage() {
    let content = messageInputBox.val()
    sock.send(
        JSON.stringify({
            content: content,
            nickname: nickname,
            messageType: accountType,
            channel: channel
        })
    );
    messageInputBox.val("");
}

// 가장 위에 있는 메시지ID 반환
function getTopMessageId() {
    return chatBox.children().first().attr('messageid');
}

// 지금 로딩중인지 아닌지 반환
function isLoadAvailable() {
    return !onLoad
}

// 로딩 상태 잠금 토글
function lockLoad(state) {
    onLoad = state;
}

function setDisabled(jSelector, state) {
    jSelector.prop("disabled", state);
}

function setScrollTop(jSelector, value) {
    jSelector.scrollTop(value)
}

function getScrollHeight(jSelector) {
    return jSelector.prop("scrollHeight")
}

function setDisplay(jSelector, value) {
    jSelector.css("display", value);
}

function makeMessageBoxListHTML(data) {
    return `<message-box messageid="${data.messageId}"
                messageType=${data.messageType}
                isMyMessage="${(nickname === data.nickname)}" 
                content="${data.content}"
                nickname="${data.nickname}"
                sentAt="${formatDateForMessage(data.sentAt)}"/>`

}
function makeChatHeaderHTML(title, visitCount) {
    return `<chat-header title="${title}" visit-count="${visitCount}"/>`
}

// Function to show the modal and populate the attribute
function showModal(messageId) {
    console.log("modal with message id: " + messageId)
    setDisplay(seeMoreModal, 'block');
    setDisplay(chatModalBackdrop, 'block');

    documentSelector.on("keydown", function(event) {
        hideModalOnEscape(event);
    });
}

function hideModalOnEscape(event) {
    if (event.key === "Escape") {
        hideModal();
    }
}

// Function to hide the modal
function hideModal() {
    setDisplay(seeMoreModal, 'none');
    setDisplay(chatModalBackdrop, 'none');
    documentSelector.off("keydown");
    //
    // chatModalBackdrop.unbind("keydown");
    // // Remove event listener for clicking outside the modal
    // chatModalBackdrop.removeEventListener('click', hideModal);
}
