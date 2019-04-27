$(".bugTree").addClass("is-expanded");
$(".bugList").addClass("active");

function deleteDept() {
    var feedbackId = $("#deleteDeptId").val();
    $.post("/feedback/deleteFeedback",{feedbackId:feedbackId},function (obj) {
        if (obj == "success") {
            alert("删除成功");
        }  else {
            alert("删除失败");
        }
        $("#blogTable").bootstrapTable('refresh');
    },"text");
}
function queryParams(params) {
    return {
        //每页多少条数据
        rows: params.limit,
        //请求第几页
        page: params.pageNumber,
    }
}
function titleFormatter(value,row,index) {
    var userInfo = $("#userInfo").val()
    if ( userInfo == 1 ) {
        if (row.feedbackDone != 2 ) {
            return [
                '<button type="button" class="ButtonF btn btn-link btn-sm table-btn" style="margin-right:15px;">'+value+'</button>'
            ].join('');
        }
    }
    return "<span style='margin-left:10px;'>"+value+"</span>" ;
}

function operateFormatter(value, row, index) {
    var userInfo = $("#userInfo").val();
    // userInfo 0-普通用户 1-主管 2-程序员
    // row.feedbackDone == 0:未处理 1:处理中 2:处理完毕 3:管理员最终回复 4:工作人员最终回复

    // 如果用户身份是 主管
    if (userInfo == 1) {
        // 如果反馈状态 处理完毕,则可以删除此反馈
        if (row.feedbackDone == 2 ) {
            return [
                '<button type="button" class="ButtonD btn btn-danger btn-sm table-btn" style="margin-right:15px;">删除提交</button>'
            ].join('');

            // 如果反馈状态 未处理
        } else if ( row.feedbackDone == 0){
            return [
                '<button type="button" class="ButtonA btn btn-info btn-sm table-btn" style="margin-right:15px;">开始</button>'
            ].join('');

            // 如果反馈状态 处理中 || 沟通中
        } else if (row.feedbackDone != 0 && row.feedbackDone != 2) {
            return [
                '<button type="button" class="ButtonB btn btn-success btn-sm table-btn" style="margin-right:15px;">完成</button>'
            ].join('');
        }
    }

    // 工作人员
    if (userInfo == 0 ) {
        // 如果任务未处理 而且 用户角色是普通角色
        if (row.feedbackDone == 0) {
            return [
                '<button type="button" class="ButtonE btn btn-danger btn-sm table-btn" style="margin-right:15px;">撤消提交</button>'
            ].join('');
        }
        if (row.feedbackDone != 0 && row.feedbackDone != 2) {
            return "<span class='greenClass'>正在处理</span>";
        }

    }
    if (row.feedbackDone == 2 ){
        return "处理完毕";
    }
    if (row.feedbackDone != 0 && row.feedbackDone != 2 && userInfo != 0) {
        return [
            '<button type="button" class="ButtonB btn btn-success btn-sm table-btn" style="margin-right:15px;">完成</button>'
        ].join('');
    }
    if (row.feedbackDone == 0 ) {
        return [
            '<button type="button" class="ButtonA btn btn-info btn-sm table-btn" style="margin-right:15px;">开始</button>'
        ].join('');
    }
    return [
        '<button type="button" class="ButtonA btn btn-info btn-sm table-btn" style="margin-right:15px;">开始</button>',
        '<button type="button" class="ButtonB btn btn-success btn-sm table-btn" style="margin-right:15px;">完成</button>'
    ].join('');
};

function articleUrlFormatter(value,row,index) {
    return [
        '<button type="button" class="ButtonC btn btn-info btn-sm table-btn" style="margin-right:15px;">查看</button>',
    ].join('');
}
function showNameFormatter(value,row,index) {
    switch (value) {
        case 3 : return '经理';break;
        default:return '工作人员';break;
    }
}
function showNameFormatter2(value,row,index) {
    var url = "/user/getNameById";
    var callback = function (obj) {
        if (obj .length > 1) {
            return obj + "";
        }
        return "请联系技术";
    };
    $.get(url,{userId:row.userId} ,callback, "text");
}
function sleep() {

}
function dateFormatter(value,row,index) {
    var temp = new String(value);
    if (temp.length < 5) {
        return "--";
    }
    var str1 = temp.substring(0,10);
    var str2 = temp.substring(10,temp.length);
    return str1 + "<br>" +str2;
}
function showNameFormatter2(value,row,index) {
    var showNameUrl = "/user/getNameById";
    var showNameCallback = function (obj) {
        return obj;
    }
    $.get(showNameUrl, {userId: value}, showNameCallback, "text");
}

