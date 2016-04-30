package com.org.efit.clothes;

import com.dream.myqiyi.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class InfoClothesPic extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.info_clothes_pic);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    finish();
    return true;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.clothes.InfoClothesPic
 * JD-Core Version:    0.6.0
 */