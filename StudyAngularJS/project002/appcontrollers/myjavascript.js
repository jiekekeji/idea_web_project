/**
 * Created by jack on 16/7/24.
 */
console.log("myjavascript.js load end");
var baseURL = "http://www.tngou.net/tnfs/api/list";
var page = 1;//起始记录
var rows = 30;//请求的记录数
var self;//当前页的controller
var http;
(function () {
    "use strict"
    app.controller("myjavascriptCtrl", myjavascriptCtrlFn);
    function myjavascriptCtrlFn($http) {
        console.log("myjavascriptCtrlFn");
        //初始化数据
        self = this;
        http = $http;

        getMyjavascriptData(page, rows);
        //绑定数据和事件
        //上一页
        self.prePage = function () {
            if (self.currentPage == 1 || self.currentPage - 1 > self.totalPage) {
                alert("已经是第一页");
                return;
            }
            self.currentPage = self.currentPage - 1;
            getMyjavascriptData(self.currentPage, rows);
        };
        //下一页
        self.nextPage = function () {
            if (self.currentPage == self.totalPage || self.currentPage < 1) {
                alert("没有该页");
                return;
            }
            self.currentPage = self.currentPage + 1;
            getMyjavascriptData(self.currentPage, rows);
        };
        //跳转
        self.skipPage = function () {
            if (self.currentPage > self.totalPage || self.currentPage < 1) {
                alert("没有该页");
                return;
            }
            getMyjavascriptData(self.currentPage, rows);
        };
    };
}());

// 请求数据填充表单
function getMyjavascriptData(page, rows) {
    http.jsonp(baseURL + "?page=" + page + "&rows=" + rows + "&id=4&callback=JSON_CALLBACK")
        .success(function (response) {
            console.log("myjavascript.js load data result");
            console.log("myjavascript ="+response.status);
            self.imgInfos = null;//先置为空
            self.currentPage = page;//设置当前页
            self.imgInfos = response.tngou;//刷新列表
            self.totalPage = Math.ceil(response.total / rows);//总页数,向上取整
        });
}

