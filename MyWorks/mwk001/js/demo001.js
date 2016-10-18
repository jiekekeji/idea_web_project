/**
 * Created by jack on 16/10/17.
 */
$(document).ready(function () {

    var i = 0;//计数器
    var interval;//定时任务
    var l2r = true;//从左向右滑动
    var liCount = 0;//滚动图片的数量
    var slideWidth = 0;//每次滚动的距离

    function initMainAD(count, width, Interval) {
        liCount = count;
        slideWidth = width;
        $(".mainAD>ul").css("width", liCount * slideWidth + 30 + "px");
        //如果鼠标进入到滚动的区域就暂停滚动，离开则重新滚动
        $(".mainAD>ul").hover(function () {
                clearInterval(interval);
            },
            function () {
                interval = setInterval(playAmin, 1000 * 3);
            });
        $(".mainAD>ul").swipe({
            //Generic swipe handler for all directions
            swipe: function (event, direction, distance, duration, fingerCount, fingerData) {
                console.log("direction:"+direction);
            },
            //Default is 75px, set to 0 for demo so any distance triggers swipe
            threshold: 0
        });
    }

    /**
     * 下一页的播放函数
     */
    function playAmin() {
        if (i == liCount - 1) {
            l2r = false;//从右像左滚动
        }
        if (i == 0) {
            l2r = true;//从左向右滚动
        }

        $(".mainAD>ul").animate({
            left: -i * 1080 + "px"
        }, 2 * 1000);

        if (l2r) {
            i++;
        } else {
            i--;
        }

    }

    initMainAD(3, 1080);
    interval = setInterval(playAmin, 1000 * 3);

    //var scrollbarWidth = $(".mainAD>ul").offsetWidth - $(".mainAD>ul").scrollWidth;
    //console.log("滚动条的宽度:"+scrollbarWidth);


});