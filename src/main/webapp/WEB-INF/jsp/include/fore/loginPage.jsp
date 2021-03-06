<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>


<script>
    $(function(){

        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>

        $("form.loginForm").submit(function(){
            if(0==$("#username").val().length||0==$("#password").val().length){
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            return true;
        });

        $("form.loginForm input").keyup(function(){
            $("div.loginErrorMessageDiv").hide();
        });
        
        var left = window.innerWidth/2+162;
        $("div.loginSmallDiv").css("left",left);
    })
</script>


<div id="loginDiv" style="position: relative ">

	<div class="simpleLogo" >
		<a href="${contextPath}"><img style="width:0px;" src="img/site/logo.png"></a>
	</div>
	<img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/loginBackgroundUser.png">

 <form class="loginForm" action="forelogin" method="post">
  <div id="loginSmallDiv" class="loginSmallDiv">
   <div class="loginErrorMessageDiv">
    <div class="alert alert-danger" >
     <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
     <span class="errorMessage"></span>
    </div>
   </div>

   <div class="login_acount_text">个人账户登录</div>
   <div class="loginInput " >
    <span class="loginInputIcon ">
     <span class=" glyphicon glyphicon-user"></span>
    </span>
    <input id="username" name="username" placeholder="手机/会员名/邮箱" type="text">
   </div>

   <div class="loginInput " >
    <span class="loginInputIcon ">
     <span class=" glyphicon glyphicon-lock"></span>
    </span>
    <input id="password" name="password" type="password" placeholder="密码" type="text">
   </div>
   <a href="loginPageCompany" class="pull-right">我是企业用户</a ><br><br>


   <div>
    <a class="notImplementLink" href="#nowhere">忘记登录密码</a >
    <a href="registerPageUser" class="pull-right">免费注册</a >
   </div>
   <div style="margin-top:20px">
    <button class="btn btn-block redButton" type="submit">登录</button>
   </div>
  </div>
 </form>


</div>	