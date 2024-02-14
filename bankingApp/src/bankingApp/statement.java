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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class statement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static int myAccID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statement frame = new statement(myAccID);
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
	
	private void displayTransaction() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root", "Wassup30#");
			st = con.createStatement();
			Rs = st.executeQuery("select * from transaction where accountID="+myAccID+"");
			table.setModel(DbUtils.resultSetToTableModel(Rs));
		}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public statement(int AccountID) {
		this.myAccID = AccountID;
		displayTransaction();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 821, 642);
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mini Statement:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 35));
		lblNewLabel_1_1_1.setBackground(Color.GRAY);
		lblNewLabel_1_1_1.setBounds(279, 146, 266, 44);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Logout");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 34));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(695, 132, 116, 44);
		panel.add(lblNewLabel);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new mainMenu(AccountID).setVisible(true);
				dispose();
			}
		});
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblBack.setBackground(Color.GRAY);
		lblBack.setBounds(382, 576, 73, 39);
		panel.add(lblBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 220, 712, 332);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				
			},
			new String[] {
				"transactionID", "accountID", "transactionType", "transactionDate"
			}
		));
	}
}
