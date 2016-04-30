package com.org.efit.search;

import com.dream.myqiyi.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter
{
  Context mContext;
  int[] test1 = { R.drawable.nav_head_1 , R.drawable.nav_head_2, R.drawable.nav_head_3, R.drawable.nav_head_4 };

  public GridAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public int getCount()
  {
    return this.test1.length;
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
      paramView = LayoutInflater.from(this.mContext).inflate(R.layout.gallery_item, null);
    ((ImageView)paramView.findViewById(R.id.home_img )).setImageResource(this.test1[paramInt]);
    return paramView;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.GridAdapter
 * JD-Core Version:    0.6.0
 */