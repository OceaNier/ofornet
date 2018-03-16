<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<title>编辑公司</title>
 
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
 
<div class="workingArea">
 
    <ol class="breadcrumb">
        <li><a href="admin_company_list">所有公司</a></li>
        <li class="active">编辑公司</li>
    </ol>
 
    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑公司</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_company_update"  enctype="multipart/form-data">
                <table class="editTable">
                    <tr>
                        <td>用户名:</td>
                        <td>${c.username}</td>
                    </tr>
                    <tr>
                        <td>公司名称</td>
                        <td><input id="name" name="name" value="${c.name}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input id="password" name="password" value="${c.password}" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>城市</td>
                        <td><input id="city" name="city" value="${c.city}" type="text" class="form-control"></td>
                    </tr>
                    
                    <tr>
                        <td>分类圖片</td>
                        <td>
                            <input id="companyPic" accept="image/*" type="file" name="image" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${c.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>