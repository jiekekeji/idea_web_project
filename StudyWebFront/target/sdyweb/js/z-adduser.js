/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    /*****start 页面加载完成，获取登录的用户名，填在表单中****/
    $.get("/sdyweb/user/getUserRoles",
        function (data) {
            console.log("数据获取结果:" + data.desc);
            switch (data.code) {
                case 2000://获取成功
                    $("#userRoles").append("<label>选择角色</label>");
                    for (var i = 0; i < data.roles.length; i++) {
                        $("#userRoles").append("<label class='radio-inline'>")
                            .append("<input type='radio' name='inlineRadioOptions' id='radio1' value='option1'>")
                            .append(data.roles[i].roleName)
                            .append("</label>");
                    }
                    break;
                case 4000://未登录
                    window.location.href = "login.html";
                    break;
                default:
                    alert("数据获取失败，请稍后重试!");
                    break;
            }
        }, "json");
    /*****end 页面加载完成，获取登录的用户名，填在表单中****/

    /*****start 设置监听  ****/
    $("#submitbtn").click(function () {
        if (null == $("#username").val() || "" == $("#username").val()) {
            alert("用户名不能为空");
            return;
        }

        if (null == $("#password0").val() || "" == $("#password0").val()) {
            alert("密码不能为空");
            return;
        }

        if (null == $("#password1").val() || "" == $("#password1").val()) {
            alert("确认密码不能为空");
            return;
        }

        if ($("#password1").val()!= $("#password1").val()) {
            alert("两次密码不一致!");
            return;
        }

        

    });


    /*****end 设置监听  ****/

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