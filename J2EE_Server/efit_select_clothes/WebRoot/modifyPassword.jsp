<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="common/head.jsp" />
<script language="javascript" type="text/javascript">
            function doSubmit(){
         //   if($("#username").val()==''||$("#username").val().length<6){alert("账号为空或长度不够");$("#username").focus();}
         if($("#password").val()==''){alert("填写密码");$("#password").focus();}
         else if($("#newPassword").val()==''){alert("新密码不能为空");$("#newPassword").focus();}
        else if($("#newPassword").val()==$("#password").val()){alert("新旧密码未修改");$("#newPassword").focus();}
          else  if($("#newPassword").val()!=$("#newPassword2").val()){alert("密码不相同");$("#newPassword").focus();}
            else{
               $("#information").ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/user/user.do?act=modifyPassword",
                    success: function(msg){
                       if(msg=='200'){alert("修改成功");}
                       else{alert("修改失败");}
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

				<div class="product_box" >


					<div id="contact_form">
						<form id="information">


							<table style="border-spacing:25px;white-space: nowrap;">
								
							<tr>
									<td>当前密码:</td>
									<td><input class="contact_input" style="width: 140%"
										type="password" name="password" id="password"  /></td>
								</tr>
								
								<tr>
									<td>新密码:</td>
									<td><input class="contact_input" style="width: 140%"
										type="password" name="newPassword" id="newPassword"  /></td>
								</tr>
								<tr>
									<td >确认新密码:</td>
									<td><input class="contact_input" style="width: 140%"
										type="password" name="newPassword2" id="newPassword2"  /></td>
								</tr>

   
							</table>
						</form>
						<table>
							
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