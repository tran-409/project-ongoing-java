package bankingApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;

public class Splash extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Splash frame = new Splash();
		frame.setVisible(true);
		try {
			for(int i = 0; i <=100; i++) {
				Thread.sleep(50);
				frame.progressBar.setValue(i);
			}
		} catch (Exception e) {
			
		}
		new Login().setVisible(true);
		frame.dispose();
	}JProgressBar progressBar = new JProgressBar();

	/**
	 * Create the frame.
	 */
	public Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 426);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 382, 389);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\trant\\OneDrive\\Desktop\\atm.png"));
		lblNewLabel.setBounds(100, 130, 152, 193);
		panel.add(lblNewLabel);
		progressBar.setStringPainted(true);
		
		
		progressBar.setBounds(0, 368, 382, 21);
		panel.add(progressBar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Family Inc. Bank");
		lblNewLabel_1_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(55, 64, 265, 48);
		panel.add(lblNewLabel_1_1);
	}
}
