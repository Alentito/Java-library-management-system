package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import java.util.ArrayList;

import library.library.RoundedPanel;

public class Dashboard {

	static JFrame frame;
	JTable table;
	addbook addbookpg;
	delbooks delbooks;
	updbooks updbooks;
	String filename= null;
	public static void main(String arg[]) {
		Dashboard w=new Dashboard();
		w.frame.setVisible(true);
	}
	
	
	
	public Dashboard()
	{
		addbookpg=new addbook();
		delbooks=new delbooks();
		updbooks=new updbooks();
		//Dashboard left nav-Menu
		JLabel adminimg = new JLabel();
		adminimg.setBounds(19,15,70,70);
		ImageIcon adminicon=new ImageIcon(((new ImageIcon("admin.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH));
		adminimg.setIcon(adminicon);
		
		
		JLabel adminname=new JLabel("ADMIN");
		adminname.setBounds(120,30,100,40);
		adminname.setFont(new Font("",Font.BOLD,25));
		adminname.setForeground(Color.decode("#3A3A3A"));
		
		JPanel admintitle=new JPanel();
		admintitle.setPreferredSize(new Dimension(380,100));
		admintitle.setLayout(null);
		admintitle.setBackground(Color.white);
		admintitle.add(adminimg);
		admintitle.add(adminname);
		
		//menu items
		JLabel dash=new JLabel("DASHBOARD");
		dash.setBounds(50,10,200,40);
		dash.setFont(new Font("",Font.BOLD,25));
		dash.setForeground(Color.decode("#F2F2F2"));
		
		
		RoundedPanel books=new RoundedPanel(30,Color.decode("#A743D9"));
		books.setBounds(10,20,360,60);
		//books.setPreferredSize(new Dimension(360,80));
		books.setLayout(null);
		books.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		//"#A743D9"
		books.add(dash);
		
		JPanel dashpane=new JPanel();
		dashpane.setPreferredSize(new Dimension(380,100));
		dashpane.setBackground(Color.white);
		dashpane.setLayout(null);
		dashpane.add(books);
		
		//addbooks
		
		JLabel bookimg = new JLabel();
		bookimg.setBounds(19,10,50,50);
		ImageIcon bookicon=new ImageIcon(((new ImageIcon("book.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		bookimg.setIcon(bookicon);
		
		JLabel bookname=new JLabel("ADD BOOKS");
		bookname.setBounds(100,15,200,40);
		bookname.setFont(new Font("",Font.PLAIN,25));
		bookname.setForeground(Color.decode("#3A3A3A"));
		
		JPanel book=new JPanel();
		book.setPreferredSize(new Dimension(380,70));
		book.setBackground(Color.white);
		book.setLayout(null);
		book.add(bookimg);
		book.add(bookname);
		
		//issue
		JLabel issueimg = new JLabel();
		issueimg.setBounds(19,10,50,50);
		ImageIcon issueicon=new ImageIcon(((new ImageIcon("issue.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		issueimg.setIcon(issueicon);
		
		JLabel issuename=new JLabel("ISSUE BOOK");
		issuename.setBounds(100,15,200,40);
		issuename.setFont(new Font("",Font.PLAIN,25));
		issuename.setForeground(Color.decode("#3A3A3A"));
		
		JPanel issue=new JPanel();
		issue.setPreferredSize(new Dimension(380,70));
		issue.setBackground(Color.white);
		issue.setLayout(null);
		issue.add(issueimg);
		issue.add(issuename);
		
		
		//returnmenu
				JLabel returnmenuimg = new JLabel();
				returnmenuimg.setBounds(19,10,50,50);
				ImageIcon returnmenuicon=new ImageIcon(((new ImageIcon("return.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
				returnmenuimg.setIcon(returnmenuicon);
				
				JLabel returnmenuname=new JLabel("RETURNED");
				returnmenuname.setBounds(100,15,200,40);
				returnmenuname.setFont(new Font("",Font.PLAIN,25));
				returnmenuname.setForeground(Color.decode("#3A3A3A"));
				
				JPanel returnmenu=new JPanel();
				returnmenu.setPreferredSize(new Dimension(380,70));
				returnmenu.setBackground(Color.white);
				returnmenu.setLayout(null);
				returnmenu.add(returnmenuimg);
				returnmenu.add(returnmenuname);
				
				//notreturned
				JLabel notreturnedimg = new JLabel();
				notreturnedimg.setBounds(19,10,50,50);
				ImageIcon notreturnedicon=new ImageIcon(((new ImageIcon("notreturn.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
				notreturnedimg.setIcon(notreturnedicon);
				
				JLabel notreturnedname=new JLabel("NOT RETURNED");
				notreturnedname.setBounds(100,15,200,40);
				notreturnedname.setFont(new Font("",Font.PLAIN,25));
				notreturnedname.setForeground(Color.decode("#3A3A3A"));
				
				JPanel notreturned=new JPanel();
				notreturned.setPreferredSize(new Dimension(380,70));
				notreturned.setBackground(Color.white);
				notreturned.setLayout(null);
				notreturned.add(notreturnedimg);
				notreturned.add(notreturnedname);
				
				
				//manageuser
				JLabel manageuserimg = new JLabel();
				manageuserimg.setBounds(19,10,50,50);
				ImageIcon manageusericon=new ImageIcon(((new ImageIcon("manageuser.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
				manageuserimg.setIcon(manageusericon);
				
				JLabel manageusername=new JLabel("MANAGE USERS");
				manageusername.setBounds(100,15,250,40);
				manageusername.setFont(new Font("",Font.PLAIN,25));
				manageusername.setForeground(Color.decode("#3A3A3A"));
				
				JPanel manageuser=new JPanel();
				manageuser.setPreferredSize(new Dimension(380,70));
				manageuser.setBackground(Color.white);
				manageuser.setLayout(null);
				manageuser.add(manageuserimg);
				manageuser.add(manageusername);
				
				
		JPanel Menu=new JPanel();
		Menu.setPreferredSize(new Dimension(380,1020));
		Menu.setBackground(Color.white);
		Menu.add(admintitle);
		Menu.add(dashpane);
		Menu.add(book);
		Menu.add(issue);
		Menu.add(returnmenu);
		Menu.add(notreturned);
		Menu.add(manageuser);
		
		//Dashboard Serach module
		
		JTextField srchname=new JTextField();
		srchname.setBounds(10,5,390,40);
		srchname.setFont(new Font("",Font.PLAIN,25));
		//srchname.setForeground(Color.decode("#3A3A3A"));
		srchname.setBorder(null);
		srchname.setBackground(Color.decode("#E2E2E2"));

		
		JLabel srchimg=new JLabel();
		srchimg.setBounds(410,10,30,30);
		ImageIcon srchicon=new ImageIcon(((new ImageIcon("srchimg.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		srchimg.setIcon(srchicon);
		
		RoundedPanel srch=new RoundedPanel(30,Color.decode("#E2E2E2"));
		srch.setBounds(500,20,460,50);
		//books.setPreferredSize(new Dimension(360,80));
		srch.setLayout(null);
		srch.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		//"#A743D9"
		srch.add(srchname);
		srch.add(srchimg);
		
		
		
		
		JPanel top=new JPanel();
		top.setPreferredSize(new Dimension(1050,100));
		
		top.setBackground(Color.white);
		top.add(srch);
		top.setLayout(null);
		
		//title pane
		
		JLabel bookmenu =new JLabel ("  BOOK");
		bookmenu.setFont(new Font("",Font.PLAIN,31));
		bookmenu.setBounds(100,25,800,50);
		//bookmenu.setPreferredSize(new Dimension(900,60));
		
		JLabel booksub =new JLabel ("     Manage books here.");
		booksub.setFont(new Font("",Font.PLAIN,16));
		booksub.setForeground(Color.decode("#7E7E7E"));
		booksub.setBounds(100,65,900,20);
		
		
		JPanel toptitle =new JPanel();
		toptitle.setPreferredSize(new Dimension(1050,100));
		toptitle.setBackground(Color.white);
		toptitle.setLayout(null);
		toptitle.add(bookmenu);
		toptitle.add(booksub);
		
		//mid table content
		
		//String column[]= {"BOOKID","TITLE","AUTHOR","GENRE","RATING","IMAGES","COUNT"};
		
		table=new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][]
						{
					
						},
						new String[]
								{
										"BOOKID","TITLE","AUTHOR","GENRE","RATING","IMAGES","COUNT"
								}
				));
		table.setPreferredSize(new Dimension(900,400));
		
	/*	ArrayList<book> list=booklist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		Object[] row=new Object[7];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getbookid();
			row[1]=list.get(i).gettitle();
			row[2]=list.get(i).getauthor();
			row[3]=list.get(i).getgenre();
			row[4]=list.get(i).getrating();
			row[5]=list.get(i).getbookimage();
			row[6]=list.get(i).getcount();
			model.addRow(row);
			
		}*/
		
		
		/*JPanel spane=new JPanel();
		spane.setPreferredSize(new Dimension(900,1020));
		spane.setBackground(Color.red);*/
		
		JScrollPane midcontent=new JScrollPane();
		midcontent.setBounds(65,65,920,560);
		//midcontent.setPreferredSize(new Dimension(1000,660));
		midcontent.setBackground(Color.white);
		midcontent.setViewportView(table);
		
		
		JPanel midpane=new JPanel();
		midpane.setPreferredSize(new Dimension(1050,660));
		midpane.setBackground(Color.decode("#E5E5E5"));
		midpane.add(midcontent);
		midpane.setLayout(null);
		
		//bottom pane menu
		
		JButton addbookimg = new JButton();
		addbookimg.setBounds(19,10,64,64);
		ImageIcon addbookicon=new ImageIcon(((new ImageIcon("addbook.png")).getImage()).getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		addbookimg.setIcon(addbookicon);
		addbookimg.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		addbookimg.setBorder(null);
		addbookimg.setContentAreaFilled(false);
		addbookimg.addMouseListener(new MouseListener()
		{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		menuClicked(addbookpg);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		});
		
		
		
		gradientpanel addbook=new gradientpanel(40,Color.decode("#EC4F98"),Color.decode("#A94171"));
		addbook.setPreferredSize(new Dimension(148,83));
		addbook.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		addbook.add(addbookimg);
		addbook.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 10));
		
		
		JButton delbookimg = new JButton();
		delbookimg.setBounds(19,10,64,64);
		ImageIcon delbookicon=new ImageIcon(((new ImageIcon("delbook.png")).getImage()).getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		delbookimg.setIcon(delbookicon);
		delbookimg.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		delbookimg.setContentAreaFilled(false);
		delbookimg.addMouseListener(new MouseListener()
		{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		menuClicked(delbooks);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		});
		delbookimg.setBorder(null);
		
		gradientpanel delbook=new gradientpanel(40,Color.decode("#47CB3D"),Color.decode("#3D9854"));
		delbook.setPreferredSize(new Dimension(148,83));
		delbook.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		delbook.add(delbookimg);
		delbook.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 10));
		
		
		
		JButton updbookimg = new JButton();
		updbookimg.setBounds(19,10,64,64);
		ImageIcon updbookicon=new ImageIcon(((new ImageIcon("updbook.png")).getImage()).getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		updbookimg.setIcon(updbookicon);
		updbookimg.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		updbookimg.setBorder(null);
		updbookimg.setContentAreaFilled(false);
		updbookimg.addMouseListener(new MouseListener()
		{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		menuClicked(updbooks);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		});
		
		gradientpanel updbook=new gradientpanel(40,Color.decode("#E6B043"),Color.decode("#B27834"));
		updbook.setPreferredSize(new Dimension(148,83));
		updbook.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		updbook.add(updbookimg);
		updbook.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 10));
		
		JPanel bottompane=new JPanel();
		bottompane.setPreferredSize(new Dimension(920,100));
		bottompane.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		bottompane.add(addbook);
		bottompane.add(delbook);
		bottompane.add(updbook);
		bottompane.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 18));
		
		RoundedPanel bottom=new RoundedPanel(20,Color.white);
		bottom.setPreferredSize(new Dimension(920,120));
		bottom.add(bottompane);
		
		
		JPanel Topmenu=new JPanel();
		Topmenu.setPreferredSize(new Dimension(1050,100));
		Topmenu.setBackground(Color.decode("#E5E5E5"));
		Topmenu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		Topmenu.add(top);
		Topmenu.add(toptitle);
		Topmenu.add(midpane);
		Topmenu.add(bottom);
		
		
		//Dashboard right fucntion
		JPanel rightadmin=new JPanel();
		rightadmin.setPreferredSize(new Dimension(420,1020));
		rightadmin.setBackground(Color.green);
		rightadmin.setLayout(null);
		rightadmin.add(addbookpg);
		rightadmin.add(delbooks);
		rightadmin.add(updbooks);
		
		//menuClicked(addbookpg);
		
		//Cenetered Main Content Pane
		JPanel Mainpane=new JPanel();
		Mainpane.setPreferredSize(new Dimension(910,470));
		Mainpane.setBackground(Color.yellow);
		
		JPanel container = new JPanel();
		container.setBackground(Color.decode("#E5E5E5"));
		//container.setBackground(new Color(0, 0, 0));
		//container.setBounds(new Rectangle(0, 0, 749, 499));
		container.setPreferredSize(new Dimension(1750, 1020));
		container.setBounds(0, 0, 1080, 720);
		container.setLayout(new BorderLayout());;
		container.add(Menu,BorderLayout.WEST);
		container.add(Topmenu,BorderLayout.CENTER);
		container.add(rightadmin,BorderLayout.EAST);
		//container.add(Mainpane,BorderLayout.CENTER);
		//container.add(Bestsellerpath,BorderLayout.CENTER);
		
		
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
		ImageIcon image=new ImageIcon("library.png");
		frame.setIconImage(image.getImage());
		//initComponents();
		try {
			showbook();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public ArrayList<book> booklist(){
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
				book=new book(rs.getInt("bookid"),rs.getString("title"),rs.getString("author"),rs.getString("genre"),rs.getString("rating"),rs.getBlob("bookimage"),rs.getString("count"));
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
	}
	public void showbook() throws SQLException
	{
		ArrayList<book> list=booklist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		Object[] row=new Object[7];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getbookid();
			row[1]=list.get(i).gettitle();
			row[2]=list.get(i).getauthor();
			row[3]=list.get(i).getgenre();
			row[4]=list.get(i).getrating();
			row[5]=list.get(i).getbookimage();
			row[6]=list.get(i).getcount();
			model.addRow(row);
			
		}
	}
	public void menuClicked(JPanel panel)
	{
		addbookpg.setVisible(false);
		delbooks.setVisible(false);
		updbooks.setVisible(false);
		
		panel.setVisible(true);
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
	  @SuppressWarnings("unused")
	  private static class gradientpanel extends JPanel
	    {
		  private Color backgroundColor1;
		  private Color backgroundColor2;
			private int cornerRadius=15;
		  
		  public gradientpanel(int radius,Color bgColor1,Color bgColor2) {
				super();
				cornerRadius=radius;
				backgroundColor1=bgColor1;
				backgroundColor2=bgColor2;
			}
	   
	   protected void paintComponent(Graphics g) {
		   super.paintComponent(g);
			Dimension arcs=new Dimension(cornerRadius,cornerRadius);
			int w = getWidth(), h = getHeight();
			Graphics2D graphics=(Graphics2D)g;
			graphics.setColor(getForeground());
		   
		   
	       
	       graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	       GradientPaint gp = new GradientPaint(0, 0, backgroundColor1, w, h, backgroundColor2);
	       graphics.setPaint(gp);
	       graphics.fillRoundRect(0,0,w-1,h-1,arcs.width,arcs.height);
	   	}
	    }
	  
}

