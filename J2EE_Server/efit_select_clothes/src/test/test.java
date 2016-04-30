import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class test {
public static void main(String args[]) {
try {
// 读取第一张图片
File fileOne = new File("E:\\1.png");
BufferedImage ImageOne = ImageIO.read(fileOne);
int width = ImageOne.getWidth();// 图片宽度
int height = ImageOne.getHeight();// 图片高度

// 从图片中读取RGB
int[] ImageArrayOne = new int[width * height];
ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne,
0, width);

// 对第二张图片做相同的处理
File fileTwo = new File("E:\\2.png");
BufferedImage ImageTwo = ImageIO.read(fileTwo);
int width2 = ImageTwo.getWidth();// 图片宽度
int height2 = ImageTwo.getHeight();// 图片高度
int[] ImageArrayTwo = new int[width2 * height2];
ImageArrayTwo = ImageTwo.getRGB(0, 0, width2, height2, ImageArrayTwo,
0, width2);
//System.out.println(ImageArrayOne.length+"");
//System.out.println(ImageArrayTwo.length+"");
for (int i = 0; i < ImageArrayTwo.length; i++) {
	if (ImageArrayTwo[i]==16777215) {

			ImageArrayOne[i]=ImageArrayTwo[i];
		
		
	}
	System.out.print(ImageArrayTwo[i]+",");
}
// 生成新图片
// BufferedImage ImageNew = new BufferedImage(width * 2, height,
// BufferedImage.TYPE_INT_RGB);
BufferedImage ImageNew = new BufferedImage(width2, height2,
BufferedImage.TYPE_INT_RGB);
ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
//ImageNew.setRGB(0, 0, width2, height2, ImageArrayTwo, 0, width2);// 设置右半部分的RGB
//
File outFile = new File("E:\\as\\out.png");
ImageIO.write(ImageNew, "png", outFile);// 写图片
} catch (Exception e) {
e.printStackTrace();
}
}
}


