package com.efit.znxy.utils;

import java.applet.AppletContext;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.efit.znxy.entity.Comment;
import com.efit.znxy.entity.User;
import com.ideatech.common.Globals;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

public class CommonUtil {

	public static String makeHtml(List<Comment> restult) {
		int i;
		StringBuilder par=new StringBuilder();
		if (restult.size()==0) {
			return par.append("<p>沙发空缺中</p>").toString();
		}
		
		for (i = 0; i < restult.size()-1; i++) {
			Comment comment=restult.get(i);
			
			par.append("<div>").append(" <label style='color:#73363c;'>").append(comment.getUsername()).append(":</label>").append("<label>").append("<img src='"+ServletActionContext.getServletContext().getContextPath()+"/star/img/star"+comment.getScore()+".png' />").append("</label>")
			.append("<p>").append(comment.getContent()).append("</p>").append("<p style='color: #9e1c50'>").append(comment.getSubTime())
			.append("</p>").append("</div>").append("<hr style='border:0.5px dashed #334455'/>");
		}
		Comment comment=restult.get(i);
		par.append("<div>").append(" <label style='color:#73363c;'>").append(comment.getUsername()).append(":</label>").append("<label>").append("<img src='"+ServletActionContext.getServletContext().getContextPath()+"/star/img/star"+comment.getScore()+".png' />").append("</label>")
		.append("<p>").append(comment.getContent()).append("</p>").append("<p style='color: #9e1c50'>").append(comment.getSubTime())
		.append("</p>").append("</div>");
		return par.toString();
	}
	public static String makePage(Page page) {
		int pageCount =page. getPageCount();
		int currentPage = page.getCurrentPage();
		StringBuffer sb = new StringBuffer("");
		int pageSize=page.getPageSize();
		sb.append("<div style='line-height:120%;margin:2px;padding:3px'");
		sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'>共 <strong>" + page.getRecordCount() + "</strong> 条记录</li>\n");
		if (currentPage > 1){
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a  href='#' onclick='comment(" + 1+ ")'; style='display:inline;color: #BF2F68;'>首页</a></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a href='#' onclick='comment(" +  (currentPage - 1) + ")'; style='display:inline;color: #BF2F68;'>上一页</a></li>\n");
		} else {
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>首页</font></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>上一页</font></li>\n");
		}
		if (currentPage < pageCount) {
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a  href='#' onclick='comment(" +(currentPage + 1) + ")'; style='display:inline;color: #BF2F68;' >下一页</a></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a  href='#'  onclick='comment(" + pageCount +")'; style='display:inline;color: #BF2F68;'>尾页</a></li>\n");
		} else {
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>下一页</font></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>尾页</font></li>");
		}
		sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'>页次：<strong><font color=red>" + currentPage + "</font>/" + pageCount + "</strong>页</li>\n");
		sb.append("</div>\n");
		return sb.toString();
	}
	 public static String bodyMach(User user){//获得模特的地址
		 MyLog.print("获得模特的地址");
		 HttpSession session=ServletActionContext.getRequest().getSession();
	     User bean= (User) session.getAttribute(Globals.USER_SESSION_KEY);
	  
	     if (bean!=null&&!bean.getHeadAdreess().equals("")) {
	    	 MyLog.print("----------------------------------------------------");
				String bodyPath=GlobalSources.Base_Path+GlobalSources.User_Path+"\\"+bean.getUsername()+"\\"+user.getSex()+user.getT_size()+".png";
				if (!FileUtil.isExists(bodyPath)) {
					if(!FileUtil.isExists(GlobalSources.Base_Path+GlobalSources.User_Path+"\\"+bean.getHeadAdreess()))return "/"+GlobalSources.Syimages_Path+"/"+user.getSex()+user.getT_size()+".jpg";
					FileUtil.createDirectory(GlobalSources.Base_Path+GlobalSources.User_Path+"\\"+bean.getUsername());
					user.setUsername(bean.getUsername());
					user.setHeadAdreess(bean.getHeadAdreess());
					UserActionUtil.saveBodyImage(user);
				}
				return "/"+GlobalSources.User_Path+"/"+bean.getUsername()+"/"+user.getSex()+user.getT_size()+".png";

		}
	     else {
	    	 return "/"+GlobalSources.Syimages_Path+"/"+user.getSex()+user.getT_size()+".jpg";
		}
		
	 }
	 public static String bodyMach(String topSize,String sex){//获得模特的地址
		 MyLog.print("获得模特的地址");
		 HttpSession session=ServletActionContext.getRequest().getSession();
	     User bean= (User) session.getAttribute(Globals.USER_SESSION_KEY);
	  
	     if (bean!=null&&!bean.getHeadAdreess().equals("")) {
	    	 MyLog.print("----------------------------------------------------");
				String bodyPath=GlobalSources.Base_Path+GlobalSources.User_Path+"\\"+bean.getUsername()+"\\"+sex+topSize+".png";
				if (!FileUtil.isExists(bodyPath)) {
					FileUtil.createDirectory(GlobalSources.Base_Path+GlobalSources.User_Path+"\\"+bean.getUsername());
					User user=new User();
					user.setUsername(bean.getUsername());
					user.setHeadAdreess(bean.getHeadAdreess());
					user.setT_size(topSize);
					user.setSex(sex);
					UserActionUtil.saveBodyImage(user);
				}

			         
				return "/"+GlobalSources.User_Path+"/"+bean.getUsername()+"/"+sex+topSize+".png";

		}
	     else {
	    	 return "/"+GlobalSources.Syimages_Path+"/"+sex+topSize+".jpg";
		}
		
	 }
}
