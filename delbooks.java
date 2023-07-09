package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class delbooks extends JPanel {
	public delbooks()
	{
		setBounds(0,0,420,1020);
		setLayout(new FlowLayout (FlowLayout.LEADING, 10, 20));
		setVisible(true);
		
		JLabel addpg=new JLabel();
		//addpg.setFont(new Font("",Font.BOLD,25));
		ImageIcon addbookpgicon=new ImageIcon(((new ImageIcon("delbookpg.png")).getImage()).getScaledInstance(420, 259, java.awt.Image.SCALE_SMOOTH));
		addpg.setIcon(addbookpgicon);
		addpg.setForeground(Color.decode("#3A3A3A"));
		addpg.setBounds(150,139,420,259);
		
		
		JTextField delbookid=new JTextField("Title");
		delbookid.setFont(new Font("",Font.PLAIN,25));
		//title.setBounds(6,145,408,63);
		delbookid.setBorder(null);
		delbookid.setForeground(Color.decode("#7E7E7E"));
		delbookid.setPreferredSize(new Dimension(400,63));
		delbookid.setBackground(Color.decode("#E2E2E2"));
		
		JButton delbookpgbtn=new JButton("DELETE BOOK");
		delbookpgbtn.setFont(new Font("",Font.BOLD,25));
		delbookpgbtn.setPreferredSize(new Dimension(400,63));
		delbookpgbtn.setBackground(Color.decode("#A743D9"));
		delbookpgbtn.setBorder(null);
		delbookpgbtn.setForeground(Color.white);
		delbookpgbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String bookid = delbookid.getText();
                Connection con=null;
        		
                try {
                	//Class.forName("com.mysql.cj.jdbc.Driver");
                	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        			if(!con.isClosed())
        				System.out.println("sucess");
        			

                    String query = "delete from books where bookid= " + bookid+ " ";

                    Statement sta = con.createStatement();
                   
                    
                    
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(delbookid, "This already exists");
                    } else {
                        JOptionPane.showMessageDialog(delbookpgbtn,
                            "Book Id : , " + bookid + "Deleted sucessfully");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                Dashboard obj=new Dashboard();
            	obj.table.repaint();
            	
               // DefaultTableModel model=(DefaultTableModel)obj.table.getModel();
               // model.setRowCount(0);
               // obj.showbook();
            	//((AbstractTableModel)obj.table.getModel()).fireTableCellUpdated(x,0);
            }
        });

		
		setBackground(Color.white);
		
		add(addpg);
		add(delbookid);
		add(delbookpgbtn);
		
	}

}
