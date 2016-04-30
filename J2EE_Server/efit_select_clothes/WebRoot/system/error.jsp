<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="utf-8"%>
<%
String baseUrl = request.getContextPath();
String errorInfo = (String)request.getAttribute("msg");
String errorUrl = (String)request.getAttribute("url");
if(errorInfo==null){
	errorInfo = "系统运行错误!!!";
}
if(errorUrl==null){
	errorUrl = baseUrl+"/index.do";
}
%>
<html>
<jsp:include page="../common/head.jsp"/>
<body>
<script language="javascript" type="text/javascript">
	var contentPath = '<%=baseUrl%>';
	function init(){
		menuBg("","");
	}
</script>
	<jsp:include page="../common/top.jsp"/>
	<div id="main">
		<div style="padding:50px 0;display:block;margin:0 auto;text-align:center;">
			<div style="width:300px;height:110px;text-align:center;vertical-align:middle">
				<font color="#FF0000" face="微软雅黑"><a href="<%=errorUrl%>"><%=errorInfo%></a></font>
			</div>
		</div>
	 	<img src="<%=baseUrl%>/images/page_bottom.jpg" style="margin-top:220px" />
	</div>
</body>
</html>