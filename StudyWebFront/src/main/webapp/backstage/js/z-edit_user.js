/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    //请求地址
    var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";
    //start 页面加载完成,检测用户是否已登陆
    console.log("检测用户是否已登陆");
    var islogin=true;
    $.get(checkUserIsLoginURL, function (result) {
        if (4000 == result.code) {
            window.location.href = encodeURI("user-login.html");
            islogin=false;
        }
    });

    if (!islogin){
        return;
    }

    //请求数据填充表单



    /*****start 给控件设置监听 ****/
    //1 登录按钮
    $("#submitbtn").click(function () {
        if (!chechInputIsOK()) {
            return;
        }
         //提交注册
        $("#adduser_form").submit(function () {
            $(this).ajaxSubmit(function (data) {
                console.log("注册状态:code=" + data.code);
                if (2000 == data.code) {
                    window.location.href = encodeURI("./user-list.html");
                } else {
                    $("#notice").text("注册失败,请修改后重试");
                }
            });
        });
    });


    /**
     * 检测输入是否OK
     */
    function chechInputIsOK() {
        console.log("检测输入是否OK");
        var username = $("#username").val();
        if (null == username || "" == username.trim() || username.length > 16) {
            $("#notice").text("用户名输入不合法");
            return false;
        }
        var password0 = $("#password0").val();
        if (null == password0 | "" == password0.trim()) {
            $("#notice").text("密码未输入");
            return false;
        }

        var password1 = $("#password1").val();
        if (null == password1 | "" == password1.trim()) {
            $("#notice").text("密码未输入");
            return false;
        }

        if (password1 != password0) {
            $("#notice").text("两次密码输入不一致");
            return false;
        }
        var phonenum = $("#phonenum").val();
        if (null == phonenum | "" == phonenum.trim()) {
            $("#notice").text("手机号未输入");
            return false;
        }

        var email = $("#email").val();
        if (null == email | "" == email.trim()) {
            $("#notice").text("邮箱未输入");
            return false;
        }

        $("#notice").text("注册中....");
        return true;
    }
});