/**
 * Created by jack on 16/7/23.
 */
console.log("page1 loaded");
(function () {
    "use strict"
    //和路由配置的controller: "page1Ctrl"一致
    app.controller("page1Ctrl", page1CtrlFn);
    function page1CtrlFn() {
        this.username = "Hello World";
        this.value="jack";
    }
}())
