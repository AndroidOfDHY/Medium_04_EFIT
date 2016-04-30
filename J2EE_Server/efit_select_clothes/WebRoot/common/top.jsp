<%@page import="com.efit.znxy.entity.User"%>
<%@page import="com.ideatech.common.Globals"%>
<%String path = request.getContextPath();String version=""+System.currentTimeMillis();%>
<div id="header" style="background:url(<%=path%>/images/top_menu_bg.png) no-repeat center;behavior: url(iepngfix.htc);">
    <div class="logo">
    <a href="<%=path %>/index.jsp"><img src="<%=path %>/images/logo.png" width="221" height="91" alt="" title="" border="0" /></a>
    </div>
    
                 <div id="menu_tab">                 
                    <ul class="menu" >     
                                                                                   
                         <li><a href="<%=path %>/index2.jsp" class="nav"> 主页 </a></li>
                         <li><a href="<%=path %>/about.jsp" class="nav"> 资讯潮流 </a></li>                         
                         <li><a href="<%=path %>/user/match.do?act=recommend" class="nav"> 推荐搭配</a></li>
                         <li><a href="<%=path %>/search.jsp" class="nav"> 搭配搜索 </a></li>
                         <li><a href="<%=path %>/contact.jsp" class="nav"> 联系我们 </a></li>
                         <%
                         User user=null;
                         if((user=(User)session.getAttribute(Globals.USER_SESSION_KEY))!=null){
                         out.print("<li><a href='"+path+"/modifyUser.jsp' class='nav'>"+user.getUsername()+"</a></li>  <li><a href='"+path+"/user/user.do?act=quit' class='nav'>退出 </a></li>");
                         }
                         else{
                         out.print("<li><a href='"+path+"/register.jsp' class='nav'> 注册 </a></li><li><a href='"+path+"/login.jsp' class='nav'> 登录 </a></li>");
                         }
                         %>
                         
                    </ul>
            </div>
            

    
    
    </div>
   