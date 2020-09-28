<%--
  Created by IntelliJ IDEA.
  User: 大卫
  Date: 2020/3/19
  Time: 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" type="text/css" href="../../../static/manager/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="../../../static/manager/common/bootstrap/css/bootstrap.css" media="all">
    <link rel="stylesheet" type="text/css" href="../../../static/manager/common/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="../../../static/manager/css/personal.css" media="all">

    <script src="../../../static/commen/js/ajaxResponse.js?1=1"></script>
    <script src="../../../static/commen/layer/layer.js?1=1"></script>
    <script src="../../../static/js/jquery.min.js"></script>
    <script src="../../../static/commen/js/common.js?1=1"></script>
    <script src="../../../static/js/moudles/personInfo/personInfo.js"></script>
</head>
<body>
<section class="layui-larry-box">
    <div class="larry-personal">
        <header class="larry-personal-tit">
            <span>个人信息</span>
        </header><!-- /header -->
        <div class="larry-personal-body clearfix">
            <form class="layui-form col-lg-5" id="personInfoForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-block">
                        <input type="text" name="cardId" id="cardId"  autocomplete="off"  class="layui-input layui-disabled" value="${userVo.cardId}" disabled="disabled" >
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所属身份</label>
                    <div class="layui-input-block">
                           <select name="identity" id="identity" lay-filter="identity">
                               <option value=""></option>
                               <option value="0"<c:if test="${userVo.identity eq '0'}">selected="selected"</c:if>>学生</option>
                               <option value="1"<c:if test="${userVo.identity eq '1'}">selected="selected"</c:if>>老师</option>
                           </select>
                    </div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="uname" id="uname"  autocomplete="off" class="layui-input" value="${userVo.uname}" placeholder="请输入姓名">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-block">
                        <input type="text" name="phone" id="phone"  autocomplete="off" class="layui-input" value="${userVo.phone}" placeholder="请输入手机号码">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="radio" name="sex" value="0" title="男"<c:if test="${userVo.sex eq '0'}">checked="checked"</c:if>><%--<div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>男${userVo.sex}</span></div>--%><div style="float: left;position: absolute;left: 30px;top: 7px;font-size: 14px"><span>男</span></div>
                        <input type="radio" name="sex" value="1"  title="女" <c:if test="${userVo.sex eq '1'}">checked="checked"</c:if> ><%--<div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>女</span></div>--%><div style=" position:absolute;float: left;margin-left: 80px;margin-top: -27px;font-size: 14px"><span>女</span></div>
                    </div>
                </div>
                <%--<div class="layui-form-item">
                    <label class="layui-form-label">修改头像</label>
                    <div class="layui-input-block">
                        <input type="file" name="file" class="layui-upload-file">
                    </div>
                </div>--%>
               <%-- <div class="layui-form-item">
                    <label class="layui-form-label">界面语言</label>
                    <div class="layui-input-block">
                        <select name="interest" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0" selected="selected">中文</option>
                            <option value="1">英文</option>
                        </select>
                    </div>
                </div>--%>
                <div class="layui-form-item" id="classMess" <c:if test="${userVo.identity eq 1}"> style="display: none" </c:if>>
                    <label class="layui-form-label">所在班级</label>
                    <div class="layui-input-block">
                        <input type="text" name="classInfo" id="classInfo"  value="${userVo.classInfo}" autocomplete="off" class="layui-input" placeholder="请输入班级信息">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">座右铭</label>
                    <div class="layui-input-block">
                        <textarea id="motto" placeholder="既然选择了远方，便只顾风雨兼程；路漫漫其修远兮，吾将上下而求索" value="" class="layui-textarea">${userVo.motto}</textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" type="button" onclick="savePersonInfo()" <%--lay-filter="demo1"--%>>立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>

<script type="text/javascript" src="../../../static/manager/common/layui/layui.js"></script>
<script src="../../../static/other/layui/src/layui.js" charset="utf-8"></script>
<script type="text/javascript">
  /*  layui.use(['form','upload'],function(){
        var form = layui.form();
        layui.upload({
            url: '' ,//上传接口
            success: function(res){
                //上传成功后的回调
                console.log(res)
            }
        });
    });*/
  layui.use('form', function(){
      var form = layui.form;
      form.on('select(identity)', function(data){
          if(data.value==1){
              $("#classMess").css("display","none");
          }
          if(data.value==0){
              $("#classMess").css("display","");
          }
      });
  });

</script>
</body>
</html>
