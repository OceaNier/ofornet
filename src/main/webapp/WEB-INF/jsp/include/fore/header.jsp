<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<script src="js/jquery/2.0.0/jquery.min.js"></script>
	<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<link href="css/fore/style.css" rel="stylesheet">
	<script>
	
	function checkEmpty(id, name){
		var value = $("#"+id).val();
		if(value.length==0){
			alert(name+ "不能为空");
			$("#"+id)[0].focus();
			return false;
		}
		return true;
	}
	function checkNumber(id, name){
		var value = $("#"+id).val();
		if(value.length==0){
			alert(name+ "不能为空");
			$("#"+id)[0].focus();
			return false;
		}
		if(isNaN(value)){
			alert(name+ "必须是数字");
			$("#"+id)[0].focus();
			return false;
		}
		
		return true;
	}
	function checkInt(id, name){
		var value = $("#"+id).val();
		if(value.length==0){
			alert(name+ "不能为空");
			$("#"+id)[0].focus();
			return false;
		}
		if(parseInt(value)!=value){
			alert(name+ "必须是整数");
			$("#"+id)[0].focus();
			return false;
		}
		
		return true;
	}

	$(function(){
		$("a").click(function(){
			var deleteLink = $(this).attr("deleteLink");
			console.log(deleteLink);
			if("true"==deleteLink){
				var confirmDelete = confirm("确认要删除");
				if(confirmDelete)
					return true;
				return false;
				
			}
		});
	})
	
        function formatMoney(num){
            num = num.toString().replace(/\$|\,/g,'');
            if(isNaN(num))
                num = "0";
            sign = (num == (num = Math.abs(num)));
            num = Math.floor(num*100+0.50000000001);
            cents = num%100;
            num = Math.floor(num/100).toString();
            if(cents<10)
                cents = "0" + cents;
            for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
                num = num.substring(0,num.length-(4*i+3))+','+
                    num.substring(num.length-(4*i+3));
            return (((sign)?'':'-') + num + '.' + cents);
        }
        
        $(function(){


            $("a.productDetailTopReviewLink").click(function(){
                $("div.productReviewDiv").show();
                $("div.productDetailDiv").hide();
            });
            $("a.productReviewTopPartSelectedLink").click(function(){
                $("div.productReviewDiv").hide();
                $("div.productDetailDiv").show();
            });

            $("span.leaveMessageTextareaSpan").hide();
            $("img.leaveMessageImg").click(function(){

                $(this).hide();
                $("span.leaveMessageTextareaSpan").show();
                $("div.orderItemSumDiv").css("height","100px");
            });

            $("div#footer a[href$=#nowhere]").click(function(){
                alert("没有跳转到实际的页面");
            });


            $("a.wangwanglink").click(function(){
                alert("no");
            });
            $("a.notImplementLink").click(function(){
                alert("这个功能没做");
            });

            $("a.companyCollect").click(function(){
                alert("您是企业用户，不能收藏岗位！");
            });
            
            $("a.companyApply").click(function(){
                alert("您是企业用户，不能申请岗位！");
            });
            

        });

	</script>
</head>

<body>

