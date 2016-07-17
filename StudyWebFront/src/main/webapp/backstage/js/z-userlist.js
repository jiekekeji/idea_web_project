/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    //*******start静态页面加载完成开始加载数据***********//
    console.log("页面加载完成开始加载数据");

    //请求地址
    var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";

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
    //获取当前登陆的用户
    var getLoginUserURL = "/sdyweb/user/getLoginUser";
    //获取用户列表
    var findOrdinaryUsersURL = "/sdyweb/user/findOrdinaryUsers";

    $.get(getLoginUserURL, function (data) {
        console.log("获取当前登陆用户:" + data.code);
        if (data.code == 2000) {
            $("#dLabel").text("");
            $("#dLabel").text("当前登陆用户: " + data.user.username);
        } else {
            $("#dLabel").html("登陆");
        }
    });

    //获取用户列表
    var paras = {"page": 0, "rows": 15};
    $.post(findOrdinaryUsersURL, paras, function (data) {
        console.log("获取用户列表:" + data.users)
        if (null == data.users) {
            return;
        }
        setPageContent(data.users);
    });

    //填充表格
    function setPageContent(users) {
        console.log("填充数据");
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
                "<td><a href="+"'"+"/sdyweb/backstage/edit-user.html?username="+user.username+"'"+">编辑</a></td>" +
                "<td><a >删除</a></td>" +
                "</tr>"
            )
        }
    }
});