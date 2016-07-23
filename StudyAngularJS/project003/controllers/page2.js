/**
 * Created by jack on 16/7/23.
 */
console.log("page2 loaded");
(function () {
    app.controller('page2Ctrl',page2CtrlFn);
    function page2CtrlFn() {
        this.value="i am page2"
        this.toggle=function () {
            console.log("page2 button 被点击了");
        };

    }
}());