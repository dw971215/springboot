<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" type="text/css" href="../../../static/manager/css/personal.css">
    <script src="../../../static/commen/js/ajaxResponse.js?1=1"></script>
    <script src="../../../static/commen/layer/layer.js?1=1"></script>
    <script src="../../../static/commen/js/jquery-3.4.1.min.js"></script>
    <script src="../../../static/commen/js/common.js?1=1"></script>
</head>
<body>
<section class="larry-wrapper">

    <div class="layui-inline">
        <div class="layui-input-inline">
            <input class="layui-input gateTime" id="teaGateTime" lay-verify="required|date" onClick="layui.laydate({elem:this})" type="text" autocomplete="off">
        </div>
        <a class="layui-btn search_btn" onclick="teaSelect()">查询</a>
    </div>

	<div class="row">
		<div class="col-lg-6">
      <section class="panel" >
                  <header class="panel-heading bm0">
                       <span class='span-title'>每天上课科目人数统计</span>
                       <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body laery-seo-box">
                        <div class="larry-seo-stats" id="larry-seo-teaday"></div>
                  </div>
      </section>
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
            elem: '#teaGateTime' //指定元素
            ,type: 'date'
            ,theme: 'molv'
            //,range: true
            ,trigger: 'click'
        });
    });
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
<script type="text/javascript" src="../../../static/js/moudles/gateteacard/gateTeaCard.js"></script>
</body>
</html>