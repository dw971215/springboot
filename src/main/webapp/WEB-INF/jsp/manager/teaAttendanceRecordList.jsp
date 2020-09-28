<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="author" content="order by dede58.com"/>
	<title>出勤学生列表</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/layui/css/layui.css" media="all">
	<%--<link rel="stylesheet" type="text/css" href="../../../static/manager/common/layui/css/modules/laydate/default/laydate.css">--%>
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/css/personal.css" media="all">
	<%--<script type="text/javascript" src="../../../static/manager/common/layui/layui.all.js"></script>--%>

	<%--<link rel="stylesheet" href="../../../static/other/layui/src/css/layui.css">--%>

	<script src="../../../static/commen/js/ajaxResponse.js?1=1"></script>
	<script src="../../../static/commen/layer/layer.js?1=1"></script>
	<script src="../../../static/commen/js/jquery-3.4.1.min.js"></script>
	<script src="../../../static/commen/js/common.js?1=1"></script>
	<script src="../../../static/js/moudles/attendance/attendance.js"></script>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<div class="layui-tab">
			<blockquote class="layui-elem-quote news_search">
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input value="${leaveName}" placeholder="请输入姓名" id="leaveName" class="layui-input search_input" type="text" autocomplete="off">
					</div>
					<div class="layui-input-inline">
						<%--<input class="layui-input" id="RecorTime" lay-verify="required|date" onClick="layui.laydate({elem:this})" type="text" autocomplete="off">--%>
                            <input type="text" placeholder="请选择开始时间" class="layui-input" id="recorStarTime" value="${recorStarTime}" autocomplete="off">
					</div>
					<div class="layui-input-inline">
						<%--<input class="layui-input" id="RecorTime" lay-verify="required|date" onClick="layui.laydate({elem:this})" type="text" autocomplete="off">--%>
						<input type="text" placeholder="请选择结束时间" class="layui-input" id="recorEndTime" value="${recorEndTime}" autocomplete="off">
					</div>
					<a  href="javascript:void(0);" class="layui-btn search_btn" onclick="teaSelectAttenRecord()" target="_self">查询</a>
				</div><div class="layui-inline">
			</div>
			</blockquote>
			<label>人数：${size}</label>
			<!-- 操作日志 -->
			<div class="layui-form news_list">
				<table class="layui-table">
					<colgroup>
						<col width="5%">
						<col width="10%">
						<col width="10%">
						<col width="20%">
						<col width="30%">
						<col width="15%">
					</colgroup>
					<thead>
					<tr>
						<th style="text-align: center">序号</th>
						<th style="text-align: center">姓名</th>
						<th style="text-align: center">性别</th>
						<th style="text-align: center">手机号码</th>
						<th style="text-align: center">所在班级</th>
						<th style="text-align: center">操作</th>
					</tr>
					</thead>
					<tbody class="news_content" id="tt">
					<c:forEach items="${list}" var="attendanceVo" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td align="center">${attendanceVo.stuName}</td>
							<td>${attendanceVo.identity}</td>
							<td>${attendanceVo.phone}</td>
							<td>${attendanceVo.classInfo}</td>
							<td>
								<a href="/pt/attendance/teaViewAttendance?stuCardId=${attendanceVo.stuCardId}&teaCardId=${teaCardId}" target="mainContent"  <%--onclick="showAttendanceDetail(${attendanceVo.id})"--%> class="layui-btn layui-btn-small"><i class="iconfont"></i>详情</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

				<%--<tr class="template" style="display: none">
					<td id="xuhao"></td>
					<td id="qingjiaren" align="center">${leaveVo.leaveName}</td>
					<td id="reason">${leaveVo.reason}</td>
					<td id="leaveTime"><fmt:formatDate  value="${leaveVo.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>~<fmt:formatDate value="${leaveVo.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td id="status"></td>
					<td id="addTime"><fmt:formatDate value="${leaveVo.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<a href="javascript:;" onclick="verifyLeavePass(${leaveVo.id})" class="layui-btn layui-btn-small"><i class="iconfont"></i>审核通过</a>
						<a href="javascript:;" onclick="verifyLeaveNoPass(${leaveVo.id})" class="layui-btn layui-btn-small"><i class="iconfont"></i>审核不通过</a>
						&lt;%&ndash;<a class="layui-btn layui-btn-mini "><i class="iconfont icon-edit"></i> 审核通过</a>
                        <a class="layui-btn layui-btn-normal layui-btn-mini"><i class="layui-icon"></i> 审核不通过</a>&ndash;%&gt;
					</td>
				</tr>--%>
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
            elem: '#recorStarTime' //指定元素
            ,type: 'datetime'
            ,theme: 'molv'
            //,range: true
            ,trigger: 'click'
        });

		laydate.render({
			elem: '#recorEndTime' //指定元素
			,type: 'datetime'
			,theme: 'molv'
			//,range: true
			,trigger: 'click'
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