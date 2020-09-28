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
    <!-- overview -->
	<%--<div class="row state-overview">
		<div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
			<section class="panel">
				<div class="symbol userblue layui-anim layui-anim-rotate"> <i class="iconpx-users"></i>
				</div>
				<div class="value">
					<a href="#">
						<h1 id="count1">10</h1>
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
						<h1 id="count2">1</h1>
					</a>
					<p>今日注册用户</p>
				</div>
			</section>
		</div>
		<div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
			<section class="panel">
				<div class="symbol articlegreen layui-anim layui-anim-rotate">
					<i class="iconpx-file-word-o"></i>
				</div>
				<div class="value">
					<a href="#">
						<h1 id="count3">50</h1>
					</a>
					<p>文章总数</p>
				</div>
			</section>
		</div>
		<div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
			<section class="panel">
				<div class="symbol rsswet layui-anim layui-anim-rotate">
					<i class="iconpx-check-circle"></i>
				</div>
				<div class="value">
					<a href="#">
						<h1 id="count4">0</h1>
					</a>
					<p>待审文章总数</p>
				</div>
			</section>
		</div>
	</div>--%>
	<!-- overview end -->
    <div class="layui-inline">
        <div class="layui-input-inline">
            <input class="layui-input gateTime" id="gateTime"  type="text" autocomplete="off">
        </div>
        <a class="layui-btn search_btn" onclick="select()">查询</a>
    </div>
    <div class="layui-inline">
    <div class="layui-input-inline">
        <select name="interest-search" id="gateMonth" lay-filter="interest-search" style="margin-left: 440px;font-family: '宋体'; width: 140px; height: 38px;">
            <option value="">请选择</option>
            <option value="1">1月</option>
            <option value="2">2月</option>
            <option value="3">3月</option>
            <option value="4">4月</option>
            <option value="5">5月</option>
            <option value="6">6月</option>
            <option value="7">7月</option>
            <option value="8">8月</option>
            <option value="9">9月</option>
            <option value="10">10月</option>
            <option value="11">11月</option>
            <option value="12">12月</option>
        </select>
    </div>
    <a class="layui-btn search_btn" onclick="getMonth()">查询</a>
    </div>
	<div class="row">
		<div class="col-lg-6">
			<%--<section class="panel">
				<header class="panel-heading bm0">
					<span class='span-title'>系统概览</span>
					<span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
				</header>
				<div class="panel-body" >
					<table class="table table-hover personal-task">
                         <tbody>
                         	<tr>
                         		<td>
                         			<strong>版本信息</strong>： 版本名称：<a href="http://www.larrycms.com">LarryCMS</a> 版本号: V01_UTF8_0.10

                         		</td>
                         		<td>

                         		</td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>开发作者</strong>： Larry

                                </td>
                                <td></td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>网站域名</strong>：未定义
                                </td>
                                <td></td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>网站目录</strong>：未定义
                                </td>
                                <td></td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>服务器IP</strong>：未定义
                                </td>
                                <td></td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>服务器环境</strong>：未定义
                                </td>
                                <td></td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>数据库版本</strong>： 未定义

                                </td>
                                <td></td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>最大上传限制</strong>： 未定义

                                </td>
                                <td></td>
                         	</tr>
                         	<tr>
                         		<td>
                                <strong>当前登录用户</strong>： <span class="current_user">未定义</span>

                                </td>
                                <td></td>
                         	</tr>
                         </tbody>
					</table>
				</div>
			</section>--%>
      <!-- 网站信息统计｛SEO数据统计｝ -->
                <%--<div class="layui-inline">
                    <div class="layui-input-inline">
                        <input class="layui-input newsTime" id="startTime" lay-verify="required|date" onClick="layui.laydate({elem:this})" type="text">
                    </div>

                </div>--%>

      <section class="panel" >
                  <header class="panel-heading bm0">
                       <span class='span-title'>每天上课科目统计</span>
                       <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body laery-seo-box">
                        <div class="larry-seo-stats" id="larry-seo-day"></div>
                  </div>
      </section>
		</div>
        <div class="col-lg-6">
            <section class="panel">
                <header class="panel-heading bm0">
                    <span class='span-title'>每月考勤信息统计</span>
                    <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                </header>
                <div class="panel-body laery-seo-box">
                    <div class="larry-seo-stats" id="larry-seo-month"></div>
                </div>
            </section>
        </div>
		<%--<div class="col-lg-6">
		     <!-- 快捷操作 -->
             <section class="panel">
                  <header class="panel-heading bm0">
                        <span class='span-title'>快捷操作</span>
                        <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body">
                        <table class="table table-hover personal-task shortcut">
                            <tr>
                            	<td>
                            		<div class="c1">1</div>
                            		<div class="c2">2</div>
                            		<br>
                            	</td>
                            </tr>
                        </table>
                  </div>
             </section>
          <!-- 系统公告 -->
             <section class="panel">
                 <header class="panel-heading bm0">
                        <span class='span-title'>系统公告</span>
                        <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body">
                        <table class="table table-hover personal-task shortcut">
                            <tr>
                              <td>
                                <div class="c1">1</div>
                                <div class="c2">2</div>
                                <br>
                              </td>
                            </tr>
                        </table>
                  </div>
             </section>

              <!-- 最新文章 -->
             <section class="panel">
                  <header class="panel-heading bm0">
                        <span class='span-title'>最新文章</span>
                        <span class="badge" style="background-color:#FF3333;"> new </span>
                        <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body">
                       <table class="table table-hover personal-task">
                             <tbody>
                              <tr>
                                <td>原创</td>
                                <td>
                                  <a href="#" target="_blank">汪涵率众特工入侵地球 20160408</a>
                                </td>
                                <td class="col-md-5">阅读量：1350 &nbsp;&nbsp;&nbsp;&nbsp; 2016-04-11</td>
                              </tr>
                              <tr>
                                <td>原创</td>
                                <td>
                                  <a href="#" target="_blank">汪涵率众特工入侵地球 20160408</a>
                                </td>
                                <td class="col-md-5">阅读量：1350 &nbsp;&nbsp;&nbsp;&nbsp; 2016-04-11</td>
                              </tr>
                              <tr>
                                <td>原创</td>
                                <td>
                                  <a href="#" target="_blank">汪涵率众特工入侵地球 20160408</a>
                                </td>
                                <td class="col-md-5">阅读量：1350 &nbsp;&nbsp;&nbsp;&nbsp; 2016-04-11</td>
                              </tr>
                              <tr>
                                <td>原创</td>
                                <td>
                                  <a href="#" target="_blank">汪涵率众特工入侵地球 20160408</a>
                                </td>
                                <td class="col-md-5">阅读量：1350 &nbsp;&nbsp;&nbsp;&nbsp; 2016-04-11</td>
                              </tr>
                              <tr>
                                <td>原创</td>
                                <td>
                                  <a href="#" target="_blank">汪涵率众特工入侵地球 20160408</a>
                                </td>
                                <td class="col-md-5">阅读量：1350 &nbsp;&nbsp;&nbsp;&nbsp; 2016-04-11</td>
                              </tr>
                             </tbody>
                       </table>
                  </div>
             </section>
		</div>--%>
	</div>

</section>

<script type="text/javascript" src="../../../static/manager/common/layui/layui.js"></script>
<script type="text/javascript" src="../../../static/manager/js/newsadd.js"></script>
<script src="../../../static/other/layui/src/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#gateTime' //指定元素
            , type: 'date'
            , theme: 'molv'
            //,range: true
            , trigger: 'click'
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
<script type="text/javascript" src="../../../static/js/moudles/gatecard/gateCard.js"></script>
</body>
</html>