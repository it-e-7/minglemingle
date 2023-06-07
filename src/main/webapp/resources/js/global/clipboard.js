function copyToClipboard(text) {
    console.log(text);
    navigator.clipboard.writeText(text)
        .then(() => {
            console.log('Text copied to clipboard');
            createNotification();
        })
        .catch((error) => {
            console.error('Error copying text to clipboard:', error);
            alert("복사 실패");
        });

}

function createNotification() {
    const notification = document.createElement('div');
    notification.innerHTML = `<div class="fixed transition-all top-1/2 left-1/2 flex items-center justify-center content-center bg-white p-3 rounded shadow-lg w-60 h-14"
                                   style="transform: translate(-50%, -50%);">
                                  <a class="flex content-center"> 클립보드에 복사되었습니다. </a>
                              </div>`
    document.body.appendChild(notification);

    setTimeout(() => {
        notification.classList.add('opacity-0');
        setTimeout(() => {
            notification.remove();
        }, 1000);
    }, 1000);
}

