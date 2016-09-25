/**
 * Created by jack on 16/9/25.
 */
$(document).ready(function () {


    $(window).scroll(function () {
        //浏览器文档的高度
        var broHeight = $(document).height();
        console.log("broHeight=" + broHeight);
        var lastLioffsetTop = $(".list li:last-child").offset().top;
        console.log("lastLioffsetTop="+lastLioffsetTop);
        var scrollTop=$(window).scrollTop();
        console.log("scrollTop="+scrollTop);
        if (lastLioffsetTop >= $(window).scrollTop() && lastLioffsetTop < ($(window).scrollTop() + $(window).height())) {
            console.log("在可视范围");
            $.get("demo_ajax_load.txt", function(result){
                $("div").html(result);
            });
        }else {
            console.log("不在可视范围");
        }
    });
});