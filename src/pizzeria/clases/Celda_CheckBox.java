package pizzeria.clases;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class Celda_CheckBox extends DefaultCellEditor implements TableCellRenderer {
	private static final long serialVersionUID = 1L;
	private JComponent component = new JCheckBox();
	private boolean value = false; // valor de la celda

	public Celda_CheckBox() {
		super(new JCheckBox());
	}

	// devuelve un componente
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		if (value == null)
			return null;
		return ((JCheckBox) component);
	}

	// devuelve el valor de la celda
	@Override
	public Object getCellEditorValue() {
		return ((JCheckBox) component).isSelected();
	}

	// segun el valor de la celda selecciona/deseleciona el JCheckBox
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// color de fondo en modo edicion
		((JCheckBox) component).setBackground(new Color(102, 153, 255)); // 200, 200, 0
		// obtiene el valor de celda y lo coloca en el JCheckBox
		boolean b = ((Boolean) value).booleanValue();
		((JCheckBox) component).setSelected(b);
		return ((JCheckBox) component);
	}

	// cuando termina la manipulacion de la celda
	@Override
	public boolean stopCellEditing() {
		value = ((Boolean) getCellEditorValue()).booleanValue();
		((JCheckBox) component).setSelected(value);
		return super.stopCellEditing();
	}

}