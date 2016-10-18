/**
 * Created by jack on 16/10/17.
 */
$(document).ready(function () {
    console.log("加载完成");

    var i = 0;//计数器
    var interval;//定时任务

    function initMainAD(count, width) {
        $(".mainAD>ul").css("width", width * count + 20 + "px");
        $(".mainAD>ul").hover(function () {
                console.log("停止播放");
                clearInterval(interval);
            },
            function () {
                console.log("再次播放");
                interval = setInterval(playAmin, 1000 * 3);
            });
    }

    function playAmin() {
        console.log("下一张");
        if (i == 3) {
            i = 0;
        }
        $(".mainAD>ul").animate({
            left: -i * 1080 + "px"
        }, 2 * 1000);
        i++;
    }

    initMainAD(3, 1080);
    interval = setInterval(playAmin, 1000 * 3);


});