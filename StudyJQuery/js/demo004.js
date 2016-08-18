/**
 * Created by jack on 16/8/16.
 */
//对象实例

// 第一种方式
var obj1 = new Object();
obj1.name = "小明";
obj1.age = 12;
obj1.sex = "男";
console.log("obj1 name=" + obj1.name);
console.log("obj1 age=" + obj1.age);
console.log("obj1 sex=" + obj1.sex);

// 第二种方式,就是一个json格式的字符串
var obj2 = {
    "name": "小明",
    "age": 12,
    "sex": "男"
}
console.log("obj2 name=" + obj2.name);
console.log("obj2 age=" + obj2.age);
console.log("obj2 sex=" + obj2.sex);

//大一点的对象
var obj3 = {
    "status": true,
    "tngou": [{
        "description": "性感美女",
        "id": 1,
        "keywords": "性感美女",
        "name": "性感美女",
        "seq": 1,
        "title": "性感美女"
    }, {
        "description": "韩日美女",
        "id": 2,
        "keywords": "韩日美女",
        "name": "韩日美女",
        "seq": 2,
        "title": "韩日美女"
    }, {
        "description": "丝袜美腿",
        "id": 3,
        "keywords": "丝袜美腿",
        "name": "丝袜美腿",
        "seq": 3,
        "title": "丝袜美腿"
    }, {
        "description": "美女照片",
        "id": 4,
        "keywords": "美女照片",
        "name": "美女照片",
        "seq": 4,
        "title": "美女照片"
    }, {
        "description": "美女写真",
        "id": 5,
        "keywords": "美女写真",
        "name": "美女写真",
        "seq": 5,
        "title": "美女写真"
    }, {
        "description": "清纯美女",
        "id": 6,
        "keywords": "清纯美女",
        "name": "清纯美女",
        "seq": 6,
        "title": "清纯美女"
    }, {
        "description": "性感车模",
        "id": 7, "keywords": "性感车模",
        "name": "性感车模", "seq": 7,
        "title": "性感车模"
    }]
}

console.log("obj3 status=" + obj3.status);
console.log("obj3 tngou=" + obj3.tngou);
// 遍历数组
for(var i=0;i<obj3.tngou.length;i++){
    console.log("*************");
    var obj=obj3.tngou[i];
    console.log(i+"obj description="+obj.description);
    console.log(i+"obj id="+obj.id);
    console.log(i+"obj keywords="+obj.keywords);
    console.log(i+"obj name="+obj.name);
    console.log(i+"obj title="+obj.title);
}

/***
js对象和jQuery对象:
    DOM对象是我们用传统的方法（javascript）获得的对象，jQuery对象就是用jQuery的类库选择器获得的对象。
    JQuery对象就是通过jQuery包装DOM对象后产生的对象。
    JQuery对象是jQuery独有的，其可以使用jQuery里的方法，但是不能使用DOM的方法.
    ******
    DOM对象就是javascript固有的一些对象。DOM对象能使用javascript固有的方法，但是不能使用jQuery里面的方法。
*****/
var jsObj=document.getElementById("loginForm");
console.log("js对象="+jsObj);
var $obj=$(jsObj);//转为jQuery对象
//调用jquery对象的方法
console.log("通过jquery对象方法:action="+$obj.attr("method"));


var jQueryObj=$("#loginForm");
console.log("jQuery对象="+jQueryObj);
