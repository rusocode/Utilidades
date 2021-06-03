package pizzeria.clases;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class Render_CheckBox extends JCheckBox implements TableCellRenderer {
	private static final long serialVersionUID = 1L;
	private JComponent component = new JCheckBox();

	public Render_CheckBox() {
		// para centrar la columna del JCheckBox
		setHorizontalAlignment(JLabel.CENTER);
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		// color de fondo de la celda
		((JCheckBox) component).setBackground(Color.white);
		// obtiene el valor boolean y lo coloca en el JCheckBox
		boolean b = ((Boolean) value).booleanValue();
		((JCheckBox) component).setSelected(b);
		return ((JCheckBox) component);

		// setSelected((value != null && ((Boolean) value).booleanValue()));
		// setBackground(table.getBackground());
		// setHorizontalAlignment(JLabel.CENTER);
		// return this;
	}

}
