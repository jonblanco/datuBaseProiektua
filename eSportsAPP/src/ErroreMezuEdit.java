import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErroreMezuEdit extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel ERROREA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErroreMezuEdit frame = new ErroreMezuEdit(args[1]); //IKUSTEKE
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
	
	
	public ErroreMezuEdit(String pMezua) {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		this.contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMezuEditagarria = new JLabel(pMezua);
		lblMezuEditagarria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMezuEditagarria.setBounds(61, 70, 363, 103);
		contentPane.add(lblMezuEditagarria);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ErroreMezuEdit.class.getResource("/images/icons8_Multiply_32px.png")));
		label.setBounds(10, 93, 96, 61);
		contentPane.add(label);
		{
			this.btnNewButton = new JButton("New button");
			this.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					
					
				}
			});
			this.btnNewButton.setIcon(new ImageIcon(ErroreMezuEdit.class.getResource("/images/Enter_ON.png")));
			this.btnNewButton.setBounds(162, 198, 110, 37);
			this.contentPane.add(this.btnNewButton);
		}
		{
			this.ERROREA = new JLabel("ERROREA");
			this.ERROREA.setForeground(new Color(255, 99, 71));
			this.ERROREA.setFont(new Font("Tahoma", Font.PLAIN, 32));
			this.ERROREA.setBounds(144, 11, 180, 25);
			this.contentPane.add(this.ERROREA);
		}
		setLocationRelativeTo(null);
	}
}