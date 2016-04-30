package com.efit.znxy.action;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.efit.znxy.dao.CommentDao;
import com.efit.znxy.dao.ShareDao;
import com.efit.znxy.entity.Share;
import com.efit.znxy.entity.User;
import com.efit.znxy.service.ClothesService;
import com.efit.znxy.service.CommentService;
import com.efit.znxy.service.ShareService;
import com.efit.znxy.service.UserService;
import com.efit.znxy.utils.FileUtil;
import com.efit.znxy.utils.GlobalSources;
import com.efit.znxy.utils.ShareActionUtil;
import com.ideatech.common.Globals;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

public class ShareAction extends BaseAction {
	@Override
	public String index() {
		MyLog.print("获取分享");
		 Map<String, Object>filter = new HashMap<String, Object>();
		 int pageNo=getPage();
		   int pageSize = getPageSize();
		   Page page=ShareService.queryPageList(filter,pageNo,pageSize);
		    List<Share>shares=(List<Share>) page.getRestult();
		    List<com.efit.znxy.vo.ShareVo> sharesVO=new ArrayList();
		    for (Share share:shares) {
		      MyLog.print(share.getShareId());
		      com.efit.znxy.vo.ShareVo shareVO=new com.efit.znxy.vo.ShareVo();
			  Integer score=CommentService.queryForScoreAvg(share.getShareId());
			  shareVO.setScore(score);
			  shareVO.setShare(share);
			  sharesVO.add(shareVO);
			}
		setReq("shareList", sharesVO);
		setReq("pagestr",page.getPageStr(getMappingPath()));
		return callMethodTempFile("listShare");
	}
	public void delete(){
		
		 String shareIds=	 getStrPar("shareIds");
		 MyLog.print("删除"+shareIds);
		 String[]shareIdArray= shareIds.split(",");
		    for (int i = 0; i < shareIdArray.length; i++) {
		    	String shareId=shareIdArray[i];
				ShareService.deleteById(shareId);
			}
		    sendHtml("200");
		
	}
	  public void shareSina(){
		  MyLog.print("分享sina微博");
		  String upperClothes=getStrPar("upperClothes");
		  String downClothes=getStrPar("downClothes");
		  String bodyPath=getStrPar("bodyPath");
		  try {
             String imageName= ShareActionUtil.makeBody(upperClothes, downClothes, bodyPath,GlobalSources.Share_Path);
					sendHtml(imageName);
				} catch (IOException e) {
					e.printStackTrace();
					sendHtml("");
				}
				
		      
	  }
	  public void shareWeb(){
		  MyLog.print("分享web");
		  String upperClothes=getStrPar("upperClothes");
		  String downClothes=getStrPar("downClothes");
		  String bodyPath=getStrPar("bodyPath");
		  String tId=getStrPar("tId");
		  String dId=getStrPar("dId");
		 User user=( User)getSession().getAttribute(Globals.USER_SESSION_KEY);
		  if(user==null){
			  sendHtml("301");return;
		  }
		  Share share=new Share(ClothesService.findById(tId),ClothesService.findById(dId));
		  share.setUserId(user.getUserId());
		  share.setUserName(user.getUsername());
		  share.setShareTime(formatTime(new Date()));
		  share.setShareId(FileUtil.randomFileName());
		  try {
             String imageName= ShareActionUtil.makeBody(upperClothes, downClothes, bodyPath,GlobalSources.Share_Path);
             share.setSharePath(GlobalSources.Share_Path+"/"+imageName);
					sendHtml(ShareService.save(share));
				} catch (IOException e) {
					e.printStackTrace();
					sendHtml("300");
				}
	  }
	  public String details(){
		  MyLog.print("详细信息");
		  String shareId=getStrPar("shareId");
		  Share share=ShareService.findById(shareId);
		  com.efit.znxy.vo.ShareVo shareVo=new com.efit.znxy.vo.ShareVo();
		  shareVo.setShare(share);
		  shareVo.setScore(CommentService.queryForScoreAvg(shareId));
		  setReq("share", shareVo);
		  return callMethodTempFile("shareDetails");
	  }
	  /**
	   *获取手机分享列表
	 * @throws JSONException 
	   */
		public void androidShareList() throws JSONException {
			 Map<String, Object>filter = new HashMap<String, Object>();
			 int pageNo=getIntPar("pageNo", 1);
			   int pageSize = getPageSize();
			   Page page=ShareService.queryPageList(filter,pageNo,pageSize);
			   List<Share>shareList=(List<Share>)page.getRestult();
		 	    JSONObject jsonResult=new JSONObject();
		  	   JSONArray jsonArray=new JSONArray();
               for (int i = 0; i < shareList.size(); i++) {
            	   JSONObject jsonObject=new JSONObject();
            	   Share share=shareList.get(i);
            	Integer score=CommentService.queryForScoreAvg(share.getShareId());
           		jsonObject.put("shareId", share.getShareId());
        		jsonObject.put("userId", share.getUserId());
        		jsonObject.put("userName", share.getUserName());
        		jsonObject.put("sharePath", share.getSharePath());
        		jsonObject.put("shareTime", share.getShareTime());
        		jsonObject.put("tId", share.gettId());
        		jsonObject.put("tName", share.gettName());
        		jsonObject.put("tDetail", share.gettDetail());
        		jsonObject.put("dId", share.getdId());
        		jsonObject.put("dName", share.getdName());
        		jsonObject.put("dDetail", share.getdDetail());
        		jsonObject.put("score", score+"");
        		jsonArray.put(jsonObject);
			   }
               jsonResult.put("jsonArray", jsonArray);
               jsonResult.put("recordCount", ""+page.getRecordCount());
               sendHtml(jsonResult.toString());
		}
}
