package com.efit.znxy.action;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;

import com.efit.znxy.entity.Clothes;
import com.efit.znxy.entity.User;
import com.efit.znxy.service.ClothesService;
import com.efit.znxy.service.UserService;
import com.efit.znxy.utils.FileUtil;
import com.efit.znxy.utils.GlobalSources;
import com.efit.znxy.utils.ImageUtil;
import com.efit.znxy.utils.UserActionUtil;
import com.ideatech.common.Globals;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

public class UserAction extends BaseAction {
	@Override
	public String index() {
		Map<String, Object>filter = new HashMap<String, Object>();
        int pageNo=getPage();
  	    int pageSize=getPageSize();
  	    Page page=UserService.queryPageList(filter,pageNo,pageSize);
    	  setReq("userList", (List<User>)page.getRestult());
      	  setReq("pagestr",page.getPageStr(getMappingPath()));
      	  MyLog.print("获取用户数："+((List<User>)page.getRestult()).get(0).getUsername());
		return callMethodTempFile("listUser");
	}
	public void delete(){
	 String userIds=	 getStrPar("userIds");
	 String[]userIdArray= userIds.split(",");
	    for (int i = 0; i < userIdArray.length; i++) {
	    	String clothesId=userIdArray[i];
			UserService.deleteById(Integer.valueOf(clothesId));
		}
	    sendHtml("200");
	}
	public void register() {
		String username = getStrPar("username");
		String password = getStrPar("password");
		String headAdreess = getStrPar("headAdreess", null);
		String sex = getStrPar("sex");
		String t_size = getStrPar("topSize");
		String d_size = getStrPar("downSize");
		if (headAdreess!=null) {
			headAdreess = FileUtil.remove(
					FileUtil.getRealPath(GlobalSources.User_Path + username),
					FileUtil.getRealPath(headAdreess));

		}

		MyLog.print(headAdreess);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setHeadAdreess(headAdreess==null?null:headAdreess.replace("\\", File.separator).replace(
				"//", File.separator));
		user.setSex(sex);
		user.setT_size(t_size);
		user.setD_size(d_size);
		if (username.length() < 6 || username.equals("")) {
			return;
		}
		if ((UserService.findByUsername(username)) == null) {
			if (headAdreess != null) {
				UserActionUtil.saveBodyImage(user);
			}
			String msg = UserService.save(user);
			if (!msg.equals("200")) {
				FileUtil.delete(FileUtil.getRealPath(GlobalSources.User_Path
						+ username));
			}
			sendHtml(msg);
			return;
		}
		sendHtml("300");
	}

	public void userDetails() {
		MyLog.print("获取用户信息");
		User user = (User) getSession().getAttribute(Globals.USER_SESSION_KEY);
		try {
			JSONObject jsonObject = new JSONObject();
			if (user == null) {

				jsonObject.put("status", "300");
				sendHtml(jsonObject.toString());
				return;
			}
			jsonObject.put("status", "200");
			jsonObject.put("sex", user.getSex());
			MyLog.print(user.getSex());
			jsonObject.put("username", user.getUsername());
			jsonObject.put("headAdreess", user.getHeadAdreess());
			jsonObject.put("topSize", user.getT_size());
			jsonObject.put("downSize", user.getD_size());
			sendHtml(jsonObject.toString());
		} catch (JSONException e) {
			sendHtml("301");
			e.printStackTrace();
		}
	}

	public void login() {
		MyLog.print("登入");
		String username = getStrPar("username");
		String password = getStrPar("password");
		User user;
		if ((user = UserService.findByUsername(username)) != null) {
			if (user.getPassword().equals(password)) {
				MyLog.print(user.getHeadAdreess());
				getSession().setAttribute(Globals.USER_SESSION_KEY, user);
				sendHtml("200");
			} else {
				sendHtml("300");
			}
		}
		sendHtml("301");
	}

