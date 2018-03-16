<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
 
$(function(){
	
     $(".collect").click(function(){
     var page = "forecheckLogin";
     $.get(
             page,
             function(result){
                 if("success"==result){
                     location.href="foreuserCollection";
                 }
                 else{
                     $("#loginModal").modal('show');                     
                 }
             }
     );      
     return false;
     });
    
     $(".apply").click(function(){
     var page = "forecheckLogin";
     $.get(
             page,
             function(result){
                 if("success"==result){
                     location.href= $(".apply").attr("href");
                 }
                 else{
                     $("#loginModal").modal('show');                     
                 }
             }
     );      
     return false;
     });
 
     $("button.loginSubmitButton").click(function(){
         var name = $("#username").val();
         var password = $("#password").val();
          
         if(0==name.length||0==password.length){
             $("span.errorMessage").html("请输入账号密码");
             $("div.loginErrorMessageDiv").show();           
             return false;
         }
          
         var page = "foreloginAjax";
         $.get(
                 page,
                 {"username":name,"password":password},
                 function(result){
                     if("success"==result){
                         location.reload();
                     }
                     else{
                         $("span.errorMessage").html("账号密码错误");
                         $("div.loginErrorMessageDiv").show();                       
                     }
                 }
         );          
          
         return true;
     });
     
    $("img.smallImage").mouseenter(function(){
        var bigImageURL = $(this).attr("bigImageURL");
        $("img.bigImg").attr("src",bigImageURL);
    });
     
    $("img.bigImg").load(
        function(){
            $("img.smallImage").each(function(){
                var bigImageURL = $(this).attr("bigImageURL");
                img = new Image();
                img.src = bigImageURL;
                 
                img.onload = function(){
                    $("div.img4load").append($(img));
                };
            });     
        }
    );
});
 
</script>
 
<div class="imgAndInfo">


    <div class="infoInimgAndInfo">
         
        <div class="productTitle" style="font-size:300%">
            ${p.name}
        </div>

        <div class="productPrice">
            
            <div class="productPriceDiv" style="width: 935px">
                <div class="gouwujuanDiv"><img height="16px" src="img/site/logo.png">
                <span>互联聘企业直招</span>
                 
                </div>
                <div class="originalDiv">
                    <span class="originalPriceDesc">工作地点</span>
                    <span class="jobCity">
                        ${p.city}
                    </span>
                </div>

                <div class="promotionDiv">
                    <span class="promotionPriceDesc">薪资(月) </span>
                    <span class="promotionPrice" style="font-size:200%">
                        ${p.salary}
                        </span>
                    <span>元</span>
                </div>
            </div>
        </div>

        <div class="productSaleAndReviewNumber">
            <div><span class="blueColor boldWord "> ${p.collecttime}</span>&nbsp人收藏过此岗位</div>
            <div>岗位发布时间：<span class="blueColor boldWord "><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span></div>
        </div>
       
        <div class="serviceCommitment">
            <span class="serviceCommitmentDesc">服务承诺</span>
            <span class="serviceCommitmentLink">
                <a href="#nowhere">企业认证</a>
                <a href="#nowhere">信息保密</a>
                <a href="#nowhere">高效沟通</a>
                <a href="#nowhere">提供第一手就业资讯</a>
            </span>
        </div>    
         
        <div class="buyDiv">
        	<c:if test="${usertype=='u'}">
            <a class="apply" href="foreapply?jobid=${p.id}"><button class="buyButton">投递简历</button></a>
            <a class="collect" href="forecollect?jobid=${p.id}" ><button class="addCartButton"><span class="glyphicon glyphicon glyphicon-star"></span>收藏岗位</button></a>
        	</c:if>
        	<c:if test="${usertype=='c' }">
            <button class="buyButton"  style="cursor:not-allowed"  disabled="disabled" background-color="gray">投递简历</button>
            <button class="addCartButton" style="cursor:not-allowed" disabled="disabled"><span class="glyphicon glyphicon glyphicon-star"></span>收藏岗位</button>
        	</c:if>
        </div>
    </div>
     
    <div style="clear:both"></div>
     
</div>