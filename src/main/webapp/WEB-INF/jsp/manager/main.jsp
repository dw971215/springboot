<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
	<title>考勤管理系统-Home</title>
  <meta name="renderer" content="webkit"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> 
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="apple-mobile-web-app-capable" content="yes">  
  <meta name="format-detection" content="telephone=no"> 
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/common/global.css">
	<link rel="stylesheet" type="text/css" href="../../../static/manager/css/main.css" media="all">

    <script src="../../../static/commen/js/ajaxResponse.js?1=1"></script>
    <script src="../../../static/commen/layer/layer.js?1=1"></script>
    <script src="../../../static/commen/js/jquery-3.4.1.min.js"></script>
    <script src="../../../static/commen/js/common.js?1=1"></script>
    <style>
		.class2{
			width: 200px;
			overflow: hidden;
			white-space: nowrap;
			text-overflow: ellipsis;
		}
	</style>
</head>
<body>
<section class="larry-wrapper">
    <!-- overview -->
	<div class="row state-overview">
		<div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
			<section class="panel">
				<div class="symbol userblue layui-anim layui-anim-rotate"> <i class="iconpx-users"></i>
				</div>
				<div class="value">
					<a href="#">
						<h1 id="count1">${countNum}</h1>
					</a>
					<p>用户总量</p>
				</div>
			</section>
		</div>
		<div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
			<section class="panel">
				<div class="symbol commred layui-anim layui-anim-rotate"> <i class="iconpx-user-add"></i>
				</div>
				<div class="value">
					<a href="#">
						<h1 id="count2">${countTodayNum}</h1>
					</a>
					<p>今日注册用户</p>
				</div>
			</section>
		</div>
        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up" <c:if test="${longinVo.identity eq '1'}">style="display: none" </c:if>>
			<section class="panel">
				<div class="symbol articlegreen layui-anim layui-anim-rotate">
					<i class="iconpx-file-word-o"></i>
				</div>
				<div class="value">
					<a href="#">
						<h1 id="count3">${stuNum}</h1>
					</a>
					<p>请假记录总数</p>
				</div>
			</section>
		</div>
		<div  <c:if test="${longinVo.identity eq '0'}">style="display: none" </c:if> class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
			<section class="panel">
				<div class="symbol rsswet layui-anim layui-anim-rotate">
					<i class="iconpx-check-circle"></i>
				</div>
				<div class="value">
					<a href="#">
						<h1 id="count4">${teaNum}</h1>
					</a>
					<p>待审核请假信息</p>
				</div>
			</section>
		</div>
	</div>
	<!-- overview end -->
	<div class="row">
		<div class="col-lg-6">
			<%--学生每天学习时间信息--%>
      <%--<section class="panel">
                  <header class="panel-heading bm0">
                       <span class='span-title'>每天学习时间统计</span>
                       <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body laery-seo-box">
                        <div class="larry-seo-stats" id="larry-seo-stats"></div>
                  </div>
      </section>--%>
					<section class="panel" <c:if test="${longinVo.identity eq '1'}">style="display: none" </c:if>>
						<div class="panel-heading">近七天统计</div>
						<div class="panel-body">
							<div class="echarts" id="years" style="height:300px; height:350px"></div>
						</div>
					</section>
                    <section class="panel" <c:if test="${longinVo.identity eq '0'}">style="display: none" </c:if>>
                        <div class="panel-heading">班级人数统计</div>
                        <div class="panel-body">
                            <div class="echarts" id="main" style="height:300px; height:350px"></div>
                        </div>
                    </section>
		</div>
		<div class="col-lg-6">
              <!-- 最新消息 -->
			<section class="panel" <c:if test="${longinVo.identity eq '1'}"> style="display: none" </c:if>>
                  <header class="panel-heading bm0">
                        <span class='span-title'>请假消息</span>
                        <span class="badge" style="background-color:#FF3333;"> new </span>
                        <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body">
                       <table class="table table-hover personal-task">
                             <tbody>
                             <c:forEach items="${stuList}" var="leave" varStatus="i">
                                 <tr>
                                     <td>${i.count}</td>
                                     <td>
                                       <div class="class2" title="${leave.reason}">${leave.reason}</div>
                                     </td>
                                     <td class="col-md-5">开始时间：<fmt:formatDate value="${leave.startTime}" pattern="yyyy-MM-dd"/></td>
									 <td width="20%">${leave.status}</td>
                                 </tr>
                             </c:forEach>
                             </tbody>
                       </table>
                  </div>
             </section>

			<section class="panel" <c:if test="${longinVo.identity eq '0'}"> style="display: none" </c:if>>
				<header class="panel-heading bm0">
					<span class='span-title'>请假审核信息</span>
					<span class="badge" style="background-color:#FF3333;"> new </span>
					<span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
				</header>
				<div class="panel-body">
					<table class="table table-hover personal-task">
						<tbody>
						<c:forEach items="${teaList}" var="leave" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>
									<div class="class2" title="${leave.reason}">${leave.reason}</div>
								</td>
								<td class="col-md-5"><span <c:if test="${leave.reason eq '无请假记录'}">style="display: none" </c:if>>开始时间：</span><fmt:formatDate value="${leave.startTime}" pattern="yyyy-MM-dd"/></td>
								<td width="20%">${leave.status}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>

