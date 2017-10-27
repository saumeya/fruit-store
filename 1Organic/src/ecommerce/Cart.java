package ecommerce;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cart extends JFrame {

	Connection con;
	private JPanel contentPane;
	public ListSelectionModel model;
    private JTable table;
    private JScrollPane scrollPane;
    int Total;
    double Tax,Net;
    private JLabel lblAllRightsReserved;
    private JLabel label;
    static int def = 0;
    int ID;
    public static int s;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart(def);
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
	public Cart(int ID) {
		this.ID = ID;
		s = ID;
		con = DB.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Order Placed successfully!!");
				setVisible(true);
				Connection con = DB.getConnection();
                PreparedStatement ps;
				try {
					PreparedStatement ps1 = con.prepareStatement("select * from cart where userid=?");
					ps1.setInt(1, s);
					ResultSet rs=ps1.executeQuery();
				
					ps = con.prepareStatement("delete from cart where userid =?");
				    ps.setInt(1, s);
	                ps.executeUpdate();
	                
	                PreparedStatement ps11=null;
					
					while(rs.next())
					{

						ps11 = con.prepareStatement("insert into orders(Item, Unit, Quantity, Total,userID) values (?,?,?,?,?)");
						ps11.setString(1, rs.getString("Item"));
						ps11.setInt(2, rs.getInt("Unit"));
						ps11.setInt(3, rs.getInt("Quantity"));
						ps11.setInt(4,rs.getInt("Total"));
						ps11.setInt(5, s);
						ps11.executeUpdate();
					
					}
					
				
            
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Order o = new Order(s);
				o.setVisible(true);
			}
		});
		btnBuy.setBounds(463, 416, 105, 36);
		contentPane.add(btnBuy);
		
		JLabel lblNewLabel = new JLabel("Tax");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(483, 331, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Net");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(483, 367, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		   JLabel logoLabel = new JLabel("");
		    logoLabel.setBackground(new Color(255, 255, 255));
			logoLabel.setBounds(139, 0, 462, 219);
			Image logo=new ImageIcon(this.getClass().getResource("/geo_logo-trans-411x207.png")).getImage();
			logoLabel.setIcon(new ImageIcon(logo));
			contentPane.add(logoLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setForeground(new Color(0, 0, 205));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(483, 293, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 258, 324, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(128, 128, 128)));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		scrollPane.setViewportView(table);
		
		lblAllRightsReserved = new JLabel("                                                                                           All rights Reserved at @ MSR developers 2017-2018");
		lblAllRightsReserved.setOpaque(true);
		lblAllRightsReserved.setBackground(new Color(255, 255, 204));
		lblAllRightsReserved.setBounds(0, 475, 734, 36);
		contentPane.add(lblAllRightsReserved);
		
		label = new JLabel("");
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		label.setBackground(new Color(255, 140, 0));
		label.setBounds(0, 0, 734, 219);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home h = new Home(s);
				h.setVisible(true);
			}
		});
		btnNewButton.setBounds(600, 416, 105, 36);
		contentPane.add(btnNewButton);
		
		JLabel total = new JLabel(Integer.toString(getTotal()));
		total.setBounds(590, 295, 46, 14);
		contentPane.add(total);
		
		JLabel tax = new JLabel(Double.toString(getTax()));
		tax.setBounds(590, 333, 46, 14);
		contentPane.add(tax);
		
		JLabel net = new JLabel(Double.toString(getNet()));
		net.setBounds(590, 369, 46, 14);
		contentPane.add(net);
		
		JButton btnNewButton_1 = new JButton("FRUITS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Fruits f = new Fruits(s);
				f.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(492, 218, 111, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home h = new Home(s);
				h.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(374, 218, 119, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VEGETABLES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Vegetables v = new Vegetables(s);
				v.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(600, 218, 134, 34);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("                    ITEMS IN YOUR CART");
		lblNewLabel_3.setForeground(new Color(0, 0, 205));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(25, 235, 324, 14);
		contentPane.add(lblNewLabel_3);
		createTable();
		
		
		model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(!model.isSelectionEmpty()){
		    int action = JOptionPane.showConfirmDialog(null, "Do you want to delete this item from cart ?","Delete",JOptionPane.YES_NO_OPTION);
			if(action==0){
					delRecord();
						}
				}
			}
		});
	
	}
	void delRecord(){
		int row = model.getMinSelectionIndex();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		String selected = model.getValueAt(row, 0).toString();
		model.removeRow(row);
		               
		                try {
		                	 Connection con = DB.getConnection();
		                    PreparedStatement ps = con.prepareStatement("delete from cart where Sr ='"+selected+"' ");
		                    ps.executeUpdate();
		                
		                }
		                catch (SQLException w) {
		        			// TODO Auto-generated catch block
		        			w.printStackTrace();
		                }
		                setVisible(false);
		                Cart c = new Cart(s);
		                c.setVisible(true);
	}
	void createTable(){
		try {
			PreparedStatement ps = con.prepareStatement("select Sr,Item,Unit,Quantity,Total,remove from cart where userID=?");
			ps.setInt(1, s);
			ResultSet rs=ps.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 con.close();
			
			} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	
	
	double getTax(){
		Tax = 0.15 * Total;
		return Tax;
	}
	int getTotal(){
		Connection con =  DB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select sum(Total) from cart where userID=?");
			ps.setInt(1, s);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 Total = rs.getInt("sum(Total)");
			 con.close();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Total;
	}
	double getNet(){
		Net = Tax + Total;
		return Net;
	}
}
