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
		<div><a href="job_listByCompany">已发布岗位</a></div>
		<div><a href="Employment_listByCompany">招聘管理</a></div>
		<div><a href="createJob_edit" class="noRightborder">新建岗位</a></div>
		<div class="orderTypeLastOne"><a class="noRightborder">&nbsp;</a></div>
	</div>
	<div class="panel panel-info addDiv" style="margin: 30px">
        <div class="panel-heading" style="text-align: center; font-size:100%">创建岗位</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="createJob" enctype="multipart/form-data">
                <table class="addTable" width="100%">
                    <tr>
                        <td>岗位名称<div class="addinput"><input   name="name" type="text" class="form-control" value=""></div></td>
                        <td>所在城市<div class="addinput"><input   name="city" type="text" class="form-control"value=""></div></td>
                    </tr>
                    <tr>
                        <td>岗位性质<div class="addinput"><input   name="nature" type="text" class="form-control"value=""></div></td>
                        <td>工作经验<div class="addinput"><input   name="experience" type="text" class="form-control" value=""></div></td>
                    </tr>
                    <tr>
                        <td>学历要求<div class="addinput"><input   name="education" type="text" class="form-control" value=""></div></td>
                        <td>薪资水平<div class="addinput"><input   name="salary" type="text" class="form-control" value=""></div></td>		
                    </tr>
                    
                    <tr>
                        <td>岗位详细描述<div class="addinput"></div></td>
                        <td>岗位类别
                            <div class="addinput">
                                  <select id="cid" name="cid">
                                  <c:forEach items="${cs}" var="c" varStatus="st">
                                     <option value="${c.id}">${c.name}</option>
                                  </c:forEach>
                                  </select>
                              </div>
                        </td>
                    </tr>
                    <tr>
                        <td><div class="addinput"><textarea name="description" class="form-control"></textarea></div></td>
                    </tr>
                
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="coid" value="${user.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>