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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField AccID;
	private JPasswordField AccPin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 761, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 765, 111);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Family Inc. Bank");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(269, 10, 277, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("In Family, We Trust.");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 24));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(502, 65, 214, 36);
		panel_1.add(lblNewLabel_1_1);
		
		AccID = new JTextField();
		AccID.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		AccID.setForeground(Color.BLACK);
		AccID.setBackground(Color.WHITE);
		AccID.setBounds(286, 201, 262, 42);
		panel.add(AccID);
		AccID.setColumns(10);
		
		AccPin = new JPasswordField();
		AccPin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AccPin.setForeground(Color.BLACK);
		AccPin.setBackground(Color.WHITE);
		AccPin.setBounds(286, 270, 262, 42);
		panel.add(AccPin);
		
		JLabel lblNewLabel = new JLabel("LOGIN INFO");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 37));
		lblNewLabel.setBounds(286, 122, 250, 48);
		panel.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Account #:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 37));
		lblUsername.setBackground(Color.GRAY);
		lblUsername.setBounds(123, 201, 153, 48);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Pin #: ");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 37));
		lblPassword.setBackground(Color.GRAY);
		lblPassword.setBounds(185, 264, 99, 48);
		panel.add(lblPassword);
		
		JButton AccLogin = new JButton("Login");
		AccLogin.addMouseListener(new MouseAdapter() {
			
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet Rs = null;
			Statement st = null;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(AccID.getText().isEmpty() || AccPin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Account ID and Pin.", "Error", JOptionPane.PLAIN_MESSAGE);
				} else {
					String query = "select * from newusers where accountID='"+AccID.getText()+"' and pin="+AccPin.getText()+"";
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						st = con.createStatement();
						Rs = st.executeQuery(query);
						if(Rs.next()) {
							new mainMenu(Rs.getInt(1)).setVisible(true);
							dispose();
						}
					}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Wrong username or pin!", null, JOptionPane.PLAIN_MESSAGE);
					}
				}	
			}
			
		});
		AccLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AccLogin.setForeground(Color.BLACK);
		AccLogin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccLogin.setBackground(Color.WHITE);
		AccLogin.setBounds(354, 340, 119, 37);
		panel.add(AccLogin);
		
		JLabel AccSignUp = new JLabel("Sign Up");
		AccSignUp.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new signUp().setVisible(true);
				dispose();
			}
			
		});
		AccSignUp.setForeground(Color.BLACK);
		AccSignUp.setFont(new Font("Bodoni MT Black", Font.PLAIN, 30));
		AccSignUp.setBackground(Color.GRAY);
		AccSignUp.setBounds(626, 122, 125, 39);
		panel.add(AccSignUp);
	}
}
