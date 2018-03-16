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

div.addinput{
padding-left:20px;
display: inline;
}
input.form-control{
	display: inline;
	width: 50%;
}
tr{
 height: 50px;
}
td
{
padding-left:60px;
margin: auto 0;
width: 50%;
}
</style>

<div class="boughtDiv">
	<div class="orderType1">
		<div class="selectedOrderType"><a href="foreuserCollection">我的收藏</a></div>
		<div><a  orderStatus="waitDelivery" href="myresume">我的简历</a></div>
		<div><a  orderStatus="waitConfirm" href="myemployment">我的招聘状态</a></div>
		<div><a href="edituser">编辑个人资料</a></div>
		<div><a  orderStatus="waitReview" href="foreCreateResume" class="noRightborder">制作简历</a></div>
		<div class="orderTypeLastOne"><a class="noRightborder">&nbsp;</a></div>
	</div>
	<div class="panel panel-info addDiv" style="margin: 30px">
        <div class="panel-heading" style="text-align: center; font-size:100%">编辑个人资料</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
                <table class="addTable" width="100%">
                    <tr>
                        <td>用户名&emsp;&emsp;<div class="addinput">${user.username}</div></td>
                    </tr>
                    <tr>
                        <td>真实姓名<div class="addinput"><input name="realname" type="text" class="form-control" value="${u.realname}"></div></td>
                        <td>性&emsp;&emsp;别<div class="addinput"><input name="sex" type="text" class="form-control"value="${u.sex}"></div></td>
                    </tr>
                    <tr>
                        <td>昵&emsp;&emsp;称<div class="addinput"><input   name="nickname" type="text" class="form-control"value="${u.nickname}"></div></td>
                        <td>联系电话<div class="addinput"><input name="phonenum" type="text" class="form-control" value="${u.phonenum}"></div></td>
                    </tr>
                    <tr>
                        <td>电子邮箱<div class="addinput"><input name="email" value="${u.email}" type="text" class="form-control" ></div></td>
                    </tr>
                    
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>