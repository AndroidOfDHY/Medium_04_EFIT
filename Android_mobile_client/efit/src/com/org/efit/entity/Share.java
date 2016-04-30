package com.org.efit.entity;

public class Share
{
  private String dDetail;
  private Integer dId;
  private String dName;
  private String shareId;
  private String sharePath;
  private String shareTime;
  private String tDetail;
  private Integer tId;
  private String tName;
  private Integer userId;
  private String userName;
  private String score;
  
  public String getScore() {
	return score;
}

public void setScore(String score) {
	this.score = score;
}

public String getShareId()
  {
    return this.shareId;
  }

  public String getSharePath()
  {
    return this.sharePath;
  }

  public String getShareTime()
  {
    return this.shareTime;
  }

  public Integer getUserId()
  {
    return this.userId;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public String getdDetail()
  {
    return this.dDetail;
  }

  public Integer getdId()
  {
    return this.dId;
  }

  public String getdName()
  {
    return this.dName;
  }

  public String gettDetail()
  {
    return this.tDetail;
  }

  public Integer gettId()
  {
    return this.tId;
  }

  public String gettName()
  {
    return this.tName;
  }

  public void setShareId(String paramInteger)
  {
    this.shareId = paramInteger;
  }

  public void setSharePath(String paramString)
  {
    this.sharePath = paramString;
  }

  public void setShareTime(String paramString)
  {
    this.shareTime = paramString;
  }

  public void setUserId(Integer paramInteger)
  {
    this.userId = paramInteger;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public void setdDetail(String paramString)
  {
    this.dDetail = paramString;
  }

  public void setdId(Integer paramInteger)
  {
    this.dId = paramInteger;
  }

  public void setdName(String paramString)
  {
    this.dName = paramString;
  }

  public void settDetail(String paramString)
  {
    this.tDetail = paramString;
  }

  public void settId(Integer paramInteger)
  {
    this.tId = paramInteger;
  }

  public void settName(String paramString)
  {
    this.tName = paramString;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.entity.Share
 * JD-Core Version:    0.6.0
 */