<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
$(function(){
    
    $("#addForm").submit(function(){
        if(!checkEmpty("name","公司名称"))
            return false;
        if(!checkEmpty("username","用户名"))
            return false;
        if(!checkEmpty("password","密码"))
            return false;
        if(!checkEmpty("city","城市"))
            return false;
        if(!checkEmpty("companyPic","Logo图片"))
            return false;
        return true;
    });
});
 
</script>
 
<title>分类管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>
     
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>公司名称</th>
                    <th>编辑</th>
                    <th>删除</th>              
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cs}" var="c">
                 
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>                
                    <td><a href="admin_company_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_company_delete?id=${c.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
     
    <div class="panel panel-warning addDiv">
      <div class="panel-heading">新增公司</div>
      <div class="panel-body">
            <form method="post" id="addForm" action="admin_company_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>公司名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>用户名</td>
                        <td><input  id="username" name="username" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input  id="password" name="password" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>城市</td>
                        <td><input  id="city" name="city" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Logo图片</td>
                        <td>
                            <input id="companyPic" accept="image/*" type="file" name="image" />
                        </td>
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
 
<%@include file="../include/admin/adminFooter.jsp"%>