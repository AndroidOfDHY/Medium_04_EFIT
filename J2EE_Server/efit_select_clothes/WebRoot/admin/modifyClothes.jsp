<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" pageEncoding="GBK"%>
<link rel="stylesheet" rev="stylesheet" href="<%=path %>/admin/css/style.css" type="text/css" media="all" />
<jsp:include page="head.jsp"/>

</head>
<script language="javascript" type="text/javascript">
  function init(){
  $("#type").val('${clothes.clothes.type}');
  $("#sex").val('${clothes.clothes.sex}');
  $("#size").val('${clothes.clothes.size}');
  }
           function uploadFrame(obj){
              	ymPrompt.win({title:'�ϴ�ͼƬ',
			message:"<form id='tijiao' value='"+obj+"'  enctype='multipart/form-data' method='post'>�ļ�:<input type='file' id='image' class='text' name='image'></form>",width:300,height:100,
			btn:[['�ύ','yes'],['�ر�','no']],handler: myhandler,autoClose:false});
           }
              function myhandler(tp){
              if(tp=='yes'){
              if($('#image').val()==''){return;}
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
                    url: "${pageContext.request.contextPath}/admin/clothes.do?act=modify",
                    success: function(msg){
                    if(msg=="200"){ymPrompt.alert({title:'��ʾ',message:"�޸ĳɹ�"});
                    }
                    else {ymPrompt.alert({title:'��ʾ',message:"�޸�ʧ��"});}
                    }                    
                });
                }
            }
</script>
<body class="ContentBody">

<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >��װ��Ϣ�޸�</th>
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
				<legend>��װ��Ϣ�޸�</legend>
	<form id="information" >
   <table border="0" cellpadding="2" cellspacing="1" align="center" width="50%">
   <input type="hidden" value="${clothes.clothes.clothesId}" id="clothesId" name="clothesId"/>
 <tr><td>��װ���ƣ�</td><td><input type="text" name="clothesName" value="${clothes.clothes.clothesName}" id="clothesName" class="text"/></td>
       <tr><td>��װ���ͣ�</td><td>  
        <select name="type" id="type">
			   <option value="T">��װ</option>
			   <option value="D">��װ</option>
			   </select></td></tr>
			   
	   <tr><td>�Ա�</td><td>  
        <select name="sex" id="sex" tabindex="">
			   <option  value="M">��</option>
			   <option value="W">Ů</option>
			    <option value="A">ͨ��</option>
			   </select></td></tr>
			   
       <tr><td>�ߴ磺</td><td><select name="size" id="size" s>
			   <option value="s">s</option>
			   <option value="m">m</option>
			   <option value="l">l</option>
			   </select></td></tr>
			   
		<tr><td>����ͼ��</td><td><input onclick="" type="text" name="thumbAdress" id="thumbAdress" value="${clothes.clothes.thumbAdress}" readonly="readonly" class="text"/><a href="#" onclick="uploadFrame('thumbAdress')">�ϴ�</a></td></tr>
		<tr><td>ͼƬ��</td><td><input type="text" name="imageAdress" id="imageAdress" value="${clothes.clothes.imageAdress}" readonly="readonly" class="text"/><a href="#" onclick="uploadFrame('imageAdress')">�ϴ�</a></td></tr>
		<tr><td>Ʒ�ƣ�</td><td><input name="brand" id="brand" class="text" value="${clothes.clothes.brand}"></td></tr> 
		<tr><td>��̨����λ�ã�</td><td><input name="position" id="position" class="text" value="${clothes.clothes.position}"></td></tr> 	
		<tr><td>�ؼ��֣�</td><td><textarea rows="5" name="key" id="key" class="text"  cols="50" name="input" id="input" >${clothes.clothes.keyword}</textarea></td></tr>
		<tr><td>��飺</td><td><textarea rows="5" name="detail" id="detail" class="text" cols="50" name="input" id="input" >${clothes.clothes.detail}</textarea></td></tr>
		<tr><td>ƥ��ֵ��</td><td><input name="matchValue" id="matchValue" class="text" value="${clothes.clothes.matchValue}" onkeyup="value=value.replace(/[^\d]/g,'')"></td></tr>      
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