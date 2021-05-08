import java.awt.BorderLayout;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JTextArea;
//
public class hilabetekoLehiaketakBilatu extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField hilaIzenaTxt;
	private JTextArea textArea;
	private Connection konexioa;
	private String talInfo;
	private JScrollPane scrollPane;
	private JLabel lblIzenaHerrialdeaTaldea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			hilabetekoLehiaketakBilatu dialog = new hilabetekoLehiaketakBilatu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public hilabetekoLehiaketakBilatu() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(hilabetekoLehiaketakBilatu.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Hilabeteko lehiaketak bilatu");
		
		setBounds(100, 100, 498, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Sartu hilabetea");
			lblNewLabel.setForeground(new Color(255, 102, 0));
			lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			lblNewLabel.setBounds(171, 125, 124, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			hilaIzenaTxt = new JTextField();
			hilaIzenaTxt.setForeground(Color.LIGHT_GRAY);
			hilaIzenaTxt.setBorder(null);
			hilaIzenaTxt.setToolTipText("");
			hilaIzenaTxt.setBounds(145, 157, 175, 31);
			contentPanel.add(hilaIzenaTxt);
			hilaIzenaTxt.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(hilabetekoLehiaketakBilatu.class.getResource("/images/icons8_Today_96px.png")));
			label.setBounds(183, 22, 96, 85);
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("");
			okButton.setBorder(null);
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(180, 362, 107, 63);
			contentPanel.add(okButton);
			okButton.setIcon(new ImageIcon(hilabetekoLehiaketakBilatu.class.getResource("/images/Enter_ON.png")));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							bilatuBideojokokoPartaideak();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
				
					}
				}
			);
			okButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 10));
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("");
			cancelButton.setBorder(null);
			cancelButton.setBounds(10, 11, 44, 39);
			contentPanel.add(cancelButton);
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setForeground(new Color(0, 0, 0));
			cancelButton.setIcon(new ImageIcon(hilabetekoLehiaketakBilatu.class.getResource("/images/eraser_1.png")));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					hilaIzenaTxt.setText(null);
					
				}
			});
			cancelButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
			cancelButton.setActionCommand("Cancel");
		}
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(145, 188, 175, 16);
		contentPanel.add(separator);
		{
			JLabel lblImglog = new JLabel("");
			lblImglog.setIcon(new ImageIcon(hilabetekoLehiaketakBilatu.class.getResource("/images/icons8_Search_32px.png")));
			lblImglog.setBounds(103, 157, 32, 39);
			contentPanel.add(lblImglog);
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
			btnNewButton.setIcon(new ImageIcon(hilabetekoLehiaketakBilatu.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 362, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextArea());
		this.scrollPane = new JScrollPane(this.textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setSize(431, 131);
		scrollPane.setLocation(27, 215);
		contentPanel.add(this.scrollPane);
		scrollPane.setColumnHeaderView(getLblIzenaHerrialdeaTaldea());
	}
	protected void bilatuBideojokokoPartaideak() throws SQLException {
		String izena = this.hilaIzenaTxt.getText();
		Integer hilaInteger = 0;
		
		if(izena.toLowerCase().equals("urtarrila")) {
			hilaInteger = 1;
		}
		else if(izena.toLowerCase().equals("otsaila")) {
			hilaInteger = 2;
		}
		else if(izena.toLowerCase().equals("martxoa")) {
			hilaInteger = 3;
		}
		else if(izena.toLowerCase().equals("apirila")) {
			hilaInteger = 4;
		}
		else if(izena.toLowerCase().equals("maiatza")) {
			hilaInteger = 5;
		}
		else if(izena.toLowerCase().equals("ekaina")) {
			hilaInteger = 6;
		}
		else if(izena.toLowerCase().equals("uztaila")) {
			hilaInteger = 7;
		}
		else if(izena.toLowerCase().equals("abuztua")) {
			hilaInteger = 8;
		}
		else if(izena.toLowerCase().equals("iraila")) {
			hilaInteger = 9;
		}
		else if(izena.toLowerCase().equals("urria")) {
			hilaInteger = 10;
		}
		else if(izena.toLowerCase().equals("azaroa")) {
			hilaInteger = 11;
		}
		else if(izena.toLowerCase().equals("abendua")) {
			hilaInteger = 12;
		}
		
		String dataLike = "";
		if(hilaInteger < 10) {
			dataLike = "2021-0" + hilaInteger.toString() + "-__"; 
		}
		else {
			dataLike = "2021-" + hilaInteger.toString() + "-__"; 
		}
		String kontsulta = "SELECT * FROM bideojoko"
				+ " WHERE hurrengoLehiaketa LIKE ? ";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, dataLike);
		ResultSet rs = null;
		ResultSet rKontsultaHutsa = pStatement.executeQuery(); 
		textArea.setText("");
		hilaIzenaTxt.setText("");
		if(!rKontsultaHutsa.next()) {
			ErroreMezuEdit em=new ErroreMezuEdit("Hilabete horretan ez dago leihaketerik !!");
			em.setVisible(true);
		}
		else {
			rs = pStatement.executeQuery();
			while(rs.next()) {
				talInfo= rs.getString("kodea");
				textArea.append(talInfo);
				textArea.append("\t");
				
				talInfo= rs.getString("izena");
				textArea.append(talInfo);
				textArea.append("\t");

				talInfo= rs.getString("jokalarikop");
				textArea.append(talInfo);
				textArea.append("\t");
				
				talInfo= rs.getString("irabazlea");
				textArea.append(talInfo);
				textArea.append("\t");
				
				talInfo= rs.getString("hurrengoLehiaketa")+"\n";
				textArea.append(talInfo);
			}
		}
				
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setBounds(58, 251, 209, 94);
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
	private JLabel getLblIzenaHerrialdeaTaldea() {
		if (lblIzenaHerrialdeaTaldea == null) {
			lblIzenaHerrialdeaTaldea = new JLabel("Kodea                  Izena                      Jokalarikop         Irabazlea             Hur. Lehiaketa");
			lblIzenaHerrialdeaTaldea.setForeground(new Color(255, 102, 0));
			lblIzenaHerrialdeaTaldea.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		}
		return lblIzenaHerrialdeaTaldea;
	}
}
