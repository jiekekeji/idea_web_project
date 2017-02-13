<template>
  <div class="main">
    <!--主体内容部分-->
    <div class="content">
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </div>
    <!--底部tab切换-->
    <div class="botm-tab">
      <ul>
        <li class="tab1" v-bind:class="{tab1ac: isTab1Ac }" v-on:click="toTab1">主页</li>
        <li class="tab2" v-bind:class="{tab2ac: isTab2Ac }" v-on:click="toTab2">热门</li>
        <li class="tab3" v-bind:class="{tab3ac: isTab3Ac }" v-on:click="toTab3">视频</li>
        <li class="tab4" v-bind:class="{tab4ac: isTab4Ac }" v-on:click="toTab4">我的</li>
      </ul>
    </div>
  </div>
</template>

<script>
  import store from '../store/store';

  export default{
    data(){
      return {
        //tab的选中状态
        isTab1Ac: true,
        isTab2Ac: false,
        isTab3Ac: false,
        isTab4Ac: false,
        msg: store.state.count,
        stu: store.state.stu,
      }
    },
    components: {},
    computed: {},
    methods: {
      toTab1: function () {
        this.isTab1Ac = true;
        this.isTab2Ac = false;
        this.isTab3Ac = false;
        this.isTab4Ac = false;
        this.$router.push('MainHome');

      },
      toTab2: function () {
        this.isTab1Ac = false;
        this.isTab2Ac = true;
        this.isTab3Ac = false;
        this.isTab4Ac = false;
        this.$router.push('MainHot');
      },
      toTab3: function () {
        this.isTab1Ac = false;
        this.isTab2Ac = false;
        this.isTab3Ac = true;
        this.isTab4Ac = false;
        this.$router.push('MainVideo');
      },
      toTab4: function () {
        this.isTab1Ac = false;
        this.isTab2Ac = false;
        this.isTab3Ac = false;
        this.isTab4Ac = true;
        this.$router.push('MainMe');
      },
    },
    created () {
    },
  }
</script>

<style scoped>

  .main {
    position: fixed;
    left: 0;
    right: 0;
    bottom: 0;
    top: 0;
  }

  .content {
    position: fixed;
    top: 0;
    bottom: 1.4rem;
    left: 0;
    right: 0;
    overflow: auto;
  }

  /*start 底部菜单部分*/
  .botm-tab {
    position: fixed;
    bottom: 0px;
    left: 0px;
    width: 100%;
    height: 1.4rem;
    background-color: #fafafa;
  }

  .botm-tab > ul {
    width: 100%;
    height: 100%;
  }

  .botm-tab > ul > li {
    float: left;
    display: inline-block;
    width: 25%;
    height: 100%;
    text-align: center;
    line-height: 2rem;
    font-size: 0.4rem;
    background-repeat: no-repeat;
    background-position: center 0.1rem;
    background-size: 0.8rem 0.6rem;
  }

  .tab1 {
    background-image: url("../assets/icon/icon-main-home.png");
  }

  .tab2 {
    background-image: url("../assets/icon/icon-main-hot.png");
  }

  .tab3 {
    background-image: url("../assets/icon/icon-main-video.png");
  }

  .tab4 {
    background-image: url("../assets/icon/icon-main-me.png");
  }

  .tab1ac {
    color: red;
    background-image: url("../assets/icon/icon-main-home-ac.png");
  }

  .tab2ac {
    color: red;
    background-image: url("../assets/icon/icon-main-hot-ac.png");
  }

  .tab3ac {
    color: red;
    background-image: url("../assets/icon/icon-main-video-ac.png");
  }

  .tab4ac {
    color: red;
    background-image: url("../assets/icon/icon-main-me-ac.png");
  }

  /*end 底部菜单部分*/
</style>

