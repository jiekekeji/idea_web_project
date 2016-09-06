<!--监听滚动条,固定导航栏-->
$(window).scroll(function () {
    //scrollTop是浏览器滚动条的top位置，距离顶部的距离
    var scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
    var adimgHeight = $(".imgshow").height();
    var titleBarHeight = $(".titleBar").height();
    var totleHeight = adimgHeight - titleBarHeight;
    console.log("adimgHeight=" + adimgHeight + " scrollTop=" + scrollTop);
    if (scrollTop > titleBarHeight) {
        $(".titleBar").css("background", "red");
        $(".titleBar").css("opacity", scrollTop / totleHeight);
    } else {
        console.log("移除属性");
        $(".titleBar").removeAttr("style");
    }

})
