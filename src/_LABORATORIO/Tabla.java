package _LABORATORIO;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Tabla extends JFrame {

	private static final long serialVersionUID = -76073673560246156L;

	private String[] columnas = { "Nombre", "Edad" };
	private Object[][] valores = { { "Juan", new Integer(25) }, { "Fede", new Integer(22) }, { "Celia", new Integer(80) } };

	private JPanel panel;

	private JTable tabla;
	private JScrollPane scroll;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		new Tabla().setVisible(true);
	}

	public Tabla() {
		setFrameProperties();
		makeGUI();

		mostrarDatos(tabla);
	}

	private void mostrarDatos(JTable tabla) {
		int numeroFilas = tabla.getRowCount();
		int numeroColumnas = tabla.getColumnCount();

		System.out.println("Valor de los datos: ");
		for (int i = 0; i < numeroFilas; i++) {
			System.out.print("    fila " + i + ":");
			for (int j = 0; j < numeroColumnas; j++)
				System.out.print("  " + tabla.getValueAt(i, j));
			System.out.println();
		}

		System.out.println("--------------------------");
	}

	private void setFrameProperties() {
		setSize(391, 171);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Devuelve el objeto contentPane para este marco
		// System.out.println(this.getContentPane());

	}

	private void makeGUI() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		/* JTable -> VISTA TableModel -> MODELO
		 * 
		 * PREGUNTA: ¿Podemos obtener los valores de la tabla tanto desde la vista como desde el modelo?
		 * 
		 * RESPUESTA: Se puede obtener un valor del modelo de la tabla o la propia instancia de JTable; El resultado final es el
		 * mismo. JTable getValueAt y los metodos relacionados simplemente invocan el mismo metodo en el objeto del modelo de
		 * tabla interno. */

		// Crea una tabla y se le pasa como argumento los valores para cada celda y las columnas
		tabla = new JTable(valores, columnas);

		// Cabecera ---
		JTableHeader cabecera = tabla.getTableHeader();

		/* El metodo getTableHeader() devuelve un objeto de tipo JTableHeader, es decir, el encabezado de la tabla. Una vez
		 * devuelto el encabezado de la tabla, se llama al metodo setReorderingAllowed() para establecer si el usuario puede o
		 * no arrastrar el encabezado de la columna. */
		cabecera.setReorderingAllowed(false);

		// Establece si el usuario puede cambiar el tamaño de las columnas arrastrandolas entre los encabezados
		cabecera.setResizingAllowed(false);

		cabecera.setOpaque(false);
		// ---

		// Tabla ---
		// tabla.setPreferredScrollableViewportSize(new Dimension(100,50));

		/* Cuando esta propiedad es true, usa la altura completa del contenedor, incluso si la tabla no tiene suficientes filas
		 * para usar todo el espacio vertical. Esto facilita el uso de la tabla como un objetivo de arrastrar y soltar. */
		tabla.setFillsViewportHeight(true);

		// Devuelve el numero de columnas
		// System.out.println(tabla.getColumnCount());

		// Devulve el numero de filas
		// System.out.println(tabla.getRowCount());

		// Los metodos para el menejo de datos dentro de la tabla son getValueAt() y setValueAt()
		// Devuelve el valor de la celda en fila y columna
		// System.out.println(tabla.getValueAt(0, 1));

		/* Tanto los modelos de seleccion de fila como de columna para JTable usan de manera predeterminada un
		 * DefaultListSelectionModel para que JTable funcione de la misma manera que la JList. Consulte el metodo
		 * setSelectionMode en JList para obtener detalles sobre los modos.
		 * 
		 * Modo 0/SINGLE_SELECTION: selecciona un indice de lista a la vez. Modo 1/SINGLE_INTERVAL_SELECTION: selecciona un
		 * rango contiguo de indices a la vez. Modo 2/MULTIPLE_INTERVAL_SELECTION (predeterminado): selecciona uno o mas rangos
		 * contiguos de indices a la vez. */
		tabla.setSelectionMode(2);

		// Establece si se pueden seleccionar las filas
		// tabla.setRowSelectionAllowed(true);

		// Establece si se pueden seleccionar las columnas
		// tabla.setColumnSelectionAllowed(true);

		// Establece la seleccion simultanea de filas y columnas
		// tabla.setCellSelectionEnabled(true); // > equivalente > tabla.setRowSelectionAllowed(true) &&
		// tabla.setColumnSelectionAllowed(true)

		// tabla.getCellSelectionEnabled();

		// Selecciona todas las filas, columnas y celdas de la tabla
		// tabla.selectAll();

		// Deselecciona todas las columnas y filas seleccionadas
		// tabla.clearSelection();

		// tabla.getColumnModel().getColumn(0).setPreferredWiqadth(5);
		// ---
		panel.add(tabla, BorderLayout.CENTER);

		// Crea un panel de desplazamiento que sirve como contenedor para la tabla
		scroll = new JScrollPane(tabla);
		// Asegurara que el espacio para el componente de esquina siempre exista
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// scroll.getViewport().setBackground(SystemColor.menu);
		panel.add(scroll);

		/* JFrame#add basicamente llama a JFrame#getContentPane().add(), por lo que es solo una forma abreviada.
		 * 
		 * Ahora, cuando comenta la linea setContentPane, JFrame usa un BorderLayout de forma predeterminada, el boton ahora se
		 * coloca en la posicion CENTRAL del panel de contenido (predeterminado del marco) y llena todo el espacio
		 * disponible. */

		// getContentPane().add(panel);
		setContentPane(panel);

	}

}

class MiModelo extends DefaultTableModel {

}
