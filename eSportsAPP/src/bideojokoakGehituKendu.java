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
//
public class bideojokoakGehituKendu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;
	private BufferedReader br;
	private Connection konexioa;
	private String bideojokoInfo;
	private JTextField sartuIzenaTF;
	private JButton gehituBtn;
	private JLabel KodeaLbl;
	private JLabel IzenaLbl;
	private JLabel JokalarikopLbl;
	private JLabel IrabazleaLbl;
	private JLabel sartuIzenaLbl;
	private JTextField sartuJokalarikopTF;
	private JSeparator sartuJokalariKopSep;
	private JLabel sartuJokalarikopLbl;
	private JSeparator sartuIzenaSep;
	private JButton enterBtn;
	private Integer bideojokoKodea = 11;
	private boolean gehituKendu = false; //false --> "-" botoia sakatu da; 	true --> "+" botoia sakatu da

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			bideojokoakGehituKendu dialog = new bideojokoakGehituKendu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public bideojokoakGehituKendu() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(bideojokoakGehituKendu.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Saridunak ikusi");
		
		setBounds(100, 100, 581, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			sartuIzenaSep = new JSeparator();
			sartuIzenaSep.setBackground(Color.BLACK);
			sartuIzenaSep.setBounds(391, 258, 164, 16);
			sartuIzenaSep.setVisible(false);
			contentPanel.add(sartuIzenaSep);
		}
		contentPanel.add(getSartuJokalariKopSep());
		{
			JLabel panelLogoLbl = new JLabel("");
			panelLogoLbl.setIcon(new ImageIcon(bideojokoakGehituKendu.class.getResource("/images/medallaNaranja.png")));
			panelLogoLbl.setBounds(236, 11, 137, 124);
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
			btnNewButton.setIcon(new ImageIcon(bideojokoakGehituKendu.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 11, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextArea());
		
		JLabel panelInfoLbl = new JLabel("Hona hemen lehiaketetan jolasten diren jokoak:");
		panelInfoLbl.setForeground(new Color(255, 102, 0));
		panelInfoLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		panelInfoLbl.setBounds(33, 137, 353, 31);
		contentPanel.add(panelInfoLbl);
		{
			sartuIzenaTF = new JTextField();
			sartuIzenaTF.setToolTipText("");
			sartuIzenaTF.setBorder(null);
			sartuIzenaTF.setForeground(Color.LIGHT_GRAY);
			sartuIzenaTF.setColumns(10);
			sartuIzenaTF.setBounds(391, 229, 164, 31);
			sartuIzenaTF.setVisible(false);
			contentPanel.add(sartuIzenaTF);
		}
		contentPanel.add(getGehituBtn());
		{
			JButton kenduBtn = new JButton("-");
			kenduBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gehituKendu = false;
					sartuIzenaLbl.setVisible(true);
					sartuIzenaTF.setVisible(true);
					sartuIzenaSep.setVisible(true);
					sartuJokalarikopLbl.setVisible(false);
					sartuJokalarikopTF.setVisible(false);
					sartuJokalariKopSep.setVisible(false);
					enterBtn.setVisible(true);
				}
			});
			kenduBtn.setForeground(new Color(255, 102, 0));
			kenduBtn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 26));
			kenduBtn.setBackground(Color.WHITE);
			kenduBtn.setBounds(478, 118, 65, 50);
			contentPanel.add(kenduBtn);
		}
		contentPanel.add(getKodeaLbl());
		contentPanel.add(getIzenaLbl());
		contentPanel.add(getJokalarikopLbl());
		contentPanel.add(getIrabazleaLbl());
		contentPanel.add(getSartuIzenaLbl());
		contentPanel.add(getSartuJokalarikopTF());
		contentPanel.add(getSartuJokalarikopLbl());
		contentPanel.add(getEnterBtn());
		try {
			bideojokoakBistaratu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(33, 239, 325, 194);
		}
		return textArea;
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
					sartuIzenaLbl.setVisible(true);
					sartuIzenaTF.setVisible(true);
					sartuIzenaSep.setVisible(true);
					sartuJokalarikopLbl.setVisible(true);
					sartuJokalarikopTF.setVisible(true);
					sartuJokalariKopSep.setVisible(true);
					enterBtn.setVisible(true);
					textArea.setText(null);
				}
			});
			gehituBtn.setForeground(new Color(255, 102, 0));
			gehituBtn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 23));
			gehituBtn.setBackground(Color.WHITE);
			gehituBtn.setBounds(391, 118, 65, 50);
		}
		return gehituBtn;
	}
	private JLabel getKodeaLbl() {
		if (KodeaLbl == null) {
			KodeaLbl = new JLabel("Kodea");
			KodeaLbl.setForeground(new Color(255, 102, 0));
			KodeaLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
			KodeaLbl.setBounds(33, 214, 46, 14);
		}
		return KodeaLbl;
	}
	private JLabel getIzenaLbl() {
		if (IzenaLbl == null) {
			IzenaLbl = new JLabel("Izena");
			IzenaLbl.setForeground(new Color(255, 102, 0));
			IzenaLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
			IzenaLbl.setBounds(122, 214, 46, 14);
		}
		return IzenaLbl;
	}
	private JLabel getJokalarikopLbl() {
		if (JokalarikopLbl == null) {
			JokalarikopLbl = new JLabel("Jokalari kop.");
			JokalarikopLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
			JokalarikopLbl.setForeground(new Color(255, 102, 0));
			JokalarikopLbl.setBounds(209, 214, 93, 14);
		}
		return JokalarikopLbl;
	}
	private JLabel getIrabazleaLbl() {
		if (IrabazleaLbl == null) {
			IrabazleaLbl = new JLabel("Irabazlea");
			IrabazleaLbl.setForeground(new Color(255, 102, 0));
			IrabazleaLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
			IrabazleaLbl.setBounds(298, 214, 46, 14);
		}
		return IrabazleaLbl;
	}
	private JLabel getSartuIzenaLbl() {
		if (sartuIzenaLbl == null) {
			sartuIzenaLbl = new JLabel("Izena:");
			sartuIzenaLbl.setForeground(new Color(255, 102, 0));
			sartuIzenaLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			sartuIzenaLbl.setBounds(391, 189, 164, 31);
			sartuIzenaLbl.setVisible(false);
		}
		return sartuIzenaLbl;
	}
	private JTextField getSartuJokalarikopTF() {
		if (sartuJokalarikopTF == null) {
			sartuJokalarikopTF = new JTextField();
			sartuJokalarikopTF.setToolTipText("");
			sartuJokalarikopTF.setForeground(Color.LIGHT_GRAY);
			sartuJokalarikopTF.setColumns(10);
			sartuJokalarikopTF.setBorder(null);
			sartuJokalarikopTF.setBounds(391, 327, 164, 31);
			sartuJokalarikopTF.setVisible(false);
		}
		return sartuJokalarikopTF;
	}
	private JSeparator getSartuJokalariKopSep() {
		if (sartuJokalariKopSep == null) {
			sartuJokalariKopSep = new JSeparator();
			sartuJokalariKopSep.setBackground(Color.BLACK);
			sartuJokalariKopSep.setBounds(391, 356, 164, 16);
			sartuJokalariKopSep.setVisible(false);
		}
		return sartuJokalariKopSep;
	}
	private JLabel getSartuJokalarikopLbl() {
		if (sartuJokalarikopLbl == null) {
			sartuJokalarikopLbl = new JLabel("Jokalari kopurua:");
			sartuJokalarikopLbl.setForeground(new Color(255, 102, 0));
			sartuJokalarikopLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			sartuJokalarikopLbl.setBounds(391, 287, 164, 31);
			sartuJokalarikopLbl.setVisible(false);
		}
		return sartuJokalarikopLbl;
	}
	private JButton getEnterBtn() {
		if (enterBtn == null) {
			enterBtn = new JButton("");
			enterBtn.setBorder(null);
			enterBtn.setIcon(new ImageIcon(bideojokoakGehituKendu.class.getResource("/images/Enter_ON.png")));
			enterBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(gehituKendu) {
							bideojokoaSartu();
							bideojokoakBistaratu();	
						}
						else {
							bideojokoaKendu();
							textArea.setText(null);
							bideojokoakBistaratu();
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
			enterBtn.setBounds(391, 383, 155, 50);
		}
		return enterBtn;
	}
//	private void bideojokoKodeakEguneratu() throws SQLException{
//		String kontsulta = "SELECT * FROM bideojoko";
//		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
//	}
	
////////////ES PARA ACTUALIZAR LOS "KODE" CUANDO BORRAS ALGUNO QUE NO SEA EL ÚLTIMO
	private void bideojokoakBistaratu() throws SQLException {
		String kontsulta = "SELECT * FROM bideojoko";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);

		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			bideojokoInfo = rs.getString("kodea");
			textArea.append(bideojokoInfo);
			textArea.append("\t");

			bideojokoInfo = rs.getString("izena");
			textArea.append(bideojokoInfo);
			textArea.append("\t");
			
			bideojokoInfo = rs.getString("jokalarikop");
			textArea.append(bideojokoInfo);
			textArea.append("\t");
	
			bideojokoInfo = rs.getString("irabazlea")+"\n";
			textArea.append(bideojokoInfo);
		}
	}
	private void bideojokoaSartu() throws SQLException {
		String kontsulta = "INSERT INTO bideojoko values (?, ?, ?, null)";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, bideojokoKodea.toString());
		bideojokoKodea++;
		pStatement.setString(2, sartuIzenaTF.getText());
		pStatement.setString(3, sartuJokalarikopTF.getText());
		pStatement.executeUpdate();
	}
	
	private void bideojokoaKendu() throws SQLException {
		String kontsulta = "DELETE FROM bideojoko WHERE izena = ?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, sartuIzenaTF.getText());
		pStatement.executeUpdate();
		//ACTUALIZAR LOS KODE;
	}
}
