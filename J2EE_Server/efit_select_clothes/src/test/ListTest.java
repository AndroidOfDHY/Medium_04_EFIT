import java.util.ArrayList;
import java.util.List;

import com.efit.znxy.entity.Image;
import com.efit.znxy.utils.ImageUtil;


public class ListTest {
public static void main(String[] args) {
	List<Image> images=new ArrayList<Image>();
	Image image1=new Image();
	image1.setX(1);
	Image image2=new Image();
	image1.setX(2);
	images.add(image1);
	images.add(image2);
	for (int i = 0; i < images.size(); i++) {
		Image image3=images.get(i);
		for (int j = 0; j < images.size(); i++) {
			Image image4=images.get(i);
			if (image3==image4) {
				System.out.println(image3.getX());
				images.remove(image4);
			}
		}
	}
	//images.add()
}
}
