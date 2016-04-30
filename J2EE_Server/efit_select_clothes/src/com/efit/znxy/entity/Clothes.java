package com.efit.znxy.entity;

import java.util.ArrayList;
import java.util.List;

public class Clothes {
 private String clothesId;
 private String clothesName;
 private String type;
 private String sex;
 private String size;
 private String keyword;
 private String brand;
 private String detail;
 private String thumbAdress;
 private String  imageAdress;
 private Integer matchValue;
 private String submitTime;
 private String position;
 
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public String getKeyword() {
	return keyword;
}
public void setKeyword(String keyword) {
	this.keyword = keyword;
}
public String getClothesId() {
	return clothesId;
}
public void setClothesId(String clothesId) {
	this.clothesId = clothesId;
}
public String getClothesName() {
	return clothesName;
}
public void setClothesName(String clothesName) {
	this.clothesName = clothesName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}

public String getThumbAdress() {
	return thumbAdress;
}
public void setThumbAdress(String thumbAdress) {
	this.thumbAdress = thumbAdress;
}
public String getImageAdress() {
	return imageAdress;
}
public void setImageAdress(String imageAdress) {
	this.imageAdress = imageAdress;
}
public Integer getMatchValue() {
	return matchValue;
}
public void setMatchValue(Integer matchValue) {
	this.matchValue = matchValue;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getSubmitTime() {
	return submitTime;
}
public void setSubmitTime(String submitTime) {
	this.submitTime = submitTime;
}
public static MatchClothes clothesToMatchClothes(Clothes c1, Clothes c2){
	MatchClothes mClothes=new MatchClothes();
	if (c1.getType().equals("T")) {
		mClothes.settId(c1.getClothesId());
		mClothes.settDetail(c1.getDetail());
		mClothes.settName(c1.getClothesName());
		mClothes.settSize(c1.getSize());
		mClothes.settImageAdress(c1.getImageAdress());
		mClothes.settThumbAdress(c1.getThumbAdress());
		
		mClothes.setdId(c2.getClothesId());
		mClothes.setdDetail(c2.getDetail());
		mClothes.setdName(c2.getClothesName());
		mClothes.setdSize(c2.getSize());
		mClothes.setdImageAdress(c2.getImageAdress());
		mClothes.setdThumbAdress(c2.getThumbAdress());
	}
	else {
		mClothes.settId(c2.getClothesId());
		mClothes.settDetail(c2.getDetail());
		mClothes.settName(c2.getClothesName());
		mClothes.settSize(c2.getSize());
		mClothes.settImageAdress(c2.getImageAdress());
		mClothes.settThumbAdress(c2.getThumbAdress());
		
		mClothes.setdId(c1.getClothesId());
		mClothes.setdDetail(c1.getDetail());
		mClothes.setdName(c1.getClothesName());
		mClothes.setdSize(c1.getSize());
		mClothes.setdImageAdress(c1.getImageAdress());
		mClothes.setdThumbAdress(c1.getThumbAdress());
		
	}
	mClothes.setSex(c2.getSex());
	return mClothes;
}
@SuppressWarnings("null")
public static List<MatchClothes> clothesToMatchClothes(List<Clothes> ListClothes, Clothes clothes){
	List<MatchClothes> mc=new ArrayList<MatchClothes>();
	for (int i = 0; i < ListClothes.size(); i++) {
		mc.add(clothesToMatchClothes(ListClothes.get(i), clothes));
	}
	return mc;
}

}
