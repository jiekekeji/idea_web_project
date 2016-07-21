/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {

        /*********** start 相关URL **********************/
        var checkUserIsLoginURL = "/sdyweb/user/checkUserIsLogin";
        var URL_findVideoClazz = "/sdyweb/video/findVideoClazz";
        var URL_findVideoClazzByName = "/sdyweb/video/findVideoClazzByName";
        /*********** end 相关URL **********************/

        /*********** start 待调用的相关方法 **********************/
        function getVideoClazzs(page, rows) {
            $.get(URL_findVideoClazz + "?page=" + page + "&rows=" + rows, function (data) {
                if (null == data.videoClazzs) {
                    return;
                }
                setPageContent(data.videoClazzs);
            });
        }

        //根据分类名称搜索
        function findVideoClazzByName(name, page, rows) {
            $.get(URL_findVideoClazzByName + "?page=" + page + "&rows=" + rows + "&name=" + name, function (data) {
                if (null == data.videoClazzs) {
                    return;
                }
                setPageContent(data.videoClazzs);
            });

        }

        //填充表格
        function setPageContent(videoClazzs) {
            console.log("填充数据");
            $("#tb-body").empty();
            for (var i = 0; i < videoClazzs.length; i++) {
                var videoClazz = videoClazzs[i];
                $("#tb-body").append(
                    "<tr>" +
                    "<td>" + videoClazz.id + "</td>" +
                    "<td>" + videoClazz.name + "</td>" +
                    "<td>" + videoClazz.totalCount + "</td>" +
                    "</tr>"
                )
            }
        }


        /*********** end 待调用的相关方法 **********************/

        //页面加载完成后开始加载数据

        //001、start 页面加载完成,检测用户是否已登陆
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

        //002、加载分类列表
        getVideoClazzs(0, 15);

        //003、设置按钮监听
        $("#search_btn").click(function () {
            var keyword=$("#keyword").val();
            if (null==keyword||""==keyword){
                return;
            }
            findVideoClazzByName(keyword,0,15);
        });

    }
);