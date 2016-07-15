/**
 * Created by Administrator on 2016-07-15.
 */
$(document).ready(function () {
    console.log("页面加载完成");
    if (navigator.geolocation) {
        console.log("该浏览器支持获取地理位置。");
    }else {
        console.log("该浏览器不支持获取地理位置.");
    }

});
