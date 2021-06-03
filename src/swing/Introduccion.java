package swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Introduccion {

	public static void main(String[] args) {

		// Otra forma de crear una ventana sin tener que extender de JFrame.
		// JFrame ventana = new JFrame();
		// new Prueba(ventana);

		// Prueba frame = new Prueba();
		// frame.setVisible(true);
		new Marco0().setVisible(true);

	}

}

class Marco0 extends JFrame {

	private JPanel contenedor; // panel

	public Marco0(/* JFrame venrana */) {

		// ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE /* 3 */);
		// ventana.setBounds(100, 100, 450, 300);
		// contenedor = new JPanel();
		// contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contenedor.setLayout(new BorderLayout(0, 0));
		// ventana.setContentPane(contenedor);
		// ventana.setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE /* 3 o EXIT_ON_CLOSE */);
		setBounds(100, 100, 450, 300);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
	}

}
