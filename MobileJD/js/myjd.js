/**
 * Created by jack on 16/9/13.
 */
$(document).ready(function () {
    //头部菜单点击事件
    $(".menu").click(function () {
        if ($("#fl_top_munu").hasClass("more_fl-show")) {
            $("#fl_top_munu").removeClass("more_fl-show");
            $("#fl_body").removeClass("clz-nomrtop");
        } else {
            $("#fl_top_munu").addClass("more_fl-show");
            $("#fl_body").addClass("clz-nomrtop");
        }
    });
});
