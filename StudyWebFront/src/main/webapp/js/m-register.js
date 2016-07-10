/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

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
        $.get("/sdyweb/user/checkUserIsExit?username="+value, function(result){
            console.log("用户名检测结果:"+result.code);
        });

    });
    
    $("#rigesterbtn").click(function () {
        var username = $("#exampleInputEmail1").val();
        console.log("提交注册:"+username);
        //发送注册请求
        $.get("/sdyweb/user/checkUserIsExit?username="+username, function(result){
            console.log("用户名检测结果:"+result.code);


            //实现页面跳转
            window.location.href="login.html?username="+result.desc;
        });
    });
    
    

});