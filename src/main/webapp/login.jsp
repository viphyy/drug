<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XX科技有限公司办公系统</title>
<link href="themes/css/login.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="/"><img src="themes/default/images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href=" ">反馈</a></li>
						<li><a href=" " target="_blank">帮助</a></li>
					</ul>
				</div>
				<h2 class="login_title"><img src="themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="checkLogin" method="post" id="loginForm">
				
					<p>
						<label>用户名：</label>
						<input type="text" name="no" id="userNo" size="20" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="password"  size="20" class="login_input" />
					</p>
					
					<div>
						<input type="checkbox" id="isRemember" />记住我 &nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
					<p style="color:red;"><br /><c:if test="${param.loginMsg==1}">用户名或密码错误</c:if></p>
				</form>
			</div>
			<div class="login_banner"><img src="themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
			 
				<div class="login_inner">
					<p>您可以使用 网易网盘 ，随时存，随地取</p>
					<p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
					<p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2009 3232323 Inc. All Rights Reserved.
		</div>
	</div>
</body>
 <script>
	var no=document.getElementById("userNo"); 
	no.focus();
 </script>
</html>