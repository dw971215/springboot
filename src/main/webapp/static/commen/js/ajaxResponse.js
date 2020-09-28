/**
 * 用于AJAX的post请求返回函数
 */

var ajaxPostCallback = function(url, params, callback) {
    if (typeof (params) == "undefined" || params == null) {
        params = "";
    }
    $.ajax({
        type : "post",
        url : url,
        contentType: "application/json; charset=utf-8",
        data : JSON.stringify(params),
        cache : false,
        timeout : 30000,
        async:false,
        success : callback
    });
};