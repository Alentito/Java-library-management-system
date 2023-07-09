package library;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class sample extends JPanel {
	private JTextField textField;
	private JTable table;
	public sample() {
		setBackground(new Color(128, 128, 255));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 202, 750, 263);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"BOOKID", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		
		//nav1
				JLabel nav1img = new JLabel();
				nav1img.setBounds(19,25,50,50);
				ImageIcon nav1icon=new ImageIcon(((new ImageIcon("nav1.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
				bookimg.setIcon(nav1icon);
				
				JLabel nav1name=new JLabel("ADD BOOKS");
				nav1name.setBounds(100,30,200,40);
				nav1name.setFont(new Font("",Font.PLAIN,25));
				nav1name.setForeground(Color.decode("#3A3A3A"));
				
				JPanel nav1=new JPanel();
				nav1.setPreferredSize(new Dimension(380,100));
				nav1.setBackground(Color.blue);
				nav1.setLayout(null);
				nav1.add(bookimg);
				nav1.add(bookname);
		
	}
/*
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = Color.RED;
        Color color2 = Color.GREEN;
        GradientPaint gp = new GradientPaint(0, 0, Color.red, 200, 40, Color.blue);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, 200, 40);
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
               //sample panel = new sample();
                frame.setSize(1750,1020);
                
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
