<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<title></title>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="stylesheet" type="text/css" href="css/shoujisc.css">
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/showTip.css">
<script type="text/javascript" src="js/showTip.js"></script>
</head>

<body id="wrap">
	
    <ul class="xzdz-ul1">
    	<li>
        	<p class="xzdz-p1 f-l">联系人</p>
            <input type="text" placeholder="姓名" class="xzdz-ipt1 f-l" id="name"/>
            <div style="clear:both;"></div>            
        </li>
    	<li>
        	<p class="xzdz-p1 f-l">手机号</p>
            <input type="text" placeholder="11位手机号" class="xzdz-ipt1 f-l" id="phone"/>
            <div style="clear:both;"></div>            
        </li>
    	<li>
        	<p class="xzdz-p1 f-l">性别</p>
            <input type="radio" name="sex" id="radio1" value="男"/>男
            <input type="radio" name="sex" id="radio2" value="女"/>女
            <div style="clear:both;"></div>            
        </li>
        <li>
        	<p class="xzdz-p1 f-l">年龄</p>
            <input type="text" placeholder="年龄" class="xzdz-ipt1 f-l" id="age"/>
            <div style="clear:both;"></div>            
        </li>
    	<li>
        	<p class="xzdz-p1 f-l">详细地址</p>
        	<p>
        	
            <input type="text" placeholder="联系人所在地" class="xzdz-ipt1 f-l" id="address" />
            <div style="clear:both;"></div>            
        </li>
    	
    </ul>
<div class="sjsc-title1" style="border-bottom:1px solid #ABD13E">
        <button class="sjsc-btn1 f-r" onclick="add()">加入我们</button>
        <div style="clear:both;"></div>
    </div>
    <script type="text/javascript">
			function add(join_id) {
				var name =$('#name').val();
				if(name==""){
					showTip("请填写姓名");return;
				}
				var phone =$('#phone').val();
				if(phone==""){
					showTip("请填写手机号码");return;
				}
				var sex =$("#radio1").is(":checked")?"男":"女";
				//alert(sex);
				if(sex==""){
					showTip("请填写性别");return;
				}
				var age =$('#age').val();
				if(age==""){
					showTip("请填写年龄");return;
				}
				
				var address =$('#address').val();
				if(address==""){
					showTip("请填写具体收货地址");return;
				}
				$.ajax({
					url : 'joinInsert.html',
					type : 'post',
					data : 'name=' + name + '&phone=' + phone
					+ '&address=' + address +'&sex=' +sex+'&age='+age,
					success : function(rs) {
						if (rs == 1) {
							window.location.href = document.referrer;
						} else {
							alert("系统故障！");
						}
					}
				})
			}
		</script>
</body>
</html>
