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
//
public class adminGuztiakIkusi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;
	private BufferedReader br;
	private Connection konexioa;
	private String usersinfo;
	private JLabel lblIzenak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			adminGuztiakIkusi dialog = new adminGuztiakIkusi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public adminGuztiakIkusi() {
		setTitle("Administratzaileak ikusi");
		konektatu();
		
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminGuztiakIkusi.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		
		setBounds(100, 100, 318, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(adminGuztiakIkusi.class.getResource("/images/icons8_Maintenance_96px.png")));
			label.setBounds(98, 11, 96, 104);
			contentPanel.add(label);
		}
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					login_Admin lA = new login_Admin();
					lA.setVisible(true);
				}
			});
			btnNewButton.setIcon(new ImageIcon(adminGuztiakIkusi.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 346, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextArea());
		contentPanel.add(getLblIzenak());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(54, 144, 195, 189);
		contentPanel.add(panel);
		try {
			adminGuztiakKontsultatu();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			textArea.setForeground(new Color(255, 255, 255));
			textArea.setBackground(new Color(255, 127, 80));
			textArea.setEditable(false);
			textArea.setBounds(72, 155, 157, 167);
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
	private JLabel getLblIzenak() {
		if (lblIzenak == null) {
			lblIzenak = new JLabel("Administratzailea");
			lblIzenak.setForeground(new Color(255, 102, 0));
			lblIzenak.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			lblIzenak.setBounds(54, 113, 150, 31);
		}
		return lblIzenak;
	}
	
	private void adminGuztiakKontsultatu() throws SQLException {
		String kontsulta = "SELECT user FROM ADMINISTRATZAILEAK";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);

		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("user"));
			usersinfo= rs.getString("user")+"\n";
			textArea.append(usersinfo); //esto da error, lo tengo que mirar
		}
}
}