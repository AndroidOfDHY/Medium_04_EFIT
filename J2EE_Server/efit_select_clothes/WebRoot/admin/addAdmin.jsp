<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" pageEncoding="GBK"%>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<jsp:include page="head.jsp"/>

</head>
<script language="javascript" type="text/javascript">
           function uploadFrame(obj){
          
              	ymPrompt.win({title:'�ϴ�ͼƬ',
			message:"<form id='tijiao' value='"+obj+"'  enctype='multipart/form-data' method='post'>�ļ�:<input type='file' id='image' class='text' name='image'></form>",width:300,height:100,
			btn:[['�ύ','yes'],['�ر�','no']],handler: myhandler,autoClose:false});
           }
              function myhandler(tp){
              if(tp=='yes'){
              if($('#image').val()==''){
                ymPrompt.alert({title:'��ʾ',message:"���ϴ���"});
              return;}
           $("#tijiao").ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/admin/fileUpload.do?act=upLaod",
                    success: function(msg){
                    var data=eval("("+msg +")");
                   
                   if(data.msg=='200'){
                     $("#"+$("#tijiao").val()).val(data.value);
                    ymPrompt.alert({title:'��ʾ',message:"�ϴ��ɹ�"});
                     }
                     else {ymPrompt.alert({title:'��ʾ',message:"�ϴ�ʧ��"});}
                    }
                });
                }
              else ymPrompt.close();
            }
            function ajaxSubmit(){
            if($("#clothesName").val()==''){ymPrompt.alert({title:'��ʾ',message:"����д������",handler:function(){$("#clothesName").focus();}});}
            else if($("#thumbAdress").val()==''){ymPrompt.alert({title:'��ʾ',message:"���ϴ���������ͼ"});}
            else if($("#imageAdress").val()==''){ymPrompt.alert({title:'��ʾ',message:"���ϴ�����ͼ"});}
            else if($("#key").val()==''){ymPrompt.alert({title:'��ʾ',message:"����д�ؼ���",handler:function(){$("#key").focus();}})}
            else if($("#matchValue").val()==''){ymPrompt.alert({title:'��ʾ',message:"����дƥ��ֵ",handler:function(){$("#matchValue").focus();}});}
            else{
               $("#information").ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/admin/clothes.do?act=add",
                    success: function(msg){
                    if(msg=="200"){ymPrompt.alert({title:'��ʾ',message:"�ύ�ɹ�"});
                    $("#clothesName").val('');$("#key").val('');$("#matchValue").val('');
                    }
                    else {ymPrompt.alert({title:'��ʾ',message:"�ύʧ��"});}
                    }                    
                });
                }
            }
</script>
<body class="ContentBody">

<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >����Ա���</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="����" class="button" onclick="doSubmit()"/>��
			
			<input type="button" name="Submit2" value="����" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>����Ա���</legend>
	<form id="information" >
   <table border="0" cellpadding="2" cellspacing="1" align="center" width="50%">

			   
		<tr><td>�˺ţ�</td><td><input type="text" name="thumbAdress" id="thumbAdress" class="text"/></td></tr>
		<tr><td>�������룺</td><td><input type="password" name="imageAdress" id="imageAdress" class="text"/></td></tr>	
		<tr><td>�ٴ��������룺</td><td><input type="password" name="brand" id="brand" class="text"></td></tr>    
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
			<input type="button"  onclick="ajaxSubmit()" value="�ύ" class="button"/>��
			
			<input type="button"  value="����" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>

</div>
</body>
</html>