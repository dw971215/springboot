<%--
  Created by IntelliJ IDEA.
  User: 大卫
  Date: 2020/3/21
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>出勤信息</title>
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
    <script src="../../../static/js/moudles/attendance/attendance.js"></script>
</head>
<body class="childrenBody">
<form class="layui-form" id="attendanceForm">
    <div class="layui-form-item">
        <label class="layui-form-label">科目</label>
        <div class="layui-input-block">
            <input style="width: 199px" id="course" class="layui-input newsName" lay-verify="required" placeholder="请输入出勤学科" value="${attendanceVo.course}" <c:if test="${flag eq '1'}"> disabled="disabled"</c:if> type="text">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-inline">
                <input class="layui-input " style="font-size: 15px" value="<fmt:formatDate value="${attendanceVo.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" lay-verify="required" placeholder="" type="text" disabled="disabled">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-inline">
                <input class="layui-input " style="font-size: 15px" value="<fmt:formatDate value="${attendanceVo.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" lay-verify="required"  type="text" disabled="disabled">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">授课老师</label>
        <div class="layui-input-inline">
            <select name="interest-search" id="teaCardId" lay-filter="interest-search" <c:if test="${flag eq '1'}"> disabled="disabled"</c:if>lay-search>
                <option value="">请选择</option>
                <c:forEach items="${list}" var="leaveVo">
                    <option value="${leaveVo.approverCardId}" <c:if test="${attendanceVo.teaCardId eq leaveVo.approverCardId}">selected="selected" </c:if> >${leaveVo.approverName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上课记录</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" id="content" class="layui-textarea" style="width: 525px;height: 120px" <c:if test="${flag eq '1'}"> disabled="disabled"</c:if>>${attendanceVo.content}</textarea>
        </div>
    </div>
    <%--<div class="layui-form-item">
        <label class="layui-form-label">上课记录</label>
        <div class="layui-input-block">
            <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="news_content"></textarea>
            <div class="layui-layedit editfuwenben" >
                <div class="layui-unselect layui-layedit-tool">
                <i class="layui-icon layedit-tool-b" title="加粗" lay-command="Bold" layedit-event="b" "=""></i>
                <i class="layui-icon layedit-tool-i" title="斜体" lay-command="italic" layedit-event="i" "=""></i>
                <i class="layui-icon layedit-tool-u" title="下划线" lay-command="underline" layedit-event="u" "=""></i>
                <i class="layui-icon layedit-tool-d" title="删除线" lay-command="strikeThrough" layedit-event="d" "=""></i>
                <span class="layedit-tool-mid"></span><i class="layui-icon layedit-tool-left" title="左对齐" lay-command="justifyLeft" layedit-event="left" "=""></i>
                <i class="layui-icon layedit-tool-center" title="居中对齐" lay-command="justifyCenter" layedit-event="center" "=""></i>
                <i class="layui-icon layedit-tool-right" title="右对齐" lay-command="justifyRight" layedit-event="right" "=""></i>
                <span class="layedit-tool-mid"></span><i class="layui-icon layedit-tool-link" title="插入链接" layedit-event="link" "=""></i>
                <i class="layui-icon layedit-tool-unlink layui-disabled" title="清除链接" lay-command="unlink" layedit-event="unlink" "=""></i>
                <i class="layui-icon layedit-tool-face" title="表情" layedit-event="face" "=""></i>
                <i class="layui-icon layedit-tool-image" title="图片" layedit-event="image"><input name="file" type="file"></i></div>
                <div class="layui-layedit-iframe"><iframe id="LAY_layedit_1" name="LAY_layedit_1" textarea="news_content" style="height: 280px;" frameborder="0"></iframe></div>
            </div>
        </div>
    </div>--%>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn"  type="button" lay-submit="" onclick="submitAttendance(${attendanceVo.id})" <c:if test="${flag eq '1'}"> style="display: none" </c:if>>立即提交</button>
            <button type="reset" <c:if test="${flag eq '1'}"> style="display: none" </c:if>class="layui-btn layui-btn-primary">重置</button>
            <button type="button" class="layui-btn" onclick="goBack()">返回</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="../../../static/manager/common/layui/layui.js"></script>
<script type="text/javascript" src="../../../static/manager/js/newsadd.js"></script>
</body>
</html>
