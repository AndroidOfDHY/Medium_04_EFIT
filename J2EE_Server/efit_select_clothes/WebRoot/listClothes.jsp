<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="common/head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath() + "/";
%>
<body>

	<div id="main_container">
		<jsp:include page="common/top.jsp" />




		<div id="main_content">

			<jsp:include page="common/left.jsp" />


			<div id="center_content">

				<div class="title">
					<a href="index.html">主页</a> &lt;&lt; 分享搭配
				</div>
				<s:iterator value="#request.clothesList" id="Clothes">

					<div class="product_box">
						<img
							src="<%=path%>clothes/<s:property value='#request.clothes.thumbAdress '/>"
							width="144" height="216" alt="" title="" class="prod_image" />
						<div class="product_details">
							<div class="prod_title" style="margin-bottom: 10px;">
								<s:property value='#request.clothes.clothesName ' />
							</div>
							<p>
								类型：
								<s:if test='clothes.type=="T"'>上身</s:if>
								<s:else>下身</s:else>
							</p>
							
							<p>
								性别：
								<s:if test='clothes.sex=="M"'>男</s:if>
								<s:else>女</s:else>
							</p>
							<p>
								尺寸：
								<s:property value='#Clothes.clothes.size'/>
							</p>
							<p>
								品牌：
								<s:property value='#Clothes.clothes.brand'/>
							</p>
							 <p>评分：<s:if test='score!=null'><img  style="margin-bottom: -7px"src="<%=path %>star/img/<s:property value='#Clothes.score'/>.png" height="23" width="120"/></s:if></p>
							<p>上市时间：<s:property value='#request.clothes.submitTime' /></p>
							<a style="margin-top: 0px;"
								href="clothes.do?act=detail&page=clothesDetails&clothesId=<s:property value='#Clothes.clothes.clothesId'/>"
								class="details"><img src="<%=path%>images/details.gif"
								alt="" title="" border="0" />
							</a>
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