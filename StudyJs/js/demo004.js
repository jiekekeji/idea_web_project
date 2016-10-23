/**
 * Created by Administrator on 2016/10/14.
 */
window.addEventListener("load", function () {
    //嵌套型的
    $(".out").click(function () {
        console.log("out click");
    });
    $(".inner").click(function (event) {
        console.log("inner click");

        //阻止冒泡方法1
        event.stopPropagation();
        //阻止冒泡方法2
        //return false;阻断事件继续传递。就是不让它冒泡
        // return false;
    });
    //阻止默认事件,默认的a标签是会跳转的
    $(".baidu").click(function (event) {
        event.preventDefault();
    });
    //表单事件
    $("#submit").click(function (event) {
        var name = $(".other form input[name='name']").val();
        var psw = $(".other form input[name='psw']").val();
        console.log("name="+name+"&"+"psw="+psw);
        if (name == "" || psw == "") {
            //阻止事件提交
            event.preventDefault();
        }else {

        }
    });


});