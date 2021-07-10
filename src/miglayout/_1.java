package miglayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

/**
 * ¿Que es MigLayout?
 * 
 * MigLayout es un administrador de dise�o extremadamente flexible que se puede usar de muchas maneras diferentes para
 * dise�ar componentes usando una API unica y consistente. Es el motor de dise�o mas flexible hasta la fecha, capaz de
 * hacer todo lo que todos los principales administradores de dise�o pueden hacer, con una API. Las restricciones
 * basadas en cadenas hacen que el codigo de dise�o sea portatil, corto, legible y facil de implementar para los
 * constructores XUL y GUI. Cuenta con unidades extensibles que se pueden usar para dise�ar componentes con todo, desde
 * porcentaje de pantalla hasta milimetros. Acoplamiento, posicionamiento absoluto con enlaces de componentes y potente
 * dise�o de cuadricula, son otras de las grandes caracteristicas de este administrador.
 * 
 * 
 * Introduccion
 * 
 * Hay tres formas principales de dise�ar componentes con MigLayout:
 * 
 * -Basado en cuadricula . Este es el modo predeterminado y lo que sucede si solo agrega componentes y no especifica
 * ninguna de las otras formas. Es mas flexible que GridBagLayout y JGoodies 'FormLayout.
 * 
 * -Componentes de acoplamiento . Esto agrega componentes en cualquiera de los cuatro bordes del contenedor, o en el
 * centro. Es mas flexible que BorderLayout, pero igual de facil de usar.
 * 
 * -Posicionamiento absoluto con enlaces . Los componentes pueden posicionarse con coordenadas absolutas y vincularse a
 * los limites de otros componentes, al contenedor, a los limites de los grupos de componentes o a cualquier combinacion
 * de estos utilizando expresiones Java normales.
 * 
 * MigLayout usa una cuadricula (filas y columnas) con manejo automatico de huecos para el dise�o de componentes basicos
 * predeterminado. La cuadricula es muy flexible y, por ejemplo, se puede ajustar mas que una tabla HTML. Por ejemplo,
 * cada celda se puede dividir para contener mas de un componente, y varias celdas se pueden dividir (fusionar) para que
 * funcionen como una sola celda grande. Las celdas pueden incluso dividirse y dividirse al mismo tiempo, haciendo
 * posible casi cualquier dise�o concebible, sin recurrir a "trucos".
 * 
 * Los componentes en una celda, si hay mas de uno, fluiran de manera muy similar a FlowLayout, pero con mas control
 * sobre como se hace y sin envoltura involuntaria. El flujo puede ser vertical (y) u horizontal (x) y tanto la
 * cuadricula principal como las celdas individuales pueden tener diferentes direcciones de flujo, aunque por defecto
 * son horizontales.
 * 
 * 
 * Conceptos basicos
 * 
 * Hay tres tipos de restricciones que se pueden establecer en la instancia del administrador de dise�o y los
 * componentes manejados:
 * 
 * -Restricciones de dise�o . Estas restricciones especifican como deberia funcionar la instancia del administrador de
 * dise�o en general. Por ejemplo, como todos los componentes dispuestos deben alinearse como un grupo, en caso de que
 * haya espacio disponible en el contenedor. Esta restriccion se establece directamente en la instancia del
 * administrador de dise�o, ya sea en el constructor o utilizando una propiedad get/set estandar. Por ejemplo, "align
 * center, fill".
 * 
 * -Restricciones de fila/columna . Especifica las propiedades de las filas y columnas de la cuadricula. Se pueden
 * especificar restricciones como los tama�os y las alineaciones predeterminadas. Esta restriccion se establece
 * directamente en la instancia del administrador de dise�o, ya sea en el constructor o utilizando una propiedad get/set
 * estandar. Por ejemplo, "[35px]10px[50:pref]".
 * 
 * -Restricciones de componentes . Se utilizan para especificar las propiedades y limites de componentes individuales.
 * Esto puede ser, por ejemplo, anular los tama�os verticales y/u horizontales minimos, preferidos o maximos para el
 * componente. Puede establecer la alineacion y si una celda se debe dividir y/o abarcar, y mucho mas. Esta restriccion
 * normalmente se establece como un argumento al agregar el componente al contenedor o al usar las propiedades estandar
 * get/set. Por ejemplo, "width 100px, left".
 * 
 * 
 * Para mas informacion sobre los tipos de restricciones -> http://www.miglayout.com/whitepaper.html
 */

