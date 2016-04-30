package com.org.efit.util;


import android.util.Log;
import com.org.efit.entity.Comment;
import com.org.efit.entity.MatchClothes;
import com.org.efit.entity.Share;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AnalysisJson
{
  public static JSONArray Analysis(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static JSONObject AnalysisJSONObject(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static JSONObject AnalysisObject(JSONArray paramJSONArray, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static List<MatchClothes> JSONArrayToList(String paramString)
  {
    try
    {
      Log.i("ccf", paramString);
      JSONArray localJSONArray = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; ; i++)
      {
        if (i >= localJSONArray.length())
        {
          Log.i("jsonList.size()", localArrayList.size()+"");
          return localArrayList;
        }
        MatchClothes localMatchClothes = new MatchClothes();
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        localMatchClothes.settId(getInt(localJSONObject, "tId"));
        Log.i("jsonObject.getInt", localJSONObject.getInt("tId")+"");
        localMatchClothes.settName(getString(localJSONObject, "tName"));
        localMatchClothes.settSize(getString(localJSONObject, "tSize"));
        localMatchClothes.settDetail(getString(localJSONObject, "tDetail"));
        localMatchClothes.settThumbAdress(getString(localJSONObject, "tThumbAdress"));
        localMatchClothes.settImageAdress(getString(localJSONObject, "tImageAdress"));
        localMatchClothes.setdId(getInt(localJSONObject, "dId"));
        localMatchClothes.setdName(getString(localJSONObject, "dName"));
        localMatchClothes.setdSize(getString(localJSONObject, "dSize"));
        localMatchClothes.setdDetail(getString(localJSONObject, "dDetail"));
        localMatchClothes.setdThumbAdress(getString(localJSONObject, "dThumbAdress"));
        localMatchClothes.setdImageAdress(getString(localJSONObject, "dImageAdress"));
        localMatchClothes.setSex(getString(localJSONObject, "sex"));
        Log.i("jsonObject.getInt", getString(localJSONObject, "sex"));
        localArrayList.add(localMatchClothes);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static List<Share> JSONArrayToList2(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; ; i++)
      {
        if (i >= localJSONArray.length())
        {
          Log.i("jsonList.size()", localArrayList.size()+"");
          return localArrayList;
        }
        Share localShare = new Share();
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        localShare.setShareId(getString(localJSONObject, "shareId"));
        localShare.setUserId(getInt(localJSONObject, "userId"));
        localShare.setUserName(getString(localJSONObject, "userName"));
        localShare.setSharePath(getString(localJSONObject, "sharePath"));
        localShare.setShareTime(getString(localJSONObject, "shareTime"));
        localShare.settId(getInt(localJSONObject, "tId"));
        localShare.settName(getString(localJSONObject, "tName"));
        localShare.settDetail(getString(localJSONObject, "tDetail"));
        localShare.setdId(getInt(localJSONObject, "dId"));
        localShare.setdName(getString(localJSONObject, "dName"));
        localShare.setdDetail(getString(localJSONObject, "dDetail"));
        localShare.setScore(getString(localJSONObject, "score"));
        localArrayList.add(localShare);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static List<Comment> JSONArrayToList3(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; ; i++)
      {
        if (i >= localJSONArray.length())
        {
          Log.i("jsonList.size()", localArrayList.size()+"");
          return localArrayList;
        }
        Comment localComment = new Comment();
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        localComment.setCommentId(getInt(localJSONObject, "commentId").intValue());
        localComment.setShareId(getString(localJSONObject, "shareId"));
        localComment.setContent(getString(localJSONObject, "content"));
        localComment.setSubTime(getString(localJSONObject, "subTime"));
        localComment.setUsername(getString(localJSONObject, "username"));
        localArrayList.add(localComment);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static Integer getInt(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      Integer localInteger = Integer.valueOf(paramJSONObject.getInt(paramString));
      return localInteger;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  public static JSONArray getJSONArray(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  public static JSONArray StringToJSONArray(String paramString)
  {
    try
    {
      return new JSONArray(paramString);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  public static String getString(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = paramJSONObject.getString(paramString);
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.util.AnalysisJson
 * JD-Core Version:    0.6.0
 */