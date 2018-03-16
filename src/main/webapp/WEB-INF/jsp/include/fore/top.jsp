<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>

<nav class="top">
	<a href="forehome">
		<span style="color:#1cacbe;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
		互联聘首页
	</a>

	<span>嗨，欢迎来互联聘</span>

	<c:if test="${!empty user}">
		<a href="userCollection">${user.username}</a>
		<a href="forelogout">退出</a>
	</c:if>


	<c:if test="${empty user}">
		<a href="loginPage">请登录</a>
		<a href="registerPageUser">免费注册</a>
	</c:if>
	



	<span class="pull-right">
	<c:if test="${usertype=='u'}">
			<a href="foreuserCollection">
			<span style="color:#1cacbe;margin:0px" class=" glyphicon glyphicon-star redColor">
			</span>
			个人中心</a>
		    </span>
	
	</c:if>
		<c:if test="${usertype=='c'}">
			<a href="job_listByCompany">
			<span style="color:#1cacbe;margin:0px" class=" glyphicon glyphicon-star redColor">
			</span>
			企业中心</a>
		    </span>
	</c:if>
     <c:if test="${usertype==null}">
        <a href="foreuserCollection">
         <span style="color:#1cacbe;margin:0px" class=" glyphicon glyphicon-star redColor">
         </span>
          个人中心</a >
         </span>
     </c:if>

</nav>



