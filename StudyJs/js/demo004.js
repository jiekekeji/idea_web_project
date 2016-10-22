/**
 * Created by Administrator on 2016/10/14.
 */
window.addEventListener("load", function () {
    $(".out").click(function () {
        console.log("out click");
    });
    $(".inner").click(function () {
        console.log("inner click");

        //return false;阻断事件继续传递。就是不让它冒泡
        return false;
    });
});