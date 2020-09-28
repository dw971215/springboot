/*修改密码js*/

var cookies  =getCookie("cardId");
/*开始加载*/
$(function () {
    setCookie("name",getCookie("name"));
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
 * 设置Cookies
 * @param name
 * @param value
 * @constructor
 */
function setCookie (name, value) {
    //设置名称为name,值为value的Cookie
    var expdate = new Date();   //初始化时间
    expdate.setTime(expdate.getTime() + 30 * 60 * 1000);   //时间单位毫秒
    document.cookie = name + "=" + value + ";expires=" + expdate.toGMTString() + ";path=/";
}

/*保存个人信息*/
function changePassWord() {
    var cardId = $("#cardId").val();//账号
    var oldpwd = $("#oldpwd").val();//数据库中正确的旧密码
    var oldPassWord = $("#oldPassWord").val();//填写的旧密码
    var newPassWord = $("#newPassWord").val();//新密码
    var rePassWord = $("#rePassWord").val();//确认密码

    if(oldPassWord=="" || oldPassWord==undefined || oldPassWord==null){
        layer.msg("请输入旧密码！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(newPassWord=="" || newPassWord==undefined || newPassWord==null){
        layer.msg("请输入新密码！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(rePassWord=="" || rePassWord==undefined || rePassWord==null){
        layer.msg("请输入确认密码！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(oldpwd!=oldPassWord){
        layer.msg("旧密码输入错误！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(newPassWord!=rePassWord){
        layer.msg("两次输入密码不一样，请重新输入！",{icon:2,shade:[0.4],time:2000});
        return false;
    }

    var PostData = $("#changePwdForm").serializeObject();
    /*数据传输格式*/
    {
        PostData["cardId"] = cardId;
        PostData["pwd"] = newPassWord;
    }
    $.ajax({
        url:"/pt/member/updatePassWord",
        type:"POST",
        data:JSON.stringify(PostData),
        contentType: "application/json",
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            /*执行成功后的操作*/
            if(data.code == "10000"){
                layer.msg(data.result,{icon:1,shade:[0.4],time:2000},function () {
                    window.parent.document.location.href="/pt/index?cardId="+cardId;
                });
               /* var href =  $("#mainHome",window.parent.document).attr("href");*/

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


