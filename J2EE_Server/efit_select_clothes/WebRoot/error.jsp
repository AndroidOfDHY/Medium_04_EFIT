<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<jsp:include page="common/head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String version = "" + System.currentTimeMillis();
	String contextPath = request.getContextPath();  
    String headerReferer  =request.getHeader("Referer");  
    String basePath = headerReferer.substring(0,headerReferer.indexOf(contextPath)+contextPath.length()+1);  
	
%>
	<body >
		<div id="main_container">
			<jsp:include page="common/top.jsp" />
			<div id="main_content">
				<jsp:include page="common/left.jsp" />


				<div id="center_content">

					<div class="title">
						<a href="index.html">主页</a> &lt;&lt; 搜索结果
					</div>


							<div id="container" align="center"> <font size="5px" color="red">${error}</font></div>
						    <s:else>
						   
					<div align="right">
						<s:property value="#request.pagestr" escape="false" />
					</div>
					</s:else>
				</div>



				<jsp:include page="common/foot.jsp" />
			</div>

		</div>

		</div>
	</body>
	</html>