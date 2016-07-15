/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

    /*****start 页面加载完成，获取登录的用户名，填在表单中****/
    getDatas(0, 15);

    /*****end 页面加载完成，获取登录的用户名，填在表单中****/


    /**
     * 发送请求获取数据并填充页面
     * @param username
     * @param page
     * @param rows
     */
    function getDatas(page, rows) {
        $.post("/sdyweb/user/findAdmins",
            {page: page, rows: rows},
            function (data) {
                console.log("获取数据结果:" + data.users);
                for (var i = 0; i < 15; i++) {
                    console.log("填充数据");
                    $("#tb-body").append(
                        "<tr>" +
                        "<td>" + i + "</td>" +
                        "<td>用户名</td>" +
                        "<td>昵称</td>" +
                        "<td>手机号</td>" +
                        "<td>邮箱</td>" +
                        "<td><button class='btn -default'>编辑</button></td>" +
                        "<td><button class='btn -default'>删除</button></td>" +
                        "</tr>"
                    )
                }
            },
            "json");
    }


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


});