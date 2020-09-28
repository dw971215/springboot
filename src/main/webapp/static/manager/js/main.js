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

/**
 *学生主页显示信息
 */
var myChartStu = echarts.init(document.getElementById('years'));

var myChartTea = echarts.init(document.getElementById('main'));

/**
 * 初始加载
 */
$(function () {
    /**
     * 学生端
     */
    $.ajax({
        url:"/pt/index/getStuWeekData",
        type:"POST",
        data:{"cardId":cookies},
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            var names =[];
            var nums =[];
            /!*执行成功后的操作*!/
            if(data.code=="10000"){
                $.each(data.result,function (key,values) {
                    names.push(values.timeWeek);
                    /*var obj = new Object();
                    obj.name = values;
                    obj.value = 1;*/
                    nums.push(values.timeCounts);
                });

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '近七天学习时间统计',
                        subtext: '单位（分钟）',
                        x: 'center'
                    },
                    color: ['#3398DB'],
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: { // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: [{
                        type: 'category',
                        data: names,
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLabel: {
                            interval:0//代表显示所有x轴标签显示
                        }
                    }],
                    yAxis: [{
                        type: 'value'
                    }],
                    series: [{
                        name: '今天学习时间',
                        type: 'bar',
                        barWidth: '60%',
                        data: nums
                    }]
                };
	            // 使用刚指定的配置项和数据显示图表。
                myChartStu.setOption(option);
            }
            else if(data.code=="20000"){}
        },
        error:function () {
            alert("保存失败！");
        }
    });

    /**
     * 教师端
     */
    $.ajax({
        url:"/pt/index/getTeaClassData",
        type:"POST",
        data:{"cardId":cookies},
        dataType:"json",
        cache:"false",
        anync:"false",
        success:function (data) {
            var names =[];
            var nums =[];
            /!*执行成功后的操作*!/
            if(data.code=="10000"){
                $.each(data.result,function (key,values) {
                    names.push(values.classInfo);
                    /*var obj = new Object();
                    obj.name = values;
                    obj.value = 1;*/
                    nums.push(values.counts);
                });

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '班级人数统计',
                        subtext: '单位（分钟）',
                        x: 'center'
                    },
                    color: ['#3398DB'],
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: { // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: [{
                        type: 'category',
                        data: names,
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLabel: {
                            interval:0//代表显示所有x轴标签显示
                        }
                    }],
                    yAxis: [{
                        type: 'value'
                    }],
                    series: [{
                        name: '班级人数',
                        type: 'bar',
                        barWidth: '60%',
                        data: nums
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChartTea.setOption(option);
            }
            else if(data.code=="20000"){}
        },
        error:function () {
            alert("保存失败！");
        }
    });
});

