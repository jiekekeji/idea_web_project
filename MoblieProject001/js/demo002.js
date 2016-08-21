/**
 * Created by jack on 16/8/21.
 */


$(document).ready(function () {
    var html = document.documentElement;
    var windowWidth = html.clientWidth;
    var scale = windowWidth / 320;
    console.log("scale=" + scale);
    var content = "width=320,, initial-scale=" + scale + ", maximum-scale=10, user-scalable=no";
    var viewport = $("meta[name='viewport']");
    viewport.attr("content", content);

    $("#btn").click(function () {
        console.log("div01 width=" + $(".div01").width());
        var viewport = $("meta[name='viewport']");
        console.log("content=" + viewport.attr("content"));
    });
});