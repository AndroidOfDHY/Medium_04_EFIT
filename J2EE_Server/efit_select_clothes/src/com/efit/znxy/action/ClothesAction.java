package com.efit.znxy.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.efit.znxy.entity.Clothes;
import com.efit.znxy.entity.Image;
import com.efit.znxy.entity.User;
import com.efit.znxy.service.ClothesService;
import com.efit.znxy.service.CommentService;
import com.efit.znxy.utils.CommonUtil;
import com.efit.znxy.utils.FileUtil;
import com.efit.znxy.vo.ClothesVo;
import com.ideatech.common.Globals;
import com.ideatech.common.MyLog;
import com.ideatech.common.Page;

/**
 * 
 * @author 池超凡
 * @time 2013-1-19
 * @功能 衣物处理
 */
public class ClothesAction extends BaseAction {
	/**
	 * 添加衣物
	 */
    public void add() {
	 String clothesName=getStrPar("clothesName");

	 String type= getStrPar("type");
	 String sex=getStrPar("sex");
	 String size=getStrPar("size");
	 String detail=getStrPar("detail");
	 String brand=getStrPar("brand");
	 String position=getStrPar("position");
	 String thumbAdress=getStrPar("thumbAdress");
	 String imageAdress=getStrPar("imageAdress");
	 //System.out.println("地址："+thumbAdress+imageAdress);
	 String keyword=getStrPar("key");
	 Integer matchValue=getIntPar("matchValue");
	 Clothes clothes=new Clothes();
	 clothes.setClothesName(clothesName);
	 clothes.setDetail(detail);
	 clothes.setSex(sex);
	 clothes.setSize(size);
	 clothes.setBrand(brand);
	 clothes.setPosition(position);
	 clothes.setThumbAdress(thumbAdress);
	 clothes.setImageAdress(imageAdress);
	 clothes.setKeyword(keyword);
	 clothes.setMatchValue(matchValue);
	 clothes.setType(type);
	 clothes.setSubmitTime(formatTime(new Date()));
	 clothes.setClothesId(FileUtil.randomFileName());
	 sendHtml(ClothesService.save(clothes));
   }
    /**
     * 获取衣物
     */
    @SuppressWarnings("unchecked")
	@Override
    public String index() {
  	 StringBuffer par=new StringBuffer("?");
	 Map<String, Object>filter = new HashMap<String, Object>();
     String type=getStrPar("type");
     String keyword=getStrPar("keyword");
     String sex=getStrPar("sex");
   //  Integer maxValue=getStrPar("maxValue").equals("")?null:getIntPar("maxValue");
    // Integer minValue=getStrPar("minValue").equals("")?null:getIntPar("minValue");
     String maxValue=getStrPar("maxValue");
     String minValue=getStrPar("minValue");
	 String searchKey=getStrPar("searchKey");
	 String size=getStrPar("size");
     MyLog.print(type+keyword+sex+maxValue+minValue);
     MyLog.print("获取搜索信息:"+"type:"+type+"searchKey:"+searchKey+"size:"+size+"sex:"+sex);
      filter.put("type", type);
      filter.put("keyword", keyword);
      filter.put("maxValue", maxValue);
      filter.put("minValue", minValue);
	  filter.put("searchKey", searchKey);
	  filter.put("size", size);
	  filter.put("sex", sex);
  	  par.append("type="+type).append("&keyword="+keyword).append("&maxValue="+maxValue).append("&minValue="+minValue).append("&sex="+sex).append("&searchKey=").append(searchKey)
	  .append("&size=").append(size);
  	  int pageNo=getPage();
	  int pageSize=getPageSize();
	  MyLog.print("页面大小："+pageSize);
	  Page page=ClothesService.queryPageList(filter,pageNo,pageSize);
	  setReq("clothesList", (List<Clothes>)page.getRestult());
	  setReq("pagestr",page.getPageStr(getMappingPath() + par.toString()));
	  return callMethodTempFile("listClothes");
    }
    /**
     * 获取单个衣物信息
     */
    public String detail() {
    	String clothesId=getStrPar("clothesId");
    	ClothesVo clothesVo=new ClothesVo();
    	clothesVo.setClothes(ClothesService.findById(clothesId));
    	clothesVo.setScore(CommentService.queryForScoreAvg(clothesId));
    	setReq("clothes", clothesVo);
		return callMethodTempFile(getStrPar("page"));
    }
    /**
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
	public String match(){
    	User bean= (User) getSession().getAttribute(Globals.USER_SESSION_KEY);
    	if (bean==null) {
    		setReq("error","请先登入!");
    		return callMethodTempFile("error");
		}
    	String clothesId=getStrPar("clothesId");
    	Clothes clothes=ClothesService.findById(clothesId);
    	if (clothes!=null&&!clothes.getSex().equals(bean.getSex())) {
       		setReq("error","性别不符");
    		return callMethodTempFile("error");
		}
    	if((clothes.getType().equals("T")&&!clothes.getSize().equals(bean.getT_size()))||(clothes.getType().equals("D")&&!clothes.getSize().equals(bean.getD_size()))){
       		setReq("error","尺寸不适合请选择其他尺寸试穿");
    		return callMethodTempFile("error");
    	}
    	 @SuppressWarnings("unused")
		StringBuffer par=new StringBuffer("?");
    	 par.append("clothesId=").append(clothesId).append("&act=").append("match");
   	 Map<String, Object>filter = new HashMap<String, Object>();
   	 filter.put("sex", clothes.getSex());
     	filter.put("type", clothes.getType().equals("D")?"T":"D");
   	 filter.put("matchValue", clothes.getMatchValue());
   	filter.put("size",clothes.getType().equals("D")?bean.getT_size():bean.getD_size());

   	      int pageNo=getPage();
   	      int pageSize=getIntPar("pageSize", 7);
   	   Page page=ClothesService.queryPageList(filter,pageNo,pageSize);
        List<Clothes> listc=  (List<Clothes>) page.getRestult();
        MyLog.print("数据量："+listc.size());
    	setReq("matchList", Clothes.clothesToMatchClothes(listc, clothes));
    	setReq("pagestr",page.getPageStr(getMappingPath() + par));
    	setReq("bodyPath", CommonUtil.bodyMach(bean));
	    setReq("topSize",bean.getT_size());
	    setReq("sex",bean.getSex());
    	return callMethodTempFile("listSearch");
    }
    /**
     * 修改衣物信息
     */
    public void modify(){
    	MyLog.print("修改");
     String clothesId=getStrPar("clothesId");
     String clothesName=getStrPar("clothesName");
   	 String type= getStrPar("type");
   	String detail=getStrPar("detail");
   	 String sex=getStrPar("sex");
   	 String size=getStrPar("size");
   	 String thumbAdress=getStrPar("thumbAdress");
   	 String imageAdress=getStrPar("imageAdress");
   	 String brand=getStrPar("brand");
   	 String position=getStrPar("position");
   	 String keyword=getStrPar("key");
	 Integer matchValue=getIntPar("matchValue");
	 Clothes clothes=new Clothes();
	 clothes.setClothesId(clothesId);
	 clothes.setClothesName(clothesName);
	 clothes.setDetail(detail);
	 clothes.setSex(sex);
	 clothes.setSize(size);
	 clothes.setThumbAdress(thumbAdress);
	 clothes.setImageAdress(imageAdress);
	 clothes.setKeyword(keyword);
	 clothes.setPosition(position);
	 clothes.setBrand(brand);
	 clothes.setMatchValue(matchValue);
	 clothes.setType(type);
	 clothes.setSubmitTime(formatTime(new Date()));
	 sendHtml(ClothesService.modify(clothes));
    }
    /**
     * 删除
     */
    public void delete(){
    String clothesIds=getStrPar("clothesIds");
    MyLog.print("获得Ids:"+clothesIds);
    String[]clothesIdArray= clothesIds.split(",");
    for (int i = 0; i < clothesIdArray.length; i++) {
    	String clothesId=clothesIdArray[i];
		ClothesService.deleteById(clothesId);
	}
    sendHtml("200");
    }
    public String getClothes(){
    	MyLog.print("获取衣");
     	 StringBuffer par=new StringBuffer("?");
    	 Map<String, Object>filter = new HashMap<String, Object>();
    	 String type=getStrPar("type");
    	 String searchKey=getStrPar("searchKey");
    	 String size=getStrPar("size");
    	 String sex=getStrPar("sex");
    	 MyLog.print("获取搜索信息:"+"type:"+type+"type:"+searchKey+"size:"+size+"sex:"+sex);
    	  filter.put("type", type);
    	  filter.put("searchKey", searchKey);
    	  filter.put("size", size);
    	  filter.put("sex", sex);
    	  par.append("type=").append(type).append("&searchKey=").append(searchKey)
    	  .append("&size=").append(size).append("&sex=").append(sex).append("&act=").append("getClothes");
      	  int pageNo=getPage();
    	  int pageSize=getPageSize();
    	  Page page=ClothesService.queryPageList(filter,pageNo,pageSize);

  	    List<Clothes>clothesList=(List<Clothes>) page.getRestult();
  	    List<com.efit.znxy.vo.ClothesVo> clothesVOList=new ArrayList();
  	    for (Clothes clothes:clothesList) {
  	      com.efit.znxy.vo.ClothesVo clothesVO=new com.efit.znxy.vo.ClothesVo();
  	      MyLog.print(clothes.getClothesId());
  		  Integer score=CommentService.queryForScoreAvg(clothes.getClothesId());
  		  clothesVO.setScore(score);
  		  clothesVO.setClothes(clothes);
  		  clothesVOList.add(clothesVO);
  		}
  	  setReq("clothesList", clothesVOList);
  	  setReq("pagestr",page.getPageStr(getMappingPath() + par.toString()));
    	 return callMethodTempFile("listClothes");
    }
    
