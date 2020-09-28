/*
请假申请js*/


/*注册页面保存数据*/
$(function () {
});


/*后台保存请假信息*/
function leaveSubmit() {
    var cardId = $("#cardId").val();//请假人账号
    var leaveName = $("#leaveName").val();
    var startTime = $("#startTime").val();//请假开始时间
    var endTime = $("#endTime").val();//请假结束时间
    var approverCardId = $("#approverCardId").val();//审批者cardId
    var reason = $("#reason").val();//请假理由
    if(startTime=="" || startTime==undefined || startTime==null){
        layer.msg("请选择开始时间！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(endTime=="" || endTime==undefined || endTime==null){
        layer.msg("请选择结束时间！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(approverCardId=="" || approverCardId==undefined || approverCardId==null){
        layer.msg("请选择审批者！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(reason=="" || reason==undefined || reason==null){
        layer.msg("请输入请假理由！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    var PostData = $("#leaveForm").serializeObject();
    /*数据传输格式*/
    {
        PostData["applyCardId"] = cardId;
        PostData["leaveName"] = leaveName;
        PostData["stuStarTime"] = startTime;
        PostData["stuEndTime"] = endTime;
        PostData["approverCardId"] = approverCardId;
        PostData["reason"] = reason;
    }
    $.ajax({
        url:"/pt/leave/saveLeaveManager",
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
                    window.parent.document.location.href = "/pt/index?cardId="+cardId;
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




