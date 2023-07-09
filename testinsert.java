package library;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class testinsert {

	private JFrame frame;
	private JTextField textField;
	String filename= null;
	byte[] bookimage=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testinsert window = new testinsert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testinsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(107, 113, 465, 319);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(106, 49, 228, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(161, 176, 131, 37);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
				
                //String booktitle = title.getText();
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
                //String authorname = author.getText();
                //String countno = count.getText();
                //String addimage = addpg.getText();
                //String ratings = rating.getText();
                //String genres = genre.getText();
              //  String Password= txtPassword.getText();
                //String Genre;
                
               // int len = ratings.length();
                //int usr =Username.length();
                //int gdr=Gender.length();
                //int dep=Department.length();
                //String msg = "" + booktitle;
               // msg += " \n";
                /*if (len != 10) {
                    JOptionPane.showMessageDialog(addbookpgbtn, "Enter a valid mobile number");
                */
                Connection con=null;
        		
                try {
                	//Class.forName("com.mysql.cj.jdbc.Driver");
                	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        			if(!con.isClosed())
        				System.out.println("sucess");
        			
        			File imgfile=new File(filename);
                    //FileInputStream fin=new FileInputStream(imgfile);
                    InputStream in =new FileInputStream(imgfile);

                    String query = "INSERT INTO books(bookimage) values('" + in + "')";

                    Statement sta = con.createStatement();
                   
                    
                    
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This already exists");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, Your account is sucessfully created");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                Dashboard obj=new Dashboard();
            	obj.table.repaint();
            	
                
            }
        });
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(174, 120, 89, 23);
		btnNewButton_1.addMouseListener(new MouseListener() {
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

		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");

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
		lblNewLabel.setBounds(10, 154, 111, 124);
		panel.add(lblNewLabel);
	}
}
