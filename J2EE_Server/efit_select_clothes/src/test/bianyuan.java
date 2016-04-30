import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.http.impl.conn.tsccm.WaitingThread;


public class bianyuan {
	public final BufferedImage getPicEdge(BufferedImage originalPic) {
		int imageWidth = originalPic.getWidth();
		int imageHeight = originalPic.getHeight();

		BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_3BYTE_BGR);

		float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.0f, -1.0f, 0.0f,
				-1.0f, 0.0f };

		// AffineTransform at = new AffineTransform();
		Kernel kernel = new Kernel(3, 3, elements);
		ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		cop.filter(originalPic, newPic);
		return newPic;
	}
	public final BufferedImage getPicture(BufferedImage originalPic) {
		int imageWidth = originalPic.getWidth();
		int imageHeight = originalPic.getHeight();
        int brighter=10;
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
//	public static void main(String[] args) {
//		try {
//		BufferedImage image=	new bianyuan().getPicture(ImageIO.read(new File("d://1.png")));
//		ImageIO.write(image, "gif", new File("d://2.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	private static Thread t;
	public static void main(String[] args) {
    t=new Thread(){
    	  public void run() {
    		  for(int i=0;i<10;i++){
    			  System.out.println(i);
//    			  try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
    		  }
    	  };
      };
      t.start();
      t.stop();
		System.out.println("结束");
		
		
	}
	
}
