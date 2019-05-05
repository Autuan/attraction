<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>畅游管理系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-editable.css">
  </head>
  <body class="app sidebar-mini rtl">
  <%--<div th:include="managerCommon :: ManagerCommon"></div>--%>
  <jsp:include page="./menuCommon.jsp"></jsp:include>
  <main class="app-content">
    <div th:include="managerCommon :: contentTitle"></div>
    <div class="row">
      <div class="col-md-6 col-lg-3">
        <div class="widget-small primary coloured-icon"><i class="icon fa fa-comments fa-3x"></i>
          <div class="info">
            <h4>反馈问题总数</h4>
            <p><b id="allFeedback"></b></p>
          </div>
        </div>
      </div>
      <div class="col-md-6 col-lg-3">
        <div class="widget-small info coloured-icon"><i class="icon fa fa-comment fa-3x"></i>
          <div class="info">
            <h4>全部未完成反馈数量</h4>
            <p><b id="notDoneFeedback"></b></p>
          </div>
        </div>
      </div>
      <div class="col-md-6 col-lg-3">
        <div class="widget-small warning coloured-icon"><i class="icon fa fa-comments-o fa-3x"></i>
          <div class="info">
            <h4>今日反馈数量</h4>
            <p><b id="allFeedbackToday"></b></p>
          </div>
        </div>
      </div>
      <div class="col-md-6 col-lg-3">
        <div class="widget-small danger coloured-icon"><i class="icon fa fa-comment-o fa-3x"></i>
          <div class="info">
            <h4>今日未完成反馈数量</h4>
            <p><b id="notDoneFeedbackToday"></b></p>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <div class="tile">
          <h3 class="tile-title">最近一周反馈提交数量</h3>
          <%--<div id="echart1" ></div>--%>
          <div id="echart1" style="width: 450px;height:400px;"></div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="tile">
          <h3 class="tile-title">最近一周反馈处理情况</h3>
          <%--<div id="echart2" ></div>--%>
          <div id="echart2" style="width: 450px;height:400px;"></div>
        </div>
      </div>
    </div>
    <%--<div class="row">--%>
      <%--<div class="col-md-6">--%>
        <%--<div class="tile">--%>
          <%--<h3 class="tile-title">Features</h3>--%>
          <%--<div id="echart3" style="width: 600px;height:400px;"></div>--%>
        <%--</div>--%>
      <%--</div>--%>

      <%--<div class="col-md-6">--%>
        <%--<div class="tile">--%>
          <%--<h3 class="tile-title">Compatibility with frameworks</h3>--%>
          <%--<div id="echart4" style="width: 600px;height:400px;"></div>--%>
        <%--</div>--%>
      <%--</div>--%>
    <%--</div>--%>
  </main>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <%--<script src="${pageContext.request.contextPath}/js/plugins/pace.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/js/feedback/sse.js"></script>--%>
    <script type="text/javascript">
      if(document.location.hostname == 'pratikborsadiya.in') {
      	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      	ga('create', 'UA-72504830-1', 'auto');
      	ga('send', 'pageview');
      }
    </script>


  <script>
      // option 1
      var echart1 = echarts.init(document.getElementById('echart1'));
      // 显示标题，图例和空的坐标轴
      echart1.setOption({
          title: {
              text: '最近一周反馈提交数量'
          },
          tooltip: {},
          legend: {
              data:['数量']
          },
          xAxis: {
              data: []
          },
          yAxis: {},
          series: [{
              name: '数量',
              type: 'bar',
              data: []
          }]
      });

      // 异步加载数据
      $.get('/countFeedbackLastWeek').done(function (data) {
          // 填入数据
          echart1.setOption({
              xAxis: {
                  data: data.categories
              },
              series: [{
                  // 根据名字对应到相应的系列
                  name: '数量',
                  data: data.data
              }]
          });
      });


      // 图表2
      var echart2 = echarts.init(document.getElementById('echart2'));
      echart2.setOption({
          tooltip : {
              trigger: 'item',
              formatter: "{a} <br/>{b} : {c} 条"
          },
          series : [
              {
                  name: '最近一周反馈处理情况',
                  type: 'pie',
                  radius: '55%',
              }
          ]
      });

      $.get('/countFeedbackGroupByStatusLastWeek').done(function (data) {
          echart2.setOption({
              series:[{
                // data:json
                  data:data
              }]
          })
      })

    $(function () {
        $.get("/getStatistics", function (obj) {
            console.log(obj);
            for( var i=0;i<obj.length;i++ ) {
                $("#allFeedback").html(obj[i].allFeedback);
                $("#notDoneFeedback" ).html(obj[i].notDoneFeedback);
                $("#allFeedbackToday" ).html(obj[i].allFeedbackToday);
                $("#notDoneFeedbackToday" ).html(obj[i].notDoneFeedbackToday);
            }
        }, "json");
    });
  </script>
  </body>
</html>