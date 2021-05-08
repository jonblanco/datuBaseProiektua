import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
//
public class taldeTxikiakGehituKendu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BufferedReader br;
	private Connection konexioa;
	private String taldeTxikiInfo;
	private JTextField sartuTaldeIzenaTF;
	private JButton gehituBtn;
	private JLabel sartuTaldeIzenaLbl;
	private JTextField sartuBideojokoKodeaTF;
	private JSeparator sartuBideojokoKodeaSep;
	private JLabel sartuBideojokoKodeaLbl;
	private JSeparator sartuTaldeIzenaSep;
	private JButton enterBtn;
	private Integer bideojokoKodea = 11;
	private Integer ezabatutakoKodea;
	private boolean gehituKendu = false; //false --> "-" botoia sakatu da; 	true --> "+" botoia sakatu da
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblKodeaIzenaJokalari;
	private JLabel lblHemenTaldeTxiki;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			taldeTxikiakGehituKendu dialog = new taldeTxikiakGehituKendu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public taldeTxikiakGehituKendu() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(taldeTxikiakGehituKendu.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Talde txikiak kudeatu");
		
		setBounds(100, 100, 926, 562);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			sartuTaldeIzenaSep = new JSeparator();
			sartuTaldeIzenaSep.setBackground(Color.BLACK);
			sartuTaldeIzenaSep.setBounds(723, 331, 164, 16);
			sartuTaldeIzenaSep.setVisible(false);
			this.scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setSize(679, 291);
			scrollPane.setLocation(10, 210);
			contentPanel.add(this.scrollPane);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblKodeaIzenaJokalari());
			contentPanel.add(sartuTaldeIzenaSep);
		}
		contentPanel.add(getSartuBideojokoKodeaSep());
		{
			JLabel panelLogoLbl = new JLabel("");
			panelLogoLbl.setIcon(new ImageIcon(taldeTxikiakGehituKendu.class.getResource("/images/equipo.png")));
			panelLogoLbl.setBounds(386, 11, 137, 124);
			contentPanel.add(panelLogoLbl);
		}
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					eragiketakAdmin eA=eragiketakAdmin.getNireEragiketakAdmin();
					eA.setVisible(true);
				}
			});
			btnNewButton.setIcon(new ImageIcon(taldeTxikiakGehituKendu.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 11, 52, 73);
			contentPanel.add(btnNewButton);
		}
		
		JLabel panelInfoLbl = new JLabel("Hona hemen lehiaketetan parte hartzen duten talde txikiak: ");
		panelInfoLbl.setForeground(new Color(255, 102, 0));
		panelInfoLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		panelInfoLbl.setBounds(23, 132, 570, 31);
		contentPanel.add(panelInfoLbl);
		{
			sartuTaldeIzenaTF = new JTextField();
			sartuTaldeIzenaTF.setToolTipText("");
			sartuTaldeIzenaTF.setBorder(null);
			sartuTaldeIzenaTF.setForeground(Color.LIGHT_GRAY);
			sartuTaldeIzenaTF.setColumns(10);
			sartuTaldeIzenaTF.setBounds(723, 295, 164, 31);
			sartuTaldeIzenaTF.setVisible(false);
			contentPanel.add(sartuTaldeIzenaTF);
		}
		contentPanel.add(getGehituBtn());
		{
			JButton kenduBtn = new JButton("-");
			kenduBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gehituKendu = false;
					sartuTaldeIzenaLbl.setVisible(true);
					sartuTaldeIzenaTF.setVisible(true);
					sartuTaldeIzenaSep.setVisible(true);
					sartuBideojokoKodeaLbl.setVisible(false);
					sartuBideojokoKodeaTF.setVisible(false);
					sartuBideojokoKodeaSep.setVisible(false);
					enterBtn.setVisible(true);
					scrollPane.setVisible(true);
					sartuTaldeIzenaLbl.setText("Talde txikiaren izena: ");
				}
			});
			kenduBtn.setForeground(new Color(255, 102, 0));
			kenduBtn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 26));
			kenduBtn.setBackground(Color.WHITE);
			kenduBtn.setBounds(810, 184, 65, 50);
			contentPanel.add(kenduBtn);
		}
		contentPanel.add(getSartuTaldeIzenaLbl());
		contentPanel.add(getSartuBideojokoKodeaTF());
		contentPanel.add(getSartuBideojokoKodeaLbl());
		contentPanel.add(getEnterBtn());
		contentPanel.add(getLblHemenTaldeTxiki());
		try {
			taldeTxikiakBistaratu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	private JButton getGehituBtn() {
		if (gehituBtn == null) {
			gehituBtn = new JButton("+");
			gehituBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gehituKendu = true;
					sartuTaldeIzenaLbl.setVisible(true);
					sartuTaldeIzenaTF.setVisible(true);
					sartuTaldeIzenaSep.setVisible(true);
					sartuBideojokoKodeaLbl.setVisible(true);
					sartuBideojokoKodeaTF.setVisible(true);
					sartuBideojokoKodeaSep.setVisible(true);
					enterBtn.setVisible(true);
					sartuTaldeIzenaLbl.setText("Taldearen izena: ");
				}
			});
			gehituBtn.setForeground(new Color(255, 102, 0));
			gehituBtn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 23));
			gehituBtn.setBackground(Color.WHITE);
			gehituBtn.setBounds(723, 184, 65, 50);
		}
		return gehituBtn;
	}
	private JLabel getSartuTaldeIzenaLbl() {
		if (sartuTaldeIzenaLbl == null) {
			sartuTaldeIzenaLbl = new JLabel("Taldearen izena:");
			sartuTaldeIzenaLbl.setForeground(new Color(255, 102, 0));
			sartuTaldeIzenaLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			sartuTaldeIzenaLbl.setBounds(723, 255, 177, 31);
			sartuTaldeIzenaLbl.setVisible(false);
		}
		return sartuTaldeIzenaLbl;
	}
	private JTextField getSartuBideojokoKodeaTF() {
		if (sartuBideojokoKodeaTF == null) {
			sartuBideojokoKodeaTF = new JTextField();
			sartuBideojokoKodeaTF.setToolTipText("");
			sartuBideojokoKodeaTF.setForeground(Color.LIGHT_GRAY);
			sartuBideojokoKodeaTF.setColumns(10);
			sartuBideojokoKodeaTF.setBorder(null);
			sartuBideojokoKodeaTF.setBounds(723, 395, 164, 31);
			sartuBideojokoKodeaTF.setVisible(false);
		}
		return sartuBideojokoKodeaTF;
	}
	private JSeparator getSartuBideojokoKodeaSep() {
		if (sartuBideojokoKodeaSep == null) {
			sartuBideojokoKodeaSep = new JSeparator();
			sartuBideojokoKodeaSep.setBackground(Color.BLACK);
			sartuBideojokoKodeaSep.setBounds(723, 429, 164, 16);
			sartuBideojokoKodeaSep.setVisible(false);
		}
		return sartuBideojokoKodeaSep;
	}
	private JLabel getSartuBideojokoKodeaLbl() {
		if (sartuBideojokoKodeaLbl == null) {
			sartuBideojokoKodeaLbl = new JLabel("Bideojoko kodea:");
			sartuBideojokoKodeaLbl.setForeground(new Color(255, 102, 0));
			sartuBideojokoKodeaLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			sartuBideojokoKodeaLbl.setBounds(723, 353, 164, 31);
			sartuBideojokoKodeaLbl.setVisible(false);
		}
		return sartuBideojokoKodeaLbl;
	}
	private JButton getEnterBtn() {
		if (enterBtn == null) {
			enterBtn = new JButton("");
			enterBtn.setBorder(null);
			enterBtn.setIcon(new ImageIcon(taldeTxikiakGehituKendu.class.getResource("/images/Enter_ON.png")));
			enterBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(gehituKendu) {
							taldeTxikiaSartu();
							textArea.setText(null);
							taldeTxikiakBistaratu();
							scrollPane.setVisible(true);
						}
						else {
							taldeTxikiaKendu();
							textArea.setText(null);
							taldeTxikiakBistaratu();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			enterBtn.setForeground(new Color(255, 102, 0));
			enterBtn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 23));
			enterBtn.setBackground(Color.WHITE);
			enterBtn.setBounds(723, 451, 155, 50);
		}
		return enterBtn;
	}
	

	//Datu basean sartuta dagoen bideojoko kopurua kalkulatzeko
	private int bideojokoKop() throws SQLException{
		String kontsulta = "SELECT COUNT(*) FROM bideojoko;";
		PreparedStatement pStatement = konexioa.prepareStatement(kontsulta);
		ResultSet rs = pStatement.executeQuery();
		int iterazioKop = 0;
		while (rs.next()) {
			 iterazioKop = Integer.parseInt(rs.getString("COUNT(*)"));
		}
		return iterazioKop;
	}
	
	//Azkena ez den edozein bideojoko ezabatzean, bakoitzaren kodea eguneratzeko
	private void bideojokoGuztienKodeakEguneratu() throws SQLException {
		while(this.ezabatutakoKodea <= this.bideojokoKop()) {
			this.bideojokoBatenKodeaEguneratu();
		}
		this.bideojokoKodea = this.ezabatutakoKodea;
		this.ezabatutakoKodea = null;
	}

	private void bideojokoBatenKodeaEguneratu() throws SQLException {
		String kontsulta = "UPDATE bideojoko SET kodea = ? WHERE kodea = ?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, this.ezabatutakoKodea.toString());
		this.ezabatutakoKodea++;
		pStatement.setString(2, this.ezabatutakoKodea.toString());
		pStatement.executeUpdate();
	}
	
	//Bideojoko guztien informazioa pantailaratzeko
	private void taldeTxikiakBistaratu() throws SQLException {
		String kontsulta = "SELECT * FROM talde_txiki";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			
			taldeTxikiInfo = rs.getString("taldetxikiizena");
			textArea.append(taldeTxikiInfo);
			textArea.append("\t");
			
			taldeTxikiInfo = rs.getString("taldeizena");
			textArea.append(taldeTxikiInfo);
			textArea.append("\t");
			
			taldeTxikiInfo = rs.getString("jokalarikop");
			textArea.append(taldeTxikiInfo);
			textArea.append("\t");
			
			taldeTxikiInfo = rs.getString("entrenatzailea");
			textArea.append(taldeTxikiInfo);
			textArea.append("                \t");
	
			taldeTxikiInfo = rs.getString("irabazikop");
			textArea.append(taldeTxikiInfo);
			textArea.append("\t");
			
			taldeTxikiInfo = rs.getString("kodebideojoko")+"\n";
			textArea.append(taldeTxikiInfo);
		}
	}
	
	//Talde txiki berri bat sartzeko (berria denez, irabazi kopurua = 0 izango da)
	private void taldeTxikiaSartu() throws SQLException {
		//taldetxikiizena: talde horretako azken talde txikia + 1 (ADBZ: USA1, USA2, USA3 --> talde_txiki berria: USA4)
		//jokalarikop: bideojoko kodea erabiliz, bideojoko horri dagokion jokalari kopurua esleitu
		//entrenatzailea: talde horretako entrenatzailea esleitu
		//irabazikop: 0 (talde_txiki berria delako)
		//taldeizena: datu-basean dagoen talde handietako bat izan behar da; bestela, ERRORE MEZUA BOTA!!
		//kodebideojoko: datu-basean dagoen bideojoko bat izan behar da; bestela, ERRORE MEZUA BOTA!!
		
	
		String taldeIzenaString = this.sartuTaldeIzenaTF.getText();
		String bideojokoKodea = this.sartuBideojokoKodeaTF.getText();
		if(taldeIzenaString.equals("") || bideojokoKodea.equals("")) {
			JOptionPane.showMessageDialog(contentPanel, "Bi testu eremuak bete behar dira !!");
		}
		else {
			String taldeTxikiIzena = this.taldeTxikiIzenaLortu(taldeIzenaString.toLowerCase());
			String jokalarikop = this.jokalariKopuruaLortu(bideojokoKodea);
			String entrenatzailea = this.entrenatzaileaLortu(taldeIzenaString);
			
			if(taldeTxikiIzena != null && jokalarikop != null && entrenatzailea != null) {
				String ekintza = "INSERT INTO talde_txiki VALUES(?, ?, ?, 0, ?, ?)";
				PreparedStatement pStatement = konexioa.prepareStatement(ekintza);
				pStatement.setString(1, taldeTxikiIzena);
				System.out.println(taldeTxikiIzena);
				pStatement.setString(2, jokalarikop);
				System.out.println(jokalarikop);
				pStatement.setString(3, entrenatzailea);
				System.out.println(entrenatzailea);
				pStatement.setString(4, taldeIzenaString.toUpperCase().charAt(0) + taldeIzenaString.substring(1, taldeIzenaString.length()).toLowerCase());
				System.out.println(taldeIzenaString.toUpperCase().charAt(0) + taldeIzenaString.substring(1, taldeIzenaString.length()).toLowerCase());
				pStatement.setString(5, bideojokoKodea);
				System.out.println(bideojokoKodea);
				pStatement.executeUpdate();	
			}
			if(taldeTxikiIzena == null) {
				JOptionPane.showMessageDialog(contentPanel, "Sartutako taldea ez dago datu-basean !!");
			}
			if(jokalarikop == null) {
				JOptionPane.showMessageDialog(contentPanel, "Datu-basean ez dago sartutako kodea duen bideojokorik !!");
			}
		}
		
		this.sartuTaldeIzenaTF.setText("");
		this.sartuBideojokoKodeaTF.setText("");
		 
	}
	

	//talde horretako azken talde txikia + 1 (ADBZ: USA1, USA2, USA3 --> talde_txiki berria: USA4)
	private String taldeTxikiIzenaLortu(String pTalde) throws SQLException {
		String kontsulta = "SELECT COUNT(*) FROM talde_txiki WHERE taldeizena=?";
		PreparedStatement pStatement = konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, pTalde);
		ResultSet rs = pStatement.executeQuery();
		Integer kontsultaInteger = null;
		if(rs.next()) {
			kontsultaInteger = Integer.parseInt(rs.getString("COUNT(*)")) + 1;
			kontsulta = kontsultaInteger.toString();
		}
		
		switch(pTalde) {
		case "betis":
			return "B" + kontsulta;
		case "team bds":
			return "BDS" + kontsulta;
		case "cloud9":
			return "C" + kontsulta;
		case "dallas e.":
			return "D" + kontsulta;
		case "dream team":
			return "DT" + kontsulta;
		case "fnatic":
			return "F" + kontsulta;
		case "g2 esports":
			return "G2" + kontsulta;
		case "heretics":
			return "H" + kontsulta;
		case "liquid":
			return "L" + kontsulta;
		case "rblz gaming":
			return "R" + kontsulta;
		case "team usa":
			return "USA" + kontsulta;
		default:
			return null;
		}
	}
	
	//lo suyo sería meterlo con el nombre del juego en vez de con el code (de momento lo dejo así)
	//bideojoko kodea erabiliz, bideojoko horri dagokion jokalari kopurua esleitu
	private String jokalariKopuruaLortu(String pBideojokoKode) throws SQLException {
		String kontsulta = "SELECT jokalarikop FROM bideojoko WHERE kodea=?";
		PreparedStatement pStatement = konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, pBideojokoKode);
		ResultSet rs = pStatement.executeQuery();
		if(rs.next()) {
			return rs.getString("jokalarikop");
		}
		return null;
	}
	
	//talde horretako entrenatzailea esleitu
	private String entrenatzaileaLortu(String pTalde) throws SQLException {
		String kontsulta = "SELECT DISTINCT entrenatzailea FROM talde_txiki WHERE taldeizena=?";
		PreparedStatement pStatement = konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, pTalde);
		ResultSet rs = pStatement.executeQuery();
		if(rs.next()) {
			return rs.getString("entrenatzailea");
		}
		return null;
	}
	
		
	//Talde_txiki jakin bat ezabatzeko 
	private void taldeTxikiaKendu() throws SQLException {
		String taldeTxikiaExistitzenDa = "SELECT * FROM talde_txiki WHERE taldetxikiizena = ?";
		PreparedStatement pStatement1 = konexioa.prepareStatement(taldeTxikiaExistitzenDa);
		pStatement1.setString(1, this.sartuTaldeIzenaTF.getText());
		ResultSet rs = pStatement1.executeQuery();
		if(rs.next()) { //Talde txikia existitzen bada, hau ezabatu
			String kontsultaTaldeTxikiaEzabatzeko = "DELETE FROM talde_txiki WHERE taldetxikiizena = ?";
			PreparedStatement pStatement2 = konexioa.prepareStatement(kontsultaTaldeTxikiaEzabatzeko);
			pStatement2.setString(1, this.sartuTaldeIzenaTF.getText());
			pStatement2.executeUpdate();
		}
		else { //Bestela, ez dela existitzen jakinarazi
			JOptionPane.showMessageDialog(contentPanel, "Ezabatu nahi duzun talde-txikia ez dago datu basean sartuta !!");
		}
	}
	
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	
	private JLabel getLblKodeaIzenaJokalari() {
		if (lblKodeaIzenaJokalari == null) {
			lblKodeaIzenaJokalari = new JLabel("TTizena                TaldeIzena            Jokalari kop.       Entrenatzailea                                  Irabazi kop.          Bideojoko kodea");
			lblKodeaIzenaJokalari.setHorizontalAlignment(SwingConstants.LEFT);
			lblKodeaIzenaJokalari.setForeground(new Color(255, 102, 0));
			lblKodeaIzenaJokalari.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		}
		return lblKodeaIzenaJokalari;
	}
	private JLabel getLblHemenTaldeTxiki() {
		if (lblHemenTaldeTxiki == null) {
			lblHemenTaldeTxiki = new JLabel("Hemen talde txiki berrriak sartzeko edo ezabatzeko aukera izango duzu ");
			lblHemenTaldeTxiki.setForeground(new Color(255, 102, 0));
			lblHemenTaldeTxiki.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblHemenTaldeTxiki.setBounds(23, 165, 570, 31);
		}
		return lblHemenTaldeTxiki;
	}
}
