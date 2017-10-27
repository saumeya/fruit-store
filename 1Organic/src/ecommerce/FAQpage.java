package ecommerce;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;

public class FAQpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQpage frame = new FAQpage();
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
	public FAQpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton(" OK ");
		tglbtnNewToggleButton.setForeground(new Color(255, 255, 255));
		tglbtnNewToggleButton.setFont(new Font("Sitka Text", Font.BOLD, 15));
		tglbtnNewToggleButton.setBackground(new Color(153, 50, 204));
		tglbtnNewToggleButton.setOpaque(true);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		tglbtnNewToggleButton.setBounds(259, 442, 158, 43);
		contentPane.add(tglbtnNewToggleButton);
		
		JTextPane txtpnAnyExtra = new JTextPane();
		txtpnAnyExtra.setForeground(Color.BLACK);
		txtpnAnyExtra.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnAnyExtra.setText(" 1. Any Extra charge on Delivery ?\r\n=>No, we deliver goods free of cost. Enjoy Free home delivery with us .\r\n\r\n2.What is payment method?\r\n=>Presently only Cash on delivery is available. \r\n\r\n3.Rturns Policy?\r\n=>We strive to deliver the best quality products,However if goods delivered to you are not good quality easy return or refund option is available.");
		txtpnAnyExtra.setBounds(27, 47, 670, 391);
		contentPane.add(txtpnAnyExtra);
		
		JLabel lblNewLabel = new JLabel("                                                                     FAQ");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(153, 204, 153));
		lblNewLabel.setBounds(0, 0, 734, 43);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		Component g1 = null;
		
	}
}

