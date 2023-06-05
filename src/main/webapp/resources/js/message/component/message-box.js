class MessageBox extends HTMLElement {
    constructor() {
        super();
    }

    static get observedAttributes() {
        return ['isMyMessage', 'content', 'nickname', 'sentAt'];
    }

    connectedCallback() {
        this.render();
    }

    attributeChangedCallback(name, oldValue, newValue) {
        this.render();
    }

    render() {
        const messageId = parseInt(this.getAttribute('messageId'));
        const isMyMessage = this.getAttribute('isMyMessage') === 'true';
        const messageType = parseInt(this.getAttribute('messageType'));
        const content = this.getAttribute('content') || 'Error';
        const nickname = this.getAttribute('nickname') || 'Error';
        const sentAt = this.getAttribute('sentAt') || '00:00';

        let profileHTML = `<div class="flex-shrink-0 h-8 w-8 rounded-full bg-gray-300 mr-2"></div>`
        let timeHTML = `<span class="sent-at-wrapper text-xxs text-gray-500 leading-none self-end mb-1 whitespace-nowrap">${sentAt}</span>`
        let nicknameHTML = `<p class="text-xs pb-1">${nickname}</p>`
        let menuDotsHTML = ` <div class="menu-dots self-end ${isMyMessage ? 'pl-7' : 'pr-7'}">
          <button onclick="showModal(${messageId})">
          <div class="hover:bg-gray-200 rounded-full p-0.5">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width='20' height='20'>
                <circle cx="12" cy="6" r="1.5"></circle>
                <circle cx="12" cy="12" r="1.5"></circle>
                <circle cx="12" cy="18" r="1.5"></circle>
              </svg>
          </div>
          </button>
        </div>`


        let backGroundHTML;
        if (isMyMessage) {
            backGroundHTML = 'bg-hyundai-600 text-white';
        }
        else {
            backGroundHTML = 'bg-gray-100';
        }

        if (messageType === 5){
            backGroundHTML = 'bg-purple-500 text-white font-bold';
        }
        this.innerHTML = `
            <div class="flex w-full mt-2 max-w-sm mb-3 ${isMyMessage ? 'ml-auto justify-end' : ''}">
                <div class="message-box-container flex">
                ${isMyMessage ? menuDotsHTML + timeHTML : profileHTML}
                <div class="${isMyMessage ? 'ml-1' : 'mr-1'}">
                    ${isMyMessage ? '' : nicknameHTML}
                    <div class="p-2 ${backGroundHTML} ${isMyMessage ? 'rounded-l-lg rounded-br-lg' : 'rounded-r-lg rounded-bl-lg'}">
                        <p class="text-sm">${content}</p>
                    </div>
                </div>
                ${isMyMessage ? '' : timeHTML + menuDotsHTML}
                </div>
            </div>`
    }
}

customElements.define('message-box', MessageBox);
