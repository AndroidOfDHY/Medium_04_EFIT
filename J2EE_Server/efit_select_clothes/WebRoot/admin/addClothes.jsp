<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" pageEncoding="GBK"%>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<jsp:include page="head.jsp"/>

</head>
<script language="javascript" type="text/javascript">
           function uploadFrame(obj){
          
              	ymPrompt.win({title:'上传图片',
			message:"<form id='tijiao' value='"+obj+"'  enctype='multipart/form-data' method='post'>文件:<input type='file' id='image' class='text' name='image'></form>",width:300,height:100,
			btn:[['提交','yes'],['关闭','no']],handler: myhandler,autoClose:false});
           }
              function myhandler(tp){
              if(tp=='yes'){
              if($('#image').val()==''){
                ymPrompt.alert({title:'提示',message:"请上传！"});
              return;}
           $("#tijiao").ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/admin/fileUpload.do?act=upLaod",
                    success: function(msg){
                    var data=eval("("+msg +")");
                   
                   if(data.msg=='200'){
                     $("#"+$("#tijiao").val()).val(data.value);
                    ymPrompt.alert({title:'提示',message:"上传成功"});
                     }
                     else {ymPrompt.alert({title:'提示',message:"上传失败"});}
                    }
                });
                }
              else ymPrompt.close();
            }
            function ajaxSubmit(){
            if($("#clothesName").val()==''){ymPrompt.alert({title:'提示',message:"请填写衣物名",handler:function(){$("#clothesName").focus();}});}
            else if($("#thumbAdress").val()==''){ymPrompt.alert({title:'提示',message:"请上传衣物缩略图"});}
            else if($("#imageAdress").val()==''){ymPrompt.alert({title:'提示',message:"请上传衣物图"});}
            else if($("#key").val()==''){ymPrompt.alert({title:'提示',message:"请填写关键字",handler:function(){$("#key").focus();}})}
            else if($("#matchValue").val()==''){ymPrompt.alert({title:'提示',message:"请填写匹配值",handler:function(){$("#matchValue").focus();}});}
            else{
               $("#information").ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/admin/clothes.do?act=add",
                    success: function(msg){
                    if(msg=="200"){ymPrompt.alert({title:'提示',message:"提交成功"});
                    $("#clothesName").val('');$("#key").val('');$("#matchValue").val('');
                    }
                    else {ymPrompt.alert({title:'提示',message:"提交失败"});}
                    }                    
                });
                }
            }
</script>
<body class="ContentBody">

<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >衣物添加</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="doSubmit()"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>添加衣物</legend>
	<form id="information" >
   <table border="0" cellpadding="2" cellspacing="1" align="center" width="50%">
 <tr><td>服装名称：</td><td><input type="text" name="clothesName" id="clothesName" class="text"/></td>
       <tr><td>服装类型：</td><td>  
        <select name="type" id="type">
			   <option value="T">上装</option>
			   <option value="D">下装</option>
			   </select></td></tr>
			   
	   <tr><td>性别：</td><td>  
        <select name="sex" id="sex">
			   <option value="M">男</option>
			   <option value="W">女</option>
			    <option value="A">通用</option>
			   </select></td></tr>
			   
       <tr><td>尺寸：</td><td><select name="size" id="size">
			   <option value="s">s</option>
			   <option value="m">m</option>
			   <option value="l">l</option>
			   </select></td></tr>
			   
		<tr><td>缩略图：</td><td><input type="text" name="thumbAdress" id="thumbAdress" readonly="readonly" class="text"/><a href="#" onclick="uploadFrame('thumbAdress')">上传</a></td></tr>
		<tr><td>图片：</td><td><input type="text" name="imageAdress" id="imageAdress" readonly="readonly" class="text"/><a href="#" onclick="uploadFrame('imageAdress')">上传</a></td></tr>	
		<tr><td>品牌：</td><td><input name="brand" id="brand" class="text"></td></tr> 
		<tr><td>柜台销售位置：</td><td><input name="position" id="position" class="text"></td></tr>          
		<tr><td>关键字：</td><td><textarea rows="5" name="key" id="key" class="text" cols="50" name="input" id="input" ></textarea></td></tr>
		<tr><td>简介：</td><td><textarea rows="5" name="detail" id="detail" class="text" cols="50" name="input" id="input" ></textarea></td></tr>
		<tr><td>匹配值：</td><td><input name="matchValue" id="matchValue" class="text" onkeyup="value=value.replace(/[^\d]/g,'')"></td></tr>      
	 </table>
	 </form>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		</TABLE>
	
	
	 </td>
  </tr>
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="button"  onclick="ajaxSubmit()" value="提交" class="button"/>　
			
			<input type="button"  value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>

</div>
</body>
</html>