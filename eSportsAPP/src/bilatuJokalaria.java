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
public class bilatuJokalaria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jokIzenaTxt;
	private JTextArea textArea;
	private Connection konexioa;
	private String jokInfo;
	private JScrollPane scrollPane;
	private JLabel lblIzenaHerrialdeaTaldea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			bilatuJokalaria dialog = new bilatuJokalaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public bilatuJokalaria() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(bilatuJokalaria.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Jokalari bat bilatu");
		
		setBounds(100, 100, 342, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Sartu jokalariaren izena");
			lblNewLabel.setForeground(new Color(255, 102, 0));
			lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			lblNewLabel.setBounds(72, 131, 223, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			jokIzenaTxt = new JTextField();
			jokIzenaTxt.setForeground(Color.LIGHT_GRAY);
			jokIzenaTxt.setBorder(null);
			jokIzenaTxt.setToolTipText("");
			jokIzenaTxt.setBounds(72, 163, 175, 31);
			contentPanel.add(jokIzenaTxt);
			jokIzenaTxt.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(bilatuJokalaria.class.getResource("/images/persona.png")));
			label.setBounds(110, 28, 96, 85);
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("");
			okButton.setBorder(null);
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(110, 356, 107, 63);
			contentPanel.add(okButton);
			okButton.setIcon(new ImageIcon(bilatuJokalaria.class.getResource("/images/Enter_ON.png")));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							bilatuJok();
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
			cancelButton.setIcon(new ImageIcon(bilatuJokalaria.class.getResource("/images/eraser_1.png")));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jokIzenaTxt.setText(null);
					
				}
			});
			cancelButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
			cancelButton.setActionCommand("Cancel");
		}
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(72, 194, 175, 16);
		contentPanel.add(separator);
		{
			JLabel lblImglog = new JLabel("");
			lblImglog.setIcon(new ImageIcon(bilatuJokalaria.class.getResource("/images/icons8_Search_32px.png")));
			lblImglog.setBounds(30, 163, 32, 39);
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
			btnNewButton.setIcon(new ImageIcon(bilatuJokalaria.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 362, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTextArea());
		this.scrollPane = new JScrollPane(this.textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//this.scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setSize(209, 114);
		scrollPane.setLocation(58, 231);
		contentPanel.add(this.scrollPane);
		scrollPane.setColumnHeaderView(getLblIzenaHerrialdeaTaldea());
	}
	protected void bilatuJok() throws SQLException {
		String izena= this.jokIzenaTxt.getText();
		String kontsulta = "SELECT * FROM JOKALARI WHERE IZENA LIKE ?";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		String izenalike= "%"+izena+"%";
		pStatement.setString(1, izenalike);
		
		ResultSet rs = pStatement.executeQuery();
		
			if(rs.next()) {
			jokInfo= rs.getString("izena");
			textArea.append(jokInfo);
			textArea.append(" ");
			textArea.append(" ");
			textArea.append(" ");
			textArea.append(" ");
			jokInfo= rs.getString("herrialdea");
			textArea.append(jokInfo);
			textArea.append(" ");
			textArea.append(" ");
			textArea.append(" ");
			textArea.append(" ");
			jokInfo= rs.getString("taldeizena")+"\n";
			textArea.append(jokInfo);
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
			lblIzenaHerrialdeaTaldea = new JLabel("Izena      Herrialdea       Taldea");
			lblIzenaHerrialdeaTaldea.setForeground(new Color(255, 102, 0));
			lblIzenaHerrialdeaTaldea.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		}
		return lblIzenaHerrialdeaTaldea;
	}
}
