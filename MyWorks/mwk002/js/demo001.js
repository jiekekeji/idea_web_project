/**
 * Created by jack on 16/10/17.
 */
$(document).ready(function () {

    var list = new Hammer($(".list")[0]);
    var startY = 0;
    var defaultMrTop=getOrgiListMrTop();
    //拖动开始
    list.on("panstart", function (ev) {
        startY = ev.deltaY;
    })
    //向下拖动
    list.on("pandown", function (ev) {
        var distance = ev.deltaY - startY;
        console.log("distance="+distance);
        $(".content").css("margin-top",defaultMrTop+distance+"px");
    })
    //拖动结束
    list.on("panend", function (ev) {
        console.log("拖动结束:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })

    /**
     * 获取原始头部的margin-top距离
     */
    function  getOrgiListMrTop(){
        var defaultMrTop = $(".content").css("margin-top");
        defaultMrTop=defaultMrTop.substr(0,defaultMrTop.length-2);
        return defaultMrTop;
    }
});