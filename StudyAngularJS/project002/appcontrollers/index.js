/**
 * Created by jack on 16/7/24.
 */
console.log("index.js load end");
(function () {
    "use strict"
    //和路由配置的controller: "indexCtrl"一致
    app.controller("indexCtrl", indexCtrlFn);
    function indexCtrlFn($http) {
        //初始化数据
        var self=this;
        $http.jsonp("http://www.tngou.net/tnfs/api/list?page=1&rows=10&callback=JSON_CALLBACK")
            .success(function (response) {
                console.log(response.status);
                self.imgInfos = response.tngou;
            });
    };
}());