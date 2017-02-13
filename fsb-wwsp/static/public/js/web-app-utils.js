/**
 *用rem适配页面:
 *这个文件放在尽量早的页面引入,比如放在viewport后的第一句话.
 * 根据设计搞和设备宽度设置fontSize:
 * 假如你的设计稿是750,那么 html.style.fontSize = windowWidth / 7.5 + 'px',
 * 将设计稿的px转为rem的公式:rem=px/100;
 *假如你的设计稿是320,那么 html.style.fontSize = windowWidth / 3.2 + 'px',
 * 将设计稿的px转为rem的公式:rem=px/100;
 */

//下面是假设设计稿的宽度尺寸是320px的例子.
function reSetFontSize() {
    var html = document.documentElement;
    var windowWidth = html.clientWidth;
    html.style.fontSize = windowWidth / (3.2) + 'px';
}
//初次加载时设置
reSetFontSize();
//页面大小变化时设置
window.addEventListener('resize', function () {
    reSetFontSize();
}, false);

