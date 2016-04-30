<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" pageEncoding="GBK"%>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<link href="<%=path %>/admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/admin/css/css.css" rel="stylesheet" type="text/css" />
<jsp:include page="head.jsp"/>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script language="javascript" type="text/javascript">
var contentPath = '<%=request.getContextPath()%>';
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

function link(){
    document.getElementById("fom").action="yuangong.htm";
   document.getElementById("fom").submit();
}
function deleteSelect()
{
var checkbox = $('input[name="delid"]');
		var idsStr = new Array();
		
		for(var idx=0;idx<checkbox.length;idx++){
			var cbd = $(checkbox[idx]);
			
			if(cbd.attr("checked")){
				idsStr.push(cbd.val());

			}
		}
		if(idsStr.length == 0) {
			ymPrompt.alert({title:'提示',message:'请选择要删除的!',autoClose:true});
			return ;
		}
		
		var ids = idsStr.join(",");
		
	ymPrompt.confirmInfo({title:'删除记录',message:'<font color="red">是否删除此条记录？</font>',width:220,height:150,handler:
	function(tp){
	if(tp=='ok'){
		$.post("<%=request.getContextPath()%>/admin/user.do", {"userIds": ids, "act": "delete"}, function(msg){
				if(msg == '200') {
					ymPrompt.succeedInfo({title:'succeed',message:'删除成功',width:220,height:150,handler:function(){window.location.reload();}});	
				} else {
					ymPrompt.errorInfo({title:'error',message:'删除失败',width:220,height:150});
				}
			});
	;}else{}}}); 
}
function searchTime(){
  var startTime=$('#startTime').val();
  var endTime=$('#endTime').val();
 if(startTime == '' ||endTime==''){
 ymPrompt.errorInfo({title:'error',message:'<font color="red">开始时间和结束时间不能为空</fon>',width:260,height:150});
  }
  else if(startTime>endTime){
  ymPrompt.errorInfo({title:'error',message:'<font color="red">开始时间不能大于结束时间</fon>',width:260,height:150});
  }
  else {
   window.location.href=contentPath+'/admin/problem.do?'+'startTime='+startTime+'&endTime='+endTime;
  }
 }
</script>
</head>


<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="<%=path %>/admin/images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="<%=path %>/admin/images/ico07.gif" width="20" height="18" /></td>
			  <td width="519"><select name="select2">
				    <option>按录入时间</option>
			      </select>
			   <input  type="text" size="12"  onFocus="WdatePicker({lang:'zh-cn'})" readonly="true" id="startTime" name="startTime"/><span class="newfont06">至</span>
			   <input  type="text" size="12" readonly="readonly" onFocus="WdatePicker({lang:'zh-cn'})"id="endTime" name="endTime"/>	
			   <input name="Submit" type="button" class="right-button02" value="查 询"  onclick="searchTime()"/></td>
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" value="删除所选" onclick="deleteSelect()" /> 
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="6" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 衣物列表 &nbsp;</td>
                    </tr>
                  <tr>
                  <td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
				    <td width="9%" align="center" bgcolor="#EEEEEE">用户名</td>
					 <td width="9%"  align="center" bgcolor="#EEEEEE">头像</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">性别</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">上身尺寸</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">下身尺寸</td>
                   
                  </tr>
                   <s:iterator value="#request.userList" >
                  <tr>
				    <td  align="center" bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="<s:property value='userId'/>"/></td>
                    <td align="center" bgcolor="#FFFFFF"><s:property value="username" /></td>
                    <td align="center" bgcolor="#FFFFFF"><img src="<%=path %>/<s:property value="headAdreess" />" width="100" height="100" onerror="this.src='<%=path %>/system/null.jpg'"/></td>
                    <td align="center" bgcolor="#FFFFFF"><s:property value="sex" /></td>
                    <td align="center" bgcolor="#FFFFFF"><s:property value="t_size" /></td>
                    <td align="center" bgcolor="#FFFFFF"><s:property value="d_size" /></td>
                 
                  </tr>
                  </s:iterator>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="<%=path %>/admin/images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%" align="right"><s:property value="#request.pagestr" escape="false"/></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
</body>
</html>
