<template>
  <div style="background-color: red">
    <div class="topbar">

    </div>
    <div class="phonearea">
      <h6>请输入您的手机</h6>
      <input type="tel" placeholder="请输入手机号码">
      <div class="button">确认</div>
    </div>
    <div class="detail">

    </div>
  </div>
</template>
<style scoped>
  .topbar {
    height: 4.45rem;
    width: 100%;
  }

  .phonearea {
    text-align: center;
    height: 6.52rem;
    width: 9.44rem;
    margin: 0 auto;
    background-color: #ffffff;
    border-radius: 10px;
  }

  .phonearea > h6 {
    padding-top: 0.89rem;
    font-size: 24px;
    text-align: center;
  }

  .phonearea > input[type="tel"] {
    height: 0.89rem;
    width: 8.5rem;
    border: 1.5px solid #b7b7b7;
    border-radius: 20px;
    text-indent: 10px;
    outline: none;
    display: inline-block;
    margin-top: 0.89rem;
    margin-left: auto;

  }

  .button {
    height: 0.89rem;
    width: 8.5rem;
    border-radius: 20px;
    text-indent: 10px;
    outline: none;
    display: inline-block;
    margin-top: 0.72rem;
    margin-left: auto;
    background-color: #00a6f8;
    color: white;
    line-height: 0.89rem;
  }

  .detail {
    margin: 14px auto;
    height: 6.52rem;
    width: 9.44rem;
    background-color: #ffffff;
    border-radius: 10px;
  }
</style>
<script>
  export default{
    data(){
      return {}
    },
    components: {}
  }
</script>
