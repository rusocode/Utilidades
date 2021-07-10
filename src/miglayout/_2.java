package miglayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class _2 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel1, panel2;

	public _2() {

		super("MigLayout");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
	}

	private void initialize() {

		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);

		panel1 = new JPanel();
		panel1.setLayout(new MigLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("sizegroup"));

		/* sg/sizegroup [nombre]: Da a la fila un nombre de grupo de tamaño. Todas las filas que comparten un nombre de grupo de
		 * tamaño obtendran el mismo tamaño que la fila con el tamaño minimo/preferido mas grande. Esto es mas util cuando el
		 * tamaño de la fila no se establece explicitamente y, por lo tanto, esta determinado por el componente mas grande que
		 * es la fila (s). Se puede usar un nombre vacio "" a menos que haya mas de un grupo. Ejemplo: "sg" o "sg grp1" o
		 * "sizegroup props".
		 * 
		 * split: Divide la celda en varias subceldas. Practicamente esto significa que los siguientes componentes del numero de
		 * conteo se colocaran en la misma celda, uno al lado del otro sin espacios. Solo el primer componente de una celda
		 * puede establecer la division, se ignoraran las palabras clave de division posteriores en la celda. El conteo
		 * predeterminado es infinito si no se especifica, lo que significa que dividir solo colocara todos los componentes que
		 * vienen en la misma celda. "split", "wrap" o "newline" saldran de la celda dividida. Los dos ultimos se moveran a una
		 * nueva fila/columna como de costumbre. Nota! "skip" se omitira si se divide y continuara en la siguiente celda.
		 * Ejemplo: "split" o "split 4".
		 * 
		 * flowy: Pone el diseño en modo de flujo vertical. Esto significa que la siguiente celda esta normalmente debajo y el
		 * siguiente componente se colocara alli en lugar de a la derecha. El valor predeterminado es flujo horizontal.
		 * 
		 * flowx: Pone el diseño en modo de flujo horizontal.
		 * 
		 * skip: Omite varias celdas en el flujo. Esto se utiliza para saltar varias celdas antes de buscar la siguiente celda
		 * libre. El salto se realiza antes de que este componente se coloque en una celda y, por lo tanto, esta celda se ve
		 * afectada por el. "count" el valor predeterminado es 1 si no se especifica. Ejemplo: "skip" o "skip 3".
		 * 
		 * Nota: "wrap", "newline", "skip", "span" y "split" controlan el flujo de la cuadricula. */

		panel1.add(new JButton("Boton - sg 1"), "sg 1, split 3, flowy");
		panel1.add(new JButton("sg 1"), "sg 1");
		panel1.add(new JButton("sg 1"), "sg 1"); // Obtiene el tamaño del componente mas grande que se encuentre en el mismo grupo (sizegroup)
		panel1.add(new JButton("ASD"), "sg 1, skip 1");
		panel1.add(new JButton("btn4"), "growy"); // Este componente no pertenece al grupo "sg 1" por lo tanto su tamaño es por defecto

		add(panel1);

		panel2 = new JPanel();
		panel2.setLayout(new MigLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("cell"));

		/* Si no desea utilizar la forma de "flujo" para colocar componentes en posiciones de cuadricula, puede utilizar
		 * cordenadas absolutas. */
		panel2.add(new JButton("btn 1"), "cell 0 0"); // cell columna 0 fila 0
		panel2.add(new JButton("btn 2"), "cell 1 0");
		panel2.add(new JButton("btn 3"), "cell 0 1");
		panel2.add(new JButton("btn 4"), "cell 1 1");
		/* Tambien se puede usar la forma de celda absoluta para ocupar y fusionar celdas. Si un componente se coloca en una
		 * celda que ya tiene un componente, entonces se fusionara y ambos componentes terminaran en la misma celda compartiendo
		 * su espacio (la celda que "decide" fusionar es la celda "padre"). */
		panel2.add(new JButton("btn 5"), "cell 0 2 2 1"); // Para este componente se especifica un ancho de dos celdas y alto de una celda (= span)

		add(panel2);

		pack();
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new _2().setVisible(true);
	}

}
