/**
 * Created by Administrator on 2016/10/19.
 */
$(document).ready(function () {
    //初始化Hammer并传入需要操作的doc元素，不是jquery对象
    var content = new Hammer($(".content")[0]);

    //**********拖动事件*********************//
    content.on("pan", function (ev) {
        //这个偏移量是以当前元素的左上角顶点为准
        console.log("X偏移量:" + ev.deltaX);
        console.log("Y偏移量:" + ev.deltaY);
        if (ev.deltaX>0){
            $(".leftMenu").css("left",ev.deltaX+"px");
        }


    });


});



