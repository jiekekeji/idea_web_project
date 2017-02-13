// src/main.js
import Vue from 'vue'
import App from './App'
import router from './router/router'
import VueResource from 'vue-resource'
Vue.use(VueResource);

// 实例化我们的Vue
var app = new Vue({
  el: '#app',
  router,
  ...App,
});
