import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class hasierakoPanela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hasierakoPanela frame = new hasierakoPanela();
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
	public hasierakoPanela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Administratzailea");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Eras Bold ITC", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login_Admin login= new login_Admin();
				setVisible(false);
				login.setVisible(true);
				//login.main(null);
			}
		});
		btnNewButton.setBounds(29, 75, 137, 94);
		contentPane.add(btnNewButton);
		
		JButton btnErabiltzailea = new JButton("Erabiltzailea");
		btnErabiltzailea.setForeground(Color.WHITE);
		btnErabiltzailea.setBackground(Color.DARK_GRAY);
		btnErabiltzailea.setFont(new Font("Eras Bold ITC", Font.PLAIN, 11));
		btnErabiltzailea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnErabiltzailea.setBounds(266, 75, 137, 94);
		contentPane.add(btnErabiltzailea);
		
		JLabel lblNewLabel = new JLabel("Zer zara?");
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(173, 35, 166, 29);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
