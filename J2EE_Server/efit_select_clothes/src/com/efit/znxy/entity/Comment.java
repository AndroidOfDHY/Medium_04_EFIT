package com.efit.znxy.entity;

public class Comment {
private int commentId;
private String shareId;
private String username;
private String content;
private int score;
private String subTime;

public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public int getCommentId() {
	return commentId;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
public String getShareId() {
	return shareId;
}
public void setShareId(String shareId) {
	this.shareId = shareId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getSubTime() {
	return subTime;
}
public void setSubTime(String subTime) {
	this.subTime = subTime;
}

}
