package com.efit.znxy.utils;

import com.ideatech.common.Page;
/**
 * 
 * @author 池超凡
 *@time 2013-1-22
 *@功能  分页 适用dwzUI框架
 */
public class PageUtil extends Page {
	public PageUtil(int pageNo,int pageSize,int rsCount){
		super(pageNo, pageSize, rsCount);
	}
	@Override
	public String getPageStr(String url) {
		if (url.indexOf("?") == -1) {
			url += "?";
		} else
			url += "&";
		int pageCount = getPageCount();
		int currentPage = getCurrentPage();
		StringBuffer sb = new StringBuffer("");
		int pageSize=getPageSize();
		sb.append("<div style='line-height:120%;margin:2px;padding:3px'");
		sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'>共 <strong>" + getRecordCount() + "</strong> 条记录</li>\n");
		if (currentPage > 1){
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a  href='#' onclick=javascript:navTab.reload('" + url + "pageSize=" + pageSize + "&page=1" + "'); style='display:inline;color:#000;'>首页</a></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a href='#' onclick=javascript:navTab.reload('" + url + "pageSize=" + pageSize + "&page=" + (currentPage - 1) + "'); style='display:inline;color:#000;'>上一页</a></li>\n");
		} else {
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>首页</font></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>上一页</font></li>\n");
		}
		if (currentPage < pageCount) {
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a  href='#' onclick=javascript:navTab.reload('" + url + "pageSize=" + pageSize + "&page=" + (currentPage + 1) + "'); style='display:inline;color:#000;' >下一页</a></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><a  href='#'  onclick=javascript:navTab.reload('" + url + "pageSize=" + pageSize + "&page=" + pageCount +"'); style='display:inline;color:#000;'>尾页</a></li>\n");
		} else {
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>下一页</font></li>\n");
			sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'><font color=#6D6D6D>尾页</font></li>");
		}
		sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'>页次：<strong><font color=red>" + currentPage + "</font>/" + pageCount + "</strong>页</li>\n");
		sb.append("<li style='margin-right:10px; display:inline; font-size:9pt;'>每页显示：<input class='inputText' maxLength=4 size=3 value=" + pageSize + " onkeypress=\"javascript:if(event.keyCode==13){navTab.reload('" + url + "page=1&pageSize='+this.value);return false}\"/>条</li>\n");
		sb.append("</div>\n");
		return sb.toString();
	}
}
