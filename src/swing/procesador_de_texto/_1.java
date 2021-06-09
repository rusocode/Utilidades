package swing.procesador_de_texto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.StyledEditorKit;

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

		setTitle("Procesador de texto");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}

		add(new Lamina());
	}

}

class Lamina extends JPanel {

	// Nombre de las instancias de clase.
	private JPanel panel_barra_menu;
	private JTextPane area;

	private JMenuBar barra_menu;
	private JToolBar barra_herramienta;

	private JButton negrita, cursiva, subrayado, azul, rojo, a_izquierda, a_centrado, a_derecha, a_justificado;

	private JPopupMenu menu_emergente;

	private boolean es_negrita, es_cursiva; // FIXME - ¿Por que las declaro como variables de clase?

	private final String IMG = "src/img/";

	public Lamina() {

		/* Crea los componentes ---------------------------------------- */

		setLayout(new BorderLayout());

		panel_barra_menu = new JPanel();

		barra_menu = new JMenuBar();
		barra_herramienta = new JToolBar();

		area = new JTextPane();

		/* CONFIGUAR MENU - Forma 1 ------------------------------------ */

		/* JMenu fuente = new JMenu("Fuente"); configurarMenu1(fuente, "Arial"); configurarMenu1(fuente, "Courier");
		 * configurarMenu1(fuente, "Verdana");
		 * 
		 * JMenu estilo = new JMenu("Estilo"); configurarMenu1(estilo, "Negrita"); configurarMenu1(estilo, "Cursiva");
		 * 
		 * JMenu tamaño = new JMenu("Tamaño"); configurarMenu1(tamaño, "12"); configurarMenu1(tamaño, "16");
		 * configurarMenu1(tamaño, "18"); configurarMenu1(tamaño, "20"); */

		/* CONFIGUAR MENU - Forma 2 ------------------------------------ */

		// configurarMenu2();

		/* CONFIGUAR MENU - Forma 3 ------------------------------------ */

		configurarMenu3();

		/* Area de texto ------------------------------------------------ */

		area.setFont(new Font("Arial", Font.PLAIN, 12));
		// area.setComponentPopupMenu(menu_emergente); // Agrega el menu emergente al area de texto.

		/* Barra de herramientas ---------------------------------------- */

		crearBarraHerramientas();

		/* --------------------------------------------------------------- */

		panel_barra_menu.add(barra_menu);

		// Agrega los componentes al panel.
		add(panel_barra_menu, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		add(barra_herramienta, BorderLayout.WEST);

	}

	private void configurarMenu1(JMenu menu, String rotulo) {

		menu.add(new JMenuItem(rotulo)).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String fuente = area.getFont().getFontName();
				int estilo = determinarEstilo(e, area.getFont().getStyle());
				int tamano = area.getFont().getSize();

				if (rotulo == "Arial") area.setFont(new Font("Arial", estilo, tamano));
				if (rotulo == "Courier") area.setFont(new Font("Courier", estilo, tamano));
				if (rotulo == "Verdana") area.setFont(new Font("Verdana", estilo, tamano));

				if (rotulo == "Negrita") area.setFont(new Font(fuente, estilo, tamano));
				if (rotulo == "Cursiva") area.setFont(new Font(fuente, estilo, tamano));

				if (rotulo == "12") area.setFont(new Font(fuente, estilo, 12));
				if (rotulo == "16") area.setFont(new Font(fuente, estilo, 16));
				if (rotulo == "18") area.setFont(new Font(fuente, estilo, 18));
				if (rotulo == "20") area.setFont(new Font(fuente, estilo, 20));

			}

		});
		;

		barra_menu.add(menu);

	}

	private void configurarMenu2() {

		String[] textoMenu = { "Fuente", "Estilo", "Tama�o" };
		JMenu[] menu = new JMenu[textoMenu.length];

		String[][] textoItem = { { "Arial", "Courier", "Verdana" }, { "Negrita", "Cursiva" }, { "12", "16", "18", "20" } };

		/* Le sumo 1 al tamaño de la matriz textoItem por que la instruccion textoItem.length almacena el maximo desde la
		 * primera fila, osea 3 columnas, y en la ultima fila ("12", "16", "18", "20") hay 4 columnas, lo que ocasionaria un
		 * ArrayIndexOutOfBoundsException en el for. */
		JMenuItem[][] item = new JMenuItem[textoMenu.length][textoItem.length + 1];

		// EL PRIMER FOR CREA LOS MENUS Y LOS AGREGA A LA BARRA.
		for (int i = 0; i < menu.length; i++) {

			// Crea un menu con su respectivo rotulo y lo asigna al array de tipo JMenu en la posicion i.
			menu[i] = new JMenu(textoMenu[i]); // fuente = new JMenu("Fuente");

			// Agrega el menu i a la barra.
			barra_menu.add(menu[i]); // barra.add(fuente);

			// EL SEGUNDO FOR CREA LOS ITEMS, LOS AGREGA AL MENU Y LOS PONE A LA ESCUCHA DE UN EVENTO.
			// System.out.println("Cantidad de columnas para la fila " + (i + 1) + ": " + textoItem[i].length);
			for (int j = 0; j < textoItem[i].length; j++) { // textoItem[i].length calcula la cantidad de columnas para la fila i.

				// Crea un item.
				item[i][j] = new JMenuItem(textoItem[i][j]); // arial = new JMenuItem("Arial");

				// Agrega el item al menu y lo pone a la escucha de un evento.
				menu[i].add(item[i][j]).addActionListener(new ActionListener() { // fuente.add(arial);

					@Override
					public void actionPerformed(ActionEvent e) {

						String fuente = area.getFont().getFontName();
						// Almacena el tipo de estilo que devuelve el metodo.
						int estilo = determinarEstilo(e, area.getFont().getStyle());
						int tamano = area.getFont().getSize();

						if (e.getSource() == item[0][0]) area.setFont(new Font("Arial", estilo, tamano)); // Con getSource() se comparun objeto de
																											// tipo JMenuItem en la posicion [0][0]
																											// ("Arial").
						if (e.getActionCommand() == "Courier") area.setFont(new Font("Courier", estilo, tamano));
						if (e.getActionCommand() == "Verdana") area.setFont(new Font("Verdana", estilo, tamano));

						if (e.getActionCommand() == "Negrita") area.setFont(new Font(fuente, estilo, tamano));
						if (e.getActionCommand() == "Cursiva") area.setFont(new Font(fuente, estilo, tamano));

						if (e.getActionCommand() == "12") area.setFont(new Font(fuente, estilo, 12));
						if (e.getActionCommand() == "16") area.setFont(new Font(fuente, estilo, 16));
						if (e.getActionCommand() == "18") area.setFont(new Font(fuente, estilo, 18));
						if (e.getActionCommand().equals("20")) area.setFont(new Font(fuente, estilo, 20));

						// Otra forma de idetificar la seleccion del tamaño.
						/* switch (e.getActionCommand()) { case "12": case "16": case "18": case "20": area.setFont(new Font(fuente, estilo,
						 * Integer.parseInt(e.getActionCommand()))); break; } */

					}

				});

				// System.out.println("Se agrego el item " + textoItem[i][j] + " de la fila " + i + " y columna " + j + " al menu " +
				// textoMenu[i]);

			}
		}
	}

	private void configurarMenu3() {

		JMenu fuente, estilo, tamano;
		JMenuItem arial, courier, verdana, negrita, cursiva;

		// Permite seleccionar varios checks a la vez.
		JCheckBoxMenuItem negrita_check, cursiva_check;
		// Solo se puede seleccionar un radio.
		JRadioButtonMenuItem _12, _16, _18, _20;
		ButtonGroup grupo_tamano = new ButtonGroup();

		// Crea un menu emergente.
		menu_emergente = new JPopupMenu();

		// CREA LOS COMPONENTES.
		fuente = new JMenu("Fuente");
		arial = new JMenuItem("Arial");
		courier = new JMenuItem("Courier");
		verdana = new JMenuItem("Verdana");

		estilo = new JMenu("Estilo");
		negrita = new JMenuItem("Negrita", new ImageIcon("src/img/negrita.png")); // JCheckBoxMenuItem para convertilo en casilla.
		cursiva = new JMenuItem("Cursiva", new ImageIcon("src/img/cursiva.png"));
		/* Con el metodo setAccelerator asigna un atajo de teclado para el item utilizando la clase KeyStroke, en donde el
		 * metodo getKeyStroke devuelve un objeto KeyStroke para esa clave. */
		negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));

		tamano = new JMenu("Tamaño");
		_12 = new JRadioButtonMenuItem("12");
		_16 = new JRadioButtonMenuItem("16");
		_18 = new JRadioButtonMenuItem("19");
		_20 = new JRadioButtonMenuItem("20");
		tamano.add(_12);
		tamano.add(_16);
		tamano.add(_18);
		tamano.add(_20);

		// AGREGA LOS OYENTES.
		fuente.add(arial).addActionListener(new StyledEditorKit.FontFamilyAction("Fuente", "Arial"));
		fuente.add(courier).addActionListener(new StyledEditorKit.FontFamilyAction("Fuente", "Courier"));
		fuente.add(verdana).addActionListener(new StyledEditorKit.FontFamilyAction("Fuente", "Verdana"));
		barra_menu.add(fuente);

		estilo.add(negrita).addActionListener(new StyledEditorKit.BoldAction());
		estilo.add(cursiva).addActionListener(new StyledEditorKit.ItalicAction());
		barra_menu.add(estilo);

		// Crea, agrega y pone a la escucha al item del menu emergente.
		menu_emergente.add(new JMenuItem("Negrita")).addActionListener(new StyledEditorKit.BoldAction());
		menu_emergente.add(new JMenuItem("Cursiva")).addActionListener(new StyledEditorKit.ItalicAction());

		tamano.add(_12).addActionListener(new StyledEditorKit.FontSizeAction("Tamaño", 12));
		tamano.add(_16).addActionListener(new StyledEditorKit.FontSizeAction("Tamaño", 16));
		tamano.add(_18).addActionListener(new StyledEditorKit.FontSizeAction("Tamaño", 18));
		tamano.add(_20).addActionListener(new StyledEditorKit.FontSizeAction("Tamaño", 20));
		barra_menu.add(tamano);

	}

	private void crearBarraHerramientas() {
		crearBoton(IMG + "negrita.png").addActionListener(new StyledEditorKit.BoldAction());
		crearBoton(IMG + "cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		crearBoton(IMG + "subrayado.png").addActionListener(new StyledEditorKit.UnderlineAction());

		barra_herramienta.addSeparator();

		crearBoton(IMG + "azul.png").addActionListener(new StyledEditorKit.ForegroundAction("color azul", Color.BLUE)); // "color azul" es el nombre
																														// de accion.;
		crearBoton(IMG + "rojo.png").addActionListener(new StyledEditorKit.ForegroundAction("color rojo", Color.RED));

		barra_herramienta.addSeparator();

		crearBoton(IMG + "a_izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("Alinear texto a la izquierda", 0));
		crearBoton(IMG + "a_centrado.png").addActionListener(new StyledEditorKit.AlignmentAction("Centrar", 1));
		crearBoton(IMG + "a_derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("Alinear texto a la derecha", 2));
		crearBoton(IMG + "a_justificado.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificar", 3));
		barra_herramienta.setOrientation(1); // Establece la orientacion de la barra en vertical.

	}

	private JButton crearBoton(String ruta) {
		JButton boton = new JButton(new ImageIcon(ruta));
		boton.setFocusable(false);
		return (JButton) barra_herramienta.add(boton);

		// return (JButton) barra_herramienta.add(new JButton(new ImageIcon(ruta)));

		/* OBSERVACION: El metodo add de la clase ToolBar pide como argumento un objeto de tipo Action, sin embargo le pasas un
		 * objeto JButton, ¿por que?
		 * 
		 * RESPUESTA: La respuesta esta en que la clase JToolBar hereda de la clase Container el metodo add que permite como
		 * parametro un objeto de tipo Component y JButton es tambien de tipo Component por polimorfismo ya que la clase JButton
		 * es descendiente de la clase Component. */
	}

	private int determinarEstilo(ActionEvent e, int estilo) {

		if (e.getActionCommand() == "Negrita") {
			estilo = Font.BOLD; // 1
			es_negrita = true;
		}

		if (e.getActionCommand() == "Cursiva") {
			estilo = Font.ITALIC; // 2
			es_cursiva = true;
		}

		if (es_negrita && es_cursiva) {
			estilo = Font.BOLD + Font.ITALIC; // 3
		}

		// System.out.println("Estilo: " + estilo);

		return estilo;
	}

}