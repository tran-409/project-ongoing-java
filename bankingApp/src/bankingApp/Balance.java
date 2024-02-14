package bankingApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Balance extends JFrame {

	static int AccID;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance frame = new Balance(AccID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet Rs = null; 
	Statement st = null;
	int OldBalance;
	
	private void GetBalance() {
		String query = "select * from newUsers where accountID='"+AccID+"'";
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
			st = con.createStatement();
			Rs = st.executeQuery(query);
			if(Rs.next()) {
				OldBalance = Rs.getInt(9);
				
			}else {
				
			}
		}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "Wrong username or pin!", "Error", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Balance(int AccountID) {
		this.AccID = AccountID;
		GetBalance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 722, 440);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 722, 123);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Family Inc. Bank");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(225, 10, 277, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("In Family, We Trust.");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 24));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(428, 77, 214, 36);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblAmount = new JLabel("Your Balance:");
		lblAmount.setForeground(Color.BLACK);
		lblAmount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAmount.setBackground(Color.GRAY);
		lblAmount.setBounds(235, 248, 176, 33);
		panel.add(lblAmount);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 531, 722, 10);
		panel.add(panel_2);
		
		JLabel backButton = new JLabel("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new mainMenu(AccountID).setVisible(true);
				dispose();
			}
		});
		backButton.setForeground(Color.BLACK);
		backButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		backButton.setBackground(Color.GRAY);
		backButton.setBounds(340, 344, 73, 39);
		panel.add(backButton);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setForeground(Color.BLACK);
		lblAccountNumber.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAccountNumber.setBackground(Color.GRAY);
		lblAccountNumber.setBounds(200, 191, 195, 33);
		panel.add(lblAccountNumber);
		
		JLabel lblNewLabel = new JLabel("Logout");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(607, 133, 105, 44);
		panel.add(lblNewLabel);
		
		JLabel AccIDLabel = new JLabel("");
		AccIDLabel.setForeground(Color.BLACK);
		AccIDLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		AccIDLabel.setBackground(Color.GRAY);
		AccIDLabel.setBounds(401, 191, 123, 33);
		panel.add(AccIDLabel);
		
		AccIDLabel.setText("" + AccountID);
		
		JLabel AccBalanceLabel = new JLabel("");
		AccBalanceLabel.setForeground(Color.BLACK);
		AccBalanceLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		AccBalanceLabel.setBackground(Color.GRAY);
		AccBalanceLabel.setBounds(401, 248, 123, 33);
		panel.add(AccBalanceLabel);
		
		AccBalanceLabel.setText(""+OldBalance);
	}
}
