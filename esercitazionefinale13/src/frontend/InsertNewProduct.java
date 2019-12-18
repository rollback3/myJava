package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import backend.services.MagazzinoServices;
import common.interfaces.IMagazzinoServices;
import common.javabeans.Magazzino;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertNewProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private IMagazzinoServices imf = new MagazzinoServices();
	private JTextField textField_3;

	public void clearFields() {
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
	}

	public InsertNewProduct() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProdotto = new JLabel("Prodotto");
		lblProdotto.setBounds(21, 42, 75, 16);
		contentPane.add(lblProdotto);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(21, 82, 87, 16);
		contentPane.add(lblDescrizione);

		JLabel lblScorte = new JLabel("Scorte");
		lblScorte.setBounds(21, 120, 75, 16);
		contentPane.add(lblScorte);

		textField = new JTextField();
		textField.setBounds(184, 37, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(184, 77, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(184, 115, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblLivelloMinimoScorte = new JLabel("Livello minimo scorte");
		lblLivelloMinimoScorte.setBounds(21, 163, 146, 16);
		contentPane.add(lblLivelloMinimoScorte);

		textField_3 = new JTextField();
		textField_3.setBounds(184, 153, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnInsertProduct = new JButton("Insert Product");
		btnInsertProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int livelloScorte = Integer.parseInt(textField_2.getText());
				int livelloMinScorte = Integer.parseInt(textField_3.getText());

				Magazzino mI = new Magazzino(textField.getText(), textField_1.getText(), livelloScorte,
						livelloMinScorte);
				imf.insertMagazzino(mI);
				JOptionPane.showMessageDialog(null, "Dato inserito");
				clearFields();
			}
		});
		btnInsertProduct.setBounds(31, 208, 117, 29);
		contentPane.add(btnInsertProduct);

	}
}
