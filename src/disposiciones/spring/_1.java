package disposiciones.spring;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Un ejemplo de la clase Spring se puede visualizar como un resorte mecánico que proporciona una fuerza correctiva a medida
 * que el resorte se comprime o se estira de su valor preferido. Esta fuerza se modela como función lineal de la distancia del
 * valor preferido, pero con dos constantes diferentes: una para la fuerza de compresión y otra para la de tensión. Esas constantes
 * se especifican por los valores mínimo y máximo del muelle de modo que un muelle en su valor mínimo produce una fuerza igual y
 * opuesta a la que se crea cuando está en su valor máximo. La diferencia entre los valores preferidos y mínimos, por lo tanto,
 * representa la facilidad con la que se puede comprimir el resorte y la diferencia entre sus valores máximo y preferido, indica
 * la facilidad con la que se puede extender el resorte.
 */

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);
	}

}

class Marco extends JFrame {

	public Marco() {
		setFrameProperties();
		makeGUI();

	}

	private void setFrameProperties() {
		setTitle("Resortes");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
	}

	private void makeGUI() {
		add(new Lamina());
	}

}

class Lamina extends JPanel {

	private JButton btn1, btn2, btn3;

	private Spring resorte_flexible, resorte_rigido;
	private SpringLayout springLayout;

	public Lamina() {

		btn1 = new JButton("Boton 1");
		btn2 = new JButton("Boton 2");
		btn3 = new JButton("Boton 3");

		springLayout = new SpringLayout();

		// Agrega el SpringLayout a la lamina.
		setLayout(springLayout);

		add(btn1);
		add(btn2);
		add(btn3);

		resorte_flexible = Spring.constant(0, 10, 100); // Valor minimo, por defecto y maximo.
		resorte_rigido = Spring.constant(10); // Distancia con 10 pixeles de ancho.

		/* Primer y segundo argumento (punto inicial): El resorte empieza desde el borde izquierdo (SpringLayout.WEST) del primer componente (btn1).
		 * Tercer argumento: Resorte (spring) con sus caracteristicas.
		 * Cuarto argumento (destino): El resorte tiene que ir hasta el borde izquierdo (SpringLayout.WEST) del contenedor (this). */
		springLayout.putConstraint(SpringLayout.WEST, btn1, resorte_flexible, SpringLayout.WEST, this);

		// Resortes internos.
		springLayout.putConstraint(SpringLayout.WEST, btn2, resorte_rigido, SpringLayout.EAST, btn1); // El resorte tiene que ir desde el borde izquierdo del segundo componente hasta el borde derecho del primer componente.
		springLayout.putConstraint(SpringLayout.WEST, btn3, resorte_rigido, SpringLayout.EAST, btn2);

		springLayout.putConstraint(SpringLayout.EAST, this, resorte_flexible, SpringLayout.EAST, btn3);

	}
}
