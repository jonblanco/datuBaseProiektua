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
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private Label TaldeIzenaLbl;
	private JLabel lblImglog_1;
	private JLabel lblImglog_2;
	private JLabel IrabaziKopLbl;
	private Connection konexioa;

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
	protected void bilatuJok() throws SQLException {
		String izena= this.TaldeTxikiTF.getText();
		this.TaldeIzenaLbl.setText(izena);
		String kontsulta = "SELECT IRABAZIKOP FROM TALDE_TXIKI WHERE talde_txiki.taldetxikiizena=?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, izena);
		ResultSet rs=pStatement.executeQuery();
		String irabaziKop="";
		if(rs.next()) {
			irabaziKop=rs.getString("IrabaziKop");
		}
		
		this.IrabaziKopLbl.setText(irabaziKop);
		String izenalike= "%"+izena+"%";
		pStatement.setString(1, izenalike);
	}
	public IrabaziKopAldatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 270);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.TaldeIzenaLbl = new Label("New label");
			this.TaldeIzenaLbl.setBackground(new Color(255, 255, 255));
			this.TaldeIzenaLbl.setBounds(47, 131, 62, 22);
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
			this.lblImglog.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/shield_2.png")));
			this.lblImglog.setBounds(43, 44, 32, 39);
			this.contentPane.add(this.lblImglog);
		}
		{
			this.lblNewLabel = new JLabel("Talde baek duen irabazi kopurua eguneratu");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.lblNewLabel.setForeground(new Color(255, 69, 0));
			this.lblNewLabel.setBounds(10, 11, 296, 14);
			this.contentPane.add(this.lblNewLabel);
		}
		{
			this.lblNewLabel_1 = new JLabel("TaldeTxikiaren izena");
			this.lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 12));
			this.lblNewLabel_1.setForeground(new Color(255, 69, 0));
			this.lblNewLabel_1.setBounds(81, 79, 283, 14);
			this.contentPane.add(this.lblNewLabel_1);
		}
		{
			this.btnNewButton = new JButton("");
			this.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					konektatu();
					
					
					
				}
			});
			this.btnNewButton.setBackground(new Color(255, 255, 255));
			this.btnNewButton.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/icons8_Search_32px_2.png")));
			this.btnNewButton.setSelectedIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/boton+1.png")));
			this.btnNewButton.setBounds(264, 44, 42, 31);
			this.contentPane.add(this.btnNewButton);
		}
		{
			this.lblImglog_1 = new JLabel("");
			this.lblImglog_1.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/shield_2.png")));
			this.lblImglog_1.setBounds(10, 123, 32, 39);
			this.contentPane.add(this.lblImglog_1);
		}
		{
			this.lblImglog_2 = new JLabel("");
			this.lblImglog_2.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/medallaNaranja32.png")));
			this.lblImglog_2.setBounds(10, 163, 32, 39);
			this.contentPane.add(this.lblImglog_2);
		}
		{
			this.IrabaziKopLbl = new JLabel("New label");
			this.IrabaziKopLbl.setBounds(47, 174, 46, 14);
			this.contentPane.add(this.IrabaziKopLbl);
		}
		
		
	}
	
	
}
