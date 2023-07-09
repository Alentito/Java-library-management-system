package library;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class login  {
	JFrame frame;
	public static void main(String[] args)
	{
		login window =new login();
		window.frame.setVisible(true);
		 try {
			//String a=send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //System.out.println("fn user = "+user);
	}
	private String user;
	private String userids;
	
	public login(String user)
	{
	login ll=new login();
	userids=ll.getid();
	this.user=user;	
	}
	public String getid()
	{
		System.out.println("getid="+user);
		return user;
	}
 public login()
 {
	 	JPanel panel_1 = new JPanel();
	 	panel_1.setBackground(Color.decode("#e3e3e3"));
		//panel_1.setBackground(new Color(213, 174, 227));
		panel_1.setBounds(0, 0, 1750,1020);
		
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		panel.setPreferredSize(new Dimension(855, 1020));
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel loginTitle = new JLabel();
		ImageIcon bookicon=new ImageIcon(((new ImageIcon("libt.png")).getImage()).getScaledInstance(464, 150, java.awt.Image.SCALE_SMOOTH));
		loginTitle.setIcon(bookicon);
		//loginTitle.setForeground(Color.decode("#FFFFFF"));
		//loginTitle.setFont(new Font("Tahoma", Font.BOLD, 74));
		loginTitle.setBounds(235, 260, 464, 150);
		panel.add(loginTitle);
		
		JLabel loginTitle_1 = new JLabel("Designed to manage all the functions ");
		loginTitle_1.setForeground(Color.decode("#000000"));
		loginTitle_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		loginTitle_1.setBounds(260, 367, 560, 42);
		panel.add(loginTitle_1);
		
		JPanel right = new JPanel();
		right.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		right.setPreferredSize(new Dimension(855, 1020));
		panel_1.add(right);
		right.setLayout(null);
		
		JPanel container = new JPanel();
		container.setBounds(100, 120, 532, 740);
		container.setBackground(new Color(1f,1f,1f,0.58f));
		right.add(container);
		container.setLayout(null);
		
		
		JLabel simg=new JLabel();
		simg.setBounds(231,90, 50, 50);
		ImageIcon addlovicon=new ImageIcon(((new ImageIcon("library.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		simg.setIcon(addlovicon);
		simg.setForeground(Color.decode("#000000"));
		container.add(simg);
		simg.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		JLabel si=new JLabel("Sign In");
		si.setBounds(211,140, 350, 50);
		si.setForeground(Color.decode("#000000"));
		container.add(si);
		si.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		JLabel sub=new JLabel("Please login to use the platform");
		sub.setBounds(131, 180, 270, 50);
		sub.setForeground(Color.decode("#000000"));
		container.add(sub);
		sub.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		
		JTextField textField = new JTextField("Username");
		textField.setBorder(new LineBorder(Color.decode("#A61EEB")));
		textField.setBounds(91, 270, 350, 50);
		container.add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
//border1=new BorderFactory.createBevelBorder(10);
		passwordField.setBorder(new LineBorder(Color.decode("#A61EEB")));
		//passwordField.setBorder(new RoundedBorder(40,Color.decode("#000000")));
		//passwordField.setBackground(Color.decode("#A61EEB"));
		passwordField.setBounds(91, 370, 350, 50);
		container.add(passwordField);
		
		 
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setBackground(Color.decode("#000000"));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String u=textField.getText();
				
				
				
				
				Connection con=null;
				 try {
	                	Class.forName("com.mysql.cj.jdbc.Driver");
	                	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
	        			if(!con.isClosed())
	        				System.out.println("sucess");
	        			
	        			Statement stat=con.createStatement();
	        			Statement sto=con.createStatement();
	        			//String q="CREATE table user"+u+"() ";
	        			String query1="select * from student where phone='"+textField.getText()+"' and password='"+passwordField.getText()+"' ";
	        			ResultSet rs=stat.executeQuery(query1);
	        			user user1;
	        			if(rs.next())
	        			{
	        				
	        				
	        				
	                		try
	                		{
	                			
	                			user1=new user(rs.getString("phone"));
	                			
	                			library obj1=new library();
		        				obj1.frame.setVisible(true);
		        				frame.dispose();
	                			
	                		}
	                		catch(Exception ee)
	                		{
	                			System.err.println("Exception:"+ee.getMessage());
	                		}
	                		finally {
	                			try
	                			{
	                				stat.executeUpdate("CREATE table '"+user+"'");
		                			System.out.println(user);
	                				if(con!=null)
	                					con.close();
	                			}
	                			catch(SQLException ee)
	                			{
	                				
	                			}
	                		}
	        				
	        			}
	        			else
	        			{
	        				JOptionPane.showMessageDialog(btnNewButton,
	                                "Sorry, " + textField.getText() + "Invalid Username or Password");
	        				textField.setText(null);
	        				passwordField.setText(null);
	        				textField.requestFocusInWindow();
	        			}
			       	 }
				 catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);
					}
				
				
				
				
			}
		});
		btnNewButton.setBounds(91, 460, 350, 50);
		container.add(btnNewButton);
		JLabel signup=new JLabel();
		signup.setBounds(0,20,350,50);
		signup.setForeground(Color.white);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		//btnNewButton_1.setBorder(new RoundedBorder(10,Color.decode("#000000")));
		btnNewButton_1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		btnNewButton_1.setForeground(Color.decode("#A61EEB"));
		btnNewButton_1.setContentAreaFilled(false);
	//	btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.decode("#A61EEB")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				signup obj1=new signup();
				obj1.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_1.add(signup);
		btnNewButton_1.setBounds(91, 580, 350, 50);
		container.add(btnNewButton_1);
		
		JLabel loginTitle_2 = new JLabel("Don't have an account ?");
		loginTitle_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		loginTitle_2.setHorizontalTextPosition(JLabel.CENTER);
		loginTitle_2.setBounds(150, 530, 280, 23);
		container.add(loginTitle_2);
		
		
	/*	JPanel container = new JPanel();
		container.setBackground(Color.decode("#D9C4E3"));
		//container.setBackground(new Color(0, 0, 0));
		//container.setBounds(new Rectangle(0, 0, 749, 499));
		container.setPreferredSize(new Dimension(1080, 720));
		container.setBounds(0, 0, 1080, 720);
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));*/
		
		//setContentpane(panel_1);
		frame = new JFrame();
		frame.setTitle("LIBRARY MANAGEMNET SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setSize(1750,1020);
		frame.setVisible(true);
		//j.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		ImageIcon image=new ImageIcon("library.png");
		frame.setIconImage(image.getImage());
		frame.getContentPane().add(panel_1);
		
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
			graphics.setColor(Color.white);
			
		}
	}

  
 @SuppressWarnings("unused")
private static class gradientpanel extends JPanel
  {
 
 protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g;
     g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
     int w = getWidth(), h = getHeight();
     Color color1 = Color.decode("#A638DB");
     Color color2 = Color.decode("#FF07C5");
     GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
     g2d.setPaint(gp);
     g2d.fillRect(0, 0, w, h);
 	}
  }
}
