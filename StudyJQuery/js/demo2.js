/**
 * Created by Administrator on 2016-07-15.
 */
$(document).ready(function () {
    console.log("页面加载完成");
    // 本地存储功能
    if (window.localStorage) {
        console.log("浏览支持localStorage");
    } else {
        console.log("浏览暂不支持localStorage");
    }
    // 会话存储功能
    if (window.sessionStorage) {
        console.log("浏览支持sessionStorage");
    } else {
        console.log("浏览暂不支持sessionStorage");
    }

    //localStorage和sessionStorage取数据
    console.log("第一次打开或刷新页面localStorage取:" + localStorage.getItem("username"));
    console.log("第一次打开或刷新页面sessionStorage取:" + sessionStorage.getItem("username"));

    //localStorage和sessionStorage存数据
    localStorage.setItem("username", "jack");
    sessionStorage.setItem("username", "rose");

    //localStorage和sessionStorage取数据
    console.log("localStorage取:" + localStorage.getItem("username"));
    console.log("sessionStorage取:" + sessionStorage.getItem("username"));

    //清除数据
    localStorage.clear();
    sessionStorage.clear();

    //localStorage和sessionStorage取数据
    console.log("清除后localStorage取:" + localStorage.getItem("username"));
    console.log("清除后sessionStorage取:" + sessionStorage.getItem("username"));

    //localStorage和sessionStorage存数据
    localStorage.setItem("username", "jack");
    sessionStorage.setItem("username", "rose");


});
