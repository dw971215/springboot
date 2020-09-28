<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
	<title>请假申请</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/css/personal.css" media="all">


	<script src="../../../static/commen/js/ajaxResponse.js?1=1"></script>
	<script src="../../../static/commen/layer/layer.js?1=1"></script>
	<script src="../../../static/commen/js/jquery-3.4.1.min.js"></script>
	<script src="../../../static/commen/js/common.js?1=1"></script>
	<script src="../../../static/js/moudles/leavemanage/leaveManage.js"></script>

	<%--<link rel="stylesheet" type="text/css" href="../../../static/manager/css/layui.css" media="all">--%>
</head>
<body <%--class="childrenBody"--%>>
	<form class="layui-form" id="leaveForm">
		<input id="cardId" type="hidden" value="${cardId}"><%--用户账号--%>
		<div class="layui-form-item">
			<label class="layui-form-label">请假人</label>
			<div class="layui-input-block">
				<input style="width: 150px;" class="layui-input" id="leaveName" lay-verify="required" value="${uname}" disabled="disabled" placeholder="请输入请假人姓名" type="text">
			</div>
		</div>
		<div class="layui-form-item">
			<%--<div class="layui-inline">
				<label class="layui-form-label">自定义属性</label>
				<div class="layui-input-block">
					<input name="tuijian" class="tuijian" title="推荐" type="checkbox"><div class="layui-unselect layui-form-checkbox" lay-skin=""><span>推荐</span><i class="layui-icon"></i></div>
					<input name="shenhe" class="newsStatus" title="审核" type="checkbox"><div class="layui-unselect layui-form-checkbox" lay-skin=""><span>审核</span><i class="layui-icon"></i></div>
					<input name="show" class="isShow" title="展示" type="checkbox"><div class="layui-unselect layui-form-checkbox" lay-skin=""><span>展示</span><i class="layui-icon"></i></div>
				</div>
			</div>--%>
			<%--<div class="layui-inline">
				<label class="layui-form-label">文章作者</label>
				<div class="layui-input-inline">
					<input class="layui-input newsAuthor" lay-verify="required" placeholder="请输入文章作者" type="text">
				</div>
			</div>--%>
			<div class="layui-inline">		
				<label class="layui-form-label">请假时间</label>
				<div class="layui-input-inline">
					<input class="layui-input" id="startTime" <%--lay-verify="required|date" onClick="layui.laydate({elem:this})" --%>type="text" autocomplete="off">
				</div>
				<label class="layui-form-label" style="width: 40px">至</label>
				<div class="layui-input-inline">
					<input class="layui-input" id="endTime" <%--lay-verify="required|date" onClick="layui.laydate({elem:this})"--%> type="text" autocomplete="off">
				</div>
			</div>

			<%--<div class="layui-inline">
				<label class="layui-form-label">浏览权限</label>
				<div class="layui-input-inline">
					<select name="browseLook" class="newsLook" lay-filter="browseLook">
				        <option value="0">开放浏览</option>
				        <option value="1">会员浏览</option>
				    </select><div class="layui-unselect layui-form-select"><div class="layui-select-title"><input placeholder="开放浏览" value="开放浏览" readonly="" class="layui-input layui-unselect" type="text"><i class="layui-edge"></i></div><dl class="layui-anim layui-anim-upbit"><dd lay-value="0" class="layui-this">开放浏览</dd><dd lay-value="1" class="">会员浏览</dd></dl></div>
				</div>
			</div>--%>
		</div>
		<%--<div class="layui-form-item">
			<label class="layui-form-label">审批者</label>
			<div class="layui-input-block">
				<select name="approverCardId" id="approverCardId" lay-filter="aihao">
					<option value=""></option>
					<option value="0"<c:if test="${userVo.identity eq '0'}">selected="selected"</c:if>>学生</option>
					<option value="1"<c:if test="${userVo.identity eq '1'}">selected="selected"</c:if>>老师</option>
				</select>
			</div>
		</div>--%>
		<div class="layui-form-item">
			<label class="layui-form-label">审批者</label>
			<div class="layui-input-inline">

				<select name="interest-search" id="approverCardId" lay-filter="interest-search" lay-search>
					<option value="">请选择</option>
					<c:forEach items="${list}" var="leaveVo">
						<option value="${leaveVo.approverCardId}">${leaveVo.approverName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">请假理由</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入请假理由" id="reason" class="layui-textarea" style="width: 400px"></textarea>
			</div>
		</div>
		<%--<div class="layui-form-item">
			<label class="layui-form-label">文章内容</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="news_content"></textarea><div class="layui-layedit"><div class="layui-unselect layui-layedit-tool"><i class="layui-icon layedit-tool-b" title="加粗" lay-command="Bold" layedit-event="b" "=""></i><i class="layui-icon layedit-tool-i" title="斜体" lay-command="italic" layedit-event="i" "=""></i><i class="layui-icon layedit-tool-u" title="下划线" lay-command="underline" layedit-event="u" "=""></i><i class="layui-icon layedit-tool-d" title="删除线" lay-command="strikeThrough" layedit-event="d" "=""></i><span class="layedit-tool-mid"></span><i class="layui-icon layedit-tool-left" title="左对齐" lay-command="justifyLeft" layedit-event="left" "=""></i><i class="layui-icon layedit-tool-center" title="居中对齐" lay-command="justifyCenter" layedit-event="center" "=""></i><i class="layui-icon layedit-tool-right" title="右对齐" lay-command="justifyRight" layedit-event="right" "=""></i><span class="layedit-tool-mid"></span><i class="layui-icon layedit-tool-link" title="插入链接" layedit-event="link" "=""></i><i class="layui-icon layedit-tool-unlink layui-disabled" title="清除链接" lay-command="unlink" layedit-event="unlink" "=""></i><i class="layui-icon layedit-tool-face" title="表情" layedit-event="face" "=""></i><i class="layui-icon layedit-tool-image" title="图片" layedit-event="image"><input name="file" type="file"></i></div><div class="layui-layedit-iframe"><iframe id="LAY_layedit_1" name="LAY_layedit_1" textarea="news_content" style="height: 280px;" frameborder="0"></iframe></div></div>
			</div>
		</div>--%>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" type="button" onclick="leaveSubmit()">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<%--<script src="../../../static/manager/js/layui.js"></script>--%>
	<script type="text/javascript" src="../../../static/manager/common/layui/layui.js"></script>
	<script type="text/javascript" src="../../../static/manager/js/newsadd.js"></script>
	<script src="../../../static/other/layui/src/layui.js" charset="utf-8"></script>
	<script type="text/javascript">
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			laydate.render({
				elem: '#startTime' //指定元素
				, type: 'datetime'
				, theme: 'molv'
				//,range: true
				, trigger: 'click'
			});

			laydate.render({
				elem: '#endTime' //指定元素
				, type: 'datetime'
				, theme: 'molv'
				//,range: true
				, trigger: 'click'
			});
		});
	</script>
</body>
</html>