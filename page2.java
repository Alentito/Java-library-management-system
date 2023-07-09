package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import library.page1.RoundedPanel;

public class page2 {

	JFrame frame;
	public static void main(String[] args)
	{
		page2 frame1=new page2();
		frame1.frame.setVisible(true);
	}
	public page2()
	{
		JButton imgbtn=new JButton(new ImageIcon(((new ImageIcon("got.png")).getImage()).getScaledInstance(195, 150, java.awt.Image.SCALE_SMOOTH)));
		imgbtn.setBounds(12,12,195,150);
		imgbtn.setFocusable(false);
		imgbtn.setBorderPainted(false);
		imgbtn.setFocusPainted(false);
		imgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				page1 obj1=new page1();
				obj1.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		

		RoundedPanel b1=new RoundedPanel(30,Color.red);
		b1.setPreferredSize(new Dimension(220,300));
		b1.add(imgbtn);
		b1.setLayout(null);
		b1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		frame=new JFrame();
		frame.setTitle("LIBRARY MANAGEMNET SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setSize(1080,720);
		frame.setVisible(true);
		frame.add(b1);
		frame.setLocationRelativeTo(null);
		ImageIcon image=new ImageIcon("library.png");
		frame.setIconImage(image.getImage());
	}
	@SuppressWarnings("serial")
	class RoundedPanel extends JPanel
	{
		private Color backgroundColor;
		private int cornerRadius=15;
		
		public RoundedPanel(LayoutManager layout,int radius) {
			super(layout);
			cornerRadius=radius;
		}
		
		public RoundedPanel(int radius,Image image) {
			// TODO Auto-generated method stub
			super();
			cornerRadius=radius;
			
			//BufferedImage im=ImageIO.read(new File("got.jpg"));
			//JPanel 
			
			
			
		}

		public RoundedPanel(LayoutManager layout,int radius,Color bgColor) {
			super(layout);
			cornerRadius=radius;
			backgroundColor=bgColor;
			
		}
		public RoundedPanel(int radius) {
			super();
			cornerRadius=radius;
		}
		public RoundedPanel(int radius,Color bgColor) {
			super();
			cornerRadius=radius;
			backgroundColor=bgColor;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Dimension arcs=new Dimension(cornerRadius,cornerRadius);
			int width=getWidth();
			int height=getHeight();
			Graphics2D graphics=(Graphics2D)g;
			graphics.setColor(backgroundColor);
			
			if(backgroundColor !=null)
			{
				graphics.setColor(backgroundColor);
			}
			else
			{
				graphics.setColor(getBackground());
			}
			graphics.fillRoundRect(0,0,width-1,height-1,arcs.width,arcs.height);
			graphics.setColor(getForeground());
			
		}
	}
}
