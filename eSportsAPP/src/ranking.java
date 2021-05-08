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
	private JLabel IrabaziMinLbl;
	private JTextField IrabaziMinTF;
	private JSeparator IrabaziMinSep;
	private JTextField IrabaziMaxTF;
	private JButton enterBtn;

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
			JLabel logoLbl = new JLabel("");
			logoLbl.setIcon(new ImageIcon(ranking.class.getResource("/images/trofeo.png")));
			logoLbl.setBounds(234, 7, 96, 124);
			contentPanel.add(logoLbl);
		}
		{
			JButton atzeraBtn = new JButton("");
			atzeraBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					eragiketakUser eU= new eragiketakUser();
					
					eU.setVisible(true);
				}
			});
			atzeraBtn.setIcon(new ImageIcon(ranking.class.getResource("/images/icons8_Back_64px.png")));
			atzeraBtn.setBorder(null);
			atzeraBtn.setBackground(new Color(255, 255, 255));
			atzeraBtn.setBounds(10, 7, 52, 73);
			contentPanel.add(atzeraBtn);
		}
		contentPanel.add(getTextAreaTaldeIzena());
		contentPanel.add(getTextAreaIrabaziKop());
		
		JPanel panelZenbakiak = new JPanel();
		panelZenbakiak.setForeground(new Color(255, 255, 255));
		panelZenbakiak.setBackground(new Color(255, 99, 71));
		panelZenbakiak.setBounds(49, 228, 15, 195);
		contentPanel.add(panelZenbakiak);
		FlowLayout fl_panelZenbakiak = new FlowLayout(FlowLayout.CENTER, 2, 1);
		fl_panelZenbakiak.setAlignOnBaseline(true);
		panelZenbakiak.setLayout(fl_panelZenbakiak);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("3");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("4");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("5");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("6");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("7");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("8");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("9");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("10");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("11");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		panelZenbakiak.add(lblNewLabel_12);
		
		JPanel panelTaldeLbl = new JPanel();
		panelTaldeLbl.setBackground(new Color(255, 99, 71));
		panelTaldeLbl.setBounds(74, 200, 125, 17);
		contentPanel.add(panelTaldeLbl);
		panelTaldeLbl.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Taldea");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(41, 1, 38, 14);
		panelTaldeLbl.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelIrabazikopLbl = new JPanel();
		panelIrabazikopLbl.setBackground(new Color(255, 99, 71));
		panelIrabazikopLbl.setForeground(new Color(255, 99, 71));
		panelIrabazikopLbl.setBounds(211, 200, 123, 17);
		contentPanel.add(panelIrabazikopLbl);
		panelIrabazikopLbl.setLayout(null);
		panelIrabazikopLbl.add(getLblNewLabel_3());
		
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
		contentPanel.add(getIrabaziMinLbl());
		contentPanel.add(getIrabaziMinTF());
		contentPanel.add(getIrabaziMinSep());
		
		JLabel IrabaziMaxLbl = new JLabel("Irabazi kopuru MAX");
		IrabaziMaxLbl.setForeground(new Color(255, 102, 0));
		IrabaziMaxLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		IrabaziMaxLbl.setBounds(372, 295, 147, 17);
		contentPanel.add(IrabaziMaxLbl);
		
		IrabaziMaxTF = new JTextField();
		IrabaziMaxTF.setForeground(Color.LIGHT_GRAY);
		IrabaziMaxTF.setColumns(10);
		IrabaziMaxTF.setBorder(null);
		IrabaziMaxTF.setBounds(370, 323, 147, 28);
		contentPanel.add(IrabaziMaxTF);
		
		JSeparator IrabaziMaxSep = new JSeparator();
		IrabaziMaxSep.setBackground(Color.BLACK);
		IrabaziMaxSep.setBounds(370, 351, 147, 16);
		contentPanel.add(IrabaziMaxSep);
		contentPanel.add(getEnterBtn());
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
			textAreaTaldeIzena.setBounds(74, 228, 125, 195);
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
			textAreaIrabaziKop.setBounds(209, 228, 125, 195);
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
//		MariaDB [esportsapp]> SELECT taldeizena, SUM(irabazikop)
//	    -> FROM TALDE_TXIKI
//	    -> GROUP BY taldeizena
//	    -> HAVING SUM(irabazikop) BETWEEN 40 AND 60
//	    -> ORDER BY SUM(irabazikop);
		boolean exekutaDaiteke = true;
		textAreaTaldeIzena.setText(null);
		textAreaIrabaziKop.setText(null);
		PreparedStatement pStatement = null;
		if(this.IrabaziMinTF.getText().equals("") && this.IrabaziMaxTF.getText().equals("")) {
			String kontsultaTarterikGabe = "SELECT taldeizena, SUM(irabazikop) "
					+ " FROM TALDE_TXIKI "
					+ " GROUP BY taldeizena "
					+ " ORDER BY SUM(irabazikop) DESC";
			pStatement=konexioa.prepareStatement(kontsultaTarterikGabe);
		}
		else {
			if((!this.IrabaziMinTF.getText().equals("") && this.IrabaziMaxTF.getText().equals("")) || this.IrabaziMinTF.getText().equals("") && !this.IrabaziMaxTF.getText().equals("")){
				JOptionPane.showMessageDialog(contentPanel, "Tarte bat zehazteko bi testu eremuak bete behar dira !! \n (Talde guztiak agertzeko bi eremuak hustu)");
				exekutaDaiteke = false;
			}
			else {
				String kontsultaTarteekin = "SELECT taldeizena, SUM(irabazikop)"
						+ " FROM TALDE_TXIKI"
						+ " GROUP BY taldeizena"
						+ " HAVING SUM(irabazikop) BETWEEN ? AND ?"
						+ " ORDER BY SUM(irabazikop) DESC";
				pStatement=konexioa.prepareStatement(kontsultaTarteekin);
				pStatement.setString(1, this.IrabaziMinTF.getText());
				pStatement.setString(2, this.IrabaziMaxTF.getText());
			}
		}

		if(exekutaDaiteke) {
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				String taldeIzena= rs.getString("taldeizena")+"\n";
				textAreaTaldeIzena.append(taldeIzena);
				String taldeIrabaziKop= rs.getString("SUM(irabaziKop)")+"\n";
				textAreaIrabaziKop.append(taldeIrabaziKop);
				
				
			}
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
	private JLabel getIrabaziMinLbl() {
		if (IrabaziMinLbl == null) {
			IrabaziMinLbl = new JLabel("Irabazi kopuru MIN");
			IrabaziMinLbl.setForeground(new Color(255, 102, 0));
			IrabaziMinLbl.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
			IrabaziMinLbl.setBounds(372, 212, 147, 17);
		}
		return IrabaziMinLbl;
	}
	private JTextField getIrabaziMinTF() {
		if (IrabaziMinTF == null) {
			IrabaziMinTF = new JTextField();
			IrabaziMinTF.setForeground(Color.LIGHT_GRAY);
			IrabaziMinTF.setBounds(368, 240, 147, 28);
			IrabaziMinTF.setColumns(10);
			IrabaziMinTF.setBorder(null);
		}
		return IrabaziMinTF;
	}
	private JSeparator getIrabaziMinSep() {
		if (IrabaziMinSep == null) {
			IrabaziMinSep = new JSeparator();
			IrabaziMinSep.setBackground(Color.BLACK);
			IrabaziMinSep.setBounds(368, 268, 147, 16);
		}
		return IrabaziMinSep;
	}
	private JButton getEnterBtn() {
		if (enterBtn == null) {
			enterBtn = new JButton("");
			enterBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						taldeakBistaratu();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			enterBtn.setIcon(new ImageIcon(ranking.class.getResource("/images/Enter_ON.png")));
			enterBtn.setForeground(new Color(255, 102, 0));
			enterBtn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 23));
			enterBtn.setBorder(null);
			enterBtn.setBackground(Color.WHITE);
			enterBtn.setBounds(364, 373, 155, 50);
		}
		return enterBtn;
	}
}
