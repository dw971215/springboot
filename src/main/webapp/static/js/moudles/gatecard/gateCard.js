



/*
* @Author: Larry
* @Date:   2016-12-15 17:20:54
* @Last Modified by:   qinsh
* @Last Modified time: 2016-12-24 21:51:08
* +----------------------------------------------------------------------
* | LarryBlogCMS [ LarryCMS网站内容管理系统 ]
* | Copyright (c) 2016-2017 http://www.larrycms.com All rights reserved.
* | Licensed ( http://www.larrycms.com/licenses/ )
* | Author: qinshouwei <313492783@qq.com>
* +----------------------------------------------------------------------
*/

var cookies  =getCookie("cardId");

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
//===========================cookies信息结束=======================
/**
 * 每天课程统计
 */
var myChartDay = echarts.init(document.getElementById('larry-seo-day'));
/**
 * 月统计出勤次数
 */
var myChartMonth = echarts.init(document.getElementById('larry-seo-month'));
/**
 * 初始加载
 */
$(function () {
    $.ajax({
        url:"/pt/gateCard/getGateCard",
        type:"POST",
        data:{"stuCardId":cookies},
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            var names =[];
            var nums =[];
            /!*执行成功后的操作*!/
            if(data.code=="10000"){
                $.each(data.result,function (key,values) {
                    names.push(values);
                    var obj = new Object();
                    obj.name = values;
                    obj.value = 1;
                    nums.push(obj);
                });
                option={
                    title : {
                        text: '每天出勤科目统计',
                        subtext: '',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: names
                    },
                    series : [
                        {
                            name: '出勤课程',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:nums,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                myChartDay.setOption(option);
            }
            else if(data.code=="20000"){}
        },
        error:function () {
            alert("保存失败！");
        }
    });


    /**
     * 开始加载每月数据
     */
    $.ajax({
        url:"/pt/gateCard/getGateCardMonth",
        type:"POST",
        data:{"stuCardId":cookies},
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            var monthNames =[];
            var monthNums = [];
            /!*执行成功后的操作*!/
            if(data.code=="10000"){
                $.each(data.result,function (key,values) {
                    monthNames.push(values.courseName);
                    var obj = new Object();
                    obj.name = values.courseName;
                    obj.value =values.counts;
                    monthNums.push(obj);
                });
                option={
                    title : {
                        text: '每月科目出勤统计',
                        subtext: '单位：次数',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: monthNames
                    },
                    series : [
                        {
                            name: '出勤课程',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:monthNums,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                myChartMonth.setOption(option)
            }
            else if(data.code=="20000"){}

        },
        error:function () {
            alert("保存失败！");
        }
    });
});

/**
 * 给每天饼状图赋值
 */
function select() {
    var gateTime = $("#gateTime").val();
    $.ajax({
        url:"/pt/gateCard/getGateCard",
        type:"POST",
        data:{"gateTime":gateTime,"stuCardId":cookies},
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            var names =[];
            var nums = [];
            debugger
            /!*执行成功后的操作*!/
            if(data.code=="10000"){
                $.each(data.result,function (key,values) {
                    names.push(values);
                    var obj = new Object();
                    obj.name = values;
                    obj.value = 1;
                    nums.push(obj);

                })
                myChartDay.setOption({
                    legend:{
                        orient: 'vertical',
                        left: 'left',
                        data:names
                    },
                    series:[
                        {
                            name: '出勤课程',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:nums,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                })
            }
            else if(data.code=="20000"){}
        },
        error:function () {
            alert("保存失败！");
        }
    });
}

/**
 * 获取每月的考勤数据
 */
function getMonth() {
    var gateMonth = $("#gateMonth").val();
    $.ajax({
        url:"/pt/gateCard/getGateCardMonth",
        type:"POST",
        data:{"gateMonth":gateMonth,"stuCardId":cookies},
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            var monthNames =[];
            var monthNums = [];
            /!*执行成功后的操作*!/
            if(data.code=="10000"){
                $.each(data.result,function (key,values) {
                    monthNames.push(values.courseName);
                    var obj = new Object();
                    obj.name = values.courseName;
                    obj.value =values.counts;
                    monthNums.push(obj);
                });
                myChartMonth.setOption({
                    legend:{
                        orient: 'vertical',
                        left: 'left',
                        data:monthNames
                    },
                    series:[
                        {
                            name: '出勤课程',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:monthNums,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                })
            }
            else if(data.code=="20000"){}
        },
        error:function () {
            alert("保存失败！");
        }
    });
}
