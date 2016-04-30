package com.org.efit.clothes;

import com.dream.myqiyi.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class InfoClothes extends Activity
{
  public void btn_back(View paramView)
  {
    finish();
  }

  public void btn_back_send(View paramView)
  {
    finish();
  }

  public void head_xiaohei(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, InfoClothesPic.class);
    startActivity(localIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.info_clothes);
    Log.i("asdasd", "adsasdasdasdasfdfdf");
   ((Button) findViewById(R.id.daoGou)).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Log.i("asdasd", "adsasdasdasdasfdfdf");
		    Intent localIntent = new Intent();
		    localIntent.setClass(InfoClothes.this, MapAcivity.class);
		    startActivity(localIntent);
			
		}
	});
    getWindow().setSoftInputMode(3);
  }

}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.clothes.InfoClothes
 * JD-Core Version:    0.6.0
 */