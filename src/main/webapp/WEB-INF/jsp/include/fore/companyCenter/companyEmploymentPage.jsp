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
				<td width="180px">岗位名称</td>
				<td width="180px">申请时间</td>
				<td width="100px">所属公司</td>
				<td width="60px">查看简历</td>
				<td width="100px">应聘人</td>
				<td width="100px">招聘状态</td>
				<td>更新招聘状态</td>
				<td width="60px">删除</td>
				
			</tr>
		</table>
	</div>
	<div class="orderListItem">
	       <table class="orderListItemTable" >
				<c:forEach items="${es}" var="e" varStatus="st">
					<tr class="orderItemProductInfoPartTR" style="height:60px">
						    <td valign="middle" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD" width="180px">
								<div>${e.job.name}</div>
							</td>
							
							<td valign="middle" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD" width="180px">
								<div><fmt:formatDate value="${e.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
							</td>
							
							<td valign="middle" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD" width="100px">
								<div>${e.company.name}</div>
							</td>
							
							<td valign="middle"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="60px">
							<a  href="resumeview?rid=${e.rid}">
							<span class="glyphicon glyphicon-eye-open"></span>
							</a>
						    </td>
							
							<td valign="middle" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD" width="100px">
								<div>${e.user.realname}</div>
							</td>
							
							<td valign="middle" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD" width="100px">
								<div>${e.employStatus}</div>
							</td>
							
							<td valign="middle"  class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD">
							  <form method="post" action="Employment_updateStatus?eid=${e.id}" enctype="multipart/form-data">
                                  <select id="status" name="status">
                                     <option value="简历已投递">简历已投递</option>
                                     <option value="待笔试／待测评">待笔试／待测评</option>
                                     <option value="待面试(一面)">待面试(一面)</option>
                                     <option value="待面试(二面)">待面试(二面)</option>
                                     <option value="待面试(HR面)">待面试(HR面)</option>
                                     <option value="已录用">已录用</option>
                                     <option value="已回绝">已回绝</option>
                                  </select>
                                <button type="submit" class="btn btn-success" style="height:20px; font-size: 80%">提 交</button>
                              </form>
                            </td>
						 
						    <td valign="middle"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="60px">
							    <a  href="deleteEmployment?eid=${e.id}">
							    <span class="glyphicon glyphicon-trash"></span>
							    </a>
						    </td>
					</tr>
				</c:forEach>	
			</table>
		
	</div>
	
</div>