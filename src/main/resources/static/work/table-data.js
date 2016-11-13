$('#table').bootstrapTable({
    url: '/bttable/dataByResp',
    columns: [{
        field: 'id',
        title: ' ID'
    }, {
        field: 'name',
        title: '产品名'
    }, {
        field: 'price',
        title: '价格'
    }
    ],
    pagination: true,//显示分页
    showRefresh: true,//显示刷新按钮
    showColumns: true,//显示勾选列显示按钮
    striped: true,  //表格显示条纹
    detailView: true,
    pageList: [10, 25, 50, 100, 'ALL'],
    showPaginationSwitch: true,
    minimumCountColumns: 2,
    cache: false,
    switchable: true,
    showExport: true,
    idField: 'id',
    uniqueId: "id",
    sidePagination: "server",
    exportDataType: "basic",
});
$('#table2').bootstrapTable({
    url: '/bttable/dataByResp',
    dataField: "rows",
    columns: [{
        field: 'id',
        title: ' ID'
    }, {
        field: 'name',
        title: '产品名'
    }, {
        field: 'price',
        title: '价格'
    }
    ],
    pagination: true,//显示分页
    showRefresh: true,//显示刷新按钮
    showColumns: true,//显示勾选列显示按钮
    striped: true,  //表格显示条纹
    detailView: true,
    pageList: [10, 25, 50, 100, 'ALL'],
    showPaginationSwitch: true,
    minimumCountColumns: 2,
    cache: false,
    switchable: true,
    showExport: true,
    idField: 'id',
    uniqueId: "id",
    sidePagination: "server",
    exportDataType: "basic",
});
$('#table3').bootstrapTable({
    url: '/bttable/dataByResp',
    columns: [{
        field: 'id',
        title: ' ID'
    }, {
        field: 'name',
        title: '产品名'
    }, {
        field: 'price',
        title: '价格'
    }
    ],
    pagination: true,//显示分页
    showRefresh: true,//显示刷新按钮
    showColumns: true,//显示勾选列显示按钮
    striped: true,  //表格显示条纹
    detailView: true,
    pageList: [10, 25, 50, 100, 'ALL'],
    showPaginationSwitch: true,
    minimumCountColumns: 2,
    cache: false,
    switchable: true,
    showExport: true,
    idField: 'id',
    uniqueId: "id",
    sidePagination: "server",
    exportDataType: "basic",
});
$('#table4').bootstrapTable({
    url: '/bttable/dataByResp',
    dataField: "rows",
    columns: [{
        field: 'id',
        title: ' ID'
    }, {
        field: 'name',
        title: '产品名'
    }, {
        field: 'price',
        title: '价格'
    }
    ],
    pagination: true,//显示分页
    showRefresh: true,//显示刷新按钮
    showColumns: true,//显示勾选列显示按钮
    striped: true,  //表格显示条纹
    detailView: true,
    pageList: [10, 25, 50, 100, 'ALL'],
    showPaginationSwitch: true,
    minimumCountColumns: 2,
    cache: false,
    switchable: true,
    showExport: true,
    idField: 'id',
    uniqueId: "id",
    sidePagination: "server",
    exportDataType: "basic",
});