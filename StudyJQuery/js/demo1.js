/**
 * Created by Administrator on 2016-07-15.
 */
$(document).ready(function () {
    console.log("页面加载完成");

    // // get请求示例
    // var url1 = "http://www.tngou.net/api/info/classify";
    // $.getJSON(url1, function (data, status) {
    //     alert("Data: " + data + "nStatus: " + status);
    // });
    if (window.localStorage) {
        alert("浏览支持localStorage")
    }
    else {
        alert("浏览暂不支持localStorage")
    }


    setTimeout(function () {
        for (var i = 0; i < 500; i++) {
            console.log("t1");
        }
    }, 0);

    setTimeout(function () {
        for (var i = 0; i < 500; i++) {
            console.log("t2");
        }
    }, 0);

    setTimeout(function () {
        for (var i = 0; i < 500; i++) {
            console.log("t3");
        }
    }, 0);


});
