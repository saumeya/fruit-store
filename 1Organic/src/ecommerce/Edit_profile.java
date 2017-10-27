package ecommerce;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

// DB;

public class Edit_profile extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField phone;
	private JTextField city;
    private JTextField street;
    private JTextField stat;
    private JTextField pincode;
    static int def = 0;
    int ID;
    public static int s;
   String str;
    int n;
    private JTextField username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_profile frame = new Edit_profile(def);
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
	public Edit_profile(int ID) {
		this.ID = ID;
		s = ID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(72, 173, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(72, 226, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PHONE");
		lblNewLabel_2.setForeground(new Color(0, 0, 205));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(72, 332, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel j = new JLabel("STREET");
		j.setForeground(new Color(0, 0, 205));
		j.setFont(new Font("Dialog", Font.BOLD, 14));
		j.setBounds(392, 173, 71, 14);
		contentPane.add(j);
		
		JLabel lblNewLabel_3 = new JLabel("CITY");
		lblNewLabel_3.setForeground(new Color(0, 0, 205));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(392, 226, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setForeground(new Color(0, 0, 205));
		lblState.setFont(new Font("Dialog", Font.BOLD, 14));
		lblState.setBounds(392, 284, 46, 14);
		contentPane.add(lblState);
		
		JLabel lblPinCode = new JLabel("PIN CODE");
		lblPinCode.setForeground(new Color(0, 0, 205));
		lblPinCode.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPinCode.setBounds(392, 337, 71, 14);
		contentPane.add(lblPinCode);
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(230, 230, 250));
		btnNewButton_1.setBackground(new Color(153, 50, 204));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateUser();
				JOptionPane.showMessageDialog(null, "Profile Updated Successfully");
			Home h = new Home(s);
			h.setVisible(true);
			setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(182, 390, 135, 43);
		contentPane.add(btnNewButton_1);
		
		name = new JTextField(getNam());
		name.setBounds(184, 172, 149, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		email = new JTextField(getEmail());
		email.setBounds(184, 225, 149, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		phone = new JTextField(Integer.toString(getPhone()));
		phone.setBounds(184, 331, 149, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		city = new JTextField(getCity());
		city.setBounds(488, 223, 149, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		street = new JTextField(getStreet());
		street.setBounds(488, 170, 149, 20);
		contentPane.add(street);
		street.setColumns(10);
		
		stat = new JTextField(getStat());
		stat.setBounds(488, 281, 149, 20);
		contentPane.add(stat);
		stat.setColumns(10);
		
		pincode = new JTextField(Integer.toString(getPin()));
		pincode.setBounds(488, 334, 149, 20);
		contentPane.add(pincode);
		pincode.setColumns(10);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home h = new Home(s);
				h.setVisible(true);
			}
		});
		btnNewButton.setBounds(407, 390, 135, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblYourDetailsAt = new JLabel("                                Your Details at Green Earth Organics");
		lblYourDetailsAt.setOpaque(true);
		lblYourDetailsAt.setForeground(Color.WHITE);
		lblYourDetailsAt.setFont(new Font("Dialog", Font.BOLD, 20));
		lblYourDetailsAt.setBackground(new Color(255, 140, 0));
		lblYourDetailsAt.setBounds(0, 0, 734, 94);
		contentPane.add(lblYourDetailsAt);
		
		JLabel lblAllRightsReserved = new JLabel("                                                                                    All rights Reserved at @ MSR developers 2017-2018");
		lblAllRightsReserved.setOpaque(true);
		lblAllRightsReserved.setBackground(new Color(255, 255, 204));
		lblAllRightsReserved.setBounds(0, 475, 734, 36);
		contentPane.add(lblAllRightsReserved);
		
		username = new JTextField(getUsername());
		username.setBounds(182, 283, 149, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUserName.setForeground(new Color(0, 0, 205));
		lblUserName.setBounds(72, 284, 98, 14);
		contentPane.add(lblUserName);
		
	}

	public void updateUser()
	{
		 Connection con = (Connection) DB.getConnection();
			try {
				
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("update user set name=?,email=?,phone=?,city=?,street=?,state=?,pincode=?, username = ? where userID = ?");
			
			    ps.setString(1, name.getText());
				ps.setString(2,email.getText() );
				ps.setInt(3,Integer.parseInt(phone.getText()));
				
				ps.setString(4,city.getText());
				ps.setString(5,street.getText());
				ps.setString(6,stat.getText());
				ps.setInt(7,Integer.parseInt(pincode.getText()));
				ps.setString(8,username.getText());
				ps.setInt(9,ID);
			    ps.executeUpdate();
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	String getNam(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select name from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 str = rs.getString("name");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
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
	String getEmail(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select email from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 str = rs.getString("email");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	String getStreet(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select street from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 str = rs.getString("street");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	String getStat(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select state from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 str = rs.getString("state");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	String getCity(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select city from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 str = rs.getString("city");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	int getPhone(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select phone from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 n = rs.getInt("phone");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	int getPin(){
		Connection con = (Connection) DB.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select pincode from user where userID = ? ");
			 ps.setInt(1, ID);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 n = rs.getInt("pincode");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
}