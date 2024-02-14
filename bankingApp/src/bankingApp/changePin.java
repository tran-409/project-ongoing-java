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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changePin extends JFrame {

	private JPanel contentPane;
	private JTextField newPin1;
	private JTextField newPin;
	static int AccID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changePin frame = new changePin(AccID);
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

	/**
	 * Create the frame.
	 */
	public changePin(int AccountID) {
		this.AccID = AccountID;
		
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
		
		JLabel lblDeposit = new JLabel("Pin Reset");
		lblDeposit.setForeground(Color.BLACK);
		lblDeposit.setFont(new Font("Berlin Sans FB", Font.ITALIC, 40));
		lblDeposit.setBackground(Color.GRAY);
		lblDeposit.setBounds(293, 133, 181, 63);
		panel.add(lblDeposit);
		
		JLabel lblAmount = new JLabel("Confirm New Pin:");
		lblAmount.setForeground(Color.BLACK);
		lblAmount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAmount.setBackground(Color.GRAY);
		lblAmount.setBounds(125, 272, 189, 33);
		panel.add(lblAmount);
		
		newPin1 = new JTextField();
		newPin1.setColumns(10);
		newPin1.setBounds(320, 272, 206, 28);
		panel.add(newPin1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 531, 722, 10);
		panel.add(panel_2);
		
		JButton AccSubmit = new JButton("Submit");
		AccSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AccSubmit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(newPin.getText().isEmpty() || newPin1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter a pin.",null, JOptionPane.PLAIN_MESSAGE);
				} else if(!newPin.getText().equals(newPin1.getText())){
					JOptionPane.showMessageDialog(null, "Pins doesn't match!",null, JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						String query = "Update newUsers set pin = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, Integer.valueOf(newPin.getText()));
						ps.setInt(2, AccountID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Pin Updated", null, JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
				}
			}
		});
		
		
		AccSubmit.setForeground(Color.BLACK);
		AccSubmit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccSubmit.setBackground(Color.WHITE);
		AccSubmit.setBounds(309, 328, 119, 37);
		panel.add(AccSubmit);
		
		JLabel accBack = new JLabel("Back");
		accBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new mainMenu(AccountID).setVisible(true);
				dispose();
			}
		});
		accBack.setForeground(Color.BLACK);
		accBack.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		accBack.setBackground(Color.GRAY);
		accBack.setBounds(337, 373, 73, 39);
		panel.add(accBack);
		
		JLabel lblNewLabel = new JLabel("Logout");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(607, 133, 105, 44);
		panel.add(lblNewLabel);
		
		JLabel lblOldPin = new JLabel("New Pin:");
		lblOldPin.setForeground(Color.BLACK);
		lblOldPin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblOldPin.setBackground(Color.GRAY);
		lblOldPin.setBounds(215, 219, 99, 33);
		panel.add(lblOldPin);
		
		newPin = new JTextField();
		newPin.setColumns(10);
		newPin.setBounds(320, 219, 206, 28);
		panel.add(newPin);
	}
}
