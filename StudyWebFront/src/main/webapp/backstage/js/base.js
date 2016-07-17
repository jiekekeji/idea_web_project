/**
 * Created by jack on 16/7/16.
 */
/**
 * 获取url中的参数值
 * @param name
 * @returns {null}
 */
function getUrlParam(name) {

    //构造一个含有目标参数的正则表达式对象
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    //匹配目标参数
    var r = window.location.search.substr(1).match(reg);
    //返回参数值
    if (r != null) return decodeURI(unescape(r[2]));
    return null;
}
