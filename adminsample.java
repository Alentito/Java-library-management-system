package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class adminsample {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminsample window = new adminsample();
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
	public adminsample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 661);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 202, 622);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 46, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setBounds(76, 20, 46, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 55, 119, 25);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DASHBOARD");
		lblNewLabel_2.setBounds(22, 11, 76, 14);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 120, 202, 33);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(".");
		lblNewLabel_3.setBounds(10, 11, 30, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BOOKS");
		lblNewLabel_4.setBounds(74, 11, 46, 14);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(0, 152, 202, 33);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel(".");
		lblNewLabel_3_1.setBounds(10, 11, 30, 14);
		panel_2_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("ISSUE");
		lblNewLabel_4_1.setBounds(74, 11, 46, 14);
		panel_2_1.add(lblNewLabel_4_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(0, 184, 202, 33);
		panel.add(panel_2_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(".");
		lblNewLabel_3_1_1.setBounds(10, 11, 30, 14);
		panel_2_1_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("RETURN");
		lblNewLabel_4_1_1.setBounds(74, 11, 46, 14);
		panel_2_1_1.add(lblNewLabel_4_1_1);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBounds(0, 217, 202, 33);
		panel.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(".");
		lblNewLabel_3_1_1_1.setBounds(10, 11, 30, 14);
		panel_2_1_1_1.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("NOT RETURNED");
		lblNewLabel_4_1_1_1.setBounds(74, 11, 97, 14);
		panel_2_1_1_1.add(lblNewLabel_4_1_1_1);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBounds(0, 552, 202, 33);
		panel.add(panel_2_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel(".");
		lblNewLabel_3_1_1_1_1.setBounds(10, 11, 30, 14);
		panel_2_1_1_1_1.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("LOGOUT");
		lblNewLabel_4_1_1_1_1.setBounds(74, 11, 46, 14);
		panel_2_1_1_1_1.add(lblNewLabel_4_1_1_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(206, 0, 442, 53);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(202, 11, 192, 31);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 161, 31);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(206, 56, 442, 53);
		frame.getContentPane().add(panel_3_1);
	}
}
