/**
 * Created by Administrator on 2016/10/14.
 */
window.addEventListener("load", function () {
    console.log("页面加载完成");
    //闭包就是能够读取其他函数内部变量的函数
    //闭包是函数内部局部变量和外部连接的一个桥梁
    /**
     * 函数可作为参数返回
     * @returns {fn2}
     */
    function fn1() {
        var a = 1;

        function fn2() {
            var b = 2;
            console.log("fn2");
            return b;
        }

        //返回fn2这个函数
        return fn2;
    }

    //如何返回到fn2函数的局部变量b

    //获取fn2函数
    var fn11 = fn1();
    //调用fn2这个函数
    console.log("fn11=" + fn11());
    //直接无法调用
    // fn2();


});