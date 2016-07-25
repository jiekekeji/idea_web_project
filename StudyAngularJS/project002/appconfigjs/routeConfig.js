/**
 * Created by jack on 16/7/23.
 */
// 配置路由
app.config(["$stateProvider", "$urlRouterProvider", routeFn]);
function routeFn($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index");
    $stateProvider
        .state("index", {//首页
            url: "/index",
            templateUrl: "index.html",//路由页面
            controller: "indexCtrl",
            controllerAs: "index",//在页面直接通过page1.的方式取变量
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    //该controller的依赖文件
                    console.log("resolve="+"index");
                    return $ocLazyLoad.load("appcontrollers/index.js");
                }]
            }
        })
        .state("android", {//android页
            url: "/android",
            templateUrl: "android.html",
            controller: "androidCtrl",
            controllerAs: "android",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    console.log("resolve="+"android");
                    return $ocLazyLoad.load("appcontrollers/android.js");
                }]
            }
        })
        .state("myhtml", {//myhtml页
            url: "/myhtml",
            templateUrl: "myhtml.html",
            controller: "myhtmlCtrl",
            controllerAs: "myhtml",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load("appcontrollers/myhtml.js");
                }]
            }
        })
        .state("mycss", {//mycss页
            url: "/mycss",
            templateUrl: "mycss.html",
            controller: "mycssCtrl",
            controllerAs: "mycss",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load("appcontrollers/mycss.js");
                }]
            }
        })
        .state("myjavascript", {//myjavascript页
            url: "/myjavascript",
            templateUrl: "myjavascript.html",
            controller: "myjavascriptCtrl",
            controllerAs: "myjavascript",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load("appcontrollers/myjavascript.js");
                }]
            }
        })
        .state("myjava", {//myjavascript页
            url: "/myjava",
            templateUrl: "myjava.html",
            controller: "myjavaCtrl",
            controllerAs: "myjava",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load("appcontrollers/myjava.js");
                }]
            }
        })
        .state("myangularjs", {//myjavascript页
            url: "/myangularjs",
            templateUrl: "myangularjs.html",
            controller: "myangularjsCtrl",
            controllerAs: "myangularjs",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load("appcontrollers/myangularjs.js");
                }]
            }
        })
        .state("mypython", {//mypython页
            url: "/mypython",
            templateUrl: "mypython.html",
            controller: "mypythonCtrl",
            controllerAs: "mypython",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load("appcontrollers/mypython.js");
                }]
            }
        })
};