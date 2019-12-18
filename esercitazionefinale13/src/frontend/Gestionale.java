package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import backend.services.UserServices;
import common.interfaces.IUserServices;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gestionale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestionale frame = new Gestionale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public Gestionale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(128, 52, 61, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(128, 90, 61, 16);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(213, 47, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public String char2string(char[] passwordInserita) {
				String passwordString = new String(passwordInserita);
				return passwordString;
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				String passwordFornita = char2string(passwordField.getPassword());

				IUserServices U = new UserServices();

				boolean controllo = U.login(textField.getText(), passwordFornita);
				if (controllo) {
					MagazzinoFrame2 frameM2 = new MagazzinoFrame2();
					frameM2.setVisible(true);
					textField.setText("");
					passwordField.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "Accesso negato");
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		btnNewButton.setBounds(83, 156, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		btnNewButton_1.setBounds(235, 156, 117, 29);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("SignUp");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SignUp.SignUpScreen();
			}
		});
		btnNewButton_2.setBounds(151, 208, 117, 29);
		contentPane.add(btnNewButton_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(213, 85, 130, 26);
		contentPane.add(passwordField);
	}
}
