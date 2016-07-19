/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    //*******start静态页面加载完成开始加载数据***********//
    console.log("页面加载完成开始加载数据");

    //检测是否已登陆
    var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";
    //查询所有
    var URL_findVideos = "/sdyweb/video/findVideos";
    //根据分类查询
    var URL_findVideosByClassID = "/sdyweb/user/findVideosByClassID";
    //获取当前登陆的用户
    var getLoginUserURL = "/sdyweb/user/getLoginUser";
    //**************************start 相关方法**************************

    //根据分类获取视屏列表
    function findVideosByClassID(classid, page, rows) {
        $.get(URL_findVideosByClassID + "?classid=" + classid + "&page=" + page + "&rows=" + rows, function (data) {
            if (null == data.videos) {
                return;
            }
            setPageContent(data.videos);
        });
    }

    //获取视频列表
    function findVideos(page, rows) {
        $.get(URL_findVideos + "?page=0" + "&rows=15", function (data) {
            if (null == data.videos) {
                return;
            }
            setPageContent(data.videos);
        });
    }

    //填充表格
    function setPageContent(videos) {
        $("#tb-body").empty();
        for (var i = 0; i < videos.length; i++) {
            var video = videos[i];
            $("#tb-body").append(
                "<tr>" +
                "<td>" + video.id + "</td>" +
                "<td>" + video.title + "</td>" +
                "<td>" + video.source + "</td>" +
                "<td>" + video.uploadtime + "</td>" +
                "<td>" + video.duration + "</td>" +
                "<td>" + video.status + "</td>" +
                "<td>" + video.classid + "</td>" +
                "<td><a href=" + "'" + "/sdyweb/backstage/edit-video.html?id=" + video.id + "'" + ">编辑</a></td>" +
                "<td><a href=" + "'" + "/sdyweb/backstage/edit-video-img.html?id=" + video.id + "&outlineImgUrl=" + video.outlineImgUrl + "'" + ">修改图片</a></td>" +
                "<td><a href='#'>删除</a></td>" +
                "</tr>"
            )
        }
    }

    //**************************end 相关方法**************************


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

    //获取当前登陆用户
    $.get(getLoginUserURL, function (data) {
        console.log("获取当前登陆用户:" + data.code);
        if (data.code == 2000) {
            $("#dLabel").text("");
            $("#dLabel").text("当前登陆用户: " + data.user.username);
        } else {
            $("#dLabel").html("登陆");
        }
    });

    //初始化用户列表数据
    findVideos(0, 15);

    //搜索监听
    $("#search_btn").click(function () {
        var keyword = $("#search_key").val();
        if (null == keyword || "" == keyword) {
            getUserList(paras);
            return;
        }

        //开始搜索
        var searchType = $("#search_type option:selected").text();
        if ("手机号" == searchType) {
            getUserListByPhonenum(keyword, 0, 15);
        } else if ("用户名" == searchType) {
            getUserListByUsername(keyword, 0, 15);
        }
    });


});