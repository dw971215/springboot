<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="author" content="order by dede58.com"/>
	<title>出勤记录</title>
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
	<script src="../../../static/js/moudles/leavemanage/verifyLeave.js"></script>
</head>
<body>
<section class="layui-larry-box">
	<div class="layui-inline">
		<label class="layui-form-label">时间</label>
		<div class="layui-input-inline">
			<input class="layui-input"  value="${RecordTime}" id="RecorTime" lay-verify="required|date" onClick="layui.laydate({elem:this})" type="text" autocomplete="off">
		</div>
		<a class="layui-btn search_btn" href="javascript:void(0)" onclick="selectAenRecord()" target="_self">查询</a>
	</div>
	<div class="larry-personal">
		<div class="layui-tab">
			<%--<blockquote class="layui-elem-quote news_search">
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input value="" placeholder="" id="leaveName" class="layui-input search_input" type="text">
					</div>
					<a  href="javascript:;" class="layui-btn search_btn" onclick="selectStu()">查询</a>
				</div><div class="layui-inline">
			</div>
			</blockquote>--%>

			<!-- 操作日志 -->
			<div class="layui-form news_list">
				<table class="layui-table">
					<colgroup>
						<col width="5%">
						<col width="10%">
						<col width="25%">
						<col width="15%">
						<col width="15%">
					</colgroup>
					<thead>
					<tr>
						<th>序号</th>
						<th>科目</th>
						<th>出勤时间</th>
						<th>授课老师</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody class="news_content" id="tt">
					<c:forEach items="${list}" var="attendanceVo" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td align="center">${attendanceVo.course}</td>
							<td><fmt:formatDate value="${attendanceVo.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>~<fmt:formatDate value="${attendanceVo.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${attendanceVo.teaName}</td>
							<td>
								<a href="/pt/attendance/viewAttendanceDetail?id=${attendanceVo.id}&flag=1" target="mainContent" <%--onclick="showAttendanceDetail(${attendanceVo.id})"--%> class="layui-btn layui-btn-small"><i class="iconfont"></i>详情</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<%--<div class="larry-table-page clearfix">
					<div id="page" class="page"></div>
				</div>--%>
			</div>
		</div>
	</div>

</section>
<script type="text/javascript" src="../../../static/manager/common/layui/layui.js"></script>
<script type="text/javascript" src="../../../static/manager/js/newsadd.js"></script>
<script src="../../../static/other/layui/src/layui.js" charset="utf-8"></script>
<script type="text/javascript">
	layui.use('laydate', function() {
		var laydate = layui.laydate;
		laydate.render({
			elem: '#RecorTime' //指定元素
			, type: 'date'
			, theme: 'molv'
			//,range: true
			, trigger: 'click'
		});
	});
	/*layui.use(['jquery','layer','element','laypage'],function(){
		window.jQuery = window.$ = layui.jquery;
		window.layer = layui.layer;
		var element = layui.element(),
				laypage = layui.laypage;


		laypage({
			cont: 'page',
			pages: 10 //总页数
			,
			groups: 5 //连续显示分页数
			,
			jump: function(obj, first) {
				//得到了当前页，用于向服务端请求对应数据
				var curr = obj.curr;
				if(!first) {
					//layer.msg('第 '+ obj.curr +' 页');
				}
			}
		});

		laypage({
			cont: 'page2',
			pages: 10 //总页数
			,
			groups: 5 //连续显示分页数
			,
			jump: function(obj, first) {
				//得到了当前页，用于向服务端请求对应数据
				var curr = obj.curr;
				if(!first) {
					//layer.msg('第 '+ obj.curr +' 页');
				}
			}
		});
	});*/
</script>
</body>
</html>