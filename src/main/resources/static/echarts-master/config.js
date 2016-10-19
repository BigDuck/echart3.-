/**
 * Created by WPJ587 on 2016/10/20.
 */
require.config({
    packages: [
        {
            name: 'zrender',
            location: '/zrender/src', // zrender与echarts在同一级目录
            main: 'zrender'
        },
        {
            name: 'echarts',
            location: '/echarts-master/src',
            main: 'echarts'
        }
    ]
    // urlArgs: '_v_=' + +new Date()
});
