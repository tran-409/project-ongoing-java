package bankingApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainMenu extends JFrame {

	static int MyAccNum;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu(MyAccNum);
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
	public mainMenu(int AccountNumber) {
		this.MyAccNum = AccountNumber;
		
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Account Number:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBackground(Color.GRAY);
		lblNewLabel_1_1_1.setBounds(183, 203, 199, 31);
		panel.add(lblNewLabel_1_1_1);
		
		JButton mainWithdraw = new JButton("Withdraw\r\n");
		
		mainWithdraw.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new Withdraw(AccountNumber).setVisible(true);
				dispose();
			}
		});
		
		
		mainWithdraw.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		mainWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mainWithdraw.setForeground(Color.BLACK);
		mainWithdraw.setBackground(Color.WHITE);
		mainWithdraw.setBounds(10, 271, 252, 65);
		panel.add(mainWithdraw);
		
		JButton AccDeposit = new JButton("Deposit");
		AccDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AccDeposit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new deposit(AccountNumber).setVisible(true);;
				dispose();
			}
			
		});
		AccDeposit.setForeground(Color.BLACK);
		AccDeposit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccDeposit.setBackground(Color.WHITE);
		AccDeposit.setBounds(555, 271, 256, 65);
		panel.add(AccDeposit);
		
		JButton AccFastCash = new JButton("Fast Cash");
		AccFastCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new fastCash(AccountNumber).setVisible(true);
				dispose();
			}
		});
		AccFastCash.setForeground(Color.BLACK);
		AccFastCash.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccFastCash.setBackground(Color.WHITE);
		AccFastCash.setBounds(10, 346, 252, 65);
		panel.add(AccFastCash);
		
		JButton AccStatement = new JButton("Statement");
		AccStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AccStatement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new statement(AccountNumber).setVisible(true);
				dispose();
			}
		});
		AccStatement.setForeground(Color.BLACK);
		AccStatement.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccStatement.setBackground(Color.WHITE);
		AccStatement.setBounds(555, 346, 256, 65);
		panel.add(AccStatement);
		
		JButton AccChangePin = new JButton("Change pin");
		AccChangePin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new changePin(AccountNumber).setVisible(true);;
				dispose();
			}
		});
		AccChangePin.setForeground(Color.BLACK);
		AccChangePin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccChangePin.setBackground(Color.WHITE);
		AccChangePin.setBounds(10, 421, 252, 65);
		panel.add(AccChangePin);
		
		JButton AccBalance = new JButton("Balance");
		AccBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Balance(AccountNumber).setVisible(true);;
				dispose();
			}
		});
		AccBalance.setForeground(Color.BLACK);
		AccBalance.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		AccBalance.setBackground(Color.WHITE);
		AccBalance.setBounds(555, 421, 256, 65);
		panel.add(AccBalance);
		
		JLabel lblNewLabel = new JLabel("Logout");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login();
				dispose();
			}
		});
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 34));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(355, 355, 116, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select your transaction:");
		lblNewLabel_1_1.setBounds(251, 141, 282, 31);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Berlin Sans FB Demi", Font.ITALIC, 27));
		lblNewLabel_1_1.setBackground(Color.GRAY);
		
		JLabel AccInitNum = new JLabel("New label");
		AccInitNum.setBackground(Color.GRAY);
		AccInitNum.setForeground(Color.BLACK);
		AccInitNum.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		AccInitNum.setBounds(387, 207, 107, 27);
		panel.add(AccInitNum);
		
		AccInitNum.setText(""+AccountNumber);
	}
	
}
