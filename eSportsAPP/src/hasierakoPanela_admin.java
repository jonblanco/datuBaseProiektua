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
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class hasierakoPanela_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hasierakoPanela_admin frame = new hasierakoPanela_admin();
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
	public hasierakoPanela_admin() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnNewButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

			}
		});
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnNewButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,0),4));
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(hasierakoPanela_admin.class.getResource("/images/icons8_Maintenance_96px.png")));
		btnNewButton.setForeground(new Color(255, 102, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eragiketakAdmin eAdmin= eragiketakAdmin.getNireEragiketakAdmin();
				setVisible(false);
				eAdmin.setVisible(true);
				//login.main(null);
			}
		});
		btnNewButton.setBounds(29, 75, 137, 94);
		contentPane.add(btnNewButton);
		
		JButton btnErabiltzailea = new JButton("");
		btnErabiltzailea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnErabiltzailea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

			}
		});
		btnErabiltzailea.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnErabiltzailea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,0),4));

			}
		});
		btnErabiltzailea.setBorder(null);
		btnErabiltzailea.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea.setIcon(new ImageIcon(hasierakoPanela_admin.class.getResource("/images/icons8_User_96px_2.png")));
		btnErabiltzailea.setForeground(new Color(255, 102, 0));
		btnErabiltzailea.setBackground(Color.WHITE);
		btnErabiltzailea.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eragiketakUser eUserAdmin= new eragiketakUser();
				eUserAdmin.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnErabiltzailea.setBounds(271, 75, 137, 94);
		contentPane.add(btnErabiltzailea);
		
		JLabel lblNewLabel = new JLabel("Zer zara?");
		lblNewLabel.setForeground(new Color(255, 102, 0));
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblNewLabel.setBounds(173, 35, 166, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Administratzailea");
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 180, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Erabiltzailea");
		lblNewLabel_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(296, 180, 128, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ongiEtorriPanel oE = new ongiEtorriPanel();
				oE.setVisible(true);
				setVisible(false);
				eragiketakAdmin.getNireEragiketakAdmin().setSesioa(false); 
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(hasierakoPanela_admin.class.getResource("/images/on-off-button.png")));
		btnNewButton_1.setForeground(new Color(255, 102, 0));
		btnNewButton_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 10));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(187, 180, 61, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Saioa itxi");
		lblNewLabel_1_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(187, 236, 128, 14);
		contentPane.add(lblNewLabel_1_1_1);
		setLocationRelativeTo(null);
	}
}
