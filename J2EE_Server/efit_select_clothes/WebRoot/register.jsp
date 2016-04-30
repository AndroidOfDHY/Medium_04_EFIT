<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="common/head.jsp" />
<script language="javascript" type="text/javascript">
            function doSubmit(){
            if($("#username").val()==''||$("#username").val().length<6){alert("账号为空或长度不够");$("#username").focus();}
             else if($("#password").val()==''){alert("填写密码");$("#password").focus();}
             else if($("#password").val()!=$("#password2").val()){alert("密码不相同");$("#password").focus();}
            else{
               $("#information").ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/user/user.do?act=register",
                    success: function(msg){
                       if(msg=='200'){window.location.href="login.jsp";}
                       else{alert("账号已经存在");}
                    }
                });
                }
            }
  function showDlog(){
  var imageUrl=window.showModalDialog("pz/pz.jsp",'',"dialogWidth=760px;dialogHeight=418px");
  $("#headAdreess").val(imageUrl);
  $("#image").attr("src",imageUrl);
  }
        </script>

<body>

	<div id="main_container">
		<jsp:include page="common/top.jsp" />




		<div id="main_content">

			<jsp:include page="common/left.jsp" />


			<div id="center_content">

				<div class="title">
					<img src="images/contact_title.gif" alt="" title="" />
				</div>

				<div class="product_box" style="width: 620px;">


					<div id="contact_form" style="margin-left: 120px;">
						<form id="information">


							<table style="border-spacing:25px;">
								<tr>
									<td>账号:</td>
									<td><input class="contact_input" style="width: 97%"
										type="text" name="username" id="username" /></td>
								</tr>
								<tr>
									<td>密码:</td>
									<td><input class="contact_input" style="width: 97%"
										type="password" name="password" id="password"  /></td>
								</tr>
								<tr>
									<td>确认密码:</td>
									<td><input class="contact_input" style="width: 97%"
										type="password" name="password2" id="password2"  /></td>
								</tr>
								<tr>
									<td>头像:</td>
									<td>  
									<img  id="image" src="images/head.png" alt="头像" width="84" height="81" onclick="showDlog()"/>
									 <input type="hidden" name="headAdreess" id="headAdreess" />
								</tr>


								<tr>
									<td>性别:</td>
									<td><select class="center_select" name="sex" id="sex">
											<option value="M">男</option>
											<option value="W">女</option>
									</select></td>
								</tr>
								<tr>
									<td>上身尺寸:</td>
									<td><select name="topSize" id="topSize">
											<option value="s">S</option>
											<option value="m">M</option>
											<option value="l">L</option>
									</select></td>
								</tr>
								<tr>
								<td>下身尺寸:</td>
								<td><select name="downSize" id="downSize">
										<option value="s">S</option>
										<option value="m">M</option>
										<option value="l">L</option>
								</select></td>
								</tr>

							</table>
						</form>
						<table style="margin-left: 150px;">
							<tr>
								<td colspan="2"><input type="image" onclick="doSubmit()"
									src="images/submit.gif" class="contact_submit" />
								</td>
							</tr>
						</table>

					</div>



				</div>





			</div>


			<div class="clear"></div>

			<jsp:include page="common/foot.jsp" />

		</div>

	</div>
</body>
</html>