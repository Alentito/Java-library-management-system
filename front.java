package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class front {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					front window = new front();
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
	public front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel container = new JPanel();
		container.setBackground(new Color(0, 0, 0));
		//container.setBackground(new Color(0, 0, 0));
		//container.setBounds(new Rectangle(0, 0, 749, 499));
		container.setPreferredSize(new Dimension(749, 499));
		container.setBounds(0, 0, 749, 462);
		frame.getContentPane().add(container);
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel header = new JPanel();
		header.setBackground(new Color(128, 0, 255));
		header.setPreferredSize(new Dimension(749, 60));
		container.add(header);
		header.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setPreferredSize(new Dimension(749, 60));
		container.add(menu);
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(561, 60));
		menu.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(187, 60));
		menu.add(panel_1);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_1.add(btnNewButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(749, 342));
		container.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 128));
		panel_2.setPreferredSize(new Dimension(740, 3400));
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(740, 300));
		panel_2.add(panel_3);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(128, 0, 255));
		panel_3_2.setPreferredSize(new Dimension(740, 150));
		panel_2.add(panel_3_2);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
