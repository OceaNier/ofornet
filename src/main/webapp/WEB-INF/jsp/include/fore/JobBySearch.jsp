<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
div.result1{
    width: 900px;
/* 	text-align:center; */
	height: 150px;
	border: 1px solid #bbbcbe;
	border-radius:10px;
	background-color: white;
	margin: 12px 5px;
	float: left;
	padding: 0px;}
	
span{
    font-size:100%;
}

a.result{
    font-size:170%;
    color:#48bce2;
}

div.result{
    display:inline;
}
</style>
<div class="left-mark"></div>
	  <span class="categoryTitle">搜索结果</span>
<div class="searchProducts"><br><br><br>
    <c:forEach items="${ps}" var="p">
	<div class="result1">
	  <%-- <div style="padding:25px 50px 25px 50px">
		<a class="result" href="forejob?jobid=${p.id}">${p.name}</a>
		<div class="result" style="font-size:120%;">&nbsp;[${p.company.name}]</div>
		<div class="result" style="font-size:120%;float:right;color:#bbbbbd"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>发布</div>
		<br><br><div class="result" style="font-size:120%;">[${p.nature}]&emsp;工作地点：${p.city}</div>
		<div class="result" style="font-size:120%;float:right"><div style="font-size:200%;color:#e76814;font-weight:700;">${p.salary}<div style="font-size:100%"></div></div></div>
		<br><br><div class="result" style="font-size:120%;">${p.education}&emsp;${p.experience}</div>
		
		
	  </div>
	   --%>
	  <div style="padding:25px 50px 25px 50px">
		<a class="result" href="forejob?jobid=${p.id}">${p.name}</a>
		<div class="result" style="font-size:120%;">&nbsp;[${p.companyName}]</div>
		<div class="result" style="font-size:120%;float:right;color:#bbbbbd">${p.createDate}发布</div>
		<br><br><div class="result" style="font-size:120%;">[${p.nature}]&emsp;工作地点：${p.city}</div>
		<div class="result" style="font-size:120%;float:right"><div style="font-size:200%;color:#e76814;font-weight:700;">${p.salary}<div style="font-size:100%"></div></div></div>
		<br><br><div class="result" style="font-size:120%;">${p.education}&emsp;${p.experience}</div>
		
		
	  </div>
	</div>
	</c:forEach>
	<c:if test="${empty ps}">
	<div class="noMatch">没有满足条件的岗位<div>
	</c:if>

		<div style="clear:both"></div>
	</div>