function showStatusFormatter(value,row,index) {
    var userInfo = $("#userInfo").val();
    switch (value) {
        case 0 : return '<span>未处理</span>';break;
        case 1 : return '<span class="greenClass">处理中</span>';break;
        case 2 : return '<span>已处理</span>';break;
        case 3 :
            if ( userInfo == 0 ) {
                return '<span class="redClass">等待沟通</span>';
                break;
            } else {
                return '<span class="greenClass">等待沟通</span>'
                break;
            }
        case 4 :
            if ( userInfo == 0 ) {
                return '<span class="greenClass">等待沟通</span>';
                break;
            } else {
                return '<span class="redClass">等待沟通</span>'
                break;
            }
        default:return 'error';break;
    }
}

window.operateEvents = {
    'click .ButtonA': function (e, value, row, index) {
        var url = "/feedback/beginTask";
        var callback = function(obj) {
            if (obj == "success") {
                alert("成功");
            } else if ( obj == "noPower") {
                alert("您无权限进行此操作");
            } else {
                alert("失败");
            }
            $("#blogTable").bootstrapTable('refresh');

        };
        $.post(url,{feedbackId:row.feedbackId},callback,"json");
    },
    'click .ButtonB': function (e, value, row, index) {
        var url = "/feedback/doneTask";
        var callback = function(obj) {
            if (obj == "success") {
                alert("成功");
            } else if ( obj == "noPower") {
                alert("您无权限进行此操作");
            }  else {
                alert("失败");
            }
            $("#blogTable").bootstrapTable('refresh');

        };
        $.post(url,{feedbackId:row.feedbackId},callback,"json");
    },
    'click .ButtonC': function (e, value, row, index) {
        $("#modalBody").empty();
        $("#modalBody").html(value);
        $("#feedbackId").val(row.feedbackId);
        $("#editorArea").show();
        $("#publishBtn").show();
        $("#tipLabel").show();
        if (row.feedbackDone == 0 || row.feedbackDone == 2) {
            $("#tipLabel").hide();
            $("#editorArea").hide();
            $("#publishBtn").hide();
        }
        $("#myModal").modal('show');

    },
    'click .ButtonD': function (e, value, row, index) {
        $("#deleteDeptId").val(row.feedbackId);
        $("#deleteModal").modal('show');

    },
    'click .ButtonE': function (e, value, row, index) {
        $("#deleteDeptId").val(row.feedbackId);
        $("#deleteModal").modal('show');
    },
    // 点击修改按钮
    'click .ButtonF': function (e, value, row, index) {
        var getManUrl = "/user/getAdminAndTechnology";
        var getManCallback = function (obj) {
            for (var i=0;i<obj.length;i++) {
                $(".technologyList").append("<option value='"+obj[i].userUsername+"'>"+obj[i].userUsername+"</option>")
            }

            $("#updateModalFeedbackPictures").val(row.feedbackPictures);
            $("#updateModalFeedbackActiveMan").val(row.activeManName);
        };
        $.get(getManUrl, getManCallback, "json");

        var deptUrl = "/dept/getDeptList";
        var deptCallback = function (obj) {
            for (var i=0;i<obj.length;i++) {
                $("#updateModalDept").append("<option value='"+obj[i].deptId+"'>"+obj[i].deptName+"</option>")
            }
        };
        $.get(deptUrl, deptCallback, "json");

        $.get("/user/getUser",{userId:row.feedbackPushMan},function (userObj) {
            $("#updateModalPushMan").empty();
            $("#updateModalPushMan").append("<option>---请选择用户---</option>");
            var pushManUrl = "/user/getUserByDeptId?deptId="+userObj.deptId;
            var pushManCallback = function (obj) {
                console.log(obj);
                for (var i=0;i<obj.length;i++) {
                    $("#updateModalPushMan").append("<option value='"+obj[i].userId+"'>"+obj[i].userUsername+"</option>")
                }

                $("#updateModalPushMan").val(userObj.userId);
            };
            $.get(pushManUrl, pushManCallback, "json");


            $("#updateModalDept").val(userObj.deptId)

        },"json")
        // $("#updateModalForm").empty();
        $("#updateFeedbackTitle").val(row.feedbackTitle);
        $("#updateModalFeedbackId").val(row.feedbackId);

        editor2.txt.html(row.feedbackContent);

        // 显示模态框
        $("#updateModal").modal('show');
    }
};
$(function(){
    // if ($("#userInfo").val() == 0) {
    //     $(".tile").css("height","1000px");
    // }
    $("#myModal").modal("hide");
    $('#blogTable').bootstrapTable('destroy').bootstrapTable({
        url: '/feedback/getPageFeedback',   //url一般是请求后台的url地址,调用ajax获取数据。此处我用本地的json数据来填充表格。
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
        pageSize: 20,                    //每页的记录行数（*）
        pageList: [20, 50],     //可供选择的每页的行数（*）
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        paginationFirstText: "首页",
        paginationLastText: "尾页",
        //     responseHandler: responseHandler,
        columns: [{
            field: 'feedbackId',
            title: 'id'
        },{
            field: 'feedbackTitle',
            title: '标题',
            formatter:titleFormatter,
            events: operateEvents
        },{
            field: 'feedbackContent',
            title: '简略',
            formatter: articleUrlFormatter,
            events: operateEvents
        },{
            field: 'feedbackPushTime',
            title: '提交时间',
            formatter: dateFormatter,
        },{
            field: 'feedbackDoneTime',
            title: '完成时间',
            // cellStyle:{
            //     css:{
            //         "width":"100px"
            //     }
            // },
            formatter: dateFormatter
        },{
            field: 'activeManName',
            title: '执行人',
        },{
            field: 'pushManName',
            title: '提交人',
        },{
            field: 'feedbackPictures',
            title: '提交对象',
        },{
            field: 'feedbackDone',
            title: '状态',
            formatter:showStatusFormatter
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
        }
    });
});

// 富文本编辑器
var E2 = window.wangEditor;
var editor2 = new E2('#updateModalEditorArea');
editor2.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    'link',  // 插入链接
    'quote',  // 引用
    'image',  // 插入图片
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
];
editor2.customConfig.uploadImgServer = '/file/uploadFiles';  // 上传图片到服务器
editor2.customConfig.showLinkImg = false; // 取消网络图片
editor2.customConfig.uploadFileName = 'file';
editor2.create();

