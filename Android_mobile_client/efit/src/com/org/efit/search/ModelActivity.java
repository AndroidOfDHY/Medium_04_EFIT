package com.org.efit.search;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

import com.dream.myqiyi.R;
import com.org.efit.util.HttpUtil;
import java.io.IOException;
import java.util.HashMap;

public class ModelActivity extends Activity
{
  private HashMap<String, String> hashMap;

  private void prepareView()
  {
      String str1 = getResources().getString(R.string.url);
      String str2 = HttpUtil.sendPostRequest(str1 + "user/match.do?act=androidWear", this.hashMap);
      if (!str2.equals(""))
      {
        Bitmap localBitmap = HttpUtil.getHttpBitmap(str1 + str2);
        if (localBitmap != null)
        {
          ((ImageView)findViewById(R.id.model)).setImageBitmap(localBitmap);
          return;
        }
        Toast.makeText(this, "Image error!", 1).show();
        return;
      }
   

   // Toast.makeText(this, "Image error!", 1).show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.show_model );
    this.hashMap = ((HashMap)getIntent().getSerializableExtra("hashMap"));
    prepareView();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    finish();
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.ModelActivity
 * JD-Core Version:    0.6.0
 */