<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath()+"/";%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="<%=path %>star/star.css" type="text/css" />
<script language="javascript"  type="text/javascript" src="<%=path %>star/star.js" ></script>
<body>
<style type="text/css">
div#PreviewBox{
  position:absolute;
  padding-left:426px;
  display: none;
  Z-INDEX:2006;
}
div#PreviewBox span{
  width:7px;
  height:13px;
  position:absolute;
  left:0px;
  top:9px;
  background:url() 0 0 no-repeat;
}
div#PreviewBox div.Picture{
  float:left;
  border:1px #666 solid;
  background:#FFF;
}
div#PreviewBox div.Picture div{
  border:4px #e8e8e8 solid;
}
div#PreviewBox div.Picture div a img{
  margin:19px;
  border:1px #b6b6b6 solid;
  display: block;
  max-height: 250px;
  max-width: 250px;
}
</style>
<script language="javascript"> 
function init(){
comment(1);
}
function comment(pageNo){
var shareId=$("#shareId").val();
$("#comments_list").load(<%=path %>+"user/comment.do?act=content&shareId="+shareId+"&page="+pageNo);
}
function loadimage(){ 
$("#randImage").show();
document.getElementById("randImage").src = "<%=path %>/image.jsp?"+Math.random(); 
} 
function submit(){
var yzm =$("#yzm").val();
var shareId=$("#shareId").val();
var content=$("#content").val();
var score=$("#score").val();
if(yzm==''){alert("验证码不能为空");return;}
if(content==''){alert("评论内容不能为空");return;}
if(score==''){alert("请评分");return;}
$.post("<%=request.getContextPath()%>/user/comment.do", {"yzm": yzm,"shareId":shareId,"score": score,"content": content,"act": "save"},function(msg){
if(msg=='200'){alert("评论成功");$("#content").val('');comment(1);}
else if(msg=='300'){alert("评论失败");}
else{alert("验证码错误");}
loadimage();
});
}
var maxWidth=200;
var maxHeight=432;
function getPosXY(a,offset) {
       var p=offset?offset.slice(0):[0,0],tn;
       while(a) {
           tn=a.tagName.toUpperCase();
           if(tn=='IMG') {
              a=a.offsetParent;continue;
           }
          p[0]+=a.offsetLeft-(tn=="DIV"&&a.scrollLeft?a.scrollLeft:0);
          p[1]+=a.offsetTop-(tn=="DIV"&&a.scrollTop?a.scrollTop:0);
          if(tn=="BODY")
                break;
          a=a.offsetParent;
      }
      return p;
}
function checkComplete() {
     if(checkComplete.__img&&checkComplete.__img.complete)
              checkComplete.__onload();
}
checkComplete.__onload=function() {
         clearInterval(checkComplete.__timeId);
         var w=checkComplete.__img.width;
         var h=checkComplete.__img.height;
         if(w>=h&&w>maxWidth) {
              previewImage.style.width=maxWidth+'px';
         }
        else if(h>=w&&h>maxHeight) {
              previewImage.style.height=maxHeight+'px';
        }
        else {
              previewImage.style.width=previewImage.style.height='';
        }
       previewImage.src=checkComplete.__img.src;previewUrl.href=checkComplete.href;checkComplete.__img=null;
}
function showPreview(e) {
         hidePreview (e);
         previewFrom=e.target||e.srcElement;
         previewImage.src=loadingImg;
         previewImage.style.width=previewImage.style.height='';
         previewTimeoutId=setTimeout('_showPreview()',500);
         checkComplete.__img=null;
}
function hidePreview(e) {
        if(e) {
            var toElement=e.relatedTarget||e.toElement;
            while(toElement) {
                  if(toElement.id=='PreviewBox')
                          return;
                  toElement=toElement.parentNode;
            }
       }
       try {
            clearInterval(checkComplete.__timeId);
            checkComplete.__img=null;
            previewImage.src=null;
       }
       catch(e) {}
       clearTimeout(previewTimeoutId);
       previewBox.style.display='none';
}
function _showPreview() {
        checkComplete.__img=new Image();
        if(previewFrom.tagName.toUpperCase()=='A')
               previewFrom=previewFrom.getElementsByTagName('img')[0];
        var largeSrc=previewFrom.getAttribute("large-src");
        var picLink=previewFrom.getAttribute("pic-link");
        if(!largeSrc)
             return;
        else {
             checkComplete.__img.src=largeSrc;
             checkComplete.href=picLink;
             checkComplete.__timeId=setInterval("checkComplete()",20);
             var pos=getPosXY(previewFrom,[106,26]);
             previewBox.style.left=pos[0]+'px';
             previewBox.style.top=pos[1]+'px';
             previewBox.style.display='block';
        }
}

