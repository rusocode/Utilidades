package _LABORATORIO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class VentanaCentrada extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		new VentanaCentrada().setVisible(true);

	}

	public VentanaCentrada() {
		setSize(500, 500);
		centrarVentana();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	private void initialize() {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
	}

	private void centrarVentana() {

		/* Como la clase Toolkit (framework) es abstracta y no se pude instanciar, entonces le asigno un objeto Toolkit a traves
		 * del metodo getDefaultToolkit. */
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Obtiene el tamaño de la pantalla
		Dimension screenSize = toolkit.getScreenSize();
		// Obtiene el tamaño de la ventana
		Dimension frameSize = this.getSize();

		int x = screenSize.width;
		int y = screenSize.height;

		// Forma "casera" de centrar la ventana
		/* Para calcular la posicion de la ventana en el centro de la pantalla primero se tiene que restar el tamaño de la
		 * pantalla con el tamaño de la ventana para luego tener el "tamaño total de la pantalla" y despues dividir ese total
		 * por 2. Sino se restan estas dimensiones, entonces ambos bordes de la ventana con respecto a los bordes de la pantalla
		 * no van a estar parejos (la ventana no va a estar centrada). */
		setLocation((x - frameSize.width) / 2, (y - frameSize.height) / 2);
		// setLocation(x / 4, y / 4); // No centra la ventana, ya que no resta los tamaños de la vetana con la pantalla

		// Otras formas mas simples de centrar la ventana
		// setBounds(x / 4, y / 4, x / 2, y / 2); // Mueve y cambia el tamaño de la ventana
		// setLocationRelativeTo(null); // Logicamente, este metodo siempre se coloca luego de darle un tamaño a la ventana

		System.out.println("Ancho de pantalla = " + x + " | Alto de pantalla = " + y);
		System.out.println("Ancho de ventana = " + frameSize.width + " | Alto de ventana = " + frameSize.height);
		System.out.println(
				"Ancho de ventana centrada = " + ((x - frameSize.width) / 2) + " | Alto de ventana centrada = " + ((y - frameSize.height) / 2));

	}

}
