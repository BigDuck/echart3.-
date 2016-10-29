/**
 * Created by WPJ587 on 2016/10/29.
 */
require([
    'jquery',
    'echarts',
    'vue',
    'echarts/chart/bar',
    'echarts/chart/line',
    'echarts/chart/pie',
    'echarts/component/legend',
    'echarts/component/tooltip',
    'echarts/component/toolbox',
    'echarts/chart/pie',
    'echarts/component/title',

], function ($, echarts,Vue) {
    var myChart;
    var chartBarLine
    // 初始化Vue
    function initVue() {
        chartBarLine =new Vue({
            el:"#vueMain",
            data:{
                isEdit:true,
                option:{}
            }
        });
    }
//       初始化echart
function initEchart() {
    myChart  = echarts.init(document.getElementById('main'));
    var chartsPie = echarts.init(document.getElementById("chart1"));
    var option;
    myChart.showLoading({
        text: "程序猿拼命加载中..."
    });

    $.ajax({
        url: "/echart/allData",
        dataType: "JSON",
        type: "GET",
        success: function (data) {
            myChart.hideLoading();
            console.log(data);
            var xData = [];
            var yData = [];
            var pieData = [];
            var tem1 = [];
            $.each(data, function (a, b) {
                xData.push(b.name);
                yData.push(b.sale);
                tem1.push(b.detail);
                var temp = [];
                $.each(b.detail, function (a, b) {
                    temp.push({
                        "value": b,
                        "name": a
                    });
                });
                pieData.push(temp);
            });
            option = {
                title: {
                    text: '考试人数'
                },
                tooltip: {
                    show: true,
                    trigger: 'axis'
                },
                legend: {
                    data: ['参考人数']
                },
                xAxis: {
                    data: xData
                },
                yAxis: {
                    min: 10,
                    max: 100
                },
                series: [
                    {
                        name: '参考人数',
                        type: 'bar',
                        data: yData
                    },
                    {
                        name: "那么",
                        type: 'pie',
                        roseType: 'area',
                        tooltip: {
                            trigger: 'item',
                            formatter:"{a} <br/>{b} : {c} ({d}%)"
                        }
                        ,
                        center: ['50%', '20%'],
                        radius: [10, 60],
                        data: pieData[0]

                    }
                ]
            };
            myChart.setOption(option, true);
            window.onresize=function () {
                console.log("调整");
                myChart.resize();
                chartsPie.resize();
            }
            myChart.on("click", function (params) {
                switch (params.name) {
                    case '入学考':
                        option.series[1].data = pieData[0];
                        option.series[1].name = pieData[0].name;
                        break;
                    case '期中考':
                        console.log('期中考')
                        option.series[1].data = pieData[1];
                        option.series[1].name = pieData[1].name;
                        ;
                        break;
                    case '月考':
                        console.log('月考');
                        option.series[1].data = pieData[2];
                        option.series[1].name = pieData[2].name;

                        break;
                    case '期末考':
                        console.log('期末考');
                        option.series[1].data = pieData[3];
                        option.series[1].name = pieData[3].name;

                        break;
                    case '结业考':
                        option.series[1].data = pieData[4];
                        option.series[1].name = pieData[4].name;
                        break;

                }
                myChart.setOption(option, true);
            });

        },
        error: function (err) {
            console.log(err);
        }
    });
}
      $(function () {
          initVue();
          initEchart();
      })

});
