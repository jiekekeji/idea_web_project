/**
 * Created by jack on 16/10/17.
 */
$(document).ready(function () {

    var list = new Hammer($(".list")[0]);
    //向下拖动
    list.on("pandown", function (ev) {
        console.log("向下拖动:" + "x=" + ev.deltaX + " y=" + ev.deltaY);
    })
});