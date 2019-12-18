package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.services.MagazzinoServices;
import common.interfaces.IMagazzinoServices;
import common.javabeans.Magazzino;
import common.utils.Utils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MagazzinoFrame2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultTableModel modelTable;
	IMagazzinoServices imf = new MagazzinoServices();
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;

	public void clearFields() {
		textField.setText(null);
		textField_1.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
	}

	public void controlloScorteAttuali(int idProdotto, int scorteDaSottrarre) {

		Magazzino m = new Magazzino(idOfTable(table));
		int livelloScorte = imf.controlloScorte(m);
		int livelloMinimoScorte = imf.livelloScorteMinime(m);
		if ((scorteDaSottrarre > livelloMinimoScorte)) {
			JOptionPane.showMessageDialog(null,
					"WARNING: si sta tentando di sottrarre scorte superiori alla soglia minima");
		} else if ((livelloScorte - scorteDaSottrarre) < livelloMinimoScorte) {
			Magazzino mDecrease = new Magazzino(idOfTable(table), scorteDaSottrarre);
			imf.decreaseScorte(mDecrease);
			JOptionPane.showMessageDialog(null, "Scorte sotto la soglia minima. Aggiungere scorte");
		} else {
			Magazzino mDecrease = new Magazzino(idOfTable(table), scorteDaSottrarre);
			imf.decreaseScorte(mDecrease);
			JOptionPane.showMessageDialog(null, "Scorte sottratte");

		}

	}

	public int idOfTable(JTable table) {

		int row = table.getSelectedRow();
		String rowString = table.getValueAt(row, 0).toString();
		int numberOfTheRow = Integer.parseInt(rowString);

		return numberOfTheRow;

	}

	public Object[][] rows() {

		MagazzinoServices service = new MagazzinoServices();
		List<Magazzino> l = service.listaMagazzino();

		Object[][] rows = (Object[][]) new Object[l.size()][4];

		for (int i = 0; i < l.size(); i++) {
			Magazzino m = l.get(i);
			rows[i][0] = m.getId();
			rows[i][1] = m.getNomeProdotto();
			rows[i][2] = m.getDescrizione();
			rows[i][3] = m.getLivelloScorte();
		}
		return rows;

	}

	public String[] columns() {

		// colonne
		String[] colonne = new String[] { "id", "Nome Prodotto", "Descrizione", "Livello Scorte" };
		return colonne;

	}

	// Create the frame.

	public MagazzinoFrame2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 25, 352, 353);
		contentPane.add(scrollPane);

		@SuppressWarnings("rawtypes")
		final Class[] columnClass = new Class[] { Integer.class, String.class, String.class, Integer.class };

		table = Utils.createTable(columns(), rows(), columnClass);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				textField.setText(table.getValueAt(row, 1).toString());
				textField_1.setText(table.getValueAt(row, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		modelTable = (DefaultTableModel) table.getModel();

		JLabel lblNewLabel = new JLabel("Nome Prodotto");
		lblNewLabel.setBounds(17, 101, 106, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Descrizione");
		lblNewLabel_1.setBounds(17, 157, 98, 16);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(116, 96, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(121, 152, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(138, 394, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(419, 394, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnInsert = new JButton("Insert new Product");
		btnInsert.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				InsertNewProduct frameM3 = new InsertNewProduct();
				frameM3.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent windowEvent) {

						if (JOptionPane.showConfirmDialog(frameM3, "Chiudere questa finestra?", "Close Window?",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

							modelTable.setDataVector(rows(), columns());
							modelTable.fireTableDataChanged();
							frameM3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

						} else {
							frameM3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						}
					}
				});
				frameM3.setVisible(true);
			}
		});
		btnInsert.setBounds(17, 266, 184, 29);
		contentPane.add(btnInsert);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row >= 0) {
					Magazzino mU = new Magazzino(idOfTable(table), textField.getText(), textField_1.getText());
					imf.updateMagazzino(mU);
					JOptionPane.showMessageDialog(null, "Prodotto e Descrizione aggiornate");
					modelTable.setDataVector(rows(), columns());
					modelTable.fireTableDataChanged();
				} else {
					JOptionPane.showMessageDialog(null, "Seleziona una riga");
				}

			}
		});
		btnUpdate.setBounds(27, 307, 117, 29);
		contentPane.add(btnUpdate);

// cancella la riga selezionata

		JButton btnDelete = new JButton("Delete Selected Product");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Magazzino mD = new Magazzino(idOfTable(table));
				imf.deleteMagazzino(mD);
				JOptionPane.showMessageDialog(null, "Prodotto cancellato");
				modelTable.setDataVector(rows(), columns());
				modelTable.fireTableDataChanged();

			}
		});
		btnDelete.setBounds(27, 353, 174, 29);
		contentPane.add(btnDelete);

		JButton btnNewButton = new JButton("Increase Scorte");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int addThisScorte = Integer.parseInt(textField_3.getText());

				Magazzino mIncrease = new Magazzino(idOfTable(table), addThisScorte);
				imf.increaseScorte(mIncrease);

				clearFields();
				modelTable.setDataVector(rows(), columns());
				modelTable.fireTableDataChanged();

			}
		});
		btnNewButton.setBounds(6, 394, 128, 28);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Decrease Scorte");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int subtractThisScorte = Integer.parseInt(textField_4.getText());

				controlloScorteAttuali(idOfTable(table), subtractThisScorte);

				clearFields();
				modelTable.setDataVector(rows(), columns());
				modelTable.fireTableDataChanged();

			}
		});
		btnNewButton_1.setBounds(280, 394, 127, 29);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnNewButton_2.setBounds(17, 18, 117, 29);
		contentPane.add(btnNewButton_2);

	}
}