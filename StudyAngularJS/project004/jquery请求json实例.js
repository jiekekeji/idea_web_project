/**
 * Created by jack on 16/7/27.
 */

//调用
getADPic();

//定义
function getADPic() {
    $.ajax({
        url: "http://www.tngou.net/tnfs/api/list",
        data: "page=1&rows=6&callback=?",
        type: "post",
        processData: false,
        timeout: 15000,
        dataType: "jsonp",  // not "json" we'll parse
        jsonp: "jsonpcallback",
        success: function (result) {
            console.log("轮训图片请求结果:" + result.status);
            if (result.status) {
                setDataToHTML(result.tngou);
            }

        }
    });
}

//填充页面
function setDataToHTML(tngou) {

}
