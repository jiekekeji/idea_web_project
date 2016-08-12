/**
 * Created by Administrator on 2016/8/12.
 */
$(document).ready(function () {
    // start 顶部导航及其子导航
    $(".toptab li").mouseenter(function () {
        //当鼠标进入tab导航时显示子导航
        console.log("鼠标进入" + $(this).attr("id"));
        var topchildId = $(this).attr("id").split("#")[1];
        $("#" + topchildId).removeClass("topchildHide");
        $("#" + topchildId).addClass("topchild");
    });
    $(".toptab li").mouseleave(function (event) {
        //当鼠标离开tab导航时隐藏子导航
        //鼠标的位置,当鼠标离开时,判断鼠标是否已移入子导航中,如果移入子导航中,则不隐藏,否则隐藏
        var x = event.clientX;
        var y = event.clientY;
        console.log("x=" + x + " y= " + y);

        //获取子tab的位置
        var div = $("#topchild1");
        var left = div.offset().left;
        var top = div.offset().top;
        var right = div.width();
        var bottom = div.height();
        //var mx = left + div.offsetWidth();
        //var my = top + div.offsetHeight();
        console.log("left=" + left + " top= " + top + " right= " + right + " bottom= " + bottom);

        //判断鼠标是否移入子菜单中
        if (x < left || x > right || y < top || y > bottom) {
            //如果离开，则执行。。
            $(".basetab").removeClass("topchild");
            $(".basetab").addClass("topchildHide");
        }
    });
    //子菜单的移入移出
    $(".basetab").mouseleave(function () {
        $(this).removeClass("topchild");
        $(this).addClass("topchildHide");
    });
    // end 顶部导航及其子导航

    //start 左侧菜单和图片轮播
    $(".leftnavTab li").mouseenter(function (event) {
        //鼠标进入
        var lefttabID = $(this).attr("id");
        console.log("左侧菜单ID=" + lefttabID);
        var leftChildID = lefttabID.split("#")[1];
        $("#" + leftChildID).removeClass("leftnavchildHidden");
        $("#" + leftChildID).addClass("leftnavchild");
    });
    $(".leftnavTab li").mouseleave(function (event) {
        //鼠标移出
        var lefttabID = $(this).attr("id");
        console.log("左侧菜单ID=" + lefttabID);
        var leftChildID = lefttabID.split("#")[1];


        //鼠标的位置
        var x = event.clientX;
        var y = event.clientY;
        console.log("x=" + x + " y= " + y);

        //获取子tab的位置
        var child = $("#" + leftChildID);
        var left = child.offset().left;
        var top = child.offset().top;
        var right = child.width();
        var bottom = child.height();
        console.log("left=" + left + " top= " + top + " right= " + right + " bottom= " + bottom);

        //判断鼠标是否移入子菜单中
        if (x < left || x > right || y < top || y > bottom) {
            //如果离开，则执行。。
            $(".leftBase").removeClass("leftnavchild");
            $(".leftBase").addClass("leftnavchildHidden");
        }

    });
    //子菜单的移入移出
    $(".leftBase").mouseleave(function () {
        $(this).removeClass("leftnavchild");
        $(this).addClass("leftnavchildHidden");
    });

    //end 左侧菜单和图片轮播
});
