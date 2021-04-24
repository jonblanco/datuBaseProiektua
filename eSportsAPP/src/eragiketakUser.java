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
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;

public class eragiketakUser extends JFrame {
	private Connection konexioa;
	private BufferedReader br;
	private JPanel contentPane;
	private boolean sesioaIrekita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eragiketakUser frame = new eragiketakUser();
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
	public eragiketakUser() {
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
		btnNewButton.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/persona.png")));
		btnNewButton.setForeground(new Color(255, 102, 0));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bilatuJokalaria bJ= new bilatuJokalaria();
				bJ.setVisible(true);
				setVisible(false);
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
		btnErabiltzailea.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/shield_1.png")));
		btnErabiltzailea.setForeground(new Color(255, 102, 0));
		btnErabiltzailea.setBackground(Color.WHITE);
		btnErabiltzailea.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taldeakIkusi tI = new taldeakIkusi();
				setVisible(false);
				tI.setVisible(true);
				
				
			}
		});
		btnErabiltzailea.setBounds(277, 119, 106, 97);
		contentPane.add(btnErabiltzailea);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/logo.png")));
		lblNewLabel.setForeground(new Color(255, 102, 0));
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblNewLabel.setBounds(270, 30, 162, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jokalari bat bilatu");
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(69, 227, 134, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Taldeak ikusi");
		lblNewLabel_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(287, 227, 128, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnErabiltzailea_1 = new JButton("");
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
		btnErabiltzailea_1.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/equipo.png")));
		btnErabiltzailea_1.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1.setBorder(null);
		btnErabiltzailea_1.setBackground(Color.WHITE);
		btnErabiltzailea_1.setBounds(484, 122, 106, 94);
		contentPane.add(btnErabiltzailea_1);
		
		JButton btnErabiltzailea_1_1 = new JButton("");
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
		btnErabiltzailea_1_1.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/trofeo.png")));
		btnErabiltzailea_1_1.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1_1.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1_1.setBorder(null);
		btnErabiltzailea_1_1.setBackground(Color.WHITE);
		btnErabiltzailea_1_1.setBounds(73, 286, 106, 94);
		contentPane.add(btnErabiltzailea_1_1);
		
		JButton btnErabiltzailea_1_1_1 = new JButton("");
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
		btnErabiltzailea_1_1_1.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/icons8_Clock_96px.png")));
		btnErabiltzailea_1_1_1.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1_1_1.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1_1_1.setBorder(null);
		btnErabiltzailea_1_1_1.setBackground(Color.WHITE);
		btnErabiltzailea_1_1_1.setBounds(277, 286, 106, 94);
		contentPane.add(btnErabiltzailea_1_1_1);
		
		JButton btnErabiltzailea_1_1_2 = new JButton("");
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
		btnErabiltzailea_1_1_2.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/icons8_User_96px_2.png")));
		btnErabiltzailea_1_1_2.setMaximumSize(new Dimension(50, 20));
		btnErabiltzailea_1_1_2.setForeground(new Color(255, 102, 0));
		btnErabiltzailea_1_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnErabiltzailea_1_1_2.setBorder(null);
		btnErabiltzailea_1_1_2.setBackground(Color.WHITE);
		btnErabiltzailea_1_1_2.setBounds(484, 286, 106, 94);
		contentPane.add(btnErabiltzailea_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Taldetxoak ikusi");
		lblNewLabel_1_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(484, 227, 120, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Aurreko talde ");
		lblNewLabel_1_3.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_3.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(73, 391, 130, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Administratzailea");
		lblNewLabel_1_4.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_4.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(277, 391, 120, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Administratzailea");
		lblNewLabel_1_5.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_5.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(484, 391, 120, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("irabazlea ikusi");
		lblNewLabel_1_3_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_3_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(73, 410, 130, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(konprobatuSesioa()==true){
					hasierakoPanela_admin hpa= new hasierakoPanela_admin();
					hpa.setVisible(true);
					setVisible(false);
				}
				else{
					
				hasierakoPanela hp= new hasierakoPanela();
				hp.setVisible(true);
				setVisible(false);
			}
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(eragiketakUser.class.getResource("/images/icons8_Back_64px.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 30, 52, 73);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
		this.sesioaIrekita=false;
		
		
			
		
	}
	
	private Boolean konprobatuSesioa(){
		if(eragiketakAdmin.getNireEragiketakAdmin().getSesioa()==true){
			sesioaIrekita=true;
		}
			
		
	return sesioaIrekita;
	}
		
		
}	

