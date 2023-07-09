package library;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class home
{
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setTitle("LIBRARY MANAGEMNET SYSTEM");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.setSize(1080,720);
		frame.setVisible(true);
		ImageIcon image=new ImageIcon("library.png");
		frame.setIconImage(image.getImage());
	}
}