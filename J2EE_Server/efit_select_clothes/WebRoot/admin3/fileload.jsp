

<script language="javascript" type="text/javascript">
function uploadAjaxDone(json){
     //DWZ.ajaxDone(json);
      if (json.statusCode == DWZ.statusCode.ok){
     $("#"+$("#upName").val()).val(json.message);
           alertMsg.correct('上传成功！');
      }
      else alertMsg.error('上传失败！');
  $.pdialog.closeCurrent();
}
</script>

	<form method="post" action="fileUpload.do?act=upLaod" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="iframeCallback(this,uploadAjaxDone);">
		<div class="pageFormContent" layoutH="56" >
			<p>
				<label>图片上传：</label>
				<input type="file" name="image" />
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
