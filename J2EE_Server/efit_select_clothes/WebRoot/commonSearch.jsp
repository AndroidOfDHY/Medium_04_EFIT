<jsp:include page="common/head.jsp" />
<script language="javascript" type="text/javascript">
            function doSubmit(){
               $("#information").submit();
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

				<div class="product_box">


					<div id="contact_form"  >
					<form  id="information" action="${pageContext.request.contextPath}/user/clothes.do?act=getClothes" method="post">

					
						<table  style="border-spacing:25px; ">
							<tr >
								<td>性别:</td>
								<td >
								<select   class="center_select" name="sex" id="sex">
								        <option value="">所有</option>
										<option value="M">男</option>
										<option value="W">女</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>类型:</td>
								<td><select  name="type"
									id="type">
									    <option value="">所有</option>
										<option value="T">上身</option>
										<option value="D">下身</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>尺寸:</td>
								<td><select  name="size"
									id="size">
									    <option value="">所有</option>
										<option value="s">S</option>
										<option value="m">M</option>
										<option value="l">L</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>关键字:</td>
								<td><input  class="contact_input" style="width: 97%" type="text" name="searchKey" id="searchKey" />
								</td>
							</tr>
						</table>
					</form>
					
						<table>
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