</script>
<div id="main_container">
<jsp:include page="common/top.jsp" />
 
            
            
    <div id="main_content">
    
 <jsp:include page="common/left.jsp" />
        
        <div id="center_content">
        
        <div class="title"><a href="index.html">主页</a> &lt;&lt; 细节</div>

		<div class="product_box_details">
		<a href="####" onmouseover='showPreview(event);' onmouseout='hidePreview(event);' >
	
           <img src="<%=path %>${share.share.sharePath}" large-src="<%=path %>${share.share.sharePath}" pic-link="/" width="144" height="216" alt="" title="" class="prod_image" style="border:0px solid #fc6; " />
        </a>
        <div class="product_details_wide">
        	<div class="prod_title">${share.share.tName}&${share.share.dName}</div>
            <p>分享者：${share.share.userName}</p>
            <p>上身：${share.share.tName}</p>
            <p>下身：${share.share.dName}</p>
             <p>评分：<s:if test='#request.share.score !=null'><img  style="margin-bottom: -7px"src="<%=path %>star/img/${share.score}.png" height="23" width="120"/></s:if></p>
            <p>分享时间：${share.share.shareTime}</p>
            <a style="margin-top: 35px;" href="details.html" class="details"><img src="<%=path %>images/order.gif" alt="" title="" border="0"/></a>
        </div>
        
        </div>
<div id="PreviewBox" onmouseout="hidePreview(event);">
  <div class="Picture" onmouseout="hidePreview(event);">
   <span></span>
   <div>
    <p id="previewUrl" href="#" target="_blank"><img oncontextmenu="return(false)" id="PreviewImage" src="about:blank" border="0" onmouseout="hidePreview(event);" /></p>
   </div>
  </div>
</div>
<script language="javascript" type="text/javascript">
var previewBox = document.getElementById('PreviewBox');
var previewImage = document.getElementById('PreviewImage');
var previewUrl = document.getElementById('previewUrl');
var previewFrom = null;
var previewTimeoutId = null;
var loadingImg = '<%=path %>images/loading.gif';
</script>
        
        
        <div class="title"><img src="<%=path %>images/recommended_title.gif" alt="" title="" /></div> 
        <div style="margin-left:10px">
        <a  href="<%=path %>user/clothes.do?act=detail&page=clothesDetails&clothesId=${share.share.tId}" style="text-decoration : none;"><label class="prod_title" style="font-size: large;">${share.share.tName}</label></a>
        <p>${share.share.tDetail}</p>
         <a  href="<%=path %>user/clothes.do?act=detail&page=clothesDetails&clothesId=${share.share.dId}" style="text-decoration : none;"><label class="prod_title" style="font-size: large;">${share.share.dName}</label></a>
        <p>${share.share.dDetail}</p>
        </div>
        <div class="title"><img src="<%=path %>images/center_divider.gif" alt="" title="" /></div> 
        <hr style="border:0.5px #6F222B solid;"/>
         <div id="comments_list" style="margin-left:10px"></div>
         <hr style="border:0.5px #6F222B solid;margin-bottom: 40px;"/>
         <div  >
       <input type="hidden" value="${share.share.shareId}" id="shareId"/>
         <label class="prod_title">我要评论</label>
         
         <table style="margin-top: 20PX;">
         <tr> <td valign="middle"> <label >请评分：</label ></td><td > <jsp:include page="star/star.jsp" /><input type="hidden" name="score" id="score" value=""/></td></tr>
         <tr><td valign="top"><label >评论内容：</label><td><textarea class="contact_textarea" id="content" name="content" style="width:440px;" ></textarea></td></tr>
         <tr><td>验证码：</td><td><input type="text"  id="yzm" name="yzm" onclick="loadimage()"  class="contact_input" style="width:100px;"/><img  src=""  id="randImage"  height="20" style="margin-left: 10px; display:none;" /></td></tr>
         <tr ><td></td><td><input type="image" src="<%=path %>images/submit.gif" onclick="submit()" /></td></tr>
         </table>
         
          
         </div>
        </div>
    
		<div class="clear"></div>
<jsp:include page="common/foot.jsp" />
    </div>
    
   </div> 


</div>
</body>
</html>