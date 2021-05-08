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
public class bilatuBideojokoPartaideak extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField talIzenaTxt;
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
			bilatuBideojokoPartaideak dialog = new bilatuBideojokoPartaideak();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public bilatuBideojokoPartaideak() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(bilatuBideojokoPartaideak.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Jokalari bat bilatu");
		
		setBounds(100, 100, 408, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Sartu bideojokoaren izena");
			lblNewLabel.setForeground(new Color(255, 102, 0));
			lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			lblNewLabel.setBounds(86, 131, 223, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			talIzenaTxt = new JTextField();
			talIzenaTxt.setForeground(Color.LIGHT_GRAY);
			talIzenaTxt.setBorder(null);
			talIzenaTxt.setToolTipText("");
			talIzenaTxt.setBounds(102, 163, 175, 31);
			contentPanel.add(talIzenaTxt);
			talIzenaTxt.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(bilatuBideojokoPartaideak.class.getResource("/images/consola.png")));
			label.setBounds(140, 28, 96, 85);
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("");
			okButton.setBorder(null);
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(140, 366, 107, 63);
			contentPanel.add(okButton);
			okButton.setIcon(new ImageIcon(bilatuBideojokoPartaideak.class.getResource("/images/Enter_ON.png")));
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
			cancelButton.setIcon(new ImageIcon(bilatuBideojokoPartaideak.class.getResource("/images/eraser_1.png")));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					talIzenaTxt.setText(null);
					
				}
			});
			cancelButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
			cancelButton.setActionCommand("Cancel");
		}
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(102, 194, 175, 16);
		contentPanel.add(separator);
		{
			JLabel lblImglog = new JLabel("");
			lblImglog.setIcon(new ImageIcon(bilatuBideojokoPartaideak.class.getResource("/images/icons8_Search_32px.png")));
			lblImglog.setBounds(60, 163, 32, 39);
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
			btnNewButton.setIcon(new ImageIcon(bilatuBideojokoPartaideak.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 362, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextArea());
		this.scrollPane = new JScrollPane(this.textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setSize(372, 131);
		scrollPane.setLocation(10, 221);
		contentPanel.add(this.scrollPane);
		scrollPane.setColumnHeaderView(getLblIzenaHerrialdeaTaldea());
	}
	protected void bilatuBideojokokoPartaideak() throws SQLException {
		String izena= this.talIzenaTxt.getText();
		String kontsulta = "SELECT taldeizena, ekikolorea, taldetxikiizena, entrenatzailea"
				+ " FROM (TALDE_TXIKI TT INNER JOIN BIDEOJOKO B ON TT.kodebideojoko=B.kodea AND "
				+ " TT.jokalarikop=B.jokalarikop) INNER JOIN TALDE T ON TT.taldeizena=T.izena"
				+ " WHERE B.izena=?";
		//LIKE ?
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, izena);
		ResultSet rs = null;
		ResultSet rKontsultaHutsa = pStatement.executeQuery(); 
		textArea.setText("");
		talIzenaTxt.setText("");
		if(!rKontsultaHutsa.next()) {
			ErroreMezuEdit em=new ErroreMezuEdit("Bilatu duzun bideojokoa ez dago datu-basean sartuta!!");
			em.setVisible(true);
		}
		else {
			rs = pStatement.executeQuery();
			while(rs.next()) {
				talInfo= rs.getString("taldeizena");
				textArea.append(talInfo);
				textArea.append("\t");
				talInfo= rs.getString("ekikolorea");
				textArea.append(talInfo);
				textArea.append("\t");
	
				talInfo= rs.getString("taldetxikiizena");
				textArea.append(talInfo);
				textArea.append("\t");
				talInfo= rs.getString("entrenatzailea")+"\n";
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
			lblIzenaHerrialdeaTaldea = new JLabel("Taldea                  Kolorea                TTxikia                  Entrenatzailea ");
			lblIzenaHerrialdeaTaldea.setForeground(new Color(255, 102, 0));
			lblIzenaHerrialdeaTaldea.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		}
		return lblIzenaHerrialdeaTaldea;
	}
}
