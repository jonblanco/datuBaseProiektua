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
public class sorpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtrMarkelRubiosJon;
	private BufferedReader br;
	private Connection konexioa;
	private String taldeinfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			sorpresa dialog = new sorpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public sorpresa() {
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(sorpresa.class.getResource("/images/logo.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Taldeak ikusi");
		
		setBounds(100, 100, 581, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(sorpresa.class.getResource("/images/sorpresa.png")));
			label.setBounds(236, 11, 137, 124);
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
			btnNewButton.setIcon(new ImageIcon(sorpresa.class.getResource("/images/icons8_Back_64px.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(10, 253, 52, 73);
			contentPanel.add(btnNewButton);
		}
		contentPanel.add(getTxtrMarkelRubiosJon());
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 99, 71));
			panel.setBounds(215, 123, 121, 24);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("Egileak");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel.add(lblNewLabel);
			}
		}
		
	}
	private JTextArea getTxtrMarkelRubiosJon() {
		if (txtrMarkelRubiosJon == null) {
			txtrMarkelRubiosJon = new JTextArea();
			txtrMarkelRubiosJon.setEditable(false);
			txtrMarkelRubiosJon.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtrMarkelRubiosJon.setForeground(new Color(255, 255, 255));
			txtrMarkelRubiosJon.setBackground(new Color(255, 99, 71));
			txtrMarkelRubiosJon.setText("Markel Rubi\u00F1os\r\nJon Blanco\r\nIker Palacios\r\nJulen Fuentes");
			txtrMarkelRubiosJon.setBounds(215, 158, 121, 95);
		}
		return txtrMarkelRubiosJon;
	}
	
}
