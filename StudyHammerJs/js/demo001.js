/**
 * Created by Administrator on 2016/10/19.
 */
$(document).ready(function () {
    //初始化Hammer并传入需要操作的doc元素，不是jquery对象
    var panDivHr = new Hammer($("#pan")[0]);

    //**********拖动事件*********************//
    panDivHr.on("pan", function (ev) {
        //这个偏移量是以当前元素的左上角顶点为准
        console.log("X偏移量:" + ev.deltaX);
        console.log("Y偏移量:" + ev.deltaY);
    });

    //拖动开始
    panDivHr.on("panstart", function (ev) {
        console.log("拖动开始:" + +"x=" + ev.deltaX + " y=" + ev.deltaY);
    })
    //拖动过程
    panDivHr.on("panmove", function (ev) {
        console.log("拖动过程:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })
    //拖动结束
    panDivHr.on("panend", function (ev) {
        console.log("拖动结束:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })
    //拖动取消
    panDivHr.on("pancancel", function (ev) {
        console.log("拖动取消:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })
    //向左拖动
    panDivHr.on("panleft", function (ev) {
        console.log("向左拖动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })
    //向右拖动
    panDivHr.on("panright", function (ev) {
        console.log("向右拖动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })
    //向上拖动
    panDivHr.on("panup", function (ev) {
        console.log("向上拖动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })
    //向下拖动
    panDivHr.on("pandown", function (ev) {
        console.log("向下拖动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })


    //**********点击事件和tap事件*********************//
    //tap事件优先于click事件触发
    panDivHr.on("tap", function () {
        console.log("tap事件");
    });
    $("#pan").click(function () {
        console.log("click事件");
    });

    //**********滑动事件*********************//
    panDivHr.on("swipe", function (ev) {
        console.log("滑动事件:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    });
    //向左滑动
    panDivHr.on("swipeleft", function (ev) {
        console.log("向左滑动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    });
    //向右滑动
    panDivHr.on("swiperight", function (ev) {
        console.log("向右滑动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    });
    //向上滑动
    panDivHr.on("swipeup", function (ev) {
        console.log("向上滑动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    });
    //向下滑动
    panDivHr.on("swipedown", function (ev) {
        console.log("向下滑动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    });

    //**********Press事件*********************//
    //按下一段时间触发
    panDivHr.on("press", function () {
        console.log("Press事件");
    });
    //按下后离开后触发
    panDivHr.on("pressup", function () {
        console.log("pressup事件");
    });

});



