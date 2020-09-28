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

/**
 * 查询请假人
 */
function selectRecord() {
    var recorTime = $("#RecorTime").val();
    window.location.href="/pt/leave/leaveRecord?cardId="+cookies+"&RecorTime="+recorTime;
}