	public String quit() {
		getSession().removeAttribute(Globals.USER_SESSION_KEY);
		return callMethodTempFile("login");
	}
	public void androidQuit() {
		getSession().removeAttribute(Globals.USER_SESSION_KEY);
	}
	public void pz() throws IOException {
		MyLog.print("拍照截取");
		JSONObject json = new JSONObject();
		String basePath = ServletActionContext.getServletContext().getRealPath(
				GlobalSources.Pzimage_Path)
				+ "\\";
		String bitmap_data = req.getParameter("bitmap_data");
		int width = Integer.parseInt(req.getParameter("width"));
		int height = Integer.parseInt(req.getParameter("height"));
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		try {
			int w = width;
			int h = height;
			int[] pixels = new int[w * h];
			String[] m_tempPics = bitmap_data.split(",");
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					Long pic_argb = Long.parseLong(m_tempPics[x * h + y]);
					int a = (int) (pic_argb >> 24 & 0xFF);
					int r = (int) (pic_argb >> 16 & 0xFF);
					int g = (int) (pic_argb >> 8 & 0xFF);
					int b = (int) (pic_argb & 0xFF);
					pixels[y * w + x] = new Color(r, g, b, a).getRGB();
				}
			}
			img.setRGB(0, 0, w, h, pixels, 0, w);
			img.flush();
			BufferedImage maskImage = ImageIO.read(new File(basePath
					+ "mask.png"));
			img.getGraphics().drawImage(maskImage, 0, 0, width, height, null);
			String outFile = FileUtil.randomFileName("png");
		//	img=ImageUtil
		//	.brighten(img, 20);
			BufferedImage image = ImageUtil.makeWhiteClarity(img);
			ImageIO.write(ImageUtil.createResizedCopy(image, width / 4,
					height / 4, false), "png", new File(basePath + outFile));
			json.put("statusCode", "200");
			json.put("imageUrl", GlobalSources.Pzimage_Path + outFile);
			MyLog.print(json.toString());
			sendHtml(json.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				json.put("statusCode", "300");
			} catch (JSONException e) {

				e.printStackTrace();
			}
			sendHtml(json.toString());
		}

	}

	public void modifyPassword() {
		User bean = (User) getSession().getAttribute(Globals.USER_SESSION_KEY);
		String newPassword = getStrPar("newPassword");
		String password = getStrPar("password");
		if (!password.equals(bean.getPassword())) {
			sendHtml("301");
			return;
		}
		bean.setPassword(newPassword);
		getSession().setAttribute(Globals.USER_SESSION_KEY, bean);
		String msg = UserService.update(bean);
		sendHtml(msg);
	}

	public void modifyUser() {
		User bean = (User) getSession().getAttribute(Globals.USER_SESSION_KEY);
		String username = getStrPar("username");
		String headAdreess = getStrPar("headAdreess");
		String sex = getStrPar("sex");
		String t_size = getStrPar("topSize");
		String d_size = getStrPar("downSize");
		MyLog.print(headAdreess + "," + bean.getHeadAdreess());
		boolean change = headAdreess.equals(bean.getHeadAdreess());
		if (!change)
			headAdreess = FileUtil.remove(
					FileUtil.getRealPath(GlobalSources.User_Path + username),
					FileUtil.getRealPath(headAdreess));
		MyLog.print(headAdreess);
		User user = new User();
		user.setUsername(username);
		user.setSex(sex);
		user.setT_size(t_size);
		user.setD_size(d_size);
		user.setHeadAdreess(headAdreess);
		user.setUserId(bean.getUserId());
		user.setPassword(bean.getPassword());

		String msg = UserService.update(user);
		if (!change || !sex.equals(bean.getSex())
				|| !bean.getT_size().equals(t_size)) {
			if (UserActionUtil.saveBodyImage(user)) {

				if (!bean.getT_size().equals(t_size)
						|| !sex.equals(bean.getSex())) {
					MyLog.print("删除："
							+ FileUtil.getRealPath(GlobalSources.User_Path
									+ bean.getUsername() + File.separator
									+ bean.getSex() + bean.getT_size() + ".png"));
					FileUtil.delete(FileUtil
							.getRealPath(GlobalSources.User_Path
									+ bean.getUsername() + File.separator
									+ bean.getSex() + bean.getT_size() + ".png"));
				}
			} else {
				sendHtml("300");
				return;
			}
		}

		if (msg.equals("200")) {
			getSession().setAttribute(Globals.USER_SESSION_KEY, user);
			if (!change) {
				MyLog.print(ServletActionContext.getServletContext()
						.getRealPath(bean.getHeadAdreess().replace("/", "\\")));
				FileUtil.delete(ServletActionContext.getServletContext()
						.getRealPath(bean.getHeadAdreess().replace("/", "\\")));
			}
		}
		sendHtml(msg);
	}

	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public void upLaod() {
		MyLog.print("上传成功");
		try {
			MyLog.print(GlobalSources.Base_Path + GlobalSources.Pzimage_Path
					+ "mask.png");
			BufferedImage img = ImageIO.read(image);
			if (img == null) {
				sendHtml("0");
				return;
			}
			int width = img.getWidth();
			int height = img.getHeight();
			BufferedImage maskImage = ImageIO.read(new File(
					GlobalSources.Base_Path + GlobalSources.Pzimage_Path
							+ "mask.png"));
			img.getGraphics().drawImage(maskImage, 0, 0, width, height, null);
			String outFile = FileUtil.randomFileName("png");
			//img=ImageUtil
			//.brighten(img, 20);
			BufferedImage image = ImageUtil.makeWhiteClarity(img);
			ImageIO.write(ImageUtil.createResizedCopy(image, width / 4,
					height / 4, false), "png", new File(GlobalSources.Base_Path
					+ GlobalSources.Pzimage_Path + outFile));
			sendHtml(GlobalSources.Pzimage_Path + outFile);
		} catch (IOException e) {
			e.printStackTrace();
			sendHtml("0");
		}

	}

	public static void main(String[] args) {
		// String aString="E:\\Tomcat
		// 7.0\webapps\efit_select_clothes\who247\Mm.png";
		// FileUtil.delete("E:\Tomcat
		// 7.0\webapps\efit_select_clothes\who247\Mm.png");

		FileUtil.delete("E:\\Tomcat 7.0\\webapps\\efit_select_clothes\\who247\\Ms.png");
	}
}
