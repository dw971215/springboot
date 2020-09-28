/*
后台登录js*/


/*注册页面保存数据*/
$(function () {
});


/*后台登录验证*/
function PtloginSubmit() {
    var loginCardId = $("#loginCardId").val();//登录卡号
    var password = $("#password").val();//密码
    if(loginCardId=="" || loginCardId==undefined || loginCardId==null){
        layer.msg("请输入账号！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(password=="" || password==undefined || password==null){
        layer.msg("请输入密码！",{icon:2,shade:[0.4],time:2000});
        return false;
    }

    var PostData = $("#loginForm").serializeObject();
    /*数据传输格式*/
    {
        PostData["cardId"] = loginCardId;
        PostData["pwd"] = password;
    }
    $.ajax({
        url:"/pt/getLogin",
        type:"POST",
        data:JSON.stringify(PostData),
        contentType: "application/json",
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            /*执行成功后的操作*/
            if(data.code=="10000"){
                layer.msg(data.result,{icon:1,shade:[0.4],time:2000});
                window.location.href = "/pt/index?cardId="+loginCardId;
            }
            else if(data.code=="20000"){
                layer.msg(data.msg,{icon:2,shade:[0.4],time:2000});
                return false;
            }
        },
        error:function () {
            alert("登录失败！");
        }
    })
}


/**
 * 注册
 * @returns {boolean}
 */
function registerSubmit() {
    var loginCardId = $("#loginCardId").val();//登录卡号
    var password = $("#password").val();//密码
    if(loginCardId=="" || loginCardId==undefined || loginCardId==null){
        layer.msg("请输入账号！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(password=="" || password==undefined || password==null){
        layer.msg("请输入密码！",{icon:2,shade:[0.4],time:2000});
        return false;
    }

    var PostData = $("#loginForm").serializeObject();
    /*数据传输格式*/
    {
        PostData["cardId"] = loginCardId;
        PostData["pwd"] = password;
    }
    $.ajax({
        url:"/pt/saveRegister",
        type:"POST",
        data:JSON.stringify(PostData),
        contentType: "application/json",
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            /*执行成功后的操作*/
            if(data.code=="10000"){
                layer.msg(data.result,{icon:1,shade:[0.4],time:2000});
                window.location.href = "/pt/member/getPersoner?cardId="+loginCardId;//完善信息页面
            }
            else if(data.code=="20000"){
                layer.msg(data.msg,{icon:2,shade:[0.4],time:2000});
                return false;
            }
        },
        error:function () {
            alert("注册失败！");
        }
    })
}



