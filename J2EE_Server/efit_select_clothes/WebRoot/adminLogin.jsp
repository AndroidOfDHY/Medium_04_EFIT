
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>

<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<title> </title>
<jsp:include page="/admin/head.jsp"/>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="<%=path %>/admin/css/css.css" rel="stylesheet" type="text/css" />
<script language="javascript"> 
function loadimage(){ 
document.getElementById("randImage").src = "<%=path %>/image.jsp?"+Math.random(); 
} 
function Dosubmit(){ 
if($('#userName').val()==''){ymPrompt.alert({title:'提示',message:'用户名不能为空',width:220,height:150});return;}
else if($('#password').val()==''){ymPrompt.alert({title:'提示',message:'密码不能为空',width:220,height:150});return;}
else if($('#captcha').val()==''){ymPrompt.alert({title:'提示',message:'验证码不能为空',width:220,height:150});return;}
else window.location.href="admin";
} 
</script>
</head>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="<%=path %>/admin/images/top02.gif"><img src="<%=path %>/images/logo.png" width="276" height="100" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="<%=path %>/admin/images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="<%=path %>/admin/images/line01.gif" width="5" height="292" /></td>
      </tr>
      
    </table></td>


    <td>
    <form action="login.do" id="form" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr><td colspan="2" width="100%" height="35">
<%
if(request.getAttribute("error")!=null)
{
out.print("<font color='red'>"+request.getAttribute("error")+"</font>");
}

 %>
    </td></tr>
      <tr>
        <td width="31%" height="35"  class="login-text02">账号：<br /></td>
        <td width="69%"><input  name="userName" id="userName" type="text" size="30" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密码：<br /></td>
        <td><input  name="password"  id="password" type="password" size="33" /></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="button" class="right-button01" onclick="Dosubmit()" value="提交"/>
          <input name="Submit232" type="reset" class="right-button02" value="重置" /></td>
      </tr>
    </table>
    </form></td>
  </tr>
</table>
</body>
</html>