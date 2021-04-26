import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ErroreMezuEdit extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMezuEditagarria = new JLabel(pMezua);
		lblMezuEditagarria.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMezuEditagarria.setBounds(61, 42, 363, 103);
		contentPane.add(lblMezuEditagarria);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ErroreMezuEdit.class.getResource("/images/icons8_Multiply_32px.png")));
		label.setBounds(10, 65, 96, 61);
		contentPane.add(label);
	}

	
}
