package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Topmenu{
	public static void main(String[] args)
{
		
				JPanel left=new JPanel();
				left
				
				
				JPanel right=new JPanel();
				
				
				
				JPanel container = new JPanel();
				container.setBackground(Color.decode("#D9C4E3"));
				//container.setBackground(new Color(0, 0, 0));
				//container.setBounds(new Rectangle(0, 0, 749, 499));
				container.setPreferredSize(new Dimension(1080, 720));
				container.setBounds(0, 0, 1080, 720);
				container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				
				
				JFrame j = new JFrame();
				j.setTitle("LIBRARY MANAGEMNET SYSTEM");
				j.setResizable(false);
			    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				j.getContentPane().setBackground(Color.yellow);
				j.setSize(1080,720);
				j.add(container);
				j.setVisible(true);
				j.setLocationRelativeTo(null);
				j.getContentPane().setLayout(null);
				ImageIcon image=new ImageIcon("library.png");
				j.setIconImage(image.getImage());
}
}