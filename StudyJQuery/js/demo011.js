$(document).ready(function () {
    //显示和隐藏
    $("#div1").click(function () {
        if ($("#div2").is(":visible")) {
            $("#div2").hide();
        } else {
            $("#div2").show();
        }
    });
    //显示和隐藏另一种写法
    $("#div3").click(function () {
        $("#div4").toggle();
    });
    //淡入:$(selector).fadeIn(speed,callback);
    //可选的 speed 参数规定效果的时长。它可以取以下值："slow"、"fast" 或毫秒。.
    // 可选的 callback 参数是 fading 完成后所执行的函数名称。
    $("#div5").click(function () {
        //另一种判断显示和隐藏的方式
        if ($("#div6").css('display') == "block") {
            $("#div6").fadeOut("slow");
        } else {
            $("#div6").fadeIn("slow");
        }
    });
    //fadeToggle
    $("#div7").click(function () {
        $("#div8").fadeToggle("slow");
    });
    //slideDown() 和jQuery slideUp()
    $("#div9").click(function () {
        if ($("#div10").css('display') == "block") {
            $("#div10").slideUp("slow");
        } else {
            $("#div10").slideDown("slow");
        }
    });
    //jQuery动画实现上滑和下滑的效果
    $("#div11").click(function () {
        var height=$("#div12").css('height');
        if ($("#div12").css('height') == "50px") {
            $("#div12").animate({height:"0px",width:"0px"});
        } else {
            $("#div12").animate({height:"50px",width:"50px"});
        }
    });
    //停止动画
    $("#stopAnim").click(function () {
        $("#div12").stop();
        //阻止事件冒泡和默认行为
        return false;
    });
});