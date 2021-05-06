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
import javax.swing.JScrollPane;

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
//
public class saridunakIkusi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;
	private BufferedReader br;
	private Connection konexioa;
	private String taldeinfo;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			saridunakIkusi dialog = new saridunakIkusi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public saridunakIkusi() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(saridunakIkusi.class.getResource("/images/logo.png")));
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
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(saridunakIkusi.class.getResource("/images/medallaNaranja.png")));
			label.setBounds(236, 11, 137, 124);
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
			btnNewButton.setIcon(new ImageIcon(saridunakIkusi.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 11, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextArea());
		
		JLabel lblNewLabel_1_2 = new JLabel("eSports-etan, 10 lehiaketa baino gehiago irabazi duten taldeei ");
		lblNewLabel_1_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(63, 131, 436, 31);
		contentPanel.add(lblNewLabel_1_2);
		{
			JLabel lblNewLabel_1_2_1 = new JLabel("sari bat ematen zaie ohorezko aipamen bat bezala. ");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(63, 157, 436, 31);
			contentPanel.add(lblNewLabel_1_2_1);
		}
		{
			JLabel lblNewLabel_1_2_1 = new JLabel("Hona hemen talde saridunak:");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(63, 199, 436, 31);
			contentPanel.add(lblNewLabel_1_2_1);
		}
		{
			JLabel lblNewLabel_1_2_1 = new JLabel("Taldea:");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(63, 241, 61, 31);
			contentPanel.add(lblNewLabel_1_2_1);
		}
		{
			JLabel lblNewLabel_1_2_1 = new JLabel("Irabazitako lehiaketa kopurua:");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(256, 241, 243, 31);
			contentPanel.add(lblNewLabel_1_2_1);
		}
		this.scrollPane = new JScrollPane(this.textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setSize(463, 168);
		scrollPane.setLocation(63, 267);
		this.contentPanel.add(this.scrollPane);
		
		try {
			saridunakBistaratu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setBounds(63, 267, 463, 168);
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
	private void saridunakBistaratu() throws SQLException {
		String kontsulta = "select talde.izena, talde_txiki.irabazikop from talde, talde_txiki where talde_txiki.taldeizena=talde.izena group by irabazikop having irabazikop>=10";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);

		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			taldeinfo= rs.getString("izena");
			textArea.append(taldeinfo);
			textArea.append("\t\t\t");
			taldeinfo= rs.getString("irabazikop")+"\n";
			textArea.append(taldeinfo);
		}
	}
}
