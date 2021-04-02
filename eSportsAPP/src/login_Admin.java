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
//
public class login_Admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			login_Admin dialog = new login_Admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public login_Admin() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Hasiera panela");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Izena");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 15));
			lblNewLabel.setBounds(82, 89, 107, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(151, 89, 213, 31);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Pasahitza");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 15));
			lblNewLabel_1.setBounds(82, 131, 87, 37);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBounds(5, 194, 421, 63);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String pasahitza= "is2021";
						if (passwordField.getText().equals(pasahitza)) {
						 lab_GUI ktrl_panela= new lab_GUI();
						 setVisible(false);
						 
						 ktrl_panela.main(null);
						}else {
							JOptionPane.showMessageDialog(null, "Pasahitza txarto dago!");
							passwordField.setText(null);
							passwordField.requestFocus();
						}
					}
				});
				okButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 10));
				okButton.setBounds(154, 5, 47, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText(null);
						passwordField.setText(null);
					}
				});
				cancelButton.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
				cancelButton.setBounds(211, 5, 65, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contentPanel.add(getPasswordField());
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setEchoChar('*');
			passwordField.setBounds(151, 131, 213, 29);
		}
		return passwordField;
	}
}
