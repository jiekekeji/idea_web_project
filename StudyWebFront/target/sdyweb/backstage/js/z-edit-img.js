/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    //*******start静态页面加载完成开始加载数据***********//
    console.log("页面加载完成开始加载数据");

    //检测是否已登陆
    var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";
    //更新地址
    var URL_findVideos = "/sdyweb/video/updateImgByID";

    //start 页面加载完成,检测用户是否已登陆
    var islogin = true;
    console.log("检测用户是否已登陆");
    $.get(checkUserIsLoginURL, function (result) {
        if (4000 == result.code) {
            islogin = false;
            window.location.href = encodeURI("user-login.html");
        }
    });

    if (!islogin) {
        return;
    }
    var id = getUrlParam("id");
    var outlineImgUrl = getUrlParam("outlineImgUrl");
    if (null == id || "" == id) {
        return;
    }

    $("#id").val(id);
    $("#outlineImgUrl").attr("src", outlineImgUrl);

    //提交按钮监听
    $("#submitbtn").click(function () {
        var image = $("#image").val();
        if (null == image || "" == image ) {
            $("#notice").text("图片为选择");
            return;
        }

        //提交注册
        $("#add_net_video_form").submit(function () {
            $(this).ajaxSubmit(function (data) {
                if (2000 == data.code) {
                    window.location.href = encodeURI("./video-list.html");
                } else {
                    $("#notice").text("提交失败，请稍后重试!");
                }
            });
        });
    });
});