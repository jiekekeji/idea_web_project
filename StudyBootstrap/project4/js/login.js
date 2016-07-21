/**
 * Created by jack on 16/7/10.
 */
$(document).ready(function () {
     console.info("xxxxx");

     //给登陆按钮添加事件
     $(".loginbtn").click(function () {
          console.info("登陆按钮被点击");
          //判断输入是否为空
          var account=$(".account").val();
          var password=$(".password").val();
          var verifycode=$(".verifycode").val();

          if(account==""){
               $(".notice").text("请输入账号!");
               $(".account").focus;
               return;
          }

          if(password==""){
               $(".notice").text("请输入密码!");
               $(".password").focus;
               return;
          }

          if(verifycode==""){
               $(".notice").text("请输入验证码!");
               $(".verifycode").focus;
               return;
          }

          $(".notice").text("正在登陆,请稍后......");
          //提交表单
          $("form").submit();
     });
});
