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

public class eragiketakAdmin extends JFrame {

	private JPanel contentPane;
	private boolean sesioaStatus;
	private static eragiketakAdmin nEragiketakAdmin;
	private JLabel lblNewLabel_1_2_1;
	private JLabel lblNewLabel_1_5_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eragiketakAdmin frame = new eragiketakAdmin();
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
	private eragiketakAdmin() {
		setTitle("Administratzaile aukerak");
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 489);
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
		btnNewButton.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/icons8_Today_96px.png")));
		btnNewButton.setForeground(new Color(255, 102, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bideojokoakGehituKendu bGK= new bideojokoakGehituKendu();
				setVisible(false);
				bGK.setVisible(true);
			}
		});
		btnNewButton.setBounds(73, 119, 106, 97);
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
		btnErabiltzailea.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/icons8_User_96px_2.png")));
		btnErabiltzailea.setForeground(new Color(255, 102, 0));
		btnErabiltzailea.setBackground(Color.WHITE);
		btnErabiltzailea.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JokalariaGehitu jG= JokalariaGehitu.getNireJokalariaGehitu();
				jG.setVisible(true);
				
				
			}
		});
		btnErabiltzailea.setBounds(277, 122, 106, 94);
		contentPane.add(btnErabiltzailea);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/Logo.png")));
		lblNewLabel.setForeground(new Color(255, 102, 0));
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblNewLabel.setBounds(295, 30, 162, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bideojokoak kudeatu");
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(60, 227, 171, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jokalari bat gehitu");
		lblNewLabel_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(277, 224, 162, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnErabiltzailea_1 = new JButton("");
		btnErabiltzailea_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				adminBerriaGehitu abg= new adminBerriaGehitu();
				abg.setVisible(true);
			}
		});
		btnErabiltzailea_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnErabiltzailea_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

			}
		});
		btnErabiltzailea_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnErabiltzailea_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,0),4));

			}
		});
		btnErabiltzailea_1.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/icons8_Maintenance_96px.png")));
		btnErabiltzailea_1.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1.setBorder(null);
		btnErabiltzailea_1.setBackground(Color.WHITE);
		btnErabiltzailea_1.setBounds(484, 122, 106, 94);
		contentPane.add(btnErabiltzailea_1);
		
		JButton btnErabiltzailea_1_1 = new JButton("");
		btnErabiltzailea_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taldeBerriaGehitu tBG= new taldeBerriaGehitu();
				tBG.setVisible(true);
				setVisible(false);
			}
		});
		btnErabiltzailea_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnErabiltzailea_1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

			}
		});
		btnErabiltzailea_1_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnErabiltzailea_1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,0),4));
			}
		});
		btnErabiltzailea_1_1.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/shield_1.png")));
		btnErabiltzailea_1_1.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1_1.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1_1.setBorder(null);
		btnErabiltzailea_1_1.setBackground(Color.WHITE);
		btnErabiltzailea_1_1.setBounds(73, 286, 106, 94);
		contentPane.add(btnErabiltzailea_1_1);
		
		JButton btnErabiltzailea_1_1_1 = new JButton("");
		btnErabiltzailea_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taldeTxikiakGehituKendu tTGK= new taldeTxikiakGehituKendu();
				setVisible(false);
				tTGK.setVisible(true);
			}
		});
		btnErabiltzailea_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnErabiltzailea_1_1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

			}
		});
		btnErabiltzailea_1_1_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnErabiltzailea_1_1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,0),4));

			}
		});
		btnErabiltzailea_1_1_1.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/equipo.png")));
		btnErabiltzailea_1_1_1.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1_1_1.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1_1_1.setBorder(null);
		btnErabiltzailea_1_1_1.setBackground(Color.WHITE);
		btnErabiltzailea_1_1_1.setBounds(277, 286, 106, 94);
		contentPane.add(btnErabiltzailea_1_1_1);
		
		JButton btnErabiltzailea_1_1_2 = new JButton("");
		btnErabiltzailea_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnErabiltzailea_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnErabiltzailea_1_1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

			}
		});
		btnErabiltzailea_1_1_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnErabiltzailea_1_1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,0),4));

			}
		});
		btnErabiltzailea_1_1_2.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/MedallaA\u00F1adir.png")));
		btnErabiltzailea_1_1_2.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1_1_2.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1_1_2.setBorder(null);
		btnErabiltzailea_1_1_2.setBackground(Color.WHITE);
		btnErabiltzailea_1_1_2.setBounds(484, 286, 106, 94);
		contentPane.add(btnErabiltzailea_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Administratzaile");
		lblNewLabel_1_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(484, 227, 120, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Talde bat gehitu");
		lblNewLabel_1_3.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_3.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(73, 391, 130, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Talde txikiak kudeatu");
		lblNewLabel_1_4.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_4.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(258, 391, 162, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Irabazi Kopurua");
		lblNewLabel_1_5.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_5.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(484, 391, 120, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hasierakoPanela_admin hpa= new hasierakoPanela_admin();
				hpa.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(eragiketakAdmin.class.getResource("/images/icons8_Back_64px.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 30, 52, 73);
		contentPane.add(btnNewButton_1);
		contentPane.add(getLblNewLabel_1_2_1());
		contentPane.add(getLblNewLabel_1_5_1());
		setLocationRelativeTo(null);
	}
	public Boolean getSesioa(){
		return this.sesioaStatus;
	}
	
	public static eragiketakAdmin getNireEragiketakAdmin(){
		if (nEragiketakAdmin==null){
			nEragiketakAdmin=new eragiketakAdmin();
		}
		return nEragiketakAdmin;
	}
	
	public void setSesioa(boolean b){
		this.sesioaStatus=b;
	}
	private JLabel getLblNewLabel_1_2_1() {
		if (lblNewLabel_1_2_1 == null) {
			lblNewLabel_1_2_1 = new JLabel("berria sartu");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(484, 252, 120, 14);
		}
		return lblNewLabel_1_2_1;
	}
	private JLabel getLblNewLabel_1_5_1() {
		if (lblNewLabel_1_5_1 == null) {
			lblNewLabel_1_5_1 = new JLabel("eguneratu");
			lblNewLabel_1_5_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_5_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_5_1.setBounds(484, 411, 120, 14);
		}
		return lblNewLabel_1_5_1;
	}
}
