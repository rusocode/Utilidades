package miglayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

// Una vez importado el JAR externo y agregado al classpath, se importa la clase a utilizar (MigLayout)
import net.miginfocom.swing.MigLayout;

public class _borrador extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

	// Componentes de la calculadora
	private JPanel panelPrincipal, panelPJ, panelNPC;
	private JLabel lblPJ, lblExpPJ;
	private JComboBox<String> cbNivel;
	private JTextField txtExpPJ;
	private JLabel lblNPC, lblExpNPC, lblVidaNPC;
	private JComboBox<String> cbNPC;
	private JTextField txtExpNPC, txtVidaNPC;

	public _borrador() {

		super("MigLayout");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
	}

	private void initialize() {

		// Usamos botones para los ejemplos
		btn1 = new JButton("comp1");
		btn2 = new JButton("comp2");
		btn3 = new JButton("comp3");
		btn4 = new JButton("comp4");
		btn5 = new JButton("comp5");
		btn6 = new JButton("comp6");
		btn7 = new JButton("comp7");
		btn8 = new JButton("comp8");

		// FIXME Agregar componentes a la cuadricula
		panel1 = new JPanel();
		panel1.setLayout(new MigLayout(/* "wrap 2" */)); // Ajusta la cuadricula con una restriccion de 2 columnas

//		panel1.add(btn1);
//		panel1.add(btn2, "wrap"); // Salta a la siguiente fila
//		panel1.add(btn3);
//		panel1.add(btn4/* , "wrap 15" */); // Salta a la siguiente fila con un espacio entra ellas de 15 pixeles

		// add(panel1);

		// FIXME Fusion y division de celdas
		panel2 = new JPanel();
		panel2.setLayout(new MigLayout());

		// SPLIT = Fusionar
//		panel2.add(btn1);
//		panel2.add(btn2, "split 2"); // Fusiona la celda en 2
//		panel2.add(btn3); // btn3 estara en la misma celda que btn2
//		panel2.add(btn4, "wrap");
//		panel2.add(btn5);

		// SPAN = Ocupar
//		panel2.add(btn1);
//		panel2.add(btn2, "span 2 2"); // btn2 ocupa 2x2 celdas
//		panel2.add(btn3, "wrap");
//		panel2.add(btn4);
//		panel2.add(btn5, "wrap");
//		panel2.add(btn6, "span"); // btn6 ocupa toda la fila
//		panel2.add(btn7, "span 2"); // btn7 ocupa 2 celdas

		// add(panel2);

		// FIXME Uso de coordenadas de celda absoluta
		panel3 = new JPanel();
		panel3.setLayout(new MigLayout());

		/* Si no desea utilizar la forma de "flujo" para colocar componentes en posiciones de cuadricula, puede utilizar
		 * cordenadas absolutas. Esto produciria la misma cuadricula que el primer ejemplo. */
//		panel3.add(btn1, "cell 0 0"); // cell columna fila
//		panel3.add(btn2, "cell 1 0");
//		panel3.add(btn3, "cell 0 1");
//		panel3.add(btn4, "cell 1 1");

		/* Tambien puede usar la forma de celda absoluta para ocupar y fusionar celdas. Si un componente se coloca en una celda
		 * que ya tiene un componente, entonces se fusionara y ambos componentes terminaran en la misma celda compartiendo su
		 * espacio (la celda que "decide" fusionar es la celda "padre"). Ejemplo: */
//		panel3.add(btn1, "cell 0 0");
//		panel3.add(btn2, "cell 1 0 2 1"); // columna fila ancho alto
//		panel3.add(btn3, "cell 3 0");
//		panel3.add(btn4, "cell 0 1 4 1"); // Ocupa toda la fila

		// add(panel3);

		// FIXME Brechas
		// Brechas de rejilla
		panel4 = new JPanel();
		/* Los tamaños de las brechas se pueden establecer en las restricciones de columnas y filas al crear el administrador de
		 * diseño, pj: . */
		// panel4.setLayout(new MigLayout("", "[][]20[]", "[]20[]"));
		/* donde la fila y columna de mayor espacio es de 20 pixeles. El espacio entre corchetes [(aqui ...)] es el lugar donde
		 * especifica la fila y el componente. */

//		panel4.add(btn1);
//		panel4.add(btn2);
//		panel4.add(btn3, "wrap");
//		panel4.add(btn4);

		// Brechas de componentes
		panel4.setLayout(new MigLayout());

//		panel4.add(btn1);
//		panel4.add(btn2, "gapleft 30"); // Agrega un espacio de 30px hacia la izquierda entre la celda y el componente
//		panel4.add(btn3, "wrap");
//		panel4.add(btn4, "gaptop 30"); // Agrega un espacio de 30px hacia arriba entre la celda y el componente
//		panel4.add(btn5, "gapright 30"); // Agrega un espacio de 30px hacia la derecha entre la celda y el componente
		// "gapbefore" ?

		// add(panel4);

		// FIXME Tamaño de componentes
		panel5 = new JPanel();
		// panel5.setLayout(new MigLayout());

		/* Los componentes tienen tamaños proporcionados por el marco GUI de alguna manera. Swing incluso tiene soporte para
		 * tamaño minimo/preferido/maximo, mientras que SWT solo tiene un tamaño preferido. Puede anular estos tamaños y para
		 * SWT incluso extiende la funcionalidad al proporcionar los tamaños en las restricciones. Los tamaños se especifican en
		 * el forma: "min:preferido:max" (ej, "10:20:40"). Un tamaño no especificado sera predeterminado para el tamaño del
		 * componente correspondiente (ej, "10::40" establecera el tamaño minimo y maximo pero conservara el tamaño preferido
		 * original). Hay muchas formas cortas de establecer los tamaños, por ejemplo, "40!" significa que los tres tamaños se
		 * estableceran en 40. Ejemplos: */

//		panel5.add(btn1, "width 10:20:40"); // 10 = tamaño minimo | 20 = tamaño preferido | 40 = tamaño maximo
//		panel5.add(btn2, "height ::40"); // Lo mismo que "hmax 40"
//		panel5.add(btn3, "w 40!"); // w = width | 40! = los 3 tamaños se estableceran en 40
//		panel5.add(btn4, "w 100!");

		// add(panel5);

		// FIXME Tama�o de filas y columnas
		/* Por defecto las filas y columnas (por ejemplo de un JPanel) toman los valores mas grandes de la columa/fila de un
		 * componente, pero tambien se puede especificar el tama�o de la columna/fila en la restriccion correspondiente,
		 * normalmente al crear el administrador de dise�a. EJ: */

//		MigLayout layout = new MigLayout("", // Layout restriccion
//				"[10][20:30:40][40!][::40]", // Columna restriccion
//				"[min!][10::20][40mm!]"); // Fila restriccion
//		
//		panel5.setLayout(layout);
//		
//		panel5.add(btn1);
//		panel5.add(btn2);
//		panel5.add(btn3);
//		panel5.add(btn4);
//
//		add(panel5);

		// FIXME Componentes de acoplamiento
		/* Puede acoplar componentes de forma muy similar a c�mo funciona BorderLayout en Swing, excepto que no est� limitado a
		 * usar solo un componente por lado y un uso predefinido de las esquinas. Los componentes de acoplamiento son siempre
		 * colocado fuera del dise�o normal. Puede mezclar componentes de rejilla y acoplamiento en el mismo dise�o. */
		panel8 = new JPanel();
		panel8.setLayout(new MigLayout());

//		panel8.add(btn1);
//		panel8.add(btn2);
//		panel8.add(btn3, "wrap");
//		panel8.add(btn4);
//		panel8.add(btn5, "dock north");
//		panel8.add(btn6, "dock west");
//		panel8.add(btn7, "dock south");
//		panel8.add(btn8, "east"); // La palabra clave "dock" es opcional

		/* Tenga en cuenta que un componente acoplado "corta" esa parte, lo que significa que el orden de los componentes
		 * acoplados es importante para como se usan las esquinas.
		 * 
		 * El acoplamiento de componentes es una forma muy buena y facil de dise�ar paneles, pero sus usos son muchos. Puedes
		 * obtener espaciado alrededor de los componentes de acoplamiento mediante el uso de espacios de componentes normales
		 * como se describe anteriormente. */

		// add(panel8);

		// FIXME Componentes que crecen y se reducen dependiendo del espacio disponible
		/* El comportamiento de crecimiento y reduccion tanto para columnas/filas como para componentes son extremadamente
		 * personalizables con MigLayout. Puede dividirlos en grupos de prioridad de crecimiento/reduccion, de modo que uno o un
		 * grupo de grupos de crecimiento/reduccion a su tama�o maximo/minimo antes de que se consideren los siguientes grupos.
		 * Tambien es posible establecer el peso de lo interesado deberian ser crecer/reducirse dentro de ese grupo prioritario.
		 * Consulte la documentacion para obtener una explicacion detallada, pero es seguro decir que no se quedara sin
		 * opciones. Los componentes y las filas/columnas se reduciran por defecto a sus tama�os minimos si el espacio es
		 * escaso. El tama�o minimo de la columna/fila es, por defecto, el tama�o minimo mas grande de sus componentes. Lo que
		 * normalmente es suficiente para saber es como hacer que un componente o fila/columna crezca y/o no permitir que
		 * encoga. Ejemplos: */
		panel9 = new JPanel();
		panel9.setLayout(new MigLayout("", "[grow][][grow]", "[][shrink 0]"));
		panel9.setLayout(new MigLayout());

		panel9.add(btn1, "growx"); // Crece horizontalmente, igual que "growx 100"
		panel9.add(btn2, "growy"); // Crece verticalmente, igual que "growy 100"
		panel9.add(btn3, "grow"); // Crece ambos, igual que "grow 100 100"
		panel9.add(btn4, "shrink 0"); // No se encogera

		add(panel9);

		// -----------------------------------------------------------------------

		// Panel principal
		panelPrincipal = new JPanel();
		/* Crea un panel con una insercion de 10px (borde invisible) al rededor y con una restriccion de 200px para todas las
		 * columnas.
		 * 
		 * Nota: Para especificar la restriccion de una columna x, hay que agregarla de la siguiente manera: new MigLayout("",
		 * "[200][200][50]"), esto agrega una restriccion de 50px para la tercera columna sin alterar las restricciones de las
		 * otras columnas. Si hacemos [200][][50], la segunda columna toma el maximo valor del componente mas grande. */
		panelPrincipal.setLayout(new MigLayout("insets 10"));

		// Panel del PJ
		panelPJ = new JPanel();

		panelPJ.setLayout(new MigLayout());
		panelPJ.setBorder(new TitledBorder(null, "PJ", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblPJ = new JLabel("Nivel:");
		cbNivel = new JComboBox<String>(new String[] { "Nivel 1" });
		lblExpPJ = new JLabel("Experiencia:");
		txtExpPJ = new JTextField();

		/* Agrego el componente en la celda 0 (columna) y 0 (fila) dentro del panel.
		 * 
		 * Alinea (align) el componente (JLabel) horizontalmente (alignX) en el centro (center) y verticalmente (alignY) en el
		 * centro (center) de la celda.
		 * 
		 * Fusiona el componente cbNivel con la celda 0:0.
		 * 
		 * Si no se especifica una fila y columna para la celda entonces por defecto las agrega en la primera fila. */
		panelPJ.add(lblPJ);
		panelPJ.add(cbNivel, "wrap"); // Tambien se puede fusionar pasandole "split 2" al primer componente para que se fusione con esta celda
		panelPJ.add(lblExpPJ);
		panelPJ.add(txtExpPJ, "grow"); // Componente que crece (grow = llenar) dependiendo del espacio disponible (150px en este caso)

		panelPJ.add(new JButton("btn 1"), "sg 1");
		panelPJ.add(new JButton("btn 2"), "sg 1");
		panelPJ.add(new JButton("btn 3"), "sg 1");

		panelPrincipal.add(panelPJ, "cell 0 0, grow"); // Le digo que cresca para llenar el espacio restante

		// Panel del NPC
		panelNPC = new JPanel();
		panelNPC.setLayout(new MigLayout("", "[50][grow]"));
		panelNPC.setBorder(new TitledBorder(null, "NPC", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblNPC = new JLabel("NPC:");
		cbNPC = new JComboBox<String>(new String[] { "Morgolock!!!!" });
		lblExpNPC = new JLabel("Experiencia:");
		txtExpNPC = new JTextField();
		lblVidaNPC = new JLabel("Vida:");
		txtVidaNPC = new JTextField();

		panelNPC.add(lblNPC, "cell 0 0, alignx left, aligny center");
		panelNPC.add(cbNPC, "cell 1 0, alignx left, aligny top");
		panelNPC.add(lblExpNPC, "cell 0 1");
		panelNPC.add(txtExpNPC, "cell 1 1, grow");
		panelNPC.add(lblVidaNPC, "cell 0 2");
		panelNPC.add(txtVidaNPC, "cell 1 2, grow");

		panelPrincipal.add(panelNPC, "cell 1 0,grow");

		add(panelPrincipal);

		/* Comprime la ventana al tama�o de los componentes, dandole un tama�o a la ventana por asi decirlo sin tener que
		 * especificar setSize() y setBounds(). */
		pack();

		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new _borrador().setVisible(true);
	}

}
