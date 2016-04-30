package com.org.efit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clothes implements Serializable{
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
 private String score;
 
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
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


}
