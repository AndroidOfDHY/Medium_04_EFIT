import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class test2 {
	public static void main(String[] args) {
		try {
		BufferedImage image1 = ImageIO.read(new File("E:\\1.png"));
		BufferedImage image2 = ImageIO.read(new File("E:\\2.png"));
		BufferedImage image3 = ImageIO.read(new File("E:\\3.png"));
		int width = image1.getWidth();
		int height = image1.getHeight();
		BufferedImage bufferedimage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		bufferedimage.getGraphics().drawImage(image1, 0, 0, width, height, null); // 将本地图片画入到内存图片
		bufferedimage.getGraphics().drawImage(image3, 6, 30, image3.getWidth(), image3.getHeight(), null); 
		bufferedimage.getGraphics().drawImage(image2, 6, 30, image2.getWidth(), image2.getHeight(), null); 
		File outFile = new File("E:\\out.png");
		
			
				ImageIO.write(bufferedimage, "png", outFile);// 写图片
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}


