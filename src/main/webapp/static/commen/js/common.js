/**
 *  针对传入的url地址做个特殊处理
 *  因为后台请求过滤要求异步的请求必须.ajax结尾
 */
var dealAjaxUrl = function (url) {
    // 传入不合理url，直接抛出异常终止程序
    if (url == null || url == "" || typeof url != "string") {
        throw new error("参数url不是一个字符串地址");
    }

    // 参数开始部分的下标
    var paramStartIndex = url.indexOf("?");

    // url是否有.ajax后缀
    var isAjaxSuffix = true;

    // 判断url是否有参数部分的字符串，大于0表示有
    if (paramStartIndex > 0) {
        // 截取参数开始符?前面5个字符，判断url是否.ajax结尾
        isAjaxSuffix = url.substring(paramStartIndex - 5, paramStartIndex + 1) == ".ajax";

        if (isAjaxSuffix) {
            return url;
        } else {
            // 参数部分字符串
            var paramUrl = url.substring(paramStartIndex);

            // 除去参数部分的url
            var requestUrl = url.substring(0, url.indexOf("?"));

            return requestUrl + ".ajax" + paramUrl;
        }
    } else {
        // 这里表示url没有参数部分，判断url是否.ajax结尾
        return url.substring(url.length - 5, url.length) == ".ajax" ? url : url + ".ajax";
    }
};

/**
 *  处理下后台返回的ajax数据成为JSON对象
 */
var ajaxReturnDataDeal = function (data) {

    // 如果服务器端存在返回，就进来处理一下
    if (data) {
        // 如果服务器端返回的是json格式字符串，就进来转换一下
        if (typeof data == "string" ) {
            // 如果不是json格式字符串，表示普通字符串，就try-catch掉
            try{
                data = JSON.parse(data);
            }catch(e){
                console.error("服务器端返回的字符串格式不合法");
                console.error("我们要的格式： {\"key\": \"value\"} or int or bool");
                console.error("服务器返回的字符串：" + data);

                throw new Error("手动抛出异常，暂停程序执行");

            }
        }
    }
};

/**
 *  执行ajax
 */
var ajaxMain = function (method, url, contentType, isAsync, data, callBack) {
    $.ajax({
        type: method ? method : "POST",

        url: url,

        contentType : contentType ? contentType : 'application/json',

        async: isAsync ? isAsync : true,

        data: data ? JSON.stringify(data) : null,

        success: function (data) {
            // 处理下服务器返回的数据
            ajaxReturnDataDeal(data);

            // 存在回调函数，就执行
            callBack ? callBack(data) : false;
        }
    });
};

/**
 *  通用的ajax调用
 *  requestJson，ajax请求需要的相关信息，具体如下
 *
 *  method : 提交方式， 默认POST
 *  url : 请求地址，必须的
 *  contentType: 请求类型，默认 application/json
 *  data : 请求参数， 默认null
 *  callBack : 回调方法，传了就执行
 *  isAsync : 同步异步方式， 默认异步
 */
var sendAjaxRequest = function (requestJson) {
    // 提交方式
    var method = requestJson["method"];

    // 请求地址
    var url = ctx + dealAjaxUrl(requestJson["url"]);

    // 请求类型
    var contentType = requestJson["contentType"];

    // true : 异步， false : 同步
    var isAsync = requestJson["isAsync"];

    // 请求参数
    var data = requestJson["data"];

    // 回调函数
    var callBack = requestJson["callBack"];

    // 执行ajax请求
    ajaxMain(method, url, contentType, isAsync, data, callBack);
};


/**
 * 给template注册一个可调用的日期格式化方法
 */
var addTemplateDateMethod = function () {
    template.helper('dateFormat', function (date, format) {
        date = new Date(date);

        var map = {
            "M": date.getMonth() + 1, //月份
            "d": date.getDate(), //日
            "h": date.getHours(), //小时
            "m": date.getMinutes(), //分
            "s": date.getSeconds(), //秒
            "q": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds() //毫秒
        };

        format = format.replace(/([yMdhmsqS])+/g, function(all, t){
            var v = map[t];
            if(v !== undefined){
                if(all.length > 1){
                    v = '0' + v;
                    v = v.substr(v.length-2);
                }
                return v;
            }
            else if(t === 'y'){
                return (date.getFullYear() + '').substr(4 - all.length);
            }

            return all;
        });

        return format;
    });

};
/**
 * 给template注册一个可调用的日期格式化方法
 */
