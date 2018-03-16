<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<style>
div.categoryMenu {
	width: 200px;
	background-color: #000000;
	margin-left: 20px;
	position: absolute;
	left: 0;
	top: 0;
	z-index: 1;
	height:510px;
}
</style>	
<div class="categoryMenu"><br>
		<c:forEach items="${cs}" var="c">
			<div cid="${c.id}" class="eachCategory" style="height:40px;">
				<span class="glyphicon glyphicon-link"></span>
				<a href="#nowhere">
					${c.name}
				</a>
			</div>
		</c:forEach>
</div>  