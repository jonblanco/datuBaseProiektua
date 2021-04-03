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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
//
public class login_User extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdatziHemenZure;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			login_User dialog = new login_User();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public login_User() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Hasiera panela");
		
		setBounds(100, 100, 342, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Izena:");
			lblNewLabel.setForeground(new Color(255, 102, 0));
			lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			lblNewLabel.setBounds(72, 131, 107, 31);
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
			JLabel lblNewLabel_1 = new JLabel("Pasahitza:");
			lblNewLabel_1.setForeground(new Color(255, 102, 0));
			lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(72, 221, 87, 37);
			contentPanel.add(lblNewLabel_1);
		}
		contentPanel.add(getPasswordField());
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(login_User.class.getResource("/images/icons8_User_96px_2.png")));
			label.setBounds(110, 28, 96, 85);
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("");
			okButton.setBorder(null);
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(110, 326, 107, 63);
			contentPanel.add(okButton);
			okButton.setIcon(new ImageIcon(login_User.class.getResource("/images/Enter_ON.png")));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String pasahitza= "admin";
					if (passwordField.getText().equals(pasahitza)) {
					// lab_GUI ktrl_panela= new lab_GUI();
					 setVisible(false);
					 
				//	 ktrl_panela.main(null);
					}else {
						JOptionPane.showMessageDialog(null, "Pasahitza txarto dago!");
						passwordField.setText(null);
						passwordField.requestFocus();
					}
				}
			});
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
			cancelButton.setIcon(new ImageIcon(login_User.class.getResource("/images/icons8_Multiply_32px.png")));
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
			lblImglog.setIcon(new ImageIcon(login_User.class.getResource("/images/icons8_customer_32px_1.png")));
			lblImglog.setBounds(30, 163, 32, 39);
			contentPanel.add(lblImglog);
		}
		{
			JLabel lblPswd = new JLabel("");
			lblPswd.setIcon(new ImageIcon(login_User.class.getResource("/images/icons8_Key_32px.png")));
			lblPswd.setBounds(30, 256, 32, 41);
			contentPanel.add(lblPswd);
		}
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				hasierakoPanela hp=new hasierakoPanela();
				hp.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(login_User.class.getResource("/images/icons8_Back_64px.png")));
		btnNewButton.setBounds(10, 362, 52, 73);
		contentPanel.add(btnNewButton);
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
}
