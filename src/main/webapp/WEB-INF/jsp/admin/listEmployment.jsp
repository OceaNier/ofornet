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
        return true;
    });
});
 
</script>
 
<title>招聘管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >招聘管理</h1>
    <br>
    <br>
     
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
                <tr class="success">
                    <th>招聘ID</th>
                    <th>岗位名称</th>
                    <th>当前招聘状态</th>
                    <th>修改招聘状态</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${es}" var="e">
                 
                <tr>
                    <td>${e.id}</td>
                    <td>${e.job.name}</td>
                    <td>${e.employStatus}</td>
                    <td><form method="post" id="addForm" action="Employment_updateStatus?eid=${e.id}" enctype="multipart/form-data">
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
                    <td><a deleteLink="true" href="deleteEmployment"?id=${e.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    
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