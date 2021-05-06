
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JSeparator;

public class JokalariaGehitu extends JFrame {

	private JPanel contentPane;
	private JTextField IzenaTF;
	private JTextField AbizenaTF;
	private JTextField AbizenaTFBi;
	private JTextField TaldeaTF;
	private JTextField AdinaTF;
	private Connection konexioa;
	private static JokalariaGehitu nireJokalariaGehitu;
	private JTextField TTKodeTF;
	private JTextField HerrialdeTF;
	private JLabel lblIzena_1;
	private JLabel lblIzena_1_1;
	private JLabel lblIzena_1_1_1;
	private JLabel lblIzena_1_1_1_1;
	private JLabel lblIzena_1_1_1_1_1;
	private JLabel lblIzena_1_1_1_1_2;
	private JLabel lblIzena_1_1_1_1_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_3;
	private JSeparator separator_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JokalariaGehitu frame = new JokalariaGehitu();
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
	public static JokalariaGehitu getNireJokalariaGehitu() {
		if(nireJokalariaGehitu==null) {
			nireJokalariaGehitu=new JokalariaGehitu();
		}
		return nireJokalariaGehitu;
	}
	
	private JokalariaGehitu() {
		setTitle("Jokalaria gehitu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,484, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IzenaTF = new JTextField();
		IzenaTF.setBorder(null);
		IzenaTF.setBounds(201, 28, 175, 20);
		contentPane.add(IzenaTF);
		IzenaTF.setColumns(10);
		
		AbizenaTF = new JTextField();
		AbizenaTF.setBorder(null);
		AbizenaTF.setBounds(201, 59, 175, 20);
		contentPane.add(AbizenaTF);
		AbizenaTF.setColumns(10);
		
		AbizenaTFBi = new JTextField();
		AbizenaTFBi.setBorder(null);
		AbizenaTFBi.setBounds(201, 90, 175, 20);
		contentPane.add(AbizenaTFBi);
		AbizenaTFBi.setColumns(10);
		
		TaldeaTF = new JTextField();
		TaldeaTF.setBorder(null);
		TaldeaTF.setBounds(201, 121, 175, 20);
		contentPane.add(TaldeaTF);
		TaldeaTF.setColumns(10);
		
		AdinaTF = new JTextField();
		AdinaTF.setBorder(null);
		AdinaTF.setBounds(201, 152, 175, 20);
		contentPane.add(AdinaTF);
		AdinaTF.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(JokalariaGehitu.class.getResource("/images/icons8_User_96px_2.png")));
		label.setBounds(23, 61, 106, 105);
		contentPane.add(label);
		
		JButton btnGehitu = new JButton("");
		btnGehitu.setBackground(Color.WHITE);
		btnGehitu.setBorder(null);
		btnGehitu.setIcon(new ImageIcon(JokalariaGehitu.class.getResource("/images/Enter_ON.png")));
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gehituJokalaria();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGehitu.setBounds(148, 264, 159, 63);
		contentPane.add(btnGehitu);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				eragiketakAdmin ea=eragiketakAdmin.getNireEragiketakAdmin();
				ea.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(JokalariaGehitu.class.getResource("/images/icons8_Back_64px.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 279, 52, 73);
		contentPane.add(btnNewButton);
		
		TTKodeTF = new JTextField();
		TTKodeTF.setBorder(null);
		TTKodeTF.setBounds(201, 183, 175, 20);
		contentPane.add(TTKodeTF);
		TTKodeTF.setColumns(10);
		
		HerrialdeTF = new JTextField();
		HerrialdeTF.setBorder(null);
		HerrialdeTF.setBounds(201, 209, 175, 20);
		contentPane.add(HerrialdeTF);
		HerrialdeTF.setColumns(10);
		contentPane.add(getLblIzena_1());
		contentPane.add(getLblIzena_1_1());
		contentPane.add(getLblIzena_1_1_1());
		contentPane.add(getLblIzena_1_1_1_1());
		contentPane.add(getLblIzena_1_1_1_1_1());
		
		lblIzena_1_1_1_1_2 = new JLabel("Talde txiki kode");
		lblIzena_1_1_1_1_2.setForeground(new Color(255, 102, 0));
		lblIzena_1_1_1_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		lblIzena_1_1_1_1_2.setBounds(95, 183, 96, 20);
		contentPane.add(lblIzena_1_1_1_1_2);
		
		lblIzena_1_1_1_1_3 = new JLabel("Herrialdea");
		lblIzena_1_1_1_1_3.setForeground(new Color(255, 102, 0));
		lblIzena_1_1_1_1_3.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		lblIzena_1_1_1_1_3.setBounds(123, 209, 76, 20);
		contentPane.add(lblIzena_1_1_1_1_3);
		contentPane.add(getSeparator());
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(201, 81, 175, 20);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(201, 112, 175, 16);
		contentPane.add(separator_2);
		
		separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(201, 177, 175, 16);
		contentPane.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(201, 209, 175, 16);
		contentPane.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(201, 236, 175, 16);
		contentPane.add(separator_6);
		
		separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(201, 150, 175, 16);
		contentPane.add(separator_3);
		
		separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(201, 204, 175, 16);
		contentPane.add(separator_7);
		setLocationRelativeTo(null);
		
		
	}
	public void gehituJokalaria() throws SQLException {
		konektatu();
		String JokIzena=IzenaTF.getText();
		String Jok1Abizena=AbizenaTF.getText();
		String herrialdea=HerrialdeTF.getText(); //POR TERMINAR
		String Jok2Abizena=AbizenaTFBi.getText();
		String JokTaldea=TaldeaTF.getText();
		String JokAdina=AdinaTF.getText();
		String taldeTxikiKode=TTKodeTF.getText(); //POR TERMINAR
		boolean taldeaOndoDago=taldeaKonprobatu(JokTaldea);
		if(!taldeaOndoDago) {
			ErroreMezuEdit em=new ErroreMezuEdit("Taldea txarto sartu duzu");
			em.setVisible(true);
		}else {
			try {
				String kontsulta="INSERT INTO JOKALARI VALUES(?,?,?,?,?,?,?)";
				PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
				pStatement.setString(1,JokIzena);
				pStatement.setString(2,Jok1Abizena);
				pStatement.setString(3,Jok2Abizena);
				pStatement.setString(4,JokAdina);
				pStatement.setString(5,herrialdea);
				pStatement.setString(6,taldeTxikiKode);
				pStatement.setString(7,JokTaldea);
				pStatement.executeUpdate();
				
			}catch(SQLException e) {
				ErroreMezuEdit em=new ErroreMezuEdit("Daturen bat txarto jarrita dago.");
				em.setVisible(true);
			}
				
			
			
			
			
			
			
			
		}
		
		
	}
	
	
	public boolean taldeaKonprobatu(String Taldea) throws SQLException {
		boolean taldeaOndoDago=false;
		String kontsulta= "SELECT * FROM TALDE";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		ResultSet rs = pStatement.executeQuery();
		while(rs.next()&& !taldeaOndoDago) {
			String t=rs.getString("izena");
			System.out.println(rs.getString("izena"));
			if(t.equals(Taldea)) {
				taldeaOndoDago=true;
			}
		}
		return taldeaOndoDago;
		
	}
	private void konektatu(){
		
		try {
			// TODO - datu-basera konektatzeko kodea
			Class.forName("com.mysql.jdbc.Driver");
			String zerbitzaria= "jdbc:mysql://localhost:3306/esportsapp";
			String erabiltzailea= "root";
			String pasahitza="";
			konexioa = DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private JLabel getLblIzena_1() {
		if (lblIzena_1 == null) {
			lblIzena_1 = new JLabel("Izena");
			lblIzena_1.setForeground(new Color(255, 102, 0));
			lblIzena_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
			lblIzena_1.setBounds(147, 23, 52, 31);
		}
		return lblIzena_1;
	}
	private JLabel getLblIzena_1_1() {
		if (lblIzena_1_1 == null) {
			lblIzena_1_1 = new JLabel("1.Abizena");
			lblIzena_1_1.setForeground(new Color(255, 102, 0));
			lblIzena_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
			lblIzena_1_1.setBounds(123, 54, 66, 31);
		}
		return lblIzena_1_1;
	}
	private JLabel getLblIzena_1_1_1() {
		if (lblIzena_1_1_1 == null) {
			lblIzena_1_1_1 = new JLabel("2.Abizena");
			lblIzena_1_1_1.setForeground(new Color(255, 102, 0));
			lblIzena_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
			lblIzena_1_1_1.setBounds(125, 90, 64, 20);
		}
		return lblIzena_1_1_1;
	}
	private JLabel getLblIzena_1_1_1_1() {
		if (lblIzena_1_1_1_1 == null) {
			lblIzena_1_1_1_1 = new JLabel("Taldea");
			lblIzena_1_1_1_1.setForeground(new Color(255, 102, 0));
			lblIzena_1_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
			lblIzena_1_1_1_1.setBounds(147, 121, 64, 20);
		}
		return lblIzena_1_1_1_1;
	}
	private JLabel getLblIzena_1_1_1_1_1() {
		if (lblIzena_1_1_1_1_1 == null) {
			lblIzena_1_1_1_1_1 = new JLabel("Adina");
			lblIzena_1_1_1_1_1.setForeground(new Color(255, 102, 0));
			lblIzena_1_1_1_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
			lblIzena_1_1_1_1_1.setBounds(147, 155, 64, 20);
		}
		return lblIzena_1_1_1_1_1;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(201, 54, 175, 16);
		}
		return separator;
	}
}