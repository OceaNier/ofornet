<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
</script>
 
<title>用户管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >用户管理</h1>
 
    <br>
    <br>
 
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>用户名</th>
                <th>昵称</th>
                <th>真实姓名</th>
                <th>性别</th>
                <th>联系方式</th>
                <th>邮箱</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${us}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.username}</td>
                    <td>${u.nickname}</td>
                    <td>${u.realname}</td>
                    <td>${u.sex}</td>
                    <td>${u.phonenum}</td>
                    <td>${u.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
 
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
 
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>