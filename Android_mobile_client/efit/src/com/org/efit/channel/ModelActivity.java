package com.org.efit.channel;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;
import com.org.efit.util.HttpUtil;
import java.io.IOException;

public class ModelActivity extends Activity
{
  private String imgUrl;

  private void prepareView()
  {
      String str = getResources().getString(com.dream.myqiyi.R.string.url);
      if (!this.imgUrl.equals(""))
      {
        Bitmap localBitmap = HttpUtil.getHttpBitmap(str + this.imgUrl);
        if (localBitmap != null)
        {
          ((ImageView)findViewById(com.dream.myqiyi.R.id.model)).setImageBitmap(localBitmap);
          return;
        }
        Toast.makeText(this, "Image error!", 1).show();
        return;
      }
//    catch (IOException localIOException)
//    {
//      Toast.makeText(this, "Newwork error!", 1).show();
//      localIOException.printStackTrace();
//      return;
//    }
    Toast.makeText(this, "Image error!", 1).show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    //setContentView(R.layout.info_clothes);
    setContentView(com.dream.myqiyi.R.layout.show_model);
    this.imgUrl = ((String)getIntent().getSerializableExtra("url"));
    prepareView();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    finish();
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.channel.ModelActivity
 * JD-Core Version:    0.6.0
 */