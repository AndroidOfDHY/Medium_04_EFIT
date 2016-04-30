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
	// ��ӵ����
	private JPanel jpanel = new JPanel();
	private JButton jb1 = new JButton();
	private JButton jb2 = new JButton();
	private GridLayout gridLayout = new GridLayout();
	PanelDemo_1 pd = new PanelDemo_1();
	public void initial() {
		// ���ø����������
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);
		this.setSize(new Dimension(350, 560));
		this.setTitle("ͼ�������ģ��������ʾ");
		jb1.setFont(new Font("Dialog", Font.BOLD, 13));
		jb1.setText("Image Edge");
		jb1.addActionListener(new ActionListener() {// ����¼�������
					public void actionPerformed(ActionEvent e) {
						jb1_actionPerformed(e);
					}
				});
		jb2.setFont(new Font("Dialog", Font.BOLD, 13));
		jb2.setText("Reset");
		jb2.addActionListener(new ActionListener() {// ����¼�������
					public void actionPerformed(ActionEvent e) {
						jb2_actionPerformed(e);
					}
				});
		jpanel.setLayout(gridLayout);
		jpanel.add(jb1, null);
		jpanel.add(jb2, null);
		contentPane.add(jpanel, BorderLayout.SOUTH);
		// �ڴ����в����PanelDemo_1���
		contentPane.add(pd, BorderLayout.CENTER);
		this.setVisible(true);
	}
	public void jb1_actionPerformed(ActionEvent e) {
		pd.detectImageEgde();// ��ʾͼ������
		pd.repaint();// ������ʾͼ���������ͼ��
	}
	public void jb2_actionPerformed(ActionEvent e) {
		pd.reset();// ������ͼ����ΪԴͼ��
		pd.repaint();// ����Դͼ��
	}
	public static void main(String[] args) {
		new ImageProfile().initial();
	}
}
class PanelDemo_1 extends JPanel {
	private BorderLayout borderLayout = new BorderLayout();
	// ����������
	Image image;// Դͼ��
	BufferedImage bi1;// ������ͼ��
	BufferedImage bi2;// ������ͼ��
	BufferedImage bi3;// ������ͼ��
	Graphics2D g2d;// ͼ��������
	public PanelDemo_1() {
		this.setLayout(borderLayout);
		loadImage();// ����ͼƬ
		createBufferedImage();// ����������ͼ��
		bi1 = bi2;
		this
				.setSize(new Dimension(image.getWidth(this), image
						.getHeight(this)));// ��������С
	}
	public void loadImage() {
		// ����ͼƬ
		image = this.getToolkit().getImage(
				//��������������дһ�����ڵ�ͼƬ����������׳���ָ���쳣
				ClassLoader.getSystemResource("1.jpg"));// ����Image����
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(image, 0);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			e.printStackTrace();// ��ʾ����ʧ��
		}
		if (image.getWidth(this) == -1) {
			System.out.println("���ܴ���ͼ��");// ����������˳�����
			System.exit(1);
		}
	}
	public void detectImageEgde() {
		float[] data = { 1.0f, 0.0f, -0.9f, 1.0f, 0.0f, -0.9f, 1.0f, 0.0f,
				-0.9f };
		Kernel kernel = new Kernel(3, 3, data);
		ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);// �������������
		co.filter(bi2, bi3);// ���洢Դͼ��Ļ�����ͼ������ݾ��������������������һ��������
		bi1 = bi3;// bi1ָ������ͼ�񻺳���bi3
	}
	public void createBufferedImage() {
		// ����image���󴴽�һ��������ͼ��
		bi2 = new BufferedImage(image.getWidth(this), image.getHeight(this),
				BufferedImage.TYPE_INT_ARGB);
		// �򻺳���ͼ��������ԭimage�����ͼ������
		g2d = bi2.createGraphics();
		g2d.drawImage(this.image, 0, 0, this);// ���ƻ�����ͼ��
		// ������һ���յĻ�����ͼ�񣬴�С��������ͬ��bi3
		bi3 = new BufferedImage(image.getWidth(this), image.getHeight(this),
				BufferedImage.TYPE_INT_ARGB);
	}
	public void reset() {
		g2d.setColor(Color.black);
		g2d.clearRect(0, 0, image.getWidth(this), image.getHeight(this));
		g2d.drawImage(this.image, 0, 0, this);// ���ƻ�����ͼ��
		// ��bi1����ָ��Դͼ��洢��bi2������ͼ��
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
