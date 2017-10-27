package ecommerce;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	public String name,email,username,street,city,state,password;
	int pincode,phone,ID;
	static int def = 0;
	public static int s;
	String str;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(def);
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
	public Home(int ID) {
		this.ID = ID;
		s = ID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 850, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("PROFILE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Edit_profile ed = new Edit_profile(s);
				ed.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Segoe Script", Font.BOLD, 14));
		btnNewButton.setBounds(0, 222, 205, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ORDERS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Order o = new Order(s);
				o.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(153, 50, 204));
		btnNewButton_1.setForeground(new Color(230, 230, 250));
		btnNewButton_1.setFont(new Font("Segoe Script", Font.BOLD, 14));
		btnNewButton_1.setBounds(202, 222, 205, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CART");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Cart c = new Cart(s);
				c.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(153, 50, 204));
		btnNewButton_2.setForeground(new Color(230, 230, 250));
		btnNewButton_2.setFont(new Font("Segoe Script", Font.BOLD, 14));
		btnNewButton_2.setBounds(407, 222, 214, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOGOUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thankyou for shopping with us! \nVisit us soon!" );
				setVisible(false);
				ProjectUI p = new ProjectUI();
				p.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(153, 50, 204));
		btnNewButton_3.setForeground(new Color(230, 230, 250));
		btnNewButton_3.setFont(new Font("Segoe Script", Font.BOLD, 14));
		btnNewButton_3.setBounds(620, 222, 214, 33);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/fruit_home.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(53, 308, 338, 201);
		contentPane.add(lblNewLabel);
		JLabel label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/vege_home.jpg")).getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(459, 308, 338, 201);
		contentPane.add(label);
		
		JButton btnNewButton_4 = new JButton("Shop Fruits >> ");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fruits f = new Fruits(s);
				setVisible(false);
				f.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(153, 50, 204));
		btnNewButton_4.setForeground(new Color(230, 230, 250));
		btnNewButton_4.setFont(new Font("Segoe Script", Font.BOLD, 16));
		btnNewButton_4.setBounds(0, 505, 407, 61);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Shop Vegetables >> ");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vegetables v = new Vegetables(s);
				setVisible(false);
				v.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(new Color(153, 50, 204));
		btnNewButton_5.setForeground(new Color(230, 230, 250));
		btnNewButton_5.setFont(new Font("Segoe Script", Font.BOLD, 16));
		btnNewButton_5.setBounds(407, 505, 417, 61);
		contentPane.add(btnNewButton_5);
		
		JLabel lblWelcome = new JLabel("Welcome back, "+getUsername());
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWelcome.setBounds(53, 277, 214, 33);
		contentPane.add(lblWelcome);
	    
		    JLabel logoLabel = new JLabel("");
		    logoLabel.setBackground(new Color(255, 255, 255));
			logoLabel.setBounds(202, 1, 462, 219);
			Image logo=new ImageIcon(this.getClass().getResource("/geo_logo-trans-411x207.png")).getImage();
			logoLabel.setIcon(new ImageIcon(logo));
			contentPane.add(logoLabel);
		
		JLabel lblAllRightsReserved = new JLabel("                                                                                                All rights Reserved at @ MSR developers 2017-2018");
		lblAllRightsReserved.setOpaque(true);
		lblAllRightsReserved.setBackground(new Color(255, 255, 204));
		lblAllRightsReserved.setBounds(0, 575, 834, 36);
		contentPane.add(lblAllRightsReserved);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		label_1.setBackground(new Color(255, 140, 0));
		label_1.setBounds(0, 1, 834, 219);
		contentPane.add(label_1);
	
		}
	String getUsername(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select username from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 str = rs.getString("username");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	}

