package ecommerce;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Loginuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	String username,password;
	Operations op = new Operations();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginuser frame = new Loginuser();
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
	public Loginuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("                                          LOGIN FORM ");
		lblNewLabel.setBackground(new Color(255, 140, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 534, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username ");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(38, 142, 162, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password ");
		lblNewLabel_2.setForeground(new Color(0, 0, 205));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(38, 224, 162, 36);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(245, 142, 204, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBackground(new Color(153, 50, 204));
		loginButton.setOpaque(true);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username=textField.getText();
				password=String.valueOf(passwordField.getPassword());
				int check = op.verify(username,password);
				if(check>0){
					JOptionPane.showMessageDialog(null, "Username and Password are correct");
					setVisible(false);
					Home h = new Home(check);
					h.setVisible(true);
					}
				else{
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password\n\nPlease Try Again ");
					setVisible(false);
					ProjectUI p = new ProjectUI();
					p.frame.setVisible(true);
				}
				}
		});
		loginButton.setBounds(197, 317, 142, 49);
		contentPane.add(loginButton);
		
		JButton btnNewButton_1 = new JButton("Create new user ?");
		btnNewButton_1.setBackground(new Color(51, 204, 102));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UserRegistration ui1=new UserRegistration();
				ui1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(89, 441, 343, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel footer = new JLabel("               All rights Reserved at @ MSR developers 2017-2018");
		footer.setBackground(new Color(255, 255, 204));
		footer.setOpaque(true);
		footer.setBounds(0, 475, 534, 36);
		contentPane.add(footer);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(245, 224, 204, 36);
		contentPane.add(passwordField);
	}
	
}
