<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%request.setCharacterEncoding("utf-8"); %>
<jsp:include page="common/head.jsp" />
<body>

	<div id="main_container">
		<jsp:include page="common/top.jsp" />




		<div id="main_content">

			<jsp:include page="common/left.jsp" />



			<div id="center_content">

				<div class="title">
					<img src="images/contact_title.gif" alt="" title="" />
				</div>

				<div class="product_box" style="width: 500px;">


					<div id="contact_form" >
						<table style="border-spacing:25px;">
							<tr>
								<td><label class="contact_form">服装编号:</label>
								</td>
								<td><input type="text" name="user" class="contact_input" value="<%=
								request.getParameter ("clothesId")
								%>"/>
								</td>
							</tr>
							<tr>
								<td><label class="contact_form">姓名:</label>
								</td>
								<td><input type="text" name="user" class="contact_input" />
								</td>
							</tr>
							<tr>
								<td><label class="contact_form">电话:</label>
								</td>
								<td><input type="text" name="payuity" class="contact_input" />
								</td>
							</tr>
							<tr>
								<td><label class="contact_form">收件地址:</label>
								</td>
								<td><textarea class="contact_textarea" name="text"></textarea>
								</td>
							</tr>
						</table>

						<input type="image" src="images/submit.gif" class="contact_submit" />

					</div>



				</div>





			</div>


			<div class="clear"></div>
			<jsp:include page="common/foot.jsp" />

		</div>

	</div>
</body>
</html>