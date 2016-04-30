package com.org.efit.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.dream.myqiyi.R;
import com.org.efit.BaseApp;
import com.org.efit.entity.User;
import com.org.efit.util.AnalysisJson;
import com.org.efit.util.HttpUtil;
import java.util.HashMap;

import org.json.JSONObject;

public class Login extends Activity
{
  private EditText mPassword;
  private EditText mUser;

  private void showAlert(String paramString1, String paramString2)
  {
    new AlertDialog.Builder(this).setIcon(getResources().getDrawable(2130837590)).setTitle(paramString1).setMessage(paramString2).create().show();
  }

  public void login_back(View paramView)
  {
    finish();
  }

  public void login_mainweixin(View paramView)
  {
    String str1 = this.mUser.getText().toString();
    String str2 = this.mPassword.getText().toString();
    if (("".equals(this.mUser.getText().toString())) || ("".equals(this.mPassword.getText().toString())))
    {
      showAlert("登录错误", "帐号或者密码不能为空，\n请输入后再登录！");
      return;
    }
    String str3 = getResources().getString(R.string.url) + "user/user.do?act=login";
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", str1);
    localHashMap.put("password", str2);
    String str4 = HttpUtil.sendPostRequest(str3, localHashMap);
    if ((str4 != null) && (str4.equals("200")))
    {
     String msg=HttpUtil.sendPostRequest(getResources().getString(R.string.url)+"user/user.do?act=userDetails", null);
     JSONObject object=AnalysisJson.AnalysisJSONObject(msg);
     User user=new User();
     user.setUsername(AnalysisJson.getString(object, "username"));
     user.setSex(AnalysisJson.getString(object, "sex"));
     user.setT_size(AnalysisJson.getString(object, "topSize"));
     user.setD_size(AnalysisJson.getString(object, "downSize"));
     user.setHeadAdreess(AnalysisJson.getString(object, "headAdreess"));
     ((BaseApp)(getApplication())).put(BaseApp.USER_KEY, user);
      Intent localIntent = new Intent();
      localIntent.setClass(this, LoadingActivity.class);
      startActivity(localIntent);
      finish();
      return;
    }
    showAlert("登录失败", "帐号或者密码错误！");
  }

  public void login_pw(View paramView)
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://#")));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.login );
    this.mUser = ((EditText)findViewById(R.id.login_user_edit));
    this.mPassword = ((EditText)findViewById(R.id.login_passwd_edit));
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.login.Login
 * JD-Core Version:    0.6.0
 */