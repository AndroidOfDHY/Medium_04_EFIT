package com.org.efit.login;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.dream.myqiyi.R;
import com.org.efit.util.HttpUtil;
import java.util.HashMap;

import com.org.efit.channel.ModelActivity;
import com.org.efit.takephoto.TakePhoto;
public class Register extends Activity
{
  private String dSize = null;
  private Spinner dSizeSpinner;
  private String sex = null;
  private Spinner sexSpinner;
  private String tSize = null;
  private Spinner tSizeSpinner;
  private String headAdreess=null;
  private void showAlert(String paramString1, String paramString2)
  {
    new AlertDialog.Builder(this).setIcon(getResources().getDrawable(R.drawable.login_error_icon)).setTitle(paramString1).setMessage(paramString2).create().show();
  }

  public void btn_back(View paramView)
  {
    finish();
  }
	public void takePhoto(View paramView){
    	Intent intent=new Intent();
    	//intent.setClass(this,TakePhoto.class);
    	intent.setClass(this, TakePhoto.class);
    	 startActivityForResult(intent,0);
    }
  @SuppressWarnings("unchecked")
public void btn_back_send(View paramView)
  {
    String str1 = ((EditText)findViewById(R.id.password )).getText().toString();
    String str2 = ((EditText)findViewById(R.id.password2)).getText().toString();
    String str3 = ((EditText)findViewById(R.id.username)).getText().toString();
    if ((this.sex == null) || (this.tSize == null) || (this.dSize == null) || (str1.equals("")) || (str2.equals("")) || (str3.length() < 6))
    {
      showAlert("提示", "请填写完整");
      return;
    }
    if (!str1.equals(str2))
    {
      showAlert("提示", "密码不相同！");
      return;
    }
    String str4 = getResources().getString(R.string.url) + "user/user.do?act=register";
    @SuppressWarnings("rawtypes")
	HashMap localHashMap = new HashMap();
    localHashMap.put("username", str3);
    localHashMap.put("password", str1);
    localHashMap.put("sex", this.sex);
    localHashMap.put("topSize", this.tSize);
    localHashMap.put("downSize", this.dSize);
    localHashMap.put("headAdreess",headAdreess);
    String str5 = HttpUtil.sendPostRequest(str4, localHashMap);
    if ((str5 != null) && (str5.equals("200")))
    {
    	Toast.makeText(this, "注册成功", 1).show();
      
      finish();
      return;
    }
    showAlert("提示", "注册失败！");
  }

  protected void onCreate(Bundle paramBundle)
  {
    setContentView(R.layout.register);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(3);
    this.sexSpinner = ((Spinner)findViewById(R.id.sexSpinner));
    this.tSizeSpinner = ((Spinner)findViewById(R.id.tSizeSpinner));
    this.dSizeSpinner = ((Spinner)findViewById(R.id.dSizeSpinner));
    this.sexSpinner.setOnItemSelectedListener(new OnItemSelectedListenerImpl1());
    this.tSizeSpinner.setOnItemSelectedListener(new OnItemSelectedListenerImpl2());
    this.dSizeSpinner.setOnItemSelectedListener(new OnItemSelectedListenerImpl3());
  }

@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	   if(data==null){return;}
	   String temp=data.getStringExtra("image");
	   if(temp!=null){
	  headAdreess=temp;
	   }
	}
  private class OnItemSelectedListenerImpl1
    implements AdapterView.OnItemSelectedListener
  {
    private OnItemSelectedListenerImpl1()
    {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        Register.this.sex = null;
        return;
      case 1:
        Register.this.sex = "M";
        return;
      case 2:
      }
      Register.this.sex = "W";
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
    }
  }

  private class OnItemSelectedListenerImpl2
    implements AdapterView.OnItemSelectedListener
  {
    private OnItemSelectedListenerImpl2()
    {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        Register.this.tSize = null;
        return;
      case 1:
        Register.this.tSize = "s";
        return;
      case 2:
        Register.this.tSize = "m";
        return;
      case 3:
      }
      Register.this.tSize = "l";
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
    }
  }

  private class OnItemSelectedListenerImpl3
    implements AdapterView.OnItemSelectedListener
  {
    private OnItemSelectedListenerImpl3()
    {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        Register.this.dSize = null;
        return;
      case 1:
        Register.this.dSize = "s";
        return;
      case 2:
        Register.this.dSize = "m";
        return;
      case 3:
      }
      Register.this.dSize = "l";
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
    }
    


  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.login.Register
 * JD-Core Version:    0.6.0
 */