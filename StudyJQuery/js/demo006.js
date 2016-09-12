/**
 * Created by Administrator on 2016/9/7.
 */
//获取当前时间
$(document).ready(function () {
    console.log("js文档开始加载");

    var time = new Date();
    console.log("当前时间毫秒值:" + time);

    var year = time.getFullYear();
    console.log("年:" + year);
    var month = time.getMonth();
    console.log("月:" + month);
    var day = time.getDay();
    console.log("日:" + day);

    console.log("日期:" + formatterDate(time));

});


//格式化时间,格式为2016-09-07
//date参数new Date();
function formatterDate(date) {
    var datetime = date.getFullYear()
        + "-"// "年"
        + ((date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : "0"
        + (date.getMonth() + 1))
        + "-"// "月"
        + (date.getDate() < 10 ? "0" + date.getDate() : date
            .getDate());
    return datetime;
}

