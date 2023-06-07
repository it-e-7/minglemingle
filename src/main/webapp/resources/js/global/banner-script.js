function showBanner() {
  const banner = document.querySelector('.in-depth-area.type-category');
  banner.style.display = 'block';

  const leftbar = document.querySelector('.top-nav-area2 .in-depth-area.type-category .in-cate-area.cosmetic');
  leftbar.style.display = 'block';

  const borderLine = document.querySelector('.top-wrap.main .top-nav-area2');
  borderLine.style.borderBottom = '1px solid #231f20';
}

function hideBanner() {
  const banner = document.querySelector('.in-depth-area.type-category');
  banner.style.display = 'none';
    const borderLine = document.querySelector('.top-wrap.main .top-nav-area2');
    borderLine.style.borderBottom = '1px solid #bababa';
}

function showLeftBarCosmetic() {
  hideLeftBarLuxury();
  const leftbar = document.querySelector('.top-nav-area2 .in-depth-area.type-category .in-cate-area.cosmetic');
  leftbar.style.display = 'block';
}

function hideLeftBarCosmetic() {
  const leftbar = document.querySelector('.top-nav-area2 .in-depth-area.type-category .in-cate-area.cosmetic');
  leftbar.style.display = 'none';
}

function showLeftBarLuxury() {
  hideLeftBarCosmetic();
  const leftbar = document.querySelector('.top-nav-area2 .in-depth-area.type-category .in-cate-area.luxury');
  leftbar.style.display = 'block';
}

function hideLeftBarLuxury() {
  const leftbar = document.querySelector('.top-nav-area2 .in-depth-area.type-category .in-cate-area.luxury');
  leftbar.style.display = 'none';
}
//
// function openChatWindow(url, width, height) {
//     var left = (window.innerWidth - width);
//     var top = (window.innerHeight - height) / 2;
//     window.open(url, '', 'width=' + 500 + ', height=' + window.innerHeight + ', left=' + 500 + ', top=' + 500);
// }


let chatWindow;

const openChatWindow = (url) => {
  const params = `status=no,toolbar=no,menubar=no,width=500,height=${window.innerHeight}`;
  chatWindow = window.open(url, 'chatWindow', params);
};
