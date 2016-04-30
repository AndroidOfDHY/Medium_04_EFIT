package com.org.efit.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ImageUtil
{
//  private static final String bodyFilePath = FileUtil.getSDPath() + File.separator + "efit";
//  public static int color_range = 210;
//
//  public static BufferedImage ImageCompose(Image[] paramArrayOfImage)
//  {
//    int i = 0;
//    int j = 0;
//    try
//    {
//      ArrayList localArrayList = new ArrayList();
//      int k = 0;
//      BufferedImage localBufferedImage2;
//      if (k >= paramArrayOfImage.length)
//      {
//        System.out.println(i + j);
//        localBufferedImage2 = new BufferedImage(i, j, 1);
//      }
//      for (int i1 = 0; ; i1++)
//      {
//        if (i1 >= localArrayList.size())
//        {
//          return localBufferedImage2;
//          System.out.println(paramArrayOfImage[k].getAddress());
//          BufferedImage localBufferedImage1 = ImageIO.read(new File(paramArrayOfImage[k].getAddress()));
//          int m = localBufferedImage1.getWidth();
//          int n = localBufferedImage1.getHeight();
//          if (m * n >= j * i)
//          {
//            j = n;
//            i = m;
//          }
//          localArrayList.add(localBufferedImage1);
//          k++;
//          break;
//        }
//        localBufferedImage2.getGraphics().drawImage((java.awt.Image)localArrayList.get(i1), paramArrayOfImage[i1].getX(), paramArrayOfImage[i1].getY(), ((BufferedImage)localArrayList.get(i1)).getWidth(), ((BufferedImage)localArrayList.get(i1)).getHeight(), null);
//      }
//    }
//    catch (IOException localIOException)
//    {
//      localIOException.printStackTrace();
//    }
//    return null;
//  }
//
//  public static boolean colorInRange(int paramInt)
//  {
//    int i = (0xFF0000 & paramInt) >> 16;
//    int j = (0xFF00 & paramInt) >> 8;
//    int k = paramInt & 0xFF;
//    return (i >= color_range) && (j >= color_range) && (k >= color_range);
//  }

  public static Bitmap createBitmapThumbnail(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = (float) ((double)paramInt1 / (double)i);
    float f2 = (float) ((double)paramInt2 / (double)i);
    Log.i("f1,f2", f1+","+f2);
    Matrix localMatrix = new Matrix();
    
    localMatrix.postScale(f1, f2);
    Log.i("ij", i+","+j);
    Bitmap bitmap= Bitmap.createBitmap(paramBitmap, 0, 0, i, j,localMatrix,false);
  //  Bitmap.createBitmap(source, x, y, width, height, m, filter)
    Log.i("createBitmapThumbnail", bitmap.getWidth()+"");
    return bitmap;
  }

//  public static BufferedImage createResizedCopy(java.awt.Image paramImage, int paramInt1, int paramInt2, boolean paramBoolean)
//  {
//    if (paramBoolean);
//    for (int i = 1; ; i = 2)
//    {
//      BufferedImage localBufferedImage = new BufferedImage(paramInt1, paramInt2, i);
//      Graphics2D localGraphics2D = localBufferedImage.createGraphics();
//      if (paramBoolean)
//        localGraphics2D.setComposite(AlphaComposite.Src);
//      localGraphics2D.drawImage(paramImage, 0, 0, paramInt1, paramInt2, null);
//      localGraphics2D.dispose();
//      return localBufferedImage;
//    }
//  }
//
//  public static void main(String[] paramArrayOfString)
//  {
//    Image[] arrayOfImage = new Image[2];
//    Image localImage1 = new Image();
//    localImage1.setAddress("E:\\1.jpg");
//    localImage1.setX(0);
//    localImage1.setY(0);
//    arrayOfImage[0] = localImage1;
//    Image localImage2 = new Image();
//    localImage2.setAddress("E:\\2.png");
//    localImage2.setX(53);
//    localImage2.setY(22);
//    arrayOfImage[1] = localImage2;
//    File localFile = new File("E:\\a.png");
//    try
//    {
//      ImageIO.write(ImageCompose(arrayOfImage), "png", localFile);
//      return;
//    }
//    catch (IOException localIOException)
//    {
//      localIOException.printStackTrace();
//    }
//  }
//
//  public static BufferedImage makeWhiteClarity(BufferedImage paramBufferedImage)
//  {
//    ImageIcon localImageIcon = new ImageIcon(paramBufferedImage);
//    BufferedImage localBufferedImage = new BufferedImage(localImageIcon.getIconWidth(), localImageIcon.getIconHeight(), 6);
//    Graphics2D localGraphics2D = (Graphics2D)localBufferedImage.getGraphics();
//    localGraphics2D.drawImage(localImageIcon.getImage(), 0, 0, localImageIcon.getImageObserver());
//    int j;
//    for (int i = localBufferedImage.getMinY(); ; i++)
//    {
//      if (i >= localBufferedImage.getHeight())
//      {
//        localGraphics2D.drawImage(localBufferedImage, 0, 0, localImageIcon.getImageObserver());
//        return localBufferedImage;
//      }
//      j = localBufferedImage.getMinX();
//      if (j < localBufferedImage.getWidth())
//        break;
//    }
//    int k = localBufferedImage.getRGB(j, i);
//    if (colorInRange(k));
//    for (int m = 0; ; m = 255)
//    {
//      localBufferedImage.setRGB(j, i, m << 24 | 0xFFFFFF & k);
//      j++;
//      break;
//    }
//  }
}

/* Location:           C:\Documents and Settings\db2admin\桌面\dex2jar-0.0.9.13\dex2jar-0.0.9.13\classes_dex2jar.jar
 * Qualified Name:     com.org.efit.util.ImageUtil
 * JD-Core Version:    0.6.0
 */