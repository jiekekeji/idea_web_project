/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {


    //请求地址
    var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";

    //start 页面加载完成,检测用户是否已登陆
    console.log("检测用户是否已登陆");
    var islogin = true;
    $.get(checkUserIsLoginURL, function (result) {
        if (4000 == result.code) {
            window.location.href = encodeURI("user-login.html");
            islogin = false;
        }
    });

    if (!islogin) {
        return;
    }

    //获取视频分类列表
    var URL_videocls = "/sdyweb/videocls/findAllVideoClazzs";
    $.get(URL_videocls, function (data) {
        var videoclss = data.videoClazzs;
        if (null == videoclss) {
            return;
        }
        for (var i = 0; i < videoclss.length; i++) {
            var videoclz = videoclss[i];
            if (i == 0) {
                $("#video_cls").after("<label class='radio-inline'>" +
                    "<input type='radio' checked='checked' name='classid'  value='" + videoclz.id + "'>"
                    + videoclz.name + "</label>");
            } else {
                $("#video_cls").after("<label class='radio-inline'>" +
                    "<input type='radio' name='classid'  value='" + videoclz.id + "'>"
                    + videoclz.name + "</label>");
            }
        }
    });

    //获取视频详情
    var URL_videocls_detail = "/sdyweb/video/findVideosByID";
    var videoid=getUrlParam("id");
    if (null==videoid||""==videoid){
        return;
    }
    $.get(URL_videocls_detail+"?id="+videoid, function (data) {
        if (4000 == data.code) {
            $("#notice").text("查询失败，刷新试试");
            return;
        }
        var video=data.video;
        $("#id").val(video.id);
        $("#uploadtime").val(video.uploadtime);
        $("#title").val(video.title);
        $("#content").val(video.content);
        $("#source").val(video.source);
        $("#duration").val(video.duration);
        $("#language").val(video.language);
        $("#videourl").val(video.videourl);
        $("#videourl").attr("readOnly",true);
        $("#outlineImgUrl").val(video.outlineImgUrl);
        $("#imgurl").attr("src","/images/"+video.outlineImgUrl);
    });


    //1 提交表单
    $("#submitbtn").click(function () {
        if (!chechInputIsOK()) {
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


    /**
     * 检测输入是否OK
     */
    function chechInputIsOK() {
        console.log("检测输入是否OK");
        var title = $("#title").val();
        if (null == title || "" == title.trim() || title.length > 30) {
            $("#notice").text("标题不合法");
            return false;
        }
        var content = $("#content").val();
        if (null == content | "" == content.trim()) {
            $("#notice").text("视频描述未输入");
            return false;
        }

        var source = $("#source").val();
        if (null == source | "" == source.trim()) {
            $("#notice").text("来源未输入");
            return false;
        }

        var duration = $("#duration").val();
        if (null == duration | "" == duration.trim()) {
            $("#notice").text("视频时长未输入");
            return false;
        }

        var language = $("#language").val();
        if (null == language | "" == language.trim()) {
            $("#notice").text("语言未输入");
            return false;
        }

        var videourl = $("#videourl").val();
        if (null == videourl | "" == videourl.trim()) {
            $("#notice").text("视频地址未输入");
            return false;
        }

        $("#notice").text("添加中....");
        return true;
    }
});