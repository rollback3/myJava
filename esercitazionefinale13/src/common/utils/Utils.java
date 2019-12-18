package common.utils;

import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Utils {

	public static JTable createTable(String[] columns, Object[][] data,
			@SuppressWarnings("rawtypes") final Class[] columnClass) {

		// create table model with data
		DefaultTableModel model = new DefaultTableModel(data, columns) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5652254922881408653L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnClass[columnIndex];
			}
		};

		JTable table = new JTable(model);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		return table;
	}
}