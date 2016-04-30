<%@ taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<%@ page contentType="text/html" language="java" import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
  $("#type").val('${clothes.type}');
  $("#sex").val('${clothes.sex}');
  $("#size").val('${clothes.size}');
});
function mdifyName(name){
 $("#upName").val(name);
}
</script>
<div class="pageContent">
	<form method="post" action="admin/clothes.do?act=modify"   class="pageForm required-validate" onsubmit="iframeCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="100" style="width: 80%">
			<p>
				<label>服装编号：</label>
				<input id="clothesId" name="clothesId"  type="text" size="30" value="${clothes.clothesId}"  readonly="readonly"/>
			</p>
			<p>
				<label>服装名称：</label>
				<input  name="clothesName" id="clothesName" class="required" type="text" size="30" value="${clothes.clothesName}" alt="请输入服装名称"/>
			</p>
			<p>
				<label>服装类型：</label>
				<select name="type" id="type" class="required combox">
				   <option value="T">上装</option>
			       <option value="D">下装</option>
				</select>
			</p>
             <p>
				<label>性别：</label>
				<select name="sex" id="sex" class="required combox">
			   <option  value="M">男</option>
			   <option value="W">女</option>
			    <option value="A">通用</option>
				</select>
			</p>
			 <p>
				<label>尺寸：</label>
				<select name="size" id="size" class="required combox">
			   <option value="s">s</option>
			   <option value="w">w</option>
				</select>
			</p>
			
			<p>
			    <input id="upName" type="hidden" value="">
				<label>缩略图：</label>
				<input class="required" type="text"  class="required" name="thumbAdress" id="thumbAdress" value="${clothes.thumbAdress}" readonly="readonly"/>
				<!--  <input type="text" class="required" name="orgLookup.orgName" value="" suggestFields="orgNum,orgName" suggestUrl="demo/database/db_lookupSuggest.html" lookupGroup="orgLookup" />-->
				<a class="btnLook" onclick="mdifyName('thumbAdress')" href="fileload.jsp" target="dialog"  rel="dlg_page1" title="上传" width="410" height="150">查找带回</a>		
			</p>
			<p>
				<label>效果图：</label>
				<input class="required" type="text"  class="required" name="imageAdress" id="imageAdress" value="${clothes.imageAdress}" readonly="readonly"/>
				<!--  <input type="text" class="required" name="orgLookup.orgName" value="" suggestFields="orgNum,orgName" suggestUrl="demo/database/db_lookupSuggest.html" lookupGroup="orgLookup" />-->
				<!-- <a class="btnLook" href="fileload.jsp" lookupGroup="orgLookup">查找带回</a>	 -->
				<span><a class="btnLook" onclick="mdifyName('imageAdress')" href="fileload.jsp" target="dialog"  rel="dlg_page1" title="上传" width="410" height="150">上传</a></span>
				
			</p>
			
			
			<dl class="nowrap">
				<dt>关键字：</dt>
				<dd><textarea class="required" rows="5" name="key" id="key"   cols="50" id="key" >${clothes.keyword}</textarea></dd>
			</dl>
			<p>
				<label>匹配值：</label>
				<input class="required" name="matchValue" id="matchValue" value="${clothes.matchValue}" onkeyup="value=value.replace(/[^\d]/g,'')"  class="digits" type="text" size="30" alt="请输入数字"/>
			</p>
			
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
