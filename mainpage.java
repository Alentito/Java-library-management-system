package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class mainpage {

//	public mainpage()
//	{
		//setUndecorated(true);
		//initComponents();
	//	this.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
	////}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mainpage m=new mainpage();
		
		
		JLabel menutitle=new JLabel("LIBRARY");
		menutitle.setBounds(60,0,150,85);
		menutitle.setFont(new Font("",Font.BOLD,25));
		menutitle.setForeground(Color.white);
		
		JPanel topleft=new JPanel();
		//topleft.setBackground(Color.yellow);
		topleft.setBackground(Color.decode("#8117B7"));
		topleft.setPreferredSize(new Dimension(200,30));
		topleft.add(menutitle);
		topleft.setLayout(null);
		
		
		
		//JPanel topsearch=new JPanel();
	//	topsearch.setBounds(120, 23, 300, 40);
		//topsearch.setBackground(Color.red);
		
	ImageIcon searchimage=new ImageIcon("C:\\Users\\ASUS\\Downloads\\icon2.png");
		//Image img = searchimage.getImage() ; 
		//Image newimg = img.getScaledInstance( 40,35, java.awt.Image.SCALE_SMOOTH ) ;
		
		
		JButton searchbtn=new JButton("");
		
		//JPanel searchbtn
		searchimage.setImage(searchimage.getImage());
		//searchbtn.setIcon(new ImageIcon( searchimage) );
		searchbtn.setBounds(514,25,40,35);
		//searchbtn.setIcon(newimg);
		searchbtn.setFocusable(false);
		searchbtn.setBorderPainted(false);
		searchbtn.setBackground(Color.decode("#8117B7"));
		
		
		
		JLabel searchtitle=new JLabel("Search Books");
		searchtitle.setBounds(15,-3,100,40);
		searchtitle.setFont(new Font("",Font.PLAIN,16));
		searchtitle.setForeground(Color.decode("#8F8F8F"));
		searchtitle.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		
		RoundedPanel topsearch=m.new RoundedPanel(10,Color.white);
		topsearch.setBounds(120,25,400,35);
		topsearch.setLayout(null);
		topsearch.add(searchtitle);
		topsearch.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		
		JPanel topmid=new JPanel();
		topmid.setBackground(Color.decode("#8117B7"));
		topmid.setPreferredSize(new Dimension(200,30));
		topmid.add(topsearch);
		topmid.add(searchbtn);
		topmid.setLayout(null);
		
		
		JPanel topright =new JPanel();
		topright.setBounds(500,30,300,40);
		topright.setBackground(Color.blue);
		
		JPanel header=new JPanel();
		header.setBackground(Color.decode("#8117B7"));
		header.setPreferredSize(new Dimension(100,85));
		header.setLayout(new BorderLayout());
		header.add(topleft,BorderLayout.WEST);
		header.add(topmid,BorderLayout.CENTER);
		//header.add(topsearch);
		//header.add(topright);
		
		
		
		
		
		//BufferedImage im=ImageIO.read(new File("got.jpg"));
		RoundedPanel v1=m.new RoundedPanel(20,Color.red);
		//ImageIcon im=new ImageIcon("got.jpg");
		//v1.setImage(im.getImage());
		v1.setBounds(12,12,195,150);
		v1.setLayout(null);
		v1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		
		/*ImageIcon img2=new ImageIcon("got.png");
		Image img3 = img2.getImage() ; 
		Image img5 = img3.getScaledInstance( 195,150, java.awt.Image.SCALE_SMOOTH ) ;
		*/
		JLabel img1=new JLabel();
		img1.setBounds(12,12,195,150);
		
		
		//ImageIcon img2=new ImageIcon("got.png");

//JButton button = new JButton(new ImageIcon(((new ImageIcon("images/pic.jpg")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		JButton imgbtn=new JButton(new ImageIcon(((new ImageIcon("got.png")).getImage()).getScaledInstance(195, 150, java.awt.Image.SCALE_SMOOTH)));
		imgbtn.setBounds(12,12,195,150);
		imgbtn.setFocusable(false);
		imgbtn.setBorderPainted(false);
		imgbtn.setFocusPainted(false);

		imgbtn.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		JLabel bookname=new JLabel("Game Of Thrones");
		bookname.setHorizontalAlignment(JLabel.CENTER);
		bookname.setFont(new Font("",Font.BOLD,16));
		bookname.setForeground(Color.decode("#505050"));
		bookname.setBounds(0,180,220,20);
		
		
		JLabel authorname=new JLabel("George");
		authorname.setHorizontalAlignment(JLabel.CENTER);
		authorname.setFont(new Font("",Font.BOLD,16));
		authorname.setForeground(Color.decode("#505050"));
		authorname.setBounds(0,200,220,20);
		
		
		
		JButton buy=new JButton();
		buy.setBounds(40,240,140,40);
		buy.setBorder(new RoundedBorder(40,Color.decode("#A61EEB")));
		buy.setBackground(Color.decode("#A61EEB"));
		buy.setForeground(Color.white);
		buy.setFocusable(false);
		buy.setOpaque(false);
		buy.setFocusPainted(false);

		JLabel bn=new JLabel("BUY");
		bn.setHorizontalAlignment(JLabel.CENTER);
		bn.setFont(new Font("",Font.BOLD,16));
		bn.setForeground(Color.white);
		bn.setBounds(0,250,220,20);
		
		//imgbtn.setIcon(img5);
		//ImageIcon image=new ImageIcon("library.png");
		//img1.setImage(image.getImage());
		//ImageIcon img2=new ImageIcon("C:\\Users\\ASUS\\Downloads\\icon2.png");
		//Image img = img2.getImage() ; 
		//Image newimg = img.getScaledInstance( 40,35, java.awt.Image.SCALE_SMOOTH ) ;
		//img1.add(newimg);
		
		RoundedPanel v2=m.new RoundedPanel(20,Color.red);
		v2.setBounds(12,12,195,150);
		v2.setLayout(null);
		v2.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		
		RoundedPanel b1=m.new RoundedPanel(30,Color.white);
		b1.setPreferredSize(new Dimension(220,300));
		b1.add(imgbtn);
		b1.add(bookname);
		b1.add(authorname);
		b1.add(bn);
		b1.add(buy);
		
		b1.setLayout(null);
		//b1.setLayout(new FlowLayout(FlowLayout.CENTER));
		b1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		RoundedPanel b2=m.new RoundedPanel(30,Color.white);
		b2.setPreferredSize(new Dimension(220,300));
		b2.setLayout(null);
		b2.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		RoundedPanel b3=m.new RoundedPanel(30,Color.white);
		b3.setPreferredSize(new Dimension(220,300));
		b3.setLayout(null);
		b3.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		RoundedPanel b4=m.new RoundedPanel(30,Color.white);
		b4.setPreferredSize(new Dimension(220,300));
		b4.setLayout(null);
		b4.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		RoundedPanel b5=m.new RoundedPanel(30,Color.white);
		b5.setPreferredSize(new Dimension(220,300));
		b5.setLayout(null);
		b5.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		RoundedPanel b6=m.new RoundedPanel(30,Color.red);
		b6.setPreferredSize(new Dimension(150,280));
		b6.setLayout(null);
		b6.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		
		JPanel Bestseller =new JPanel();
		Bestseller.setBackground(Color.decode("#D9C4E3"));
		//Bestseller.setBounds(500,30,1080,300);
		Bestseller.setPreferredSize(new Dimension(1080,180));
		Bestseller.add(b1);
		Bestseller.add(b2);
		Bestseller.add(b3);
		Bestseller.add(b4);
		//Bestseller.add(b5);
		Bestseller.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		
		/*JPanel bscontainer=new JPanel();
		bscontainer.setBackground(Color.decode("#D9C4E3"));
		//bscontainer.setBounds(0,0,1080,400);
		bscontainer.setPreferredSize(new Dimension(1080,600));
		bscontainer.add(Bestseller);
		bscontainer.setLayout(null);*/
		JLabel bstitle=new JLabel("BEST SELLERS");
		bstitle.setBounds(100,5,1080,70);
		bstitle.setFont(new Font("",Font.BOLD,28));
		//bstitle.setPreferredSize(new Dimension(1080,70));
		bstitle.setHorizontalAlignment(JLabel.LEFT);
		bstitle.setForeground(Color.decode("#A61EEB"));
		
		JPanel bcon = new JPanel();
		bcon.setPreferredSize(new Dimension(1080,70));
		bcon.setBackground(Color.decode("#D9C4E3"));
		
		bcon.add(bstitle);
		bcon.setLayout(null);
		
		JPanel containmid =new JPanel();
		containmid.setBackground(Color.red);
		containmid.setPreferredSize(new Dimension(1080,400));
		containmid.setLayout(new BorderLayout());
		containmid.add(bcon,BorderLayout.NORTH);
		containmid.add(Bestseller,BorderLayout.CENTER);

		
		
		/*JPanel ultramid=new JPanel();
		ultramid.setBackground(Color.green);
		ultramid.setLayout(new BorderLayout());
		ultramid.add(containmid,BorderLayout.NORTH);*/
		
	JScrollPane supermid=new JScrollPane();
		//JPanel supermid=new JPanel();
		supermid.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		supermid.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//supermid.setBounds(0,0,1080,400);
		//supermid.setPreferredSize(new Dimension(1080,00));
		supermid.setBackground(Color.blue);
		supermid.setViewportView(containmid);
		//supermid.setLayout(null);
		
		/*JPanel ultramid=new JPanel();
		ultramid.setBackground(Color.green);
		ultramid.add(supermid);*/
		
		JPanel container =new JPanel();
		container.setBackground(Color.decode("#D9C4E3"));
		container.setLayout(new BorderLayout());
		container.add(header,BorderLayout.NORTH);
		container.add(supermid,BorderLayout.CENTER);
		
		
		
		//containermid.add(header,BorderLayout.CENTER);
		//Jframe
		
		
		JFrame frame=new JFrame();
		frame.setTitle("LIBRARY MANAGEMNET SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setSize(1080,720);
		frame.add(container);
		frame.setVisible(true);
		ImageIcon image=new ImageIcon("library.png");
		frame.setIconImage(image.getImage());
	}

	
	@SuppressWarnings("unused")
	private static class RoundedBorder implements Border {

	    private int radius;
	    private Color backgroundColor;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    RoundedBorder(int radius,Color bgColor) {
	        this.radius = radius;
	        backgroundColor=bgColor;
		}
	
	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	  /*  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }*/
	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Dimension arcs=new Dimension(radius,radius);
			/*int width=getWidth();
			int height=getHeight();*/
			Graphics2D graphics=(Graphics2D)g;
			graphics.setColor(backgroundColor);
			
			if(backgroundColor !=null)
			{
				graphics.setColor(backgroundColor);
			}
			else
			{
				//graphics.setColor(getBackground());
			}
			graphics.fillRoundRect(0,0,width-1,height-1,arcs.width,arcs.height);
			g.drawRoundRect(x, y, width-1, height-1, radius, radius);
			//graphics.setColor(getForeground());
			
		}
	}
	
	
	
	@SuppressWarnings({ "serial" })
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
