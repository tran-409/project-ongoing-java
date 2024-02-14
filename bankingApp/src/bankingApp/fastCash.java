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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fastCash extends JFrame {

	private JPanel contentPane;

	static int AccID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fastCash frame = new fastCash(AccID);
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
	public fastCash(int AccountID) {
		this.AccID = AccountID;
		GetBalance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 821, 515);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 827, 122);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Family Inc. Bank");
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(277, 10, 298, 48);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("In Family, We Trust.");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 24));
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(563, 76, 214, 36);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fast Cash");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 35));
		lblNewLabel_1_1_1.setBackground(Color.GRAY);
		lblNewLabel_1_1_1.setBounds(327, 146, 163, 44);
		panel.add(lblNewLabel_1_1_1);
		
		JButton Button20 = new JButton("$20");
		Button20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(OldBalance < 20) {
					JOptionPane.showMessageDialog(null, "Unable to withdraw!",null, JOptionPane.PLAIN_MESSAGE);
				} else {
					
					try {
						String query = "Update newUsers set balance = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, OldBalance - 20);
						ps.setInt(2, AccountID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Balance Updated", null, JOptionPane.PLAIN_MESSAGE);
							new mainMenu(AccountID).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
				}
			}	
		});
		
		Button20.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Button20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button20.setForeground(Color.BLACK);
		Button20.setBackground(Color.WHITE);
		Button20.setBounds(87, 224, 175, 65);
		panel.add(Button20);
		
		JButton Button40 = new JButton("$40");
		Button40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(OldBalance < 40) {
					JOptionPane.showMessageDialog(null, "Unable to withdraw!",null, JOptionPane.PLAIN_MESSAGE);
				} else {
					
					try {
						String query = "Update newUsers set balance = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, OldBalance - 40);
						ps.setInt(2, AccountID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Balance Updated", null, JOptionPane.PLAIN_MESSAGE);
							new mainMenu(AccountID).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
				}
			}
		});
		Button40.setForeground(Color.BLACK);
		Button40.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Button40.setBackground(Color.WHITE);
		Button40.setBounds(555, 224, 175, 65);
		panel.add(Button40);
		
		JButton Button80 = new JButton("$80");
		Button80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OldBalance < 80) {
					JOptionPane.showMessageDialog(null, "Unable to withdraw!",null, JOptionPane.PLAIN_MESSAGE);
				} else {
					
					try {
						String query = "Update newUsers set balance = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, OldBalance - 80);
						ps.setInt(2, AccountID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Balance Updated", null, JOptionPane.PLAIN_MESSAGE);
							new mainMenu(AccountID).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
				}
			}
		});
		Button80.setForeground(Color.BLACK);
		Button80.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Button80.setBackground(Color.WHITE);
		Button80.setBounds(87, 321, 175, 65);
		panel.add(Button80);
		
		JButton Button100 = new JButton("$100");
		Button100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(OldBalance < 100) {
					JOptionPane.showMessageDialog(null, "Unable to withdraw!",null, JOptionPane.PLAIN_MESSAGE);
				} else {
					
					try {
						String query = "Update newUsers set balance = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, OldBalance - 100);
						ps.setInt(2, AccountID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Balance Updated", null, JOptionPane.PLAIN_MESSAGE);
							new mainMenu(AccountID).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
				}
			}
		});
		Button100.setForeground(Color.BLACK);
		Button100.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Button100.setBackground(Color.WHITE);
		Button100.setBounds(555, 321, 175, 65);
		panel.add(Button100);
		
		JButton Button200 = new JButton("$200");
		Button200.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(OldBalance < 200) {
					JOptionPane.showMessageDialog(null, "Unable to withdraw!",null, JOptionPane.PLAIN_MESSAGE);
				} else {
					
					try {
						String query = "Update newUsers set balance = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, OldBalance - 200);
						ps.setInt(2, AccountID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Balance Updated", null, JOptionPane.PLAIN_MESSAGE);
							new mainMenu(AccountID).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
				}
			}
		});
		Button200.setForeground(Color.BLACK);
		Button200.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Button200.setBackground(Color.WHITE);
		Button200.setBounds(87, 421, 175, 65);
		panel.add(Button200);
		
		JButton Button300 = new JButton("$300");
		Button300.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(OldBalance < 300) {
					JOptionPane.showMessageDialog(null, "Unable to withdraw!",null, JOptionPane.PLAIN_MESSAGE);
				} else {
					
					try {
						String query = "Update newUsers set balance = ? where accountID = ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, OldBalance - 300);
						ps.setInt(2, AccountID);
						if(ps.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "Balance Updated", null, JOptionPane.PLAIN_MESSAGE);
							new mainMenu(AccountID).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Missing Information", null, JOptionPane.PLAIN_MESSAGE);
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.PLAIN_MESSAGE);
						
					}
				}
			}
		});
		Button300.setForeground(Color.BLACK);
		Button300.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Button300.setBackground(Color.WHITE);
		Button300.setBounds(555, 421, 175, 65);
		panel.add(Button300);
		
		JLabel Logout = new JLabel("Logout");
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login();
				dispose();
			}
		});
		Logout.setFont(new Font("Berlin Sans FB", Font.PLAIN, 34));
		Logout.setForeground(Color.LIGHT_GRAY);
		Logout.setBackground(Color.GRAY);
		Logout.setBounds(351, 328, 116, 44);
		panel.add(Logout);
	}
}
