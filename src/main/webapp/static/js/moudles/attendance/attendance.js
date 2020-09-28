/*
出勤详情信息js*/
var cookies  =getCookie("cardId");

/**
 * 获取cookies
 * @param cname
 * @returns {string}
 */

function getCookie(name) {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; ");
    for(var i = 0; i < arrCookie.length; i++){
        var arr = arrCookie[i].split("=");
        if(name == arr[0]){
            return decodeURI(arr[1]);
        }
    }
    return "";
}

/*注册页面保存数据*/
$(function () {
});


/*后台保存*/
function submitAttendance(id) {
    var course = $("#course").val();//课程
    var teaCardId = $("#teaCardId").val();//授课老师的Id
    var content = $("#content").val();//上课内容
    if(course=="" || course==undefined || course==null){
        layer.msg("请输入科目！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(teaCardId=="" || teaCardId==undefined || teaCardId==null){
        layer.msg("请选择授课老师！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    var PostData = $("#attendanceForm").serializeObject();
    /*数据传输格式*/
    {
        PostData["course"] = course;
        PostData["teaCardId"] = teaCardId;
        PostData["content"] = content;
        PostData["id"] = id;
    }
    $.ajax({
        url:"/pt/attendance/saveAttendance",
        type:"POST",
        data:JSON.stringify(PostData),
        contentType: "application/json",
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            /*执行成功后的操作*/
            if(data.code=="10000"){
                layer.msg(data.result,{icon:1,shade:[0.4],time:2000},function () {
                  /*  history.back();
                    location.reload();*/
                  window.location.href=document.referrer;//返回上一个页面并刷新
                });
            }
            else if(data.code=="20000"){
                layer.msg(data.msg,{icon:2,shade:[0.4],time:2000});
                return false;
            }
        },
        error:function () {
            alert("保存失败！");
        }
    })
}

/**
 * 返回上一个页面
 */
function goBack() {
    history.back();
}


function selectAttenRecord() {
     var recorTime = $("#recorTime").val();
     var editStatus = $("#editStatus").val();
    window.location.href="/pt/attendance/viewAttendanceEdit?cardId="+cookies+"&recorTime="+recorTime+"&editStatus="+editStatus;
}

/**
 * 老师查看当天学生信息
 */
function teaSelectAttenRecord() {
    var leaveName = $("#leaveName").val();
    var recorStarTime = $("#recorStarTime").val();
    var recorEndTime = $("#recorEndTime").val();
    window.location.href="/pt/attendance/teaViewRecord?cardId="+cookies+"&leaveName="+leaveName+"&recordStarTime="+recorStarTime+"&recordEndTime="+recorEndTime;
}

function selectStuRecord() {
    var stuCardId = $("#stuCardId").val();
    var recorStarTime = $("#recorStarTime").val();
    var recorEndTime = $("#recorEndTime").val();

    window.location.href="/pt/attendance/teaViewAttendance?stuCardId="+stuCardId+"&teaCardId="+cookies+"&recordStarTime="+recorStarTime+"&recordEndTime="+recorEndTime;
}


