$(document).ready(function () {
    //点击事件
    $(".div1").click(function () {
        console.log("我被点击了");
    });
    //双击事件
    $(".div1").dblclick(function () {
        console.log("我被双击了");
    });
    //鼠标进入事件
    $(".div1").mouseenter(function () {
        console.log("鼠标进入");
    });
    //鼠标离开事件
    $(".div1").mouseleave(function () {
        console.log("鼠标进入");
    });
    /*****************************************/
    //光标悬停事件
    $(".div2").hover(function () {
            console.log("鼠标进入");
        },
        function () {
            console.log("鼠标离开");
        });
    //focus事件
    //当通过鼠标点击选中元素或通过 tab 键定位到元素时，该元素就会获得焦点。
    $(".username").focus(function () {
        console.log("input获取了焦点");
    });
    //blur()
    //blur() 方法触发 blur 事件，或规定当发生 blur 事件时运行的函数：
    $(".username").blur(function () {
        console.log("input失去焦点");
    });
    //change
    $(".username").change(function () {
        console.log("input内容改变");
    });

});