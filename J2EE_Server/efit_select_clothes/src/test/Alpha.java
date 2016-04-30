import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Alpha {
/**
 * @param args
 * @throws IOException 
 */
public Alpha() throws IOException
{
 //创建一个600*400的图象
 BufferedImage image=new BufferedImage(600,400,BufferedImage.TYPE_INT_RGB);
 //创建java2D对象
 Graphics2D g2d=image.createGraphics();
 
 //g2d.setBackground(Color.PINK);
// 填充背景
 g2d.setColor(Color.WHITE);
 g2d.fillRect(0, 0, 600, 400);
 

 

  // 创建AlphaComposite对象，并设定透明度
   AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
   g2d.setComposite(ac);
 //  g2d.setFont(new Font("隶书", Font.PLAIN, 42));
 // g2d.setColor(Color.black);
  g2d.drawImage(ImageIO.read(new File("d://20130306192752375.png")), null, 1, 1);
  
 //画一个背景色为..的长方形
  
   AlphaComposite ac2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f);
    g2d.setComposite(ac2);
  g2d.setColor(Color.CYAN);
  g2d.fill3DRect(10, 200, 180, 80,false);
  
 g2d.dispose();
 try {
  FileOutputStream fs=new FileOutputStream("d://alpha.jpg");
  ImageIO.write(image, "jpg", fs);
 } catch (Exception e) {
  // TODO 自动生成 catch 块
  e.printStackTrace();
 }
}
public static void main(String[] args) {
 // TODO 自动生成方法存根
 try {
	new Alpha();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}


}
