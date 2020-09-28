/*
请假审核js*/
var cookies  =getCookie("cardId");

/*注册页面保存数据*/
$(function () {
});
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

/**
 * 查询请假人
 */
function selectStu() {
    var leaveName = $("#leaveName").val();
    window.location.href="/pt/leave/leaveManage?cardId="+cookies+"&leaveName="+leaveName;
}

/*审核通过*/
function verifyLeavePass(id) {
    var dateJson ="{\"id\":\""+id+"\"}";
    $.ajax({
        url:"/pt/leave/leavePass",
        type:"post",
        data:{'id':id},
        /*contentType: "application/json",*/
        dataType:"json",
        /*cache:"false",*/
        /*anync:"false",*/
        success:function (data) {
            /*执行成功后的操作*/
            if(data.code=="10000"){
                layer.msg(data.result,{icon:1,shade:[0.4],time:2000},function () {
                   /* window.parent.document.location.href = "/pt/index?cardId="+cookies;*/
                    window.location.reload();
                });

            }
            else if(data.code=="20000"){
                layer.msg(data.msg,{icon:2,shade:[0.4],time:2000});
                return false;
            }
        },
        error:function () {
            alert("操作失败！");
        }
    })
}


/*审核不通过*/
function verifyLeaveNoPass(id) {
    $.ajax({
        url:"/pt/leave/leaveNoPass",
        type:"post",
        data:{'id':id},
        /*contentType: "application/json",*/
        dataType:"json",
        /*cache:"false",*/
        /*anync:"false",*/
        success:function (data) {
            /*执行成功后的操作*/
            if(data.code=="10000"){
                layer.msg(data.result,{icon:1,shade:[0.4],time:2000},function () {
                   /* window.parent.document.location.href = "/pt/index?cardId="+cookies;*/
                    window.location.reload();
                });

            }
            else if(data.code=="20000"){
                layer.msg(data.msg,{icon:2,shade:[0.4],time:2000});
                return false;
            }
        },
        error:function () {
            alert("操作失败！");
        }
    })
}

function selectAenRecord() {
    var recorTime = $("#RecorTime").val();
    window.location.href="/pt/attendance/viewAttendance?cardId="+cookies+"&recorTime="+recorTime;
}


function selectTeaStu() {
    var recorTime = $("#RecorTime").val();
    var leaveName = $("#leaveName").val();
    window.location.href="/pt/leave/verifyRecord?cardId="+cookies+"&recorTime="+recorTime+"&leaveName="+leaveName;
}
