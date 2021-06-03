package eventos.ventana;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class _1 {

	public static void main(String[] args) {

		new Marco("Ventana 1", JFrame.EXIT_ON_CLOSE).setVisible(true);
		new Marco("Ventana 2", JFrame.DISPOSE_ON_CLOSE).setVisible(true); // Cierra esa ventana y no el programa.

	}

}

class Marco extends JFrame {

	public Marco(String nombre, int opcion) {

		Oyente oyente = new Oyente();
		// Agrega el Oyente de tipo WindowListener a la ventana.
		addWindowListener(oyente);

		setTitle(nombre);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(opcion);
		//setVisible(true);

	}

}

class Oyente implements WindowListener {

	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana activada."); // Primer plano.
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("Ventana cerrada.");
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("Cerrando ventana...");
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana desactivada."); // Segundo plano.
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana restaurada."); // Maximiza.
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada.");
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana abierta.");
	}

}
