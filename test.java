package library;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

//import test.test.RoundedBorder;
//import test.RoundedPanel;

public class test {
	JFrame frame;
	int bookid;
	//JButton[] imgbtn=new JButton[5];
	String filename= null;
	JLabel[] imgbtn=new JLabel[5];
	JLabel[] bookname=new JLabel[5];
	JLabel[] authorname=new JLabel[5];
	JButton[] buy=new JButton[5];
	JLabel[] bn=new JLabel[5];
	RoundedPanel[] b1=new RoundedPanel[5];
	JPanel panel=new JPanel();
	BufferedImage img=null;
	FileOutputStream fos=null;
	ImageIcon imgicon=null;
	public static void main(String args[])
	{
		test window =new test();
		window.frame.setVisible(true);
	}
	public void book(String title,String author,ImageIcon imgicon)
	{
		System.out.println(imgicon);
		
		//filename =imgicon.getAbsolutePath();
		//Object[] row=new Object[7];
		for(int i=0;i<5;i++)
		{
			
			//imgbtn[i]=new JButton(imgicon);
			imgbtn[i]=new JLabel();
			//ImageIcon imagei=new ImageIcon("C:\\Users\\ASUS\\eclipse-java\\library\\"+bookid+".png");
			//ImageIcon srchicon=new ImageIcon(((new ImageIcon("C:\\Users\\ASUS\\eclipse-java\\library\\"+bookid+".png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
			imgbtn[i].setIcon(imgicon);
			//imgbtn[i].setIcon(imagei.getImage());
			//imgbtn[i].setImage(imagei.getImage());
			imgbtn[i].setBounds(12,12,195,150);
			imgbtn[i].setFocusable(false);
			//imgbtn[i].setBorderPainted(false);
			//imgbtn[i].setFocusPainted(false);
			//imgbtn[i].setContentAreaFilled(false);
			//imgbtn[i].addActionListener(new ActionListener() {
				//public void actionPerformed(ActionEvent e)
				//{
				/*	JFrame j = new JFrame();
					j.setTitle("LIBRARY MANAGEMNET SYSTEM");
					j.setResizable(false);
				    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					j.getContentPane().setBackground(Color.yellow);
					j.setSize(1080,720);
					j.setVisible(true);
					j.setLocationRelativeTo(null);
					j.getContentPane().setLayout(null);
					ImageIcon image=new ImageIcon("library.png");
					j.setIconImage(image.getImage());*/
					
			//	}
		//	}); 
			

			//imgbtn[i].setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
			
			//JLabel l1=new JLabel("vanma");
			bookname[i]=new JLabel(title);
			bookname[i].setHorizontalAlignment(JLabel.CENTER);
			bookname[i].setFont(new Font("",Font.BOLD,16));
			bookname[i].setForeground(Color.decode("#505050"));
			bookname[i].setBounds(0,180,220,20);
			
			
			authorname[i]=new JLabel(author);
			authorname[i].setHorizontalAlignment(JLabel.CENTER);
			authorname[i].setFont(new Font("",Font.BOLD,16));
			authorname[i].setForeground(Color.decode("#505050"));
			authorname[i].setBounds(0,200,220,20);
			
			
			
			buy[i]=new JButton("BUY");
			buy[i].setBounds(40,240,140,40);
			buy[i].setForeground(Color.white);
			buy[i].setBorder(new RoundedBorder(40,Color.decode("#A61EEB")));
			buy[i].setBackground(Color.decode("#A61EEB"));
			
			buy[i].setFocusable(false);
			buy[i].setOpaque(false);
			buy[i].setFocusPainted(true);
			
			bn[i]=new JLabel("BUY");
			bn[i].setHorizontalAlignment(JLabel.CENTER);
			bn[i].setFont(new Font("",Font.BOLD,16));
			bn[i].setForeground(Color.white);
			bn[i].setBounds(0,250,220,20);
			
			
			b1[i]=new RoundedPanel(30,Color.white);
			b1[i].setPreferredSize(new Dimension(220,300));
			b1[i].add(imgbtn[i]);
			b1[i].add(bookname[i]);
			b1[i].add(authorname[i]);
			b1[i].add(bn[i]);
			b1[i].add(buy[i]);
			
			b1[i].setLayout(null);
			//b1[i].setLayout(new FlowLayout(FlowLayout.CENTER));
			b1[i].setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
			
			
		}
	}
	public test()
	{
		//book("game of thrones","george");
		
		
		panel=new JPanel();
		panel.setPreferredSize(new Dimension(1080,720));
		panel.setBackground(Color.red);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	/*	for(int j=0;j<5;j++)
		{
			panel.add(b1[j]);
		}*/
		
		//panel.add(b1[4]);
		//panel.add(b1);
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			if(!con.isClosed())
				System.out.println("sucess");
			String query1="select * from books ";
			Statement stat=con.createStatement();

			ResultSet rs=stat.executeQuery(query1);
			//book book;
			int j=1;
			while(rs.next())
			{
				//book=new book(rs.getInt("bookid"),rs.getString("title"),rs.getString("author"),rs.getString("genre"),rs.getString("rating"),rs.getBlob("bookimage"),rs.getString("count"));
				//booklist.add(book)
				bookid=rs.getInt("bookid");
				String title = rs.getString("title");
				String author=rs.getString("author");
				Blob blob=rs.getBlob("bookimage");
				//fos=new FileOutputStream("C://Users/ASUS/eclipse-java/library/"+bookid+".png");
				//int len=(int)blob.length();
			
			    byte image[]=blob.getBytes(1, (int)blob.length());
			    fos=new FileOutputStream("C://Users/ASUS/eclipse-java/library/"+bookid+".png");
				fos.write(image);
				imgicon=new ImageIcon(image);
				Image img=imgicon.getImage();
				Image newimg=img.getScaledInstance(195, 150, java.awt.Image.SCALE_SMOOTH);
				imgicon=new ImageIcon(newimg);
				book(title,author,imgicon);
				System.out.println(imgicon);
				//book(title,author,bookid);
				panel.add(b1[j]);
				j++;
				//BufferedImage im = ImageIO.read(rs.getBinaryStream("Image"));
	           // BackGroundImage.setIcon(new ImageIcon(im));
			}
			
			//stat.executeUpdate("CREATE DATABASE PASSU");
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		frame=new JFrame();
		//frame.getContentPane().add(panel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(1080,720);
		frame.setVisible(true);
	}
	/*public ArrayList<book> booklist(){
		ArrayList<book> booklist=new ArrayList<>();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			if(!con.isClosed())
				System.out.println("sucess");
			String query1="select * from books ";
			Statement stat=con.createStatement();

			ResultSet rs=stat.executeQuery(query1);
			book book;
			while(rs.next())
			{
				book=new book(rs.getInt("bookid"),rs.getString("title"),rs.getString("author"),rs.getString("genre"),rs.getString("rating"),rs.getBinaryStream("bookimage"),rs.getString("count"));
				booklist.add(book);
				
				//BufferedImage im = ImageIO.read(rs.getBinaryStream("Image"));
	           // BackGroundImage.setIcon(new ImageIcon(im));
			}
			
			//stat.executeUpdate("CREATE DATABASE PASSU");
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
 		
		
		return booklist;
	}*/
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
