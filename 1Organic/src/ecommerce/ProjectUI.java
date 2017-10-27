package ecommerce;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ProjectUI {

	public JFrame frame;
      JPanel registerPanel;
	protected int String;
      
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectUI window = new ProjectUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		frame.setBounds(10, 10, 850, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane();
		
	    JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(213, 46, 475, 219);
		Image logo=new ImageIcon(this.getClass().getResource("/geo_logo-trans-411x207.png")).getImage();
		logoLabel.setIcon(new ImageIcon(logo));
		frame.getContentPane().add(logoLabel);
		
		JLabel lblNewLabel_4 = new JLabel("      Making  Life Easier   Now Shop Here ...                    @MSR");
		lblNewLabel_4.setForeground(new Color(65, 105, 225));
		lblNewLabel_4.setBackground(new Color(255, 165, 0));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(0, 588, 834, 23);
		lblNewLabel_4.setOpaque(true);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 42, 834, 223);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(255, 140, 0));
		lblNewLabel_1.setOpaque(true);
		
		JButton aboutusButton = new JButton("About Us");
		aboutusButton.setFont(new Font("Sitka Text", Font.BOLD, 16));
		aboutusButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Aboutus a=new Aboutus();
						a.setVisible(true);
					}
				});
		aboutusButton.setBounds(256, -1, 140, 44);
		frame.getContentPane().add(aboutusButton);
		aboutusButton.setBackground(Color.WHITE);
		aboutusButton.setOpaque(true);
		
		JButton Btnregister = new JButton(" REGISTER");
		Btnregister.setBounds(394, -1, 148, 44);
		frame.getContentPane().add(Btnregister);
		Btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				UserRegistration userreg=new UserRegistration();
				userreg.setVisible(true);
	
			}
		});
		
		Btnregister.setForeground(Color.BLACK);
		Btnregister.setFont(new Font("Dialog", Font.BOLD, 16));
		Btnregister.setBackground(Color.WHITE);
		Btnregister.setOpaque(true);
		
		JButton btnNewButton_1 = new JButton("  LOGIN");
		btnNewButton_1.setBounds(540, -1, 148, 44);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Loginuser luser=new Loginuser();
				luser.setVisible(true);
	
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setOpaque(true);
		
		JButton btnNewButton = new JButton("Contact Us");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contactus c = new Contactus();
				c.setVisible(true);
			}
		});
		btnNewButton.setBounds(125, -1, 133, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton faqButton = new JButton("   FAQ");
		faqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAQpage faq=new FAQpage();
				faq.setVisible(true);
			}
		});
		faqButton .setBackground(Color.WHITE);
		faqButton .setFont(new Font("Dialog", Font.BOLD, 16));
		faqButton .setBounds(0, 0, 133, 43);
		faqButton .setOpaque(true);
		frame.getContentPane().add(faqButton );
		/********************************************************************/
		 
		final JTextPane jtp = new JTextPane();
		 jtp.setSize(new Dimension(480, 110));
		    jtp.setPreferredSize(new Dimension(480,110));
		
		
		
		final JToggleButton enquiryToggleButton = new JToggleButton("Enquiry");
		enquiryToggleButton.setForeground(Color.BLACK);
		enquiryToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, jtp, "Feel free to write your complaints or feedbacks", JOptionPane.INFORMATION_MESSAGE);
				//JOptionPane.showInputDialog(enquiryToggleButton, "", "",String);
				
				
			JOptionPane.showConfirmDialog(enquiryToggleButton, "Our team working on your enquiry.\n Stay with us ");
			}
		});
		enquiryToggleButton.setBackground(Color.WHITE);
		enquiryToggleButton.setOpaque(true);
		enquiryToggleButton.setFont(new Font("Dialog", Font.BOLD, 16));
		enquiryToggleButton.setBounds(686, -1, 148, 44);
		frame.getContentPane().add(enquiryToggleButton);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Register or Login to begin shopping ");
			}
		});
		Image i1 = new ImageIcon(this.getClass().getResource("/uipage2.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(i1));
		lblNewLabel.setBounds(415, 276, 309, 161);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Register or Login to begin shopping  ");
			}
		});
		Image i2 = new ImageIcon(this.getClass().getResource("/vege_home.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(i2));
		lblNewLabel_2.setBounds(136, 276, 280, 161);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image i3 = new ImageIcon(this.getClass().getResource("/fruit_home.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(i3));
		lblNewLabel_3.setBounds(416, 437, 318, 142);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image i = new ImageIcon(this.getClass().getResource("/3063.jpg")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(i));
		lblNewLabel_5.setBounds(136, 437, 280, 150);
		frame.getContentPane().add(lblNewLabel_5);
		
	
	
	}
}
