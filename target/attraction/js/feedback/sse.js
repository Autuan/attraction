
if ('EventSource' in window) {
    var source = new EventSource("/push");
} else {
    alert("不推荐使用IE 及 Edge 浏览器");
}

var source = new EventSource("/push");
// 连接建立时的方法
source.addEventListener('open',function () {
    console.log("SSE 连接打开")
});
// 收到消息时的方法
source.onmessage = function(event) {
    console.log("event.data=" + event.data);//必须用data接收
    // $("#test").innerHTML += event.data + "<br />";
    console.log("SSE 收到消息");
    var msg = event.data;
    console.log(msg);
    var userInfo = $("#userInfo").val();

    if (userInfo != 0) {
        var notification = new Notification("收到了新的任务", {
            dir: "auto",
            lang: "hi,Lang",
            tag: "testTag",
            // icon:"null",
            body: event.data,
        });
        notification.onclick = function () {
            //可直接打开通知notification相关联的tab窗口
            location = "/feedback/bugList";
        }
    }
};
