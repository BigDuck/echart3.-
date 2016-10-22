define(function (require) {

    require('../coord/single.vm/singleCreator');
    require('./axis/SingleAxisView');
    require('../coord/single.vm/AxisModel');

    var echarts = require('../echarts');

    echarts.extendComponentView({
        type: 'single.vm'
    });

});