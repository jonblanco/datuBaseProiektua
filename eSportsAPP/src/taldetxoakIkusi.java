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
public class taldetxoakIkusi extends JDialog {

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
			taldetxoakIkusi dialog = new taldetxoakIkusi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public taldetxoakIkusi() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(taldetxoakIkusi.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Taldetxoak ikusi");
		
		setBounds(100, 100, 581, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(taldetxoakIkusi.class.getResource("/images/equipo.png")));
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
			btnNewButton.setIcon(new ImageIcon(taldetxoakIkusi.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 11, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextArea());
		
		JLabel lblNewLabel_1_2 = new JLabel("Hona hemen talde txikiak, irabazitako lehiaketen arabera ordenatuta:");
		lblNewLabel_1_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(43, 140, 483, 14);
		contentPanel.add(lblNewLabel_1_2);
		{
			JLabel lblNewLabel_1_2_1 = new JLabel("Izena");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(70, 186, 52, 14);
			contentPanel.add(lblNewLabel_1_2_1);
		}
		{
			JLabel lblNewLabel_1_2_1 = new JLabel("Entrenatzailea");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(210, 186, 109, 14);
			contentPanel.add(lblNewLabel_1_2_1);
		}
		{
			JLabel lblNewLabel_1_2_1 = new JLabel("Irabazitako lehiaketa kopurua");
			lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			lblNewLabel_1_2_1.setBounds(344, 186, 211, 14);
			contentPanel.add(lblNewLabel_1_2_1);
		}
		
		this.scrollPane = new JScrollPane(this.textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setSize(496, 195);
		scrollPane.setLocation(34, 211);
		this.contentPanel.add(this.scrollPane);
		try {
			taldetxoakBistaratu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setBounds(20, 0, 463, 195);
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
	private void taldetxoakBistaratu() throws SQLException {
		String kontsulta = "SELECT taldetxikiizena, entrenatzailea, irabazikop, taldeizena FROM talde_txiki ORDER BY irabaziKop DESC;";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);

		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("taldetxikiizena"));
			taldeinfo= rs.getString("taldetxikiizena");
			textArea.append(taldeinfo);
			textArea.append("\t\t");

			taldeinfo= rs.getString("entrenatzailea");
			textArea.append(taldeinfo);
			textArea.append("\t\t");		
			taldeinfo= rs.getString("irabazikop")+"\n";
			textArea.append(taldeinfo);
		}
	}
}
