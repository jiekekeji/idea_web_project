/**
 * Created by jack on 16/7/24.
 */
console.log("mycss.js load end");
var baseURL = "http://www.tngou.net/tnfs/api/list";
var page = 1;//起始记录
var rows = 32;//请求的记录数
var self;//当前页的controller
var http;
(function () {
    "use strict"
    //和路由配置的controller: "myhtmlCtrl"一致
    app.controller("mycssCtrl", mycssCtrlFn);
    function mycssCtrlFn($http) {
        console.log("mycssCtrlFn");
        //初始化数据
        self = this;
        http = $http;

        getMycssData(page, rows);
        //绑定数据和事件
        //上一页
        self.prePage = function () {
            if (self.currentPage == 1 || self.currentPage - 1 > self.totalPage) {
                alert("已经是第一页");
                return;
            }
            self.currentPage = self.currentPage - 1;
            getMycssData(self.currentPage, rows);
        };
        //下一页
        self.nextPage = function () {
            if (self.currentPage == self.totalPage || self.currentPage < 1) {
                alert("没有该页");
                return;
            }
            self.currentPage = self.currentPage + 1;
            getMycssData(self.currentPage, rows);
        };
        //跳转
        self.skipPage = function () {
            if (self.currentPage > self.totalPage || self.currentPage < 1) {
                alert("没有该页");
                return;
            }
            getMycssData(self.currentPage, rows);
        };

    };
}());
// 请求数据填充表单
function getMycssData(page, rows) {
    http.jsonp(baseURL + "?page=" + page + "&rows=" + rows + "&id=3&callback=JSON_CALLBACK")
        .success(function (response) {
            console.log("mycss.js load data result");
            console.log("mycss =" + response.status);
            self.imgInfos = null;//先置为空
            self.currentPage = page;//设置当前页
            self.imgInfos = response.tngou;//刷新列表
            self.totalPage = Math.ceil(response.total / rows);//总页数,向上取整
        });
}
