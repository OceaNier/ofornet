<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
div.orderType1 div{
	border-bottom: 0px;
}
div.orderType1 a {
	border-right: 1px solid #E8E8E8;
	float: left;
	font-size: 16px;
	font-weight: bold;
	color: black;
	margin-bottom: 10px;
	padding: 0px 20px;
	text-decoration: none;
}
div.selectedOrderType {
	border-bottom: 2px solid #1ec0d7;
}

div.orderType1 a {
	color: black;
}

div.orderType1 a:hover {
	color: #1ec0d7;
	text-decoration: none;
}
</style>
<script>
var deleteOrder = false;
var deleteOrderid = 0;

$(function(){

	
	$("a.deleteOrderLink").click(function(){
		deleteOrderid = $(this).attr("oid");
		deleteOrder = false;
		$("#deleteConfirmModal").modal("show");
	});
	
	$("button.deleteConfirmButton").click(function(){
		deleteOrder = true;
		$("#deleteConfirmModal").modal('hide');
	});	
	
	$('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
		if(deleteOrder){
			var page="foredeleteOrder";
			$.post(
				    page,
				    {"oid":deleteOrderid},
				    function(result){
						if("success"==result){
							$("table.orderListItemTable[oid="+deleteOrderid+"]").hide();
						}
						else{
							location.href="loginPage";
						}
				    }
				);
			
		}
	})		
});

</script>
	
<div class="boughtDiv">
	<div class="orderType1">
		<div><a href="job_listByCompany">已发布岗位</a></div>
		<div><a href="Employment_listByCompany">招聘管理</a></div>
		<div><a href="createJob_edit" class="noRightborder">新建岗位</a></div>
		<div class="orderTypeLastOne"><a class="noRightborder">&nbsp;</a></div>
	</div>
	<div class="orderListTitle">
		<table class="orderListTitleTable">
			<tr>
				<td>岗位名称</td>
				<td width="100px">薪资</td>
				<td width="100px">地点</td>
				<td width="120px">学历要求</td>
				<td width="60px">删除</td>
			</tr>
		</table>
	</div>
	<div class="orderListItem">
	       <table class="orderListItemTable" >
				<c:forEach items="${cs}" var="c" varStatus="st">
					<tr class="orderItemProductInfoPartTR" style="height:80px;">
						    <td valign="middle" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD">
								<a href="forejob?jobid=${c.id}">${c.name}</div>
							</td>
						    <td valign="middle"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">
								<span class="orderListItemNumber">${c.salary}</span>
							</td>
					
							<td valign="middle"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">
								<span class="orderListItemNumber">${c.city}</span>
							</td>
							<td valign="middle"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="120px">
								<span class="orderListItemNumber">${c.education}</span>
							</td>
							<td valign="middle"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="60px">
							<a deleteLink="true" href="job_delete?id=${c.id}">
							<span class="glyphicon glyphicon-trash"></span>
							</a>
							</td>
							
					</tr>
				</c:forEach>	
			</table>
		
	</div>
	
</div>