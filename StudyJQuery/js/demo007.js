/**
 * Created by Administrator on 2016/9/12.
 */
$(document).ready(function () {
    //相当于定义一个类
    var person = {
        "age": 16,
        "weight": 120,
        "gender": "man",
        "getAge": function () {
            return this.age;
        },
        "setAge": function (age) {
            this.age = age;
        }
    }

    person.setAge(26);
    console.log("person age=" + person.getAge());

    //定义一个jack
    var jack = {
        "address": "深圳市龙华区",
        "phoneNum": 18586536253,
        "getPhoneNum": function () {
            return this.phoneNum;
        }
    };
    //然后继承了person
    jack.prototype = person;
    console.log("jack age=" + jack.prototype.getAge());
    console.log("jack phoneNum=" + jack.getPhoneNum());

});
