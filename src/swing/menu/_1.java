package swing.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class _1 {

	public static void main(String[] args) {
		new Marco().setVisible(true);

	}

}

class Marco extends JFrame {

	public Marco() {

		setFrameProperties();

	}

	private void setFrameProperties() {

		setTitle("Ventana");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		// Agrega el panel al marco.
		add(new Lamina());

	}
}

class Lamina extends JPanel {

	private JMenuBar barra;
	private JMenu archivo, edicion, herramientas, opciones;
	private JMenuItem guardar, guardar_como, cortar, copiar, pegar, generales, opcion1, opcion2;

	public Lamina() {

		// Barra.
		barra = new JMenuBar();

		// Menus.
		archivo = new JMenu("Archivo");
		edicion = new JMenu("Edicion");
		herramientas = new JMenu("Herramientas");
		opciones = new JMenu("Opciones");

		// Items.
		guardar = new JMenuItem("Guardar");
		guardar_como = new JMenuItem("Guardar como");

		cortar = new JMenuItem("Cortar");
		copiar = new JMenuItem("Copiar");
		pegar = new JMenuItem("Pegar");

		generales = new JMenuItem("Generales");
		opcion1 = new JMenuItem("Opcion 1");
		opcion2 = new JMenuItem("Opcion 2");

		// Agrega los items al menu.
		archivo.add(guardar);
		archivo.add(guardar_como);

		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.addSeparator(); // Linea separadora.
		edicion.add(opciones);
		opciones.add(opcion1);
		opciones.add(opcion2);

		herramientas.add(generales);

		// Agrega los menus a la barra.
		barra.add(archivo);
		barra.add(edicion);
		barra.add(herramientas);

		// Agrega la barra al panel.
		add(barra);

	}
}