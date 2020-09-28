/*主页的js*/

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
/**
 * 退出系统
 */
function goSignOut() {
    window.location.href = "/pt/ptViewLogin";
}

/**
 * 修改Title
 */
function showContentTitle(obj) {
    $("#contentTitle").text($(obj).text());
}




