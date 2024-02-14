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
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField AccountID;
	private JTextField AccFirstName;
	private JTextField AccLastName;
	private JTextField pinNum;
	private JTextField AccOccupation;
	private JTextField AccPhone;
	private JTextField AccDateOfBirth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
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
	public signUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 866, 607);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 873, 108);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Family Inc. Bank");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(292, 10, 277, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("In Family, We Trust.");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 24));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(526, 65, 214, 36);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Account ID:");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(48, 177, 138, 33);
		panel.add(lblNewLabel);
		
		JLabel lblCreateAnAccount = new JLabel("Create an account:");
		lblCreateAnAccount.setForeground(Color.BLACK);
		lblCreateAnAccount.setFont(new Font("Berlin Sans FB", Font.ITALIC, 40));
		lblCreateAnAccount.setBackground(Color.GRAY);
		lblCreateAnAccount.setBounds(269, 109, 346, 63);
		panel.add(lblCreateAnAccount);
		
		AccountID = new JTextField();
		AccountID.setBounds(185, 182, 206, 28);
		panel.add(AccountID);
		AccountID.setColumns(10);
		
		JLabel lblFirstAndLast = new JLabel("First Name:\r\n");
		lblFirstAndLast.setForeground(Color.BLACK);
		lblFirstAndLast.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblFirstAndLast.setBackground(Color.GRAY);
		lblFirstAndLast.setBounds(48, 232, 125, 41);
		panel.add(lblFirstAndLast);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblLastName.setBackground(Color.GRAY);
		lblLastName.setBounds(48, 291, 125, 33);
		panel.add(lblLastName);
		
		JLabel lblPin = new JLabel("Pin #:");
		lblPin.setForeground(Color.BLACK);
		lblPin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblPin.setBackground(Color.GRAY);
		lblPin.setBounds(539, 179, 71, 33);
		panel.add(lblPin);
		
		JLabel lblOccupation = new JLabel("Occupation:");
		lblOccupation.setForeground(Color.BLACK);
		lblOccupation.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblOccupation.setBackground(Color.GRAY);
		lblOccupation.setBounds(483, 236, 127, 33);
		panel.add(lblOccupation);
		
		JLabel lblPhone = new JLabel("Phone #:");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblPhone.setBackground(Color.GRAY);
		lblPhone.setBounds(511, 291, 110, 33);
		panel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAddress.setBackground(Color.GRAY);
		lblAddress.setBounds(10, 381, 99, 33);
		panel.add(lblAddress);
		
		JLabel lblDob = new JLabel("Date Of Birth:");
		lblDob.setForeground(Color.BLACK);
		lblDob.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblDob.setBackground(Color.GRAY);
		lblDob.setBounds(465, 348, 161, 33);
		panel.add(lblDob);
		
		AccFirstName = new JTextField();
		AccFirstName.setColumns(10);
		AccFirstName.setBounds(185, 236, 206, 28);
		panel.add(AccFirstName);
		
		AccLastName = new JTextField();
		AccLastName.setColumns(10);
		AccLastName.setBounds(185, 291, 206, 28);
		panel.add(AccLastName);
		
		JTextArea AccAddress = new JTextArea();
		AccAddress.setBounds(108, 390, 316, 145);
		panel.add(AccAddress);
		
		pinNum = new JTextField();
		pinNum.setColumns(10);
		pinNum.setBounds(620, 184, 206, 28);
		panel.add(pinNum);
		
		AccOccupation = new JTextField();
		AccOccupation.setColumns(10);
		AccOccupation.setBounds(620, 237, 206, 28);
		panel.add(AccOccupation);
		
		AccPhone = new JTextField();
		AccPhone.setColumns(10);
		AccPhone.setBounds(620, 296, 206, 28);
		panel.add(AccPhone);
		
		AccDateOfBirth = new JTextField();
		AccDateOfBirth.setColumns(10);
		AccDateOfBirth.setBounds(620, 353, 206, 28);
		panel.add(AccDateOfBirth);
		
		JButton signUpSubmit = new JButton("Submit");
		signUpSubmit.addMouseListener(new MouseAdapter() {
			
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet Rs = null;
			Statement st = null;
			
			private void clear() {
				AccountID.setText("");
				AccFirstName.setText("");
				AccLastName.setText("");
				AccAddress.setText("");
				AccPhone.setText("");
				pinNum.setText("");
				AccOccupation.setText("");
				AccDateOfBirth.setText("");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent event) {
				if(AccountID.getText().isEmpty() || 
						AccFirstName.getText().isEmpty() || 
						AccLastName.getText().isEmpty() ||
						AccAddress.getText().isEmpty() ||
						AccOccupation.getText().isEmpty() ||
						AccPhone.getText().isEmpty() ||
						pinNum.getText().isEmpty()
						) {
					JOptionPane.showMessageDialog(null, "Please fill out all the required fields.", "Error", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
						PreparedStatement add = con.prepareStatement("insert into newusers values(?,?,?,?,?,?,?,?,?)");
						add.setInt(1, Integer.valueOf(AccountID.getText()));
						add.setString(2, AccFirstName.getText());
						add.setString(3, AccLastName.getText());
						add.setString(4, AccAddress.getText());
						add.setString(5, AccPhone.getText());
						add.setInt(6, Integer.valueOf(pinNum.getText()));
						add.setString(7, AccOccupation.getText());
						add.setString(8, AccDateOfBirth.getText());
						add.setInt(9, 0);
					
						int row = add.executeUpdate();
						JOptionPane.showMessageDialog(null, "Account saved", "Account creation", JOptionPane.PLAIN_MESSAGE);
						con.close();
						clear();
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
			}
		});
		signUpSubmit.setForeground(Color.BLACK);
		signUpSubmit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		signUpSubmit.setBackground(Color.WHITE);
		signUpSubmit.setBounds(579, 467, 119, 37);
		panel.add(signUpSubmit);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblBack.setBackground(Color.GRAY);
		lblBack.setBounds(601, 523, 73, 39);
		panel.add(lblBack);
	}
}
