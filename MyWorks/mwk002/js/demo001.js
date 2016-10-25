/**
 * Created by jack on 16/10/17.
 */
$(document).ready(function () {


    var startY = 0;
    var defaultMrTop = getOrgiListMrTop();
    initDragDownListener();
    /**
     * 初始化下拉事件
     */
    function initDragDownListener() {
        var list = new Hammer($(".list")[0]);
        //拖动开始
        list.on("panstart", function (ev) {
            startY = ev.deltaY;
        })
        //向下拖动
        list.on("pandown", function (ev) {
            var distance = ev.deltaY - startY + parseInt(defaultMrTop);
            $(".list").css("margin-top", (distance) + "px");
        })
        //拖动结束
        list.on("panend", function (ev) {
            reSet2Loading();
        })
    }

    /**
     * 恢复到正在加载数据的状态
     */
    function reSet2Loading() {
        $(".list").animate({
            "margin-top": "0px",
        }, 1000 * 1);
        reFreshData();
    }

    /**
     * 加载数据的方法
     */
    function reFreshData() {
        setTimeout(function(){
            reSetOrig();
        },1000*5);
    }

    /**
     * 恢复到原始的状态
     */
    function reSetOrig() {
        $(".list").animate({
            "margin-top": "-60px",
        }, 1000 * 1);
    }

    /**
     * 获取原始头部的margin-top距离
     */
    function getOrgiListMrTop() {
        var defaultMrTop = $(".list").css("margin-top");
        defaultMrTop = defaultMrTop.substr(0, defaultMrTop.length - 2);
        return defaultMrTop;
    }
});