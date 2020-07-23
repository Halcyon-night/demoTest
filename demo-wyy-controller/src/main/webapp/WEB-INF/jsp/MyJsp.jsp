<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>封装好的js库，直接生成模态框html，不需要手写</title>
    
	<link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" />
	<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="static/js/Ewin.js"></script>
	<script type="text/javascript">
		function index(){
			location.href="index";
		}
	
	
		function check(){
			$("#myModalLabel").text("新增");
			$('#myModal').modal();
		}
		
		function dele(){
			Ewin.confirm({message: "确认要删除选择的数据吗？"}).on(function(e) {
				if (!e) {
                  return;
             	}
			})
		}
		
		function btnalert(){
			Ewin.alert({message: "你好"})
		}
	</script>
	<script src="static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </head>
  
  <body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
					<li class="active">
						<a href="#"> 
							<i class="glyphicon glyphicon-th-large"></i> 首页
						</a>
					</li>
					<li>
						<a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse"> 
							<i class="glyphicon glyphicon-cog"></i> 系统管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span>
						</a>
						<ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
							<li><a href="mytask"><i class="glyphicon glyphicon-user"></i>用户管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>
						</ul>
					</li>
					<li>
						<a href="./plans.html"> 
							<i class="glyphicon glyphicon-credit-card"></i> 物料管理
						</a>
					</li>
					<li>
						<a href="./grid.html"> 
							<i class="glyphicon glyphicon-globe"></i> 分发配置 <span class="label label-warning pull-right">5</span>
						</a>
					</li>
					<li>
						<a href="./charts.html"> 
							<i class="glyphicon glyphicon-calendar"></i> 图表统计
						</a>
					</li>
					<li>
						<a href="#"> 
							<i class="glyphicon glyphicon-fire"></i> 关于系统
						</a>
					</li>
				</ul>
			</div>
			<br>
			<div class="col-md-10 col-xs-6">
				<input type="button" value="新增" class="btn btn-success" id="btn_add" onclick="check();">
			  	<input type="button" value="删除" class="btn btn-primary" id="btn_delete" onclick="dele();">
			  	<input type="button" value="测试alert弹窗" class="btn btn-warning" id="btn_delete" onclick="btnalert();">
			  	<div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="hide.jsp" %>
  </body>
</html>
