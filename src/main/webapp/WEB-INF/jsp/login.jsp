<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
	<title>考勤管理系统登录</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="../../static/manager/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../static/manager/css/login.css" media="all">

	<script src="../../static/commen/js/ajaxResponse.js?1=1"></script>
	<script src="../../static/commen/layer/layer.js?1=1"></script>
	<script src="../../static/js/jquery.min.js"></script>
	<script src="../../static/commen/js/common.js?1=1"></script>
	<script src="../../static/js/moudles/login/login.js"></script>
</head>
<body>
<div class="layui-canvs"></div>
<form id="loginForm">
<div class="layui-layout layui-layout-login" style="height: 320px">
	<h1>
		 <strong style="font-size: 25px;text-align: center;letter-spacing: 8px">考勤管理系统</strong>
		 <em>Management System</em>
	</h1>
	<div class="layui-user-icon larry-login">
		 <input type="text" placeholder="账号"  id="loginCardId" class="login_txtbx"/>
	</div>
	<div class="layui-pwd-icon larry-login" style="margin-top: 20px">
		 <input type="password" placeholder="密码" id="password" class="login_txtbx"/>
	</div>
    <%--<div class="layui-val-icon larry-login">
    	<div class="layui-code-box">
    		<input type="text" id="code" name="code" placeholder="验证码" maxlength="4" class="login_txtbx">
            <img src="../../static/images/demoImages/verifyimg.png" alt="" class="verifyImg" id="verifyImg" onClick="javascript:this.src='xxx'+Math.random();">
    	</div>
    </div>--%>
    <div class="layui-submit larry-login" style="margin-top: 20px">
    	<input type="button" value="立即登陆" class="submit_btn" onclick="PtloginSubmit()"/>
    </div>

	<div class="layui-submit larry-login" style="margin-top: 20px">
		<input type="button" value="立即注册" class="submit_btn" onclick="registerSubmit()"/>
	</div>
    <%--<div class="layui-login-text">
    	<p style="font-size: 14px">© 2016-2017 Larry 版权所有</p>
        <p>鄂xxxxxx</p>
    </div>--%>
</div>
</form>
<script type="text/javascript" src="../../static/manager/common/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="../../static/manager/js/login.js"></script>
<script type="text/javascript" src="../../static/manager/jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
$(function(){
	$(".layui-canvs").jParticle({
		background: "#141414",
		color: "#E6E6E6"
	});
	/*//登录链接测试，使用时可删除
	$(".submit_btn").click(function(){
	  location.href="index.html";
	});*/
});
</script>
</body>
</html>