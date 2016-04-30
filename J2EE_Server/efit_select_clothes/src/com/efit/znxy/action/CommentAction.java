package com.efit.znxy.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.efit.znxy.entity.Comment;
import com.efit.znxy.entity.Share;
import com.efit.znxy.entity.User;
import com.efit.znxy.service.CommentService;
import com.efit.znxy.service.ShareService;
import com.efit.znxy.utils.CommonUtil;
import com.ideatech.common.Globals;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

public class CommentAction extends BaseAction{

	public void save(){//保存评论
		MyLog.print("保存评论");
		User user=(User)getSession().getAttribute(Globals.USER_SESSION_KEY);
		String username=user==null?"匿名":user.getUsername();
		String content=getStrPar("content");
		
		String yzm=getStrPar("yzm");
		int score=getIntPar("score",1);
		
	//	MyLog.print("验证码："+yzm+getSession().getAttribute("rand"));
		String shareId=getStrPar("shareId");
		MyLog.print(content+","+score+","+shareId);
	//	MyLog.print("shareId："+shareId);
	    if (content.equals("")||"".equals(shareId)) {
			return;
		}
	    String rand=(String)getSession().getAttribute("rand");
	    if (rand!=null&&!yzm.equals(rand)) {
	    	MyLog.print("失败");
			sendHtml("301");
			return;
		}
	    String subTime=formatTime(new Date(), "yyyy-MM-dd HH:mm:ss");
	    Comment comment=new Comment();
	    comment.setContent(htmlToString(content));
	    comment.setShareId(shareId);
	    comment.setUsername(username);
	    comment.setSubTime(subTime);
	    comment.setScore(score);
	    MyLog.print("成功");
	    sendHtml(CommentService.save(comment));
	}
	public void content(){
		MyLog.print("评论内容获取");
		StringBuilder par=new StringBuilder("?");
		String shareId=getStrPar("shareId");
		 Map<String, Object>filter = new HashMap<String, Object>();
		 
		 filter.put("shareId", shareId);
		   int pageNo=getPage();
		   int pageSize = 5;
		   MyLog.print("shareId"+shareId+"pageNo"+pageNo);
		   Page page=CommentService.queryPageList(filter,pageNo,pageSize);
		   MyLog.print("数量:"+page.getRecordCount());
		  String details=((List<Comment>)page.getRestult()).size()==0? CommonUtil.makeHtml((List<Comment>)page.getRestult()):CommonUtil.makeHtml((List<Comment>)page.getRestult())+CommonUtil.makePage(page);
		  MyLog.print(details);
		  sendHtml(details);
	}
	/**
	 * 手机获取评论
	 * @throws JSONException 
	 */
	public void androidContent() throws JSONException{
		MyLog.print("评论内容获取");
		StringBuilder par=new StringBuilder("?");
		String shareId=getStrPar("shareId");
		 Map<String, Object>filter = new HashMap<String, Object>();
		 MyLog.print("shareId"+shareId);
		 filter.put("shareId", shareId);
		 int pageNo=getPage();
		   int pageSize = 5;
		   Page page=CommentService.queryPageList(filter,pageNo,pageSize);
		   MyLog.print("数量:"+page.getRecordCount());
		   List<Comment> comments=(List<Comment>) page.getRestult();
	 	    JSONObject jsonResult=new JSONObject();
	  	   JSONArray jsonArray=new JSONArray();
		   for (int i = 0; i < comments.size(); i++) {
			   JSONObject jsonObject=new JSONObject();
			   Comment comment=comments.get(i);
			   jsonObject.put("commentId", comment.getCommentId());
				jsonObject.put("shareId", comment.getShareId());
				jsonObject.put("content", comment.getContent());
				jsonObject.put("username", comment.getUsername());
				jsonObject.put("subTime",comment.getSubTime());
				jsonArray.put(jsonObject);
		  }
		 	jsonResult.put("jsonArray", jsonArray);
		 	 jsonResult.put("recordCount", ""+page.getRecordCount());
		 	   sendHtml(jsonResult.toString());
	}
}
