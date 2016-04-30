<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<jsp:include page="common/head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String version = "" + System.currentTimeMillis();
	String contextPath = request.getContextPath();  
    String headerReferer  =request.getHeader("Referer");  
    String basePath = headerReferer.substring(0,headerReferer.indexOf(contextPath)+contextPath.length()+1);  
	
%>
<script src="<%=path%>/js/slides.min.jquery.js"></script>
<link rel="stylesheet" href="<%=path%>/css/global.css">
	<link href="../sycss/css.css" rel="stylesheet" type="text/css" />
	<script src="../js/shiyi.js" type="text/javascript"></SCRIPT>
	<script>
function init(){
deletebutton();
var sex=$("#sex").val();
var bodyPath=$("#bodyPath").val();

if(sex=='M'){
$("#ss_women").css({'display':'none'});
$("#shiyi_men").css({ 'background-image':'url(<%=path%>'+bodyPath+')'});
 }
else{
$("#ss_men").css({'display':'none'});
ss_womendt();
$("#shiyi_women").css({ 'background-image':'url(<%=path%>'+bodyPath+')'});
}
}
	$(function(){
		$('#slides').slides({
			preload: true,
			preloadImage: 'img/loading.gif',

			hoverPause: true
		});
	});
	function wear(sex,tT,tI,name1,dT,dI,name2,tId,dId){
	$("#upperClothes").val(tI);
	$("#downClothes").val(dI);
		$("#tId").val(tId);
	$("#dId").val(dId);
	deletebutton();
	if(sex=='M'){
	xt(5,tI,tT,name1);
	xt(3,dI,dT,'name2');
	}
	else {
	xt(8,tI,tT,name2);
	xt(6,dI,dT,name2);
	}
	ss_xt2();
	} 
function shareSina(){
	var upperClothes=$("#upperClothes").val();
	var downClothes=$("#downClothes").val();
	var bodyPath=$("#bodyPath").val();
	if(upperClothes==''||downClothes==''||bodyPath==''){alert('请穿衣服');return;}
 
 		$.post("<%=request.getContextPath()%>/user/share.do", {'upperClothes': upperClothes,'downClothes': downClothes,'bodyPath':bodyPath,'act': 'shareSina'},function(msg){
        var url= "<%=basePath%>"; 
        window.open("http://service.weibo.com/share/share.php?url="+url+"&appkey=&title=E裳智换&pic=<%=basePath%>share/"+msg+"&ralateUid=&language=");
      //  window.location.href="http://service.weibo.com/share/share.php?url="+url+"&appkey=&title=E裳智换&pic=&ralateUid="+msg+"&language="; 
	  }
	  ); 
 }
 function shareWeb(){
   if(!window.confirm('你确定要分享到网站吗？')){
    return ;
}
	var upperClothes=$("#upperClothes").val();
	var downClothes=$("#downClothes").val();
	var bodyPath=$("#bodyPath").val();
	var tId=$("#tId").val();
	var dId=$("#dId").val();
	if(upperClothes==''||downClothes==''||bodyPath==''){alert('请穿衣服');return;}
 		$.post("<%=request.getContextPath()%>/user/share.do", {'upperClothes': upperClothes,'downClothes': downClothes,'bodyPath':bodyPath,'tId':tId,'dId':dId,'act': 'shareWeb'},function(msg){
         if(msg=='200'){alert("分享成功");}
         else if(msg=='301'){alert("请先登入");}
         else{alert("分享失败");}
	  }
	  ); 
 }
</script>
	<body onload="checkCookie()">
	<input type="hidden"  value="" id="upperClothes"/>
	<input type="hidden"  value="" id="downClothes"/>
	<input type="hidden"  value="" id="tId"/>
	<input type="hidden"  value="" id="dId"/>
	<input type="hidden" id="size" value="<s:property value='#request.topSize' />" /> 
	<input type="hidden" id="sex" value="<s:property value='#request.sex' />" />
	<input type="hidden" id="bodyPath" value="<s:property value='#request.bodyPath' />" />
		<div id="main_container">
			<jsp:include page="common/top.jsp" />
			<div id="main_content">
				<jsp:include page="common/left.jsp" />


				<div id="center_content">

					<div class="title">
						<a href="index.html">主页</a> &lt;&lt; 搜索结果
					</div>

							<s:if test="#request.matchList.size()==0">
							<div id="container"> <font size="20px" color="red">没有找到你要的结果！</font></div>
						    </s:if>
						    <s:else>
						    <!-- 轮显开始 -->
					<div id="container">
						<div id="example">
							<div id="slides">
								<div class="slides_container">

									<s:iterator value="#request.matchList" id="MatchClothes">
										<a href="#" onclick="wear('${MatchClothes.sex}','../clothes/${MatchClothes.tThumbAdress}','../clothes/${MatchClothes.tImageAdress}','${MatchClothes.tName}','../clothes/${MatchClothes.dThumbAdress}','../clothes/${MatchClothes.dImageAdress}','${MatchClothes.dName}','${MatchClothes.tId}','${MatchClothes.dId}')" title="E裳智换">
											<div class="product_box" style="margin-left:0px;  width:570px; height:270px;">
												<div>
													<img
														src="<%=path%>/clothes/${MatchClothes.tThumbAdress}"
														height=250px width="167px" alt="" title=""
														class="prod_image" /> <img
														src="<%=path%>/clothes/${MatchClothes.dThumbAdress}"
														height=250px width="167px" alt="" title=""
														class="prod_image"  /> <span class="product_details">
														<p class="prod_title" style="font-size: 20px;margin-bottom: 10px">${MatchClothes.tName}&${MatchClothes.dName}</p>
														<p><font color="red" style="font-size: 15px">${MatchClothes.tName}(${MatchClothes.tSize}):</font>${MatchClothes.tDetail}</p>
														<p><font color="red" style="font-size: 15px">${MatchClothes.dName}(${MatchClothes.dSize}):</font>${MatchClothes.dDetail}</p>
													</span>
												</div>
											</div> </a>
									</s:iterator>
								</div>
								<a href="#" class="prev"><img
									src="<%=path%>/img/arrow-prev.png" width="24" height="43"
									alt="Arrow Prev">
								</a> <a href="#" class="next"><img
									src="<%=path%>/img/arrow-next.png" width="24" height="43"
									alt="Arrow Next">
								</a>
							</div>
							<img src="<%=path%>/img/example-frame.png" width="739"
								height="341"  id="frame">
						</div>
					</div>

					<!-- 轮显结束 -->
					
					<div align="right">
						<s:property value="#request.pagestr" escape="false" />
					</div>
					</s:else>
				</div>

				<div><jsp:include page="shiyi.jsp" /></div>
				<div class="clear"></div>

				<jsp:include page="common/foot.jsp" />
			</div>

		</div>

		</div>
	</body>
	</html>