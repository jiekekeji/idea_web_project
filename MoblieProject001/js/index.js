/**
 * Created by jack on 16/8/18.
 */

var a = document.documentElement;
// b = a.clientWidth > 750 ? 750 : a.clientWidth;
a.style.fontSize = 20 + "px";


console.log("font-size=" + getComputedStyle(window.document.documentElement)['font-size']);


$(window).resize(function () {          //当浏览器大小变化时
    console.log("页面的宽度:" + $(window).width());
    console.log("div01 width=" + $(".div01").width());

    console.log("font-size=" + getComputedStyle(window.document.documentElement)['font-size']);
});

$(document).ready(function () {
    console.log("div01 width=" + $(".div01").width());


});

// (function (win) {
//     var doc = win.document;
//     var docEl = doc.documentElement;
//     var tid;
//
//     function refreshRem() {
//         var width = docEl.getBoundingClientRect().width;
//         if (width > 540) { // 最大宽度
//             width = 540;
//         }
//         var rem = width / 10; // 将屏幕宽度分成10份， 1份为1rem
//         docEl.style.fontSize = rem + 'px';
//     }
//
//     win.addEventListener('resize', function () {
//         clearTimeout(tid);
//         tid = setTimeout(refreshRem, 300);
//     }, false);
//     win.addEventListener('pageshow', function (e) {
//         if (e.persisted) {
//             clearTimeout(tid);
//             tid = setTimeout(refreshRem, 300);
//         }
//     }, false);
//
//     refreshRem();
//
// })(window);
//
//
