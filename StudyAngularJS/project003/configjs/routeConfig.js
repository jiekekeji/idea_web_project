/**
 * Created by jack on 16/7/23.
 */
// 配置路由
app.config(["$stateProvider", "$urlRouterProvider", routeFn]);
function routeFn($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/page1");
    $stateProvider
        .state("page1", {
            url: "/page1",
            templateUrl: "page1.html",//路由页面
            controller: "page1Ctrl",
            controllerAs: "page1",//在页面直接通过page1.的方式取变量
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    //该controller的依赖文件
                    return $ocLazyLoad.load("controllers/page1.js");
                }]
            }
        })
        .state("page2", {
            url: "/page2",
            templateUrl: "page2.html",
            controller: "page2Ctrl",
            controllerAs: "page2",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load("controllers/page2.js");
                }]
            }
        })
};