import java.awt.BorderLayout;
import AppPackage.AnimationClass;
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
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JTextArea;
//
public class adminBerriaGehitu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdatziHemenZure;
	private JPasswordField passwordField;
	private Connection konexioa;
	private String izena_Kontsultatuta;
	private String pasahitza_Kontsultatuta;
	private JLabel lblNewLabel_2;
	private JButton mugimenduButton;
	private JTextArea textAreaEginda;
	private String erab;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			adminBerriaGehitu dialog = new adminBerriaGehitu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public adminBerriaGehitu() {
		konektatu();
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminBerriaGehitu.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Administratzaile login-a");
		
		setBounds(100, 100, 342, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Administratzaile berriaren izena:");
			lblNewLabel.setForeground(new Color(255, 102, 0));
			lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
			lblNewLabel.setBounds(72, 131, 224, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			txtIdatziHemenZure = new JTextField();
			txtIdatziHemenZure.setForeground(Color.LIGHT_GRAY);
			txtIdatziHemenZure.setBorder(null);
			txtIdatziHemenZure.setToolTipText("");
			txtIdatziHemenZure.setBounds(72, 163, 175, 31);
			contentPanel.add(txtIdatziHemenZure);
			txtIdatziHemenZure.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Administratzaile berriaren pasahitza:");
			lblNewLabel_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(72, 221, 246, 37);
			contentPanel.add(lblNewLabel_1);
		}
		contentPanel.add(getPasswordField());
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/icons8_Maintenance_96px.png")));
			label.setBounds(110, 28, 96, 85);
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("");
			okButton.setBorder(null);
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(110, 326, 107, 63);
			contentPanel.add(okButton);
			okButton.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/Enter_ON.png")));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					try {
						kontsulta();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
			});
			okButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 10));
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("");
			cancelButton.setBorder(null);
			cancelButton.setBounds(252, 339, 44, 39);
			contentPanel.add(cancelButton);
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setForeground(new Color(0, 0, 0));
			cancelButton.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/eraser_1.png")));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtIdatziHemenZure.setText(null);
					passwordField.setText(null);
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
			JSeparator separator_1 = new JSeparator();
			separator_1.setBackground(Color.BLACK);
			separator_1.setBounds(72, 288, 175, 16);
			contentPanel.add(separator_1);
		}
		{
			JLabel lblImglog = new JLabel("");
			lblImglog.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/icons8_customer_32px_1.png")));
			lblImglog.setBounds(30, 163, 32, 39);
			contentPanel.add(lblImglog);
		}
		{
			JLabel lblPswd = new JLabel("");
			lblPswd.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/icons8_Key_32px.png")));
			lblPswd.setBounds(30, 256, 32, 41);
			contentPanel.add(lblPswd);
		}
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					eragiketakAdmin eA = eragiketakAdmin.getNireEragiketakAdmin();
					eA.setVisible(true);
				}
			});
			btnNewButton.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 362, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getMugimenduButton());
		contentPanel.add(getTextAreaEginda());
		
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setForeground(Color.LIGHT_GRAY);
			passwordField.setBorder(null);
			passwordField.setEchoChar('*');
			passwordField.setBounds(72, 256, 175, 29);
		}
		return passwordField;
	}
	private void kontsulta() throws SQLException{
		String userSartu= txtIdatziHemenZure.getText();
		String pasahitza= passwordField.getText();
		String pasahitzaHash= md5(pasahitza);
		Boolean badagoDatuBasean = konprobatuUser(userSartu);
		if (badagoDatuBasean==false) {
			String kontsulta = "INSERT INTO ADMINISTRATZAILEAK VALUES(?,?)";
			PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
			pStatement.setString(1, userSartu);
			pStatement.setString(2, pasahitzaHash);
			pStatement.executeUpdate();
			textAreaEginda.append("EGINDA!!!!");
			txtIdatziHemenZure.setText(null);
			passwordField.setText(null);
		}else {
			JOptionPane.showMessageDialog(null, "Izen hori duen beste administratzaile bat dago, saiatu berriro.");
			txtIdatziHemenZure.setText(null);
			passwordField.setText(null);
		}
	
	
	}
	
     public Boolean konprobatuUser(String pUser) throws SQLException {
    	Boolean badago=false;
		String kontsulta= "SELECT USER FROM ADMINISTRATZAILEAK WHERE USER=? ";
		PreparedStatement pStatement=konexioa.prepareStatement(kontsulta);
		pStatement.setString(1, pUser);
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
		erab= rs.getString("user");
		
		}
		if (erab==pUser) {
			badago=true;
		}
			

		return badago ;
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
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AnimationClass mugimendua = new AnimationClass();
					mugimendua.jButtonXRight(-32, 10, 10, 5, mugimenduButton);
				}
			});
			lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblNewLabel_2.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/icons8_Menu_32px_1.png")));
			lblNewLabel_2.setBounds(10, 11, 49, 49);
		}
		return lblNewLabel_2;
	}
	private JButton getMugimenduButton() {
		if (mugimenduButton == null) {
			mugimenduButton = new JButton("");
			mugimenduButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					adminGuztiakIkusi aGU= new adminGuztiakIkusi();
					aGU.setVisible(true);
				}
			});
			mugimenduButton.setBorder(null);
			mugimenduButton.setForeground(Color.WHITE);
			mugimenduButton.setBackground(Color.WHITE);
			mugimenduButton.setIcon(new ImageIcon(adminBerriaGehitu.class.getResource("/images/LupaTuerca.png")));
			mugimenduButton.setBounds(-32, 56, 32, 49);
		}
		return mugimenduButton;
	}
	
	private String md5(String input){
		//Nondik hartuta: https://www.geeksforgeeks.org/md5-hash-in-java/
		 try {

	            // Static getInstance method is called with hashing MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");

	            // digest() method is called to calculate message digest
	            //  of an input digest() return array of byte
	            byte[] messageDigest = md.digest(input.getBytes());

	            // Convert byte array into signum representation
	            BigInteger no = new BigInteger(1, messageDigest);

	            // Convert message digest into hex value
	            String hashtext = no.toString(16);
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            return hashtext;
	        } 

	        // For specifying wrong message digest algorithms
	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	}
	private JTextArea getTextAreaEginda() {
		if (textAreaEginda == null) {
			textAreaEginda = new JTextArea();
			textAreaEginda.setBounds(72, 298, 175, 31);
		}
		return textAreaEginda;
	}
}