    /**
     * 安卓端获取衣物
     */
    public void getAndroidClothes(){
    	MyLog.print("获取衣");
     	 StringBuffer par=new StringBuffer("?");
    	 Map<String, Object>filter = new HashMap<String, Object>();
    	 String type=getStrPar("type");
    	 String searchKey=getStrPar("searchKey");
    	 String size=getStrPar("size");
    	 String sex=getStrPar("sex");
    	 MyLog.print("获取搜索信息:"+"type:"+type+"type:"+searchKey+"size:"+size+"sex:"+sex);
    	  filter.put("type", type);
    	  filter.put("searchKey", searchKey);
    	  filter.put("size", size);
    	  filter.put("sex", sex);
    	  par.append("type=").append(type).append("&searchKey=").append(searchKey)
    	  .append("&size=").append(size).append("&sex=").append(sex).append("&act=").append("getClothes");
   	      int pageNo= getIntPar("pageNo", 1);
   	      int pageSize=getIntPar("pageSize", 7);
    	  Page page=ClothesService.queryPageList(filter,pageNo,pageSize);
    	 // MyLog.print(((List<Clothes>)page.getRestult()).get(0).getSize()+"size");
    	  try {
  	    List<Clothes>clothesList=(List<Clothes>) page.getRestult();
 	    JSONObject jsonResult=new JSONObject();
 	    JSONArray jsonArray=new JSONArray();
  	    for (Clothes clothes:clothesList) {
  	      MyLog.print(clothes.getClothesId());
  	     JSONObject jsonObject=new JSONObject();
  		  Integer score=CommentService.queryForScoreAvg(clothes.getClothesId());
  		  
  		jsonObject.put("clotesId", clothes.getClothesId());
  		jsonObject.put("clothesName", clothes.getClothesName());
  		jsonObject.put("type", clothes.getType());
  		jsonObject.put("size", clothes.getSize());
  		jsonObject.put("sex", clothes.getSex());
  		jsonObject.put("brand", clothes.getBrand());
  		jsonObject.put("detail", clothes.getDetail());
  		jsonObject.put("thumbAdress", clothes.getThumbAdress());
  		jsonObject.put("imageAdress", clothes.getImageAdress());
  		jsonObject.put("matchValue", clothes.getMatchValue());
  		jsonObject.put("subTime", clothes.getSubmitTime());
  		jsonObject.put("position",clothes.getPosition());
  		jsonObject.put("score", score+"");
  		jsonArray.put(jsonObject);
  		}
  	 	 jsonResult.put("jsonArray", jsonArray);
  	 	 jsonResult.put("recordCount", ""+page.getRecordCount());
  	 	 MyLog.print(jsonResult.toString());
  	 	  sendHtml(jsonResult.toString());
  		} catch (JSONException e) {
  			sendHtml("300");
			e.printStackTrace();
		}
    }
    
//    public static void main(String[] args) {
//    Image i1=new Image();
//    i1.setAddress("1");
//    i1.setX(1);
//    i1.setY(0);
//    
//    Image i2=new Image();
//    i2.setAddress("1");
//    i2.setX(1);
//    i2.setY(0);
//    System.out.print(i1.equals(i2));
//	}
}
