<template>
  <div class="footer">
    这是Page3内容
  </div>
</template>
<style scoped>
  .footer {
    height: 120px;
    width: 100%;
    text-align: center;
    line-height: 120px;
    background-color: darkseagreen;
  }
</style>
<script>
  export default{
    data(){
      return {
        msg: 'hello vue'
      }
    },
    components: {},
    methods: {
      test(){
        console.log('test');
      }
    },
    events: {
      'dialog-dispatch' () {
        this.hidedialog = !this.hidedialog
        this.$broadcast('dialog-broadcast')
      },
      'mask-dispatch' () {
        this.hideMask = !this.hideMask
        this.$broadcast('mask-broadcast')
      }
    }
  }
</script>
