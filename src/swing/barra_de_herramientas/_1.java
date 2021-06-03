package swing.barra_de_herramientas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class _1 {

	public static void main(String[] args) {
		new Marco2().setVisible(true);
	}

}

class Marco2 extends JFrame {

	private Color color;

	private JPanel lamina;
	private JMenu menu;

	// Barra de menu
	private JMenuBar barra_menu;
	// Barra de herramientas
	private JToolBar barra_herramienta;

	public Marco2() {

		setFrameProperties();

	}

	private void setFrameProperties() {
		
		// Por defecto los JFrame usan un BorderLayout por defecto

		setTitle("Marco con barra");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		// ------------------------

		lamina = new JPanel();
		barra_menu = new JMenuBar();

		// Agrega los oyentes a cada accion
		Action accionAmarillo = new Accion("Amarillo", new ImageIcon("src/img/bola_amarilla2.png"), Color.YELLOW);
		Action accionAzul = new Accion("Azul", new ImageIcon("src/img/bola_azul2.png"), Color.BLUE);
		Action accionRojo = new Accion("Rojo", new ImageIcon("src/img/bola_roja2.png"), Color.RED);

		// Para el objeto salir creo una clase interna anonima ya que agrega solo el boton, y no se le pasa un color
		Action salir = new AbstractAction("Salir", new ImageIcon("src/img/exit.png")) {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}

		};

		menu = new JMenu("Color");
		menu.add(accionAmarillo);
		menu.add(accionAzul);
		menu.add(accionRojo);
		barra_menu.add(menu);
		// Agrega la barra al marco
		setJMenuBar(barra_menu);

		add(lamina);

		// Creacion de la barra de herramientas
		barra_herramienta = new JToolBar();
		barra_herramienta.add(accionAmarillo);
		barra_herramienta.add(accionAzul);
		barra_herramienta.add(accionRojo);

		// Separador
		barra_herramienta.addSeparator();

		/* El metodo add de la clase JToolBar agrega un JButton que distribuye la accion.
		 * Recibe un objeto de tipo Accion para agregarlo como un nuevo elemento de menu, y devuelve
		 * el nuevo boton que distribuye la accion. */
		barra_herramienta.add(salir);

		// Por defecto la barra de herramientas se ubica al oeste
		add(barra_herramienta, BorderLayout.NORTH);

	}

	// AbstractAction es la clase adaptadora de la interfaz Action
	private class Accion extends AbstractAction {

		public Accion(String nombre, Icon icono, Color color) {

			// Establece los valores creados con la clave especificada
			putValue(Action.NAME, nombre); // Clave:valor
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
			// Accion
			putValue("color de fondo", color);
		}

		public void actionPerformed(ActionEvent e) {
			// Rescata del objeto del evento el valor correspondiente a una clave, el "color de fondo" se guarda como clave
			color = (Color) getValue("color de fondo");

			lamina.setBackground(color);

			// System.out
			// .println("Nombre: " + getValue(Action.NAME) + " - Descripcion: " + getValue(Action.SHORT_DESCRIPTION));

		}

	}

	
}
