<template>

  <div class="base content">
    <!--start 顶部标题-->
    <div class="title-bar">首页</div>
    <!--end 顶部标题-->
    <!--star 轮播区域-->
    <div class="swiper-container">
      <div class="swiper-wrapper">
        <div class="swiper-slide" v-for="item in swiperList" v-on:click="openDetail(item)">
          <img v-bind:src="item.img">
        </div>
      </div>
      <!--1、指示点放在这或放在外面-->
      <div class="swiper-pagination"></div>
    </div>
    <!--end 轮播区域-->
    <!--start 分类菜单-->
    <div class="clz-menu">
      <ul>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
      </ul>
    </div>
    <!--end 分类菜单-->
    <!--start 热门列表-->
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
    <!--end 热门列表-->
  </div>

</template>


<script>
  import Vue from 'vue'
  import Swiper from '../assets/swiper/swiper-3.4.0.jquery.min'
  import {api} from '../constant/api'
  import 'mint-ui/lib/style.css'
  import {Indicator} from 'mint-ui';
  import {Lazyload} from 'mint-ui';
  Vue.use(Lazyload);

  import {InfiniteScroll} from 'mint-ui';
  Vue.use(InfiniteScroll);

  import {Spinner} from 'mint-ui';
  Vue.component(Spinner.name, Spinner);


  import {utils} from '../constant/utils'

  export default{
    data(){
      return {
        swiperList: [],
        newsList: [],
        clzList: [],
        loading: false
      }
    },
    methods: {
      //打开详情页
      openDetail(index) {
        this.$router.push({path: 'ImgDetail', query: {userId: 123456}});
      },
      //请求列表数据
      loadMore() {
//        console.log('loadMore');
//        var temthis = this;
//        temthis.loading = true;
//        $.getJSON(WebImg + '?id=2&rows=13&callback=?', function (json, code) {
//          temthis.loading = false;
//          if (code !== 'success' || json.status !== true) {
//            return;
//          }
//          var length = json.tngou.length;
//          for (var i = 0; i < length; i++) {
//            json.tngou[i].img = BaseImg + json.tngou[i].img;
//            temthis.newsList.push(json.tngou[i]);
//          }
//        })
      },
      //请求轮播数据
      loadSwiperList(){
        let random = utils.getRandom();
        console.log(random);

        console.log('romkey=' + utils.getRandomkey(246, random, 'ada8043c-a229-4d51-ae96-1c7d0f1504b9'))
        console.log(utils.isEmpty(''));
        var temthis = this;
//        Indicator.open();
        this.$http.get(api.baseUrl + 'info_topic_type').then(resp => {
          console.log(resp.body);
          Indicator.close();
          if (0 !== resp.body.error_code) {
            //加载失败
            console.log('加载失败')
            return;
          }
          console.log('加载成功')
          var length = resp.body.result.length;
          console.log('加载成功=' + length)
          for (var i = 0; i < length; i++) {
            temthis.swiperList.push(resp.body.result[i]);
            console.log(resp.body.result[i]);
          }
        }, error => {
          Indicator.close();
          console.log('error');
        });

//        Indicator.open();
//        var temthis = this;
//        $.getJSON(WebImg + '?id=2&rows=2&callback=?', function (json, code) {
//          Indicator.close();
//          if (code !== 'success' || json.status !== true) {
//            return;
//          }
//          var length = json.tngou.length;
//          for (var i = 0; i < length; i++) {
//            json.tngou[i].img = BaseImg + json.tngou[i].img;
//            console.log(json.tngou[i].img)
//            temthis.swiperList.push(json.tngou[i]);
//          }
//        })
      },
      //初始化轮播列表
      initSwiperList(){
        var mySwiper = new Swiper('.swiper-container', {
          direction: 'horizontal',
          pagination: '.swiper-pagination',
          paginationClickable: true,
          centeredSlides: true,
          autoplay: 1000,
          observer: true,
        });
      },
      //请求分类列表数据
      loadClzList(){
        this.$http.get(SERVER + 'Lore/LoreClass?key=' + AppKey).then(resp => {
          console.log(resp.body);
        }, error => {
          console.log('error');
        });
      }
    },
    computer: {},
    components: {},
    created () {
      this.loadSwiperList();
//      this.loadClzList();
    },
    mounted: function () {
      this.initSwiperList();
      console.log(this);
    },
    activated: function () {
      console.log('activated');
      utils.setDocumentTitle('首页');
    },
    beforeRouteEnter  (to, from, next) {
      console.log('beforeRouteEnter');
      next();
    },
    beforeRouteLeave (to, from, next) {
      console.log('beforeRouteLeave=');
      next();
    },
  }
</script>
<style scoped>
  @import "../assets/swiper/swiper-3.4.0.min.css";
  @import "../assets/style/base.css";

  .title-bar {
    line-height: 1.2rem;
    text-align: center;
    height: 1.2rem;
    width: 100%;
  }

  .content {
  }

  .swiper-container {
    width: 100%;
    height: 4rem;
  }

  .swiper-slide > img {
    width: 100%;
    height: 100%;
  }

  .clz-menu {
    background-color: #FAFAFA;
    display: table;
    padding-bottom: 0.1rem;
  }

  .clz-menu > ul > li {
    display: inherit;
    float: left;
    height: 1.5625rem;
    width: 1.5625rem;
    background-color: darkgreen;
    border-radius: 0.1rem;
    margin-left: 0.75rem;
    margin-top: 0.1rem;
    text-align: center;
    line-height: 0.5rem;
  }

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
