/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    //*******start静态页面加载完成开始加载数据***********//
    console.log("页面加载完成开始加载数据");

    //检测是否已登陆
    var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";
    //根据手机号搜索
    var findUserByPhonenumURL = "/sdyweb/user/findUserByPhonenum";
    //根据用户名搜索
    var findUsersByUsernameURL = "/sdyweb/user/findUsersByUsername";
    //获取当前登陆的用户
    var getLoginUserURL = "/sdyweb/user/getLoginUser";
    //获取用户列表
    var findOrdinaryUsersURL = "/sdyweb/user/findOrdinaryUsers";

    //**************************start 相关方法**************************

    //根据用户名获取用户列表
    function getUserListByUsername(keyword, page, rows) {
        console.log("根据用户名获取用户列表");
        $.get(findUsersByUsernameURL + "?username=" + keyword + "&page=" + page + "&rows=" + rows, function (data) {
            console.log("根据用户名获取用户列表:" + data.users)
            if (null == data.users) {
                return;
            }
            setPageContent(data.users);
        });
    }

    //根据手机号获取用户列表
    function getUserListByPhonenum(keyword, page, rows) {
        console.log("根据手机号获取用户列表");
        $.get(findUserByPhonenumURL + "?phonenum=" + keyword + "&page=0" + "&rows=15", function (data) {
            console.log("根据手机号获取用户列表:" + data.users)
            if (null == data.users) {
                return;
            }
            setPageContent(data.users);
        });
    }

    //获取用户列表
    function getUserList(paras) {
        $.post(findOrdinaryUsersURL, paras, function (data) {
            console.log("获取用户列表:" + data.users)
            if (null == data.users) {
                return;
            }
            setPageContent(data.users);
        });
    }

    //填充表格
    function setPageContent(users) {
        console.log("填充数据");
        $("#tb-body").empty();
        for (var i = 0; i < users.length; i++) {
            var user = users[i];
            $("#tb-body").append(
                "<tr>" +
                "<td>" + user.id + "</td>" +
                "<td>" + user.username + "</td>" +
                "<td>" + user.nickname + "</td>" +
                "<td>" + user.phonenum + "</td>" +
                "<td>" + user.registertime + "</td>" +
                "<td>" + user.roleid + "</td>" +
                "<td><a href=" + "'" + "/sdyweb/backstage/edit-user.html?username=" + user.username + "'" + ">编辑</a></td>" +
                "<td><a href='#'>暂不支持该功能</a></td>" +
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
    var paras = {"page": 0, "rows": 15};
    getUserList(paras);

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