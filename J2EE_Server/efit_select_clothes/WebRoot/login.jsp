<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<jsp:include page="common/head.jsp" />
<script language="javascript" type="text/javascript">
            function doSubmit(){
            if($("#username").val()==''){alert("填写账号");$("#username").focus();}
             else if($("#password").val()==''){alert("填写密码");$("#password").focus();}
            else{
               $("#information").ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/user/user.do?act=login",
                    success: function(msg){
                       if(msg=='200'){window.location.href="${pageContext.request.contextPath}/search.jsp";}
                       else if(msg=='301'){alert("账号不存在");}
                       else {alert("密码错误");}
                    }
                });
                }
            }
        </script>
<body>
<div id="main_container">

<jsp:include page="common/top.jsp" />
    
 
            
            
    <div id="main_content">
    <jsp:include page="common/left.jsp" />

        
        <div id="center_content">
        
        <div class="title"><img src="<%=path %>/images/contact_title.gif" alt="" title="" /></div>
        
		<div class="product_box" style="width: 620px;">

        
		        <div id="contact_form" style="margin-left: 120px;">
                     						<form id="information">


							<table style="border-spacing:25px;" >
								<tr>
									<td>账号:</td>
									<td><input class="contact_input" style="width: 180%"
										type="text" name="username" id="username" /></td>
								</tr>
								<tr>
									<td>密码:</td>
									<td><input class="contact_input" style="width: 180%"
										type="password" name="password" id="password" /></td>
								</tr>

							</table>
						</form>
						<table style="margin-left: 160px;">
							<tr>
								<td colspan="2"><input type="image" onclick="doSubmit()"
									src="<%=path %>/images/submit.gif" class="contact_submit" />
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
</html>