var E = window.wangEditor;

var editor1 = new E('#editorArea');
// 编辑器菜单设置
editor1.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    // 'italic',  // 斜体
    // 'underline',  // 下划线
    // 'strikeThrough',  // 删除线
    // 'foreColor',  // 文字颜色
    // 'backColor',  // 背景颜色
    'link',  // 插入链接
    // 'list',  // 列表
    // 'justify',  // 对齐方式
    'quote',  // 引用
    // 'emoticon',  // 表情
    'image',  // 插入图片
    // 'table',  // 表格
    // 'video',  // 插入视频
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
];
editor1.customConfig.uploadImgServer = '/file/uploadFiles';  // 上传图片到服务器
editor1.customConfig.showLinkImg = false; // 取消网络图片
editor1.customConfig.uploadFileName = 'file';
editor1.customConfig.onfocus = function () {
    editor1.txt.clear()
}
editor1.create();

$(function () {
    // excel 生成
    $("#saveBtn").click(function () {
        var url="/feedback/generatorExcel";
        window.open(url);
    });

    $("#updateBtn").click(function () {
        $("#updateModalFeedbackContent").val(editor2.txt.html());
        var updateUrl = "/feedback/update";
        var updateData = $("#updateModalForm").serialize();
        var updateCallback = function (obj) {
            if (obj == "success") {
                alert("修改成功")
            } else if (obj == "noPower") {
                alert("您无权限进行此操作");
            } else if (obj == "fail") {
                alert("修改失败,请稍后重试")
            } else {
                alert("系统错误,请联系技术人员");
            }
            $("#blogTable").bootstrapTable('refresh');
        };
        $.post(updateUrl,updateData,updateCallback,"text");
    });
    $("#publishBtn").click(function () {
        var content =editor1.txt.html() + "<hr style='height:1px;border:none;border-top:1px dashed #0066CC;' />"
            + $("#modalBody").html();
        var feedbackId = $("#feedbackId").val();

        var url = "/feedback/reply";
        var data = {
            content : content,
            feedbackId : feedbackId
        };
        $.post(url,data,function (obj) {
            if (obj == "success") {
                alert("成功");
                location.reload();
            } else {
                alert("失败");
            }
        },"text");
    });
});
$(function () {
    $("#modalBody").delegate("img","click",function () {
        var obj = this.src;
        window.open(obj);
    });
    $("#modalBody").delegate("img","mousemove",function () {
        $(this).css("cursor","pointer");
    });
});


