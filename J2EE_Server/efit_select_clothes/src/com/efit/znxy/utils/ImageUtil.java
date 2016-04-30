package com.efit.znxy.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



import com.efit.znxy.entity.Image;
import com.ideatech.common.MyLog;


public class ImageUtil {
  public static BufferedImage ImageCompose(Image images[]){//图片合成
	  MyLog.print("图片合成");
		try {
			int tempW=0;
			int tempH=0;
			List<BufferedImage> bufferedImages=new ArrayList<BufferedImage>();
       for (int i = 0; i < images.length; i++) 
        {
    	   System.out.println(images[i].getAddress());
    	   BufferedImage image = ImageIO.read(new File(images[i].getAddress()));
   		  int width = image.getWidth();
   		   int height = image.getHeight();
		   if (width*height>=tempH*tempW) {
			tempH=height;
			tempW=width;
		   }
		   bufferedImages.add(image);
	    }
       System.out.println(tempW+""+tempH);
		BufferedImage bufferedimage = new BufferedImage(tempW, tempH,
				BufferedImage.TYPE_INT_RGB);
	       for (int j = 0; j < bufferedImages.size(); j++) {
	    	   bufferedimage.getGraphics().drawImage(bufferedImages.get(j), images[j].getX(), images[j].getY(), bufferedImages.get(j).getWidth(), bufferedImages.get(j).getHeight(), null);
		    }
	       return bufferedimage;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
  }

  public static BufferedImage makeWhiteClarity(BufferedImage image){//白色透明化
			ImageIcon imageIcon = new ImageIcon(image);
			BufferedImage bufferedImage = new BufferedImage(
					imageIcon.getIconWidth(), imageIcon.getIconHeight(),
					BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
			g2D.drawImage(imageIcon.getImage(), 0, 0,
					imageIcon.getImageObserver());
			int alpha = 0;
			for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage
					.getHeight(); j1++) {
				for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage
						.getWidth(); j2++) {
					int rgb = bufferedImage.getRGB(j2, j1);
					if (colorInRange(rgb))
						alpha = 0;
					else
						alpha = 255;
					rgb = (alpha << 24) | (rgb & 0x00ffffff);
					bufferedImage.setRGB(j2, j1, rgb);
				}
			}
		//	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f);
		//	g2D.setComposite(ac);
			g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
			
			
			g2D.dispose();
			
			// 生成图片为PNG
			//String outFile = path.substring(0, path.lastIndexOf("."));
			return bufferedImage;
		//	ImageIO.write(bufferedImage, "png", new File("E:\\Tomcat 7.0\\webapps\\efit_select_clothes\\pz\\pzimage\\ssss" + ".png"));

	}
  public static int color_range = 110;
	public static boolean colorInRange(int color) {
		int red = (color & 0xff0000) >> 16;
		int green = (color & 0x00ff00) >> 8;
		int blue = (color & 0x0000ff);
		if (red >= color_range && green >= color_range && blue >= color_range)
			return true;
		return false;
	}
	
	public static BufferedImage createResizedCopy(java.awt.Image originalImage, int scaledWidth,//缩小放大图片
            int scaledHeight, boolean preserveAlpha) {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB
                : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight,
                imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }
	/**
	 * 
	 * @param originalPic
	 * @param brighter 变亮值
	 * @return
	 */
	public static BufferedImage brighten(BufferedImage originalPic,int brighter) {//变亮处理
		int imageWidth = originalPic.getWidth();
		int imageHeight = originalPic.getHeight();
  //      int brighter=80;
		BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_3BYTE_BGR);

		short[] brighten = new short[256];
		short pixelValue;

		for (int i = 0; i < 256; i++) {
			pixelValue = (short) (i + brighter);
			if (pixelValue > 255) {
				pixelValue = 255;
			}
			brighten[i] = pixelValue;
		}

		LookupTable lut = new ShortLookupTable(0, brighten);
		LookupOp lop = new LookupOp(lut, null);
		lop.filter(originalPic, newPic);
		return newPic;
	}
  public static void main(String[] args)  {
//      Image images[]=new Image[2];
//		Image image1=new Image();
//		image1.setAddress("E:\\1.jpg");
//		image1.setX(0);
//		image1.setY(0);
//		images[0]=image1;
//		
//		Image image2=new Image();
//		image2.setAddress("E:\\2.png");
//		image2.setX(53);
//		image2.setY(22);
//		images[1]=image2;
//		File outFile = new File("E:\\a.png");
//		try {
//			ImageIO.write(ImageCompose(images),"png",outFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	  try {
	  BufferedImage image = ImageIO.read(new File("E:\\2.png"));
	  String outFile = FileUtil.randomFileName("png");
      
		ImageIO.write(ImageUtil.makeWhiteClarity(image), "png", new File("E:\\"+ outFile));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  }
  

}
