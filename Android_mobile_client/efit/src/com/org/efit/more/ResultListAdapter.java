package com.org.efit.more;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dream.myqiyi.R;
import com.org.efit.entity.Clothes;
import com.org.efit.entity.MatchClothes;
import com.org.efit.util.HttpUtil;
import com.org.efit.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class ResultListAdapter extends BaseAdapter
{
  private Context context;
  private LayoutInflater mInflater;
  private List<Clothes> resultList = new ArrayList();

  public ResultListAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public void addMore(List<Clothes> paramList)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return;
      this.resultList.add((Clothes)paramList.get(i));
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

  public List<Clothes> getResultList()
  {
    return this.resultList;
  }


public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
	  Clothes localClothes = (Clothes)this.resultList.get(paramInt);
    if (localClothes == null)
      return null;
    Log.i("clothes.getdName() ", localClothes.getClothesName());
    View localView = LayoutInflater.from(this.context).inflate(R.layout.list_single_clotehs_item  , null);
    String str = this.context.getResources().getString(R.string.url);
     
      Bitmap localBitmap1 = HttpUtil.getHttpBitmap(str + "clothes/" + localClothes.getThumbAdress());
      if (localBitmap1!=null) {
      Log.i("localBitmap1", localBitmap1.getWidth()+","+localBitmap1.getHeight());
     ((ImageView) localView.findViewById(R.id.clothes_img)).setImageBitmap(ImageUtil.createBitmapThumbnail(localBitmap1, 144, 216));
      }
      ((TextView)localView.findViewById(R.id.title_text )).setText(localClothes.getClothesName());
      ((TextView)localView.findViewById(R.id.type_text )).setText("类型:" + localClothes.getType());
      ((TextView)localView.findViewById(R.id.sex_text )).setText("性别：" + localClothes.getSex());
      ((TextView)localView.findViewById(R.id.size_text )).setText("尺寸：" + localClothes.getSize());
      ((TextView)localView.findViewById(R.id.brand_text )).setText("品牌：" + localClothes.getBrand());
      ((TextView)localView.findViewById(R.id.score_text )).setText("评分：" + localClothes.getScore());
      ((TextView)localView.findViewById(R.id.sub_time_text)).setText("上架时间：" + localClothes.getSubmitTime());
      return localView;
  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.search.ResultListAdapter
 * JD-Core Version:    0.6.0
 */