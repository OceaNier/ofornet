<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<div class="productDetailDiv" >
	<div class="productDetailTopPart" style="height: 50px">
		<div  class="productDetailTopPartSelectedLink" style="font-size:150%;margin-top:10px">岗位详情</div>
	</div>
	
	
	<div class="productParamterPart">
		<div class="productParamter">岗位描述：</div>
		
		<div class="productParamterList">
			
			<span>工作经验：${p.experience}</span>
			<span>学历要求：${p.education}</span>
			<span>所属公司：${p.company.name}</span>
			<span>岗位类别：${p.category.name}</span><span></span><span></span>
		    <span style="width:100%">岗位职责及福利待遇：</span>
			<span style="width:100%">${p.description}</span>
		</div>
		<div style="clear:both"></div>
	</div>
	
</div>

