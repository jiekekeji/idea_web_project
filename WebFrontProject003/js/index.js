/**
 * Created by Administrator on 2016/8/12.
 */
$(document).ready(function () {
    //每个分类的推荐详情内容的显示和隐藏
    $(".tuijian").mouseenter(function () {
        var id = $(this).attr("id");
        console.log("鼠标进入了=" + id);

        //获取对应描述div,显示
        var descDiv = $("#" + id + " div");
        descDiv.removeClass("tuijianDescHidden");
        descDiv.addClass("tuijianDesc");
    });
    $(".tuijian").mouseleave(function () {
        var id = $(this).attr("id");
        console.log("鼠标移除=" + id);

        //获取对应描述div,显示
        var descDiv = $("#" + id + " div");
        descDiv.removeClass("tuijianDesc");
        descDiv.addClass("tuijianDescHidden");
    });
    //每个分类列表详情内容的显示和隐藏
    $(".typeDetail li").mouseenter(function () {
        var id = $(this).attr("id");
        var descDiv = $("#" + id + " div");
        descDiv.removeClass("typeDescHidden");
        descDiv.addClass("typeDesc");
    });
    $(".typeDetail li").mouseleave(function () {
        var id = $(this).attr("id");
        var descDiv = $("#" + id + " div");
        descDiv.removeClass("typeDesc");
        descDiv.addClass("typeDescHidden");
    });
    //监听页面的滚动
    $(window).scroll(function() {
        console.log("scrollTop="+$(window).scrollTop());
        if ($(window).scrollTop() > 100) {
            $("#topBtn").removeClass("backTopHidden");
            $("#topBtn").addClass("backTop");
        } else {
            $("#topBtn").removeClass("backTop");
            $("#topBtn").addClass("backTopHidden");
        }
    });
    //回到顶部按钮的监听
    $("#topBtn").click(function () {
        $("body,html").animate({scrollTop:0},300);
    });
});
