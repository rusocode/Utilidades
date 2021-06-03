package _LABORATORIO;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ValidacionCampos extends JFrame /* implements KeyListener */ {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ValidacionCampos vc = new ValidacionCampos();
		vc.setVisible(true);

	}

	private static final long serialVersionUID = 1L;

	private JLabel lblNumeros;
	private JLabel lblLetras;
	private JTextField txtNumeros;
	private JTextField txtLetras;

	public ValidacionCampos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(262, 105);
		setResizable(false);
		initialize();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		lblNumeros = new JLabel("Campo de numeros:");
		lblNumeros.setBounds(10, 11, 103, 14);

		lblLetras = new JLabel("Campo de letras:");
		lblLetras.setBounds(10, 36, 103, 14);

		txtNumeros = new JTextField();
		txtNumeros.setBounds(123, 8, 113, 20);
		// agregamos una escucha al componente txtNumeros y le pasamos como argumento al metodo addKeyListener un KeyAdapter(),
		// asi con esto no tendremos que implementar la clase KeyListener() con todos sus metodos al principio de la clase
		txtNumeros.addKeyListener(new KeyAdapter() {
			// una vez creada la clase KeyAdapter() tendremos la opcion de redefinir cualquier metodo sin la necesidad de
			// implementar a todos los otros
			public void keyTyped(KeyEvent evt) { /* El metodo keyTyped recibe un objeto de tipo KeyEvent que es el que nos suministra codigo de la
													 * tecla que se ha pulsado que se extrae mediante su funci�n miembro getKeyCode() o del
													 * car�cter tecleado mediante getKeyChar(). */

				/* Si dicho caracter no corresponde a una tecla num�rica, el suceso se consume, conclcuye su procesamiento, y por lo
				 * tanto, no se muestra en el control de edici�n. */
				char tecla = evt.getKeyChar(); // tomo el caracter de la tecla pulsada mediante el metodo getKeyChar() y lo almaceno en la variable
												// local tecla de tipo char

				// si la tecla pulsada es menor al caracter 0 o mayor al caracter 9 entonces...
				if (tecla < '0' || tecla > '9') { // solo numeros
					evt.consume(); // el metodo consume() de la clase KeyEvent() hace que esa pulsaci�n de tecla se rechace y el JTextField no la
									// trate
					Toolkit.getDefaultToolkit().beep(); // produce el sonido de windows
				}
				// si la tecla pulsada es menor al caracter 0 o mayor al caracter 9 y distinto al caracter . entonces...
				if ((tecla < '0' || tecla > '9') && (tecla != '.')) { // solo numeros y el caracter .
					// evt.consume();
				}

				if (Character.isLetter(tecla)) { // solo numeros y signos
					// evt.consume();
				}

			}
		});

		txtLetras = new JTextField();
		txtLetras.setBounds(123, 33, 113, 20);
		// agregamos una escucha al componente txtLetras y le pasamos como argumento el objeto
		// txtLetras.addKeyListener(this);
		// agregamos una escucha al componente txtLetras y le pasamos como argumento al metodo addKeyListener un KeyListener(),
		// en donde se implementaran todos sus metodos
		txtLetras.addKeyListener(new KeyListener() {

			// se ejecuta cuando el usuario presiona una tecla
			@Override
			public void keyReleased(KeyEvent evt) {
				// cerrar ventana con escape
				if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0); // destruye el programa
				}
			}

			// se ejecuta cuando el usuario libera una tecla
			@Override
			public void keyPressed(KeyEvent evt) {
				// testTeclas(evt);
			}

			@Override
			public void keyTyped(KeyEvent evt) {
				char tecla = evt.getKeyChar(); // tomo el caracter de la tecla pulsada mediante el metodo getKeyChar() y lo almaceno en la variable
												// local tecla de tipo char

				// si la tecla pulsada es menor al caracter a o mayor al caracter z y menor al caracter A o mayor al caracter Z
				// entonces...
				if ((tecla < 'a' || tecla > 'z') && (tecla < 'A' || tecla > 'Z')) { // solo letras minusculas y mayusculas
					evt.consume();
				}

				// si la tecla pulsada es mayor e igual a la tecla 0 y menor e igual a la tecla 9 entonces...
				if (tecla >= KeyEvent.VK_0 && tecla <= KeyEvent.VK_9) { // solo letras y signos
					// evt.consume();
				}

				// si la tecla pulsada es mayor e igual al caracter 0 y menor e igual al caracter 9 entonces...
				if (tecla >= '0' && tecla <= '9') { // solo letras y signos
					// evt.consume();
				}

			}

		});

		getContentPane().add(lblNumeros);
		getContentPane().add(lblLetras);
		getContentPane().add(txtNumeros);
		getContentPane().add(txtLetras);
	}

	public void testTeclas(KeyEvent evt) {
		// estos metodos se ejecutan en keyPressed, pero no funcionan en keyTyped
		char caracter = evt.getKeyChar(); // tomo el caracter de la tecla pulsada mediante el metodo getKeyChar() y lo almaceno en la variable local
											// caracter de tipo char
		int codigo = evt.getKeyCode(); // tomo el codigo de la tecla pulsada mediante el metodo getKeyCode() y lo almaceno en la variable local codigo
										// de tipo int
		String nombre = KeyEvent.getKeyText(codigo); // tomo el nombre de la teclada pulsada mediante el codigo que se le paso al metodo getKeyText()
														// y lo guardo en la variable local nombre de tipo String

		// muestro en consola el nombre, caracter y codigo de la tecla pulsada
		System.out.println(
				"Nombre de la tecla: " + nombre + "\nCaracter: " + caracter + "\nCodigo de tecla: " + codigo + "\n------------------------------");
	}

	// CUANDO IMPLEMENTAMOS LA CLASE KeyListener() DESDE LA CLASE SE SOBREESCRIBEN TODOS LOS METODOS Y SERIA UN POCO MAS
	// COMODO DE TRABAJAR
	// @Override
	// public void keyPressed(KeyEvent evt) {
	// if(evt.getSource() == this.txtLetras ){
	// // funcion...
	// }
	// }
	//
	// @Override
	// public void keyReleased(KeyEvent evt) {
	// }
	//
	// @Override
	// public void keyTyped(KeyEvent evt) {
	// }

}
