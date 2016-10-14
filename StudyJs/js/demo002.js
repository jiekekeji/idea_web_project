/**
 * Created by Administrator on 2016/10/14.
 */
window.addEventListener("load", function () {
    console.log("********demo002.js***********");
    //windows对象:所有 JavaScript 全局对象、函数以及变量均自动成为 window 对象的成员。
    //定义变量时不加var那么自动成为windows对象全局变量
    name = "jack";
    //通过window就能直接点出来
    console.log(window.name);
    var age = 18;
    //undefined,访问不到
    console.log(window.age);

    //模仿wondiws对象,链式的一级一级往下走
    var mWin = {
        name: "jack",
        age: 18,
        sayHello: function () {
            console.log("sayHello");
            stu:{
                addr:"深圳市"
            }
        },
        hand: {
            name: "leftHand",
            payBoll: function () {
                console.log("payBoll");
            },
            boll: {
                weight: 128,
                addWeight:function () {
                    console.log("addWeight");
                }
            }
        },
        hands: [{}]
    }
    //开始调用
    console.log("mWin.name=" + mWin.name);
    mWin.sayHello();
    mWin.hand.payBoll();
    mWin.hand.boll.addWeight();

});