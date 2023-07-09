package library;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
public class signup  {
	private JTextField textField;
	private JTextField txtUsername;
	private JTextField txtYear;
	private JTextField txtDepartment;
	private JTextField txtClass;
	private JTextField txtRollNo;
	private JTextField txtPhoneNo;
	private JTextField txtPassword;
	JFrame frame;
	public static void main(String[] args)
	{
		signup window =new signup();
		window.frame.setVisible(true);
		Connection con=null;
		/*try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			if(!con.isClosed())
				System.out.println("sucess");
			//Statement stat=con.createStatement();
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
		}*/
	}
 public signup()
 {
	 
		
		JPanel panel = new JPanel();
		panel.setBounds(980, 11, 509, 646);
		panel.setLayout(null);
		panel.setSize(600,960);
		
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(139, 59, 240, 33);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(139, 107, 60, 23);
		panel.add(rdbtnMale);
		rdbtnMale.setSelected(false);
		
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(230, 107, 60, 23);
		panel.add(rdbtnFemale);
		rdbtnFemale.setSelected(true);
		
		
		txtYear = new JTextField();
		txtYear.setText("Year");
		txtYear.setBounds(279, 157, 100, 33);
		panel.add(txtYear);
		txtYear.setColumns(10);
		
		txtDepartment = new JTextField();
		txtDepartment.setText("Department");
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(139, 157, 100, 33);
		panel.add(txtDepartment);
		
		txtClass = new JTextField();
		txtClass.setText("Class");
		txtClass.setColumns(10);
		txtClass.setBounds(139, 223, 100, 33);
		panel.add(txtClass);
		
		txtRollNo = new JTextField();
		txtRollNo.setText("Roll No");
		txtRollNo.setColumns(10);
		txtRollNo.setBounds(279, 223, 100, 33);
		panel.add(txtRollNo);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setText("Phone No");
		txtPhoneNo.setColumns(10);
		txtPhoneNo.setBounds(139, 288, 240, 33);
		panel.add(txtPhoneNo);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(139, 351, 240, 33);
		panel.add(txtPassword);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Action");
		chckbxNewCheckBox.setBounds(139, 417, 68, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxTriller = new JCheckBox("Drama");
		chckbxTriller.setBounds(279, 417, 68, 23);
		panel.add(chckbxTriller);
		
		JCheckBox chckbxTriller_1 = new JCheckBox("triller");
		chckbxTriller_1.setBounds(212, 417, 68, 23);
		panel.add(chckbxTriller_1);
		
		JCheckBox chckbxRomance = new JCheckBox("Romance");
		chckbxRomance.setBounds(139, 455, 100, 23);
		panel.add(chckbxRomance);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBackground(new Color(165, 87, 181));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(139, 493, 240, 33);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Username = txtUsername.getText();
                String Gender = null;
                if(rdbtnMale.isSelected())
                {
                	Gender="Male";
                	rdbtnFemale.setSelected(false);
                }
                	else if(rdbtnFemale.isSelected())
                	{
                	Gender="Female";
                	rdbtnMale.setSelected(false);
                	}
                String Department = txtDepartment.getText();
                String Year = txtYear.getText();
                String Class = txtClass.getText();
                String Rollno = txtRollNo.getText();
                String Phone = txtPhoneNo.getText();
                String Password= txtPassword.getText();
                //String Genre;
                String Action=chckbxNewCheckBox.getText();
                String Romance=chckbxRomance.getText();
                String Drama=chckbxTriller.getText();
                String Triller=chckbxTriller_1.getText();
                int len = Phone.length();
                int usr =Username.length();
                int gdr=Gender.length();
                int dep=Department.length();
                String msg = "" + Username;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }
                Connection con=null;
        		
                try {
                	//Class.forName("com.mysql.cj.jdbc.Driver");
                	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        			if(!con.isClosed())
        				System.out.println("sucess");

                    String query = "INSERT INTO student(username,password,department,year,class,rno,phone,genre,sex) values('" + Username + "','" + Password + "','" + Department + "','" +
                        Year + "','" + Class + "','" + Rollno + "','" + Phone + "','" + Action + Drama + "','" + Gender + "')";

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This already exists");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                
            }
        });
		panel.add(btnNewButton);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogIn.setBounds(139, 572, 240, 33);
		panel.add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				login obj1=new login();
				obj1.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Already have an account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(169, 537, 178, 24);
		
		
		JLabel lblNewLabel_1 = new JLabel("LIBRARY");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(133, 158, 193, 48);
		
		
		JLabel lblNewLabel_2 = new JLabel("Designed to manage all the functions ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(133, 219, 294, 38);
		
		
		/*JButton btnNewButton2 = new JButton("LOG IN");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				login obj1=new login();
				obj1.frame.setVisible(true);
				frame.dispose();
				
			}
		});*/
		
		
		
	/*	JPanel container = new JPanel();
		container.setBackground(Color.decode("#D9C4E3"));
		//container.setBackground(new Color(0, 0, 0));
		//container.setBounds(new Rectangle(0, 0, 749, 499));
		container.setPreferredSize(new Dimension(1080, 720));
		container.setBounds(0, 0, 1080, 720);
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));*/
		
		//setContentpane(panel_1);
		 frame = new JFrame();
        
         frame.setSize(1750,1020);
         //frame.getContentPane().setSize(1750,1020);  
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
         frame.add(lblNewLabel_1);
         frame.add(lblNewLabel_2);
   
 		
	
		frame.setTitle("LIBRARY MANAGEMNET SYSTEM");
		frame.setResizable(false);
		
		frame.getContentPane().setBackground(new Color(128, 128, 255));

		
		frame.add(panel);
		
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		ImageIcon image=new ImageIcon("library.png");
		frame.setIconImage(image.getImage());
		
		 
		
 }

}