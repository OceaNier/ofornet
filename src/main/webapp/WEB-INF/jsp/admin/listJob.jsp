<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
 
<title>岗位管理</title>
 
<div class="workingArea">
 
    <ol class="breadcrumb">
        <%-- <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_job_list?cid=${c.id}">${c.name}</a></li> --%>
        <li class="active">岗位管理</li>
    </ol>
 
    <div class="listDataTableDiv">
        <table
                class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>岗位名称</th>
                <th>工作地点</th>
                <th>所属公司</th>
                <th>岗位种类</th>
                <th width="120px">岗位性质</th>
                <th width="120px">工作经验要求</th>
                <th width="120px">教育程度</th>
                <th width="120px">薪资待遇</th>
                <!-- <th width="80px">设置属性</th> -->
                <th width="40px">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ps}" var="p">
                <tr>
                    <%-- <td>
                        <c:if test="${!empty p.firstProductImage}">
                            <img width="40px" src="img/productSingle/${p.firstProductImage.id}.jpg">
                        </c:if>
                    </td> --%>
                    <td>${p.name}</td>
                    <td>${p.city}</td>
                    <td>${p.company.name}</td>
                    <td>${p.category.name}</td>
                    <td>${p.nature}</td>
                    <td>${p.experience}</td>
                    <td>${p.education}</td>
                    <td>${p.salary}</td>
                    <%-- <td><a href="admin_productImage_list?pid=${p.id}"><span
                            class="glyphicon glyphicon-picture"></span></a></td>
                    <td><a href="admin_propertyValue_edit?pid=${p.id}"><span
                            class="glyphicon glyphicon-th-list"></span></a></td>
 
                    <td><a href="admin_job_edit?id=${p.id}"><span
                            class="glyphicon glyphicon-edit"></span></a></td> --%>
                    <td><a deleteLink="true"
                           href="admin_job_delete?id=${p.id}"><span
                            class="glyphicon glyphicon-trash"></span></a></td>
 
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
 
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>
 
</div>
 
<%@include file="../include/admin/adminFooter.jsp"%>