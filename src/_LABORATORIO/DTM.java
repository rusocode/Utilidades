package _LABORATORIO;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class DTM {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Marco().setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}
}

class Marco extends JFrame {

	private static final long serialVersionUID = 1L;

	public Marco() {

		setFrameProperties();

	}

	private void setFrameProperties() {

		setTitle("DefaultTableModel");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLayout(null);

		add(new Lamina());

	}

}

/**
 * Los modelos de tabla son objetos que implementan la interface TableModel a traves de ellos es posible personalizar
 * mucho mas y mejorar el comportamiento de los componentes JTable, permitiendo utilizar al maximo sus potencialidades.
 * 
 * Todas las tablas cuentan con un modelo de tabla, la clase AbstractTableModel es la que implementa directamente a la
 * interface TableModel, aunque es esta clase la que se recomienda extender para utilizarla como modelo de tabla, existe
 * un modelo de tabla predeterminado que facilita mucho el trabajo con tablas. Este modelo predeterminado es la clase
 * DefaultTableModel.
 * 
 * Como te podras dar cuenta, al ejecutar los ejemplos 2 y 3, una de las desventajas de no manejar de manera directa un
 * modelo de tabla a sido superada; ya es posible agregar directamente valores a las celdas de la tabla. Sin embargo,
 * las celdas siguen siendo editables, y sus valores siguen siendo tratados aun como cadenas. Cuando utilices el modelo
 * de tabla DefaultTableModel debes tener en cuenta que: este utiliza una matriz para almacenar los valores de las
 * celdas de la tabla, tiene un desempe�o inferior al de un modelo de tabla personalizado, debido a que sus metodos
 * estan sincronizados y que ademas en la documentacion oficial, se menciona que la serializacion de objetos que realiza
 * esta clase no sera compatible con entregas futuras de Swing. Asi, aunque la utilizacion del modelo de tabla
 * DefaultTableModel es aun funcional y proporciona facilidades para la utilizacion de un modelo de tabla, es mucho mas
 * recomendable, por cuestiones de desempeño y personalizacion, utilizar la clase AbstractTableModel.
 */
class Lamina extends JPanel {

	private JPanel panel;

	// Titulos de las columnas
	private String[] columnNames = { "Nombre", "Apellido", "Pasatiempo", "Años de practica", "Soltero(a)" };

	// Matriz de objetos con los datos de la tabla
	private Object[][] data = { { "Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false) },
			{ "Lhucas", "Huml", "Patinar", new Integer(3), new Boolean(true) },
			{ "Kathya", "Walrath", "Escalar", new Integer(2), new Boolean(false) },
			{ "Marcus", "Andrews", "Correr", new Integer(7), new Boolean(true) },
			{ "Angela", "Lalth", "Nadar", new Integer(4), new Boolean(false) } };

	private DefaultTableModel modelo;
	private JTable tabla;
	private JScrollPane scroll;

	public Lamina() {

		panel = new JPanel();

		// Crea el modelo con los datos anteriores.
		modelo = new DefaultTableModel(data, columnNames);

		// Crea la tabla con el modelo.
		tabla = new JTable(modelo);

		scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 60, 512, 106);

		panel.add(scroll);

		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));

	}

}
