<%@ taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<%@ page contentType="text/html" language="java" import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="navTabSearch(this);" action="admin/clothes.do${pagestr}&pageSize='+this.value" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>我的客户：</label>
				<input type="text" name="keywords" value=""/>
			</li>
			<li>
			<select class="combox" name="province">
				<option value="">所有省市</option>
				<option value="北京">北京</option>
				<option value="上海">上海</option>
				<option value="天津">天津</option>
				<option value="重庆">重庆</option>
				<option value="广东">广东</option>
			</select>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="demo_page4.html" target="navTab"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除默认方式</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="138" >
		<thead>
			<tr>
				<th width="6%"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
			
				 <th width="11%" height="20" align="center" bgcolor="#EEEEEE">服装名称</td>
                    <th width="11%" align="center" orderField="accountType" bgcolor="#EEEEEE">类型</td>
                    <th width="11%" align="center" orderField="accountType" bgcolor="#EEEEEE">性别</td>
                    <th width="11%" align="center" orderField="accountType" bgcolor="#EEEEEE">尺寸</td>
					<th width="11%" align="center" bgcolor="#EEEEEE">缩略图</td>
					<th width="11%" align="center" orderField="accountLevel" bgcolor="#EEEEEE">匹配值</td>
					<th width="11%" align="center" bgcolor="#EEEEEE">提交时间</td>
                    <th width="19%" align="center" bgcolor="#EEEEEE">操作</td>
			</tr>
		</thead>
		<tbody>
		 <s:iterator value="#request.clothesList" >
			<tr target="sid_user" rel="1" align="center" >
				<td><input name="ids" value="<s:property value='clothesId' />" type="checkbox"></td>
                    <td ><s:property value="clothesName" /></td>
                    <td ><s:property value="type" /></td>
                    <td ><s:property value="sex" /></td>
                    <td ><s:property value="size" /></td>
                    <td ><img  width="50%" height="50%"   src="<%=path %>/images/<s:property value='thumbAdress' />"  onerror="this.src='<%=path %>/system/null.jpg'"/></td>
                    <td ><s:property value="matchValue" /></td>
                    <td ><s:property value="submitTime" /></td>
				<td >
				<a title="删除" target="ajaxTodo" href="demo/common/ajaxDone.html?id=<s:property value='clothesId' />" class="btnDel" title="确定要删除吗?">删除</a>
				<a title="编辑" target="navTab" href="admin/clothes.do?act=detail&clothesId=<s:property value='clothesId'/>&page=modifyClothes" class="btnEdit">编辑</a>
				<a title="详情" target="navTab" href="admin/clothes.do?act=detail&clothesId=<s:property value='clothesId'/>&page=detailClothes" class="btnEdit">编辑</a>
				</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	<div align="right">
		<!--<div class="pages">
			<span>显示</span>
			<select name="pageSize" class="combox" onchange="javascript:navTab.reload('admin/clothes.do${pagestr}&pageSize='+this.value)">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		<!--  <div class="pagination" targetType="navTab" totalCount="${totalCount}" numPerPage="${numPerPage}" pageNumShown="${pageNumShown}" currentPage="${currentPage}"></div>-->
    <s:property value="#request.pagestr" escape="false"/>
	</div>
</div>
