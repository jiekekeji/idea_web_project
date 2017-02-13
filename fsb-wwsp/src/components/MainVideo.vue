<template>
  <div>
    <!--start 顶部那个小图片-->
    <div class="top">
      <img src="../assets/images/feng-jing.jpg">
    </div>
    <!--end 顶部那个小图片-->
    <!--start 公告-->
    <div class="txtMarquee-top">
      <ul class="infoList">
        <li v-for="item in infoList">{{item}}</li>
      </ul>
    </div>
    <!--end 公告-->
    <!--start 操作部分-->
    <div class="operation">
      <button class="btn">打开</button>
    </div>

    <!--end 操作部分-->

    <Page3></Page3>

    <!--start 弹窗部分-->
    <div class="dg-container">
      <div class="dg-content">
      </div>
    </div>
    <!--end 弹窗部分-->
  </div>
</template>
<style scoped>
  .top > img {
    width: 100%;
    height: 4rem;
  }

  .infoList {
    width: 100%;
    height: auto;
    background-color: #ff4949;
  }

  .infoList > li {
    height: 0.4rem;
    width: 100%;
    text-align: center;
    line-height: 0.4rem;
  }

  .operation {
    height: 4rem;
    width: 100%;
    position: relative;
  }

  .operation > .btn {
    height: 1rem;
    width: 2rem;
    position: absolute;
    left: 50%;
    top: 50%;
    margin-left: -1rem;
    margin-top: -0.5rem;
  }

  /*start 弹窗样式*/
  .dg-container {
    position: fixed;
    left: 0;
    top: 0;
    height: 100%;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    opacity: 0;
    visibility: hidden;
    -webkit-transition: opacity 0.3s 0s, visibility 0s 0.3s;
    -moz-transition: opacity 0.3s 0s, visibility 0s 0.3s;
    transition: opacity 0.3s 0s, visibility 0s 0.3s;
    z-index: 9999;
  }

  .dg-container.is-visible3 {
    opacity: 1;
    visibility: visible;
    -webkit-transition: opacity 0.3s 0s, visibility 0s 0s;
    -moz-transition: opacity 0.3s 0s, visibility 0s 0s;
    transition: opacity 0.3s 0s, visibility 0s 0s;
  }

  .dg-content {
    position: absolute;
    left: 50%;
    top: 50%;
    margin-left: -3rem;
    margin-top: -4rem;
    width: 6rem;
    height: 8rem;
    background: #FFF;
    border-radius: .4rem .4rem .4rem .4rem;
    text-align: center;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    -webkit-transform: scale(0.8);
    -moz-transform: scale(0.8);
    -ms-transform: scale(0.8);
    -o-transform: scale(0.8);
    transform: scale(0.8);
    -webkit-backface-visibility: hidden;
    -webkit-transition-property: -webkit-transform;
    -moz-transition-property: -moz-transform;
    transition-property: transform;
    -webkit-transition-duration: 0.3s;
    -moz-transition-duration: 0.3s;
    -ms-transition-duration: 0.3s;
    -o-transition-duration: 0.3s;
    transition-duration: 0.3s;
  }

  .is-visible3 .dg-content {
    -webkit-transform: scale(1);
    -moz-transform: scale(1);
    -ms-transform: scale(1);
    -o-transform: scale(1);
    transform: scale(1);
  }

  /*end 弹窗样式*/
</style>
<script>
  import md5 from 'js-md5'
  import 'mint-ui/lib/style.css'
  import {Indicator} from 'mint-ui';
  import Page3 from './Page3.vue'
  require('../assets/superslide/jquery.SuperSlide.2.1.1')
  export default{
    data(){
      return {
        msg: 'hello vue',
        infoList: []
      }
    },
    components: {
      'Page3': Page3
    },
    created () {
      console.log('created');
      this.loadInfoList();

    },
    mounted: function () {
      console.log('mounted');
      //打开窗口
      $('.btn').on('click', function (event) {
        event.preventDefault();
        $('.dg-container').addClass('is-visible3');
        //$(".dialog-addquxiao").hide()
      });
      //关闭窗口
      $('.dg-container').on('click', function (event) {
        if ($(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup3')) {
          event.preventDefault();
          $(this).removeClass('is-visible3');
        }
      });

      console.log(Page3.methods);
    },
    methods: {
      loadInfoList(){
        var me = this;
        Indicator.open();
        setTimeout(function () {
          Indicator.close();
          for (var i = 0; i < 12; i++) {
            me.infoList.push(i);
          }
          //初始化跑马灯
          me.$nextTick(function () {
            console.log('v-for渲染已经完成');
            jQuery(".txtMarquee-top").slide({
              mainCell: ".infoList",
              autoPlay: true,
              effect: "topMarquee",
              vis: 5,
              interTime: 50
            });
          })
        }, 3 * 1000);
      },
      activated: function () {
        console.log('activated');
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
  }
</script>
