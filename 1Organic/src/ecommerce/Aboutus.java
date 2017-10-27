package ecommerce;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Aboutus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contactus frame = new Contactus();
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
	public Aboutus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		Image i2=new ImageIcon(this.getClass().getResource("/manali.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(i2));
		lblNewLabel.setBounds(10, 43, 245, 301);
		//lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image i=new ImageIcon(this.getClass().getResource("/saumeya22.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(i));
		lblNewLabel_1.setBounds(270, 43, 204, 238);
		contentPane.add(lblNewLabel_1);
		
		JLabel ruchitaLabel = new JLabel("");
		Image profile3=new ImageIcon(this.getClass().getResource("/ruchita.jpeg")).getImage();
		ruchitaLabel.setIcon(new ImageIcon(profile3));
		ruchitaLabel.setBounds(474, 43, 250, 301);
		contentPane.add(ruchitaLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.ITALIC, 17));
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.setBounds(251, 446, 257, 54);
		btnNewButton.setOpaque(true);
		contentPane.add(btnNewButton);
		
		JLabel lblAboutUs = new JLabel("                                                                  ABOUT US");
		lblAboutUs.setOpaque(true);
		lblAboutUs.setForeground(new Color(255, 255, 204));
		lblAboutUs.setFont(new Font("Dialog", Font.BOLD, 17));
		lblAboutUs.setBackground(new Color(153, 204, 153));
		lblAboutUs.setBounds(0, 0, 734, 43);
		contentPane.add(lblAboutUs);
		
		JLabel lblManaliKale = new JLabel("MANALI KALE       3424");
		lblManaliKale.setBounds(51, 370, 134, 14);
		contentPane.add(lblManaliKale);
		
		JLabel lblSaumeyaKatyal = new JLabel("SAUMEYA KATYAL   3428");
		lblSaumeyaKatyal.setBounds(281, 370, 163, 14);
		contentPane.add(lblSaumeyaKatyal);
		
		JLabel lblRuchitaKshirsagar = new JLabel("RUCHITA KSHIRSAGAR    3430");
		lblRuchitaKshirsagar.setBounds(474, 370, 213, 14);
		contentPane.add(lblRuchitaKshirsagar);
	}
}

