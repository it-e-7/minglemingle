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
        const isMyMessage = this.getAttribute('isMyMessage') === 'true' || false;
        const messageType = parseInt(this.getAttribute('messageType'));
        const content = this.getAttribute('content') || 'Error';
        const nickname = this.getAttribute('nickname') || 'Error';
        const sentAt = this.getAttribute('sentAt') || '00:00';
        const showImagePreview = this.getAttribute('showImagePreview') === 'true' || false;

        let profileHTML = `<div class="flex-shrink-0 h-8 w-8 rounded-full bg-gray-300 mr-2"></div>`

        let timeHTML = `<div class="flex text-xxs text-gray-500 leading-none self-end whitespace-nowrap w-10"> 
                            <span class="sent-at-wrapper w-10">
                              ${sentAt}
                            </span>
                            <div class="menu-dots self-end align-bottom w-10">
                                <div class="hover:bg-gray-200 rounded-full p-0.5 w-6 h-6" onclick="showSeeMoreModal(${messageId})">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width='20' height='20'>
                                        <circle cx="12" cy="6" r="1.5"></circle>
                                        <circle cx="12" cy="12" r="1.5"></circle>
                                        <circle cx="12" cy="18" r="1.5"></circle>
                                    </svg>
                                </div>
                            </div>
                        </div>`

        let nicknameHTML = `<p class="text-xs pb-1">${nickname}</p>`

        let imageHTML;
        let contentHTML;

        if (showImagePreview) {
            imageHTML = `<img class="m-2 w-36" src="http://ryulrudaga.com:48000/api/image/first?url=${content}"/>`
            contentHTML = `<a href="${content}">${content}</a>`
        }
        else {
            contentHTML = `<p>${content}</p>`;
        }


        let backGroundHTML;
        if (isMyMessage) {
            backGroundHTML = `bg-hyundai-600 ${showImagePreview ? 'text-blue-200 underline' : 'text-white'}`;
        }
        else {
            backGroundHTML = `bg-gray-100 ${showImagePreview ? 'text-blue-500 underline' : 'text-black'}`;
        }

        if (messageType === 5){
            backGroundHTML = `bg-purple-500 ${showImagePreview ? 'text-white underline' : 'text-white'}`;
        }

        this.innerHTML = `
          <div class="flex w-full mt-2 max-w-sm mb-3 ${isMyMessage ? 'ml-auto justify-end' : ''}">
            <div class="message-box-container flex">
                ${isMyMessage ? timeHTML : profileHTML}
                <div class="flex flex-col  ${isMyMessage ? 'ml-1 items-end' : 'mr-1 items-start'}">
                    ${isMyMessage ? '' : nicknameHTML}
                    <div class="text-sm p-2 items-start ${backGroundHTML} ${isMyMessage ? 'rounded-l-lg rounded-br-lg' : 'rounded-r-lg rounded-bl-lg'}">
                        ${contentHTML}
                    </div>
                    <div>${showImagePreview ? imageHTML : ''}</div>
                </div>
                
                ${isMyMessage ? '' : timeHTML}
            </div>
          </div>`
    }
}

customElements.define('message-box', MessageBox);



