/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    //请求地址
    var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";

    //start 页面加载完成,检测用户是否已登陆
    console.log("检测用户是否已登陆");
    $.get(checkUserIsLoginURL, function (result) {
        if (2000 == result.code) {
            window.location.href = encodeURI("backstage/user-list.html");
        }
    }, "json");

    //start 如果ULR中包含用户名,说明是注册页面过来的
    console.log("判断URL中是否有参数username");
    var username = getUrlParam("username");
    if (null != username) {
        $("#usernameinput").val(username);
    }


    /*****start 给控件设置监听 ****/
    //1 登录按钮
    $("#loginbtn").click(function () {
        if (!chechInputIsOK()) {
            return;
        }

        $("#loginform").submit(function() {
            $(this).ajaxSubmit(function(data) {
                console.log("登陆状态:code="+data.code);
                if (2000 == data.code) {
                    window.location.href = encodeURI("user-list.html");
                }else{
                    $("#notice").text("登陆失败,请修改后重试");
                }
            });
        });
    });

    /**
     * 检测输入是否OK
     */
    function chechInputIsOK() {
        console.log("检测输入是否OK");
        var username = $("#usernameinput").val();
        if (null == username ||""==username.trim()|| username.length > 16) {
            $("#notice").text("用户名输入不合法");
            return false;
        }
        var password = $("#passwordinput").val();
        if (null == password|""==password.trim()) {
            $("#notice").text("密码未输入");
            return false;
        }

        $("#notice").text("登录中....");
        return true;
    }

});