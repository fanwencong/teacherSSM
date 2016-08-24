<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>所有数据</title>
</head>
<body >
	<nav class="navbar navbar-default" >
	<div class="container-fluid" >
		<div class="navbar-header" >
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
	<h3>所有教师数据</h3>
		
		<div class="table-responsive">
		<table  class="table">
			<tbody>
				<tr>
					<th>姓名</th>
					<th>登录密码</th>
					<th>性别</th>
					<th>个人简介</th>
					<th>头像URL</th>
					<th>学校名称</th>
					<th>注册时间</th>
					<th>备注</th>
					<th>操作</th>
					
				</tr>
				<c:if test="${!empty teacherList }">
					<c:forEach items="${teacherList}" var="list" varStatus="loop">
						<tr>
							<td>${list.name }</td>
							<td>${list.password }</td>
							<td>${list.sex }</td>
							<td>${list.description }</td>
							<td>${list.picUrl }</td>
							<td>${list.schoolName }</td>
							<td>${dateList[loop.count-1]}</td>
							<td>${list.remark }</td>
							<td>&nbsp;
							<a href="update/${list.id} ">修改</a>&nbsp;
							<a href="delete/${list.id}">删除</a>&nbsp;
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		</div>
		
		
	<ul class="pagination pagination-lg">
		<li><a href="#">&laquo;</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	</center>
	<br>
</body>
</html>