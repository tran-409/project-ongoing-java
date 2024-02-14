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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deposit extends JFrame {

	private JPanel contentPane;
	private JTextField AccAmount;
	static int AccountID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposit frame = new deposit(AccountID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String MyDate;
	
	public void getDate() {
		Date today = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		MyDate = s.format(today);
	}
	
	
	private void deposited() {
		try {
			getDate();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
			PreparedStatement add = con.prepareStatement("insert into transaction values(?,?,?,?)");
			add.setInt(1, 1);
			add.setInt(2, AccountID);
			add.setString(3, AccAmount.getText());
			add.setString(4, MyDate);
			int row = add.executeUpdate();
//			JOptionPane.showMessageDialog(null, "Account saved", "Account creation", JOptionPane.PLAIN_MESSAGE);
			con.close();
//			clear();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.PLAIN_MESSAGE);
	}
	}
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet Rs = null; 
	Statement st = null;
	int OldBalance;
	
	private void GetBalance() {
		String query = "select * from newusers where accountID='"+AccountID+"'";
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
				JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.PLAIN_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public deposit(int AccID) {
		this.AccountID = AccID;
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
		
		JLabel lblDeposit = new JLabel("Deposit:");
		lblDeposit.setForeground(Color.BLACK);
		lblDeposit.setFont(new Font("Berlin Sans FB", Font.ITALIC, 40));
		lblDeposit.setBackground(Color.GRAY);
		lblDeposit.setBounds(294, 133, 149, 63);
		panel.add(lblDeposit);
		
		JLabel lblAmount = new JLabel("AMOUNT:");
		lblAmount.setForeground(Color.BLACK);
		lblAmount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAmount.setBackground(Color.GRAY);
		lblAmount.setBounds(206, 238, 112, 33);
		panel.add(lblAmount);
		
		AccAmount = new JTextField();
		AccAmount.setColumns(10);
		AccAmount.setBounds(328, 238, 206, 28);
		panel.add(AccAmount);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 531, 722, 10);
		panel.add(panel_2);
		
		
		JButton AccSubmitDeposit = new JButton("Submit");
		AccSubmitDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AccSubmitDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(AccAmount.getText().isEmpty() || AccAmount.getText().equals(0)) {
					JOptionPane.showMessageDialog(null,"Enter valid amount!", "Error", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						String Query = "Update newUsers set balance = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(Query);
						ps.setInt(1, OldBalance + Integer.valueOf(AccAmount.getText()));
						ps.setInt(2, AccID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Balance Updated", null, JOptionPane.PLAIN_MESSAGE);
							new mainMenu(AccID).setVisible(true);
							dispose();
							deposited();
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
					
				}
			}
		});
		
		
		AccSubmitDeposit.setForeground(Color.BLACK);
		AccSubmitDeposit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccSubmitDeposit.setBackground(Color.WHITE);
		AccSubmitDeposit.setBounds(311, 333, 119, 37);
		panel.add(AccSubmitDeposit);
		
		JLabel AccBack = new JLabel("Back");
		AccBack.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new mainMenu(AccID).setVisible(true);
				dispose();
			}
		});
		
		AccBack.setForeground(Color.BLACK);
		AccBack.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		AccBack.setBackground(Color.GRAY);
		AccBack.setBounds(339, 378, 73, 39);
		panel.add(AccBack);
		
		JLabel AccLogout = new JLabel("Logout");
		AccLogout.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);;
				dispose();
			}
		});
		
		AccLogout.setForeground(Color.LIGHT_GRAY);
		AccLogout.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		AccLogout.setBackground(Color.GRAY);
		AccLogout.setBounds(607, 133, 105, 44);
		panel.add(AccLogout);
		
		
		
	}
}
