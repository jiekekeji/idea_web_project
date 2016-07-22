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
    //查询置顶
    var URL_findVideosByIsTop = "/sdyweb/video/findVideosByIsTop";
    //查询审核中
    var URL_findVideosByIsTop = "/sdyweb/video/findVideosByStatus";


    var searchType = "";
    var page = 0;
    //**************************start 相关方法**************************

    //查询置顶视频
    function findVideosByIsTop(page, rows) {
        $.get(URL_findVideosByIsTop + "?page=" + page + "&rows=" + rows, function (data) {
            if (null == data.videos) {
                return;
            }
            setPageContent(data.videos);
        });
    }

    //查询审核中视频
    function findVideosByStatus(page, rows) {
        $.get(URL_findVideosByIsTop + "?page=" + page + "&rows=" + rows, function (data) {
            if (null == data.videos) {
                return;
            }
            setPageContent(data.videos);
        });
    }

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
        $.get(URL_findVideos + "?page="+page + "&rows="+rows, function (data) {
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
                "<td><a href=" + "'" + "/sdyweb/video/deleteVideoByVideoid?id=" + video.id + "'" + "  id='deleteBtn'>删除</a></td>" +
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
    findVideos(0, 50);

    //搜索监听
    $("#search_btn").click(function () {
        //开始搜索
        searchType = $("#search_type option:selected").text();
        if ("审核中" == searchType) {
            findVideosByStatus(0, 50);
        } else if ("推荐" == searchType) {
            findVideosByIsTop(0, 50);
        } else {
            findVideos(0, 50);
        }
    });

    //上一页
    $("#pre_btn").click(function () {
        if (page==0){
            return;
        }
        page = page - 50;
        if ("审核中" == searchType) {
            findVideosByStatus(page, 50);
        } else if ("推荐" == searchType) {
            findVideosByIsTop(page, 50);
        } else {
            findVideos(page, 50);
        }
    });

    //下一页
    $("#next_btn").click(function () {
        page = page +50;
        if ("审核中" == searchType) {
            findVideosByStatus(page, 50);
        } else if ("推荐" == searchType) {
            findVideosByIsTop(page, 50);
        } else {
            findVideos(page, 50);
        }
    });

});