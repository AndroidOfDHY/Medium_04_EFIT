<%@ taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<%@ page contentType="text/html" language="java" import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>


<div class="pageContent" align="center">
<table class="list" width="80%" layoutH="1"  cellpadding="4" cellspacing="1"  >
<tbody>
                  <tr>
				    <td>服装名字:</td>
                    <td >${clothes.clothesName}</td>
                    </tr>
                  <tr>
                    <td>类型:</td>
                    <td>${clothes.type}</td>
                  </tr>
                  <tr>
				    <td>性别:</td>
                    <td>${clothes.sex}</td>
                    </tr>
                  <tr>
				   <td >尺寸:</td>
                    <td >${clothes.size}</td>
                    </tr>
                  <tr>
				    <td >关键字:</td>
                    <td >${clothes.keyword}</td>
                    </tr>
                  <tr>
				    <td >缩略图:</td>
                   <td ><img src="<%=path %>/images/${clothes.thumbAdress}" width="100" height="100" onerror="this.src='<%=path %>/system/null.jpg'"/></td>
                    </tr>
                    
                    <tr>
				    <td >服装图片:</td>
                   <td ><img idth="50%" height="50%" src="<%=path %>/images/${clothes.imageAdress}" onerror="this.src='<%=path %>/system/null.jpg'"/></td>
                   </tr>
                    <tr>
				    <td >匹配值:</td>
                   <td >${clothes.matchValue}</td>
                   </tr>
                    <tr>
				    <td  >提交时间:</td>
                   <td >${clothes.submitTime}</td>
                   </tr>
</tbody>

            </table>
</div>
