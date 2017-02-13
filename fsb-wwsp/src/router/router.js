/**
 * Created by Administrator on 2017/1/20.
 */

/**
 * 路由配置
 */
import Vue from 'vue'
import VueRouter from 'vue-router'


//配置组件为懒加载的方式
const Main = resolve => require(['../components/Main.vue'], resolve)
const MainHome = resolve => require(['../components/MainHome.vue'], resolve)
const MainHot = resolve => require(['../components/MainHot.vue'], resolve)
const MainVideo = resolve => require(['../components/MainVideo.vue'], resolve)
const MainMe = resolve => require(['../components/MainMe.vue'], resolve)


const ImgDetail = resolve => require(['../components/ClzList.vue'], resolve)
const Page3 = resolve => require(['../components/Page3.vue'], resolve)


Vue.use(VueRouter);

//路由映射配置
const routes = [
  {
    path: '/',
    redirect: '/MainHome',
    component: Main,
    children: [
      {
        path: 'MainHome',
        component: MainHome,
      }, {
        path: 'MainHot',
        component: MainHot,
      }, {
        path: 'MainVideo',
        component: MainVideo,
      }, {
        path: 'MainMe',
        component: MainMe,
      }
    ]
  },
  {
    path: '/Main',
    redirect: '/MainHome',
    component: Main,
    children: [
      {
        path: 'MainHome',
        component: MainHome,
      }, {
        path: 'MainHot',
        component: MainHot,
      }, {
        path: 'MainVideo',
        component: MainVideo,
      }, {
        path: 'MainMe',
        component: MainMe,
      }
    ]
  },
  {
    name: 'ImgDetail',
    path: '/ImgDetail',
    component: ImgDetail,
  },
  {
    path: '/Page3',
    component: Page3
  }
];


//创建实例
const router = new VueRouter({
  history: true,
  routes,
});

export default router;
