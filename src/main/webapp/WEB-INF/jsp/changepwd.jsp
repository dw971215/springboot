<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
	<title>个人信息</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="../../static/manager/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../static/manager/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../static/manager/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../static/manager/css/personal.css" media="all">

	<script src="../../static/commen/js/ajaxResponse.js?1=1"></script>
	<script src="../../static/commen/layer/layer.js?1=1"></script>
	<script src="../../static/commen/js/jquery-3.4.1.min.js"></script>
	<script src="../../static/commen/js/common.js?1=1"></script>
	<script src="../../static/js/moudles/changepassword/changepassword.js"></script>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>修改密码</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix changepwd">
			<form class="layui-form col-lg-4" id="changePwdForm">
			 	<div class="layui-form-item">
					<label class="layui-form-label">账号</label>
					<div class="layui-input-block">  
					  	<input type="text" name="cardId" id="cardId" autocomplete="off"  class="layui-input layui-disabled" value="${userVo.cardId}" disabled="disabled" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">旧密码</label>
					<div class="layui-input-block">
                        <input id="oldpwd" type="hidden" value="${userVo.pwd}">
					  	<input type="password" name="oldPassWord" id="oldPassWord" autocomplete="off"  class="layui-input" value="" placeholder="请输入旧密码">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-block">  
					  	<input type="password" name="newPassWord" id="newPassWord"  autocomplete="off"  class="layui-input" value="" placeholder="请输入新密码">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认密码</label>
					<div class="layui-input-block">  
					  	<input type="password" name="rePassWord" id="rePassWord" autocomplete="off"  class="layui-input" value="" placeholder="请输入确认新密码">
					</div>
				</div>
				<div class="layui-form-item change-submit">
					<div class="layui-input-block">
						<button class="layui-btn" type="button" onclick="changePassWord()" <%--lay-submit="" lay-filter="demo1"--%>>立即修改</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="../../static/manager/common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
	});
</script>
</body>
</html>