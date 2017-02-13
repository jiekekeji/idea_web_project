<!--分类列表-->
<template>
  <div>
    <div class="hot-list" v-infinite-scroll="loadMore"
         infinite-scroll-disabled="loading"
         infinite-scroll-distance="10">
      <div class="hot-list-container" v-for="item in newsList" v-on:click="openDetail(item)">
        <img v-lazy="item.img">
        <div class="list-detail">
          <p class="list-title">{{item.title}}</p>
          <p class="list-time">{{item.title}}</p>
        </div>
      </div>
      <p v-show="loading" class="page-infinite-loading" style="text-align: center">
        加载中...
      </p>
    </div>
  </div>
</template>

<script>
  import Vue from 'vue'
  import Swiper from '../assets/swiper/swiper-3.4.0.jquery.min'
  import {BaseImg, WebImg, WebHealth} from '../constant/api'
  import 'mint-ui/lib/style.css'
  import {Indicator} from 'mint-ui';
  import {Lazyload} from 'mint-ui';
  Vue.use(Lazyload);

  import {InfiniteScroll} from 'mint-ui';
  Vue.use(InfiniteScroll);

  import {Spinner} from 'mint-ui';
  Vue.component(Spinner.name, Spinner);

  import {setDocumentTitle} from '../constant/utils'

  export default {
    name: 'topnav',
    data () {
      return {
        loading: false,
        newsList: [],
        scrollTop: 0
      }
    },
    methods: {
      //列表点击事件
      openDetail(item){
        this.$router.push({path: 'Page3', query: {userId: 123456}});
      },
      //请求列表数据
      loadMore() {
        console.log('loadMore');
        var temthis = this;
        temthis.loading = true;
        $.getJSON(WebImg + '?id=2&rows=13&callback=?', function (json, code) {
          temthis.loading = false;
          if (code !== 'success' || json.status !== true) {
            return;
          }
          var length = json.tngou.length;
          for (var i = 0; i < length; i++) {
            json.tngou[i].img = BaseImg + json.tngou[i].img;
            temthis.newsList.push(json.tngou[i]);
          }
        })
      }
    },
    activated: function () {
      console.log('activated');
      var tempThis = this;

      setDocumentTitle('分类列表');

      //滚回到之前的地方
      var scrollTop = sessionStorage.getItem('ClzList');
      if (0 !== scrollTop) {
        $(window).scrollTop(scrollTop);
      }
    },
    beforeRouteEnter  (to, from, next) {
      console.log('beforeRouteEnter');
      next();
    },
    beforeRouteLeave (to, from, next) {
      //记录滚动的位置
      var scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
      sessionStorage.setItem('ClzList', scrollTop);
      console.log('beforeRouteLeave=' + scrollTop);
      next();
    },
  }
</script>

<style scoped>
  .hot-list {
    background-color: #FAFAFA;
  }

  .hot-list-container {
    position: relative;
    width: 100%;
    height: 2.5rem;
    margin-top: 2px;
    margin-bottom: 2px;
  }

  .hot-list-container > img {
    height: 2.1875rem;
    width: 2.1875rem;
    border-radius: 0.1rem;
    margin-top: 0.05rem;
    margin-left: 0.05rem;
    margin-bottom: 0.05rem;
    margin-right: 0.05rem;
  }

  .hot-list-container > img [lazy=loading] {
    height: 2.1875rem;
    width: 2.1875rem;
    /*margin: auto;*/
    /*background-color: red;*/
  }

  .list-detail {
    position: absolute;
    left: 2.2875rem;
    right: 0;
    top: 0;
    bottom: 0;
  }

  .list-detail > .list-title {
    font-size: 0.4rem;
    width: 100%;
    height: 1.7rem;
    /*padding: 4px;*/
    text-overflow: ellipsis;
    /*margin: 4px;*/
  }

  .list-detail > .list-time {
    font-size: 14px;
    line-height: 0.5rem;
    width: 100%;
    height: 0.5rem;
    background-color: beige;
    text-indent: 5px;
  }
</style>
