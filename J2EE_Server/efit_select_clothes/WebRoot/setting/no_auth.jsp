<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="utf-8"%>
<html>
<jsp:include page="../common/head.jsp"/>
<body>
<script language="javascript" type="text/javascript">
	var contentPath = '<%=request.getContextPath()%>';
	function init(){
		menuBg("1");
	}
</script>
	<jsp:include page="../common/top.jsp"/>
	<div id="main">
		<jsp:include page="menu_left.jsp"/>
		<div class="right">
			<div style="text-align:center;width:100%;padding-top:50px;">
				<div style="width:300px;height:90px;background:url(images/error.jpg);margin:0 auto;">
					<a style="color:#FF0000" href="javascript:history.go(-1);"><br/>对不起，你没有该项权限!<br/><br/>请联系管理员!点击返回</a>
				</div>
			</div>
		</div>
		<jsp:include page="../common/bottom.jsp"/>
	</div>
</body>
</html>
