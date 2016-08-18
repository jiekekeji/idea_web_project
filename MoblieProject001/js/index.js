/**
 * Created by jack on 16/8/18.
 */
$(window).resize(function () {          //当浏览器大小变化时
    console.log("页面的宽度:" + $(window).width());
    console.log("div01 width="+$(".div01").width());
});

$(document).ready(function () {
    console.log("div01 width="+$(".div01").width());


});