public class _1 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel1, panel2, panel3, panel4, panel5;

	public _1() {

		super("MigLayout");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
	}

	private void initialize() {

		// Restriccion de diseño para la ventana
		// - Flujo horizontal (predeterminado)
		// - Borde de 10px
		/* - Establece cada 2 componentes, el modo de ajuste automatico para el diseño. Esto significa que la cuadricula se
		 * ajustara a una nueva columna / fila despues de un cierto numero de columnas (para flujo horizontal) o filas (para
		 * flujo vertical). */
		MigLayout layout = new MigLayout("insets 10, wrap 2");
		getContentPane().setLayout(layout);

		panel1 = new JPanel();
		// Restriccion de diseño
		// - Flujo horizontal ("flowx" predeterminado)
		panel1.setLayout(new MigLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("flowx"));

		/* Las restricciones predeterminadas, de diseño o columna/fila, se pueden anular especificando una restriccion dentro
		 * del metodo add() (restriccion de componente). */
		panel1.add(new JButton("btn1"));
		panel1.add(new JButton("btn2"), "wrap"); // Salta a la siguiente fila
		panel1.add(new JButton("btn3"), "wrap 10"); // Salta a la siguiente fila con un espacio de 10px
		panel1.add(new JButton("btn4"), "span 2, growx, wrap"); // Ocupa 2 celdas, la llena y salta de fila
		panel1.add(new JButton("btn5"));
		panel1.add(new JButton("btn6"), "gapx 20, wrap"); // Espacio de 20px entre btn6 y btn5
		panel1.add(new JButton("btn8"));
		panel1.add(new JButton("btn9"), "alignx right"); // Alinea el componente hacia la derecha solo si la celda es mas grande
		panel1.add(new JButton("btn0"));

		add(panel1);

		panel2 = new JPanel();
		// Restriccion de diseño
		// - Flujo vertical (en este caso cada wrap salta a la siguiente columna)
		panel2.setLayout(new MigLayout("flowy"));
		panel2.setBorder(BorderFactory.createTitledBorder("flowy"));

		panel2.add(new JButton("btn1"));
		panel2.add(new JButton("btn2"));
		panel2.add(new JButton("btn3"), "span, growx, wrap"); // Ocupa toda la fila, llena el componente y salta de columna
		panel2.add(new JButton("btn4"));
		panel2.add(new JButton("btn5"));

		getContentPane().add(panel2, "grow");

		panel3 = new JPanel();
		// Restriccion de diseño
		/* Reclama todo el espacio disponible en el contenedor para las columnas/filas. Al menos un componente debe tener un
		 * "grow" constante para llenar el contenedor. */
		panel3.setLayout(new MigLayout("fill"));
		panel3.setBorder(BorderFactory.createTitledBorder("grow de diseño"));
		panel3.add(new JButton("A"), "grow"); // Llena el componente sobre todo el espacio libre
		panel3.add(new JButton("B")); // Componente con espacio libre sin llenar

		getContentPane().add(panel3, "grow");

		panel4 = new JPanel();
		// Restriccion de columnas/filas
		/* Establece un valor predeterminado fill en la primera columna, para que todos los componentes de esa columna se llenen
		 * (grow) automaticamente. Esta propiedad no afecta el tamaño de la fila, sino el tamaño de los componentes en la
		 * fila. */
		panel4.setLayout(new MigLayout("", "[fill]"));
		panel4.setBorder(BorderFactory.createTitledBorder("grow de columna"));

		panel4.add(new JTextField(10), "wrap");
		panel4.add(new JTextField()); // "growx 0" se utiliza para que explicitamente el componente no se llene

		getContentPane().add(panel4);

		panel5 = new JPanel();
		// Solo ESPECIFICA! que la primera columna se va a llenar
		panel5.setLayout(new MigLayout("", "[grow]"));
		panel5.setBorder(BorderFactory.createTitledBorder("grow de componente"));

		panel5.add(new JTextField(15), "wrap");
		panel5.add(new JTextField(), "growx, wrap"); /* El grow de cada componente se especifica dentro del metodo add() y, se llena hasta el
														 * componente con mayor tamaño. */
		panel5.add(new JTextField());

		getContentPane().add(panel5, "wrap");

		// FIXME
//		panel6 = new JPanel();
//		panel6.setLayout(new MigLayout());
//		panel6.setBorder(BorderFactory.createTitledBorder("push"));
//
//		// push solo afecta huecos, no componentes
//		panel6.add(new JButton("Boton 1"), "pushx, growx, wrap");
//		panel6.add(new JButton("Boton 2"));
//		panel6.add(new JButton("Boton 3"));
//
//		add(panel6);

		/* Es importante comprender que fill, grow y push trabajan en conjunto con el componente para definir el dise�o. Tenga
		 * en cuenta que el relleno (fill) o el crecimiento (grow) es la tendencia de ocupar espacio vacio en el dise�o. El area
		 * de la ventana que no esta ocupada por columnas, filas o componentes se llena con un espacio vacio.
		 * 
		 * El push y el grow toman el ancho como parametro opcional. Define qua tan entusiasta deberia crecer la columna o fila
		 * en relacion con otras columnas y filas. La restriccion "fill" distribuye el ancho uniforme.
		 * 
		 * Otra respuesta... push solo afecta huecos, no elementos, que yo sepa. Si un componente esta configurado para llenar
		 * (fill), esto significa configurar todos los subcomponentes para que crezcan (grow), mientras que el crecimiento
		 * (grow) afecta al componente directamente. */

		pack();
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new _1().setVisible(true);

	}

}