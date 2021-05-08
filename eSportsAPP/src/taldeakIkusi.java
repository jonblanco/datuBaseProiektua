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
import java.awt.Canvas;
//
public class taldeakIkusi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea TaldeIzena;
	private JTextArea TTKop;
	private JTextArea BabesleKop;
	private JTextArea Ekikolorea;
	private Connection konexioa;
	private String taldeinfo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			taldeakIkusi dialog = new taldeakIkusi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public taldeakIkusi() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(taldeakIkusi.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Taldeak ikusi");
		
		setBounds(100, 100, 581, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(taldeakIkusi.class.getResource("/images/shield_1.png")));
			label.setBounds(236, 11, 96, 124);
			contentPanel.add(label);
		}
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					eragiketakUser eU= new eragiketakUser();
					
					eU.setVisible(true);
				}
			});
			btnNewButton.setIcon(new ImageIcon(taldeakIkusi.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 11, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(this.getTTKop());
		contentPanel.add(getTaldeIzena());
		contentPanel.add(this.getBabesleKop());
		contentPanel.add(this.getEkikolorea());
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(255, 99, 71));
		canvas.setBounds(157, 195, 120, 213);
		contentPanel.add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(new Color(255, 99, 71));
		canvas_1.setBounds(30, 195, 120, 213);
		contentPanel.add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(new Color(255, 99, 71));
		canvas_2.setBounds(283, 195, 120, 213);
		contentPanel.add(canvas_2);
		
		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(new Color(255, 99, 71));
		canvas_3.setBounds(408, 195, 120, 213);
		contentPanel.add(canvas_3);
		{
			this.lblNewLabel = new JLabel("Taldea");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.lblNewLabel.setForeground(new Color(255, 69, 0));
			this.lblNewLabel.setBounds(69, 175, 46, 14);
			contentPanel.add(this.lblNewLabel);
		}
		{
			this.lblNewLabel_1 = new JLabel("Kolorea");
			this.lblNewLabel_1.setForeground(new Color(255, 69, 0));
			this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.lblNewLabel_1.setBounds(191, 175, 61, 14);
			contentPanel.add(this.lblNewLabel_1);
		}
		{
			this.lblNewLabel_2 = new JLabel("Babesle Kop");
			this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.lblNewLabel_2.setForeground(new Color(255, 69, 0));
			this.lblNewLabel_2.setBounds(300, 175, 109, 14);
			contentPanel.add(this.lblNewLabel_2);
		}
		{
			this.lblNewLabel_3 = new JLabel("Talde Txiki");
			this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.lblNewLabel_3.setForeground(new Color(255, 69, 0));
			this.lblNewLabel_3.setBounds(427, 175, 109, 14);
			contentPanel.add(this.lblNewLabel_3);
		}
		try {
			taldeakBistaratu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JTextArea getTaldeIzena() {
		if (TaldeIzena == null) {
			TaldeIzena = new JTextArea();
			TaldeIzena.setEditable(false);
			TaldeIzena.setFont(new Font("Monospaced", Font.BOLD, 13));
			TaldeIzena.setForeground(new Color(255, 255, 255));
			TaldeIzena.setBackground(new Color(255, 99, 71));
			TaldeIzena.setBounds(36, 200, 109, 200);
		}
		return TaldeIzena;
	}
	
	private JTextArea getTTKop() {
		if (this.TTKop == null) {
			this.TTKop = new JTextArea();
			TTKop.setEditable(false);
			TTKop.setFont(new Font("Monospaced", Font.BOLD, 13));
			TTKop.setForeground(new Color(255, 255, 255));
			this.TTKop.setBackground(new Color(255, 99, 71));
			this.TTKop.setBounds(409, 200, 109, 203);
		}
		return this.TTKop;
	}
	
	private JTextArea getBabesleKop() {
		if (this.BabesleKop == null) {
			this.BabesleKop = new JTextArea();
			BabesleKop.setEditable(false);
			BabesleKop.setFont(new Font("Monospaced", Font.BOLD, 13));
			BabesleKop.setForeground(new Color(255, 255, 255));
			this.BabesleKop.setBackground(new Color(255, 99, 71));
			this.BabesleKop.setBounds(287, 200, 109, 203);
		}
		return this.BabesleKop;
	}
	
	private JTextArea getEkikolorea() {
		if (this.Ekikolorea == null) {
			this.Ekikolorea = new JTextArea();
			Ekikolorea.setEditable(false);
			Ekikolorea.setFont(new Font("Monospaced", Font.BOLD, 13));
			Ekikolorea.setForeground(new Color(255, 255, 255));
			this.Ekikolorea.setBackground(new Color(255, 99, 71));
			this.Ekikolorea.setBounds(159, 200, 109, 203);
		}
		return this.Ekikolorea;
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
	private void taldeakBistaratu() throws SQLException {
		String kontsulta = "SELECT T.izena, T.ekikolorea, COUNT(DISTINCT TT.taldetxikiizena), COUNT(DISTINCT izenababesle)"
				+ " FROM (TALDE_TXIKI TT INNER JOIN TALDE T ON TT.taldeizena=T.izena) INNER JOIN BABESTU B "
				+ " ON B.izenatalde=T.izena"
				+ " GROUP BY T.izena, T.ekikolorea";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);

		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			taldeinfo= rs.getString("izena")+"\n";
			TaldeIzena.append(taldeinfo);
			
			taldeinfo= rs.getString("COUNT(DISTINCT izenababesle)")+"\n";
			this.BabesleKop.append(taldeinfo);
			
			taldeinfo= rs.getString("ekikolorea")+"\n";
			this.Ekikolorea.append(taldeinfo);
			
			taldeinfo= rs.getString("COUNT(DISTINCT TT.taldetxikiizena)")+"\n";
			TTKop.append(taldeinfo);
			
		}
	}
}