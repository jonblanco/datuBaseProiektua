import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Label;

public class IrabaziKopAldatu extends JFrame {

	private JPanel contentPane;
	private JSeparator separator;
	private JTextField textField;
	private JLabel lblImglog;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private Label TaldeIzenaLbl;
	private JLabel lblImglog_1;
	private JLabel lblImglog_2;
	private JLabel IrabaziKopLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IrabaziKopAldatu frame = new IrabaziKopAldatu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IrabaziKopAldatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 270);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.TaldeIzenaLbl = new Label("New label");
			this.TaldeIzenaLbl.setBackground(new Color(255, 255, 255));
			this.TaldeIzenaLbl.setBounds(47, 131, 62, 22);
			this.contentPane.add(this.TaldeIzenaLbl);
		}
		{
			this.separator = new JSeparator();
			this.separator.setBackground(Color.BLACK);
			this.separator.setBounds(82, 76, 175, 16);
			this.contentPane.add(this.separator);
		}
		{
			this.textField = new JTextField();
			this.textField.setToolTipText("");
			this.textField.setForeground(Color.LIGHT_GRAY);
			this.textField.setColumns(10);
			this.textField.setBorder(null);
			this.textField.setBounds(82, 44, 175, 31);
			this.contentPane.add(this.textField);
		}
		{
			this.lblImglog = new JLabel("");
			this.lblImglog.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/shield_2.png")));
			this.lblImglog.setBounds(43, 44, 32, 39);
			this.contentPane.add(this.lblImglog);
		}
		{
			this.lblNewLabel = new JLabel("Talde baek duen irabazi kopurua eguneratu");
			this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.lblNewLabel.setForeground(new Color(255, 69, 0));
			this.lblNewLabel.setBounds(10, 11, 296, 14);
			this.contentPane.add(this.lblNewLabel);
		}
		{
			this.lblNewLabel_1 = new JLabel("TaldeTxikiaren izena");
			this.lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 12));
			this.lblNewLabel_1.setForeground(new Color(255, 69, 0));
			this.lblNewLabel_1.setBounds(81, 79, 283, 14);
			this.contentPane.add(this.lblNewLabel_1);
		}
		{
			this.btnNewButton = new JButton("");
			this.btnNewButton.setBackground(new Color(255, 255, 255));
			this.btnNewButton.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/icons8_Search_32px_2.png")));
			this.btnNewButton.setSelectedIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/boton+1.png")));
			this.btnNewButton.setBounds(264, 50, 25, 25);
			this.contentPane.add(this.btnNewButton);
		}
		{
			this.lblImglog_1 = new JLabel("");
			this.lblImglog_1.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/shield_2.png")));
			this.lblImglog_1.setBounds(10, 123, 32, 39);
			this.contentPane.add(this.lblImglog_1);
		}
		{
			this.lblImglog_2 = new JLabel("");
			this.lblImglog_2.setIcon(new ImageIcon(IrabaziKopAldatu.class.getResource("/images/medallaNaranja32.png")));
			this.lblImglog_2.setBounds(10, 163, 32, 39);
			this.contentPane.add(this.lblImglog_2);
		}
		{
			this.IrabaziKopLbl = new JLabel("New label");
			this.IrabaziKopLbl.setBounds(47, 174, 46, 14);
			this.contentPane.add(this.IrabaziKopLbl);
		}
	}
}
