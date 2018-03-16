<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<style>
img.logo {
	position: absolute;
	left: 320px;
	top: 120px;
	width:200px;
	
/* 	z-index:-1; */
}
</style>
<a href="${contextPath}">
<div class="categoryPictureInProductPageDiv">
	<img class="categoryPictureInProductPage" style="width:100%" src="img/site/top.png">
</div>
</a>

<a>
	<img id="logo" src="img/site/logo.png" class="logo">
</a>



<form action="foresearch" method="post" >
	<div class="searchDiv">
		<input name="keyword" placeholder="请输入要搜索的岗位或关键字" type="text" value="${keywords}">

		<button  type="submit" class="searchButton">搜索</button>
		
	</div>
</form>