var formatDate = function (date, format) {
    date = new Date(date);

    var map = {
        "M": date.getMonth() + 1, //月份
        "d": date.getDate(), //日
        "h": date.getHours(), //小时
        "m": date.getMinutes(), //分
        "s": date.getSeconds(), //秒
        "q": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };

    format = format.replace(/([yMdhmsqS])+/g, function(all, t){
        var v = map[t];
        if(v !== undefined){
            if(all.length > 1){
                v = '0' + v;
                v = v.substr(v.length-2);
            }
            return v;
        }
        else if(t === 'y'){
            return (date.getFullYear() + '').substr(4 - all.length);
        }

        return all;
    });

    return format;
};
//
//
//$(function () {
//
//
//    /**
//     *  key-value参数提交后端
//     *  不需要@RequestBdoy
//     */
//    var urlParam = function () {
//        // ajax请求设置
//        var requestJson = {
//            url: "/apples/apple/url-param?remark=tongjian童剑&id=555",
//            data: {price: 44.3},
//            contentType: "text/html"
//        };
//
//        // 开始请求
//        sendAjaxRequest(requestJson);
//    };
//
//    /**
//     * 向数据库添加一条apple数据
//     */
//    var addApple = function () {
//        var appleJson = {
//            "id": Math.round(Math.random()*1000000000),
//            "price": Math.round(Math.random()*10).toFixed(2),
//            "remark": "new macbook pro " + Math.round(Math.random()*10)
//        };
//
//        // ajax请求设置
//        var requestJson = {
//            url: "/apples/apple/add",
//            data: appleJson,
//            callBack: addAppleCallBack
//        };
//
//        sendAjaxRequest(requestJson);
//    };
//
//    var updateApple = function () {
//        var appleJson = {
//            "id": $("#id").val(),
//            "price": $("#price").val(),
//            "remark": $("#remark").val()
//        };
//
//        // ajax请求设置
//        var requestJson = {
//            url: "/apples/apple/update",
//            data: appleJson,
//            callBack: updateAppleCallBack
//        };
//
//        sendAjaxRequest(requestJson);
//    }
//
//    var deleteApple = function (deleteBtnObj) {
//        var $siblings = $(deleteBtnObj).parent().siblings();
//
//        var appleJson = {
//            "id": $($siblings[0]).text()
//        };
//
//        // 作为体验，需要先删除页面响应的tr标签，因为服务器响应比较慢
//        // 服务器删除失败，刷新页面，这个也会回来
//        deleteAppleCallBack(appleJson);
//
//        // ajax请求设置
//        var requestJson = {
//            url: "/apples/apple/delete",
//            data: appleJson
//        };
//
//        sendAjaxRequest(requestJson);
//    }
//
//
//    var editApple = function (editBtnObj) {
//        var $siblings = $(editBtnObj).parent().siblings();
//
//        $("#id").val($($siblings[0]).text());
//        $("#price").val($($siblings[1]).text());
//        $("#remark").val($($siblings[2]).text());
//
//        $("#edit-area").show();
//    }
//
//
//    var  addAppleCallBack = function (data) {
//        // 如果后台返回的是json格式字符串，就转一下
//        data = data && typeof data == "string" ? JSON.parse(data) : data;
//
//        var appleInfo = "<tr>" +
//            "<td>id</td>" +
//            "<td>price</td>" +
//            "<td>remark</td>" +
//            "<td>" +
//            "<input type='button' id='edit-apple' value='修改苹果' />" +
//            "<input type='button' id='delete-apple' value='删除苹果' />" +
//            "</td>" +
//            "</tr>";
//
//        appleInfo = appleInfo.replace(/id/, data.id).replace(/price/, data.price.toFixed(2)).replace(/remark/, data.remark);
//
//        $("#apple-list").append($(appleInfo));
//    }
//
//    var updateAppleCallBack = function (data) {
//        // 如果后台返回的是json格式字符串，就转一下
//        data = data && typeof data == "string" ? JSON.parse(data) : data;
//
//        // 隐藏更新输入框区域
//        $("#edit-area").hide();
//        // 根据要更新的数据id获取相应显示数据的标签
//        var $appleInfo = $("td:contains(" + data.id +")").siblings();
//
//        // 更新价格标签内容
//        $($appleInfo[0]).text(data.price);
//
//        // 更新备注标签内容
//        $($appleInfo[1]).text(data.remark);
//    }
//
//
//    var deleteAppleCallBack = function (data) {
//        // 如果后台返回的是json格式字符串，就转一下
//        data = data && typeof data == "string" ? JSON.parse(data) : data;
//
//        // 根据id删除一个apple的tr数据
//        $("td:contains(" + data.id +")").parent().remove();
//    }
//
//
//    // 给添加apple按钮绑定单击事件
//    $("[id=add-apple]").click(function () {
//        addApple();
//    });
//
//    // 给更新apple按钮绑定单击事件
//    $("[id=update-apple]").click(function () {
//        updateApple();
//    });
//
//    // 测试url参数提交
//    $("[id=url-param]").click(function () {
//        urlParam();
//    });
//
//
//
//    // 更精确的小范围使用事件代理，性能优于.live()
//    $("#apple-list").delegate("[id=edit-apple]","click", function () {
//        editApple(this);
//    });
//
//    $("#apple-list").delegate("[id=delete-apple]","click", function () {
//        deleteApple(this);
//    });
//})

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push($.trim(this.value) || '');
        } else {
            o[this.name] = $.trim(this.value) || '';
        }
    });
    return o;
};

