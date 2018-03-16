

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<style>
div.top {
	background-image: url(./img/site/topbg.png);
	border: 0px solid #DFDFDF;
	padding: 20px;
}</style>
<div class="top">
	<a href="${contextPath}">
		<img id="simpleLogo" class="simpleLogo" src="img/site/logo.png">
	</a>
	<form action="foresearch" method="post" >
		<div class="simpleSearchDiv pull-right">
			<input type="text" placeholder="产品经理  Java研发工程师"  value="${param.keyword}" name="keyword">
			<button class="searchButton" type="submit">搜索</button>
			<div class="searchBelow">
				<c:forEach items="${cs}" var="c" varStatus="st">
					<c:if test="${st.count>=8 and st.count<=11}">
					<span>
						<a href="forecategory?cid=${c.id}">
								${c.name}
						</a>
						<c:if test="${st.count!=11}">
							<span>|</span>
						</c:if>
					</span>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</form>
	<div style="clear:both"></div>
</div>