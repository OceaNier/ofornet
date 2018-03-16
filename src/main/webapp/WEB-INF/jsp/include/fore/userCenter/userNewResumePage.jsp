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
	width: 70%;
}

textarea.form-control{
	display: inline;
	width: 328px;
	height:200px;
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
        <div class="panel-heading" style="text-align: center; font-size:100%">创建简历</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="createResume" enctype="multipart/form-data">
                <table class="addTable" width="100%">
                    <tr>
                        <td>用户名&emsp;<div class="addinput">${user.username}</div></td>
                        
                    </tr>
                    <tr>
                        <td>真实姓名<div class="addinput"><input   name="username" type="text" class="form-control" value=""></div></td>
                        <td>性&emsp;&emsp;别<div class="addinput"><input   name="sex" type="text" class="form-control"value=""></div></td>
                    </tr>
                    <tr>
                        <td>年&emsp;&emsp;龄<div class="addinput"><input   name="age" type="text" class="form-control"value=""></div></td>
                        <td>电子邮箱<div class="addinput"><input   name="email" type="text" class="form-control" value=""></div></td>
                    </tr>
                    <tr>
                        <td>学&emsp;&emsp;历<div class="addinput"><input   name="degree" type="text" class="form-control" value=""></div></td>
                        <td>籍&emsp;&emsp;贯<div class="addinput"><input   name="hometown" type="text" class="form-control" value=""></div></td>		
                    </tr>
                    <tr>
                        <td>居住地址<div class="addinput"><input   name="address" type="text" class="form-control"value=""></div></td>
                        <td>联系电话<div class="addinput"><input   name="phone" type="text" class="form-control" value=""></div></td>
                    </tr>
                    <tr>
                        <td>主要技能<div class="addinput"><input   name="skill" type="text" class="form-control"value=""></div></td>
                        <td>意向岗位<div class="addinput"><input   name="job" type="text" class="form-control" value=""></div></td>
                    </tr>
                    <tr>
                        <td>备&emsp;&emsp;注<div class="addinput"><input   name="message" type="text" class="form-control" value=""></div></td>
                        <td>简历照片<div class="addinput"><input id="resumePic" accept="image/*" type="file" name="image" /></div></td>
                    </tr>
                    <tr>
                        <td>工作经历<div class="addinput"></div></td>
                        <td>项目经历<div class="addinput"></div></td>
                    </tr>
                    <tr>
                        <td><div class="addinput"><textarea name="experience" class="form-control"></textarea></div></td>
                        <td><div class="addinput"><textarea name="project" class="form-control"></textarea></div></td>
                    </tr>
                    <tr>
                        <td>获奖情况<div class="addinput"></div></td>    
                    </tr>
                    <tr>
                        <td><div class="addinput"><textarea name="award" class="form-control"></textarea></div></td>
                    </tr>
                    
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="uid" value="${user.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>