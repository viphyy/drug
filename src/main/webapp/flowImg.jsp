<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看当前流程图</title>
</head>
<body>
fafasfsafsaf
<!-- 1.获取到规则流程图deploymentId -->
<img style="position: absolute;top: 0px;left: 0px;" src="flow/img?deploymentId=${deploymentId}&imageName=process/leave.png">

<!-- 2.根据当前活动的坐标，动态绘制DIV -->
<div style="position: absolute;border:1px solid red;top:${acs.y}px;left:${acs.x}px;width: ${acs.width}px;height:${acs.height}px;   "></div>
<div>
当前办理人：${current}
</div>
</body>
</html>