$(".attractionTree").addClass("is-expanded");
$(".attractionList").addClass("active");

function insertUser() {
    var url = "/dept/insertDept";
    var data = $("#userForm").serialize();
    var callback = function (obj) {
        if (obj == "success") {
            alert("成功");
            $("#bootstrapTable").bootstrapTable('refresh');
        }
    }
    $.post(url, data, callback, "text");
}

function queryParams(params) {
    return {
        //每页多少条数据
        rows: params.limit,
        //请求第几页
        page: params.pageNumber,
    }
}

function operateFormatter(value, row, index) {
    return [
        '<button type="button" class="ButtonB btn btn-danger btn-sm table-btn" style="margin-right:15px;">删除</button>'
    ].join('');
};

function showStatusFormatter(value, row, index) {
    switch (value) {
        case 0 :
            return '未处理';
            break;
        case 1 :
            return '处理中';
            break;
        case 2 :
            return '已处理';
            break;
        default:
            return 'error';
            break;
    }
}

function deleteFun() {
    var id = $("#id").val();
    $.post("/admin/attraction/deleteAttraction", {id: id}, function (obj) {
        if (obj.code==='200') {
            alert("删除成功");
        }
        $("#bootstrapTable").bootstrapTable('refresh');
    }, "text");
}

window.operateEvents = {
    'click .ButtonB': function (e, value, row, index) {
        $("#id").val(row.id);
        $("#deleteModal").modal('show');
    }
};
$(function () {
    $('#bootstrapTable').bootstrapTable('destroy').bootstrapTable({
        url: '/admin/attraction/list',   //url一般是请求后台的url地址,调用ajax获取数据。此处我用本地的json数据来填充表格。
        method: "get",                     //使用get请求到服务器获取数据
        dataType: "json",
        contentType: 'application/json,charset=utf-8',
        singleSelect: true,
        toolbar: "#toolbar",                //一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
        uniqueId: "id",                    //每一行的唯一标识，一般为主键列
        height: document.body.clientHeight - 165,   //动态获取高度值，可以使表格自适应页面
        cache: false,                       // 不缓存
        striped: true,                      // 隔行加亮
        //设置为"undefined",可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为"limit",符合 RESTFul 格式的参数,可以获取limit, offset, search, sort, order
        //设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
        queryParamsType: '',
        //queryParams: queryParams,
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        // sortable: true,                     //是否启用排序;意味着整个表格都会排序
        sortName: 'uid',                    // 设置默认排序为 name
        sortOrder: "asc",                   //排序方式
        pagination: true,                   //是否显示分页（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: false,                  //是否显示所有的列
        //    showRefresh: true,                  //是否显示刷新按钮
        //    showToggle:true,                    //是否显示详细视图和列表视图
        clickToSelect: true,                //是否启用点击选中行
        minimumCountColumns: 2,          //最少允许的列数 clickToSelect: true, //是否启用点击选中行
        pageNumber: 1,                   //初始化加载第一页，默认第一页
        pageSize: 5,                    //每页的记录行数（*）
        pageList: [5, 10, 20],     //可供选择的每页的行数（*）
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        paginationFirstText: "首页",
        paginationLastText: "尾页",
        //     responseHandler: responseHandler,
        columns: [{
            checkbox: true,
        }, {
            field: 'id',
            title: 'id'
        }, {
            field: 'attractionName',
            title: '名称',
        }, {
            field: 'attractionPrice',
            title: '票价',
        }, {
            field: 'attractionStar',
            title: '星级',
        }, {
            field: 'operate',
            title: '操作',
            width: '80px',
            events: operateEvents,
            formatter: operateFormatter
        },],
        onLoadSuccess: function (data) { //加载成功时执行
        },
        onLoadError: function (res) { //加载失败时执行
        }, onEditableSave: function (field, row, oldValue, $el) {
            $.ajax({
                type: "post",
                url: "/dept/updateDept",
                data: row,
                dataType: 'text',
                success: function (obj) {
                    if (obj == "success") {
                        alert('提交数据成功');
                        $("#bootstrapTable").bootstrapTable('refresh');
                    }
                },
                error: function () {
                    alert('编辑失败');
                },
                complete: function () {
                }
            });
        }
    });
});

$("#btn_add").click(function () {
    location.href = "/admin/attraction/addPage";
});
$("#btn_edit").click(function () {
    var row = $('#bootstrapTable').bootstrapTable('getSelections');
    if (row.length === 1) {
        location.href = "/admin/attraction/editPage?id=" + row[0].id;
    }
    else {
        alert("请选中一行")
    }
});