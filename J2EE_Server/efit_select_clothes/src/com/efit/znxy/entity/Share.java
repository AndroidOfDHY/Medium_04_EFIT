package com.efit.znxy.entity;

public class Share {
private String shareId;
private Integer userId;
private String userName;
private String sharePath;
private String shareTime;
private String tId;
private String tName;
private String tDetail;
private String dId;
private String dName;
private String dDetail;
public Share(){
	
}
public Share(Clothes tClothes,Clothes dClothes){
	tId=tClothes.getClothesId();
	tName=tClothes.getClothesName();
	tDetail=tClothes.getDetail();
	dId=dClothes.getClothesId();
	dName=dClothes.getClothesName();
	dDetail=dClothes.getDetail();
}
public String getShareId() {
	return shareId;
}
public void setShareId(String shareId) {
	this.shareId = shareId;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getSharePath() {
	return sharePath;
}
public void setSharePath(String sharePath) {
	this.sharePath = sharePath;
}
public String getShareTime() {
	return shareTime;
}
public void setShareTime(String shareTime) {
	this.shareTime = shareTime;
}
public String gettId() {
	return tId;
}
public void settId(String tId) {
	this.tId = tId;
}
public String gettName() {
	return tName;
}
public void settName(String tName) {
	this.tName = tName;
}
public String gettDetail() {
	return tDetail;
}
public void settDetail(String tDetail) {
	this.tDetail = tDetail;
}
public String getdId() {
	return dId;
}
public void setdId(String dId) {
	this.dId = dId;
}
public String getdName() {
	return dName;
}
public void setdName(String dName) {
	this.dName = dName;
}
public String getdDetail() {
	return dDetail;
}
public void setdDetail(String dDetail) {
	this.dDetail = dDetail;
}

}
