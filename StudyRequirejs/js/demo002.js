$(document).ready(function () {
    var age = 12;

    console.log("type of=" + typeof age);

    console.log("hostname=" + location.hostname);
    console.log("pathname=" + location.pathname);
    console.log("port=" + location.port);
    console.log("protocol=" + location.protocol);
    console.log("href=" + location.href);
    console.log("Pathname=" + location.pathname);


    $(".newDoc1").click(function () {
        openDoc1();
    });

    $(".newDoc2").click(function () {
        openDoc2();
    });

    $(".newDoc3").click(function () {
        openDoc3();
    });

    $(".newDoc4").click(function () {
        openDoc4();
    });

    /**********历史记录**********************/
    $(".his1").click(function () {
        history.back();
    });
    $(".his2").click(function () {
        history.forward();
    });
    $(".his3").click(function () {
        history.go(-2);
    });
    $(".his4").click(function () {
        console.log("history.length="+history.length);
    });


    function openDoc1() {
        location.assign("http://baidu.com");
    }

    function openDoc2() {
        location.href = "http://google.com";
    }

    function openDoc3() {
        //该方法不会产生历史记录，无法后退
        location.replace("http://zhibo8.cc");
    }

    function openDoc4() {
        //重新载入当前文档
        location.reload();
    }

});