/**
 * Created by Administrator on 2016/8/12.
 */
$(document).ready(function () {

    //当鼠标进入tab导航时显示子导航
    $(".toptab li").mouseenter(function () {
        console.log("鼠标进入" + $(this).attr("id"));
        $("#topchild1").removeClass("topchildHide");
        $("#topchild1").addClass("topchild");
    });
    //当鼠标离开tab导航时隐藏子导航
    $(".toptab li").mouseleave(function (event) {
        //鼠标的位置
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
            $("#topchild1").removeClass("topchild");
            $("#topchild1").addClass("topchildHide");
        }
    });

    //子菜单的移入移出
    $("#topchild1").mouseleave(function () {
        $(this).removeClass("topchild");
        $(this).addClass("topchildHide");
    });

});
