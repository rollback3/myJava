package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.services.UserServices;
import common.interfaces.IUserServices;
import common.javabeans.Utente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	public void clearFields() {

		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		passwordField.setText("");
	}

	public boolean isValidated() {

		boolean campiCompilati = true;
		if (textField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'nome' vuoto");
			campiCompilati = false;
		} else if (textField_1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'cognonome' vuoto");
			campiCompilati = false;
		} else if (textField_2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'via' vuoto");
			campiCompilati = false;
		} else if (textField_3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'email' vuoto");
			campiCompilati = false;
		} else if (textField_4.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'userName' vuoto");
			campiCompilati = false;
		} else if ((String.valueOf(passwordField.getPassword())).equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'password' vuoto");
			campiCompilati = false;
		}
		return campiCompilati;

	}

	/**
	 * Launch the application.
	 */
	public static void SignUpScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		// dispose per chiudere solo il frame di signup
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, -32, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(48, 62, 61, 16);
		contentPane.add(lblNome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(48, 90, 61, 16);
		contentPane.add(lblCognome);

		JLabel lblVia = new JLabel("via");
		lblVia.setBounds(48, 118, 61, 16);
		contentPane.add(lblVia);

		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(48, 146, 61, 16);
		contentPane.add(lblEmail);

		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(48, 177, 84, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 205, 61, 16);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(152, 57, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(152, 85, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(152, 113, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(152, 141, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(152, 172, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(152, 200, 130, 26);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addMouseListener(new MouseAdapter() {

			public String char2stringSignUp(char[] passwordInserita) {
				String passwordString = new String(passwordInserita);
				return passwordString;
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				if (isValidated() == true) {

					String passwordFornitaSignUp = char2stringSignUp(passwordField.getPassword());

					Utente user = new Utente(textField.getText(), textField_1.getText(), textField_2.getText(),
							textField_3.getText(), textField_4.getText(), passwordFornitaSignUp);

					IUserServices signIn = new UserServices();

					signIn.registraUtente(user);
					JOptionPane.showMessageDialog(null, "Registrazione effettuata");
					clearFields();
				}
			}
		});
		btnNewButton.setBounds(40, 243, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnNewButton_1.setBounds(188, 243, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
