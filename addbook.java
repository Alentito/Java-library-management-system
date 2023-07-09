package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JButton;

public class addbook extends JPanel{
	
	String filename= null;
	byte[] bookimage=null;


	
	public addbook()
	{
		
		//setSize(420,1020);
		setBounds(0,0,420,1020);
		setLayout(new FlowLayout (FlowLayout.LEADING, 10, 20));
		setVisible(true);
		
		
		
		JLabel addpg=new JLabel();
		//addpg.setFont(new Font("",Font.BOLD,25));
		//ImageIcon addbookpgicon=new ImageIcon(((new ImageIcon("got.png")).getImage()).getScaledInstance(273, 186, java.awt.Image.SCALE_SMOOTH));
		///addpg.setIcon(addbookpgicon);
		addpg.setForeground(Color.decode("#3A3A3A"));
		addpg.setBounds(150,139,420,259);
		addpg.setPreferredSize(new Dimension(273,186));
		//addpg.setBackground(Color.decode("#E2E2E2"));	
		//addpg.setBackground(Color.red);
		//addpg.setOpaque(true);
		
		JPanel addpgcon=new JPanel();
		addpgcon.setPreferredSize(new Dimension(400,200));
		addpgcon.setLayout(new FlowLayout (FlowLayout.LEADING, 63, 7));
		addpgcon.add(addpg);
		//addpgcon.setBackground(Color.red);
		
		
		
		/*JPanel imgpg=new JPanel();
		imgpg.setPreferredSize(new Dimension(400,200));
		imgpg.setLayout(new FlowLayout (FlowLayout.LEADING, 63, 7));
		imgpg.add(addpg);
		imgpg.setBackground(Color.blue);*/
		
		JButton imgbtn=new JButton("Choose Image");
		imgbtn.setPreferredSize(new Dimension(200,63));
		imgbtn.setBackground(Color.decode("#A743D9"));
		imgbtn.setBorder(null);
	    imgbtn.setForeground(Color.white);
	    imgbtn.addMouseListener(new MouseListener() {
	    	@Override
            public void mouseClicked(MouseEvent e) {
            	
            	JFileChooser imgfc=new JFileChooser();
        		imgfc.showOpenDialog(null);
        		File f =imgfc.getSelectedFile();
        		filename =f.getAbsolutePath();
        		
        		try
        		{
        			File image=new File(filename);
        			//String pathname=imgfc.getSelectedFile().getPath();
        			ImageIcon newimg=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(addpg.getWidth(),addpg.getHeight(),Image.SCALE_SMOOTH));
            		addpg.setIcon(newimg);
        			/*try (FileInputStream fis = new FileInputStream(image)) {
						ByteArrayOutputStream bos=new ByteArrayOutputStream();
						byte[] buf=new byte[1024];
						for(int readnum;(readnum=fis.read(buf))!=1;)
						{
							bos.write(buf,0,readnum);
						}
						bookimage=bos.toByteArray();*/
					
        			
        			
        		}
        		catch(Exception ee)
        		{
        			JOptionPane.showMessageDialog(null, ee);
        		}
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
	    
	    JPanel imgbtnpg=new JPanel();
		imgbtnpg.setPreferredSize(new Dimension(400,63));
		imgbtnpg.setLayout(new FlowLayout (FlowLayout.CENTER, 0, 0));
		imgbtnpg.add(imgbtn);
		imgbtnpg.setBackground(Color.white);
		
		JTextField title=new JTextField("Title");
		title.setFont(new Font("",Font.PLAIN,25));
		//title.setBounds(6,145,408,63);
		title.setBorder(null);
		title.setForeground(Color.decode("#7E7E7E"));
		title.setPreferredSize(new Dimension(400,63));
		title.setBackground(Color.decode("#E2E2E2"));
		
		
		JTextField author=new JTextField("Author");
		author.setFont(new Font("",Font.PLAIN,25));
		//author.setBounds(6,228,408,63);
		author.setBorder(null);
		author.setForeground(Color.decode("#7E7E7E"));
		author.setPreferredSize(new Dimension(400,63));
		author.setBackground(Color.decode("#E2E2E2"));
		
		JTextField count=new JTextField("Count");
		count.setFont(new Font("",Font.PLAIN,25));
		//author.setBounds(6,228,408,63);
		count.setBorder(null);
		count.setForeground(Color.decode("#7E7E7E"));
		count.setPreferredSize(new Dimension(400,63));
		count.setBackground(Color.decode("#E2E2E2"));
		
		
		/**/
		
		
		
		JTextField addimg=new JTextField("Add Image");
		addimg.setFont(new Font("",Font.PLAIN,25));
		//author.setBounds(6,228,408,63);
		addimg.setForeground(Color.decode("#7E7E7E"));
		addimg.setBorder(null);
		addimg.setPreferredSize(new Dimension(400,63));
		addimg.setBackground(Color.decode("#E2E2E2"));
		
		JTextField rating=new JTextField("Rating");
		rating.setFont(new Font("",Font.PLAIN,25));
		//author.setBounds(6,228,408,63);
		rating.setBorder(null);
		rating.setForeground(Color.decode("#7E7E7E"));
		rating.setPreferredSize(new Dimension(400,63));
		rating.setBackground(Color.decode("#E2E2E2"));
		
		JTextField genre=new JTextField("Genre");
		genre.setFont(new Font("",Font.PLAIN,25));
		//author.setBounds(6,228,408,63);
		genre.setBorder(null);
		genre.setForeground(Color.decode("#7E7E7E"));
		genre.setPreferredSize(new Dimension(400,63));
		genre.setBackground(Color.decode("#E2E2E2"));
		
		JButton addbookpgbtn=new JButton("ADD BOOK");
		addbookpgbtn.setFont(new Font("",Font.BOLD,25));
		addbookpgbtn.setPreferredSize(new Dimension(400,63));
		addbookpgbtn.setBackground(Color.decode("#A743D9"));
		addbookpgbtn.setBorder(null);
		addbookpgbtn.setForeground(Color.white);
		addbookpgbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
				
                String booktitle = title.getText();
               // String Gender = null;
               /* if(rdbtnMale.isSelected())
                {
                	Gender="Male";
                	rdbtnFemale.setSelected(false);
                }
                	else if(rdbtnFemale.isSelected())
                	{
                	Gender="Female";
                	rdbtnMale.setSelected(false);
                	}*/
                String authorname = author.getText();
                String countno = count.getText();
                String addimage = addpg.getText();
                String ratings = rating.getText();
                String genres = genre.getText();
              //  String Password= txtPassword.getText();
                //String Genre;
                
                int len = ratings.length();
                //int usr =Username.length();
                //int gdr=Gender.length();
                //int dep=Department.length();
                String msg = "" + booktitle;
                msg += " \n";
                /*if (len != 10) {
                    JOptionPane.showMessageDialog(addbookpgbtn, "Enter a valid mobile number");
                */
                Connection con=null;
        		
                try {
                	//Class.forName("com.mysql.cj.jdbc.Driver");
                	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        			if(!con.isClosed())
        				System.out.println("sucess");
        			Statement sta = con.createStatement();
        			File imgfile=new File(filename);
                    //FileInputStream fin=new FileInputStream(imgfile);
                    FileInputStream in =new FileInputStream(imgfile);

                    //String query = "INSERT INTO books(title,author,genre,rating,bookimage,count) values('" + booktitle + "','" + authorname + "','" + genres + "','" +
                    //		ratings + "','" + in + "','" + countno + "')";
                    PreparedStatement pre=con.prepareStatement("insert into books(title,author,genre,rating,bookimage,count) values(?,?,?,?,?,?)");
                    pre.setString(1,booktitle);
                    pre.setString(2,authorname);
                    pre.setString(3,genres);
                    pre.setString(4,ratings);
                    pre.setBinaryStream(5,(InputStream)in,(int)imgfile.length());
                    pre.setString(6,countno);
                   int x= pre.executeUpdate();
                    
                   
                    
                    
                   // int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(addbookpgbtn, "This already exists");
                        pre.close();
                        con.close();
                        } else {
                        JOptionPane.showMessageDialog(addbookpgbtn,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                Dashboard obj=new Dashboard();
            	obj.table.repaint();
            	
                
            }
        });
		//addbookpgbtn.setIcon(delbookicon);
		//addbookpgbtn.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		//addbookpgbtn.setContentAreaFilled(false);
		
		
		
		setBackground(Color.white);
		
		add(addpgcon);
		add(imgbtnpg);
		add(title);
		add(author);
		add(count);
		//add(addimg);
		add(rating);
		add(genre);
		add(addbookpgbtn);
		
	}

}