</section>

<script type="text/javascript" src="../../../static/manager/common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['jquery','layer','element'],function(){
		window.jQuery = window.$ = layui.jquery;
		window.layer = layui.layer;
        window.element = layui.element();

       $('.panel .tools .iconpx-chevron-down').click(function(){
       	   var el = $(this).parents(".panel").children(".panel-body");
       	   if($(this).hasClass("iconpx-chevron-down")){
       	   	   $(this).removeClass("iconpx-chevron-down").addClass("iconpx-chevron-up");
       	   	   el.slideUp(200);
       	   }else{
       	   	   $(this).removeClass("iconpx-chevron-up").addClass("iconpx-chevron-down");
       	   	   el.slideDown(200);
       	   }
       })

	});
</script>
<script type="text/javascript" src="../../../static/manager/jsplug/echarts.min.js"></script>
<script type="text/javascript" src="../../../static/manager/js/main.js"></script>
<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	/*var myChart = echarts.init(document.getElementById('years'));

	// 指定图表的配置项和数据
	var option = {
		title: {
			text: '每天学习时间',
			subtext: '',
			x: 'center'
		},
		color: ['#3398DB'],
		tooltip: {
			trigger: 'axis',
			axisPointer: { // 坐标轴指示器，坐标轴触发有效
				type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		xAxis: [{
			type: 'category',
			data: ['一号', '二号', '三号', '四号', '五号', '六号', '七号', '八号', '九号', '十号', '十一号', '十二号','十三号','十四号','十五号','十六号','十七号','十八号','十九号','二十号','二十一号','二十二号','二十三号'],
			axisTick: {
				alignWithLabel: true
			},
			axisLabel: {
				interval:0,//代表显示所有x轴标签显示
				rotate:45,
			}
		}],
		yAxis: [{
			type: 'value'
		}],
		series: [{
			name: '活跃度',
			type: 'bar',
			barWidth: '60%',
			data: [10, 52, 200, 334, 390, 330, 220, 200, 334, 390, 330, 220,11,12,13,14,15,15,18,19,21,25,26]
		}]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);*/

    /*var myCharts = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '每日课程学习时间',
            subtext: '单位（分钟）',
            x: 'center'
        },
        tooltip: {
            trigger: 'axis'
        },
        /!*legend: {
            data:['车贷','房贷','信用贷']
        },*!/
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一','周二','周三','周四','周五','周六','周日']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name:'车贷',
                type:'line',
                stack: '总量',
                data:[120, 132, 101, 134, 90, 80, 60]
            },
            {
                name:'房贷',
                type:'line',
                stack: '总量',
                data:[110, 120, 150, 120, 100, 60, 90]
            },
            {
                name:'信用贷',
                type:'line',
                stack: '总量',
                data:[50, 120, 110, 86, 90, 70, 150]
            }
        ]
    };
    myCharts.setOption(option);*/
</script>
</body>
</html>