$(document).ready(function () {

    //获取服务端传回的剩余时间毫秒数之后开始倒计时
    var nowTime=91858000;
    setInterval(function () {
        $(".content").text(getLeftTime(nowTime))
        nowTime=nowTime-1000*1;
    },1000*1);

    /**
     * 将传入的毫秒值转为时间格式
     * @param millis 毫秒值
     * return hh:mm:ss
     */
    function getLeftTime(millis) {
        var day = parseInt(millis / (1000 * 60 * 60 * 24));
        var temp = millis % (1000 * 60 * 60 * 24);
        var hh = parseInt(temp / (1000 * 60 * 60));
        temp = temp % (1000 * 60 * 60);
        var mm = parseInt(temp / (60 * 1000));
        temp = temp % (60 * 1000);
        var ss = parseInt(temp / 1000);
        if (day==0){
            return hh + ":" + mm + ":" + ss;
        }else {
            return day+"天"+hh + "小时" + mm + "分" + ss+"秒";
        }
    }

});