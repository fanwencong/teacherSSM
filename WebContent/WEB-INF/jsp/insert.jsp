<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师数据</title>

</head>

<body>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="<%=basePath + "/teacher/getAllTeacher"%>">首页</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<form class="navbar-form navbar-left" role="search"
				action="getTeacherByName" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="教师名字"
						name="getName">
				</div>
				<button type="submit" class="btn btn-default btn-lg">
				<span class="glyphicon glyphicon-search" aria-hidden="true">
				</span>
				</button>
				
			</form>

			<ul class="nav navbar-nav ">
				<li><a class="btn btn-default btn-lg" href="<%=basePath + "/teacher/insert"%>">
				<span class="glyphicon glyphicon-plus" aria-hidden="true">
				</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<center>
		<h3>添加教师</h3>
		
			<form action="addTeacher" method="post" class="form-horizontal">
			<div class="table-responsive">
			<table width="500" class="table" >
				<tr>
					
					<td align="right">姓名:</td>
					<td><input type="text" name="name"></td>
					<td style=" color:#CC3300">${name}</td>
					
				</tr>
				<tr>
					
					<td align="right">登录密码: </td>
					<td><input type="password" name="password" id="inputPassword3" ></td>
					<td style=" color:#CC3300">${password}</td>
					
				</tr>
				<tr>
					<td align="right">性别:</td>
					<td><input type="text" name="sex"></td>
					<td style=" color:#CC3300">${sex}</td>
				</tr>
				<tr>
					<td align="right">个人简介:</td>
					<td><input type="text" name="description"></td>
					<td style=" color:#CC3300">${description}</td>
				</tr>
				<tr>
					<td align="right">头像Url:</td>
					<td><input type="text" name="picUrl"></td>
					<td style=" color:#CC3300">${picUrl}</td>
				</tr>
				<tr>
					<td align="right">学校名称:</td>
					<td><input type="text" name="schoolName"></td>
					<td style=" color:#CC3300">${schoolName}</td>
				</tr>
				<tr>
					<td align="right">备注:</td>
					<td><input type="text" name="remark"></td>
					<td style=" color:#CC3300"></td>
				</tr>

			</table>
			</div>
			<input type="submit" value="确认添加" class="btn btn-default">

			</form>
		
	</center>
</body>
</html>