package ecommerce;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contactus extends JFrame {

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
	public Contactus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Image profile3=new ImageIcon(this.getClass().getResource("/ruchita.jpeg")).getImage();
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.ITALIC, 17));
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.setBounds(200, 389, 305, 54);
		btnNewButton.setOpaque(true);
		contentPane.add(btnNewButton);
		
		JLabel lblContactUs = new JLabel("                                                        CONTACT US");
		lblContactUs.setOpaque(true);
		lblContactUs.setForeground(new Color(255, 255, 204));
		lblContactUs.setFont(new Font("Dialog", Font.BOLD, 17));
		lblContactUs.setBackground(new Color(153, 204, 153));
		lblContactUs.setBounds(0, 0, 734, 43);
		contentPane.add(lblContactUs);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(" Address : Cummins College, Karve Road\nPune, Maharashtra\n\n\nPhone : 987654321 or 879654123\n\n\nEmail: msr@gmail.com");
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("Dialog", Font.PLAIN, 15));
		textPane.setBounds(35, 85, 670, 235);
		contentPane.add(textPane);
	}
}

