/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    //*******start静态页面加载完成开始加载数据***********//
    console.log("页面加载完成开始加载数据");
    for (var i=0;i<15;i++) {
        console.log("填充数据");
        $("#tb-body").append(
            "<tr>" +
            "<td>"+i+"</td>" +
            "<td>用户名</td>" +
            "<td>昵称</td>" +
            "<td>手机号</td>" +
            "<td>邮箱</td>" +
            "<td>性别</td>" +
            "<td><button class='btn -default'>编辑</button></td>" +
            "<td><button class='btn -default'>删除</button></td>" +
            "</tr>"
        )
    }


    /*****start 页面加载完成，获取登录的用户名，填在表单中****/
    var username = getUrlParam("username");
    // username=decodeURI(username);
    console.log("地址中url参数username=" + username);
    $("#usernameinput").val(username);

    /*****end 页面加载完成，获取登录的用户名，填在表单中****/

    /*****start 给控件设置监听 ****/
    //登录按钮
    $("#loginbtn").click(function () {
        $.post("/sdyweb/user/login",
            {username: $("#usernameinput").val(), password: $('#exampleInputPassword').val()},
            function (data) {
                if (2000 == data.code) {
                    //登录成功
                    console.log("登录成功：" + data.code);
                    window.location.href = "index.html?username=" + $("#usernameinput").val();
                } else {
                    //登录失败
                    console.log("登录失败：" + data.code);
                }

            },
            "json");//这里返回的类型有：json,html,xml,text

    });

    /*****end 给控件设置监听 ****/

    /**
     * 获取url中的参数值
     * @param name
     * @returns {null}
     */
    function getUrlParam(name) {
        //构造一个含有目标参数的正则表达式对象
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        //匹配目标参数
        var r = window.location.search.substr(1).match(reg);
        //返回参数值
        if (r != null) return decodeURI(unescape(r[2]));
        return null;
    }


    //给输入框添加焦点事件
    $("#exampleInputEmail1").focus(function () {
        console.log("获取焦点");
    });

    //input失去焦点的事件
    $("#exampleInputEmail1").blur(function () {
        console.log("失去焦点");
        var value = $("#exampleInputEmail1").val();
        if (null == value || "" == value) {
            $("#notice").text("请输入用户名");
            $("#exampleInputEmail1").focus();
            return;
        }

        //发送请求检测用户是否可注册
        $.get("/sdyweb/user/checkUserIsExit?username=" + value, function (result) {
            console.log("用户名检测结果:" + result.code);
        });

    });

    $("#rigesterbtn").click(function () {
        var username = $("#exampleInputEmail1").val();
        console.log("提交注册:" + username);
        //发送注册请求
        $.get("/sdyweb/user/checkUserIsExit?username=" + username, function (result) {
            console.log("用户名检测结果:" + result.code);


            //实现页面跳转
            window.location.href = "login.html?username=" + result.desc;
        });
    });


});