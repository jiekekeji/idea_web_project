<template>
  <div>
    <!--start 跑马灯公告-->
    <div class="txtMarquee-top">
      <ul class="infoList">
        <li v-for="item in infoList">{{item}}</li>
      </ul>
    </div>
    <!--end 跑马灯公告-->
    <!--start 数据列表-->
    <ul class="pdList">
      <li v-for="item in even(pdList)" v-bind:class="{ pdListItem: item.isBg}">{{item}}</li>
    </ul>

    <!--end 数据列表-->
  </div>
</template>
<style scoped>
  .txtMarquee-top {
    height: auto;
    width: 100%;
    background-color: azure;
  }

  .txtMarquee-top > .infoList {
    width: 100%;
    height: auto;
  }

  .infoList > li {
    height: 0.9rem;
    width: 100%;
    text-align: center;
    border: 0.1rem solid transparent;
  }

  /*start 数据列表*/
  .pdList {
    width: 100%;
    height: auto;
  }

  .pdList > li {
    height: 1.6rem;
    width: 100%;

  }

  .pdListItem {
    background-color: #9b9b9b;
  }

  /*end 数据列表*/
</style>
<script>
  import md5 from 'js-md5'
  require('../assets/superslide/jquery.SuperSlide.2.1.1')
  export default{
    data(){
      return {
        msg: 'hello vue',
        infoList: [],
        pdList: []
      }
    },
    components: {},
    created () {
      this.loadNoticeData();
      this.loadPdList();
    },
    mounted: function () {

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
    methods: {
      //加载公告数据
      loadNoticeData(){
        var me = this;
        setTimeout(function () {
          for (var i = 0; i < 10; i++) {
            me.infoList.push(i);
          }
          //初始化跑马灯
          me.$nextTick(function () {
            console.log('v-for渲染已经完成');
            jQuery(".txtMarquee-top").slide({
              mainCell: ".infoList",
              autoPlay: true,
              effect: "topMarquee",
              vis: 4,
              interTime: 50
            });
          })
        }, 3 * 1000);
      },
      //加载列表数据
      loadPdList(){
        var me = this;
        setTimeout(function () {
          for (var i = 0; i < 10; i++) {
            var stu = {};
            stu.age = i;
            stu.name = '小明' + i;
            me.pdList.push(stu);
          }
        }, 2 * 1000);
      },
      //整理列表数据,在这里处理每个样式什么的
      even(pdList) {
        for (var i = 0; i < pdList.length; i++) {
          var obj = pdList[i];
          if (3 === obj.age) {
            obj.isBg = true;
          } else {
            obj.isBg = false;
          }
        }
        return pdList;
      }
    }
  }
</script>
