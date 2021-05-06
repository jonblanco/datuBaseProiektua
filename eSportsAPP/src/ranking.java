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
public class ranking extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaTaldeIzena;
	private BufferedReader br;
	private Connection konexioa;
	private JTextArea textAreaIrabaziKop;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ranking dialog = new ranking();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ranking() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ranking.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Ranking-a ikusi");
		
		setBounds(100, 100, 581, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(ranking.class.getResource("/images/trofeo.png")));
			label.setBounds(234, 7, 96, 124);
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
			btnNewButton.setIcon(new ImageIcon(ranking.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 7, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextAreaTaldeIzena());
		contentPanel.add(getTextAreaIrabaziKop());
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(127, 226, 15, 195);
		contentPanel.add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 2, 1);
		fl_panel.setAlignOnBaseline(true);
		panel.setLayout(fl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("3");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("4");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("5");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("6");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("7");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("8");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("9");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("10");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("11");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 99, 71));
		panel_1.setBounds(152, 198, 125, 17);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Taldea");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(41, 1, 38, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 99, 71));
		panel_2.setForeground(new Color(255, 99, 71));
		panel_2.setBounds(289, 198, 123, 17);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(getLblNewLabel_3());
		
		JLabel lblNewLabel_1_2 = new JLabel("Hona hemen talde guztien sailkapena, bideojoko guztietan");
		lblNewLabel_1_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(49, 142, 425, 17);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("lortutako irabazien arabera ordenatuta:");
		lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(49, 162, 592, 17);
		contentPanel.add(lblNewLabel_1_2_1);
		try {
			taldeakBistaratu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JTextArea getTextAreaTaldeIzena() {
		if (textAreaTaldeIzena == null) {
			textAreaTaldeIzena = new JTextArea();
			textAreaTaldeIzena.setForeground(new Color(255, 255, 255));
			textAreaTaldeIzena.setEditable(false);
			textAreaTaldeIzena.setFont(new Font("Tahoma", Font.BOLD, 12));
			textAreaTaldeIzena.setBackground(new Color(255, 99, 71));
			textAreaTaldeIzena.setBounds(152, 226, 125, 195);
		}
		return textAreaTaldeIzena;
	}
	
	private JTextArea getTextAreaIrabaziKop() {
		if (textAreaIrabaziKop == null) {
			textAreaIrabaziKop = new JTextArea();
			textAreaIrabaziKop.setForeground(new Color(255, 255, 255));
			textAreaIrabaziKop.setEditable(false);
			textAreaIrabaziKop.setFont(new Font("Tahoma", Font.BOLD, 12));
			textAreaIrabaziKop.setBackground(new Color(255, 99, 71));
			textAreaIrabaziKop.setBounds(287, 226, 125, 195);
		}
		return textAreaIrabaziKop;
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
		//String kontsulta = "select talde.izena,talde_txiki.irabazikop from talde inner join talde_txiki where talde_txiki.taldeizena=talde.izena group by talde.izena order by irabazikop DESC;";
		String kontsulta = "SELECT taldeizena, SUM(irabazikop) FROM TALDE_TXIKI GROUP BY taldeizena ORDER BY SUM(irabazikop) DESC";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);

		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			//String taldeIzena= rs.getString("izena")+"\n";
			String taldeIzena= rs.getString("taldeizena")+"\n";
			textAreaTaldeIzena.append(taldeIzena);
			//String taldeIrabaziKop= rs.getString("irabaziKop")+"\n";
			String taldeIrabaziKop= rs.getString("SUM(irabaziKop)")+"\n";
			textAreaIrabaziKop.append(taldeIrabaziKop);
			
			
		}
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("IrabaziKop");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setBounds(30, 1, 61, 14);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblNewLabel_3;
	}
}
