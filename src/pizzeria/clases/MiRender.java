package pizzeria.clases;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class MiRender extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	// y el constructor?

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// para posicionar los valores de la celda
		// cell.setHorizontalAlignment(CENTER);
		// creo un borde para cada celda
		// setBorder(new LineBorder(new Color(0, 0, 0)));

		// if (value instanceof Integer) {
		// if (column == 0) {
		// if (isSelected) {
		// cell.setBackground(Color.CYAN);
		// }
		//
		// }
		// }

		// si se selecciono la fila
		if (isSelected) {
			cell.setBackground(new Color(102, 153, 255)); // celeste claro: 102, 153, 255 ; celeste mediano: 51, 102, 204
			cell.setForeground(Color.WHITE);

		} else {
			cell.setBackground(Color.WHITE);
			cell.setForeground(Color.BLACK);
		}

		// // si el valor instanciado es de tipo entero
		// if (value instanceof Integer) {
		// // si el valor de la celda es menor igual a 2 y la columna es igual a 0
		// if (((Integer) value <= 3 && column == 0)) {
		// // si se selecciono la fila n de la columna 0
		// if (isSelected) {
		// cell.setBackground(new Color(192, 192, 192));
		// cell.setFont(new Font("Tahoma", Font.BOLD, 12));
		// }
		// }
		// }

		// le paso el espacio interno de cada celda cuando selecciono una fila
		// tabla.setIntercellSpacing(new Dimension(1, 1));
		// seleccionar solo la celda
		// tabla.setCellSelectionEnabled(false); <-- dejarlo comentado porque no se selecciona la fila
		// tabla.setSurrendersFocusOnKeystroke(true);
		// muestra un icono que no permite mover las filas
		// tabla.setDragEnabled(true);

		return cell;
	}

}
