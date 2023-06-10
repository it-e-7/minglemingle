
const copyToClipboard = (text) => {
    const textArea = document.createElement("textarea");
    textArea.value=text; document.body.appendChild(textArea);
    textArea.focus({preventScroll: true});textArea.select();
    try{document.execCommand('copy')}
    catch(err){console.error('Unable to copy to clipboard',err)}
    document.body.removeChild(textArea);
    createNotification();
};

    //
    // navigator.clipboard.writeText(text)
    //     .then(() => {
    //         createNotification();
    //     })
    //     .catch((error) => {
    //         console.error('Error copying text to clipboard:', error);
    //         alert("복사 실패");
    //     });



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

