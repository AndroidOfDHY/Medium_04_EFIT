
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" pageEncoding="GBK"%>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<link href="<%=path %>/admin/css/css.css" rel="stylesheet" type="text/css" />
<jsp:include page="head.jsp"/>
<%@ taglib prefix="s" uri="/struts-tags"%>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>
<script type="text/JavaScript">

</script>
<style type="text/css">
<!--
.style3 {font-size: 18px}
.style5 {font-size: 14px; text-decoration: none; font-family: "宋体";}
.style6 {font-size: 12px; height: 20px; width: 45px; background-image: url(../images/button04.gif); border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-family: "宋体";}
.style7 {font-size: 12px; height: 20px; width: 75px; background-image: url(../images/button09.gif); border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px; font-family: "宋体";}
.style10 {color: #000000}
-->
</style>
<link href="<%=path %>/admin/css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}
</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="<%=path %>/admin/images/nav04.gif" class="style10">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24">&nbsp;</td>
			  <td width="519">&nbsp;</td>
			  <td width="679" align="left"><a href="#" onclick="sousuo()"></a></td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%"   border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span></td>
          </tr>
              <tr>
                <td height="40" class="font42">
                <table class="list" width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
					                  <tr>
                    <td height="20" colspan="2" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${clothes.clothes.clothesName} &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="21%" height="20"  align="right" bgcolor="#FFFFFF">服装名字:</td>
                    <td width="74%" bgcolor="#FFFFFF">${clothes.clothes.clothesName}</td>
                    </tr>
                  <tr>
                    <td height="20" align="right" bgcolor="#FFFFFF">类型:</td>
                    <td bgcolor="#FFFFFF">${clothes.clothes.type}</td>
                  </tr>
                  <tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">性别:</td>
                    <td bgcolor="#FFFFFF">${clothes.clothes.sex}</td>
                    </tr>
                  <tr>
				   <td height="20" align="right" bgcolor="#FFFFFF">尺寸:</td>
                    <td bgcolor="#FFFFFF">${clothes.clothes.size}</td>
                    </tr>
                    
                   <tr>
				   <td height="20" align="right" bgcolor="#FFFFFF">品牌:</td>
                    <td bgcolor="#FFFFFF">${clothes.clothes.brand}</td>
                    </tr>
                    
                    <tr>
				   <td height="20" align="right" bgcolor="#FFFFFF">销售柜台:</td>
                    <td bgcolor="#FFFFFF">${clothes.clothes.position}</td>
                    </tr>
                    
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">关键字:</td>
                    <td bgcolor="#FFFFFF">${clothes.clothes.keyword}</td>
                    </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">缩略图:</td>
                   <td bgcolor="#FFFFFF"><img src="<%=path %>/clothes/${clothes.clothes.thumbAdress}" width="100" height="100" onerror="this.src='<%=path %>/system/null.jpg'"/></td>
                    </tr>
                    
                    <tr>
				    <td align="right" bgcolor="#FFFFFF">服装图片:</td>
                   <td bgcolor="#FFFFFF"><img width="50%" height="50%"  src="<%=path %>/clothes/${clothes.clothes.imageAdress}" onerror="this.src='<%=path %>/system/null.jpg'"/></td>
                   </tr>
                    <tr>
				    <td align="right" bgcolor="#FFFFFF">匹配值:</td>
                   <td bgcolor="#FFFFFF">${clothes.clothes.matchValue}</td>
                   </tr>
                    <tr>
				    <td align="right" bgcolor="#FFFFFF">提交时间:</td>
                   <td bgcolor="#FFFFFF">${clothes.clothes.submitTime}</td>
                   </tr>
                   
                  <tr>
                  

            </table></td>
        </tr>
        
      </table>
      
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td ><input class="button" type="button" name="back" id="back" onclick="window.history.go(-1);" value="返回"/></td>
                
        </tr>
      
</table>
</body>
</html>
