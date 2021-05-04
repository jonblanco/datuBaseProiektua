
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IzenaTF = new JTextField();
		IzenaTF.setBounds(221, 28, 86, 20);
		contentPane.add(IzenaTF);
		IzenaTF.setColumns(10);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setBounds(147, 31, 46, 14);
		contentPane.add(lblIzena);
		
		AbizenaTF = new JTextField();
		AbizenaTF.setBounds(221, 59, 86, 20);
		contentPane.add(AbizenaTF);
		AbizenaTF.setColumns(10);
		
		JLabel lblAbizena = new JLabel("1.Abizena");
		lblAbizena.setBounds(147, 62, 64, 14);
		contentPane.add(lblAbizena);
		
		AbizenaTFBi = new JTextField();
		AbizenaTFBi.setBounds(221, 90, 86, 20);
		contentPane.add(AbizenaTFBi);
		AbizenaTFBi.setColumns(10);
		
		JLabel lblabizena = new JLabel("2.Abizena");
		lblabizena.setBounds(147, 93, 64, 14);
		contentPane.add(lblabizena);
		
		TaldeaTF = new JTextField();
		TaldeaTF.setBounds(221, 121, 86, 20);
		contentPane.add(TaldeaTF);
		TaldeaTF.setColumns(10);
		
		JLabel Taldea = new JLabel("Taldea");
		Taldea.setBounds(147, 124, 46, 14);
		contentPane.add(Taldea);
		
		AdinaTF = new JTextField();
		AdinaTF.setBounds(221, 152, 86, 20);
		contentPane.add(AdinaTF);
		AdinaTF.setColumns(10);
		
		JLabel lblAdina = new JLabel("Adina");
		lblAdina.setBounds(147, 155, 46, 14);
		contentPane.add(lblAdina);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(JokalariaGehitu.class.getResource("/images/icons8_User_96px_2.png")));
		label.setBounds(23, 61, 106, 105);
		contentPane.add(label);
		
		JButton btnGehitu = new JButton("Gehitu");
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
		btnGehitu.setBounds(191, 258, 97, 29);
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
		btnNewButton.setBounds(23, 177, 52, 73);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("TT_kode");
		lblNewLabel.setBounds(147, 183, 58, 14);
		contentPane.add(lblNewLabel);
		
		TTKodeTF = new JTextField();
		TTKodeTF.setBounds(221, 180, 86, 20);
		contentPane.add(TTKodeTF);
		TTKodeTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Herrialdea");
		lblNewLabel_1.setBounds(147, 211, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		HerrialdeTF = new JTextField();
		HerrialdeTF.setBounds(221, 209, 86, 20);
		contentPane.add(HerrialdeTF);
		HerrialdeTF.setColumns(10);
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
}