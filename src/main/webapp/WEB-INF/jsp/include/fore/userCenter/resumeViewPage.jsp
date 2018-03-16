<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
span.font{
font-size:125%;
}
</style>
<div class="productDetailDiv" >
	<div class="productDetailTopPart" style="height: 50px">
		<div  class="productDetailTopPartSelectedLink" style="font-size:150%;margin-top:10px">简历详情</div>
	</div>
	
	
	<div class="resumeContent">
		
		<div class="productParamterList">
			<span><td><img height="60px" src="img/site/logo.png"></span></td>
		    <span></span>
		    <span><td><img height="150px" src="img/resume/${r.id}.jpg"></td></span>
			<span class="font">姓名：${r.username }</span>
			<span class="font">性别：${r.sex}</span>
			<span class="font">年龄：${r.age }</span>
			<span class="font" style="width:100%"> </span>
			<span class="font">学历：${r.degree}</span>
			<span class="font">联系电话：${r.phone}</span>
			<span class="font">电子邮箱：${r.email}</span>
			<span class="font" style="width:100%"> </span>
		    <span class="font">意向岗位：${r.job}</span>
		    <span class="font"></span>
		    <span class="font" style="width:100%"></span>
			<span class="font" style="width:100%">工作经历：</span>
			<span class="font" style="width:100%"></span>
			<span class="font" style="width:100%">&emsp;&emsp;${r.experience}</span>
			<span class="font" style="width:100%"></span>
			<span class="font" style="width:100%">项目经历：</span>
			<span class="font" style="width:100%"></span>
			<span class="font" style="width:100%">&emsp;&emsp;${r.project}</span>
			<span class="font" style="width:100%"></span>
			<span class="font" style="width:100%">获奖情况：</span>
			<span class="font" style="width:100%"></span>
			<span class="font" style="width:100%">&emsp;&emsp;${r.award}</span>
			<span class="font" style="width:100%"></span>
		</div>
		<div style="clear:both"></div>
	</div>
	
</div>