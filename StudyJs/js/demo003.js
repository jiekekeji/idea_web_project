/**
 * Created by Administrator on 2016/10/14.
 */
window.addEventListener("load", function () {
    console.log("********demo003.js***********");

    /*********回调函数***********/
    function callback1() {
        for (var i = 0; i < 20; i++) {
            console.log("callback=" + i);
        }
    }

    //fn1函数指定到一定条件时通知回调函数执行
    function fn1(callback) {
        for (var i = 0; i < 20; i++) {
            console.log("callback before=" + i);
        }
        //中间插一脚过来执行，call函数
        callback();
        for (var i = 0; i < 20; i++) {
            console.log("callback after=" + i);
        }
    }

    //将callback1函数作为参数传递
    fn1(callback1);


    /*********事件监听***********/
    function fn3() {
        for (var i = 0; i < 20; i++) {
            console.log("fn3=" + i);
        }
    }

    function fn4() {
        for (var i = 0; i < 20; i++) {
            console.log("fn4=" + i);
            if (i == 10) {
                fn4().trigger('done');
            }
        }
    }
    fn4().on('done', fn3);
    fn4();

});