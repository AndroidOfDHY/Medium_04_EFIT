package com.org.efit.home;

import com.dream.myqiyi.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter
{
  Context mContext;
  int[] res = { R.drawable.nav_head_1, R.drawable.nav_head_2, R.drawable.nav_head_3, R.drawable.nav_head_4, R.drawable.nav_head_5, R.drawable.nav_head_6, R.drawable.nav_head_7 };

  public GalleryAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public int getCount()
  {
    return this.res.length;
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = LayoutInflater.from(this.mContext).inflate(R.layout.gallery_item , null);
    ((ImageView)paramView.findViewById(R.id.home_img )).setImageResource(this.res[paramInt]);
    return paramView;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.home.GalleryAdapter
 * JD-Core Version:    0.6.0
 */