/* https://www.youtube.com/watch?v=vNnHhBUhnXM&index=119&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk */

package disposiciones.libre;

// Abstract Window Toolkit (AWT).

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Un componente es un objeto que tiene una representación gráfica que se puede mostrar en la pantalla y que puede interactuar
 * con el usuario. Ejemplos de componentes son los botones, casillas de verificación y barras de desplazamiento de una interfaz
 * gráfica de usuario típica.
 * La clase Component es la superclase abstracta de los componentes Abstract Window Toolkit no relacionados con el menú.
 */

public class _2 {

	public static void main(String[] args) {
		new Marco2().setVisible(true);
	}

}

class Marco2 extends JFrame {

	public Marco2() {
		setFrameProperties();
		makeGUI();

	}

	private void setFrameProperties() {
		setTitle("Ventana");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
	}

	private void makeGUI() {
		add(new Lamina2());
	}
}

class Lamina2 extends JPanel {

	private JLabel lblNombre, lblApellido, lblApodo;
	private JTextField txtNombre, txtApellido, txtApodo;

	public Lamina2() {
		setLayout(new EnColumnas());

		lblNombre = new JLabel("Nombre: ");
		lblApellido = new JLabel("Apellido: ");
		lblApodo = new JLabel("Apodo: ");

		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtApodo = new JTextField();

		add(lblNombre);
		add(txtNombre);
		add(lblApellido);
		add(txtApellido);
		add(lblApodo);
		add(txtApodo);
	}
}

// Clase propia que administra los componentes haciendo el codigo mas legible.
class EnColumnas implements LayoutManager {

	// Inicia el primer componente en x=20, y a la posicion y=20 la inicializa dentro del metodo para que los componentes no desaparescan.
	private int x = 20;

	public void addLayoutComponent(String name, Component comp) {

	}

	public void layoutContainer(Container contenedor) {

		int c = 0, y = 20;

		for (int i = 0; i < contenedor.getComponentCount(); i++) { // getComponentCount() devuelve la cantidad de componentes que hay en la lamina (contenedor).

			// Identificador de filas.
			c++;

			// Devuelve el componente del contenedor en la posicion i y lo alamcena en una variable de tipo Component.
			Component componente = contenedor.getComponent(i);

			// Agrega el componente en la posicion x e y, con un ancho de 100 pixeles y un alto de 20.
			componente.setBounds(x, y, 100, 20);

			// Incrementa la posicion de x en 100 para que el siguiente componente no se agrege encima del otro.
			x += 100;

			// Si la cantidad de componentes en una fila es par, entonces...
			if (c % 2 == 0) {
				x = 20; // Inicializa x en 20 pixeles.
				y += 40; // Aumenta y en 40 pixeles. En el primer caso seria un total de 60 pixeles (20 + 40).	
			}
		}
	}

	public Dimension minimumLayoutSize(Container parent) {

		return null;
	}

	public Dimension preferredLayoutSize(Container parent) {

		return null;
	}

	public void removeLayoutComponent(Component comp) {

	}

}
