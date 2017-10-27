package ecommerce;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*;
import java.io.*;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JList;

public class UserRegistration extends JFrame {

	private JPanel contentPane;
	String name,email,username,street,city,state,password;
	int pincode,phone;
	Operations op = new Operations();
	
	

	/**
	 * Launch the application.
	 */
	//public static String url="jdbc:mysql://localhost/b30";
		static String user="root";
		static String pass="root";
		public  JTextField TFname;
		public JTextField TF ;
	
		private JLabel nameLabel;
		private JLabel emailLabel;
		private JLabel phoneLabel;
		private JLabel usernameLabel;
		private JLabel passwordLabel;
		private JLabel streetLabel;
		private JLabel cityLabel;
		private JLabel stateLabel;
		private JLabel pincodeLabel;
		
		
		
		private JTextField nameTF;
		private JTextField emailTF;
		private JTextField phoneTF;
		private JTextField usernameTF;
		private JPasswordField passwordField;	
		private JTextField streetTF;
		private JTextField cityTF;
		private JTextField stateTF;
		private JTextField  pincodeTF;
		private JLabel lblNewLabel;
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
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
	public UserRegistration() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel reglabel = new JLabel("              Registration Form ");
		reglabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 27));
		reglabel.setForeground(new Color(255, 255, 255));
		reglabel.setBackground(new Color(255, 140, 0));
		reglabel.setOpaque(true);
		reglabel.setBounds(0, 0, 534, 63);
		contentPane.add(reglabel);
		
		JButton btnNewButton = new JButton("Register ");
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.setForeground(new Color(255, 255, 204));
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				name=nameTF.getText();
				email=emailTF.getText();
			    phone=Integer.parseInt(phoneTF.getText());
				username=usernameTF.getText();
				street=streetTF.getText();
				password=String.valueOf(passwordField.getPassword());
				city=cityTF.getText();				
				state=stateTF.getText();
				pincode=Integer.parseInt(pincodeTF.getText());
				User u = new User(phone, name, email,street,city, password, pincode,state, username);
				
				op.register(u);
				JOptionPane.showMessageDialog(null, "Registration done successfully"
						+ "\n\nPlease Login to continue shopping");
				setVisible(false);
				ProjectUI pi=new ProjectUI();
				pi.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(167, 525, 213, 63);
		contentPane.add(btnNewButton);
		
		
		nameLabel = new JLabel("   Name ");
		nameLabel.setBackground(new Color(255, 255, 255));
		nameLabel.setForeground(new Color(51, 0, 204));
		nameLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		nameLabel.setBounds(85, 74, 119, 31);
		nameLabel.setOpaque(true);
		contentPane.add(nameLabel);
		
	
		emailLabel = new JLabel(" Email   ");
		emailLabel.setBackground(new Color(255, 255, 255));
		emailLabel.setForeground(new Color(51, 0, 204));
		emailLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		emailLabel.setBounds(95, 116, 119, 38);
		emailLabel.setOpaque(true);
		contentPane.add(emailLabel);

	    phoneLabel = new JLabel("   Phone");
	    phoneLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
	    phoneLabel.setForeground(new Color(51, 0, 204));
		phoneLabel.setBounds(85, 165, 99, 40);
		contentPane.add(phoneLabel);
	
		usernameLabel = new JLabel(" UserName");
		usernameLabel .setForeground(new Color(51, 0, 204));
		usernameLabel .setFont(new Font("Sitka Text", Font.BOLD, 20));
		usernameLabel .setBounds(95, 216, 119, 38);
		contentPane.add(usernameLabel );
		
		passwordLabel = new JLabel(" Password ");
		passwordLabel.setForeground(new Color(51, 0, 204));
		passwordLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		passwordLabel.setBounds(95, 270, 119, 38);
		contentPane.add(passwordLabel);
		
		streetLabel = new JLabel("   Street");
		streetLabel.setForeground(new Color(51, 0, 204));
		streetLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		streetLabel.setBounds(85, 319, 119,38);
		contentPane.add(streetLabel);
		
		cityLabel = new JLabel("   City ");
		cityLabel.setForeground(new Color(51, 0, 204));
		cityLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		cityLabel.setBounds(85, 368, 119,38);
		contentPane.add(cityLabel);
		
		stateLabel = new JLabel("   State");
		stateLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		stateLabel.setForeground(new Color(51, 0, 204));
		stateLabel.setBounds(85, 417, 119,38);
		contentPane.add(stateLabel);
		
		pincodeLabel = new JLabel("   Pincode ");
		pincodeLabel.setForeground(new Color(51, 0, 204));
		pincodeLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		pincodeLabel.setBounds(85, 466, 119,38);
		contentPane.add(pincodeLabel);
		
		
		JLabel footer;
		footer = new JLabel("                                All rights Reserved at @ MSR developers 2017-2018");
		footer.setBackground(new Color(255, 255, 204));
		footer.setOpaque(true);
		footer.setBounds(0, 640, 576, 31);
	
		contentPane.add(footer);
		
		//=========================JTEXT FIELD ===========================================
		
		nameTF = new JTextField();
		nameTF.setBounds(256, 74, 164, 31);
		contentPane.add(nameTF);
		nameTF.setColumns(10);

		emailTF = new JTextField();
		emailTF.setBounds(256, 123, 164, 31);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		phoneTF= new JTextField();
		phoneTF.setForeground(new Color(0, 0, 0));
		phoneTF.setBackground(new Color(255, 255, 255));
		phoneTF.setBounds(256, 170, 164, 32);
		contentPane.add(phoneTF);
		phoneTF.setColumns(10);
		
		usernameTF= new JTextField();
		usernameTF.setBounds(256, 221, 164, 36);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(256, 272, 164, 31);
		contentPane.add(passwordField);
		
		streetTF = new JTextField();
		streetTF.setBounds(256, 321, 164, 31);
		contentPane.add(streetTF);
		streetTF.setColumns(10);
		
		cityTF = new JTextField();
		cityTF.setBounds(256, 368, 164, 36);
		contentPane.add(cityTF);
		cityTF.setColumns(10);
		
		stateTF = new JTextField();
		stateTF.setBounds(256, 417, 164, 38);
		contentPane.add(stateTF);
		stateTF.setColumns(10);
		
		pincodeTF= new JTextField();
		pincodeTF.setBounds(256, 466, 164, 38);
		contentPane.add(	pincodeTF);
		pincodeTF.setColumns(10);

	}
}
