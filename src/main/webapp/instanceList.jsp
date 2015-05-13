<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="echase/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="sign/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					日期从：<input type="text" class="date" name="startDate" />
				</td>
				<td>
					到日期：<input type="text" class="date" name="endDate" />
				</td>
				<td>
					<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="70%" layoutH="138">
		<thead>
			<tr>
				<th >部门</th>
				<th >人员</th>
				<th >流程标题</th>
				<th >表单ID</th>
				<th >操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.data}" var="e">
			<tr target="e_id" rel="${e[0]}">
				<td>${e[1]}</td>
				<td>${e[2]}</td>
				<td>${e[3]}</td>
				<td>${e[4]}</td>
				<td><a href="flow/recall?instanceId=${e[0]}">撤消</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示${pages.numPerPage}</span><span>条，共${pages.totalCount}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${pages.totalCount}" numPerPage="${pages.numPerPage}" pageNumShown="${pages.pageNumShown}" currentPage="${pages.currentPage}"></div>
	</div>
</div>
    