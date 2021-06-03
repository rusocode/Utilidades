/* https://www.youtube.com/watch?v=hgHvmjyHxpU&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=71 */

package eventos.teclado;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * ¿Que sucede realmente con los eventos?
 * 
 * Pulsacion de tecla = evento (suceso)
 * Nosotros consideramos a este suceso como algo intangible, pero java lo considera como un OBJETO.
 * Java lo que hace es empaquetar al suceso en un objeto (suceso = objeto).
 * 
 * A ese paquete se le añaden una serie de caracteristicas, por ejemplo en el caso de una tecla pulsada, el suceso (objeto) seria:
 * tipo de objeto: KeyEvent
 * tipo de evento: Pressed
 * 
 * Lo que ocurre despues de empaquetar ese evento, es que viaja y se almacena en el parametro del metodo keyPressed(KeyEvent objeto)
 * del objeto Oyente (KeyListener).
 * 
 */

public class _1 {

	public static void main(String[] args) {

		new Marco().setVisible(true);

	}
}

class Marco extends JFrame {

	public Marco() {

		// Agrega el Oyente de tipo KeyListener a la ventana.
		addKeyListener(new Oyente());

		setTitle("Ventana");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit()
				.getScreenSize().height / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

	private class Oyente implements KeyListener {

		// Tecla presionada (_).
		public void keyPressed(KeyEvent e ) { /* e PASA A SER DE UN SUCESO A UN OBJETO!!!!!!!!!!!*/
			// Imprime el codigo de la tecla pulsada.
			// System.out.println(e.getKeyCode());
			System.out.println("Pulsada");

		}

		// Tecla soltada (-).
		public void keyReleased(KeyEvent e) {
			System.out.println("Soltada");

		}

		// Tecla pulsada y soltada (-), combinacion de tecla pulsada y soltada.
		public void keyTyped(KeyEvent e) {
			// System.out.println(e.getKeyChar());
			System.out.println("Se toco la tecla: " + e.getKeyChar());
		}

	}

}
