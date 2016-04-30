<jsp:include page="common/head.jsp" />
<script language="javascript" type="text/javascript">
   function init(){
   $.post("<%=request.getContextPath()%>/user/user.do", {'act': 'userDetails'},function(msg){
     var data= eval('(' + msg + ')');
     if(data.status=='200'){
     $("#sex").val(data.sex);
     $("#downSize").val(data.downSize);
     $("#topSize").val(data.topSize);
     }
    
   });
    $("#keywords").load('<%=request.getContextPath()%>/user/match.do?act=getKeywords');
   }
function setKeyword(keyword){$('#key').val(keyword)}
            function doSubmit(){
            if($("#key").val()==''){alert("填写关键字");$("#key").focus();}
            else{
               $("#information").submit();
                }
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


					<div id="contact_form"  style="margin-left: 120px;">
					<form  id="information" action="${pageContext.request.contextPath}/user/match.do?act=match" method="post">

					
						<table  style="border-spacing:25px; ">
							<tr >
								<td>性别:</td>
								<td >
								<select   class="center_select" name="sex" id="sex">
										<option value="M">男</option>
										<option value="W">女</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>上身尺寸:</td>
								<td><select  name="topSize"
									id="topSize">
										<option value="s">S</option>
										<option value="m">M</option>
										<option value="l">L</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>下身尺寸:</td>
								<td><select  name="downSize"
									id="downSize">
										<option value="s">S</option>
										<option value="m">M</option>
										<option value="l">L</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>关键字:</td>
								<td><input  class="contact_input" style="width: 97%" type="text" name="key" id="key" />
								</td>
							</tr>
							
							<tr>
								<td colspan="2" id="keywords" ></td>
							</tr>
						</table>
					</form>
					
						<table style="margin-left: 150px;">
						<tr><td colspan="2"><input type="image" onclick="doSubmit()"
								src="images/submit.gif" class="contact_submit" /></td>
								</tr>
						</table>
					</div>



				</div>

			</div>

           
			<div class="clear"></div>

			<jsp:include page="common/foot.jsp" />

		</div>

	</div>
	</div>
</body>
</html>