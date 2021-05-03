
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

public class JokalariaGehitu extends JFrame {

	private JPanel contentPane;
	private JTextField IzenaTF;
	private JTextField AbizenaTF;
	private JTextField AbizenaTFBi;
	private JTextField TaldeaTF;
	private JTextField AdinaTF;
	private Connection konexioa;
	private static JokalariaGehitu nireJokalariaGehitu;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IzenaTF = new JTextField();
		IzenaTF.setBounds(170, 82, 86, 20);
		contentPane.add(IzenaTF);
		IzenaTF.setColumns(10);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setBounds(96, 85, 46, 14);
		contentPane.add(lblIzena);
		
		AbizenaTF = new JTextField();
		AbizenaTF.setBounds(170, 113, 86, 20);
		contentPane.add(AbizenaTF);
		AbizenaTF.setColumns(10);
		
		JLabel lblAbizena = new JLabel("1.Abizena");
		lblAbizena.setBounds(96, 116, 64, 14);
		contentPane.add(lblAbizena);
		
		AbizenaTFBi = new JTextField();
		AbizenaTFBi.setBounds(170, 144, 86, 20);
		contentPane.add(AbizenaTFBi);
		AbizenaTFBi.setColumns(10);
		
		JLabel lblabizena = new JLabel("2.Abizena");
		lblabizena.setBounds(96, 147, 64, 14);
		contentPane.add(lblabizena);
		
		TaldeaTF = new JTextField();
		TaldeaTF.setBounds(170, 172, 86, 20);
		contentPane.add(TaldeaTF);
		TaldeaTF.setColumns(10);
		
		JLabel Taldea = new JLabel("Taldea");
		Taldea.setBounds(96, 175, 46, 14);
		contentPane.add(Taldea);
		
		AdinaTF = new JTextField();
		AdinaTF.setBounds(170, 203, 86, 20);
		contentPane.add(AdinaTF);
		AdinaTF.setColumns(10);
		
		JLabel lblAdina = new JLabel("Adina");
		lblAdina.setBounds(96, 206, 46, 14);
		contentPane.add(lblAdina);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(JokalariaGehitu.class.getResource("/images/icons8_User_96px_2.png")));
		label.setBounds(170, 11, 86, 71);
		contentPane.add(label);
		
		JButton btnGehitu = new JButton("Gehitu");
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
		btnGehitu.setBounds(283, 202, 89, 23);
		contentPane.add(btnGehitu);
		setLocationRelativeTo(null);
		
		
	}
	public void gehituJokalaria() throws SQLException {
		konektatu();
		String JokIzena=IzenaTF.getText();
		String Jok1Abizena=AbizenaTF.getText();
		String herrialdea="Santurtzi"; //POR TERMINAR
		String Jok2Abizena=AbizenaTFBi.getText();
		String JokTaldea=TaldeaTF.getText();
		String JokAdina=AdinaTF.getText();
		String taldeTxikiKode=null; //POR TERMINAR
		boolean taldeaOndoDago=taldeaKonprobatu(JokTaldea);
		if(!taldeaOndoDago) {
			ErroreMezuEdit em=new ErroreMezuEdit("Taldea txarto sartu duzu");
			em.setVisible(true);
		}else {
			String kontsulta="INSERT INTO JOKALARI VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
			pStatement.setString(1,JokTaldea);
			pStatement.setString(2,JokIzena);
			pStatement.setString(3,Jok1Abizena);
			pStatement.setString(4,Jok2Abizena);
			pStatement.setString(5,JokAdina);
			pStatement.setString(6,herrialdea);
			pStatement.setString(7,taldeTxikiKode);
			pStatement.executeUpdate();
			
			
			
			
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