package _LABORATORIO;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;

/* Con esta clase es posible implementar, de una manera mas completa y eficiente, los metodos
 * necesarios para crear un modelo de tabla.
 * Para crear un modelo de tabla personalizado, lo primero que necesitamos es extender la clase
 * AbstractTableModel.
 */

public class ATM extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private JFrame ventana;

	public ATM() {
		ventana = new JFrame();
		ventana.setTitle("AbstractTableModel");
		ventana.setDefaultCloseOperation(3);
		ventana.setBounds(100, 100, 395, 316);
		ventana.setResizable(false);
		ventana.getContentPane().setLayout(null);
		initialize();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	private void initialize() {

	}

	/* Con la implementacion de los metodos anteriores, las celdas de la tabla NO seran editables y NO se podran modificar
	 * los valores de cada una de ellas. Si deseamos tener un mecanismo para modificar los valores de las celdas de la
	 * tabla, tenemos que sobrescribir el metodo setValueAt de la clase AbstractTableModel. */

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return null;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// creo un nuevo objeto de la clase
			new ATM();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
