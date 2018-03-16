<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>

div.result1{
    width: 900px;
/* 	text-align:center; */
	height: 150px;
	border: 1px solid #bbbcbe;
	border-radius:10px;
	background-color: white;
	margin: 12px 50px;
	float: left;
	padding: 0px;}
	a.result{
	color:#48bce2;
    font-size:170%;
}

div.result{
    display:inline;
}
	</style>

<c:if test="${empty param.categorycount}">
	<c:set var="categorycount" scope="page" value="100"/>
</c:if>

<c:if test="${!empty param.categorycount}">
	<c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>

<div class="homepageCategoryProducts">
	<c:forEach items="${cs}" var="c" varStatus="stc">
		<c:if test="${stc.count<=categorycount}">
			<div class="eachHomepageCategoryProducts">
				<div class="left-mark"></div>
				<span class="categoryTitle">${c.name}</span>
				<br>
					<c:forEach items="${c.jobs}" var="p" varStatus="st">
					<c:if test="${st.count<=2}">
						
						<div>
							<div class="result1">
	                            <div style="padding:25px 50px 25px 50px">
	                           	<a class="result" href="forejob?jobid=${p.id}">${p.name}</a>
	                           	<div class="result" style="font-size:120%;">&nbsp;[${p.company.name}]</div>
		                         <div class="result" style="font-size:120%; float:right; color:#bbbbbd;"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>&emsp;发布</div>
	                             	<br><br><div class="result" style="font-size:120%;">[${p.nature}]&emsp;工作地点：${p.city}</div>
		                           <div class="result" style="font-size:120%;float:right"><div style="font-size:200%;color:#e76814;font-weight:700;">${p.salary}<div style="font-size:100%"></div></div></div>
		                           <br><br><div class="result" style="font-size:120%;">${p.education}&emsp;${p.experience}</div>
	                   </div>
	    
	                    </div>
						</div>
						
					</c:if>				
				</c:forEach>
				<div style="clear:both"></div>
			</div>
		</c:if>
	</c:forEach>
	
	
	<img id="endpng" class="endpng" src="img/site/end.png">

</div>