<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath()+"/";%>
<body>

<div id="main_container">
<jsp:include page="common/top.jsp" />
    
 
            
            
    <div id="main_content">
    
     <jsp:include page="common/left.jsp" />
        
        
        <div id="center_content">
        
       <div class="title"><a href="index.html">主页</a> &lt;&lt; 分享搭配</div>
        <s:iterator value="#request.shareList">
		<div class="product_box">
        <img src="<%=path %>${share.sharePath}" width="144" height="216" alt="" title="" class="prod_image" />
        <div class="product_details">
        	<div class="prod_title">${share.tName}&${share.dName}</div>
            <p>分享者：${share.userName}</p>
            <p>上身：${share.tName}</p>
            <p>下身：${share.dName}</p>
             <p>评分：<s:if test='score!=null'><img  style="margin-bottom: -7px"src="<%=path %>star/img/${score}.png" height="23" width="120"/></s:if></p>
            <p>分享时间：${share.shareTime}</p>
           
            
            <a style="margin-top: 35px;" href="share.do?act=details&shareId=${share.shareId}" class="details"><img src="<%=path %>images/details.gif" alt="" title="" border="0"/></a>
        </div>
        </div>
        </s:iterator>

  
       <div class="pagination" align="right">
<s:property value="#request.pagestr" escape="false" /> 
        </div> 
        
        
        </div>
    

   <div class="clear"></div> 
<jsp:include page="common/foot.jsp" />
    </div>
    
    </div>

</div>
</body>
</html>