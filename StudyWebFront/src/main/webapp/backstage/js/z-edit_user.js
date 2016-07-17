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

    var username=getUrlParam("username");
    if (null==username||""==username){
        username=sessionStorage.getItem("edit_username");
    }else{
        sessionStorage.setItem("edit_username",username);
    }


    //请求数据填充表单
    $.get("/sdyweb/user/findUserByUsername?username="+username,function (data) {
        console.log("查询用户信息:"+data.code);
        if (4000==data.code){
            $("#notice").text("遇到错误,请重试");
            return;
        }

        var user=data.user;
        $("#username").val(user.username);
        $("#username").attr("readOnly",true);
        $("#nickname").val(user.nickname);
        $("#phonenum").val(user.phonenum);
        $("#email").val(user.email);
        $("#introduce").val(user.introduce);

        $("#qq").val(user.qq);
        $("#headerurl").val(user.headerurl);
        $("#weixin").val(user.weixin);


    });

    /*****start 给控件设置监听 ****/
    //1提交按钮
    $("#submitbtn").click(function () {
         //提交更新
        $("#adduser_form").submit(function () {
            $(this).ajaxSubmit(function (data) {
                console.log("更新状态状态:code=" + data.code);
                if (2000 == data.code) {
                    window.location.href = encodeURI("./user-list.html");
                } else {
                    $("#notice").text("注册失败,请修改后重试");
                }
            });
        });
    });



});