/* layer移动端弹出层
 * @param msg  提示信息
 * @param icon   1-错误 2-成功 3-提示警告
 * @param time  弹出框存在时间 如果为-1 可以维持弹出状态
 * @param f    弹出框关闭后函数
 * @param shade  是否需要遮罩 true-需要 false-不需要 默认为需要
 **/
function layerMobile(msg, icon, time, shade, f) {
    if (time == "" || time == undefined) {
        time = 2;
    }
    if (time == "-1") {
        time = 300;
    }

    if (typeof shade !== 'boolean') {
        shade = true;
    }

    // if (icon == "" || icon == undefined) {
    //     icon = 'background-color:#09C1FF; color:#fff; border:none;';
    // }
    // if (icon == "1") {// 错误
    //     icon = 'background-color:#FF0000; color:#fff; border:none;';
    // }
    // if (icon == "2") {// 成功
    //     icon = 'background-color:#35A57F; color:#fff; border:none;';
    // }
    // if (icon == "3") {// 提示
    //    icon = 'background-color:#FF7F24; color:#fff; border:none;';
    // }

    icon = 'background-color:#FFFFFF; color:#000000; border:none;';
    layer.open({
        content : msg,
        style:icon,
        time : time,
        shade : shade,
        end : f
    });

    
}

/* layer移动端弹出层
 * @param msg  提示信息
 * @param f  点击确定按钮后执行的函数
 */
function layerMobileConfirm(msg, f) {
    var time = 300;
    // var icon = 'background-color:#cc1d00; color:#fff; border:none;';
    var icon = 'background-color:#FFFFFF; color:#000000; border:none;';
    layer.open({
        content : msg,
        style : icon,
        time : time,
        shade : true,
        btn : [ '确定', '取消' ],
        yes : f,
        btn2 : function() {
            layer.closeAll();
        }
    });
}

/**数组根据数组对象中的某个属性值进行排序的方法
 * 使用例子：newArray.sort(sortBy('number',false)) //表示根据number属性降序排列;若第二个参数不传递，默认表示升序排序
 * @param attr 排序的属性 如number属性
 * @param rev true表示升序排列，false降序排序
 * */
function sortBy(attr,rev){
    //第二个参数没有传递 默认升序排列
    if(rev ==  undefined){
        rev = 1;
    }else{
        rev = (rev) ? 1 : -1;
    }

    return function(a,b){
        a = a[attr];
        b = b[attr];
        if(a < b){
            return rev * -1;
        }
        if(a > b){
            return rev * 1;
        }
        return 0;
    }
}

//快速排序
function quickSort(arr){
    //如果数组长度小于等于1无需判断直接返回即可
    if(arr.length<=1){
        return arr;
    }
    var midIndex=Math.floor(arr.length/2);//取基准点
    var midIndexVal=arr.splice(midIndex,1);//取基准点的值,splice(index,1)函数可以返回数组中被删除的那个数arr[index+1]
    var left=[];//存放比基准点小的数组
    var right=[];//存放比基准点大的数组
    //遍历数组，进行判断分配
    for(var i=0;i<arr.length;i++){
        if(Number(arr[i].rowNum)<Number(midIndexVal.rowNum)){
            left.push(arr[i]);//比基准点小的放在左边数组
        }
        else{
            right.push(arr[i]);//比基准点大的放在右边数组
        }
    }
    //递归执行以上操作,对左右两个数组进行操作，直到数组长度为<=1；
    return quickSort(left).concat(midIndexVal,quickSort(right));
}

//数组选择排序
function selectionSort(arr) {
    var len = arr.length;
    var minIndex, temp;
    for (var i = 0; i < len - 1; i++) {
        minIndex = i;
        for (var j = i + 1; j < len; j++) {
            if (arr[j].rowNum < arr[minIndex].rowNum) {     //寻找最小的数
                minIndex = j;                 //将最小数的索引保存
            }
        }
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
}

//对图片路径进行解码
function decodePicUrl(url) {
    var decodeStr=decodeURI(decodeURI(url));
    return decodeStr;
}


/**
 * 页面定时刷新
 * @param time 单位为分钟
 */
function timeRefresh(time) {
    var xIndex ;
    var yIndex ;
    var count = 0;
    var outTime=30; //默认30分钟无操作则刷新
    if (time != undefined && time != "" && time != null) {
        outTime=time;
    }
    //监听鼠标
    document.onmousemove = function (event) {
        var xMouse = event.clientX;
        var yMouse = event.clientY;
        if (xIndex != xMouse || yIndex != yMouse) {
            count = 0;  //鼠标移动,计数清0
        }
        xIndex = xMouse; //记录本次鼠标移动位置
        yIndex = yMouse;
    };
    //监听键盘
    document.onkeydown = function () {
        count = 0; //键盘按下,计数清0
    };

    window.setInterval(timeCount, 1000);
    function timeCount() {
        count++;
        if (count == outTime*60) {
            window.location.reload();
        }
    }
}