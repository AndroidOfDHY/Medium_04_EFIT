package com.efit.znxy.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;

import com.ideatech.common.Globals;
import com.ideatech.common.Page;
import com.ideatech.common.base.ExtendsAction;
import com.ideatech.common.utils.NumberUtils;

public class BaseAction extends ExtendsAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7574909648122864129L;
	
	
	/** 锟斤拷玫锟角耙筹拷锟侥拷锟� */
	public int getPage() {
		return getIntPar("page", 1);
	}
	
	/** 锟斤拷玫锟角帮拷锟揭筹拷锟侥拷锟�0 */
	public int getPageSize() {
		return getIntPar("pageSize", 10);
	}
	
	protected int getIntPar(String parName) {
		return getIntPar(parName, 0);
	}
	
	protected int getIntPar(String parName, int defaultNum) {
		int par = NumberUtils.str2Int(req.getParameter(parName), defaultNum);
		setReq("par_" + parName, par);
		return par;
	}
	protected long getLongPar(String parName) {
		return getLongPar(parName, 0);
	}
	
	protected long getLongPar(String parName, int defaultNum) {
		long par = NumberUtils.str2Long(req.getParameter(parName), defaultNum);
		setReq("par_" + parName, par);
		return par;
	}
	protected String getStrPar(String parName) {
		return getStrPar(parName, "");
	}
	
	protected String getStrPar(String parName, String defaultStr) {
		String value = req.getParameter(parName);
		value = StringUtils.isEmpty(value) ? defaultStr : value;
		setReq("par_" + parName, value);
		return value;
	}
	
	public Map<String, String> getParameterMap() {
		Map<String, String> map = new HashMap<String, String>();
		Map<?, ?> pars = req.getParameterMap();
		Iterator<?> iter = pars.keySet().iterator();
		while(iter.hasNext()) {
			Object key = iter.next();
			Object values = pars.get(key);
			if(values instanceof Object[]) {
				String p = "";
				for(Object obj : (Object[]) values) {
					p += (String) obj;
				}
				map.put(key.toString(), p);
			} else {
				map.put(key.toString(), values.toString());
			}
		}
		return map;
	}
	
	
	/** Javascript锟斤拷息锟斤拷示 */
	protected String sendJsMessage(String msg){
		return sendJsMessage(msg, null);
	}
	protected String sendJsMessage(String msg,String url){
		url = StringUtils.isEmpty(url) ? getMappingPath() : url;
		try {
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.append("<script language=\"javascript\" type=\"text/javascript\">");
			pw.append("alert('" + msg + "');");
			if (StringUtils.isEmpty(url) == false) {
				pw.append("window.location.href='" + url + "';");
			}
			pw.append("</script>");
			pw.flush();
			pw.close();
		} catch (IOException e) {}
		return NONE;
	}
	
	
	/**
	 * 锟斤拷锟斤拷Html锟斤拷锟斤拷
	 * @param data
	 * @param res
	 * @throws Exception
	 */
	protected String sendHtml(String data){
		try {
			res.getWriter().print(data);
			res.getWriter().flush();
			res.getWriter().close();
		} catch (IOException e) {
			return NONE;
		}
		return NONE;
	}
	/**
	 * 锟斤拷锟截碉拷锟斤拷锟斤拷tempFile 直锟斤拷锟斤拷转锟斤拷
	 * @param tempFile
	 * @return
	 */
	protected String callTempFile(String tempFile){
		setTempFile(tempFile);
		return SUCCESS;
	}
	/**
	 * 锟斤拷锟截碉拷锟斤拷锟斤拷tempFile 锟斤拷锟斤拷tempFile=methodName(小写)
	 * @param tempFile
	 * @return
	 */
	protected String callMethodTempFile(String tempFile){
		setTempFile(tempFile);
		return SUCCESS;
	}
	/**
	 * redirect 锟斤拷转
	 * @param url
	 * @return
	 */
	protected String pageTo(String url){
		try {
			res.sendRedirect(url);
		} catch (IOException e) {
			return NONE;
		}
		return NONE;
	}
	/**
	 * 锟斤拷取ContextPathUrl锟斤拷锟斤拷实锟斤拷锟绞碉拷址
	 * @param url
	 * @return
	 */
	protected String buildUrl(String url){
		if (url.startsWith("/")) {
			return Globals.CONTEXT_PATH + url;
		} else {
			return url;
		}
	}
	
	/**
	 * 锟斤拷锟芥到req锟斤拷锟斤拷
	 * @param key
	 * @param obj
	 */
	protected void setReq(String key,Object obj){
		req.setAttribute(key, obj);
	}
	protected String getHistoryPath(){
		return "javascript:history.go(-1)";
	}
	/**
	 * 锟斤拷取锟斤拷锟斤拷锟皆�
	 * @return
	 */
	public String getFromPage(){
		String path = "";
		if ((path = getStrPar("from_page")).length() > 2)
			return path;
		path = getRequest().getHeader("Referer");
		if (path == null)
			path = getMappingPath();
		return path;
	}
	/** 锟斤拷锟街凤拷锟斤拷邪锟饺拷锟斤拷锟�* */
	protected String getSafeSqlValue(String sql){
		return sql.replace("'", "").replace("or", "").replace(" ", "");
	}
	/**
	 * 锟斤拷臃锟斤拷锟斤拷锟较拷锟斤拷锟斤拷锟斤拷诜锟斤拷卮锟斤拷锟斤拷锟较�锟斤拷锟斤拷 retInfo 锟斤拷 key值 默锟斤拷为系统锟斤拷锟斤拷锟斤拷息 锟斤拷锟斤拷 _infomap 锟斤拷
	 * @param key
	 * @param msg
	 */
	protected void addMsg(String key,String msg){
		get_infomap().put(key, msg);
	}
	/** 锟斤拷哟锟斤拷锟斤拷锟较拷锟斤拷锟阶猴拷锟斤拷锟絖error* */
	protected void addError(String key,String msg){
		get_infomap().put(key + "_error", msg);
	}
	/**
	 * 锟斤拷锟斤拷addMsg 锟斤拷 _infomap 锟斤拷戏锟斤拷卮锟斤拷锟斤拷锟较�
	 * @param url
	 * @param msg
	 * @return
	 */
	protected String callMsgPage(String url){
		url = StringUtils.isEmpty(url) ? getHistoryPath() : url;
		List<String> list = new ArrayList<String>();
		Map<String, Object> errors = get_infomap();
		Iterator<String> it = errors.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Object v = errors.get(key);
			list.add(String.valueOf(v));
		}
		setReq("msgs", list);
		addMsg("type", "0");
		addMsg("url", url);
		return getMsgPage();
	}
	protected String encodeURL(String str){
		try {
			return URLEncoder.encode(URLEncoder.encode(str, "UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	protected String decodeURL(String str){
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	protected String formatTime(Date date)
	{
		//SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}
	protected String formatTime(Date date,String forMat)
	{
		SimpleDateFormat sf = new SimpleDateFormat(forMat);
		return sf.format(date);
	}
	/*分页*/
	 protected  Page pagination(List<Object> list)
	  {
		 int rsCount =list.size();
			Page page=new Page(getPage(), getPageSize(), rsCount);
			List<Object> tempList= list.subList(page.getIndexOf(), page.getLastIndex());
			page.setRestult(tempList);
			return page;
	  }
	 protected  String getJson(String statusCode,String message)
	  {
		 JSONObject json=new JSONObject();
		 try {
			json.put("statusCode", statusCode);
			json.put("message", message);
			json.put("navTabId", "");
			json.put("rel", "");
			json.put("callbackType", "closeCurrent");
			json.put("forwardUrl", "");
			return json.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
       return null;
	  }
	 protected  String getJson(String statusCode)
	  {
		 return getJson(statusCode, "");
	  }
	 protected String htmlToString(String content){
		 if(content==null) return "";        
		    String html = content;
		html = StringUtils.replace(html, "'", "&apos;");
		    html = StringUtils.replace(html, "\"", "&quot;");
		    html = StringUtils.replace(html, "\t", "&nbsp;&nbsp;");// 替换跳格
		    //html = StringUtils.replace(html, " ", "&nbsp;");// 替换空格
		    html = StringUtils.replace(html, "<", "&lt;");
		    html = StringUtils.replace(html, ">", "&gt;");
		    return html;

	 }
	 protected  String getJsonWithMsg(String statusCode)
	  {
		 return getJson(statusCode, statusCode.equals("200")?"succeed":"error");
	  }

}

