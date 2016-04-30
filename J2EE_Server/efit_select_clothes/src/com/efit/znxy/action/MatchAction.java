package com.efit.znxy.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.efit.znxy.entity.MatchClothes;
import com.efit.znxy.entity.Search;
import com.efit.znxy.entity.User;
import com.efit.znxy.service.MatchService;
import com.ideatech.common.Globals;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;
import com.efit.znxy.utils.GlobalSources;
import com.efit.znxy.utils.ShareActionUtil;
import com.efit.znxy.utils.CommonUtil;
/**
 * 
 * @author 池超凡
 * @time 2013-1-19 
 * @功能 匹配
 */
public class MatchAction extends BaseAction{
  public String match()
  {
	  StringBuffer par=new StringBuffer("?");
	  Map<String, Object>filter = new HashMap<String, Object>();
	  String topSize= getStrPar("topSize");
	  String downSize= getStrPar("downSize");
	  String sex=getStrPar("sex");
	 String key=  decodeURL(getStrPar("key"));
	   User user=new User();
	    user.setT_size(topSize);
	    user.setSex(sex);
		par.append("act=match&topSize="+topSize).append("&downSize="+downSize);
		par.append("&key=").append(key==null ? "" : encodeURL(key));
		par.append("&sex="+sex);
		filter.put("topSize", topSize);
		filter.put("downSize", downSize);
		filter.put("key",key);
		filter.put("sex",sex);
	 
	    int pageNo= getIntPar("page", 1);
	    int pageSize=getIntPar("pageSize", 7);
	    
	    Page page=MatchService.queryPageList(filter,pageNo,pageSize);
	   List<MatchClothes>matchList= (List<MatchClothes>) page.getRestult();
	    setReq("matchList",matchList);
	    setReq("pagestr",page.getPageStr(getMappingPath() + par));
	    MyLog.print(topSize+"");
	    setReq("topSize",topSize);
	    setReq("sex",sex);
	    setReq("bodyPath", CommonUtil.bodyMach(user));
	    
	    if (matchList.size()!=0) {
	    	User bean= (User) getSession().getAttribute(Globals.USER_SESSION_KEY);
		    Search search=new Search();
		    search.setUsername( bean==null?"匿名":bean.getUsername());
		    search.setKeyword(key);
		    search.setSubTime(formatTime(new Date(), "yyyy-MM-dd HH:mm:ss"));
		    MatchService.save(search);
		}

	  return callMethodTempFile("listSearch");
  }
  
 
  /**
   * 推荐
   * @return
   */
   public String recommend(){
	  MyLog.print("推荐");
	  User user= (User) getSession().getAttribute(Globals.USER_SESSION_KEY);
	  String username=user==null?"匿名":user.getUsername();
      
      String keyword=MatchService.findKeyword(username);
      
      if (user!=null) {
    	  setReq("bodyPath", CommonUtil.bodyMach(user));
    	  MyLog.print(CommonUtil.bodyMach(user));
  	    setReq("sex",user.getSex());
	}
      if (keyword!=null) {
    	  Map<String, Object>filter = new HashMap<String, Object>();
    	  MyLog.print(keyword);
    	  filter.put("key",keyword);
    	  if (user!=null) {
    		  filter.put("topSize", user.getT_size());
      		  filter.put("downSize", user.getD_size());
      		  filter.put("sex",user.getSex());
		}
  	
    	  int pageNo= getIntPar("page", 1);
    	  int pageSize=getIntPar("pageSize", 7);
    	  Page page=MatchService.queryPageList(filter,pageNo,pageSize);
    	   List<MatchClothes>matchList= (List<MatchClothes>) page.getRestult();
    	    setReq("matchList",matchList);
    	    MyLog.print(getMappingPath());
    	    MyLog.print("获取的数量："+matchList.size());
    	    setReq("pagestr",page.getPageStr(getMappingPath()+"?act=recommend"));
	}
      else  setReq("matchList",null);
      
	return callMethodTempFile("listRecommend");
   }
   public void getKeywords(){
	   MyLog.print("获取关键字");
	   StringBuffer par=new StringBuffer("");
	   Map<String, Object>filter = new HashMap<String, Object>();
	   filter.put("limit", 5);
	   List<String>keywordList=  MatchService.findKeywords(filter);
	for (int i = 0; i < keywordList.size(); i++) {
		String keyword=keywordList.get(i);
		par.append("<a href='#'style='text-decoration:none; margin-left: 25px;' onclick=\"setKeyword('"+keyword+"')\">");
		par.append(keyword);
		par.append("<a>");
	}
	MyLog.print(par.toString());
	sendHtml(par.toString());
   }
   /**
    * 手机匹配
 * @throws JSONException 
    */
   public void androidMatch() throws JSONException
   {
 	  StringBuffer par=new StringBuffer("?");
 	  Map<String, Object>filter = new HashMap<String, Object>();
 	  String topSize= getStrPar("topSize");
 	  String downSize= getStrPar("downSize");
 	  String sex=getStrPar("sex");
 	 String key=  decodeURL(getStrPar("keyword"));
 	 
 	   User user=new User();
 	    user.setT_size(topSize);
 	    user.setSex(sex);
 		par.append("act=match&topSize="+topSize).append("&downSize="+downSize);
 		par.append("&key=").append(key==null ? "" : encodeURL(key));
 		par.append("&sex="+sex);
 		filter.put("topSize", topSize);
 		filter.put("downSize", downSize);
 		filter.put("key",key);
 		filter.put("sex",sex);
 	 
 	    int pageNo= getIntPar("pageNo", 1);
 	    int pageSize=getIntPar("pageSize", 7);
 	    
 	    Page page=MatchService.queryPageList(filter,pageNo,pageSize);
 	   List<MatchClothes>matchList= (List<MatchClothes>) page.getRestult();
 	    JSONObject jsonResult=new JSONObject();
 	   JSONArray jsonArray=new JSONArray();
 	   for (int i = 0; i < matchList.size(); i++) {
		JSONObject jsonObject=new JSONObject();
		 MatchClothes clothes=  matchList.get(i);
		jsonObject.put("tId", clothes.gettId());
		jsonObject.put("tName", clothes.gettName());
		jsonObject.put("tSize", clothes.gettSize());
		jsonObject.put("tDetail", clothes.gettDetail());
		jsonObject.put("tThumbAdress", clothes.gettThumbAdress());
		jsonObject.put("tImageAdress", clothes.gettImageAdress());
		jsonObject.put("dId", clothes.getdId());
		jsonObject.put("dName", clothes.getdName());
		jsonObject.put("dSize", clothes.getdSize());
		jsonObject.put("dDetail", clothes.getdDetail());
		jsonObject.put("dThumbAdress", clothes.getdThumbAdress());
		jsonObject.put("dImageAdress", clothes.getdImageAdress());
		jsonObject.put("sex", clothes.getSex());
		jsonArray.put(jsonObject);
	  }
 	   
 	 jsonResult.put("jsonArray", jsonArray);
 	 jsonResult.put("recordCount", ""+page.getRecordCount());
 	   sendHtml(jsonResult.toString());
   }
   /**
    * 穿衣服
    */
   public void androidWear(){
	   MyLog.print("穿衣服");
		  String upperClothes=getStrPar("upperClothes");
		  String downClothes=getStrPar("downClothes");
		  String sex=getStrPar("sex");
		  String topSize= getStrPar("topSize");
		   User user=new User();
		   MyLog.print(topSize+sex);
		    user.setT_size(topSize);
		    user.setSex(sex);
		   String bodyPath=  CommonUtil.bodyMach(user);
		    try {
		    	String savePath=GlobalSources.Android_Wear_Path;
				String imageName= ShareActionUtil.makeBody(upperClothes, downClothes, bodyPath,savePath);
				sendHtml(savePath.replace(File.separator, "/")+"/"+imageName);
			} catch (IOException e) {
				e.printStackTrace();
				sendHtml("");
			}
   }
   /**
    * 手机推荐
    * @return
 * @throws JSONException 
    */
    public void androidRecommend() throws JSONException{
 	  MyLog.print("推荐");
 	  User user= (User) getSession().getAttribute(Globals.USER_SESSION_KEY);
 	  String username=user==null?"匿名":user.getUsername();
       String keyword=MatchService.findKeyword(username);
       if (user!=null) {
     	  setReq("bodyPath", CommonUtil.bodyMach(user));
     	  MyLog.print(CommonUtil.bodyMach(user));
   	    setReq("sex",user.getSex());
 	}
       if (keyword!=null) {
     	  Map<String, Object>filter = new HashMap<String, Object>();
     	  filter.put("key",keyword);
     	  int pageNo= getIntPar("page", 1);
     	  int pageSize=getIntPar("pageSize", 7);
     	  Page page=MatchService.queryPageList(filter,pageNo,pageSize);
     	   List<MatchClothes>matchList= (List<MatchClothes>) page.getRestult();
     	   JSONArray jsonArray=new JSONArray();
     	   for (int i = 0; i < matchList.size(); i++) {
    		JSONObject jsonObject=new JSONObject();
    		 MatchClothes clothes=  matchList.get(i);
    		jsonObject.put("tId", clothes.gettId());
    		jsonObject.put("tName", clothes.gettName());
    		jsonObject.put("tSize", clothes.gettSize());
    		jsonObject.put("tDetail", clothes.gettDetail());
    		jsonObject.put("tThumbAdress", clothes.gettThumbAdress());
    		jsonObject.put("tImageAdress", clothes.gettImageAdress());
    		jsonObject.put("dId", clothes.getdId());
    		jsonObject.put("dName", clothes.getdName());
    		jsonObject.put("dSize", clothes.getdSize());
    		jsonObject.put("dDetail", clothes.getdDetail());
    		jsonObject.put("dThumbAdress", clothes.getdThumbAdress());
    		jsonObject.put("dImageAdress", clothes.getdImageAdress());
    		jsonObject.put("sex", clothes.getSex());
    		jsonArray.put(jsonObject);
    	  }
     	   System.out.print("返回："+jsonArray.toString());
     	  sendHtml(jsonArray.toString());
 	}
       else  sendHtml("");
       
    }
    /**
     * 手机推荐
     * @return
  * @throws JSONException 
     */
    public void getAndroidKeywords(){
 	   MyLog.print("获取关键字");
 	   StringBuffer par=new StringBuffer("");
	   Map<String, Object>filter = new HashMap<String, Object>();
	   filter.put("limit", 5);
 	List<String>keywordList=  MatchService.findKeywords(filter);
 	for (int i = 0; i < keywordList.size(); i++) {
 		String keyword=keywordList.get(i);
 		par.append(keyword);
 		par.append(",");
 	}
 	par.substring(0,par.length()-1);
 	MyLog.print(par.substring(0,par.length()-1).toString());
 	sendHtml(par.substring(0,par.length()-1).toString());
    }
}
