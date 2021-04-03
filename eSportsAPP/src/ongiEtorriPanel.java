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
public class ongiEtorriPanel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ongiEtorriPanel dialog = new ongiEtorriPanel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ongiEtorriPanel() {
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
			JLabel lblNewLabel = new JLabel("Ongi etorri eSportsAPP-era!");
			lblNewLabel.setForeground(new Color(255, 102, 0));
			lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
			lblNewLabel.setBounds(53, 175, 299, 85);
			contentPanel.add(lblNewLabel);
		}
		contentPanel.add(getPasswordField());
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(ongiEtorriPanel.class.getResource("/images/logo.png")));
			label.setBounds(98, 62, 128, 85);
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("");
			okButton.setBorder(null);
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(110, 326, 107, 63);
			contentPanel.add(okButton);
			okButton.setIcon(new ImageIcon(ongiEtorriPanel.class.getResource("/images/Enter_ON.png")));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						hasierakoPanela hPan=new hasierakoPanela();
						hPan.setVisible(true);
						setVisible(false);
					
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
			cancelButton.setIcon(new ImageIcon(ongiEtorriPanel.class.getResource("/images/icons8_Multiply_32px.png")));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			cancelButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
			cancelButton.setActionCommand("Cancel");
		}
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
