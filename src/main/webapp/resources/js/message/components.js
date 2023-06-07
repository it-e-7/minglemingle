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

        let menuDotsHTML = `<div class="menu-dots self-end align-bottom w-10">
                                <div class="hover:bg-gray-200 rounded-full p-0.5 w-6 h-6" onclick="showSeeMoreModal(${messageId})">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width='20' height='20'>
                                        <circle cx="12" cy="6" r="1.5"></circle>
                                        <circle cx="12" cy="12" r="1.5"></circle>
                                        <circle cx="12" cy="18" r="1.5"></circle>
                                    </svg>
                                </div>
                            </div>`

        let timeHTML = `<div class="flex text-xxs text-gray-500 leading-none self-end whitespace-nowrap w-10"> 
                            <span class="sent-at-wrapper ${isMyMessage ? '' : 'others-message'} w-10">
                              ${sentAt}
                            </span>
                            ${isMyMessage ? '' : menuDotsHTML}
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
class ChatHeader extends HTMLElement {
    constructor() {
        super();
    }

    static get observedAttributes() {
        return ['title', 'visit_count'];
    }

    connectedCallback() {
        this.render();
    }

    attributeChangedCallback(name, oldValue, newValue) {
        this.render();
    }

    render() {
        const title = this.getAttribute('title');
        const visit_count = this.getAttribute('visit-count');

        this.innerHTML = `
          <header>
            <nav class="bg-white border-gray-200 px-4 lg:px-6 py-2.5 dark:bg-gray-800 w-screen w-full max-w-xl">
              <div class="flex justify-between mx-auto max-w-xl">
                <div>
                  <div class="text-xl font-bold">
                    ${title}
                  </div>
                  <div class="text-xs">
                    최근 ${visit_count}명 방문
                  </div>
                </div>
                  <a href="/chattingList">
                      <button class="inline-flex items-center p-2 ml-1 
                                    text-sm text-gray-500 rounded-lg hover:bg-gray-100 focus:outline-none 
                                    focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
                          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                              <path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"/>
                          </svg>  
                      </button>
                  </a>
              </div>
            </nav>
          </header>`

    }
}
class NoticeBox extends HTMLElement {
    constructor() {
        super();
    }

    static get observedAttributes() {
        return ['content'];
    }

    connectedCallback() {
        this.render();
    }

    attributeChangedCallback(name, oldValue, newValue) {
        this.render();
    }

    render() {
        const content = this.getAttribute('content') || 'Error';

        this.innerHTML = `
<div class="mx-4 mt-2 grid justify-items-stretch rounded-md bg-amber-300 p-1">
  <div class="ml-2 mt-1 justify-self-start">
    <button id="remove-notice-btn" class="justify-self-start">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" width="10px" height="10px">
        <path d="M 7.71875 6.28125 L 6.28125 7.71875 L 23.5625 25 L 6.28125 42.28125 L 7.71875 43.71875 L 25 26.4375 L 42.28125 43.71875 L 43.71875 42.28125 L 26.4375 25 L 43.71875 7.71875 L 42.28125 6.28125 L 25 23.5625 Z" />
      </svg>
    </button>
  </div>
  <div class="justify-self-center mb-2 mx-6">
    <p class="font-bold">${content}</p>
  </div>
</div>
`
    }
}

customElements.define('notice-box', NoticeBox);

customElements.define('chat-header', ChatHeader);

customElements.define('message-box', MessageBox);



