<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" pageEncoding="GBK"%>
    <title>请先登入</title>
    <link rel="stylesheet" href="../prompt/skin/vista/ymPrompt.css" type="text/css"/>
      <script language="javascript"  type="text/javascript" src="../prompt/ymPrompt.js"></script>
  </head>
  
  <body onload="ymPrompt.alert({title:'提示',message:'请先登入!',autoClose:true,handler:function(){window.open('','_top'); 
window.top.close(); } });">

  </body>
</html>
