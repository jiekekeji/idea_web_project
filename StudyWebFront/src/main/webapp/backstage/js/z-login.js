/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

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
            {username: $("#usernameinput").val(), password: $('#passwordinput').val()},
            function (data) {
                if (2000 == data.code) {
                    //登录成功
                    window.location.href = "admin-manage.html?username=" + $("#usernameinput").val();
                } else {
                    //登录失败
                    alert("登陆失败");
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


});