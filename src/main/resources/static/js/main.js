/**
 * Created by WPJ587 on 2016/10/20.
 */

require.config({
    baseUrl:"/js",
    paths: {
      "jquery":"jquery",

    },
        // ,
    packages: [
        {
            name: 'zrender',
            location: 'zrender/src', // zrender与echarts在同一级目录
            main: 'zrender'
        },
        {
            name: 'echarts',
            location: 'echarts/src',
            main: 'echarts'
        },
        {
            name:'jquery',
            location:'/js',
            main:"jquery"
        }
    ]
});
