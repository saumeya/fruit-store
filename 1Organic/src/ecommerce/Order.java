package ecommerce;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order extends JFrame {

	private JPanel contentPane;
	private JTable table;
	 static int def = 0;
	    int ID;
	    public static int s;
	    Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order(s);
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
	public Order(int ID) {
		this.ID = ID;
		s = ID;
		con = DB.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoLabel = new JLabel("");
		    logoLabel.setBackground(new Color(255, 255, 255));
			logoLabel.setBounds(140, 0, 462, 219);
			Image logo=new ImageIcon(this.getClass().getResource("/geo_logo-trans-411x207.png")).getImage();
			logoLabel.setIcon(new ImageIcon(logo));
			contentPane.add(logoLabel);
			
			JLabel label = new JLabel("");
			label.setOpaque(true);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
			label.setBackground(new Color(255, 140, 0));
			label.setBounds(0, 0, 734, 219);
			contentPane.add(label);
			
			JLabel label_1 = new JLabel("                                                                                           All rights Reserved at @ MSR developers 2017-2018");
			label_1.setOpaque(true);
			label_1.setBackground(new Color(255, 255, 204));
			label_1.setBounds(0, 475, 734, 36);
			contentPane.add(label_1);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(140, 255, 519, 183);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("HOME");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home h = new Home(s);
					h.setVisible(true);
				}
			});
			btnNewButton.setBounds(0, 219, 142, 33);
			contentPane.add(btnNewButton);
			
			JLabel lblYourOrders = new JLabel("YOUR ORDERS");
			lblYourOrders.setBounds(335, 230, 111, 14);
			contentPane.add(lblYourOrders);
			
			JLabel lblThankYouFor = new JLabel("THANK YOU FOR SHOPPING WITH US");
			lblThankYouFor.setBounds(280, 450, 259, 14);
			contentPane.add(lblThankYouFor);
			createTable();
	}
	void createTable(){
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select Sr,Item,Unit, Quantity,Total,Date from orders where userID=?");
			ps.setInt(1, s);
			ResultSet rs=ps.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 con.close();
			
			} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}
