package ecommerce;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fruits extends JFrame {

	private JPanel contentPane;
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
					Fruits frmOnlineStore = new Fruits(def);
					frmOnlineStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fruits(int ID) {
		this.ID = ID;
		s = ID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1159, 700);
		contentPane = new FruitPanel(s,this);
		setContentPane(contentPane);
		setVisible(true);
		
		} 
	
	

}

class FruitPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public FruitPanel(final int s, final JFrame frame) {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		setBounds(100,10,750,700);
		ResultSet rs;
		String query;

		Connection con =DB.getConnection();
		try {
			Statement stmt=con.createStatement();

			query= "select count(*) from fruits";

			rs = stmt.executeQuery(query);

			rs.next();
			int count=rs.getInt(1);

			query= "select * from fruits";

			rs = stmt.executeQuery(query);

			//*******************Page Initialization********************************************************

			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setLayout(new GridLayout(count/2+1, 2, 80, 30));
			JScrollPane js = new JScrollPane(panel);
			js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			add(js, BorderLayout.CENTER);


			JPanel panel_8 = new JPanel();
			panel_8.setBackground(new Color(255, 255, 255));
			add(panel_8, BorderLayout.NORTH);
			panel_8.setLayout(new BorderLayout(0, 0));

			JButton btnNewButton = new JButton("");
			btnNewButton.setBackground(new Color(255, 140, 0));
			btnNewButton.setIcon(new ImageIcon("./img/geo_logo-trans-411x207.png"));
			panel_8.add(btnNewButton, BorderLayout.NORTH);
			
			JPanel panel_81 = new JPanel();
			panel_81.setBackground(new Color(255, 255, 255));
			panel_8.add(panel_81, BorderLayout.EAST);
			panel_81.setLayout(new BorderLayout(0, 0));

			JLabel lblNewLabel_4 = new JLabel("Fruits");
			lblNewLabel_4.setBackground(new Color(255, 255, 255));
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
			panel_8.add(lblNewLabel_4, BorderLayout.WEST);
			
			JButton btnNewButton1 = new JButton("Home");
			btnNewButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					frame.setVisible(false);
					Home home = new Home(s);
					home.setVisible(true);
				}
			});
			btnNewButton1.setBackground(new Color(153, 50, 204));
			btnNewButton1.setForeground(new Color(230, 230, 250));
			panel_81.add(btnNewButton1, BorderLayout.WEST);
			
			JButton btnNewButton11 = new JButton("Vegetables");
			btnNewButton11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					Vegetables v = new Vegetables(s);
					v.setVisible(true);
				}
			});
			btnNewButton11.setBackground(new Color(153, 50, 204));
			btnNewButton11.setForeground(new Color(230, 230, 250));
			panel_81.add(btnNewButton11, BorderLayout.EAST);

			//***********************Setting values according to DB***********************************************		

			while(rs.next())
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(255, 255, 255));
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));

				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBackground(new Color(255, 255, 255));
				lblNewLabel.setIcon(new ImageIcon(rs.getString("image")));
				panel_1.add(lblNewLabel, BorderLayout.WEST);

				JPanel panel_5 = new JPanel();
				panel_5.setBackground(new Color(255, 255, 255));
				panel_1.add(panel_5, BorderLayout.CENTER);
				panel_5.setLayout(new GridLayout(4, 1, 10, 10));

				JPanel panel_9 = new JPanel();
				panel_9.setBackground(new Color(255, 255, 255));
				panel_5.add(panel_9);

				final JLabel lblApple = new JLabel(rs.getString("name"));
				lblApple.setFont(new Font("Tahoma", Font.BOLD, 18));
				panel_9.add(lblApple);

				JPanel panel_10 = new JPanel();
				panel_10.setBackground(new Color(255, 255, 255));
				panel_5.add(panel_10);

				JLabel lblRs = new JLabel("Rs.");
				lblRs.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_10.add(lblRs);

				final JLabel label = new JLabel(rs.getString("cost"));
				label.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel_10.add(label);

				JPanel panel_6 = new JPanel();
				panel_6.setBackground(new Color(255, 255, 255));
				panel_5.add(panel_6);

				JLabel lblNewLabel_7 = new JLabel("Quantity");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel_6.add(lblNewLabel_7);

				final JSpinner spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
				panel_6.add(spinner);

				JPanel panel_7 = new JPanel();
				panel_7.setBackground(new Color(255, 255, 255));
				panel_5.add(panel_7);

				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setIcon(new ImageIcon("./img/addtocart.jpg"));
				btnNewButton_1.setBackground(new Color(255, 165, 0));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null, "Successfully Added");;
						int quantity=(int) spinner.getValue();
						String fruit_name=lblApple.getText();
						int cost=Integer.parseInt(label.getText());
						Connection con = DB.getConnection();
						try {
							PreparedStatement pre_stmt = con.prepareStatement("insert into  cart (Item, Unit, Quantity, Total, userID) values (?,?,?,?,?)");
							pre_stmt.setString(1, fruit_name);
							pre_stmt.setInt(2, cost);
							pre_stmt.setInt(3, quantity);
							pre_stmt.setInt(4,(cost*quantity));
							pre_stmt.setInt(5, s);
							pre_stmt.execute();
							con.close();
						}
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				panel_7.add(btnNewButton_1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//***********************************************************************************************************************************

	}

}
