/**
 * Created by WPJ587 on 2016/10/29.
 */
require([
    'jquery',
    'echarts',
    'echarts/theme/macarons',
    'echarts/chart/bar',
    'echarts/chart/line',
    'echarts/chart/pie',
    'echarts/component/legend',
    'echarts/component/tooltip',
    'echarts/component/toolbox',
    'echarts/chart/pie',
    'echarts/component/title',
    'echarts/component/markPoint',
    'echarts/component/markLine'
], function ($, echarts) {
//
//        // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'), 'macarons');
    var chart1 = echarts.init(document.getElementById("chart1"), 'macarons');
    var idData=[];
    var xData = [];
    var option;
    myChart.on("click", function (params) {
        setPie(params.name);
        console.log("params", xData.indexOf(params.name));

    });

    $.ajax({
        url: "/echart/data",
        dataType: "JSON",
        type: "GET",
        success: function (data) {
            console.log(data);

            var yData = [];
            $.each(data, function (a, b) {
                xData.push(b.name);
                yData.push(b.sale);
                idData.push(b.id);
            });
            option = {
                title: {
                    text: '考试人数'
                },
                tooltip: {
                    show: true,
                    trigger: 'axis'
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        dataView: {readOnly: false},
                        magicType: {type: ['line', 'bar']},
                        restore: {},
                        saveAsImage: {}
                    }
                },
                legend: {
                    data: ['参考人数']
                },
                xAxis: {
                    data: xData
                },
                yAxis: {
                    min: 10,
                    max: 100,
                    axisLabel: {
                        formatter: '{value}'
                    }
                },
                series: [
                    {
                        name: '参考人数',
                        type: 'bar',
                        data: yData,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均参考人数'},
                                [{
                                    symbol: 'none',
                                    x: '90%',
                                    yAxis: 'max'
                                },
                                    {
                                        symbol: 'circle',
                                        label: {
                                            normal: {
                                                position: 'middle',
                                                formatter: '最高参考人数'
                                            }
                                        },
                                        type: 'max',
                                        name: '最高'
                                    }]
                            ]
                        }
                    }
                ]
            };
            myChart.resize();
            myChart.setOption(option);
            console.log(xData.toString().indexOf());
            setPie(xData[0]);

        },
        error: function (err) {
            console.log(err);
        }
    })
    // 指定图表的配置项和数据

    function setPie(titleName) {
        $.ajax({
            url: "/echart/pie",
            dataType: "JSON",
            data: {type: titleName},
            type: "POST",
            success: function (data) {
                console.log(data);
                var xData = [];
                var legendData = [];
                $.each(data, function (a, b) {
                    console.log(a);
                    console.log(b);
                    xData.push({value: b, name: a});
                    legendData.push(a);

                });
                console.log(legendData);
                console.log(xData);
                var option = {
                    title: {
                        text: titleName + '成绩分布',
                        x: 'center'
                    },
                    toolbox: {
                        feature: {
                            myTool2: {
                                show: true,
                                title: '自定义扩展方法',
                                icon: 'image://http://echarts.baidu.com/images/favicon.png',
                                onclick: function () {
                                    alert('myToolHandler2')
                                }
                            },
                            saveAsImage: {},
                            restore: {}
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a}:{b} <br/>: {c} ({d}%){}"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: legendData
                    },
                    series: [
                        {
                            name: '成绩等级',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: xData,
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
                chart1.setOption(option, false);
                chart1.resize();
            },
            error: function (err) {
                console.log(err);
            }
        })

    }

    window.onresize = function () {
        chart1.resize();
        myChart.resize();
    }

});
