package com.org.efit.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dream.myqiyi.R;
import com.org.efit.entity.MatchClothes;
import com.org.efit.util.HttpUtil;
import com.org.efit.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class ResultListAdapter extends BaseAdapter
{
  private Context context;
  private LayoutInflater mInflater;
  private List<MatchClothes> resultList = new ArrayList();

  public ResultListAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public void addMore(List<MatchClothes> paramList)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return;
      this.resultList.add((MatchClothes)paramList.get(i));
    }
  }

  public int getCount()
  {
    Log.i("数量", this.resultList.size()+"");
    return this.resultList.size();
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public List<MatchClothes> getResultList()
  {
    return this.resultList;
  }

public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MatchClothes localMatchClothes = (MatchClothes)this.resultList.get(paramInt);
    if (localMatchClothes == null)
      return null;
    Log.i("matchClothes.getdName() ", localMatchClothes.getdName());
    View localView = LayoutInflater.from(this.context).inflate(R.layout.list_result_item  , null);
    String str = this.context.getResources().getString(R.string.url);
     
      Bitmap localBitmap1 = HttpUtil.getHttpBitmap(str + "clothes/" + localMatchClothes.gettThumbAdress());
      if (localBitmap1!=null) {
      Log.i("localBitmap1", localBitmap1.getWidth()+","+localBitmap1.getHeight());
      //localView.findViewById(R.id.imageView1).setImageBitmap(ImageUtil.createBitmapThumbnail(localBitmap1, 144, 216));
      ImageView imageView=((ImageView)localView.findViewById(R.id.imageView1));
      Bitmap bitmap=ImageUtil.createBitmapThumbnail(localBitmap1, 144, 216);
      imageView.setImageBitmap(bitmap);
      
	}
      
      Bitmap localBitmap2 = HttpUtil.getHttpBitmap(str + "clothes/" + localMatchClothes.getdThumbAdress());
      if (localBitmap2!=null) {
     ((ImageView)localView.findViewById(R.id.imageView3)).setImageBitmap(ImageUtil.createBitmapThumbnail(localBitmap2, 144, 216));
      }
      return localView;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.ResultListAdapter
 * JD-Core Version:    0.6.0
 */