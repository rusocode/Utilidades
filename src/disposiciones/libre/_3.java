/* https://www.youtube.com/watch?v=VXWu2FZ2U1k&index=120&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk */
package disposiciones.libre;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class _3 {

	public static void main(String[] args) {
		new Marco3().setVisible(true);
	}

}

class Marco3 extends JFrame {

	public Marco3() {
		setFrameProperties();
		makeGUI();

	}

	private void setFrameProperties() {
		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
	}

	private void makeGUI() {
		add(new Lamina3());
	}
}

class Lamina3 extends JPanel {

	private JLabel lblNombre, lblApellido, lblApodo;
	private JTextField txtNombre, txtApellido, txtApodo;

	public Lamina3() {
		setLayout(new EnColumnas2());

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

class EnColumnas2 implements LayoutManager {

	public void addLayoutComponent(String name, Component comp) {

	}

	public void layoutContainer(Container contenedor) {

		/* Para que los componentes del marco no salgan volando hacia abajo hay que inicializar la variable y dentro del metodo
		 * en vez de fuera y asi cada vez que redimensionas se resetea a 20﻿. */

		// En x se almacena el punto central horizontalmente hablando del contenedor. Es decir que se divide el ancho del contenedor.
		int x = contenedor.getWidth() / 2, y = 20, c = 0;

		int punto_central = x;

		for (int i = 0; i < contenedor.getComponentCount(); i++) {

			c++;

			Component componente = contenedor.getComponent(i);

			// Le resta 100 pixeles (ancho del componente) para que no lo situe justo despues del punto central, y de esta manera lo coloque a la izquierda del punto central.
			componente.setBounds(x - 100, y, 100, 20);

			x += 100;

			if (c % 2 == 0) {
				x = punto_central; // Inicia x en el punto central.
				y += 40;
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
