/*个人信息的js*/

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
function savePersonInfo() {
    var cardId = $("#cardId").val();//账号
    var identity = $("#identity").val();//所属身份
    var uname = $("#uname").val();//真实姓名
    var phone = $("#phone").val();//手机号码
    var sex = $("input[name='sex']:checked").val();//获取性别的值
    var classInfo = $("#classInfo").val();//获取所在班级
    var motto = $("#motto").val();//座右铭
    if(identity=="" || identity==undefined || identity==null){
        layer.msg("请选择所属身份！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(uname=="" || uname==undefined || uname==null){
        layer.msg("请输入真实姓名！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(phone=="" || phone==undefined || phone==null){
        layer.msg("请输入手机号码！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    if(identity=="0"){
    if(classInfo=="" || classInfo==undefined || classInfo==null){
        layer.msg("请输入所在班级！",{icon:2,shade:[0.4],time:2000});
        return false;
    }
    }

    var PostData = $("#personInfoForm").serializeObject();
    /*数据传输格式*/
    {
        PostData["cardId"] = cardId;
        PostData["identity"] = identity;
        PostData["uname"] = uname;
        PostData["phone"] = phone;
        PostData["sex"] = sex;
        PostData["classInfo"] = classInfo;
        PostData["motto"] = motto;
    }
    $.ajax({
        url:"/pt/member/updatePersonInfo",
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
            alert("登录失败！");
        }
    })
}


