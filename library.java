package library;

import java.awt.BorderLayout;
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
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;



//import library.library.RoundedBorder;
//import library.librRoundedPanel;

import java.sql.*;

public class library implements ActionListener  {

	JFrame frame;
	
	int bookid;
	//int flag;
	//JButton[] imgbtn=new JButton[5];
	String filename= null;
	JLabel[] imgbtn=new JLabel[10];
	JLabel[] bookname=new JLabel[10];
	JLabel[] authorname=new JLabel[10];
	JButton[] fav=new JButton[10];
	JButton[] lov=new JButton[10];
	JButton[] buy=new JButton[10];
	JLabel[] bn=new JLabel[10];
	RoundedPanel[] b1=new RoundedPanel[10];
	JPanel Bestsellerpath=new JPanel();
	BufferedImage img=null;
	FileOutputStream fos=null;
	ImageIcon imgicon=null;
	//String ids;
	public static JTextField ids=new JTextField();
		public String userid;
	public static void main(String[] args)
	{
		//library window =new library();
	//	window.frame.setVisible(true);
		
		
		
		library w=new library();
		w.frame.setVisible(true);
		
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			if(!con.isClosed())
				System.out.println("sucess");
			Statement stat=con.createStatement();
			//stat.executeUpdate("CREATE DATABASE PASSU");
		}
		catch(Exception e)
		{
			System.err.println("Exception:"+e.getMessage());
		}
		finally {
			try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				
			}
		}
	}
	
	public void book(int k,int i,int bookid,String title,String author,ImageIcon imgicon)
	{
		System.out.println(imgicon);
		
		login l;
			final int log=k;
			final int index=i;
			System.out.println(index);
			imgbtn[i]=new JLabel();
			imgbtn[i].setIcon(imgicon);
			
			imgbtn[i].setBounds(12,12,195,150);
			imgbtn[i].setFocusable(false);
			
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
			
			
			
			fav[i]=new JButton();
			fav[i].setBounds(160,10,50,50);
			ImageIcon addfavicon=new ImageIcon(((new ImageIcon("defaultfav.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
			fav[i].setIcon(addfavicon);
			fav[i].setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
			fav[i].setBorder(null);
			fav[i].setContentAreaFilled(false);
			//fav[i].setVisible(true);
			
              
			fav[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					
					
                	
                	
                	//login login;
                	Connection con=null;
                	//ImageIcon f =imgicon;
            		filename ="C://Users/ASUS/eclipse-java/library/"+bookid+".png";
            		System.out.println("bookid="+bookid);
            		
                    try {
                    
                    	login obj=new login();
        				obj.frame.dispose();
                    	//Class.forName("com.mysql.cj.jdbc.Driver");
                    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            			if(!con.isClosed())
            				System.out.println("sucess");
            			Statement sta = con.createStatement();
            			File imgfile=new File(filename);
            			user user1;
            			userid=user.userid();
                        //FileInputStream fin=new FileInputStream(imgfile);
                        FileInputStream in =new FileInputStream(imgfile);
            			//File imgfile=new File(imgicon);
                        //FileInputStream fin=new FileInputStream(imgfile);
                       // FileInputStream in =new FileInputStream(imgfile);

                        //String query = "INSERT INTO books(title,author,genre,rating,bookimage,count) values('" + booktitle + "','" + authorname + "','" + genres + "','" +
                        //		ratings + "','" + in + "','" + countno + "')";
                        /* String query1="select * from wishlist where userid='"+userid+"' and bookid='"+bookid+"' ";
	        			ResultSet rs=sta.executeQuery(query1);
	        			if(rs.next())
	        			{
                        
                        
                        
                        fav[index].setVisible(false);
                    	lov[index].setVisible(true);
                        
	        			}*/
                        //library jj=new library(String a);
                        //final String xu=user;
                        PreparedStatement pre=con.prepareStatement("insert into wishlist(userid,bookid,title,author,img) values(?,?,?,?,?)");
                        
                       
                        System.out.println("x="+userid);
                        pre.setString(1,userid);
                        pre.setInt(2,bookid);
                        pre.setString(3,title);
                        pre.setString(4,author);
                        pre.setBinaryStream(5,(InputStream)in,(int)imgfile.length());
                       
                       int x= pre.executeUpdate();
                        
                       
                        
                        
                       // int x = sta.executeUpdate(query);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(fav[i], "This already exists");
                            pre.close();
                            con.close();
                            } else {
                            JOptionPane.showMessageDialog(fav[i],
                                "Welcome, " + ids.getText() + "Your account is sucessfully created");
                            	}
                        con.close();
                    	}	
                    catch (Exception exception) {
                        exception.printStackTrace();
                    			}
                    
                }

				
	});
			
			lov[i]=new JButton();
			lov[i].setBounds(160,10,50,50);
			ImageIcon addlovicon=new ImageIcon(((new ImageIcon("fav.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
			lov[i].setIcon(addlovicon);
			lov[i].setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
			lov[i].setBorder(null);
			lov[i].setContentAreaFilled(false);
			lov[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					ImageIcon addlovicon=new ImageIcon(((new ImageIcon("fav.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					fav[index].setVisible(true);
                	lov[index].setVisible(false);
                	Connection con=null;
                	try
                	{
                		login obj=new login();
        				obj.frame.dispose();
                    	//Class.forName("com.mysql.cj.jdbc.Driver");
                    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            			if(!con.isClosed())
            				System.out.println("sucess");
            			String query = "delete from wishlist where userid="+userid+" and bookid= " + bookid+ " ";
            			Statement sta = con.createStatement();
            			int x = sta.executeUpdate(query);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(lov[i], "This already exists");
                        } else {
                            JOptionPane.showMessageDialog(lov[i],
                                "Book Id : , " + bookid + "Deleted sucessfully");
                        }
                        con.close();
                		
                	}
                	 catch (Exception exception) {
                         exception.printStackTrace();
                     			}
                	
                	
				}
				
			});
			//lov[i].setVisible(true);
			
			
			if(k==1)
			{
				fav[index].setVisible(false);
				lov[index].setVisible(true);
				System.out.println("flaggg  if=="+index);
			}
			else
			{
				fav[index].setVisible(true);
				lov[index].setVisible(false);
				System.out.println("flaggg else=="+index);
			}
			
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
			b1[i].add(fav[i]);
			b1[i].add(lov[i]);
			b1[i].add(imgbtn[i]);
			b1[i].add(bookname[i]);
			b1[i].add(authorname[i]);
			
			b1[i].add(bn[i]);
			b1[i].add(buy[i]);
			
			
			b1[i].setLayout(null);
			//b1[i].setLayout(new FlowLayout(FlowLayout.CENTER));
			b1[i].setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
			
		
		
}
	
	public library()
	{
		//initialize();
		//library m=new library();
	
		
		
		//container.add(header,BorderLayout.NORTH);
		//container.add(supermid,BorderLayout.CENTER);
		ids=new JTextField();
		System.out.println("constructor ids="+ids.getText());
		
		JLabel menutitle=new JLabel("LIBRARY");
		menutitle.setBounds(80,0,150,105);
		menutitle.setFont(new Font("",Font.BOLD,25));
		menutitle.setForeground(Color.white);
		
		JPanel topleft=new JPanel();
		//topleft.setBackground(Color.yellow);
		topleft.setBackground(Color.decode("#8117B7"));
		topleft.setPreferredSize(new Dimension(200,30));
		topleft.add(menutitle);
		topleft.setLayout(null);
		
		
		
	ImageIcon searchimage=new ImageIcon("C:\\Users\\ASUS\\Downloads\\icon2.png");
		
		
		
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
		
		
		RoundedPanel topsearch=new RoundedPanel(10,Color.white);
		topsearch.setBounds(120,37,400,35);
		topsearch.setLayout(null);
		topsearch.add(searchtitle);
		topsearch.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		
		JPanel topmid=new JPanel();
		topmid.setBackground(Color.decode("#8117B7"));
		topmid.setPreferredSize(new Dimension(200,30));
		topmid.add(topsearch);
		topmid.add(searchbtn);
		topmid.setLayout(null);
		
		
		JButton profile =new JButton(new ImageIcon(((new ImageIcon("login.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		profile.setPreferredSize(new Dimension(100,30));
		profile.setFocusable(false);
		profile.setBorderPainted(false);
		//Color.decode("#8117B7")
		profile.setBackground(Color.decode("#8117B7"));
		profile.setFocusPainted(false);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				login obj=new login();
				obj.frame.setVisible(true);
				frame.dispose();
				 }

			
				
			
		});
		JButton wish =new JButton(new ImageIcon(((new ImageIcon("wish.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		wish.setPreferredSize(new Dimension(100,30));
		wish.setFocusable(false);
		wish.setBorderPainted(false);
		//Color.decode("#8117B7")
		wish.setBackground(Color.decode("#8117B7"));
		wish.setFocusPainted(false);
		wish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				login obj=new login();
				obj.frame.setVisible(true);
				frame.dispose();
				 }

			
				
			
		});
		JButton cart =new JButton(new ImageIcon(((new ImageIcon("cart.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		cart.setPreferredSize(new Dimension(100,60));
		cart.setFocusable(false);
		cart.setBorderPainted(false);
		//Color.decode("#8117B7")
		cart.setBackground(Color.decode("#8117B7"));
		cart.setFocusPainted(false);
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				login obj=new login();
				obj.frame.setVisible(true);
				frame.dispose();
				 }

			
				
			
		});
	//	Color.decode("#8117B7")
		
		JPanel topright=new JPanel();
		topright.setBackground(Color.decode("#8117B7"));
		topright.setPreferredSize(new Dimension(380,105));
		topright.add(profile);
		topright.add(wish);
		topright.add(cart);
		topright.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		JPanel header = new JPanel();
		header.setBackground(Color.decode("#8117B7"));
		header.setPreferredSize(new Dimension(1750, 105));
		header.setLayout(new BorderLayout());
		header.add(topleft,BorderLayout.WEST);
		header.add(topmid,BorderLayout.CENTER);
		header.add(topright,BorderLayout.EAST);
		
		//bestseller
		
		
		
		
		JPanel menu = new JPanel();
		menu.setPreferredSize(new Dimension(1750, 105));
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel menuleft = new JPanel();
		menuleft.setPreferredSize(new Dimension(561, 60));
		menu.add(menuleft);
		
		JPanel menuright = new JPanel();
		menuright.setPreferredSize(new Dimension(187, 60));
		menu.add(menuright);
		
		JButton actionbtn=new JButton("ACTION");
		menuleft.add(actionbtn);
		actionbtn.setPreferredSize(new Dimension(200,80));
		actionbtn.setBounds(0,0,300,80);
		actionbtn.setFont(new Font("",Font.BOLD,18));
		actionbtn.setForeground(Color.decode("#A61EEB"));
		actionbtn.setHorizontalAlignment(SwingConstants.CENTER);
		actionbtn.setFocusable(false);
		actionbtn.setBorderPainted(false);
		actionbtn.setFocusPainted(false);
		
		JButton trillerbtn=new JButton("ACTION");
		menuleft.add(trillerbtn);
		trillerbtn.setBounds(0,0,30,30);
		trillerbtn.setFocusable(false);
		trillerbtn.setBorderPainted(false);
		trillerbtn.setFocusPainted(false);
		
		JButton romancebtn=new JButton("ACTION");
		menuleft.add(romancebtn);
		romancebtn.setBounds(0,0,30,30);
		romancebtn.setFocusable(false);
		romancebtn.setBorderPainted(false);
		romancebtn.setFocusPainted(false);
		
		JButton dramabtn=new JButton("ACTION");
		menuleft.add(dramabtn);
		dramabtn.setBounds(0,0,30,30);
		dramabtn.setFocusable(false);
		dramabtn.setBorderPainted(false);
		dramabtn.setFocusPainted(false);
		
		
		JButton comedybtn=new JButton("ACTION");
		menuleft.add(comedybtn);
		comedybtn.setBounds(0,0,30,30);
		comedybtn.setFocusable(false);
		comedybtn.setBorderPainted(false);
		comedybtn.setFocusPainted(false);
		
		
		JButton btnNewButton_5 = new JButton(new ImageIcon(((new ImageIcon("icon1.jpg")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		menuright.add(btnNewButton_5);
		btnNewButton_5.setBounds(0,0,30,30);
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setFocusPainted(false);
		//btnNewButton_5.
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			/*	
				JFrame j = new JFrame();
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
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1750, 810));
		
		
		
		JPanel Bestsellerpath =new JPanel();
		Bestsellerpath.setBackground(Color.decode("#D9C4E3"));
		//Bestseller.setBounds(500,30,1080,300);
		Bestsellerpath.setPreferredSize(new Dimension(1750,180));
		//Bestseller.add(b5);
		Bestsellerpath.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			if(!con.isClosed())
				System.out.println("sucess");
			//String query2="select count(bookid) from books";
			String query1="select * from books ";
			Statement stat=con.createStatement();
			//ResultSet ry=stat.executeQuery(query2);
			ResultSet rs=stat.executeQuery(query1);
			String query2="select bookid from wishlist where userid="+userid+" and bookid="+bookid+"";
			Statement sta=con.createStatement();
			ResultSet ry=sta.executeQuery(query2);
			int flag=0;
			if(ry.next())
			{
				flag=1;
			}
			else
				flag=0;			
			
			/*System.out.println(ry);
			while(ry.next())
			{
				bookid=ry.getInt("bookid");
			}
			*/
			//book book;
			String idu=ids.getText();
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
				book(flag,j,bookid,title,author,imgicon);
				//System.out.println(imgicon);
				//book(title,author,bookid);
				Bestsellerpath.add(b1[j]);
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
		
		
		JLabel bstitle=new JLabel("BEST SELLERS");
		bstitle.setBounds(100,5,1750,70);
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
		containmid.setPreferredSize(new Dimension(1750,400));
		containmid.setLayout(new BorderLayout());
		containmid.add(bcon,BorderLayout.NORTH);
		containmid.add(Bestsellerpath,BorderLayout.CENTER);
		
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(128, 0, 255));
		footer.setPreferredSize(new Dimension(1750, 150));
		
		
		JPanel scrollmainpanel = new JPanel();
		scrollmainpanel.setBackground(new Color(255, 0, 128));
		scrollmainpanel.setPreferredSize(new Dimension(1750, 850));
		scrollPane.setViewportView(scrollmainpanel);
		scrollmainpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		scrollmainpanel.add(containmid);
		scrollmainpanel.add(footer);
		
		JPanel container = new JPanel();
		container.setBackground(new Color(0, 0, 0));
		//container.setBackground(new Color(0, 0, 0));
		//container.setBounds(new Rectangle(0, 0, 749, 499));
		container.setPreferredSize(new Dimension(1750, 1020));
		container.setBounds(0, 0, 1080, 720);
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		container.add(header);
		container.add(menu);
		container.add(scrollPane);
		
		frame=new JFrame();
		frame.getContentPane().add(container);
		frame.setTitle("LIBRARY MANAGEMNET SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setSize(1750,1020);
		frame.add(container);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		//frame.getContentPane().setLayout(null);
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



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}