$(function () {
    var userInfo = $("#userInfo").val();
    if (userInfo == 0) {
        $("#choosePushManTip").hide();
        $("#selectPushMan").hide();
        $("#selectDept").hide();
        $("#saveBtn").addClass("disabled");
        $("#saveBtn").hide();
    }
    // $("#selectDept").empty()
    var url = "/dept/getDeptList";
    var callback = function (obj) {
        for (var i = 0; i < obj.length; i++) {
            $("#selectDept").append("<option value='" + obj[i].deptId + "'>" + obj[i].deptName + "</option>")
        }
    };
    $.get(url, callback, "json");

    var url = "/feedback/getFeedbackStatus";
    var callback = function (obj) {
        $("#selectStatus").append("<option>---请选择状态---</option>")
        for (var i = 0; i < obj.length; i++) {
            $("#selectStatus").append("<option value='" + obj[i].feedbackId + "'>" + obj[i].feedbackPictures + "</option>")
        }
    };
    $.get(url, callback, "json");

    $("#updateModalDept").change(function () {
        var selectDept = $("#updateModalDept").val();
        if (selectDept == "---请选择部门---") {
            $("#blogTable").bootstrapTable('refresh', {
                url: '/feedback/getPageFeedback'
            });
        }
        $("#updateModalPushMan").empty();
        $("#updateModalPushMan").append("<option>---请选择用户---</option>")
        var pushManUrl = "/user/getUserByDeptId?deptId=" + selectDept;
        var pushManCallback = function (obj) {
            for (var i = 0; i < obj.length; i++) {
                $("#updateModalPushMan").append("<option value='" + obj[i].userId + "'>" + obj[i].userUsername + "</option>")
            }
        };
        $.get(pushManUrl, pushManCallback, "json");
    });

    $("#selectDept").change(function () {
        var selectDept = $("#selectDept").val();
        if (selectDept == "---请选择部门---") {
            $("#blogTable").bootstrapTable('refresh', {
                url: '/feedback/getPageFeedback'
            });
        }
        $("#selectPushMan").empty();
        $("#selectPushMan").append("<option>---请选择用户---</option>")
        var url = "/user/getUserByDeptId?deptId=" + selectDept;
        var callback = function (obj) {
            for (var i = 0; i < obj.length; i++) {
                $("#selectPushMan").append("<option value='" + obj[i].userId + "'>" + obj[i].userUsername + "</option>")
            }
        };
        $.get(url, callback, "json");
    });

    $("#selectPushMan").change(function () {
        var chooseStatus = $("#selectStatus").val();
        var choosePushMan = $("#selectPushMan").val();
        if (choosePushMan == "---请选择用户---" && chooseStatus == "---请选择状态---") {
            $("#blogTable").bootstrapTable('refresh', {
                url: '/feedback/getPageFeedback'
            });
        } else if (chooseStatus == "---请选择状态---" && choosePushMan != "---请选择用户---") {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByUserId?userId=" + choosePushMan
            });
        } else if (chooseStatus != "---请选择状态---" && choosePushMan == "---请选择用户---") {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByStatus?statusId=" + chooseStatus
            });
        } else {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByUserIdAndStatus?userId=" + choosePushMan + "&statusId=" + chooseStatus
            });
        }


    });
    $("#selectStatus").change(function () {
        var chooseStatus = $("#selectStatus").val();
        var choosePushMan = $("#selectPushMan").val();
        var chooseDept = $("#selectDept").val();
        var userInfo = $("#userInfo").val();
        var userId = $("#userId").val();
        if (chooseStatus == "---请选择状态---" && userInfo == 0) {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByUserId?userId=" + userId
            });
        } else if (chooseStatus != "---请选择状态---" && userInfo == 0) {
            var refreshUrl = "/feedback/getPageFeedbackByUserIdAndStatus?userId=" + userId + "&statusId=" + chooseStatus;
            $("#blogTable").bootstrapTable('refresh', {
                url: refreshUrl
            });

        } else if ((choosePushMan == "---请先选择部门---" || choosePushMan == "---请选择用户---") && chooseStatus == "---请选择状态---" && userInfo != 0) {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedback"
            });
        } else if (choosePushMan == "---请选择用户---" && chooseStatus == "---请选择状态---" && userInfo != 0) {
            $("#blogTable").bootstrapTable('refresh', {
                url: '/feedback/getPageFeedback'
            });
        } else if (choosePushMan == "---请选择用户---" && chooseStatus != "---请选择状态---" && userInfo != 0) {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByStatus?statusId=" + chooseStatus
            });
        } else if (choosePushMan != "---请先选择部门---" && chooseStatus == "---请选择状态---" && userInfo != 0) {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByUserId?userId=" + choosePushMan
            });
        } else if ((choosePushMan == "---请先选择部门---" || choosePushMan == "---请选择用户---") && chooseStatus != "---请选择状态---" && userInfo != 0) {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByStatus?statusId=" + chooseStatus
            });
        } else {
            $("#blogTable").bootstrapTable('refresh', {
                url: "/feedback/getPageFeedbackByUserIdAndStatus?userId=" + choosePushMan + "&statusId=" + chooseStatus
            });
        }

    });


});
