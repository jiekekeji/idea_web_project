/**
 * 用viewport的initial-scale缩放页面
 *
 * 通过<meta name="viewport" content="width=320, initial-scale=1, maximum-scale=10, user-scalable=no">
 * width设置为一个初始值,一般按设计图的倍数;比如设计图是640的,设置width=320,那么设计图上所有的尺寸都除以2,
 * 页面初始加载时通过设备的宽度clientWidth和320的比值计算;initial-scale的比值.页面加载时就有相应的缩放.
 */
function reSetInitialScale(){
    var html = document.documentElement;
    var windowWidth = html.clientWidth;
    var scale = windowWidth / 320;
    var content = "width=320,, initial-scale=" + scale + ", maximum-scale=10, user-scalable=no";
    var viewport = $("meta[name='viewport']");
    viewport.attr("content", content);
}
$(document).ready(function () {
    reSetInitialScale();
    $(window).resize(function() {
        // reSetInitialScale();
    });
});
