import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageProfile extends JFrame {
	private JPanel contentPane;
	private BorderLayout borderLayout1 = new BorderLayout();
	// 添加的组件
	private JPanel jpanel = new JPanel();
	private JButton jb1 = new JButton();
	private JButton jb2 = new JButton();
	private GridLayout gridLayout = new GridLayout();
	PanelDemo_1 pd = new PanelDemo_1();
	public void initial() {
		// 设置各组件的属性
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);
		this.setSize(new Dimension(350, 560));
		this.setTitle("图像的锐化与模糊处理演示");
		jb1.setFont(new Font("Dialog", Font.BOLD, 13));
		jb1.setText("Image Edge");
		jb1.addActionListener(new ActionListener() {// 添加事件监听器
					public void actionPerformed(ActionEvent e) {
						jb1_actionPerformed(e);
					}
				});
		jb2.setFont(new Font("Dialog", Font.BOLD, 13));
		jb2.setText("Reset");
		jb2.addActionListener(new ActionListener() {// 添加事件监听器
					public void actionPerformed(ActionEvent e) {
						jb2_actionPerformed(e);
					}
				});
		jpanel.setLayout(gridLayout);
		jpanel.add(jb1, null);
		jpanel.add(jb2, null);
		contentPane.add(jpanel, BorderLayout.SOUTH);
		// 在窗口中部添加PanelDemo_1面板
		contentPane.add(pd, BorderLayout.CENTER);
		this.setVisible(true);
	}
	public void jb1_actionPerformed(ActionEvent e) {
		pd.detectImageEgde();// 显示图像轮廓
		pd.repaint();// 绘制显示图像轮廓后的图像
	}
	public void jb2_actionPerformed(ActionEvent e) {
		pd.reset();// 缓冲区图像设为源图像
		pd.repaint();// 绘制源图像
	}
	public static void main(String[] args) {
		new ImageProfile().initial();
	}
}
class PanelDemo_1 extends JPanel {
	private BorderLayout borderLayout = new BorderLayout();
	// 定义新属性
	Image image;// 源图像
	BufferedImage bi1;// 缓冲区图像
	BufferedImage bi2;// 缓冲区图像
	BufferedImage bi3;// 缓冲区图像
	Graphics2D g2d;// 图像上下文
	public PanelDemo_1() {
		this.setLayout(borderLayout);
		loadImage();// 加载图片
		createBufferedImage();// 创建缓冲区图像
		bi1 = bi2;
		this
				.setSize(new Dimension(image.getWidth(this), image
						.getHeight(this)));// 设置面板大小
	}
	public void loadImage() {
		// 加载图片
		image = this.getToolkit().getImage(
				//这里读者如果不填写一个存在的图片名，程序会抛出空指针异常
				ClassLoader.getSystemResource("1.jpg"));// 创建Image对象
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(image, 0);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			e.printStackTrace();// 表示加载失败
		}
		if (image.getWidth(this) == -1) {
			System.out.println("不能创建图象");// 如果不存在退出程序
			System.exit(1);
		}
	}
	public void detectImageEgde() {
		float[] data = { 1.0f, 0.0f, -0.9f, 1.0f, 0.0f, -0.9f, 1.0f, 0.0f,
				-0.9f };
		Kernel kernel = new Kernel(3, 3, data);
		ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);// 创建卷积过滤器
		co.filter(bi2, bi3);// 将存储源图像的缓冲区图像的数据经卷积过滤器处理后进入另一个缓冲区
		bi1 = bi3;// bi1指向处理后的图像缓冲区bi3
	}
	public void createBufferedImage() {
		// 根据image对象创建一个缓冲区图像
		bi2 = new BufferedImage(image.getWidth(this), image.getHeight(this),
				BufferedImage.TYPE_INT_ARGB);
		// 向缓冲区图像中输入原image对象的图象数据
		g2d = bi2.createGraphics();
		g2d.drawImage(this.image, 0, 0, this);// 绘制缓冲区图像
		// 创建另一个空的缓冲区图像，大小和类型相同的bi3
		bi3 = new BufferedImage(image.getWidth(this), image.getHeight(this),
				BufferedImage.TYPE_INT_ARGB);
	}
	public void reset() {
		g2d.setColor(Color.black);
		g2d.clearRect(0, 0, image.getWidth(this), image.getHeight(this));
		g2d.drawImage(this.image, 0, 0, this);// 绘制缓冲区图像
		// 令bi1对象指向源图像存储的bi2缓冲区图像
		bi1 = bi2;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi1, 0, 0, this);
	}
	public void update(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.paintComponent(g);
	}
}
