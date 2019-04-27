$(".userTree").addClass("is-expanded");
$(".userList").addClass("active");

function passwordFormatter(value , row ,index) {
    return "修改密码";
}
function deptFormatter(value, row, index) {
    var url = "/dept/getDeptList";
    var callback = function (obj) {
        for (var i=0;i<obj.length;i++) {
            if ( value == obj[i].deptId) {
                return obj[i].deptName;
            }

        }
        return "未找到,请联系技术";
    };
    $.get(url, callback, "json");
}
function insertUser() {
    var url = "/user/insertUser";
    var data = $("#userForm").serialize();
    var callback = function (obj) {
        if (obj == "success") {
            alert("成功");

        } else if ( obj == "repeatUsername") {
            alert("用户姓名重复,请重新输入");
        } else if ( obj == "repeatLogName"){
            alert("账户名重复,请重新输入");
        } else {
            alert("系统错误,请联系技术人员");
        }
        $("#blogTable").bootstrapTable('refresh');
    }
    $.post(url, data, callback, "text");
}
function deleteDept() {
    var userId = $("#deleteDeptId").val();
    $.post("/user/deleteUser",{userId:userId},function (obj) {
        if (obj == "success") {
            alert("删除成功");
        } else if ( obj == "cannotDeleteYourself") {
            alert("不能删除自己");
        }  else if ( obj == "cannotDeleteAdmin") {
            alert("管理员账户不能删除");
        } else {
            alert("删除失败");
        }
        $("#blogTable").bootstrapTable('refresh');
    },"text");
}
function queryParams(params){
    return{
        //每页多少条数据
        rows: params.limit,
        //请求第几页
        page:params.pageNumber,
    }
}
function operateFormatter(value, row, index) {
    return [
        '<button type="button" class="ButtonB btn btn-danger btn-sm table-btn" style="margin-right:15px;">删除</button>'
    ].join('');
};
function showNameFormatter(value,row,index) {
    switch (value) {
        case 3 : return '经理';break;
        default:return '工作人员';break;
    }
}
function roleFormatter(value,row,index) {
    switch (value) {
        case 0 : return "工作人员";break;
        case 1 : return "技术人员";break;
        case 2 : return "主管";break;
    }
}
function showNameFormatter2(value,row,index) {
    var showNameUrl = "/user/getNameById";
    var showNameCallback = function (obj) {
        return obj;
    }
    $.get(showNameUrl, {userId: value}, showNameCallback, "text");
}

function showStatusFormatter(value,row,index) {
    switch (value) {
        case 0 : return '未处理';break;
        case 1 : return '处理中';break;
        case 2 : return '已处理';break;
        default:return 'error';break;
    }
}

window.operateEvents = {
    'click .ButtonB': function (e, value, row, index) {
        $("#deleteDeptId").val(row.userId);
        $("#deleteModal").modal('show');
    }
};
$(function(){
    // excel 生成
    $("#saveBtn").click(function () {
        var url="/user/generatorExcel";
        window.open(url);
    });

    $("#myModal").modal("hide");
    $('#blogTable').bootstrapTable('destroy').bootstrapTable({
        url: '/user/getUserList',   //url一般是请求后台的url地址,调用ajax获取数据。此处我用本地的json数据来填充表格。
        method: "get",                     //使用get请求到服务器获取数据
        dataType: "json",
        contentType: 'application/json,charset=utf-8',
        toolbar: "#toolbar",                //一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
        uniqueId: "id",                    //每一行的唯一标识，一般为主键列
        height: document.body.clientHeight-165,   //动态获取高度值，可以使表格自适应页面
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
        pageSize: 10,                    //每页的记录行数（*）
        pageList: [10, 20],     //可供选择的每页的行数（*）
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        paginationFirstText: "首页",
        paginationLastText: "尾页",
        //     responseHandler: responseHandler,
        columns: [{
            field: 'userId',
            title: 'id'
        },{
            field: 'userLogname',
            title: '账户名',
            editable: {
                type: 'text',
                title: '账户名',
                validate: function (v) {
                    if (!v) return '账户名不能为空';
                }
            }
        },{
            field: 'userPassword',
            title: '密码',
            formatter:passwordFormatter,
            editable: {
                type: 'text',
                title: '密码',
                validate: function (v) {
                    if (!v) return '密码不能为空';
                },
                placeholder: ""
            }
        },{
            field: 'userUsername',
            title: '用户名',
            editable: {
                type: 'text',
                title: '用户名',
                validate: function (v) {
                    if (!v) return '用户名不能为空';

                }
            }
        },{
            field: 'userRole',
            title: '身份',
            //             formatter: roleFormatter,
            editable: {
                type: 'select',
                title: '身份',
                source:[{value:"0",text:"工作人员"},{value:"1",text:"主管"},{value:"2",text:"技术人员"}]
            }
        },{
            field: 'deptId',
            title: '部门',
            // formatter: deptFormatter,
            editable: {
                type: 'select',
                title: '部门',
                source: function () {
                    var result = [];
                    $.ajax({
                        url: '/dept/getDeptList',
                        async: false,
                        type: "get",
                        data: {},
                        success: function (data) {
                            $.each(data, function (key, value) {
                                result.push({ value: value.deptId, text: value.deptName });
                            });
                        }
                    });
                    return result;
                }
            }
        },{
            field: 'operate',
            title: '操作',
            width: '80px',
            events: operateEvents,
            formatter: operateFormatter
        }, ],
        onLoadSuccess: function (data) { //加载成功时执行
        },
        onLoadError: function (res) { //加载失败时执行
        },onEditableSave: function (field, row, oldValue, $el) {
            $.ajax({
                type: "post",
                url: "/user/updateUser",
                data: row,
                dataType: 'text',
                success: function (obj) {
                    if (obj == "success") {
                        alert('提交数据成功');
                    } else if (obj=="repeatUsername"){
                        alert("用户姓名已存在");
                    } else {
                        alert("系统错误,请联系技术人员");
                    }
                    $("#blogTable").bootstrapTable('refresh');
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
    $("#deptId").empty()
    var url = "/dept/getDeptList";
    var callback = function (obj) {
        for (var i=0;i<obj.length;i++) {
            $("#deptId").append("<option value='"+obj[i].deptId+"'>"+obj[i].deptName+"</option>")
        }
    };
    $.get(url, callback, "json");
    $("#myModal").modal('show');
})