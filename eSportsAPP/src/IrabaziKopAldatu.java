import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class IrabaziKopAldatu extends JFrame {

	private JPanel contentPane;
	private JSeparator separator;
	private JTextField TaldeTxikiTF;
	private JLabel lblImglog;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private Label TaldeIzenaLbl;
	private JLabel lblImglog_1;
	private JLabel lblImglog_2;
	private JLabel IrabaziKopLbl;
	private Connection konexioa;
	private JLabel lblNewLabel_2;
	private JLabel TaldeIzena;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IrabaziKopAldatu frame = new IrabaziKopAldatu();
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
	protected void bilatuTaldeTxikia() throws SQLException {
		String izena= this.TaldeTxikiTF.getText();
		this.TaldeIzenaLbl.setText(izena);
		String kontsulta = "SELECT IRABAZIKOP,taldeizena FROM TALDE_TXIKI WHERE talde_txiki.taldetxikiizena=?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, izena);
		ResultSet rs=pStatement.executeQuery();
		String irabaziKop="";
		String taldeIzena="";
		if(rs.next()) {
			irabaziKop=rs.getString("IrabaziKop");
			taldeIzena=rs.getString("taldeizena");
		}
		
		this.IrabaziKopLbl.setText(irabaziKop);
		this.TaldeIzena.setText(taldeIzena);
		
	}
	
	protected void gehituBat() throws SQLException {
		String izena= this.TaldeTxikiTF.getText();
		String kontsulta = "UPDATE talde_txiki SET irabazikop=irabazikop+1 WHERE talde_txiki.taldetxikiizena=?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, izena);
		pStatement.executeUpdate();
		bilatuTaldeTxikia();
	}
	
	protected void kenduBat() throws SQLException {
		String izena= this.TaldeTxikiTF.getText();
		String kontsulta = "UPDATE talde_txiki SET irabazikop=irabazikop-1 WHERE talde_txiki.taldetxikiizena=?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, izena);
		pStatement.executeUpdate();
		bilatuTaldeTxikia();
	}
	public IrabaziKopAldatu() {
		konektatu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 270);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.TaldeIzenaLbl = new Label("");
			this.TaldeIzenaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			this.TaldeIzenaLbl.setBackground(new Color(255, 255, 255));
			this.TaldeIzenaLbl.setBounds(154, 142, 62, 22);
			this.contentPane.add(this.TaldeIzenaLbl);
		}
		{
			this.separator = new JSeparator();
			this.separator.setBackground(Color.BLACK);
			this.separator.setBounds(82, 76, 175, 16);
			this.contentPane.add(this.separator);
		}
		{
			this.TaldeTxikiTF = new JTextField();
			this.TaldeTxikiTF.setToolTipText("");
			this.TaldeTxikiTF.setForeground(Color.LIGHT_GRAY);
			this.TaldeTxikiTF.setColumns(10);
			this.TaldeTxikiTF.setBorder(null);
			this.TaldeTxikiTF.setBounds(82, 44, 175, 31);
			this.contentPane.add(this.TaldeTxikiTF);
		}
		{
			this.lblImglog = new JLabel("");
			this.lblImglog.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/equipo32.png")));
			this.lblImglog.setBounds(43, 44, 32, 39);
			this.contentPane.add(this.lblImglog);
		}
		{
			this.lblNewLabel = new JLabel("Talde_txiki batek duen irabazi kopurua eguneratu");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			this.lblNewLabel.setForeground(new Color(255, 69, 0));
			this.lblNewLabel.setBounds(10, 11, 296, 24);
			this.contentPane.add(this.lblNewLabel);
		}
		{
			this.btnNewButton = new JButton("");
			this.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						bilatuTaldeTxikia();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			this.btnNewButton.setBackground(new Color(255, 255, 255));
			this.btnNewButton.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/icons8_Search_32px_2.png")));
			this.btnNewButton.setSelectedIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/boton+1.png")));
			this.btnNewButton.setBounds(267, 44, 42, 31);
			this.contentPane.add(this.btnNewButton);
		}
		{
			this.lblImglog_1 = new JLabel("");
			this.lblImglog_1.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/shield_2.png")));
			this.lblImglog_1.setBounds(111, 103, 32, 32);
			this.contentPane.add(this.lblImglog_1);
		}
		{
			this.lblImglog_2 = new JLabel("");
			this.lblImglog_2.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/medallaNaranja32.png")));
			this.lblImglog_2.setBounds(111, 171, 32, 39);
			this.contentPane.add(this.lblImglog_2);
		}
		{
			this.IrabaziKopLbl = new JLabel("");
			this.IrabaziKopLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			this.IrabaziKopLbl.setBounds(152, 178, 80, 26);
			this.contentPane.add(this.IrabaziKopLbl);
		}
		{
			this.lblNewLabel_2 = new JLabel("");
			this.lblNewLabel_2.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/equipo32.png")));
			this.lblNewLabel_2.setBounds(111, 137, 32, 32);
			this.contentPane.add(this.lblNewLabel_2);
		}
		{
			this.TaldeIzena = new JLabel("");
			this.TaldeIzena.setBounds(154, 111, 78, 20);
			this.contentPane.add(this.TaldeIzena);
		}
		{
			this.btnNewButton_1 = new JButton("");
			this.btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					eragiketakAdmin ea= eragiketakAdmin.getNireEragiketakAdmin();
					ea.setVisible(true);
				}
			});
			this.btnNewButton_1.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/icons8_Back_64px.png")));
			this.btnNewButton_1.setBorder(null);
			this.btnNewButton_1.setBackground(Color.WHITE);
			this.btnNewButton_1.setBounds(10, 147, 52, 73);
			this.contentPane.add(this.btnNewButton_1);
		}
		{
			this.btnNewButton_2 = new JButton("");
			this.btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						gehituBat();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			this.btnNewButton_2.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/boton+1.png")));
			this.btnNewButton_2.setBounds(279, 113, 32, 32);
			this.contentPane.add(this.btnNewButton_2);
		}
		{
			this.btnNewButton_3 = new JButton("");
			this.btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						kenduBat();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			this.btnNewButton_3.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/boton-1.png")));
			this.btnNewButton_3.setBounds(278, 155, 32, 32);
			this.contentPane.add(this.btnNewButton_3);
		}
		setLocationRelativeTo(null);
		
		
	}
	
	
}
