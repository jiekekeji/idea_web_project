/**
 * Created by jack on 16/10/17.
 */
$(document).ready(function () {

    var i = 0;//计数器
    var interval;//定时任务
    var l2r = true;//从左向右滑动
    var liCount = 0;//滚动图片的数量
    var slideWidth = 0;//每次滚动的距离
    var aminLength = 1 * 1000;//默认为2s
    var aminInterval = 3 * 1000;//动画播放的间隔默认为3s

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
        //更改指示点的样式
        setindicateDotStyle(i);
        setDisPlayLi(i);

        if (l2r) {
            i++;
        } else {
            i--;
        }


    }

    /**
     * 设置显示的li
     * @param i
     */
    function setDisPlayLi(i) {
        $(".mainAD>ul").animate({
            left: -i * slideWidth + "px"
        }, aminLength);
    }

    /**
     * 设置当前展示的图片指示点的样式
     * @param i
     */
    function setindicateDotStyle(i) {
        $(".indicateDot > ul li").css({"background-color": "red"});
        $(".indicateDot > ul li:eq(" + i + ")").css({"background-color": "yellow"});
    }

    /**
     * 给指示点设置监听函数
     */
    function setindicateDotOnclick() {
        $(".indicateDot > ul li").click(function () {
            //获取被点击的li在ul中的位置
            var liAtUl = $(this).index();
            i=liAtUl;
            setDisPlayLi(i);
            setindicateDotStyle(liAtUl);
        });
    }

    initMainAD(3, 1080);
    interval = setInterval(playAmin, aminInterval);
    setindicateDotStyle(0);
    setindicateDotOnclick();


});