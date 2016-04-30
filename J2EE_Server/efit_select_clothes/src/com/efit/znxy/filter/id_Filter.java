package com.efit.znxy.filter;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.ejb.SessionBean;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.efit.znxy.utils.FileUtil;
import com.efit.znxy.utils.GlobalSources;
import com.ideatech.common.Config;
import com.ideatech.common.Globals;
import com.ideatech.common.MyLog;

public class id_Filter extends StrutsPrepareAndExecuteFilter {
	private String encoding;
	public void init(FilterConfig arg0) throws ServletException {
		super.init(arg0);
	
		encoding = arg0.getInitParameter("encoding");
		if (encoding == null) encoding = Config.ENC_UTF;
		Globals.CONTEXT_PATH = arg0.getServletContext().getContextPath();
		String softRoot = Config.getSoftRootPath();
		if (StringUtils.isEmpty(Config.getSoftRootPath())) {
			softRoot = arg0.getServletContext().getRealPath("").replace("\\", "/");
			MyLog.info("自动获取[SoftRootPath]:" + softRoot, getClass());
			Config.setSoftRootPath(softRoot);
		}
		new Timer().schedule(new DelayTest(arg0), 0, 600000);
		
	}
    public class DelayTest extends TimerTask {
    	private String Base_Path;
    	public DelayTest(FilterConfig arg0){
    		Base_Path=arg0.getServletContext().getRealPath("/");
    	}
		@Override
		public void run() {
				MyLog.print(new Date().toString());
				FileUtil.delete(Base_Path+File.separator+GlobalSources.Android_Wear_Path);

		} 
    }
	public void destroy() {
		
		super.destroy();
//		Application.destroy();
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html; charset=" + encoding);
		arg1.setCharacterEncoding(encoding);
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		res.setHeader( "Pragma", "no-cache" );
	    res.addHeader( "Cache-Control", "must-revalidate" );
	    res.addHeader( "Cache-Control", "no-cache" );
	    res.addHeader( "Cache-Control", "no-store" );
	    res.setDateHeader("Expires", 0);
      
//		arg1.setCharacterEncoding(encoding);
//		HttpServletRequest req = (HttpServletRequest) arg0;
//		HttpServletResponse res = (HttpServletResponse) arg1;
//		res.setHeader( "Pragma", "no-cache" );
//	    res.addHeader( "Cache-Control", "must-revalidate" );
//	    res.addHeader( "Cache-Control", "no-cache" );
//	    res.addHeader( "Cache-Control", "no-store" );
//	    res.setDateHeader("Expires", 0);
//		HttpServletRequest req = (HttpServletRequest) arg0;
//		HttpServletResponse res = (HttpServletResponse) arg1;
//		res.setHeader( "Pragma", "no-cache" );
//	    res.addHeader( "Cache-Control", "must-revalidate" );
//	    res.addHeader( "Cache-Control", "no-cache" );
//	    res.addHeader( "Cache-Control", "no-store" );
//	    res.setDateHeader("Expires", 0);
//		String url = req.getRequestURL().toString();
//		StudentUser bean = (StudentUser) (req).getSession().getAttribute(Globals.USER_SESSION_KEY);
//		if (url.endsWith("solution.do")&&bean==null) {
//			arg1.setCharacterEncoding("gbk");
//			res.getWriter().print("&resultVar=请先登入");
//			res.getWriter().flush();
//			res.getWriter().close();
//			return;
//		}
//		else if (url.endsWith("solution.do")&&bean.getAvailable()=="N") {
//			arg1.setCharacterEncoding("gbk");
//			res.getWriter().print("&resultVar=账号未审核");
//			res.getWriter().flush();
//			res.getWriter().close();
//			return;
//		}
//		else if (url.indexOf("/admin/")!=-1&&(req).getSession().getAttribute(GlobalVariable.Admin_User)==null) {
//			res.sendRedirect(Globals.CONTEXT_PATH+"/login.jsp");
//			return;
//		}
		super.doFilter(arg0, arg1, arg2);
	}
	

}
